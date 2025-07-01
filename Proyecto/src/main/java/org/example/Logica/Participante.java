package org.example.Logica;

abstract class Participante {
    protected String nombre;
    protected String email;
    protected int id;
    protected boolean activo;

    public Participante() {
        this.activo = true; // Por defecto, el participante está activo
    }
    /**
     * Constructor vacio para las clases hijas
     * */

    public String getNombre() {
        return nombre;
    }
    public String getEmail() {
        return email;
    }
    public int getId() {
        return id;
    }
    public boolean getEstado() {return activo;}
    public void setEstado(boolean activo) {
        this.activo = activo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}
