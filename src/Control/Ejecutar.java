package Control;

import Vista.InOut;
import Modelo.PatitasALaCasa;

public class Ejecutar {
// atributos
    static InOut vista=new InOut();
    static PatitasALaCasa patitas;
    
    public static void main(String[] args){
        patitas = new PatitasALaCasa();
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
        menu+="7. Revision de la Mascota \n";
        menu+="8. Salir \n";
        return vista.pedirEntero(menu);
    }    
   
    static boolean funCreada=true, mascCreada=true, adopCreado=true;
    
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
                if(mascCreada==false){
                patitas.crearAdoptante();
                }
                adopCreado = false;
            break;
            
            case 4:
                
            break;
            
            case 5:
                
            break;
            
            case 6:
                
            break;
            
            case 7:
                
            break;
        }
    }
    
    public static void devolverMenu(){
        int opcion=0;
        do{
            opcion=mostrarMenu();
            ejecutarMenu(opcion);
        }while(opcion!=8);
    }
}
