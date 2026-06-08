package org.example.DAO;

import java.sql.DriverManager;

public class PostgreMotorSQL extends MotorSQL {
    private static final String URL =
            "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER =
            "postgres";
    private static final String PASSWORD =
            "12345678";
    private static final String DRIVER =
            "org.postgresql.Driver";
    public PostgreMotorSQL(){
        super(
                URL,
                USER,
                PASSWORD,
                DRIVER
        );
    }
    @Override
    public void connect(){
        try{
            Class.forName(driver);
            conn =
                    DriverManager.getConnection(
                            url,
                            user,
                            password
                    );
            System.out.println(
                    "CONEXIÓN OK");
        }catch (Exception e){
            System.out.println(
                    e.getMessage());
        }
    }
}