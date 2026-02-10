public class Pedido {

    //Atributos del pedido, dados en el ejercicio.
    private int id;
    private String direccionEntrega;
    private EstadoPedido estado;

    //Constructor.
    public Pedido(int id, String direccionEntrega) {
        this.id = id;
        this.direccionEntrega = direccionEntrega;
        this.estado = EstadoPedido.PENDIENTE;
    }

    //Getters y setters.
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDireccionEntrega(String direccionEntrega) {
        this.direccionEntrega = direccionEntrega;
    }

    public String getDireccionEntrega() {
        return direccionEntrega;
    }

    //Getter del estado del pedido.
    public EstadoPedido getEstado() {
        return estado;
    }

    //Actualizaciójn del estado. O "setter".
    public synchronized void setEstado(EstadoPedido nuevoEstado) {
        this.estado = nuevoEstado;
    }

    //Mensaje de salida legible.
    @Override
    public String toString() {
        return "Pedido N°" + id +
                " | Dirección: " + direccionEntrega +
                " | Estado: " + estado;
    }
}