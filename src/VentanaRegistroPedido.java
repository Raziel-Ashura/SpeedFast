import javax.swing.*;
import java.awt.*;

public class VentanaRegistroPedido extends JFrame {

    public VentanaRegistroPedido(ControladorPedidos controlador) {

        setTitle("Registrar Pedido");
        setSize(350, 250);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 2, 5, 5));

        JTextField txtId = new JTextField();
        JTextField txtDireccion = new JTextField();
        JComboBox<String> comboTipo = new JComboBox<>(
                new String[]{"Comida", "Encomienda", "Express"});

        JButton btnGuardar = new JButton("Guardar");

        add(new JLabel("ID:"));
        add(txtId);

        add(new JLabel("Dirección:"));
        add(txtDireccion);

        add(new JLabel("Tipo:"));
        add(comboTipo);

        add(new JLabel());
        add(btnGuardar);

        btnGuardar.addActionListener(e -> {

            try {
                int id = Integer.parseInt(txtId.getText());
                String direccion = txtDireccion.getText();

                if (direccion.isEmpty()) {
                    JOptionPane.showMessageDialog(this,
                            "La dirección no puede estar vacía");
                    return;
                }

                Pedido pedido = new Pedido(id, direccion);
                pedido.setEstado(EstadoPedido.PENDIENTE);

                controlador.agregarPedido(pedido);

                JOptionPane.showMessageDialog(this,
                        "Pedido registrado correctamente");

                dispose();

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this,
                        "ID inválido");
            }
        });

        setVisible(true);
    }
}