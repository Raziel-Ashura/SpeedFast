package vista;

import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal extends JFrame {

    public VentanaPrincipal() {

        setTitle("SpeedFast - Sistema de Gestión");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4,1,10,10));

        JButton btnClientes = new JButton("Clientes");
        JButton btnRepartidores = new JButton("Repartidores");
        JButton btnPedidos = new JButton("Pedidos");
        JButton btnEntregas = new JButton("Entregas");

        add(btnClientes);
        add(btnRepartidores);
        add(btnPedidos);
        add(btnEntregas);

        btnClientes.addActionListener(e -> new VentanaClientes());
        btnRepartidores.addActionListener(e -> new VentanaRepartidores());
        btnPedidos.addActionListener(e -> new VentanaPedidos());
        btnEntregas.addActionListener(e -> new VentanaEntregas());

        setVisible(true);
    }
}