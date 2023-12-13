package ProyectoIntroProgra;

import java.util.Date;
import javax.swing.JOptionPane;
import ProyectoIntroProgra.Parqueo;
public class Main {

    public static void main(String[] args) {

        // Agregar usuarios
        UsuarioManager.agregarUsuarios();

        // Mostrar información de los usuarios almacenados
        UsuarioManager.mostrarInformacionUsuarios();

        // Obtener el array de usuarios desde UsuarioManager
        Usuario[] usuarios = UsuarioManager.getUsuarios();

        // Iniciar sesión
        Usuario usuarioSesion = Inicio_Sesion.IniciarSesion(usuarios);

       //RegistroParqueo
        RegistroParqueo registroParqueo = new RegistroParqueo("123ABC", usuarioSesion.getUsuario());

        registroParqueo.obtenerInformacionRegistro();

        // Solicitar hora de salida pendiente si es necesario
        registroParqueo.solicitarHoraSalida();

        // Generar factura
        registroParqueo.generarFactura();


        // Crear un registro de facturación 
        RegistroFacturacion registroFacturacion = new RegistroFacturacion(new Date(), 1500.0);

        // Agregar el registro de facturación al análisis de facturación
        AnalisisFacturacion.agregarRegistroFacturacion(registroFacturacion);

        // Obtener el día con más ganancias
        String diaConMasGanancias = AnalisisFacturacion.obtenerDiaConMasGanancias();

        // Mostrar el resultado del análisis de facturación
        JOptionPane.showMessageDialog(null, "Día con más ganancias: " + diaConMasGanancias, "Análisis de Facturación", JOptionPane.INFORMATION_MESSAGE);
         
         // Crear instancia de Parqueo
        Parqueo parqueo = new Parqueo();

        //método agregarEspacio
        parqueo.agregarEspacio();

        // método editarEspacio
        parqueo.editarEspacio();

        // método inactivarEspacio
        parqueo.inactivarEspacio();

        // método intercambiarEspacios
        parqueo.intercambiarEspacios(0, 1);

        
    }
    
}
  
