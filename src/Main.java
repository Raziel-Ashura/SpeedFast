public class Main {

    public static void main(String[] args) {

        //Se llama al controlador.
        ControladorDeEnvios controlador = new ControladorDeEnvios();

        //Se crean los pedidos como dato base.
        Pedido pedido1 = new PedidoComida(1, "Av. Austral 123", 4);
        Pedido pedido2 = new PedidoEncomienda(2, "Calle Los Lagos 456", 7);
        Pedido pedido3 = new PedidoExpress(3, "Pasaje Sur 789", 9);

        //Se registran los pedidos en el controlador.
        controlador.registrarPedido(pedido1);
        controlador.registrarPedido(pedido2);
        controlador.registrarPedido(pedido3);

        //Acá se asignaría automáticamente.
        pedido1.asignarRepartidor();
        System.out.println("\n");
        pedido2.asignarRepartidor();
        System.out.println("\n");
        pedido3.asignarRepartidor();

        //Acá manual.
        pedido1.asignarRepartidor("Carlos");
        pedido2.asignarRepartidor("María");
        pedido3.asignarRepartidor("Felipe");

        //Mostrar resumen y tiempo estimado.
        System.out.println("\n\n[Estimado de Tiempos]\n");
        pedido1.mostrarResumen();
        System.out.println("Tiempo entrega: " + pedido1.calcularTiempoEntrega() + " min\n");

        pedido2.mostrarResumen();
        System.out.println("Tiempo entrega: " + pedido2.calcularTiempoEntrega() + " min\n");

        pedido3.mostrarResumen();
        System.out.println("Tiempo entrega: " + pedido3.calcularTiempoEntrega() + " min\n");

        //Despacho.
        pedido1.despachar();
        pedido2.despachar();
        pedido3.despachar();
        System.out.println("\n");

        //Cancelamos uno. Ya había salido el repartidos ='(.
        pedido2.cancelar();

        //Y acá mostramos el historial.
        controlador.verHistorial();
    }
}