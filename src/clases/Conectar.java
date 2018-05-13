
package clases;

import java.sql.Connection;
import java.sql.DriverManager;


/**
 *
 * @author kimberly
 */
public class Conectar {
    
    Connection conectar=null;
    public Connection conexion(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conectar=DriverManager.getConnection("jdbc:mysql://localhost/yupisoft","root","");
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
        return conectar;
    }
               
}
