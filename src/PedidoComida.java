public class PedidoComida extends Pedido {

    public PedidoComida(int idPedido, String direccionEntrega, double distanciaKm) {
        super(idPedido, direccionEntrega, distanciaKm);
    }

    //Calculo de tiempo de entrega legible.
    @Override
    public int calcularTiempoEntrega() {
        return (int) (15 + (2 * distanciaKm));
    }
}