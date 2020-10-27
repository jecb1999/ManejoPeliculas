package org.example.view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.example.controller.VincularController;
import org.example.model.Actor;
import org.example.model.Pelicula;

public class Vincular extends Stage {
    private Label titulo;
    private Label tactor;
    private Label tpelicula;
    private ComboBox<Pelicula> listPeliculasOB;
    private ComboBox<Actor> listActoresOB;
    private Button vincular;
    private Button volver;
    private Scene scene;
    private VincularController control;

    public Vincular(){
        titulo = new Label();
        titulo.setLayoutX(119);
        titulo.setLayoutY(14);
        titulo.setText("VINCULAR ACTOR CON PELICULA");

        tactor = new Label();
        tactor.setLayoutX(49);
        tactor.setLayoutY(75);
        tactor.setText("ACTOR");

        tpelicula = new Label();
        tpelicula.setLayoutX(45);
        tpelicula.setLayoutY(140);
        tpelicula.setText("PELICULA");

        vincular = new Button();
        vincular.setLayoutY(242);
        vincular.setLayoutX(87);
        vincular.setText("VINCULAR");

        volver = new Button();
        volver.setLayoutX(227);
        volver.setLayoutY(242);
        volver.setText("VOLVER AL MENU");

        listPeliculasOB = new ComboBox<Pelicula>();
        listPeliculasOB.setLayoutX(209);
        listPeliculasOB.setLayoutY(136);
        listPeliculasOB.setPrefWidth(150);

        listActoresOB = new ComboBox<Actor>();
        listActoresOB.setLayoutX(209);
        listActoresOB.setLayoutY(71);
        listActoresOB.setPrefWidth(150);

        AnchorPane ap = new AnchorPane();
        ap.setPrefHeight(296);
        ap.setPrefWidth(403);
        ap.getChildren().add(titulo);
        ap.getChildren().add(tactor);
        ap.getChildren().add(tpelicula);
        ap.getChildren().add(listActoresOB);
        ap.getChildren().add(listPeliculasOB);
        ap.getChildren().add(volver);
        ap.getChildren().add(vincular);
        scene = new Scene(ap);
        this.setScene(scene);
        control = new VincularController(this);
    }

    public ComboBox<Pelicula> getListPeliculasOB() {
        return listPeliculasOB;
    }

    public ComboBox<Actor> getListActoresOB() {
        return listActoresOB;
    }

    public Button getVincular() {
        return vincular;
    }

    public Button getVolver() {
        return volver;
    }
}
