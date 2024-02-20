package db.conexion;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionDB {
    private Connection conexion;
    private String user = "root";
    private String pass = "root";
    private String db = "empleados";
    private int port = 3306;
    private String url = "jdbc:mysql://localhost:" + port + "/" + db;
    private ConexionDB() {
       
    }
    public Connection getConexion() {
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
    public String getUser() {
        return user;
    }
    public void setUser(String user) {
        this.user = user;
    }
    public String getPass() {
        return pass;
    }
    public void setPass(String pass) {
        this.pass = pass;
    }
    public String getDb() {
        return db;
    }
    public void setDb(String db) {
        this.db = db;
    }
    public int getPort() {
        return port;
    }
    public void setPort(int port) {
        this.port = port;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
}
