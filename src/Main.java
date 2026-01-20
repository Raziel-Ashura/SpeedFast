public class Main {

    public static void main(String[] args) {

        //Datos pre cargados para desplegar en pantalla.
        Pedido pedidoComida = new PedidoComida(1, "Av. Los Robles 123", 4.5);
        Pedido pedidoEncomienda = new PedidoEncomienda(2, "Calle Central 456", 8);
        Pedido pedidoExpress = new PedidoExpress(3, "Pasaje Norte 789", 6);

        Pedido[] pedidos = { pedidoComida, pedidoEncomienda, pedidoExpress };

        for (Pedido p : pedidos) {
            p.mostrarResumen();
            System.out.println("Tiempo estimado de entrega: "
                    + p.calcularTiempoEntrega() + " minutos");
            System.out.println("----------------------------------");
        }
    }
}