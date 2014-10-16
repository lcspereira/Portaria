/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package portaria.interfaces;

import java.sql.SQLException;

/**
 *
 * @author lucas
 */
public interface DatabaseTable {
    public void insert () throws SQLException;
    public void delete () throws SQLException;
    public void update () throws SQLException;
}
