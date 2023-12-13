package ProyectoIntroProgra;

import javax.swing.JOptionPane;
import java.util.Arrays;

public class Inicio_Sesion {
    private static final int MAX_INTENTOS = 3;
    private static int intentosFallidos = 0;

    // Método para realizar el inicio de sesión
    public static Usuario IniciarSesion(Usuario[] usuarios) {
        String usuarioIngresado = JOptionPane.showInputDialog(null, "Ingrese su nombre de usuario:");
        String passwordIngresado = JOptionPane.showInputDialog(null, "Ingrese su contraseña:");
        
        for (Usuario usuario : usuarios) {
            if (usuario != null && usuario.getUsuario().equals(usuarioIngresado) && Arrays.equals(usuario.getPassword().toCharArray(), passwordIngresado.toCharArray())) {
                JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso. ¡Bienvenido a parqueo del oeste!");
                return usuario; // Devuelve el usuario si las credenciales son correctas
            }
        }

        JOptionPane.showMessageDialog(null, "Nombre de usuario o contraseña incorrectos. Inténtelo nuevamente.", "Error", JOptionPane.ERROR_MESSAGE);
        intentosFallidos++;

        if (intentosFallidos >= MAX_INTENTOS) {
            JOptionPane.showMessageDialog(null, "Demasiados intentos", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        } else {
            return null; // Devuelve null si las credenciales son incorrectas
        }
        return null;
    }
}
    
