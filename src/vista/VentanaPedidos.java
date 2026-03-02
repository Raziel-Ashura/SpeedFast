package vista;

import dao.PedidoDAO;
import model.Pedido;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class VentanaPedidos extends JFrame {

    private JTextField txtDireccion;
    private JComboBox<String> comboTipo, comboEstado;
    private JTable tabla;
    private DefaultTableModel modelo;
    private PedidoDAO dao = new PedidoDAO();

    public VentanaPedidos(){

        setTitle("Gestión de Pedidos");
        setSize(700,400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel panelTop = new JPanel(new GridLayout(3,2));

        panelTop.add(new JLabel("Dirección:"));
        txtDireccion = new JTextField();
        panelTop.add(txtDireccion);

        panelTop.add(new JLabel("Tipo:"));
        comboTipo = new JComboBox<>(new String[]{"COMIDA","ENCOMIENDA","EXPRESS"});
        panelTop.add(comboTipo);

        panelTop.add(new JLabel("Estado:"));
        comboEstado = new JComboBox<>(new String[]{"PENDIENTE","EN_REPARTO","ENTREGADO"});
        panelTop.add(comboEstado);

        add(panelTop, BorderLayout.NORTH);

        modelo = new DefaultTableModel(new String[]{"ID","Dirección","Tipo","Estado"},0);
        tabla = new JTable(modelo);
        add(new JScrollPane(tabla), BorderLayout.CENTER);

        JPanel panelBot = new JPanel();
        JButton btnAgregar = new JButton("Agregar");
        JButton btnEliminar = new JButton("Eliminar");
        panelBot.add(btnAgregar);
        panelBot.add(btnEliminar);
        add(panelBot, BorderLayout.SOUTH);

        btnAgregar.addActionListener(e -> {
            dao.create(new Pedido(
                    txtDireccion.getText(),
                    comboTipo.getSelectedItem().toString(),
                    comboEstado.getSelectedItem().toString()
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
        for(Pedido p : dao.readAll()){
            modelo.addRow(new Object[]{
                    p.getId(),
                    p.getDireccion(),
                    p.getTipo(),
                    p.getEstado()
            });
        }
    }
}