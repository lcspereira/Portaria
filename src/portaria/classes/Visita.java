/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package portaria.classes;

/**
 *
 * @author lucas
 */
public class Visita {
    private int id;
    private int idVisitante;
    private String obs;

    public Visita(int idVisitante, String obs) {
        this.idVisitante = idVisitante;
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
}
