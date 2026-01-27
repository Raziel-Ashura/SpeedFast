public class PedidoComida extends Pedido {

    public PedidoComida(int idPedido, String direccionEntrega, double distanciaKm) {
        super(idPedido, direccionEntrega, distanciaKm);
    }

    //El método de asignar repartidor que llaman las otras clases. Pero al pedir comida.
    @Override
    public void asignarRepartidor() {
        System.out.println("[Pedido Comida]");
        repartidorAsignado = "Carlos"; //Creo un repartidor que se asigna automáticamente a este tipo de pedido.
        System.out.println("Repartidor con mochila térmica asignado: " + repartidorAsignado);
    }

    //Lo mismo pero para calcular el tiempo de entrega. 2 minutos por kilómetro más 15 minutos por si acaso.
    @Override
    public int calcularTiempoEntrega() {
        return (int) (15 + 2 * distanciaKm);
    }

    @Override
    public void verHistorial() {

    }
}