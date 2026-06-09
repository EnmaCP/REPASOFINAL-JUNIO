package org.example;


import org.example.beans.Cliente;

import java.sql.*;
import java.util.ArrayList;

public class Main {
    private static final String URL = "jdbc:postgresql://database-2.cxhptkfuwfna.us-east-1.rds.amazonaws.com:5432/postgres";
    private static final String USER = "postgres";
    private static final String PASSWORD = "12345678";
    private static final String DRIVER = "org.postgresql.Driver";
    private static final String SQL_SELECT = "SELECT * FROM CLIENTES";
    private static final String SQL_SELECT_PELICULAS = "SELECT * FROM PELICULAS";
    private static Connection conn;
    private static Statement st;

    private static void initConexion(){
        System.out.println("Intentando conectar a la base de datos...");
        try{
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        }catch (Exception e){

        }
    }
    private static ResultSet ejecutarQuery(String SQL){
        ResultSet rs = null;
        try{
            st = conn.createStatement();
            rs = st.executeQuery(SQL);
            }catch(Exception e){
            }finally {
                return rs;
        }

    }
    public static void main(String[] args) {
        try {
                initConexion();
                ResultSet rs = ejecutarQuery(SQL_SELECT);

                System.out.println("¡CONECTADO EXITOSAMENTE!");
                ArrayList<Cliente> lstClientes =
                        new ArrayList<>();

                if(rs!=null) {
                    while (rs.next()) {
                        // SELECT * FROM CLIENTES
                        // ID NOMBRE EMAIL DIA MES AÑYO
                        Cliente cliente = new Cliente();
                        cliente.setId(rs.getInt(1));
                        cliente.setNombre(rs.getString(2));
                        cliente.setEmail(rs.getString(3));
                        cliente.setDia(rs.getString(4));
                        cliente.setMes(rs.getString(5));
                        cliente.setAnyo(rs.getString(6));
                        lstClientes.add(cliente);


/*
                        System.out.println("Id"
                                + rs.getInt(1));
                        System.out.println("Nombre"
                                + rs.getString(2));
                        System.out.println("Email"
                                + rs.getString(3));
                        System.out.println("Día"
                                + rs.getString(4));
                        System.out.println("Mes"
                                + rs.getString(5));
                        System.out.println("Año"
                                + rs.getString(6));
                        // rs.getString(1)
                        // rs.getString(2)
                        // rs.getString(3)
                        // rs.getString(4)
                        // rs.getString(5)
                        // rs.getString(6)
*/
                        System.out.println("RESULTADO DEL TEST (SELECT 1): " + rs.getInt(1));
                    } // Aquí se cierran automáticamente rs, st y conn
                    for (Cliente cliente: lstClientes
                         ) {
                        System.out.println(cliente.toString());
                    }
                }
            System.out.println("CONEXIÓN CERRADA CORRECTAMENTE.");
        } catch (SQLException e) {
            System.err.println("ERROR DE SQL: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
