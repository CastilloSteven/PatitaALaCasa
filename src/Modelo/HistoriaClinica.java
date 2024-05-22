 package Modelo;
 
import java.util.Date;

public class HistoriaClinica {
    private int id;
    private String vacunas;
    private String enfermedades;
    private int VisitasMedico;
    private Date ultimaVisita;
    private String DesAdicional; 

    public HistoriaClinica(int id, String vacunas, String enfermedades, int VisitasMedico, String DesAdicional) {
        this.id = id;
        this.vacunas = vacunas;
        this.enfermedades = enfermedades;
        this.VisitasMedico = VisitasMedico;
        this.DesAdicional = DesAdicional;
    }

    public int getId() {
        return id;
    }

    public String getVacunas() {
        return vacunas;
    }

    public String getEnfermedades() {
        return enfermedades;
    }

    public int getVisitasMedico() {
        return VisitasMedico;
    }

    public String getDesAdicional() {
        return DesAdicional;
    }

    public void setId(int id) {
        this.id = id; 
    }

    public void setVacunas(String vacunas) {
        this.vacunas = vacunas;
    }

    public void setEnfermedades(String enfermedades) {
        this.enfermedades = enfermedades;
    }

    public void setVisitasMedico(int VisitasMedico) {
        this.VisitasMedico = VisitasMedico;
    }

    public void setDesAdicional(String DesAdicional) {
        this.DesAdicional = DesAdicional;
    }

    public Date getUltimaVisita() {
        return ultimaVisita;
    }

    public void setUltimaVisita(Date ultimaVisita) {
        this.ultimaVisita = ultimaVisita;
    }
    
    
    
    
}
