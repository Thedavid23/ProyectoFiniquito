package ProyectoIntroProgra;
import javax.swing.JOptionPane;

enum TipoUsuario {
    CLIENTE, ADMINISTRADOR
}
public class Usuario {
    //Atributos del usuario
    private String nombre;
    private String apellidos;
    private String usuario;
    private String password;
    private boolean estado;
    private String correo;
    private TipoUsuario tipoUsuario;
    
    //Constructor con los atributos 
    public Usuario(String nombre, String apellidos, String usuario, String password, boolean estado, String correo, TipoUsuario tipoUsuario){
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.usuario = usuario;
        this.password = password;
        this.estado = estado;
        this.correo = correo;
        this.tipoUsuario = tipoUsuario;
    }
    
    // Métodos getters y setters para los atributos del usuario
    
    // Getters y setters para el atributo nombre
    public String getNombre(){
        return nombre;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    // Getters y setters para el atributo apellidos
    public String getApellidos(){
        return apellidos;
    }
    
    public void setApellidos(String apellidos){
        this.apellidos = apellidos;
    }
    
    // Getters y setters para el atributo usuario
    public String getUsuario(){
        return usuario;
    }
    
    public void setUsuario(String usuario){       
            this.usuario = usuario;
    }
    
    // Getters y setters para el atributo password
    public String getPassword(){
        return password;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    
    // Getters y setters para el atributo estado
    public boolean getEstado(){
        return estado;
    }
    
    public void setEstado(boolean estado){
        this.estado = estado;
    }
    
    // Getters y setters para el atributo correo
    public String getCorreo(){
        return correo;
    }
    
    public void setCorreo(String correo){
        this.correo = correo;
    }
    // Getters y setters para el atributo tipoUsuario
    public TipoUsuario getTipoUsuario(){
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario){
        this.tipoUsuario = tipoUsuario;
    }
    
    //Metodo para agregar los datos del usuario
    public static void Agregar() {
        // Solicitar datos del usuario
        String nombre = JOptionPane.showInputDialog(null, "Ingrese su nombre:");
        String apellidos = JOptionPane.showInputDialog(null, "Ingrese sus apellidos:");
        String usuario = JOptionPane.showInputDialog(null, "Ingrese su nombre de usuario:");
        String password = JOptionPane.showInputDialog(null, "Ingrese su contraseña:");
        String correo = JOptionPane.showInputDialog(null, "Ingrese su correo electrónico:");
        boolean estado = true;
        int opcionTipoUsuario = Integer.parseInt(JOptionPane.showInputDialog(null,
                "Seleccione el tipo de usuario:\n1. Cliente\n2. Administrador"));

        // Validar la opción del usuario y asignar el tipo correspondiente
        TipoUsuario tipoUsuario = (opcionTipoUsuario == 1) ? TipoUsuario.CLIENTE : TipoUsuario.ADMINISTRADOR;

        Usuario registroUsuarios = new Usuario(nombre, apellidos, usuario, password, estado, correo, tipoUsuario);

        

        // Mostrar información del usuario 
        String mensaje = "Información del Usuario:\n" +
                "Nombre: " + registroUsuarios.getNombre() + "\n" +
                "Apellidos: " + registroUsuarios.getApellidos() + "\n" +
                "Usuario: " + registroUsuarios.getUsuario() + "\n" +
                "Contraseña: " + registroUsuarios.getPassword() + "\n" +
                "Estado: " + registroUsuarios.getEstado() + "\n" +
                "Correo: " + registroUsuarios.getCorreo();

        JOptionPane.showMessageDialog(null, mensaje, "Información del Usuario", JOptionPane.INFORMATION_MESSAGE);
    }
}

class UsuarioManager {
    private static Usuario[] usuarios = new Usuario[100];

    // Método para agregar usuarios al array
    public static void agregarUsuarios() {
        for (int i = 0; i < usuarios.length; i++) {
            agregarUsuario(i);

            // Preguntar al usuario si desea ingresar otro usuario
            int opcion = JOptionPane.showConfirmDialog(null, "¿Desea ingresar otro usuario?", "Confirmar", JOptionPane.YES_NO_OPTION);
            if (opcion != JOptionPane.YES_OPTION) {
                break;
            }
        }
    }

    // Método para crear un nuevo usuario con la entrada del usuario
    private static void agregarUsuario(int indice) {
        String nombre = JOptionPane.showInputDialog(null, "Ingrese su nombre:");
        String apellidos = JOptionPane.showInputDialog(null, "Ingrese sus apellidos:");
        String usuario = JOptionPane.showInputDialog(null, "Ingrese su nombre de usuario:");
        String password = JOptionPane.showInputDialog(null, "Ingrese su contraseña:");
        String correo = JOptionPane.showInputDialog(null, "Ingrese su correo electrónico:");
        boolean estado = true;

    // Solicitar el tipo de usuario (1 para Cliente, 2 para Administrador)
        int opcionTipoUsuario = Integer.parseInt(JOptionPane.showInputDialog(null,
                "Seleccione el tipo de usuario:\n1. Cliente\n2. Administrador"));

        // Validar la opción del usuario y asignar el tipo correspondiente
        TipoUsuario tipoUsuario = (opcionTipoUsuario == 1) ? TipoUsuario.CLIENTE : TipoUsuario.ADMINISTRADOR;

        // Crear un nuevo objeto Usuario y asignarlo al array
        usuarios[indice] = new Usuario(nombre, apellidos, usuario, password, estado, correo, tipoUsuario);
    }

    // Método para mostrar la información de todos los usuarios
    public static void mostrarInformacionUsuarios() {
        for (Usuario usuario : usuarios) {
        // Verificar si el usuario no es null antes de mostrar la información
        if (usuario != null) {
            mostrarInformacionUsuario(usuario);
        }
    }
}

    // Método para mostrar la información de un usuario
    private static void mostrarInformacionUsuario(Usuario usuario) {
        if (usuario != null) {
            String mensaje = "Información del Usuario:\n" +
                    "Nombre: " + usuario.getNombre() + "\n" +
                    "Apellidos: " + usuario.getApellidos() + "\n" +
                    "Usuario: " + usuario.getUsuario() + "\n" +
                    "Contraseña: " + usuario.getPassword() + "\n" +
                    "Estado: " + usuario.getEstado() + "\n" +
                    "Correo: " + usuario.getCorreo();

            JOptionPane.showMessageDialog(null, mensaje, "Información del Usuario", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static Usuario[] getUsuarios() {
        return usuarios;
    }
}


