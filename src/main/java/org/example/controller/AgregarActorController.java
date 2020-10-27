package org.example.controller;

import javafx.application.Platform;
import org.example.comm.MySQLConnection;
import org.example.model.Actor;
import org.example.view.AgregarActor;
import org.example.view.Menu;

import javax.swing.*;

public class AgregarActorController {

    private AgregarActor agregar;
    private MySQLConnection sqlConnection;

    public AgregarActorController(AgregarActor agregar){
        this.agregar = agregar;
        sqlConnection = new MySQLConnection();
        init();
    }

    public void init(){
        agregar.getVolver().setOnAction(
                e->{
                    Platform.runLater(
                            ()->{
                                Menu menu = new Menu();
                                menu.show();
                                agregar.close();

                            }
                    );
                }
        );
        agregar.getAgregar().setOnAction(
                event -> {
                    sqlConnection.insertActor(new Actor(-1, agregar.getNombre().getText(), agregar.getApellido().getText(), Integer.parseInt(agregar.getEdad().getText())));
                    agregar.getNombre().clear();
                    agregar.getApellido().clear();
                    agregar.getEdad().clear();
                    JOptionPane.showMessageDialog(null, "Agregado Correctamente", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                }
        );
    }
}
