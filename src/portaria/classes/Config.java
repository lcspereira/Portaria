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


import java.io.*;
import java.util.Properties;
/**
 *
 * @author lucas
 */
public class Config {
    private String dbAddress;
    private String dbPort;
    private String dbUser;
    private String dbPasswd;
    private String dbName;
    private String imgDir;

    public Config(String arqConfigName) throws FileNotFoundException, IOException {
        Properties p = new Properties ();
        p.load(new FileInputStream (arqConfigName));
        this.dbAddress = p.getProperty("dbAddress");
        this.dbPort    = p.getProperty("dbPort");
        this.dbUser    = p.getProperty("dbUser");
        this.dbPasswd  = p.getProperty("dbPasswd");
        this.dbName    = p.getProperty("dbName");
        this.imgDir    = p.getProperty("imgDir");
    }
    
    
    

    /**
     * @return the dbAddress
     */
    public String getDbAddress() {
        return dbAddress;
    }

    /**
     * @return the dbPort
     */
    public String getDbPort() {
        return dbPort;
    }

    /**
     * @return the dbUser
     */
    public String getDbUser() {
        return dbUser;
    }

    /**
     * @return the dbPasswd
     */
    public String getDbPasswd() {
        return dbPasswd;
    }

    /**
     * @return the imgDir
     */
    public String getImgDir() {
        return imgDir;
    }

    /**
     * @return the dbName
     */
    public String getDbName() {
        return dbName;
    }
}
