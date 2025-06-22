package org.example;

abstract class Participante {
    protected String nombre;
    protected String Contacto;
    protected int identificacion;
    public Participante() {
    }
    /**
     * constructor vacio para las clases hijas
     * */

    public String getNombre() {
        return nombre;
    }
    public String getContacto() {
        return Contacto;
    }
    public int getIdentificacion() {
        return identificacion;
    }
}
