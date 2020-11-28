package Servidor;

public class Tarea {

    private String descripcion;
    private String estado;

    public Tarea(String descripcion, String estado) {
        this.descripcion = descripcion;
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Tarea: \nDescripcion: " + descripcion + "\nEstado: " + estado + "\n";
    }
}
