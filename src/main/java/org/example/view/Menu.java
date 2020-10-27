package org.example.view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import org.example.controller.MenuController;

public class Menu extends Stage {

    private Scene scene;
    private Label titulo;
    private Button agregar;
    private Button eliminar;
    private Button vincular;
    private Button buscar;
    private MenuController control;

    public Menu(){
        agregar = new Button();
        agregar.setLayoutX(72);
        agregar.setLayoutY(79);
        agregar.setText("AGREGAR");
        eliminar = new Button();
        eliminar.setLayoutX(261);
        eliminar.setLayoutY(79);
        eliminar.setText("ELIMINAR");
        vincular = new Button();
        vincular.setLayoutX(452);
        vincular.setLayoutY(79);
        vincular.setText("VINCULAR");
        buscar = new Button();
        buscar.setLayoutX(266);
        buscar.setLayoutY(144);
        buscar.setText("BUSCAR");
        titulo = new Label();
        titulo.setLayoutX(259);
        titulo.setLayoutY(14);
        titulo.prefHeight(46);
        titulo.prefWidth(82);
        titulo.setText("MENU");
        titulo.setTextFill(Color.ORANGE);
        titulo.setFont(new Font(31));
        AnchorPane ap = new AnchorPane();
        ap.setPrefHeight(183);
        ap.setPrefWidth(600);
        ap.getChildren().add(agregar);
        ap.getChildren().add(eliminar);
        ap.getChildren().add(buscar);
        ap.getChildren().add(vincular);
        ap.getChildren().add(titulo);
        scene = new Scene(ap);
        this.setScene(scene);
        control = new MenuController(this);
    }

    public Button getAgregar() {
        return agregar;
    }

    public void setAgregar(Button agregar) {
        this.agregar = agregar;
    }

    public Button getEliminar() {
        return eliminar;
    }

    public void setEliminar(Button eliminar) {
        this.eliminar = eliminar;
    }

    public Button getVincular() {
        return vincular;
    }

    public void setVincular(Button vincular) {
        this.vincular = vincular;
    }

    public Button getBuscar() {
        return buscar;
    }

    public void setBuscar(Button buscar) {
        this.buscar = buscar;
    }
}
