package org.example.view;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.example.controller.AgregarPeliculaController;
import org.example.model.Genero;

public class AgregarPelicula extends Stage {
    private Scene scene;
    private Label titulo;
    private Label tnombre;
    private TextField nombre;
    private Label tgenero;
    private ComboBox<Genero> genero;
    private Button agregar;
    private  Button volver;
    private AgregarPeliculaController control;

    public AgregarPelicula() {
        titulo = new Label();
        titulo.setLayoutX(151);
        titulo.setLayoutY(14);
        titulo.setText("AGREGAR PELICULA");

        tnombre = new Label();
        tnombre.setLayoutX(43);
        tnombre.setLayoutY(75);
        tnombre.setText("NOMBRE");

        nombre = new TextField();
        nombre.setLayoutX(209);
        nombre.setLayoutY(71);

        tgenero = new Label();
        tgenero.setLayoutX(41);
        tgenero.setLayoutY(140);
        tgenero.setText("GENERO");

        genero = new ComboBox<Genero>();
        genero.setLayoutX(209);
        genero.setLayoutY(136);
        genero.setPrefWidth(150);
        genero.setPrefHeight(4);

        agregar = new Button();
        agregar.setLayoutX(92);
        agregar.setLayoutY(242);
        agregar.setText("AGREGAR");

        volver = new Button();
        volver.setLayoutX(227);
        volver.setLayoutY(242);
        volver.setText("VOLVER AL MENU");

        AnchorPane ap = new AnchorPane();
        ap.setPrefHeight(296);
        ap.setPrefWidth(403);
        ap.getChildren().add(titulo);
        ap.getChildren().add(tnombre);
        ap.getChildren().add(nombre);
        ap.getChildren().add(tgenero);
        ap.getChildren().add(genero);
        ap.getChildren().add(volver);
        ap.getChildren().add(agregar);
        scene = new Scene(ap);
        this.setScene(scene);
        control = new AgregarPeliculaController(this);
    }

    public TextField getNombre() {
        return nombre;
    }

    public ComboBox getGenero() {
        return genero;
    }

    public Button getAgregar() {
        return agregar;
    }

    public Button getVolver() {
        return volver;
    }
}
