package vista;

import dao.RepartidorDAO;
import model.Repartidor;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class VentanaRepartidores extends JFrame {

    //Lo mismo para repartidores
    private JTextField txtNombre;
    private JTable tabla;
    private DefaultTableModel modelo;
    private RepartidorDAO dao = new RepartidorDAO();

    public VentanaRepartidores(){

        setTitle("Gestión de Repartidores");
        setSize(500,350);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel panelTop = new JPanel();
        panelTop.add(new JLabel("Nombre:"));
        txtNombre = new JTextField(15);
        panelTop.add(txtNombre);

        JButton btnAgregar = new JButton("Agregar");
        panelTop.add(btnAgregar);

        add(panelTop, BorderLayout.NORTH);

        modelo = new DefaultTableModel(new String[]{"ID","Nombre"},0);
        tabla = new JTable(modelo);
        add(new JScrollPane(tabla), BorderLayout.CENTER);

        JButton btnEliminar = new JButton("Eliminar");
        add(btnEliminar, BorderLayout.SOUTH);

        btnAgregar.addActionListener(e -> {
            dao.create(new Repartidor(txtNombre.getText()));
            cargarTabla();
        });

        btnEliminar.addActionListener(e -> {
            int fila = tabla.getSelectedRow();
            if(fila>=0){
                int id = (int) modelo.getValueAt(fila,0);
                dao.delete(id);
                cargarTabla();
            }
        });

        cargarTabla();
        setVisible(true);
    }

    private void cargarTabla(){
        modelo.setRowCount(0);
        for(Repartidor r : dao.readAll()){
            modelo.addRow(new Object[]{r.getId(), r.getNombre()});
        }
    }
}