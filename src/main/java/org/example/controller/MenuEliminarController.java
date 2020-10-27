package org.example.controller;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.example.model.Genero;
import org.example.view.MenuEliminar;
import org.example.comm.MySQLConnection;
import org.example.model.Actor;
import org.example.model.Pelicula;
import org.example.view.Menu;

import javax.swing.*;
import java.util.ArrayList;

public class MenuEliminarController {

    private MenuEliminar menuEliminar;
    private MySQLConnection sqlConnection;
    private ObservableList<Pelicula> listPeliculaOb;
    private ObservableList<Actor> listActorOb;
    private ObservableList<Genero> listGeneroOb;


    public MenuEliminarController(MenuEliminar menuEliminar){
        this.menuEliminar = menuEliminar;
        sqlConnection = new MySQLConnection();
        ArrayList<Pelicula> listPelicula = sqlConnection.getAllPeliculas();
        listPeliculaOb = FXCollections.observableArrayList(listPelicula);
        ArrayList<Actor> listActor = sqlConnection.getAllActores();
        listActorOb = FXCollections.observableArrayList(listActor);
        ArrayList<Genero> listGenero = sqlConnection.getAllGeneros();
        listGeneroOb = FXCollections.observableArrayList(listGenero);
        init();
    }

    public void init(){
        menuEliminar.getVolver().setOnAction(
                e -> {
                    Platform.runLater(
                            () ->{
                                org.example.view.Menu inicio = new Menu();
                                inicio.show();
                                menuEliminar.close();
                            }
                    );
                }
        );

        menuEliminar.getActorb().setItems(listActorOb);
        menuEliminar.getPeliculab().setItems(listPeliculaOb);
        menuEliminar.getGenerob().setItems(listGeneroOb);

        menuEliminar.getElimpeli().setOnAction(
                e->{
                    sqlConnection.DeletePelicula(((Pelicula)menuEliminar.getPeliculab().getValue()).getId());
                    ArrayList<Pelicula> listPelicula = sqlConnection.getAllPeliculas();
                    listPeliculaOb = FXCollections.observableArrayList(listPelicula);
                    menuEliminar.getPeliculab().setItems(listPeliculaOb);
                    JOptionPane.showMessageDialog(null, "Eliminado Correctamente", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                }
        );

        menuEliminar.getElimact().setOnAction(
                e->{
                    sqlConnection.DeleteActor(((Actor)menuEliminar.getActorb().getValue()).getId());
                    ArrayList<Actor> listActor = sqlConnection.getAllActores();
                    listActorOb = FXCollections.observableArrayList(listActor);
                    menuEliminar.getActorb().setItems(listActorOb);
                    JOptionPane.showMessageDialog(null, "Eliminado Correctamente", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                }
        );

        menuEliminar.getElimgen().setOnAction(
                e->{
                    sqlConnection.DeleteGenero(((Genero)menuEliminar.getGenerob().getValue()).getId());
                    ArrayList<Genero> listGenero = sqlConnection.getAllGeneros();
                    listGeneroOb = FXCollections.observableArrayList(listGenero);
                    menuEliminar.getGenerob().setItems(listGeneroOb);
                    JOptionPane.showMessageDialog(null, "Eliminado Correctamente", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                }
        );


    }
}
