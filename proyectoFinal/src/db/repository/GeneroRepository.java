package db.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import db.conexion.ConexionDB;
import interfaces.RepositoryInterfaces;
import models.Genero;

public class GeneroRepository implements RepositoryInterfaces<Genero> {

    @Override
    public Genero recuperarId(Long id) {
        try (Connection connection = ConexionDB.getConexion()) {
            String q = "SELECT * FROM generos WHERE id_generos = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(q);) {
                preparedStatement.setLong(1, id);
                return dameEntidadResulSet(preparedStatement.executeQuery());
            } catch (Exception e) {
                System.out.println("Error en la consulta: "+e.getMessage());
            }

        } catch (Exception e) {
            System.out.println("Error al preparar la consulta" + e.getMessage());
        }
        return null;
    }

    private Genero dameEntidadResulSet(ResultSet resultSet) {
        Long idR = null;
        String nombre = null;
        try {
            if (resultSet.next()) {
                idR = resultSet.getLong("id_generos");
                nombre = resultSet.getString("nombre");
                return new Genero(idR, nombre);
            }
            return null;
        } catch (Exception e) {
            System.out.println("Error en el resultSet: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Genero> recuperarTodos() {
       
        //recuperamos la conexion
        try (Connection connection = ConexionDB.getConexion()) {
            //creamos el query
            String q = "SELECT * FROM generos";
            //No se necesita preparar por lo que usamos Statement   
            Statement statement  = connection.createStatement();
            // ejecutamos y recuperamos recordSet, en java resultSet
            return dameListaGeneros(statement.executeQuery(q));            
        } catch (Exception e) {
            System.out.println("Error en la conexion: "+e.getMessage());
        }
        return null;
    }

    private List<Genero> dameListaGeneros(ResultSet resultSet){
        // creamos la lista que retornaremos
        List<Genero> generos = new ArrayList<Genero>();
        Long id = null;
        String nombre = null;
        try {
            while (resultSet.next()) {
                //recuperamos los valores en las filas
                id = resultSet.getLong("id_generos");
                nombre = resultSet.getString("nombre");
                // agregamos el genero a la lista
                generos.add(new Genero(id, nombre));
                }
                return generos;
        } catch (Exception e) {
            System.out.println("error en la consulta: "+e.getMessage());
        }
        return null;
    }

    @Override
    public void agregar(Genero entidad) {
        try (Connection connection = ConexionDB.getConexion()) {
            String q = "INSERT INTO generos VALUES = (null,?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(q)) {
                preparedStatement.setString(1, entidad.getNombre());
                preparedStatement.executeUpdate();
            } catch (Exception e) {
                System.out.println("Error en la consulta: "+e.getMessage());
            }
            
        } catch (Exception e) {
            System.out.println("Error en la consulta: "+e.getMessage());

        }
        
    }

    @Override
    public void modificar(Genero entidad) {
        try (Connection connection = ConexionDB.getConexion()) {
            String q = "UPDATE generos SET nombre = ? WHERE id_generos=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(q)) {
                preparedStatement.setString(1, entidad.getNombre());
                preparedStatement.setLong(2, entidad.getId());
                preparedStatement.executeUpdate();
            } catch (Exception e) {
                System.out.println("Error en la consulta: "+e.getMessage());
            }
            
        } catch (Exception e) {
            System.out.println("Error en la consulta: "+e.getMessage());

        }
        
    }

    @Override
    public void eliminar(Genero entidad) {
        try (Connection connection = ConexionDB.getConexion()) {
            String q = "DELETE FROM generos WHERE id_generos = ?";
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
