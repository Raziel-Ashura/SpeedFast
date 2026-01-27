public class PedidoEncomienda extends Pedido {

    public PedidoEncomienda(int idPedido, String direccionEntrega, double distanciaKm) {
        super(idPedido, direccionEntrega, distanciaKm);
    }

    //El método de asignar repartidor pero para encomienda.
    @Override
    public void asignarRepartidor() {
        System.out.println("[Pedido Encomienda]");
        System.out.println("Validando peso y embalaje.");
        repartidorAsignado = "María";//Lo mismo que en comida.
        System.out.println("Repartidor de carga segura asignado: " + repartidorAsignado);
    }

    //Cálculo del tiempo de entrega. Pogamos que se demora un poco menos por Km pero se demora más en encontrar estacionamiento.
    @Override
    public int calcularTiempoEntrega() {
        return (int) Math.round(20 + 1.5 * distanciaKm);
    }

    @Override
    public void verHistorial() {

    }
}