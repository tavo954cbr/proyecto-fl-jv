

import java.util.List;

import db.repository.EmpleadoRepository;
import db.repository.GeneroRepository;
import models.Empleado;
import models.Genero;

public class App {
    public static void main(String[] args) throws Exception {
       EmpleadoRepository empleadoRepository = new EmpleadoRepository();
       List<Empleado> lista = empleadoRepository.recuperarTodos();
       for (Empleado empleado : lista) {
        
           System.out.println(empleado);
       }
        

    }
}
