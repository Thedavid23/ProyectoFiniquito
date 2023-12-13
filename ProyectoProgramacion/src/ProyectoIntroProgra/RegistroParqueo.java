package ProyectoIntroProgra;

import javax.swing.JOptionPane;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RegistroParqueo {
    private Date fechaEntrada;
    private String horaEntrada;
    private String numeroPlaca;
    private String usuarioCliente;
    private String horaSalida;

    // Constructor para crear un registro de parqueo
    public RegistroParqueo(String numeroPlaca, String usuarioCliente) {
        // Solicitar la fecha de entrada al usuario
        String fechaEntrada = JOptionPane.showInputDialog(null, "Ingrese la fecha de entrada (AAAA-MM-DD):", "Fecha de Entrada", JOptionPane.QUESTION_MESSAGE);
        try {
            SimpleDateFormat formatoFecha = new SimpleDateFormat("AAAA-MM-DD");
            this.fechaEntrada = formatoFecha.parse(fechaEntrada);
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "Formato de fecha incorrecto. Se usará la fecha actual.", "Error", JOptionPane.ERROR_MESSAGE);
            this.fechaEntrada = new Date();
        }

        // Solicitar la hora de entrada al usuario
        this.horaEntrada = JOptionPane.showInputDialog(null, "Ingrese la hora de entrada (HH:mm:ss):", "Hora de Entrada", JOptionPane.QUESTION_MESSAGE);

        this.numeroPlaca = numeroPlaca;
        this.usuarioCliente = usuarioCliente;
        this.horaSalida = "Pendiente";  // La hora de salida queda pendiente al inicio
    }

    // Método para obtener la hora actual
    private String obtenerHoraActual() {
        SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");
        return formatoHora.format(new Date());
    }

    public Date getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(Date fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public String getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(String horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public String getNumeroPlaca() {
        return numeroPlaca;
    }

    public void setNumeroPlaca(String numeroPlaca) {
        this.numeroPlaca = numeroPlaca;
    }

    public String getUsuarioCliente() {
        return usuarioCliente;
    }

    public void setUsuarioCliente(String usuarioCliente) {
        this.usuarioCliente = usuarioCliente;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }

    public void registrarHoraSalida() {
        this.horaSalida = obtenerHoraActual();
    }

    public void obtenerInformacionRegistro() {
        StringBuilder informacion = new StringBuilder();
        informacion.append("Registro de Parqueo:\n");

        // Mostrar la información de la fecha y hora de entrada
        informacion.append("Fecha de Entrada: ").append(new SimpleDateFormat("yyyy-MM-dd").format(fechaEntrada)).append("\n");
        informacion.append("Hora de Entrada: ").append(horaEntrada).append("\n");

        // Mostrar la información de la fecha y hora de salida
        if (!horaSalida.equals("Pendiente")) {
            informacion.append("Fecha de Salida: ").append(new SimpleDateFormat("yyyy-MM-dd").format(new Date())).append("\n");
            informacion.append("Hora de Salida: ").append(horaSalida).append("\n");
        } else {
            informacion.append("Fecha de Salida: Pendiente\n");
            informacion.append("Hora de Salida: Pendiente\n");
        }

        // Mostrar la información final
        JOptionPane.showMessageDialog(null, informacion.toString(), "Información del Registro de Parqueo", JOptionPane.INFORMATION_MESSAGE);
    }

    // Método para solicitar la hora de salida al usuario
    public void solicitarHoraSalida() {
    boolean entradaValida = false;

    while (!entradaValida) {
        // Solicitar al usuario la fecha y hora de salida
        String fechaSalidaStr = JOptionPane.showInputDialog(null, "Ingrese la fecha de salida (YYYY-MM-DD):", "Fecha de Salida", JOptionPane.QUESTION_MESSAGE);

        try {
            SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
            Date fechaSalida = formatoFecha.parse(fechaSalidaStr);
            this.fechaEntrada = fechaSalida;
            entradaValida = true;
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "Formato de fecha incorrecto. Vuelva a ingresar la fecha.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    entradaValida = false;

    while (!entradaValida) {
        this.horaSalida = JOptionPane.showInputDialog(null, "Ingrese la hora de salida (HH:mm:ss):", "Hora de Salida", JOptionPane.QUESTION_MESSAGE);

        try {
            SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");
            formatoHora.parse(this.horaSalida);
            entradaValida = true;
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "Formato de hora incorrecto. Vuelva a ingresar la hora.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    JOptionPane.showMessageDialog(null, "Hora de Salida registrada con éxito: " + horaSalida, "Registro de Hora de Salida", JOptionPane.INFORMATION_MESSAGE);
}
     
    // Método para generar la factura
    public void generarFactura() {
        if (horaSalida == null) {
            // Si la hora de salida no ha sido registrada, solicitarla al usuario
            horaSalida = JOptionPane.showInputDialog(null, "Ingrese la hora de salida (HH:mm:ss):", "Hora de Salida", JOptionPane.QUESTION_MESSAGE);
            JOptionPane.showMessageDialog(null, "Hora de Salida registrada con éxito: " + horaSalida, "Registro de Hora de Salida", JOptionPane.INFORMATION_MESSAGE);
        }

        // Calcular la diferencia de tiempo en milisegundos
        long tiempoEntrada = fechaEntrada.getTime();
        long tiempoSalida = new Date().getTime();
        long diferenciaTiempo = tiempoSalida - tiempoEntrada;

        // Convertir la diferencia de tiempo a horas
        int horasEstacionadas = (int) (diferenciaTiempo / (1000 * 60 * 60));

        // Costo por hora
        double costoPorHora = 700.0;
        // Calcular el monto total a pagar
        double montoTotal = horasEstacionadas * costoPorHora;

        // Calcular el IVA (13% del monto total)
        double iva = montoTotal * 0.13;

        // Calcular el total (monto total + IVA)
        double total = montoTotal + iva;

        // Mostrar la factura al usuario
        String factura = "Factura:\n" +
                "Nombre del Cliente: " + usuarioCliente + "\n" +
                "Fecha de Entrada: " + new SimpleDateFormat("yyyy-MM-dd").format(fechaEntrada) + "\n" +
                "Hora de Entrada: " + horaEntrada + "\n" +
                "Hora de Salida: " + horaSalida + "\n" +
                "Horas Estacionadas: " + horasEstacionadas + "\n" +
                "Costo por Hora: " + costoPorHora + "\n" +
                "Monto Total: " + montoTotal + "\n" +
                "IVA (13%): " + iva + "\n" +
                "Total a Pagar: " + total;

        JOptionPane.showMessageDialog(null, factura, "Factura", JOptionPane.INFORMATION_MESSAGE);
    }
}

   
    
    
    
     


