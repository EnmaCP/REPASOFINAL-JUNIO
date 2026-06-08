package org.example.DAO;

import java.sql.DriverManager;

public class MariaDBMotorSQL
        extends MotorSQL {
    private static final String URL =
            "jdbc:mariadb://db-mariadb.cgsa0il5cf9s.us-east-1.rds.amazonaws.com:3306/mariadb";
    private static final String USER = "admin";
    private static final String PASSWORD =  "12345678";
    private static final String DRIVER =  "org.mariadb.jdbc.Driver";
    public MariaDBMotorSQL(){
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