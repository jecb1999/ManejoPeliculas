package org.example.view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.example.controller.MenuEliminarController;
import org.example.model.Actor;
import org.example.model.Genero;
import org.example.model.Pelicula;

public class MenuEliminar extends Stage {

    private ComboBox<Actor> actorb;
    private ComboBox<Pelicula> peliculab;
    private ComboBox<Genero> generob;
    private Button elimact;
    private Button elimpeli;
    private Button elimgen;
    private Button volver;
    private Scene scene;
    private MenuEliminarController control;

    public MenuEliminar(){
        actorb = new ComboBox<Actor>();
        actorb.setLayoutX(37);
        actorb.setLayoutY(21);
        actorb.setPrefWidth(150);

        peliculab = new ComboBox<Pelicula>();
        peliculab.setLayoutX(37);
        peliculab.setLayoutY(83);
        peliculab.setPrefWidth(150);

        generob = new ComboBox<Genero>();
        generob.setLayoutX(37);
        generob.setLayoutY(146);
        generob.setPrefWidth(150);

        elimact = new Button("ELIMINAR ACTOR");
        elimact.setLayoutX(300);
        elimact.setLayoutY(21);
        elimact.setPrefHeight(25);
        elimact.setPrefWidth(130);

        elimpeli = new Button("ELIMINAR PELICULA");
        elimpeli.setLayoutX(300);
        elimpeli.setLayoutY(83);
        elimpeli.setPrefHeight(25);
        elimpeli.setPrefWidth(130);

        elimgen = new Button("ELIMINAR GENERO");
        elimgen.setLayoutX(300);
        elimgen.setLayoutY(146);
        elimgen.setPrefHeight(25);
        elimgen.setPrefWidth(130);

        volver = new Button("VOLVER AL MENU");
        volver.setLayoutX(188);
        volver.setLayoutY(205);

        AnchorPane ap = new AnchorPane();
        ap.setPrefHeight(244);
        ap.setPrefWidth(488);
        ap.getChildren().add(elimact);
        ap.getChildren().add(elimpeli);
        ap.getChildren().add(elimgen);
        ap.getChildren().add(volver);
        ap.getChildren().add(peliculab);
        ap.getChildren().add(generob);
        ap.getChildren().add(actorb);
        scene = new Scene(ap);
        this.setScene(scene);
        control = new MenuEliminarController(this);


    }

    public ComboBox<Actor> getActorb() {
        return actorb;
    }

    public ComboBox<Pelicula> getPeliculab() {
        return peliculab;
    }

    public ComboBox<Genero> getGenerob() {
        return generob;
    }

    public Button getElimact() {
        return elimact;
    }

    public Button getElimpeli() {
        return elimpeli;
    }

    public Button getElimgen() {
        return elimgen;
    }

    public Button getVolver() {
        return volver;
    }
}
