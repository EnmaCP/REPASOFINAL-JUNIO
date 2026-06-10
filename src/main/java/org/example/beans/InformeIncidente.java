package org.example.beans;

public class InformeIncidente {
    private int id;
    private boolean malwareDetectado;
    private int nivelSeguridad;
    private String conclusion;
    private String autorExamen;

    public InformeIncidente() {
    }

    public InformeIncidente(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isMalwareDetectado() {
        return malwareDetectado;
    }

    public void setMalwareDetectado(boolean malwareDetectado) {
        this.malwareDetectado = malwareDetectado;
    }

    public int getNivelSeguridad() {
        return nivelSeguridad;
    }

    public void setNivelSeguridad(int nivelSeguridad) {
        this.nivelSeguridad = nivelSeguridad;
    }

    public String getConclusion() {
        return conclusion;
    }

    public void setConclusion(String conclusion) {
        this.conclusion = conclusion;
    }

    public String getAutorExamen() {
        return autorExamen;
    }

    public void setAutorExamen(String autorExamen) {
        this.autorExamen = autorExamen;
    }

    @Override
    public String toString() {
        return "InformeIncidente{" +
                "id=" + id +
                ", malwareDetectado=" + malwareDetectado +
                ", nivelSeguridad=" + nivelSeguridad +
                ", conclusion='" + conclusion + '\'' +
                ", autorExamen='" + autorExamen + '\'' +
                '}';
    }
}
