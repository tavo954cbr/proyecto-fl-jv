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

public class EmpleadoRepository implements RepositoryInterfaces<Empleado>{

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
        Genero genero = null;
        try {
            if (resultSet.next()) {
                idR = resultSet.getLong("id_empleados");
                nombre = resultSet.getString("nombre");
                return new Empleado(idR, nombre, domicilio, telefono, email, fecha_nacimiento, genero);
            }
            ;
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
        Long id = null;
        String nombre = null;
        String domicilio = null;
        String telefono = null;
        String email = null;
        Date fecha_nacimiento = null;
        Genero genero = null;
        try {
            while (resultSet.next()) {
                id = resultSet.getLong("id_empleados");
                nombre = resultSet.getString("nombre");
                domicilio = resultSet.getString("domicilio");
                telefono = resultSet.getString("telefono");
                email = resultSet.getString("email");
                fecha_nacimiento = resultSet.getDate("fecha_nacimiento");
                genero = genero
                empleados.add(new Empleado(id, nombre, nombre, nombre, nombre, null, null));
            }
                return empleados;
        } catch (Exception e) {
            System.out.println("Error en la consulta: "+e.getMessage());
        }
        return null;
    }

    @Override
    public void agregar(Empleado entidad) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'agregar'");
    }

    @Override
    public void modificar(Empleado entidad) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'modificar'");
    }

    @Override
    public void eliminar(Empleado entidad) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminar'");
    }


    
}
