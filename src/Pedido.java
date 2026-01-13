public class Pedido {

    //Variables de ejemplo del ejercicio.
    protected int idPedido;
    protected String direccionEntrega;
    protected String tipoPedido;

    public Pedido(int idPedido, String direccionEntrega, String tipoPedido) {
        this.idPedido = idPedido;
        this.direccionEntrega = direccionEntrega;
        this.tipoPedido = tipoPedido;
    }

    //Método general.
    public void asignarRepartidor() {
        System.out.println("Asignando repartidor al pedido " + idPedido);
    }

    //Método con sobrecarga.
    public void asignarRepartidor(String nombreRepartidor) {
        System.out.println("Repartidor " + nombreRepartidor +
                " asignado al pedido " + idPedido);
    }
}