package org.example.DAO;

import org.example.beans.Pelicula;

import java.util.ArrayList;

public class PeliculasDAO
 implements DAO<Pelicula> {

    @Override
    public void add(Pelicula object) {}

    @Override
    public void update(int id, Pelicula object) {

    }

    @Override
    public void delete(int id) {

    }
    @Override
    public Pelicula find(int id) {
        return null;
    }
    @Override
    public ArrayList<Pelicula> findAll() {
        return null;
    }
}
