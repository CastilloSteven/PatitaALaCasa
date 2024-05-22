package Modelo;

public class Preguntas {
    private String descripcion;
    private boolean valorCorrecto;
    private String respuesta;

    public Preguntas(String descripcion, boolean valorCorrecto) {
        this.descripcion = descripcion;
        this.valorCorrecto = valorCorrecto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean getValorCorrecto() {
        return valorCorrecto;
    }

    public void setValorCorrecto(boolean valorCorrecto) {
        this.valorCorrecto = valorCorrecto;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }
    
}

