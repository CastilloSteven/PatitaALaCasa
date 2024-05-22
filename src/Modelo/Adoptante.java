
package Modelo;


public class Adoptante extends Persona{
    private int salario;

    public Adoptante(int cedula, String nombre, String apellido, int edad, String correo, int numero, int salario) {
        super(cedula, nombre, apellido, edad, correo, numero);
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }
    
}
