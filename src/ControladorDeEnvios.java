import java.util.ArrayList;
import java.util.List;

public class ControladorDeEnvios implements Rastreable {

    private List<Pedido> historial;

    public ControladorDeEnvios() {
        historial = new ArrayList<>();
    }

    public void registrarPedido(Pedido pedido) {
        historial.add(pedido);
    }

    @Override
    public void verHistorial() {
        System.out.println("\nHistorial de pedidos entregados\n");

        for (Pedido p : historial) {
            if (!p.isCancelado()) {
                p.mostrarResumen();
                System.out.println("\n");
            }
        }
    }
}