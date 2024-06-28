package Utilidades;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import java.sql.*;

public class Conexion {

    public static String MENSAJEMONGO = "";

    public DBCollection ConexionMongo() {
        DB database;
        DBCollection table;

        try {
            Mongo mongo = new Mongo("localhost", 27017); //Crear la conexion
            database = mongo.getDB("planta"); //Llamo a mi base de datos
            table = database.getCollection("funcionario"); //llamo mi coleccion
            return table;

        } catch (Exception e) {
            MENSAJEMONGO = ("No se pudo conectar a la base de datos Mongo " + e.getMessage());
            return null;
        }
    }
    
    public void CloseConexionMongo() {
        Mongo mongo = new Mongo("localhost", 27017); //Crear la conexion
        mongo.close();
    }


}
