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

package portaria.classes;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import portaria.frames.Consulta;


/**
 *
 * @author lucas
 */
public class Visitante {
    private int id;
    private String nome;
    private String rg;
    private String cpf;
    private String telefone;
    private String email;
    private String endereco;
    private String numEndereco;
    private String complEndereco;
    private String bairro;
    private String cidade;
    private String uf;
    private String cep;
    private String obs;
    private String foto;
                    
    public Visitante(int id, String nome, String rg, String cpf, String telefone, String email, String endereco, String numEndereco, String complEndereco, String bairro, String cidade, String uf, String cep, String obs, String foto) {
        this.id            = id;
        this.nome          = nome;
        this.rg            = rg;
        this.cpf           = cpf;
        this.telefone      = telefone;
        this.email         = email;
        this.endereco      = endereco;
        this.numEndereco   = numEndereco;
        this.complEndereco = complEndereco;
        this.bairro        = bairro;
        this.cidade        = cidade;
        this.uf            = uf;
        this.cep           = cep;
        this.obs           = obs;
        this.foto          = foto;
    }
    
    public Visitante(String nome, String rg, String cpf, String telefone, String email, String endereco, String numEndereco, String complEndereco, String bairro, String cidade, String uf, String cep, String obs, String foto) {
        this.nome          = nome;
        this.rg            = rg;
        this.cpf           = cpf;
        this.telefone      = telefone;
        this.email         = email;
        this.endereco      = endereco;
        this.numEndereco   = numEndereco;
        this.complEndereco = complEndereco;
        this.bairro        = bairro;
        this.cidade        = cidade;
        this.uf            = uf;
        this.cep           = cep;
        this.obs           = obs;
        this.foto          = foto;
    }
    
    /**
     *
     * @param nome
     * @return Visitante
     */  
    public Visitante (String nome) throws SQLException{
        Statement stmt = null;
        ResultSet rs   = null;
        
        stmt = Consulta.conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        rs   = null;

        stmt.execute("SELECT * FROM visitante WHERE nome = '" + nome + "'");
        rs                 = stmt.getResultSet();
        rs.first ();
        this.id            = rs.getInt("id");
        this.nome          = rs.getString("nome");
        this.rg            = rs.getString("rg");
        this.cpf           = rs.getString("cpf");
        this.telefone      = rs.getString("telefone");
        this.email         = rs.getString("email");
        this.endereco      = rs.getString("endereco");
        this.numEndereco   = rs.getString("num_endereco");
        this.complEndereco = rs.getString("compl_endereco");
        this.bairro        = rs.getString("bairro");
        this.cidade        = rs.getString("cidade");
        this.uf            = rs.getString("uf");
        this.cep           = rs.getString("cep");
        this.foto          = rs.getString("foto");
        stmt.close();
    }
    
    
    /**
     *
     * @param id
     * @return Visitante
     */  
    public Visitante (int id) throws SQLException{
        Statement stmt = null;
        ResultSet rs   = null;
        
        stmt = Consulta.conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        rs   = null;

        stmt.execute("SELECT * FROM visitante WHERE id = " + id);
        rs                 = stmt.getResultSet();
        
        this.id            = rs.getInt("id");
        this.nome          = rs.getString("nome");
        this.rg            = rs.getString("rg");
        this.cpf           = rs.getString("cpf");
        this.telefone      = rs.getString("telefone");
        this.email         = rs.getString("email");
        this.endereco      = rs.getString("endereco");
        this.numEndereco   = rs.getString("num_endereco");
        this.complEndereco = rs.getString("compl_endereco");
        this.bairro        = rs.getString("bairro");
        this.cidade        = rs.getString("cidade");
        this.uf            = rs.getString("uf");
        this.cep           = rs.getString("cep");
        this.foto          = rs.getString("foto");
        stmt.close();
    }
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the rg
     */
    public String getRg() {
        return rg;
    }

