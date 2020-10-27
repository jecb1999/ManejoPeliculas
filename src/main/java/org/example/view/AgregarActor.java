package org.example.view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.example.controller.AgregarActorController;

public class AgregarActor extends Stage {

    private Scene scene;
    private Label titulo;
    private Label tnombre;
    private TextField nombre;
    private Label tapellido;
    private TextField apellido;
    private Label tedad;
    private TextField edad;
    private Button agregar;
    private Button volver;
    private AgregarActorController control;

    public AgregarActor(){

        titulo = new Label();
        titulo.setLayoutX(151);
        titulo.setLayoutY(14);
        titulo.setText("AGREGAR ACTOR");

        tnombre = new Label();
        tnombre.setLayoutX(43);
        tnombre.setLayoutY(75);
        tnombre.setText("NOMBRE");

        nombre = new TextField();
        nombre.setLayoutX(209);
        nombre.setLayoutY(71);

        tapellido = new Label();
        tapellido.setLayoutX(41);
        tapellido.setLayoutY(140);
        tapellido.setText("APELLIDO");

        apellido = new TextField();
        apellido.setLayoutX(209);
        apellido.setLayoutY(136);

        tedad = new Label();
        tedad.setLayoutX(52);
        tedad.setLayoutY(200);
        tedad.setText("EDAD");

        edad = new TextField();
        edad.setLayoutX(209);
        edad.setLayoutY(196);

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
        ap.getChildren().add(tapellido);
        ap.getChildren().add(apellido);
        ap.getChildren().add(tedad);
        ap.getChildren().add(edad);
        ap.getChildren().add(agregar);
        ap.getChildren().add(volver);
        scene = new Scene(ap);
        this.setScene(scene);
        control = new AgregarActorController(this);

    }

    public TextField getNombre() {
        return nombre;
    }

    public TextField getApellido() {
        return apellido;
    }

    public TextField getEdad() {
        return edad;
    }

    public Button getAgregar() {
        return agregar;
    }

    public Button getVolver() {
        return volver;
    }
}
