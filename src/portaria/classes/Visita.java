/*
 * Copyright (C) 2014 lucas
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
/**
 *
 * @author lucas
 */

package portaria.classes;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
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

    public static List<Visita> getVisitasByVisitante (int idVisitante) throws SQLException {
        Statement stmt = Consulta.conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs         = null;
        List<Visita> visitas = new ArrayList();
        
        stmt.executeQuery("SELECT * FROM visita WHERE id_visitante = " + idVisitante);
        rs = stmt.getResultSet();
        rs.first ();
        do {
            visitas.add(new Visita (rs.getInt("id"), rs.getInt("id_visitante"), new Date(rs.getTimestamp("data_hora").getTime()), rs.getString("obs")));
        } while (rs.next());
        return visitas;
    }
    
    public static List<Visita> getVisitasByData (Date dataVisitaLower, Date dataVisitaUpper) throws SQLException {
        Statement stmt = Consulta.conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs         = null;
        List<Visita> visitas = new ArrayList();
        
        stmt.executeQuery("SELECT * FROM visita WHERE data_hora BETWEEN " + dataVisitaLower.getTime() + " AND " + dataVisitaUpper.getTime());
        rs = stmt.getResultSet();
        while (rs.next()) {
            visitas.add(new Visita (rs.getInt("id"), rs.getInt("id_visitante"), new Date(rs.getTimestamp("data_hora").getTime()), rs.getString("obs")));
        }
        return visitas;
    }
   
    public void insert () throws SQLException{
        Statement stmt = null;
        String sql     = null;
        
        stmt = Consulta.conn.createStatement();
        sql  = "INSERT INTO visita (";
        sql += "id_visitante, ";
        sql += "data_hora, ";
        sql += "obs";
        sql += ") VALUES (";
        sql += this.idVisitante + ", '";
        sql += this.dataHora + "', '";
        sql += this.obs;
        sql += "')";
        stmt.execute(sql);
        stmt.close();
    }
}
