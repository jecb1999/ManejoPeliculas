package org.example.controller;

import javafx.application.Platform;
import org.example.view.*;

public class MenuController {

    private Menu menu;

    public MenuController(Menu menu){
        this.menu = menu;
        init();
    }

    public void init(){
        menu.getAgregar().setOnAction(
                e -> {
                    Platform.runLater(
                            ()->{
                                MenuAgregar menuAgregar = new MenuAgregar();
                                menuAgregar.show();
                                menu.close();
                            }
                    );
                }
        );

        menu.getVincular().setOnAction(
                e -> {
                    Platform.runLater(
                            ()->{
                                Vincular vincular = new Vincular();
                                vincular.show();
                                menu.close();
                            }
                    );
                }
        );

        menu.getBuscar().setOnAction(
                e -> {
                    Platform.runLater(
                            ()->{
                                MenuBuscar menuBuscar = new MenuBuscar();
                                menuBuscar.show();
                                menu.close();
                            }
                    );
                }
        );

        menu.getEliminar().setOnAction(
                e -> {
                    Platform.runLater(
                            ()->{
                                MenuEliminar menuEliminar = new MenuEliminar();
                                menuEliminar.show();
                                menu.close();
                            }
                    );
                }
        );
    }


}
