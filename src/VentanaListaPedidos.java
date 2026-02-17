import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class VentanaListaPedidos extends JFrame {

    private DefaultTableModel modelo;

    public VentanaListaPedidos(ControladorPedidos controlador) {

        setTitle("Lista de Pedidos");
        setSize(600, 300);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("Dirección");
        modelo.addColumn("Estado");
        modelo.addColumn("Repartidor");

        JTable tabla = new JTable(modelo);
        JScrollPane scroll = new JScrollPane(tabla);

        add(scroll, BorderLayout.CENTER);

        cargarDatos(controlador);

        setVisible(true);
    }

    private void cargarDatos(ControladorPedidos controlador) {

        modelo.setRowCount(0);

        for (Pedido p : controlador.getListaPedidos()) {
            modelo.addRow(new Object[]{
                    p.getId(),
                    p.getDireccionEntrega(),
                    p.getEstado(),
                    p.getRepartidorAsignado()
            });
        }
    }
}