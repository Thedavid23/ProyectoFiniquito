package ProyectoIntroProgra;

import javax.swing.JOptionPane;
import ProyectoIntroProgra.Espacio.EspacioParqueo;
public class Parqueo {
   
    private static final int MAX_ESPACIOS = 100;  // Número máximo de espacios
    private final EspacioParqueo[] espacios;
    private int cantidadEspacios;  // Número actual de espacios
    
    // Constructor
    public Parqueo() {
        espacios = new EspacioParqueo[MAX_ESPACIOS];
        cantidadEspacios = 0;
    }
    
    // Método privado para verificar si todos los espacios están libres
    private boolean espaciosLibres() {
        for (EspacioParqueo espacio : espacios) {
            if (espacio != null) {
                return false; // Hay un espacio ocupado
            }
        }
        return true; // Todos los espacios están libres
    }
    
    
    // Método privado para desplazar los espacios y hacer espacio para uno nuevo
    private void desplazarEspacios() {
        for (int i = cantidadEspacios; i > 0; i--) {
            espacios[i] = espacios[i - 1];
        }
        cantidadEspacios++;
    }

    
    // Método para agregar un nuevo espacio de parqueo
    public void agregarEspacio() {
    // Solicitar información al usuario usando JOptionPane
    
    int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el ID del espacio de parqueo:"));
    
     // Verificar si el espacio con el ID proporcionado ya está ocupado
    if (buscarEspacioPorID(id) != null) {
        JOptionPane.showMessageDialog(null, "Error: El espacio con ID " + id + " ya está ocupado.");
        return;
    }

    
        // Solicitar al usuario que ingrese un número correspondiente a la opción deseada
    int opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
            "Seleccione el tipo de espacio:\n" +
                    "1. Discapacitado\n" +
                    "2. Carga eléctrica\n" +
                    "3. Techado\n" +
                    "4. Descubierto"));

    boolean discapacitado = (opcion == 1);
    boolean cargaElectrica = (opcion == 2);
    boolean techado = (opcion == 3);
    boolean descubierto = (opcion == 4);

    if (espaciosLibres()) {
        if (cantidadEspacios < MAX_ESPACIOS) {

            if (discapacitado) {
                if (cantidadEspacios < 15) {
                    desplazarEspacios();
                    espacios[0] = new EspacioParqueo(id, discapacitado, cargaElectrica, techado, descubierto);
                    JOptionPane.showMessageDialog(null, "Espacio de parqueo agregado exitosamente.\nID: " + id + "\nTipo: Discapacitado");
                } else {
                    JOptionPane.showMessageDialog(null, "Error: Se alcanzó el límite de espacios discapacitados.");
                }
            } else if (cargaElectrica) {
                if (cantidadEspacios >= 15 && cantidadEspacios < 50) {
                    desplazarEspacios();
                    espacios[15] = new EspacioParqueo(id, discapacitado, cargaElectrica, techado, descubierto);
                    JOptionPane.showMessageDialog(null, "Espacio de parqueo agregado exitosamente.\nID: " + id + "\nTipo: Carga eléctrica");
                } else {
                    JOptionPane.showMessageDialog(null, "Error: Se alcanzó el límite de espacios de carga eléctrica.");
                }
            } else if (techado) {
                if (cantidadEspacios >= 50 && cantidadEspacios < 75) {
                    desplazarEspacios();
                    espacios[50] = new EspacioParqueo(id, discapacitado, cargaElectrica, techado, descubierto);
                    JOptionPane.showMessageDialog(null, "Espacio de parqueo agregado exitosamente.\nID: " + id + "\nTipo: Techado");
                } else {
                    JOptionPane.showMessageDialog(null, "Error: Se alcanzó el límite de espacios techados.");
                }
            } else if (descubierto) {
                if (cantidadEspacios >= 75 && cantidadEspacios < 100) {
                    desplazarEspacios();
                    espacios[75] = new EspacioParqueo(id, discapacitado, cargaElectrica, techado, descubierto);
                    JOptionPane.showMessageDialog(null, "Espacio de parqueo agregado exitosamente.\nID: " + id + "\nTipo: Descubierto");
                } else {
                    JOptionPane.showMessageDialog(null, "Error: Se alcanzó el límite de espacios sin techo.");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Error: Se alcanzó el límite de espacios en el parqueo.");
        }
    } else {
        JOptionPane.showMessageDialog(null, "Error: Todos los espacios deben estar libres para agregar un nuevo espacio.");
    }
}
    
// Método para editar la información de un espacio
public void editarEspacio() {
    // Solicitar al usuario el ID del espacio a editar
    int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el ID del espacio de parqueo a editar:"));

    int indiceEspacioEditar = -1; // Inicializamos la variable con un valor que indica que no se encontró el espacio

    for (int i = 0; i < cantidadEspacios; i++) {
        if (espacios[i] != null && espacios[i].getId() == id) {
            indiceEspacioEditar = i;
            break;
        }
    }

    if (indiceEspacioEditar != -1) {
        EspacioParqueo espacioEditar = espacios[indiceEspacioEditar];

        if (!espacioEditar.getActivo()) {
            JOptionPane.showMessageDialog(null, "Error: El espacio con ID " + id + " está inactivo. No se puede editar.");
        } else {
            // Resto del código permanece igual
            int opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "Seleccione el nuevo tipo de espacio para el ID " + id + ":\n" +
                            "1. Discapacitado\n" +
                            "2. Carga eléctrica\n" +
                            "3. Techado\n" +
                            "4. Descubierto"));

            boolean discapacitado = (opcion == 1);
            boolean cargaElectrica = (opcion == 2);
            boolean techado = (opcion == 3);
            boolean descubierto = (opcion == 4);

            boolean eraDiscapacitado = espacioEditar.getDiscapacitado();
            espacioEditar.editarEspacio(discapacitado, cargaElectrica, techado, descubierto);

            // Si cambió a ser espacio discapacitado y no lo era antes, ajustar numeración
            if (discapacitado && !eraDiscapacitado) {
                ajustarNumeracionDiscapacitado(indiceEspacioEditar);
            }

            JOptionPane.showMessageDialog(null, "Información del espacio actualizada exitosamente.");
        }
    } else {
        JOptionPane.showMessageDialog(null, "Error: No se encontró el espacio con ID " + id);
    }
}


