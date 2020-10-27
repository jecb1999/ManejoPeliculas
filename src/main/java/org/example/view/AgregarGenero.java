package org.example.view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.example.controller.AgregarGeneroController;

public class AgregarGenero extends Stage {

    private Scene scene;
    private Label titulo;
    private Label tnombre;
    private TextField nombre;
    private Button agregar;
    private Button volver;
    private AgregarGeneroController control;

    public AgregarGenero(){


        titulo = new Label();
        titulo.setLayoutX(151);
        titulo.setLayoutY(14);
        titulo.setText("AGREGAR GENERO");

        tnombre = new Label();
        tnombre.setLayoutX(41);
        tnombre.setLayoutY(149);
        tnombre.setText("NOMBRE");
        nombre = new TextField();
        nombre.setLayoutX(209);
        nombre.setLayoutY(145);

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
        ap.getChildren().add(agregar);
        ap.getChildren().add(volver);
        scene = new Scene(ap);
        this.setScene(scene);
        control = new AgregarGeneroController(this);

    }

    public TextField getNombre() {
        return nombre;
    }

    public Button getAgregar() {
        return agregar;
    }

    public Button getVolver() {
        return volver;
    }
}
