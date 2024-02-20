package db.conexion;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionDB {
    private static Connection conexion;
    private static String user = "root";
    private static String pass = "1212";
    private static String db = "empleados";
    private static int port = 3306;
    private static String url = "jdbc:mysql://localhost:" + port + "/" + db;
    private ConexionDB() {
       
    }
    public static Connection getConexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(url, user, pass);
            return conexion;
        } catch (Exception ex) {
            System.out.println("Error al conectar la base de datos");
        }
        return null;
    }
    public void setConexion(Connection conexion) {
        try {
            if (conexion == null || conexion.isClosed()) return;
            conexion.close();
        } catch (Exception e) {
            System.out.println("Error al cerrar la conexión");
        }
    }
   
}
