package org.example.view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.example.controller.MenuBuscarController;
import org.example.model.Actor;
import org.example.model.Genero;
import org.example.model.Pelicula;


public class MenuBuscar extends Stage {

    private TextArea textArea;
    private ComboBox<Genero> generos;
    private Button filtrarPorGeneros;
    private ComboBox<Actor> actores;
    private Button filtrarporActor;
    private Button actoresPelicula;
    private Button infoPeli;
    private ComboBox<Pelicula> peliculas1;
    private ComboBox<Pelicula> peliculas2;
    private Button volver;
    private Scene scene;
    private MenuBuscarController control;

    public MenuBuscar(){

        textArea = new TextArea();
        textArea.setLayoutX(28);
        textArea.setLayoutY(21);
        textArea.setPrefHeight(285);
        textArea.setPrefWidth(314);

        generos = new ComboBox<Genero>();
        generos.setLayoutX(365);
        generos.setLayoutY(21);
        generos.setPrefWidth(150);

        actores = new ComboBox<Actor>();
        actores.setLayoutX(365);
        actores.setLayoutY(139);
        actores.setPrefWidth(150);

        filtrarPorGeneros = new Button("FILTRAR POR GENERO");
        filtrarPorGeneros.setLayoutX(550);
        filtrarPorGeneros.setLayoutY(21);

        filtrarporActor = new Button("FILTRAR POR ACTOR");
        filtrarporActor.setLayoutX(550);
        filtrarporActor.setLayoutY(139);

        actoresPelicula = new Button("ACTORES DE ESTA PELICULA");
        actoresPelicula.setLayoutX(550);
        actoresPelicula.setLayoutY(265);

        infoPeli = new Button("INFORMACION DE ESTA PELICULA");
        infoPeli.setLayoutX(550);
        infoPeli.setLayoutY(369);

        peliculas1 = new ComboBox<Pelicula>();
        peliculas1.setLayoutX(365);
        peliculas1.setLayoutY(265);
        peliculas1.setPrefWidth(150);

        peliculas2 = new ComboBox<Pelicula>();
        peliculas2.setLayoutX(365);
        peliculas2.setLayoutY(369);
        peliculas2.setPrefWidth(150);

        volver = new Button("VOLVER AL MENU");
        volver.setLayoutX(129);
        volver.setLayoutY(369);

        AnchorPane ap = new AnchorPane();
        ap.setPrefWidth(773);
        ap.setPrefHeight(464);
        ap.getChildren().add(textArea);
        ap.getChildren().add(generos);
        ap.getChildren().add(actores);
        ap.getChildren().add(filtrarPorGeneros);
        ap.getChildren().add(filtrarporActor);
        ap.getChildren().add(actoresPelicula);
        ap.getChildren().add(infoPeli);
        ap.getChildren().add(peliculas1);
        ap.getChildren().add(peliculas2);
        ap.getChildren().add(volver);
        scene = new Scene(ap);
        this.setScene(scene);
        control = new MenuBuscarController(this);

    }

    public TextArea getTextArea() {
        return textArea;
    }

    public ComboBox<Genero> getGeneros() {
        return generos;
    }

    public Button getFiltrarPorGeneros() {
        return filtrarPorGeneros;
    }

    public ComboBox<Actor> getActores() {
        return actores;
    }

    public Button getFiltrarporActor() {
        return filtrarporActor;
    }

    public Button getActoresPelicula() {
        return actoresPelicula;
    }

    public Button getInfoPeli() {
        return infoPeli;
    }

    public ComboBox<Pelicula> getPeliculas1() {
        return peliculas1;
    }

    public ComboBox<Pelicula> getPeliculas2() {
        return peliculas2;
    }

    public Button getVolver() {
        return volver;
    }
}
