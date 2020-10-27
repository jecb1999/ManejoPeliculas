package org.example.controller;

import javafx.application.Platform;
import org.example.comm.MySQLConnection;
import org.example.model.Genero;
import org.example.view.AgregarGenero;
import org.example.view.Menu;

import javax.swing.*;

public class AgregarGeneroController {

    private AgregarGenero agregar;
    private MySQLConnection sqlConnection;

    public AgregarGeneroController(AgregarGenero agregar){

        this.agregar = agregar;
        sqlConnection = new MySQLConnection();
        init();

    }

    public void init(){
        agregar.getVolver().setOnAction(
                e->{
                    Platform.runLater(
                            ()-> {
                                Menu menu = new Menu();
                                menu.show();
                                agregar.close();
                            }
                    );
                }
        );

        agregar.getAgregar().setOnAction(
                e->{
                    sqlConnection.insertGenero(new Genero(-1, agregar.getNombre().getText()));
                    agregar.getNombre().clear();
                    JOptionPane.showMessageDialog(null, "Agregado Correctamente", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                }
        );
    }
}
