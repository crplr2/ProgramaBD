package ProgramBD.Roberto.ProductoHistorico.ProductoHistorico;

public class ProductoHistorico {
    private String IDProducto;
    private String campoModificado;
    private String valorAnterior;
    private String valorNuevo;
    private String fechaModificacion;

    public String getCampoModificado() {
        return campoModificado;
    }

    public String getIDProducto() {
        return IDProducto;

    }

    public String getValorAnterior() {
        return valorAnterior;
    }

    public String getValorNuevo() {
        return valorNuevo;
    }

    public String getFechaModificacion() {
        return fechaModificacion;
    }


    public void setCampoModificado(String campoModificado) {
        this.campoModificado = campoModificado;
    }

    public void setIDProducto(String IDProducto) {
        this.IDProducto = IDProducto;
    }

    public void setValorAnterior(String valorAnterior) {
        this.valorAnterior = valorAnterior;
    }

    public void setValorNuevo(String valorNuevo) {
        this.valorNuevo = valorNuevo;
    }

    public void setFechaModificacion(String fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }
}
