/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package portaria.classes;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import portaria.frames.Consulta;

/**
 *
 * @author lucas
 */
public class Visita {
    private int id;
    private int idVisitante;
    private Date dataHora;
    private String obs;

    public Visita(int idVisitante, Date dataHora, String obs) {
        this.idVisitante = idVisitante;
        this.dataHora    = dataHora;
        this.obs         = obs;
    }

    public Visita(int id, int idVisitante, Date dataHora, String obs) {
        this.id          = id;
        this.idVisitante = idVisitante;
        this.dataHora    = dataHora;
        this.obs         = obs;
    }
    
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the idVisitante
     */
    public int getIdVisitante() {
        return idVisitante;
    }

    /**
     * @param idVisitante the idVisitante to set
     */
    public void setIdVisitante(int idVisitante) {
        this.idVisitante = idVisitante;
    }
    
    /**
     * @return the dataHora
     */
    public Date getDataHora() {
        return dataHora;
    }

    /**
     * @param dataHora the dataHora to set
     */
    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    /**
     * @return the obs
     */
    public String getObs() {
        return obs;
    }

    /**
     * @param obs the obs to set
     */
    public void setObs(String obs) {
        this.obs = obs;
    }

    public List<Visita> getVisitasByVisitante (int idVisitante) throws SQLException {
        Statement stmt       = Consulta.conn.createStatement();
        ResultSet rs         = null;
        List<Visita> visitas = new ArrayList<Visita>();
        
        stmt.executeQuery("SELECT * FROM visita WHERE id_visitante = " + idVisitante);
        rs = stmt.getResultSet();
        while (rs.next()) {
            visitas.add(new Visita (rs.getInt("id"), rs.getInt("id_visitante"), new Date(rs.getInt("data_hora") * 1000L), rs.getString("obs")));
        }
        return visitas;
    }
    
    public List<Visita> getVisitasByData (Date dataVisitaLower, Date dataVisitaUpper) throws SQLException {
        Statement stmt       = Consulta.conn.createStatement();
        ResultSet rs         = null;
        List<Visita> visitas = new ArrayList<Visita>();
        
        stmt.executeQuery("SELECT * FROM visita WHERE data_hora BETWEEN " + dataVisitaLower.getTime() + " AND " + dataVisitaUpper.getTime());
        rs = stmt.getResultSet();
        while (rs.next()) {
            visitas.add(new Visita (rs.getInt("id"), rs.getInt("id_visitante"), new Date(rs.getInt("data_hora") * 1000L), rs.getString("obs")));
        }
        return visitas;
    }
}
