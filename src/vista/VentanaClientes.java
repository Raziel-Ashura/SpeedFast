package vista;

import dao.ClienteDAO;
import model.Cliente;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class VentanaClientes extends JFrame {

    private JTextField txtNombre, txtTelefono;
    private JTable tabla;
    private DefaultTableModel modelo;
    private ClienteDAO dao = new ClienteDAO();

    public VentanaClientes() {

        setTitle("Gestión de Clientes");
        setSize(600,400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel panelTop = new JPanel(new GridLayout(2,2));
        panelTop.add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        panelTop.add(txtNombre);
        panelTop.add(new JLabel("Teléfono:"));
        txtTelefono = new JTextField();
        panelTop.add(txtTelefono);

        add(panelTop, BorderLayout.NORTH);

        modelo = new DefaultTableModel(new String[]{"ID","Nombre","Teléfono"},0);
        tabla = new JTable(modelo);
        add(new JScrollPane(tabla), BorderLayout.CENTER);

        JPanel panelBot = new JPanel();
        JButton btnAgregar = new JButton("Agregar");
        JButton btnEliminar = new JButton("Eliminar");
        panelBot.add(btnAgregar);
        panelBot.add(btnEliminar);
        add(panelBot, BorderLayout.SOUTH);

        btnAgregar.addActionListener(e -> {
            dao.create(new Cliente(
                    txtNombre.getText(),
                    txtTelefono.getText()
            ));
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
        for(Cliente c : dao.readAll()){
            modelo.addRow(new Object[]{
                    c.getId(),
                    c.getNombre(),
                    c.getTelefono()
            });
        }
    }
}