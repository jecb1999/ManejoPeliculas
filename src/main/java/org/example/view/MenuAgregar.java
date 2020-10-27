package org.example.view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.example.controller.MenuAgregarController;

public class MenuAgregar extends Stage {

    private Scene scene;
    private Label titulo;
    private Button actor;
    private Button genero;
    private Button pelicula;
    private Button volver;
    private MenuAgregarController control;

    public MenuAgregar(){
        titulo = new Label();
        titulo.setLayoutX(136);
        titulo.setLayoutY(14);
        titulo.prefHeight(17);
        titulo.prefWidth(134);
        titulo.setText("¿QUE DESEA AGREGAR?");

        actor = new Button();
        actor.setLayoutX(51);
        actor.setLayoutY(49);
        actor.setText("ACTOR");

        genero = new Button();
        genero.setLayoutX(172);
        genero.setLayoutY(49);
        genero.setText("GENERO");

        pelicula = new Button();
        pelicula.setLayoutX(298);
        pelicula.setLayoutY(49);
        pelicula.setText("PELICULA");

        volver = new Button();
        volver.setLayoutX(147);
        volver.setLayoutY(84);
        volver.setText("VOLVER AL MENU");

        AnchorPane ap = new AnchorPane();
        ap.setPrefWidth(405);
        ap.setPrefHeight(123);
        ap.getChildren().add(titulo);
        ap.getChildren().add(actor);
        ap.getChildren().add(genero);
        ap.getChildren().add(pelicula);
        ap.getChildren().add(volver);
        scene = new Scene(ap);
        this.setScene(scene);
        control = new MenuAgregarController(this);


    }

    public Button getActor() {
        return actor;
    }

    public Button getGenero() {
        return genero;
    }

    public Button getPelicula() {
        return pelicula;
    }

    public Button getVolver() {
        return volver;
    }
}
