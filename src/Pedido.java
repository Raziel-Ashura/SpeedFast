import java.util.List;

//Acá implementamos las 3 interfaces.
public abstract class Pedido
        implements Despachable, Cancelable, Rastreable {

//Las variables.
    protected int idPedido;
    protected String direccionEntrega;
    protected double distanciaKm;
    protected String repartidorAsignado;
    protected boolean cancelado;

//Constructor.
    public Pedido(int idPedido, String direccionEntrega, double distanciaKm) {
        this.idPedido = idPedido;
        this.direccionEntrega = direccionEntrega;
        this.distanciaKm = distanciaKm;
        this.repartidorAsignado = "Sin asignar";
        this.cancelado = false;
    }

    //Método para verificar cancelación.
    public boolean isCancelado() {
        return cancelado;
    }

    //Método de abstracción.
    public void mostrarResumen() {
        System.out.println("ID Pedido: " + idPedido);
        System.out.println("Dirección: " + direccionEntrega);
        System.out.println("Distancia: " + distanciaKm + " km");
        System.out.println("Repartidor: " + repartidorAsignado);
    }

    //Método para calcular el tiempo de entrega.
    public abstract int calcularTiempoEntrega();

    //Método para asignar al repartidor.
    public abstract void asignarRepartidor();



    //Una sobrecarga para una asignación manual de repartidor.
    public void asignarRepartidor(String nombre) {
        this.repartidorAsignado = nombre;
    }

    //Mensaje de confirmación.
    @Override
    public void despachar() {
        System.out.println("Pedido " + idPedido + " despachado.");
    }

    //Mensaje de cancelado.
    @Override
    public void cancelar() {
        cancelado = true;
        System.out.println("Pedido " + idPedido + " cancelado");
    }
}