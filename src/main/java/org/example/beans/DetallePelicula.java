package org.example.beans;

public class DetallePelicula {
    private int id;
    private String text;
    private long presupuesto;
    private long recaudacion;
    private String idioma;
    // private Pelicula pelicula;

    /* ORM
    * ID SERIAL,
    SINOPSIS TEXT,
    PRESUPUESTO BIGINT,
    RECAUDACION BIGINT,
    IDIOMA_ORIGINAL VARCHAR(50),
    PELICULA_ID INT,
*/

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public long getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(long presupuesto) {
        this.presupuesto = presupuesto;
    }

    public long getRecaudacion() {
        return recaudacion;
    }

    public void setRecaudacion(long recaudacion) {
        this.recaudacion = recaudacion;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }
}
