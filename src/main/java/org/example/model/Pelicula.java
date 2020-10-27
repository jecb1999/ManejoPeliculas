package org.example.model;

public class Pelicula {
    private int id;
    private String nombre;
    private int generoID;

    public Pelicula(int id, String nombre, int generoID) {
        this.id = id;
        this.nombre = nombre;
        this.generoID = generoID;
    }

    public Pelicula() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getGeneroID() {
        return generoID;
    }

    public void setGeneroID(int generoID) {
        this.generoID = generoID;
    }

    @Override
    public String toString() {
        return id+"."+nombre;
    }
}
