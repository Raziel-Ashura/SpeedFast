import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ZonaDeCarga {

    //Acá tenemos la lista de pedidos en el BlockingQueue, la fila que se hace uno por uno.
    private BlockingQueue<Pedido> pedidos;

    //Acá se crea una nueva.
    public ZonaDeCarga() {
        pedidos = new LinkedBlockingQueue<>();
    }

    //Se agrega un pedido nuevo.
    public void agregarPedido(Pedido pedido) {
        pedidos.add(pedido);
        System.out.println("Pedido agregado: " + pedido);
    }

    //Acá se verifica que se tome un pedido no asignado.
    public Pedido retirarPedido() {
        try {
            return pedidos.take();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return null;
        }
    }

    //Se verifica si quedan pedidos que asignar.
    public boolean hayPedidos() {
        return !pedidos.isEmpty();
    }
}