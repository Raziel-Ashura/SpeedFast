package vista;

import dao.*;
import model.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.time.LocalDate;
import java.time.LocalTime;

public class VentanaEntregas extends JFrame {

    //Y finalmente lo mismo para entregas
    private JComboBox<Pedido> comboPedido;
    private JComboBox<Repartidor> comboRepartidor;
    private JTable tabla;
    private DefaultTableModel modelo;

    private EntregaDAO entregaDAO = new EntregaDAO();
    private PedidoDAO pedidoDAO = new PedidoDAO();
    private RepartidorDAO repartidorDAO = new RepartidorDAO();

    public VentanaEntregas(){

        setTitle("Gestión de Entregas");
        setSize(800,400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel panelTop = new JPanel();

        comboPedido = new JComboBox<>();
        comboRepartidor = new JComboBox<>();

        panelTop.add(new JLabel("Pedido:"));
        panelTop.add(comboPedido);
        panelTop.add(new JLabel("Repartidor:"));
        panelTop.add(comboRepartidor);

        JButton btnAsignar = new JButton("Asignar");
        panelTop.add(btnAsignar);

        add(panelTop, BorderLayout.NORTH);

        modelo = new DefaultTableModel(
                new String[]{"ID","Pedido","Repartidor","Fecha","Hora"},0);
        tabla = new JTable(modelo);
        add(new JScrollPane(tabla), BorderLayout.CENTER);

        btnAsignar.addActionListener(e -> {
            Pedido p = (Pedido) comboPedido.getSelectedItem();
            Repartidor r = (Repartidor) comboRepartidor.getSelectedItem();

            entregaDAO.create(new Entrega(
                    p,
                    r,
                    LocalDate.now(),
                    LocalTime.now()
            ));

            cargarTabla();
        });

        cargarCombos();
        cargarTabla();
        setVisible(true);
    }

    private void cargarCombos(){
        comboPedido.removeAllItems();
        for(Pedido p : pedidoDAO.readAll()){
            comboPedido.addItem(p);
        }

        comboRepartidor.removeAllItems();
        for(Repartidor r : repartidorDAO.readAll()){
            comboRepartidor.addItem(r);
        }
    }

    private void cargarTabla(){
        modelo.setRowCount(0);
        for(Entrega e : entregaDAO.readAll()){
            modelo.addRow(new Object[]{
                    e.getId(),
                    e.getPedido().getDireccion(),
                    e.getRepartidor().getNombre(),
                    e.getFecha(),
                    e.getHora()
            });
        }
    }
}