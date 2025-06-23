package org.example;

public class Jugador extends Participante{

    //datos de jugadores
    private String nombre;
    private String apellido;
    private int edad;
    private String sexo;
    private String correo;
    private String contacto;
    private int identificacion;
    /**
     * esto se llenara en su panel
     * segun la cantidad de participates
     *
     * */

    public Jugador(){
        super();
        this.estado = 1;
    }
    public String getNombre() {
        return nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public int getEdad() {
        return edad;
    }
    public String getSexo() {
        return sexo;
    }
    public String getCorreo() {
        return correo;
    }
    public String getContacto() {
        return contacto;
    }
    public int getIdentificacion() {
        return identificacion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
    }
}
