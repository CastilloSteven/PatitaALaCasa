package Modelo;

import java.util.Date;

public class Mascota {
    private String nombre;
    private int id;
    private Date fLlegada;
    private Date fAdopcion;
    private String especie;
    private String raza;
    private int edad;
    private HistoriaClinica hisClinica;
    
    public Mascota(String nombre,int id, Date Fllegada, String especie, String raza, int edad){
        this.nombre=nombre;
        this.id=id;
        this.fLlegada=Fllegada;
        this.especie=especie;
        this.raza=raza;
        this.edad=edad;
    }
    public String getNombre(){
        return nombre;
    }
    public int getId(){
        return id;
    }
    public int getEdad(){
        return edad;
    }
    public String getEspecie(){
        return especie;
    }
    public String getRaza(){
        return raza;
    }
    public Date getFllegada(){
        return fLlegada;
    }
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    public void setId(int id){
        this.id=id;
    }
    public void setEdad(int edad){
        this.edad=edad;
    }
    public void setEspecie(String especie){
        this.especie=especie;
    }
    public void setRaza(String raza){
        this.raza=raza;
    }
    public void setFllegada(Date Fllegada){
        this.fLlegada=Fllegada;
    }

    public Date getfLlegada() {
        return fLlegada;
    }

    public Date getfAdopcion() {
        return fAdopcion;
    }

    public HistoriaClinica getHisClinica() {
        return hisClinica;
    }

    public void setfLlegada(Date fLlegada) {
        this.fLlegada = fLlegada;
    }

    public void setfAdopcion(Date fAdopcion) {
        this.fAdopcion = fAdopcion;
    }

    public void setHisClinica(HistoriaClinica hisClinica) {
        this.hisClinica = hisClinica;
    }
    
    
    
    
    
    
    public String verHistoriaClinica(){
        String m="Historial Clinico de "+ nombre+"\n";
        m+="Vacunas:\n"+hisClinica.getVacunas()+"\n";
        m+="Enfermedades:\n"+hisClinica.getEnfermedades()+"\n";
        m+="Visitas al medico:\n"+hisClinica.getVisitasMedico()+"\n";
        m+="Ultima visita:\n"+hisClinica.getUltimaVisita()+"\n";
        m+="Descripcion adicional:\n"+hisClinica.getDesAdicional()+"\n";
        return m;
    }
}
