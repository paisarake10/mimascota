package com.juancastano.mimascota;

public class Mascota
{
    private int foto;
    private String nombre;
    private String num;

    public Mascota(int foto, String nombre, String num) {
        this.foto = foto;
        this.nombre = nombre;
        this.num = num;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }
}
