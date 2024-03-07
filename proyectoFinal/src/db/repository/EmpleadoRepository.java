package db.repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.conexion.ConexionDB;
import interfaces.RepositoryInterfaces;
import models.Empleado;
import models.Genero;
import db.repository.GeneroRepository;

public class EmpleadoRepository implements RepositoryInterfaces<Empleado>{
    GeneroRepository generoRepository = new GeneroRepository();

    @Override
    public Empleado recuperarId(Long id) {
        try (Connection connection = ConexionDB.getConexion()) {
            String q = "SELECT * FROM empleados WHERE id_empleados = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(q);) {
                preparedStatement.setLong(1, id);
                return dameEntidadResulSet(preparedStatement.executeQuery());
            } catch (Exception e) {
                System.out.println("Error en la consulta: "+e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Error al preparar la consulta: "+e.getMessage());
        }
        return null;
    }

    private Empleado dameEntidadResulSet(ResultSet resultSet) {
        Long idR = null;
        String nombre = null;
        String domicilio = null;
        String telefono = null;
        String email = null;
        Date fecha_nacimiento = null;
        Long generoId = null;
        Genero genero = null;
        try {
            if (resultSet.next()) {
                idR = resultSet.getLong("id_empleados");
                nombre = resultSet.getString("nombre");
                domicilio = resultSet.getString("domicilio");
                telefono = resultSet.getString("telefono");
                email = resultSet.getString("email");
                fecha_nacimiento = resultSet.getDate("fecha_nacimiento");
                generoId = resultSet.getLong("id_generos");
                genero = generoRepository.recuperarId(generoId);

                return new Empleado(idR, 
                nombre, 
                domicilio, 
                telefono, 
                email, 
                fecha_nacimiento, 
                genero);
            }
            return null;
        } catch (Exception e) {
            System.out.println("Error en el resultSet: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Empleado> recuperarTodos() {
        try (Connection connection = ConexionDB.getConexion()) {
            String q = "SELECT * FROM empleados";
            Statement statement  = connection.createStatement();
            return dameListaEmpleados(statement.executeQuery(q));
        } catch (Exception e) {
            System.out.println("Error en la conexion: "+e.getMessage());
        }
        return null;
    }

    private List<Empleado> dameListaEmpleados(ResultSet resultSet) {
        List<Empleado> empleados = new ArrayList<Empleado>();
        GeneroRepository generoRepository = new GeneroRepository();
        try {
            Long generoid = null;
            Genero genero = null;
            while (resultSet.next()) {
                Long id = resultSet.getLong("id_empleados");
                String nombre = resultSet.getString("nombre");
                String domicilio = resultSet.getString("domicilio");
                String telefono = resultSet.getString("telefono");
                String email = resultSet.getString("email");
                Date fecha_nacimiento = resultSet.getDate("fecha_nacimiento");
                generoid = resultSet.getLong("id_generos");
                genero = generoRepository.recuperarId(generoid);
                empleados.add(new Empleado(id, nombre, domicilio, telefono, email, fecha_nacimiento, genero));
            }
                return empleados;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error en la consulta: "+e.getMessage());
        }
        return null;
    }

    @Override
    public void agregar(Empleado entidad) {
        try (Connection connection = ConexionDB.getConexion()) {
            String q= "INSERT INTO empleados VALUES  (null,?,?,?,?,?,?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(q)) {
                preparedStatement.setString(1, entidad.getNombre());
                preparedStatement.setString(2, entidad.getDomicilio());
                preparedStatement.setString(3, entidad.getTelefono());
                preparedStatement.setString(4, entidad.getEmail());
                preparedStatement.setDate(5, entidad.getFechaNacimiento());
                preparedStatement.setLong(6, entidad.getGenero().getId());
                preparedStatement.execute();
            } catch (Exception e) {
                System.out.println("Error en la consulta: "+e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Error en la consulta: "+e.getMessage());
        }
    }

    @Override
    public void modificar(Empleado entidad) {
        try (Connection connection = ConexionDB.getConexion()) {
            String q = "UPDATE empleados SET nombre=?,domicilio=?,telefono=?,email=?,fecha_nacimiento=?,id_generos=? WHERE id_empleados = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(q)) {
                preparedStatement.setString(1, entidad.getNombre());
                preparedStatement.setString(2, entidad.getDomicilio());
                preparedStatement.setString(3, entidad.getTelefono());
                preparedStatement.setString(4, entidad.getEmail());
                preparedStatement.setDate(5, entidad.getFechaNacimiento());
                preparedStatement.setLong(6, entidad.getGenero().getId());
                preparedStatement.setLong(7, entidad.getId());
                preparedStatement.executeUpdate();
                
            } catch (Exception e) {
                System.out.println("Error en la consulta: "+e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Error en la consulta: "+e.getMessage());
        }
    }

    @Override
    public void eliminar(Empleado entidad) {
        try (Connection connection = ConexionDB.getConexion()) {
            String q = "DELETE FROM empleados WHERE id_empleados = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(q)) {
                preparedStatement.setLong(1, entidad.getId());
                preparedStatement.executeUpdate();
            } catch (Exception e) {
                System.out.println("Error en la consulta: "+e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Error en la consulta: "+e.getMessage());
        }
    }


    
}
