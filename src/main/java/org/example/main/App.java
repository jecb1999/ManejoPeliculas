package org.example.main;

import javafx.application.Application;
import javafx.stage.Stage;
import org.example.comm.MySQLConnection;
import org.example.view.Menu;

/**
 * Hello world!
 *
 */
public class App extends Application
{
    public static void main( String[] args )
    {

        System.out.println( "Hello World!" );
        MySQLConnection connection = new MySQLConnection();
        //connection.insertGenero(new Genero(-1,"Terror"));
        //connection.insertActor(new Actor(-1,"Tom","Hanks",54));
        //connection.insertPelicula(new Pelicula(-1, "El Aro", 1));
        launch();

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Menu menu = new Menu();
        menu.show();
    }
}
