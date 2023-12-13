package ProyectoIntroProgra;

import java.util.Date;

public class RegistroFacturacion {
    
    private Date fechaFacturacion;
    private double montoTotal;

    public RegistroFacturacion(Date fechaFacturacion, double montoTotal) {
        this.fechaFacturacion = fechaFacturacion;
        this.montoTotal = montoTotal;
    }

    public Date getFechaFacturacion() {
        return fechaFacturacion;
    }

    public double getMontoTotal() {
        return montoTotal;
    }
}
    
