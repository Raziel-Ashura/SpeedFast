package main;

import vista.VentanaPrincipal;


//Llamo la ventana principal para desplegar al sistema
public class Main {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() ->
                new VentanaPrincipal());
    }
}