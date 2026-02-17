import javax.swing.*;
import java.awt.*;

public class VentanaAsignarRepartidor extends JFrame {

    public VentanaAsignarRepartidor(ControladorPedidos controlador) {

        setTitle("Asignar Repartidor");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        DefaultListModel<Pedido> modeloLista = new DefaultListModel<>();

        for (Pedido p : controlador.getListaPedidos()) {
            if (p.getEstado() == EstadoPedido.PENDIENTE) {
                modeloLista.addElement(p);
            }
        }

        JList<Pedido> lista = new JList<>(modeloLista);
        JScrollPane scroll = new JScrollPane(lista);

        JPanel panelInferior = new JPanel(new GridLayout(2, 1, 5, 5));

        JTextField txtNombre = new JTextField();
        JButton btnAsignar = new JButton("Asignar e Iniciar");

        panelInferior.add(txtNombre);
        panelInferior.add(btnAsignar);

        add(scroll, BorderLayout.CENTER);
        add(panelInferior, BorderLayout.SOUTH);

        btnAsignar.addActionListener(e -> {

            Pedido seleccionado = lista.getSelectedValue();
            String nombre = txtNombre.getText();

            if (seleccionado == null) {
                JOptionPane.showMessageDialog(this,
                        "Seleccione un pedido");
                return;
            }

            if (nombre.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "Ingrese nombre del repartidor");
                return;
            }

            seleccionado.setRepartidorAsignado(nombre);
            seleccionado.setEstado(EstadoPedido.EN_REPARTO);

            JOptionPane.showMessageDialog(this,
                    "Repartidor asignado correctamente");

            dispose();
        });

        setVisible(true);
    }
}