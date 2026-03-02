package model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Entrega {

    private int id;
    private Pedido pedido;
    private Repartidor repartidor;
    private LocalDate fecha;
    private LocalTime hora;

    public Entrega() {}

    public Entrega(Pedido pedido, Repartidor repartidor,
                   LocalDate fecha, LocalTime hora) {
        this.pedido = pedido;
        this.repartidor = repartidor;
        this.fecha = fecha;
        this.hora = hora;
    }

    public Entrega(int id, Pedido pedido, Repartidor repartidor,
                   LocalDate fecha, LocalTime hora) {
        this.id = id;
        this.pedido = pedido;
        this.repartidor = repartidor;
        this.fecha = fecha;
        this.hora = hora;
    }

    public int getId() { return id; }
    public Pedido getPedido() { return pedido; }
    public Repartidor getRepartidor() { return repartidor; }
    public LocalDate getFecha() { return fecha; }
    public LocalTime getHora() { return hora; }

    public void setId(int id) { this.id = id; }
    public void setPedido(Pedido pedido) { this.pedido = pedido; }
    public void setRepartidor(Repartidor repartidor) { this.repartidor = repartidor; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }
    public void setHora(LocalTime hora) { this.hora = hora; }

    @Override
    public String toString() {
        return "Entrega " + id + " - Pedido: " + pedido.getId()
                + " - Repartidor: " + repartidor.getNombre();
    }
}