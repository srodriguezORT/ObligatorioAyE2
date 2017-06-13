package obligaye2;

/**
 *
 * @author Camila Ferreira y Sebastián Rodríguez
 */
public class Compra {
    
    private Cliente cliente;
    private int trackingId;

    public Compra(Cliente cliente, int trackingId, String empresa) {
        this.cliente = cliente;
        this.trackingId = trackingId;
        this.empresa = empresa;
        this.enviado = false;
    }
    private String empresa;
    private boolean enviado;

    
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getTrackingId() {
        return trackingId;
    }

    public void setTrackingId(int trackingId) {
        this.trackingId = trackingId;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }
    
    public boolean isEnviado() {
        return enviado;
    }

    public void setEnviado(boolean enviado) {
        this.enviado = enviado;
    }

}
