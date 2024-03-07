

import java.sql.ResultSet;
import java.util.List;

import db.repository.EmpleadoRepository;
import db.repository.GeneroRepository;
import models.Empleado;
import models.Genero;
import screen.LoginVentana;
import screen.RegistroVentana;
import screen.VentanaEmpleados;

public class App {
    public static void main(String[] args) throws Exception {
        // EmpleadoRepository empleadoRepository = new EmpleadoRepository();
        // System.out.println(empleadoRepository.modificar(Empleado););
        

    // GeneroRepository generoRepository = new GeneroRepository();
    // System.out.println(generoRepository.recuperarTodos());
        // VentanaEmpleados ventanaEmpleados = new VentanaEmpleados();
        // ventanaEmpleados.setVisible(true);

        // RegistroVentana registroVentana = new RegistroVentana();
        // registroVentana.setVisible(true);

        LoginVentana loginVentana = new LoginVentana(null);
        loginVentana.setVisible(true);
    }
}
