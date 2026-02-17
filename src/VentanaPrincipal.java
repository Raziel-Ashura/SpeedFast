import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal extends JFrame {

    private ControladorPedidos controlador;

    public VentanaPrincipal() {

        controlador = new ControladorPedidos();

        setTitle("SpeedFast - Sistema de Gestión");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(3, 1, 10, 10));

        JButton btnRegistrar = new JButton("Registrar Pedido");
        JButton btnListar = new JButton("Listar Pedidos");
        JButton btnAsignar = new JButton("Asignar / Iniciar Entrega");

        panelBotones.add(btnRegistrar);
        panelBotones.add(btnListar);
        panelBotones.add(btnAsignar);

        add(panelBotones, BorderLayout.CENTER);

        // Eventos
        btnRegistrar.addActionListener(e ->
                new VentanaRegistroPedido(controlador));

        btnListar.addActionListener(e ->
                new VentanaListaPedidos(controlador));

        btnAsignar.addActionListener(e ->
                new VentanaAsignarRepartidor(controlador));

        setVisible(true);
    }
}