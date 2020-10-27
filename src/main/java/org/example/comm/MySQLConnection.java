package org.example.comm;

import org.example.model.Actor;
import org.example.model.Genero;
import org.example.model.Pelicula;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import  java.sql.*;
import java.util.ArrayList;

public class MySQLConnection {

    private Connection connection;


    public MySQLConnection(){
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/taller3","root","");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void  closeDB(){
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void insertGenero(Genero genero){
        try {

                Statement statement = connection.createStatement();
                String sql = ("INSERT INTO generos(nombre) VALUES ('$NOMBRE')")
                        .replace("$NOMBRE", genero.getNombre());
                statement.execute(sql);


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void insertActor(Actor actor){
        try {
                Statement statement = connection.createStatement();
                String sql = ("INSERT INTO actores(nombre,apellido,edad) VALUES ('$NOMBRE','$APELLIDO',$EDAD)")
                        .replace("$NOMBRE", actor.getNombre())
                        .replace("$APELLIDO", actor.getApellido())
                        .replace("$EDAD", "" + actor.getEdad());
                statement.execute(sql);


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void insertPelicula(Pelicula pelicula){
        try {

                Statement statement = connection.createStatement();
                String sql = ("INSERT INTO peliculas(nombre,generoID) VALUES ('$NOMBRE',$GENERO)")
                        .replace("$NOMBRE", pelicula.getNombre())
                        .replace("$GENERO", "" + pelicula.getGeneroID());
                statement.execute(sql);


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void insertActores_Peliculas(int actor,int pelicula){
        try {
            Statement statement = connection.createStatement();
            String sql = ("INSERT INTO actores_peliculas(actorID,peliculaID) VALUES ('$ACTOR','$PELICULA')")
                    .replace("$ACTOR", ""+actor)
                    .replace("$PELICULA", ""+pelicula);
            statement.execute(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public ArrayList<Genero> getAllGeneros(){
        ArrayList<Genero> output = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultados = statement.executeQuery("SELECT * FROM generos");
            while (resultados.next()){
                int id = resultados.getInt(resultados.findColumn("id"));
                String nombre = resultados.getString(resultados.findColumn("nombre"));
                output.add(new Genero(id,nombre));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return output;
    }

    public ArrayList<Pelicula> getAllPeliculas(){
        ArrayList<Pelicula> output = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultados = statement.executeQuery("SELECT * FROM peliculas");
            while (resultados.next()){
                int id = resultados.getInt(resultados.findColumn("id"));
                String nombre = resultados.getString(resultados.findColumn("nombre"));
                int genero = resultados.getInt(resultados.findColumn("generoID"));
                output.add(new Pelicula(id,nombre,genero));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return output;
    }

    public ArrayList<Actor> getAllActores(){
        ArrayList<Actor> output = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultados = statement.executeQuery("SELECT * FROM actores");
            while (resultados.next()){
                int id = resultados.getInt(resultados.findColumn("id"));
                String nombre = resultados.getString(resultados.findColumn("nombre"));
                String apellido = resultados.getString(resultados.findColumn("apellido"));
                int edad = resultados.getInt(resultados.findColumn("edad"));
                output.add(new Actor(id,nombre,apellido,edad));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return output;
    }

    public ArrayList<Pelicula> getAllPeliculasDelActor(int actor){
        ArrayList<Pelicula> output = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultados = statement.executeQuery("SELECT peliculas.id,peliculas.nombre,peliculas.generoID FROM (peliculas INNER JOIN actores_peliculas ON peliculas.id = actores_peliculas.peliculaID) INNER JOIN actores ON actores_peliculas.actorID = actores.id WHERE actores.id ="+actor );
            while (resultados.next()){
                int id = resultados.getInt(resultados.findColumn("id"));
                String nombre = resultados.getString(resultados.findColumn("nombre"));
                int genero = resultados.getInt(resultados.findColumn("generoID"));
                output.add(new Pelicula(id,nombre,genero));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return output;
    }

    public ArrayList<Pelicula> getAllPeliculasDelGenero(int generoID){
        ArrayList<Pelicula> output = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultados = statement.executeQuery("SELECT peliculas.id,peliculas.nombre,peliculas.generoID FROM peliculas INNER JOIN generos ON generos.id = peliculas.generoID WHERE peliculas.generoID = "+generoID );
            while (resultados.next()){
                int id = resultados.getInt(resultados.findColumn("id"));
                String nombre = resultados.getString(resultados.findColumn("nombre"));
                int genero = resultados.getInt(resultados.findColumn("generoID"));
                output.add(new Pelicula(id,nombre,genero));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return output;
    }

    public ArrayList<Actor> getAllActoresDeLaPelicula(int peliculasID){
        ArrayList<Actor> output = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultados = statement.executeQuery("SELECT actores.id, actores.nombre, actores.apellido, actores.edad FROM (actores INNER JOIN actores_peliculas ON actores.id = actores_peliculas.actorID) INNER JOIN peliculas ON actores_peliculas.peliculaID = peliculas.id WHERE peliculas.id ="+peliculasID );
            while (resultados.next()){
                int id = resultados.getInt(resultados.findColumn("id"));
                String nombre = resultados.getString(resultados.findColumn("nombre"));
                String apellido = resultados.getString(resultados.findColumn("apellido"));
                int edad = resultados.getInt(resultados.findColumn("edad"));
                output.add(new Actor(id,nombre,apellido,edad));

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return output;
    }

    public ArrayList<String> getPeliculayElGenero(int peliculasid){
        ArrayList<String> output = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultados = statement.executeQuery("SELECT peliculas.nombre, generos.nombre FROM peliculas INNER JOIN generos ON generos.id = peliculas.generoID WHERE peliculas.id ="+peliculasid );
            while (resultados.next()){
                String pelicula = resultados.getString(1);
                String genero = resultados.getString(2);
                output.add(pelicula);
                output.add(genero);

            }
            ResultSet resultados2 = statement.executeQuery("SELECT  actores.nombre, actores.apellido FROM (actores INNER JOIN actores_peliculas ON actores.id = actores_peliculas.actorID) INNER JOIN peliculas ON actores_peliculas.peliculaID = peliculas.id WHERE peliculas.id ="+peliculasid );
            while (resultados2.next()) {
                String nombre = resultados2.getString(resultados2.findColumn("nombre"));
                String apellido = resultados2.getString(resultados2.findColumn("apellido"));
                output.add(nombre+" "+apellido);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return output;
    }


    public void DeletePelicula(int peliculaID){
        try {
            Statement statement = connection.createStatement();
            statement.execute("DELETE  FROM `actores_peliculas` WHERE actores_peliculas.peliculaID ="+peliculaID );
            statement.execute("DELETE  FROM `peliculas` WHERE peliculas.id ="+peliculaID );
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void DeleteActor(int actorID){
        try {
            Statement statement = connection.createStatement();
            statement.execute("DELETE  FROM `actores_peliculas` WHERE actores_peliculas.actorID ="+actorID );
            statement.execute("DELETE  FROM `actores` WHERE actores.id ="+actorID );
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void DeleteGenero(int generoID){
        try {
            Statement statement = connection.createStatement();
            ResultSet resultados = statement.executeQuery("SELECT peliculas.id FROM `peliculas` WHERE peliculas.generoID =" + generoID);
            while (resultados.next()) {
                int id = resultados.getInt(resultados.findColumn("id"));
                DeletePelicula(id);
            }
            statement.execute("DELETE  FROM `generos` WHERE generos.id ="+generoID );
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
    }

}