// Método privado para ajustar la numeración al convertir un espacio en discapacitado
private void ajustarNumeracionDiscapacitado(int indiceEspacioDiscapacitado) {
    for (int i = indiceEspacioDiscapacitado; i > 0; i--) {
        intercambiarEspacios(i, i - 1);
    }
}
    // Método para inactivar un espacio
    public void inactivarEspacio() {
    // Solicitar al usuario el ID del espacio a inactivar
    int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el ID del espacio de parqueo a inactivar:"));

    EspacioParqueo espacioInactivar = buscarEspacioPorID(id);

    if (espacioInactivar != null) {
        if (!espacioInactivar.getActivo()) {
            JOptionPane.showMessageDialog(null, "Error: El espacio con ID " + id + " ya está inactivo.");
        } else {
            espacioInactivar.setActivo(false);
            JOptionPane.showMessageDialog(null, "Espacio de parqueo inactivado exitosamente.");
        }
    } else {
        JOptionPane.showMessageDialog(null, "Error: No se encontró el espacio con ID " + id);
    }
}
    
    // Método para intercambiar la posición de dos espacios
    public void intercambiarEspacios(int espacio1, int espacio2) {
        EspacioParqueo temp = espacios[espacio1];
        espacios[espacio1] = espacios[espacio2];
        espacios[espacio2] = temp;
    }
    
     private EspacioParqueo buscarEspacioPorID(int id) {
        for (EspacioParqueo espacio : espacios) {
            if (espacio != null && espacio.getId() == id) {
                return espacio; // El espacio con el ID ya está ocupado
            }
        }
        return null; // El espacio con el ID no está ocupado
    }

}