    /**
     * @param rg the rg to set
     */
    public void setRg(String rg) {
        this.rg = rg;
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the endereco
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * @return the numEndereco
     */
    public String getNumEndereco() {
        return numEndereco;
    }

    /**
     * @param numEndereco the numEndereco to set
     */
    public void setNumEndereco(String numEndereco) {
        this.numEndereco = numEndereco;
    }

    /**
     * @return the complEndereco
     */
    public String getComplEndereco() {
        return complEndereco;
    }

    /**
     * @param complEndereco the complEndereco to set
     */
    public void setComplEndereco(String complEndereco) {
        this.complEndereco = complEndereco;
    }

    /**
     * @return the bairro
     */
    public String getBairro() {
        return bairro;
    }

    /**
     * @param bairro the bairro to set
     */
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    /**
     * @return the cidade
     */
    public String getCidade() {
        return cidade;
    }

    /**
     * @param cidade the cidade to set
     */
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    /**
     * @return the uf
     */
    public String getUf() {
        return uf;
    }

    /**
     * @param uf the uf to set
     */
    public void setUf(String uf) {
        this.uf = uf;
    }

    /**
     * @return the cep
     */
    public String getCep() {
        return cep;
    }

    /**
     * @param cep the cep to set
     */
    public void setCep(String cep) {
        this.cep = cep;
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

    /**
     * @return the foto
     */
    public String getFoto() {
        return foto;
    }

    /**
     * @param foto the foto to set
     */
    public void setFoto(String foto) {
        this.foto = foto;
    }
  
    
    /**
     *
     * @param nome
     * @return List<Visitante>
     */
    public static List<Visitante> getVisitantes (String nome, String cpf, Date dataLower, Date dataUpper) throws SQLException {
        Statement stmt             = null;
        ResultSet rs               = null;
        List<Visitante> visitantes = new ArrayList();
        Visitante visitante        = null;
        String sql                 = "SELECT * FROM visitante" ;
       
        stmt = Consulta.conn.createStatement();
        rs   = null;
        
        if (dataLower != null) {
            sql += " INNER JOIN visita ON visitante.id = visita.id_visitante";
            sql += " WHERE data_hora >= '" + dataLower.toString() + "'";
            if (dataUpper == null) {
                dataUpper = Calendar.getInstance().getTime();
                sql += " AND data_hora < '" + dataUpper.toString() + "'";
            }
            if (! nome.isEmpty()) {
                sql += " AND nome LIKE '" + nome + "'";
            }
        }
       
        if (dataLower == null && ! nome.isEmpty()){
            sql += " WHERE nome ILIKE '" + nome + "'";
        }
        
        if (! cpf.isEmpty ()) {
            sql += " AND cpf = '" + cpf + "'";
        }
        System.out.println (sql);
        
        stmt.execute(sql);
        rs = stmt.getResultSet();
        while (rs.next()) {
            visitante = new Visitante (rs.getInt ("id"), rs.getString("nome"), rs.getString("rg"), rs.getString("cpf"), rs.getString("telefone"), rs.getString("email"), rs.getString("endereco"), rs.getString("num_endereco"), rs.getString("compl_endereco"), rs.getString("bairro"), rs.getString("cidade"), rs.getString("uf"), rs.getString("cep"), rs.getString("obs"), rs.getString("foto"));
            visitantes.add(visitante);
        }
        stmt.close();
        return visitantes;
    }
    
    /**
     *
     */
    public void insert () throws SQLException, Exception{
        Statement stmt = null;
        String sql     = null;
        
        if (this.nome.isEmpty()) {
            throw new Exception("Por favor, informe o nome do visitante");
        } else if (this.rg.isEmpty() && this.cpf.isEmpty()) {
            throw new Exception ("RG ou CPF deve ser informado");
        } else if (! this.rg.isEmpty() && this.rg.length() != 10) {
            throw new Exception ("RG inválido");
        } else if (! this.cpf.isEmpty() && this.cpf.length() != 11) {
            throw new Exception ("CPF inválido");
        } else if (this.foto.isEmpty() || this.foto.equals("null.jpg")) {
            throw new Exception ("Por favor, tire a foto do visitante");
        } else {
            stmt = Consulta.conn.createStatement();
            sql  = "INSERT INTO visitante (";
            sql += "nome, ";
            sql += "rg, ";
            sql += "cpf, ";
            sql += "telefone, ";
            sql += "email, ";
            sql += "endereco, ";
            sql += "num_endereco, ";
            sql += "compl_endereco, ";
            sql += "bairro, ";
            sql += "cidade, ";
            sql += "uf, ";
            sql += "cep, ";
            sql += "foto";
            sql += ") VALUES ('";
            sql += this.nome + "', '";
            sql += this.rg + "', '";
            sql += this.cpf + "', '";
            sql += this.telefone + "', '";
            sql += this.email + "', '";
            sql += this.endereco + "', '";
            sql += this.numEndereco + "', '";
            sql += this.complEndereco + "', '";
            sql += this.bairro + "', '";
            sql += this.cidade + "', '";
            sql += this.uf + "', '";
            sql += this.cep + "', '";
            sql += this.foto;
            sql += "')";
            stmt.execute(sql);
            stmt.close();
        }
    }

    public void update() throws SQLException {
        Statement stmt           = Consulta.conn.createStatement();
        String sql               = null;
        sql  = "UPDATE visitante ";
        sql += "    SET ";
        sql += "nome = " + this.nome + ", ";
        sql += "rg = " + this.rg + ", ";
        sql += "cpf = " + this.cpf + ", ";
        sql += "telefone = " + this.telefone + ", ";
        sql += "email = " + this.email + ", ";
        sql += "endereco = " + this.endereco + ", ";
        sql += "num_endereco = " + this.numEndereco + ", ";
        sql += "comp_endereco = " + this.complEndereco + ", ";
        sql += "bairro = " + this.bairro + ", ";
        sql += "cidade = " + this.cidade + ", ";
        sql += "uf = " + this.uf + ", ";
        sql += "cep = " + this.cep + ", ";
        sql += "foto = " + this.foto;
        sql += "WHERE id = " + this.id;
        
        stmt.executeQuery(sql);
        stmt.close();
    }
}
