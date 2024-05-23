package Control;

import Modelo.Adoptante;
import Modelo.Mascota;
import Vista.InOut;
import Modelo.PatitasALaCasa;
import Modelo.Test;
import java.time.LocalDate;

public class Ejecutar {
// atributos
    static InOut vista=new InOut();
    static PatitasALaCasa patitas;
    static Test test;
    
    public static void main(String[] args){
        int cedula=0,edad=0,numero=0,salario=0,id=0;
        String nombre="",apellido="",correo="",especie="",raza="";
        LocalDate Fllegada = null;
        Adoptante adoptan = new Adoptante(cedula,nombre,apellido,edad,correo,numero,salario);
        Mascota mascota = new Mascota(nombre, id, Fllegada, especie, raza, edad);
        patitas = new PatitasALaCasa(adoptan, mascota);
        test = new Test();
        devolverMenu();
    }
    
    public static int mostrarMenu(){
        String menu="PATITAS A LA CASA\n";
        menu+="MENU PRINCIPAL\n";
        menu+="1. Ingresar Administrador \n";
        menu+="2. Ingresar datos de Mascotas \n";
        menu+="3. Ingresar datos de Adoptante \n";
        menu+="4. Test de idoneidad \n";
        menu+="5. Ver mascotas \n";
        menu+="6. Adoptar Mascota \n";
        menu+="7. Mostrar mascotas adoptadas \n";
        menu+="8. Revision de la Mascota \n";
        menu+="9. Salir \n";
        return vista.pedirEntero(menu);
    }    
   
    static boolean funCreada=true, mascCreada=true, adopCreado=true, testCompl=true;
    
    public static void ejecutarMenu(int accion){
        switch(accion){
            case 1:
                funCreada = false;
                patitas.crearAdmin();
            break;
            
            case 2:
                if(funCreada==false){
                patitas.crearMascota();
                }
                mascCreada = false;
            break;
            
            case 3:
                if(funCreada==false && mascCreada==false){
                patitas.crearAdoptante();
                }
                adopCreado = false;
            break;
            
            case 4:
                if(funCreada==false && mascCreada==false && adopCreado==false){
                    test.realizarTest();
                }
                testCompl = false;
            break;
            
            case 5:
                if(funCreada==false && mascCreada==false){
                    patitas.verMasc();
                }
            break;
            
            case 6:
                if(adopCreado==false && testCompl==false){
                    patitas.adoptarMascota();
                }
            break;
            
            case 7:
                if(adopCreado==false && testCompl==false){
                    patitas.mostrarAdopciones();
                }
            break;
            
            case 8:
                if(mascCreada==false){
                   int id=vista.pedirEntero("Ingrese el id de la mascota");
                    patitas.realizarRevision(id);
                }
                adopCreado = false;
            break;
        }
    }
    
    public static void devolverMenu(){
        int opcion=0;
        do{
            opcion=mostrarMenu();
            ejecutarMenu(opcion);
        }while(opcion!=9);
    }
}