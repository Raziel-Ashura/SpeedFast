public class Main {

    public static void main(String[] args) {

        ZonaDeCarga zonaDeCarga = new ZonaDeCarga();

        //Se cargan pedidos con direcciones para el despliegue.
        zonaDeCarga.agregarPedido(new Pedido(1, "Av. Austral 123, Puerto Montt"));
        zonaDeCarga.agregarPedido(new Pedido(2, "Calle Los Lagos 456, Puerto Varas"));
        zonaDeCarga.agregarPedido(new Pedido(3, "Pasaje Sur 789, Osorno"));
        zonaDeCarga.agregarPedido(new Pedido(4, "Av. Costanera 1020, Castro"));
        zonaDeCarga.agregarPedido(new Pedido(5, "Ruta 5 Sur Km 1015, Calbuco"));

        //Se crean los repartidores.
        Thread r1 = new Thread(new Repartidor("Andrés", zonaDeCarga));
        Thread r2 = new Thread(new Repartidor("María", zonaDeCarga));
        Thread r3 = new Thread(new Repartidor("Felipe", zonaDeCarga));

        //Se inician los hilos de cada pedido.
        r1.start();
        r2.start();
        r3.start();

        //Se ejecutan los join() para que se asigne y ejecute uno después del otro. En un try en caso que haya algun problema.
        try {
            r1.join();
            r2.join();
            r3.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        //Mensaje final.
        System.out.println("\nTodos los pedidos han sido entregados correctamente.");
    }
}

//Agregué este comentario porque no le puse bien el comentario del commit, así que lo haré de nuevo.