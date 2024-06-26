package Modelo;

import Vista.InOut;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

public class PatitasALaCasa {

    private Adoptante adoptan;
    private Mascota mascota;
    ArrayList <Mascota> mascotas = new ArrayList <Mascota>();
    ArrayList <Mascota> mascotasAdoptadas = new ArrayList <Mascota>();
    ArrayList <Mascota> fechaLlegada = new ArrayList <Mascota>();
    ArrayList <Mascota> fechaAdopcion = new ArrayList <Mascota>();
    ArrayList <Adoptante> adoptante = new ArrayList <Adoptante>();
    ArrayList <PatitasALaCasa> adoptante_Mascota = new ArrayList <PatitasALaCasa>();
    ArrayList <Administrador> administrador = new ArrayList <Administrador>();
    ArrayList<Integer> idsPersonas = new ArrayList<>();
    ArrayList<Integer> idsMascotas = new ArrayList<>();
    InOut oe=new InOut();
    Validaciones v=new Validaciones();
    
    public PatitasALaCasa(Adoptante adoptan, Mascota mascota){
        this.adoptan = adoptan;
        this.mascota = mascota;
    }
    
    public Adoptante getAdoptan() {
        return adoptan;
    }

    public Mascota getMascota() {
        return mascota;
    }
    
    public void crearAdmin(){
        int ced, edad, num, res;
        String nom, ape, correo;
        Administrador admin;
        res=oe.pedirEntero("Crear Administrador \n 1. Ingresar nuevo administrador \n Otro numero para salir");
        while(res==1){
            do{
                nom=oe.pedirString("Ingrese el nombre del administrador");
            }while(!v.evaluarNombre(nom));
            
            do{
                ape=oe.pedirString("Ingrese el apellido del administrador");
            }while(!v.evaluarNombre(ape));
            
            do{
                ced=oe.pedirEntero("Ingrese el numero de cedula del administrador");
            }while(!v.evaluarIdPersona(idsPersonas, ced) || !v.evaluarCedula(ced));
            idsPersonas.add(ced);
            
            do{
                edad=oe.pedirEntero("Ingrese la edad del administrador");
            }while(!v.evaluarEdadC(edad));
            
            do{
                num=oe.pedirEntero("Ingrese el numero del administrador \n +57 3");
            }while(!v.evaluarTelefono(num));
            
            do{
                correo=oe.pedirString("Ingrese el correo del administrador");
            }while(!v.evaluarCorreo(correo));
            
            admin = new Administrador(ced,nom,ape,edad,correo,num);
            administrador.add(admin);
            
            res = oe.pedirEntero("Crear Administrador \n 1. Ingresar nuevo administrador \n Otro numero para salir");
        }
    }
    
    public void crearMascota(){
        int id, edad, res;
        String nom,raza,esp;
        LocalDate fLlegada;
        Mascota masc;
        res=oe.pedirEntero("Crear Mascota \n 1. Ingresar nueva mascota \n Otro numero para salir");
        while(res==1){
            do{
                nom=oe.pedirString("Ingrese el nombre de la mascota");
            }while(!v.evaluarNombre(nom));
            
            do{
                esp=oe.pedirString("Ingrese el tipo de especie (perro o gato)");
            }while(!v.evaluarNombre(esp));
            
            do{
                raza=oe.pedirString("Ingrese la raza de la mascota");
            }while(!v.evaluarNombre(raza));
            
            do{
                id=oe.pedirEntero("Ingrese el ID de la mascota");
            }while(!v.evaluarIdMascotas(idsMascotas, id) || !v.evaluarId(id));
            idsMascotas.add(id);
            
            do{
                edad=oe.pedirEntero("Ingrese la edad de la mascota");
            }while(!v.evaluarEdadM(edad));
            
            //DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate fechaActual = LocalDate.now();
            oe.mostraDatos("fecha de ingreso:" + fechaActual);

            fLlegada= fechaActual;
            
            masc = new Mascota(nom, id, fLlegada,esp,raza,edad);
            
            
            oe.mostraDatos("Historial Clinico del animal");
             
             String vacunas = oe.pedirString("Vacunas de la mascota");
             String enfermedades = oe.pedirString("Enfermedades de la mascota");
             String descAdd = oe.pedirString("Descripcion adicional acerda del estado de la mascota");
             LocalDate ultVis = fechaActual;
             int visMed = 0;
            
            HistoriaClinica mascHC = new HistoriaClinica(id, vacunas, enfermedades, visMed, descAdd,ultVis);
            masc.setHisClinica(mascHC);
            
            
            mascotas.add(masc);
            res = oe.pedirEntero("Crear Mascota \n 1. Ingresar nueva mascota \n Otro numero para salir");
        }
        
    }
    
