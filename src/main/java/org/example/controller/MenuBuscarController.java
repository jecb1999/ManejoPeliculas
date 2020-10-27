package org.example.controller;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.example.view.MenuBuscar;
import org.example.comm.MySQLConnection;
import org.example.model.Actor;
import org.example.model.Genero;
import org.example.model.Pelicula;
import org.example.view.Menu;

import java.util.ArrayList;

public class MenuBuscarController {

    private MenuBuscar menuBuscar;
    private MySQLConnection sqlConnection;
    private ObservableList<Pelicula> listPeliculaOb;
    private ObservableList<Actor> listActorOb;
    private ObservableList<Genero> listGeneroOb;

    public MenuBuscarController(MenuBuscar menuBuscar) {
        this.menuBuscar = menuBuscar;
        sqlConnection = new MySQLConnection();
        ArrayList<Pelicula> listPelicula = sqlConnection.getAllPeliculas();
        listPeliculaOb = FXCollections.observableArrayList(listPelicula);
        ArrayList<Actor> listActor = sqlConnection.getAllActores();
        listActorOb = FXCollections.observableArrayList(listActor);
        ArrayList<Genero> listGenero = sqlConnection.getAllGeneros();
        listGeneroOb = FXCollections.observableArrayList(listGenero);
        init();
    }
     public  void init(){
        menuBuscar.getVolver().setOnAction(
                event -> {
                    Platform.runLater(
                            () ->{
                                Menu inicio = new Menu();
                                inicio.show();
                                menuBuscar.close();
                            }
                    );
                }
        );

         menuBuscar.getActores().setItems(listActorOb);
         menuBuscar.getPeliculas1().setItems(listPeliculaOb);
         menuBuscar.getPeliculas2().setItems(listPeliculaOb);
         menuBuscar.getGeneros().setItems(listGeneroOb);

         menuBuscar.getFiltrarporActor().setOnAction(
                 e->{
                     Platform.runLater(
                             ()->{
                                 ArrayList<Pelicula> listpeliact = sqlConnection.getAllPeliculasDelActor(((Actor)menuBuscar.getActores().getValue()).getId());
                                 String output ="";
                                 for(int i=0;i<listpeliact.size();i++){
                                     output += listpeliact.get(i).getNombre()+"\n";
                                 }
                                 menuBuscar.getTextArea().setText(output);
                             }
                     );
                 }
         );

         menuBuscar.getFiltrarPorGeneros().setOnAction(
                 e->{
                     Platform.runLater(
                             ()->{
                                 ArrayList<Pelicula> listpeligen = sqlConnection.getAllPeliculasDelGenero(((Genero)menuBuscar.getGeneros().getValue()).getId());
                                 String output ="";
                                 for(int i=0;i<listpeligen.size();i++){
                                     output += listpeligen.get(i).getNombre()+"\n";
                                 }
                                 menuBuscar.getTextArea().setText(output);
                             }
                     );
                 }
         );

         menuBuscar.getActoresPelicula().setOnAction(
                 e->{
                     Platform.runLater(
                             ()->{
                                 ArrayList<Actor> listact = sqlConnection.getAllActoresDeLaPelicula(((Pelicula)menuBuscar.getPeliculas1().getValue()).getId());
                                 String output ="";
                                 for(int i=0;i<listact.size();i++){
                                     output += listact.get(i).getNombre()+" "+listact.get(i).getApellido()+"\n";
                                 }
                                 menuBuscar.getTextArea().setText(output);
                             }
                     );
                 }
         );

         menuBuscar.getInfoPeli().setOnAction(
                 e->{
                     Platform.runLater(
                             ()->{
                                 String output = "";
                                 ArrayList<String> peliYGen = sqlConnection.getPeliculayElGenero(((Pelicula)menuBuscar.getPeliculas2().getValue()).getId());
                                 output += "Nombre:"+" "+peliYGen.get(0)+"\n";
                                 output += "Genero:"+" "+peliYGen.get(1)+"\n";
                                 for(int i=2;i<peliYGen.size();i++){
                                     output += peliYGen.get(i)+"\n";
                                 }
                                 menuBuscar.getTextArea().setText(output);
                             }
                     );
                 }
         );







    }
}
