public class Main {

    public static void main(String[] args) {

        Pedido pedido1 = new PedidoComida(1, "Av. Los Robles 123");
        Pedido pedido2 = new PedidoEncomienda(2, "Calle Central 456", 8.5);
        Pedido pedido3 = new PedidoExpress(3, "Pasaje Norte 789");

        //Polimorfismo sobreescribiendo el método.
        pedido1.asignarRepartidor();
        System.out.println();

        pedido2.asignarRepartidor();
        System.out.println();

        pedido3.asignarRepartidor();
        System.out.println();

        //Acá sobrecarga.
        pedido1.asignarRepartidor("Carlos");
        System.out.println();

        pedido2.asignarRepartidor("María");
        System.out.println();

        pedido3.asignarRepartidor("Javier");
    }
}