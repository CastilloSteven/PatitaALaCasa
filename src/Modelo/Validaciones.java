package Modelo;

import Vista.InOut;
import java.util.Date;
import java.util.ArrayList;

public class Validaciones {

    InOut oe = new InOut();
    
    public boolean evaluarCedula(int cedula) {
        return cedula > 1 && cedula <= 999999999;
    }
    
    public boolean evaluarSoloNumeros(int numero){
        String numeroStr = String.valueOf(numero); 

        for (int i = 0; i < numeroStr.length(); i++) {
            if (!Character.isDigit(numeroStr.charAt(i))) {
                return false; 
            }
        }
        return true; 
    }
    
    public boolean evaluarNombre(String nombre) {
        return nombre.matches("^[a-zA-Z\\s]+");
    }

    public boolean evaluarEdadC(int edad) {   
        return edad >= 18 && edad<=120;
    }
    
    public boolean evaluarEdadM(int edad){
        return edad>=1 && edad<=30;
    }
    
    public boolean evaluarFecha(Date Fecha){
        
        return true;
    }
    public boolean evaluarId(int id){
        return id > 0 && id<= 1000000000;
    }
    public boolean evaluarSalario(double salario){
        return salario > 1200000;
    }
    public boolean evaluarTelefono(double telefono){
        return telefono > 100000000 && telefono <=999999999;
    }
    
    public boolean evaluarCorreo(String correo){
        boolean valido = true;
        for(int i=0; i<correo.length();i++){
            char c = correo.charAt(i);
            int ascii = (int) c;
            if(!((ascii>=48 && ascii<=57)||(ascii>=64 && ascii<=90)||(ascii>=97 && ascii<=122)||(ascii==164 || ascii==165)||ascii==95||ascii==46)){
                valido = false;
            }
        }
        if(!valido){
            oe.mostraDatos("Correo invalido");
        }
        return valido;
   }
   
    public boolean evaluarIdPersona(ArrayList<Integer> idsExistentes, int nuevoId){
        boolean valido = true;
        for (int i=0; i<idsExistentes.size();i++){
            if(nuevoId == idsExistentes.get(i)){
                valido = false;
            }
        }
       return valido;
   }
    
    public boolean evaluarIdMascotas(ArrayList<Integer> idsExistentes, int nuevoId){
        boolean valido = true;
        for (int i=0; i<idsExistentes.size();i++){
            if(nuevoId == idsExistentes.get(i)){
                valido = false;
            }
        }
       return valido;
   }
}