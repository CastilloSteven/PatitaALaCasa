package Modelo;

public class Persona {
    private int cedula;
    private String nombre;
    private String apellido;
    private int edad;
    private String correo;
    private int numero;


    public Persona(int cedula, String nombre, String apellido, int edad, String correo, int numero) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido=apellido;
        this.edad=edad;
        this.correo=correo;
        this.numero=numero;
        
    }   

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getCedula() {
        return cedula;
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

    public String getCorreo() {
        return correo;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
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

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
}