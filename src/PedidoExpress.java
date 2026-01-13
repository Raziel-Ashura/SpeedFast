public class PedidoExpress extends Pedido {

    public PedidoExpress(int idPedido, String direccionEntrega) {
        super(idPedido, direccionEntrega, "Compra Express");
    }

    //ültimo método general.
    @Override
    public void asignarRepartidor() {
        System.out.println("[Pedido Compra Express]");
        System.out.println("Asignando repartidor más cercano con disponibilidad inmediata.");
    }

    //Y acá con sobrecarga.
    public void asignarRepartidor(String nombreRepartidor) {
        System.out.println("[Pedido Compra Express]");
        System.out.println("Repartidor " + nombreRepartidor +
                " asignado por cercanía y disponibilidad inmediata.");
    }
}