package org.example.beans;

public class Socs {
    private int id;
    private String nombre;
    private String pais;
    private int nivelSeguridad;
    private String autorExamen;

    public Socs(int id) {
        this.id = id;
    }

    public Socs() {
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getPais() {
        return pais;
    }
    public void setPais(String pais) {
        this.pais = pais;
    }
    public int getNivelSeguridad() {
        return nivelSeguridad;
    }
    public void setNivelSeguridad(int nivelSeguridad) {
        this.nivelSeguridad = nivelSeguridad;
    }
    public String getAutorExamen() {
        return autorExamen;
    }
    public void setAutorExamen(String autorExamen) {
        this.autorExamen = autorExamen;
    }
    public Socs(int id, String nombre, String pais, int nivelSeguridad, String autorExamen) {
        this.id = id;
        this.nombre = nombre;
        this.pais = pais;
        this.nivelSeguridad = nivelSeguridad;
        this.autorExamen = autorExamen;
    }
}
