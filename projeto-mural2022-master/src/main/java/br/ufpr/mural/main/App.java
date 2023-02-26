package br.ufpr.mural.main;

import java.io.IOException;

//import com.mysql.cj.jdbc.JdbcPropertySetImpl;

import br.ufpr.mural.database.InMemoryDatabase;
import br.ufpr.mural.server.Servidor;


public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Iniciando servidor");
         InMemoryDatabase database = new InMemoryDatabase();
        //JdbcSqlDatabaseDao database = new JdbcSqlDatabaseDao();
        Servidor servidor = new Servidor(database);
        servidor.iniciar();        
    }
}