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

}