    public void crearAdoptante(){
        int ced, edad, num, salario = 0, res;
        String nom, ape, correo;
        Adoptante adop;
        res=oe.pedirEntero("Crear Adoptante \n 1. Ingresar nuevo adoptante \n Otro numero para salir");
        while(res==1){
            do{
                nom=oe.pedirString("Ingrese el nombre del adoptante");
            }while(!v.evaluarNombre(nom));
            
            do{
                ape=oe.pedirString("Ingrese el apellido del adoptante");
            }while(!v.evaluarNombre(ape));
            
            do{
                ced=oe.pedirEntero("Ingrese el numero de cedula del adoptante");
            }while(!v.evaluarIdPersona(idsPersonas, ced) || !v.evaluarCedula(ced) || !v.evaluarSoloNumeros(ced));
            idsPersonas.add(ced);
            
            do{
                edad=oe.pedirEntero("Ingrese la edad del adoptante");
            }while(!v.evaluarEdadC(edad) || !v.evaluarSoloNumeros(edad));
            
            do{
                num=oe.pedirEntero("Ingrese el numero del adoptante \n +57 3");
            }while(!v.evaluarTelefono(num) || !v.evaluarSoloNumeros(num));
            
            do{
                correo=oe.pedirString("Ingrese el correo del adoptante");
            }while(!v.evaluarCorreo(correo));
            
            do{
                salario=oe.pedirEntero("Ingrese su salario actual");
                if(salario<1200000){
                    oe.mostraDatos("No es apto para adoptar una mascota");
                }
            }while(!v.evaluarSalario(salario) || !v.evaluarSoloNumeros(salario));
        
            adop = new Adoptante(ced,nom,ape,edad,correo,num,salario);
            adoptante.add(adop);
            
            res=oe.pedirEntero("Crear Adoptante \n 1. Ingresar nuevo adoptante \n Otro numero para salir");
        }
    }
    
    public void adoptarMascota(){
        int adopt=0;
        int masc_adop=0;
        int res=0;
        PatitasALaCasa adopMasc;
        
        res = oe.pedirEntero("Adoptar Mascota \n 1. Adoptar una mascota \n Otro para salir");
        while(res==1){
            do{
                adopt = oe.pedirEntero("Ingrese la cedula del adoptante");
            }while(!v.evaluarCedula(adopt));

            Adoptante perAdop = null;
            for(Adoptante adoptan:adoptante){
                if(adopt == adoptan.getCedula()){
                    perAdop = adoptan;
                    break;
                }
            }

            if(perAdop != null){
               oe.mostraDatos("Adoptante encontrado");
            }
            else{
                oe.mostraDatos("No se encontro un adoptante con ese numero de cedula");
                continue;
            }

            do{
                masc_adop = oe.pedirEntero("Ingrese el ID de la mascota que quiere adoptar");
            }while (!v.evaluarId(masc_adop));

            Mascota mascotaAdoptar = null;
            for(Mascota mascota : mascotas){
                if(masc_adop == mascota.getId()){
                    mascotaAdoptar = mascota;
                    break;
                }
            }

            if(mascotaAdoptar != null) {
                mascotas.remove(mascotaAdoptar);
                oe.mostraDatos("La mascota ha sido adoptada");
            } 
            else{
                oe.mostraDatos("No se encontró una mascota con el ID proporcionado.");
                continue;
            }
            
            adopMasc = new PatitasALaCasa(perAdop,mascotaAdoptar);
            adoptante_Mascota.add(adopMasc);
            oe.mostraDatos("Adoptante y mascota guardados en el registro de adopciones.");
            
            res = oe.pedirEntero("Adoptar Mascota \n 1. Adoptar una mascota \n Otro para salir");
        }
    }
    
