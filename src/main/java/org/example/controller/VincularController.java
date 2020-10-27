package org.example.controller;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.example.comm.MySQLConnection;
import org.example.view.Vincular;
import org.example.model.Actor;
import org.example.model.Pelicula;
import org.example.view.Menu;

import javax.swing.*;
import java.util.ArrayList;

public class VincularController {

    private Vincular vincular;
    private MySQLConnection sqlConnection;
    private ObservableList<Pelicula> listPeliculaOb;
    private ObservableList<Actor> listActorOb;

    public VincularController(Vincular vincular){

        this.vincular = vincular;
        sqlConnection = new MySQLConnection();
        ArrayList<Pelicula> listPelicula = sqlConnection.getAllPeliculas();
        listPeliculaOb = FXCollections.observableArrayList(listPelicula);
        ArrayList<Actor> listActor = sqlConnection.getAllActores();
        listActorOb = FXCollections.observableArrayList(listActor);

        init();


    }

    public void init(){

        vincular.getVolver().setOnAction(
                e->{
                    Platform.runLater(
                            ()-> {
                                Menu menu = new Menu();
                                menu.show();
                                vincular.close();
                            }
                    );
                }
        );

        vincular.getListActoresOB().setItems(listActorOb);
        vincular.getListPeliculasOB().setItems(listPeliculaOb);

        vincular.getVincular().setOnAction(
                e->{
                    sqlConnection.insertActores_Peliculas(((Actor)vincular.getListActoresOB().getValue()).getId(),((Pelicula)vincular.getListPeliculasOB().getValue()).getId());
                    JOptionPane.showMessageDialog(null, "Vinculado Correctamente", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                }
        );



    }


}
