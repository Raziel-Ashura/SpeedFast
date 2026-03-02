package model;

public class Pedido {

    //Objeto pedido, con gettes, setters, constructores, etc etc
    private int id;
    private String direccion;
    private String tipo;
    private String estado;

    public Pedido() {}

    public Pedido(String direccion, String tipo, String estado) {
        this.direccion = direccion;
        this.tipo = tipo;
        this.estado = estado;
    }

    public Pedido(int id, String direccion, String tipo, String estado) {
        this.id = id;
        this.direccion = direccion;
        this.tipo = tipo;
        this.estado = estado;
    }

    public int getId() { return id; }
    public String getDireccion() { return direccion; }
    public String getTipo() { return tipo; }
    public String getEstado() { return estado; }

    public void setId(int id) { this.id = id; }
    public void setDireccion(String direccion) { this.direccion = direccion; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public void setEstado(String estado) { this.estado = estado; }

    @Override
    public String toString() {
        return id + " - " + direccion;
    }
}