    public void mostrarAdopciones(){
        int i=1;
        oe.mostraDatos("El/Los adoptante(s) y su(s) mascota(s) es/son");
        for(PatitasALaCasa adoptar:adoptante_Mascota){
            oe.mostraDatos("Adopcion "+ i++);
            oe.mostraDatos("Adoptante: \n Nombre: "+adoptar.getAdoptan().getNombre()+"\n Apellido: "+adoptar.getAdoptan().getApellido()+"\n Cedula: "+adoptar.getAdoptan().getCedula());
            oe.mostraDatos("Mascota: \n Nombre: "+adoptar.getMascota().getNombre()+"\n Especie: "+adoptar.getMascota().getEspecie()+"\n Raza: "+adoptar.getMascota().getRaza()+"\n ID: "+adoptar.getMascota().getId());
        }
    }
    
    public void realizarRevision(int id){
        for (Mascota mascota : mascotas) {
            if(mascota.getId()==id){
                oe.mostraDatos("Revisión a "+ mascota.getNombre());
                String m ="Historial Clinico\n";
                m+="Vacunas: \n"+mascota.getHisClinica().getVacunas();
                m+="\n Enfermedades: \n"+mascota.getHisClinica().getEnfermedades();
                m+="\n Descricion Adicional:\n"+mascota.getHisClinica().getDesAdicional();
                m+="\n total visitas:\n"+mascota.getHisClinica().getVisitasMedico();
                m+="\n Ultima Visita y revision:\n"+mascota.getHisClinica().getUltimaVisita();
                oe.mostraDatos(m);
                
                int opc;
                do{
                    String n = "Informacion que va a editar\n";
                    n+="1. Vacunas\n";
                    n+="2. Enfermedades\n";
                    n+="3. Descripcion Adicional\n";
                    n+="4. terminar revision\n";
                    opc = oe.pedirEntero("Informacion que va a editar");
                    int opc2=0;
                    String aux="";
                    switch(opc){
                        case 1:                    
                            aux = oe.pedirString("Nueva vacuna");
                            mascota.getHisClinica().setVacunas(mascota.getHisClinica().getVacunas()+"\n"+aux);
                            
                        break;
                        case 2:
                            aux = oe.pedirString("Agregar nueva Enfermedad");
                            mascota.getHisClinica().setEnfermedades(mascota.getHisClinica().getEnfermedades()+"\n"+aux);
                        break;
                        case 3:
                            aux = oe.pedirDate("Nueva descripcion adicional");
                            mascota.getHisClinica().setDesAdicional(aux);
                            
                        break;
                        case 4:
                            oe.mostraDatos("Saliendo");
                        break;
                    }
                }while(opc!=4);
             LocalDate fechaActual = LocalDate.now();
             mascota.getHisClinica().setUltimaVisita(fechaActual);
             mascota.getHisClinica().setVisitasMedico(mascota.getHisClinica().getVisitasMedico()+1);
            oe.mostraDatos("Revisión a "+ mascota.getNombre());
                String m2 ="Nuevo Historial Clinico\n";
                m2+="Vacunas:\n"+mascota.getHisClinica().getVacunas();
                m2+="\n Enfermedades:\n"+mascota.getHisClinica().getEnfermedades();
                m2+="\n Descricion Adicional:\n"+mascota.getHisClinica().getDesAdicional();
                m2+="\n total visitas:\n"+mascota.getHisClinica().getVisitasMedico();
                m2+="\n Ultima Visita y revision:\n"+mascota.getHisClinica().getUltimaVisita();
                oe.mostraDatos(m2);
            }else{
                oe.mostraDatos("El id es incorrecto");
            }   
        }
        for (PatitasALaCasa mascotica : adoptante_Mascota) {
            if(mascotica.getMascota().getId()==id){
                oe.mostraDatos("Revisión a "+ mascotica.getMascota().getNombre());
                String m ="Historial Clinico\n";
                m+="Vacunas: \n"+mascotica.getMascota().getHisClinica().getVacunas();
                m+="\n Enfermedades: \n"+mascotica.getMascota().getHisClinica().getEnfermedades();
                m+="\n Descricion Adicional:\n"+mascotica.getMascota().getHisClinica().getDesAdicional();
                m+="\n total visitas:\n"+mascotica.getMascota().getHisClinica().getVisitasMedico();
                m+="\n Ultima Visita y revision:\n"+mascotica.getMascota().getHisClinica().getUltimaVisita();
                oe.mostraDatos(m);
                
                int opc;
                do{
                    String n = "Informacion que va a editar\n";
                    n+="1. Vacunas\n";
                    n+="2. Enfermedades\n";
                    n+="3. Descripcion Adicional\n";
                    n+="4. terminar revision\n";
                    opc = oe.pedirEntero("Informacion que va a editar");
                    int opc2=0;
                    String aux="";
                    switch(opc){
                        case 1:                    
                            aux = oe.pedirString("Nueva vacuna");
                            mascotica.getMascota().getHisClinica().setVacunas(mascotica.getMascota().getHisClinica().getVacunas()+"\n"+aux);
                            
                        break;
                        case 2:
                            aux = oe.pedirString("Agregar nueva Enfermedad");
                            mascotica.getMascota().getHisClinica().setEnfermedades(mascotica.getMascota().getHisClinica().getEnfermedades()+"\n"+aux);
                        break;
                        case 3:
                            aux = oe.pedirDate("Nueva descripcion adicional");
                            mascotica.getMascota().getHisClinica().setDesAdicional(aux);
                            
                        break;
                        case 4:
                            oe.mostraDatos("Saliendo");
                        break;
                    }
                }while(opc!=4);
             LocalDate fechaActual = LocalDate.now();
             mascotica.getMascota().getHisClinica().setUltimaVisita(fechaActual);
             mascotica.getMascota().getHisClinica().setVisitasMedico(mascotica.getMascota().getHisClinica().getVisitasMedico()+1);
            oe.mostraDatos("Revisión a "+ mascotica.getMascota().getNombre());
                String m2 ="Nuevo Historial Clinico\n";
                m2+="Vacunas:\n"+mascotica.getMascota().getHisClinica().getVacunas();
                m2+="\n Enfermedades:\n"+mascotica.getMascota().getHisClinica().getEnfermedades();
                m2+="\n Descricion Adicional:\n"+mascotica.getMascota().getHisClinica().getDesAdicional();
                m2+="\n total visitas:\n"+mascotica.getMascota().getHisClinica().getVisitasMedico();
                m2+="\n Ultima Visita y revision:\n"+mascotica.getMascota().getHisClinica().getUltimaVisita();
                oe.mostraDatos(m2);
            }else{
                oe.mostraDatos("El id es incorrecto");
            }   
        }
    }
    
    public void verMasc(){
        
        oe.mostraDatos("Las mascotas en lista de adopcion son");
        int i=1;
        for (Mascota masc:mascotas) {
            oe.mostraDatos("Mascota "+ i++);
            oe.mostraDatos("Nombre: "+masc.getNombre()+"\n Especie: "+masc.getEspecie()+"\n Raza: "+masc.getRaza()+"\n Edad: "+masc.getEdad()+"\n ID: "+masc.getId());
        }
    }
        
}