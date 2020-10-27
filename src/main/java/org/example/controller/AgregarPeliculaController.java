package org.example.controller;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.example.comm.MySQLConnection;
import org.example.model.Genero;
import org.example.model.Pelicula;
import org.example.view.AgregarPelicula;
import org.example.view.Menu;

import javax.swing.*;
import java.util.ArrayList;

public class AgregarPeliculaController {

    private AgregarPelicula agregar;
    private MySQLConnection sqlConnection;
    private ObservableList<Genero> listGeneroOb;

    public AgregarPeliculaController(AgregarPelicula agregar){

        this.agregar = agregar;
        sqlConnection = new MySQLConnection();
        ArrayList<Genero> listGenero = sqlConnection.getAllGeneros();
        listGeneroOb = FXCollections.observableArrayList(listGenero);

        init();


    }

    public void  init(){
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

        agregar.getGenero().setItems(listGeneroOb);

        agregar.getAgregar().setOnAction(
                e->{
                    sqlConnection.insertPelicula(new Pelicula(-1,agregar.getNombre().getText(),((Genero)agregar.getGenero().getValue()).getId()));
                    agregar.getNombre().clear();
                    JOptionPane.showMessageDialog(null, "Agregado Correctamente", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                }
        );
    }

}
