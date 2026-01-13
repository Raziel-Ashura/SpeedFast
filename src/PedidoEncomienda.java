public class PedidoEncomienda extends Pedido {

    private double peso;

    //Constructor.
    public PedidoEncomienda(int idPedido, String direccionEntrega, double peso) {
        super(idPedido, direccionEntrega, "Encomienda");
        this.peso = peso;
    }

    //Método general.
    @Override
    public void asignarRepartidor() {
        System.out.println("[Pedido de Encomienda]");
        System.out.println("Validando peso y embalaje. Peso: " + peso + " kg... OK");
    }

    //Método con sobrecarga.
    public void asignarRepartidor(String nombreRepartidor) {
        System.out.println("[Pedido de Encomienda]");
        System.out.println("Repartidor " + nombreRepartidor +
                " asignado tras validar peso (" + peso + " kg) y embalaje.");
    }
}