package org.example.beans;

import java.util.ArrayList;

public class Pelicula {
    private int id;
    private String titulo;
    private String director;
    private String genero;
    private int anyo;
    private int duracion;
    private DetallePelicula detallePelicula;
    private Categoria categoria;

    public Pelicula(String titulo, String director, String genero, int anyo, int duracion) {
        this.titulo = titulo;
        this.director = director;
        this.genero = genero;
        this.anyo = anyo;
        this.duracion = duracion;
    }

    public Pelicula(int id, String titulo, String director, String genero, int anyo, int duracion) {
        this.id = id;
        this.titulo = titulo;
        this.director = director;
        this.genero = genero;
        this.anyo = anyo;
        this.duracion = duracion;
    }

    public Pelicula() {
    }

    public DetallePelicula getDetallePelicula() {
        if(detallePelicula == null){
            detallePelicula = new DetallePelicula();
        }
        return detallePelicula;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getAnyo() {
        return anyo;
    }

    public void setAnyo(int anyo) {
        this.anyo = anyo;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    @Override
    public String toString() {
        return "Pelicula{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", director='" + director + '\'' +
                ", genero='" + genero + '\'' +
                ", anyo=" + anyo +
                ", duracion=" + duracion +
                '}';
    }
}
