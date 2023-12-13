package ProyectoIntroProgra;
public class Espacio {
    
    public static class EspacioParqueo {
    private int id;  // Identificador único del espacio
    private boolean discapacitado;
    private boolean cargaElectrica;
    private boolean techado;
    private boolean descubierto;
    private boolean activo;
    
    // Constructor
    public EspacioParqueo(int id, boolean discapacitado, boolean cargaElectrica, boolean techado, boolean descubierto) {
        this.id = id;
        this.discapacitado = discapacitado;
        this.cargaElectrica = cargaElectrica;
        this.techado = techado;
        this.descubierto = descubierto;
        this.activo = true;
    
}
        // Getters y setters para el atributo 'id'
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getters y setters para el atributo 'discapacitado'
    public boolean getDiscapacitado() {
        return discapacitado;
    }

    public void setDiscapacitado(boolean discapacitado) {
        this.discapacitado = discapacitado;
    }

    // Getters y setters para el atributo 'cargaElectrica'
    public boolean getCargaElectrica() {
        return cargaElectrica;
    }

    public void setCargaElectrica(boolean cargaElectrica) {
        this.cargaElectrica = cargaElectrica;
    }

    // Getters y setters para el atributo 'techado'
    public boolean getTechado() {
        return techado;
    }

    public void setTechado(boolean techado) {
        this.techado = techado;
    }

    // Getters y setters para el atributo 'descubierto'
    public boolean getDescubierto() {
        return descubierto;
    }

    public void setDescubierto(boolean descubierto) {
        this.descubierto = descubierto;
    }

    // Getters y setters para el atributo 'activo'
    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    // Método para editar la información de un espacio
    public void editarEspacio(boolean discapacitado, boolean cargaElectrica, boolean techado, boolean descubierto) {
        this.discapacitado = discapacitado;
        this.cargaElectrica = cargaElectrica;
        this.techado = techado;
        this.descubierto = descubierto;
    }
    
    
    }
}