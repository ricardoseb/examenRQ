package sql;

import java.sql.Connection;
import java.sql.DriverManager;
//import modelo.Chocolate;
//import controlador.RegistroChoco;
//import vista.AppChoco;

public class Conexion {
    
        public static Connection getConexion(boolean nube) {
            String driverUrl;
            if (nube == false)
                driverUrl="jdbc:oracle:thin:@localhost:1521:XE";
            else
                driverUrl="jdbc:oracle:thin:@PVD-AM-01-08.aws.smartcloud.cl:1521:XE";
        Connection connection = null;
        try {
           String driverClassName = "oracle.jdbc.driver.OracleDriver";
           Class.forName(driverClassName);
           connection = DriverManager.getConnection(driverUrl, "usuario01","usuario01");
        }catch (Exception e) {
            e.printStackTrace();
        }
        
        return connection;
    }
    
}
