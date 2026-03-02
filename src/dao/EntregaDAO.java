package dao;

import model.*;
import java.sql.Date;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

public class EntregaDAO {

    public void create(Entrega e) {
        String sql = "INSERT INTO entregas(id_pedido,id_repartidor,fecha,hora) VALUES (?,?,?,?)";

        try (Connection conn = ConexionDB.Conectarse();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, e.getPedido().getId());
            ps.setInt(2, e.getRepartidor().getId());
            ps.setDate(3, Date.valueOf(e.getFecha()));
            ps.setTime(4, Time.valueOf(e.getHora()));
            ps.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public List<Entrega> readAll() {

        List<Entrega> lista = new ArrayList<>();

        String sql = """
            SELECT e.id, e.fecha, e.hora,
                   p.id AS pedido_id, p.direccion, p.tipo, p.estado,
                   r.id AS rep_id, r.nombre
            FROM entregas e
            JOIN pedidos p ON e.id_pedido = p.id
            JOIN repartidores r ON e.id_repartidor = r.id
        """;

        try (Connection conn = ConexionDB.Conectarse();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Pedido p = new Pedido(
                        rs.getInt("pedido_id"),
                        rs.getString("direccion"),
                        rs.getString("tipo"),
                        rs.getString("estado")
                );

                Repartidor r = new Repartidor(
                        rs.getInt("rep_id"),
                        rs.getString("nombre")
                );

                Entrega e = new Entrega(
                        rs.getInt("id"),
                        p,
                        r,
                        rs.getDate("fecha").toLocalDate(),
                        rs.getTime("hora").toLocalTime()
                );

                lista.add(e);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return lista;
    }

    public void delete(int id) {
        String sql = "DELETE FROM entregas WHERE id=?";

        try (Connection conn = ConexionDB.Conectarse();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}