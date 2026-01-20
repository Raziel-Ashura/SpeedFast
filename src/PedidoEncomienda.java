public class PedidoEncomienda extends Pedido {

    public PedidoEncomienda(int idPedido, String direccionEntrega, double distanciaKm) {
        super(idPedido, direccionEntrega, distanciaKm);
    }

    //El tiempo de entrega de nuevo pero legible.
    @Override
    public int calcularTiempoEntrega() {
        return (int) Math.round(20 + (1.5 * distanciaKm));
    }
}