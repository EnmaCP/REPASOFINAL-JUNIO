package org.example;


import org.example.DAO.MotorFactory;
import org.example.DAO.MotorSQL;
import org.example.DAO.PeliculaDAOImpl;
import org.example.beans.Pelicula;

import java.util.ArrayList;

public class Main2 {

    public static void main(String[] args) {
        /* MotorSQL motorSQL =
                MotorFactory.create(
                        MotorFactory.POSTGRE
                ); */
        PeliculaDAOImpl peliculaDAO =
                new PeliculaDAOImpl(MotorFactory.
                        create(
                                MotorFactory.POSTGRE));
        peliculaDAO.check();
        // Prueba Unitaria: ADD Película
        Pelicula pelicula = new Pelicula();
        pelicula.setTitulo("300");
        pelicula.setDirector("Zack Snyder");
        pelicula.setAnyo(2007);
        pelicula.setGenero("Cine Epico");
        peliculaDAO.add(pelicula);
        // Fin Prueba Unitaria: ADD Película
        // Prueba Unitaria: LISTAR PELÍCULAS
        ArrayList<Pelicula> lstPelicula = peliculaDAO.findAll();
        for (Pelicula pelicula1:lstPelicula
             ) {
            System.out.println(pelicula1.toString());
        }
        // Fin Prueba Unitaria: LISTAR PELÍCULAS
        // Prueba Unitaria: ELIMINAR
            peliculaDAO.delete(9);
        // Prueba Unitaria: FIN ELIMINAR
        // Fin Prueba Unitaria: ELIMINAR

        // Prueba Unitaria: FIND
        peliculaDAO.find(2);
        // Prueba Unitaria: FIND

        // Prueba Unitaria: UPDATE
        // peliculaDAO.update(¿?¿?¿?);
        // Prueba Unitaria: UPDATE
        // Prueba Unitaria: FIND DETALLE DE PEDIDO
        peliculaDAO.findDetallePeliculaByPelicula(5);
        // Prueba Unitaria:  FIND DETALLE DE PEDIDO
    }
}