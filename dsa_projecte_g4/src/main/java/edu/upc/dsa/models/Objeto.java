package edu.upc.dsa.models;

public class Objeto {
    int id;
    int rareza;
    private String nombre;
    private int precio;
    private int daño;

    public Objeto(){}
    public Objeto(int id, int rareza, String nombre, int precio, int daño){
        this.setId(id);
        this.setRareza(rareza);
        this.setNombre(nombre);
        this.setPrecio(precio);
        this.setDaño(daño);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRareza() {
        return rareza;
    }

    public void setRareza(int rareza) {
        this.rareza = rareza;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getDaño() {
        return daño;
    }

    public void setDaño(int daño) {
        this.daño = daño;
    }
}