public class PedidoComida extends Pedido {

    //Constructor.
    public PedidoComida(int idPedido, String direccionEntrega) {
        super(idPedido, direccionEntrega, "Comida");
    }

    @Override
    public void asignarRepartidor() {
        System.out.println("[Pedido de Comida]");
        System.out.println("Se requiere repartidor con mochila térmica.");
    }

    //Método con sobrecarga.
    public void asignarRepartidor(String nombreRepartidor) {
        System.out.println("[Pedido de Comida]");
        System.out.println("Repartidor " + nombreRepartidor +
                " asignado (verificando mochila térmica)... OK");
    }
}