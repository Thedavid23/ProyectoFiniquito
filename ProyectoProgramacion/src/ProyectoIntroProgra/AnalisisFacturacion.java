package ProyectoIntroProgra;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class AnalisisFacturacion {
    
    private static  RegistroFacturacion[] registrosFacturacion = new RegistroFacturacion[100];
    private static int cantidadRegistros = 0;

    public static void agregarRegistroFacturacion(RegistroFacturacion registro) {
        if (cantidadRegistros < registrosFacturacion.length) {
            registrosFacturacion[cantidadRegistros++] = registro;
        } else {
            JOptionPane.showMessageDialog(null, "Error: Se alcanzó el límite de registros.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static String obtenerDiaConMasGanancias() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd");
        double[] gananciasPorDia = new double[32];

        for (int i = 0; i < cantidadRegistros; i++) {
            Date fechaFacturacion = registrosFacturacion[i].getFechaFacturacion();
            double montoTotal = registrosFacturacion[i].getMontoTotal();

            int dia = Integer.parseInt(sdf.format(fechaFacturacion));
            gananciasPorDia[dia] += montoTotal;
        }

        int diaConMasGanancias = 1;
        double gananciaMaxima = gananciasPorDia[1];

        for (int i = 2; i < gananciasPorDia.length; i++) {
            if (gananciasPorDia[i] > gananciaMaxima) {
                diaConMasGanancias = i;
                gananciaMaxima = gananciasPorDia[i];
            }
        }

        return "Día " + diaConMasGanancias;
    }
}

