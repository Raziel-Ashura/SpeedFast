public class Repartidor implements Runnable {

    //Variables del repartidor.
    private String nombre;
    private ZonaDeCarga zonaDeCarga;

    //Constructor.
    public Repartidor(String nombre, ZonaDeCarga zonaDeCarga) {
        this.nombre = nombre;
        this.zonaDeCarga = zonaDeCarga;
    }

    //Legibilidad para poder desplegar el estado del pedido y lo demás.
    @Override
    public void run() {
        while (zonaDeCarga.hayPedidos()) { //Se ejecuta mientras que hayan pedidos sin asignar.

            Pedido pedido = zonaDeCarga.retirarPedido();
            if (pedido == null) {
                break;
            }

            //Se toma el pedido y se le asigna en reparto. Con mensaje en consola.
            pedido.setEstado(EstadoPedido.EN_REPARTO);
            System.out.println(nombre + " retiró " + pedido);

            //La espera antes de marcarlo como entregado.
            try {
                Thread.sleep(2000); // simula entrega
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            //Se marca como entregado.
            pedido.setEstado(EstadoPedido.ENTREGADO);
            System.out.println(nombre + " entregó Pedido N°" + pedido.getId());
        }
    }
}