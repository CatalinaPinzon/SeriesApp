package co.edu.unab.martinez.andrea.seriesapp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Serie implements Serializable {

    private String nombre;
    private String descripcion;
    private String Urlpreview;
    private String Urldetail;
    private ArrayList<String>Elenco;
    private String miembros;

    public Serie(String nombre, String descripcion, String urlpreview, String urldetail, String miembros ) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        Urlpreview = urlpreview;
        Urldetail = urldetail;
        this.miembros = miembros;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUrlpreview() {
        return Urlpreview;
    }

    public void setUrlpreview(String urlpreview) {
        Urlpreview = urlpreview;
    }

    public String getUrldetail() {
        return Urldetail;
    }

    public void setUrldetail(String urldetail) {
        Urldetail = urldetail;
    }

    public ArrayList<String> getElenco() {

        String miembros = getMiembros();

        String[] elements = miembros.split(",");

        List<String> fixedLenghtList = Arrays.asList(elements);

        Elenco = new ArrayList<String>(fixedLenghtList);

        return Elenco;
    }


    public String getMiembros() {
        return miembros;
    }

    public void setMiembros(String miembros) {
        this.miembros = miembros;
    }
}
