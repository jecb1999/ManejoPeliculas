package org.example.controller;

import javafx.application.Platform;
import org.example.view.MenuAgregar;
import org.example.view.AgregarActor;
import org.example.view.AgregarGenero;
import org.example.view.AgregarPelicula;
import org.example.view.Menu;

public class MenuAgregarController {

    private MenuAgregar menu;

    public MenuAgregarController(MenuAgregar menu){
        this.menu = menu;
        init();
    }

    public void init(){

        menu.getActor().setOnAction(
                e -> {
                    Platform.runLater(
                            ()->{
                                AgregarActor agregarActor = new AgregarActor();
                                agregarActor.show();
                                menu.close();
                            }
                    );
                }
        );

        menu.getGenero().setOnAction(
                e -> {
                    Platform.runLater(
                            ()->{
                                AgregarGenero agregarGenero = new AgregarGenero();
                                agregarGenero.show();
                                menu.close();
                            }
                    );
                }
        );

        menu.getPelicula().setOnAction(
                e -> {
                    Platform.runLater(
                            ()->{
                                AgregarPelicula agregarPelicula = new AgregarPelicula();
                                agregarPelicula.show();
                                menu.close();
                            }
                    );
                }
        );

        menu.getVolver().setOnAction(
                e -> {
                    Platform.runLater(
                            () ->{
                                Menu inicio = new Menu();
                                inicio.show();
                                menu.close();
                            }
                    );
                }
        );


    }

}
