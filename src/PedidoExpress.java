public class PedidoExpress extends Pedido {

    public PedidoExpress(int idPedido, String direccionEntrega, double distanciaKm) {
        super(idPedido, direccionEntrega, distanciaKm);
    }

    //El método de asignar repartidor pero para pedido express.
    @Override
    public void asignarRepartidor() {
        System.out.println("[Pedido Express]");
        System.out.println("Asignando repartidor más cercano disponible.");
        repartidorAsignado = "Luis";//Lo mismo.
    }

    //Cálculo del tiempo de entrega. Este va volando. Pero se demora un poco más si está lejos.
    @Override
    public int calcularTiempoEntrega() {
        int tiempo = 10;
        if (distanciaKm > 5) {
            tiempo += 5;
        }
        return tiempo;
    }

    @Override
    public void verHistorial() {

    }
}