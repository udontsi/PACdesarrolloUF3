package Servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Servidor {

    private final int PUERTO = 9876;
    private ServerSocket serSocket;
    private Socket socket;
    static  ArrayList<Tarea>  lista = new ArrayList();

    public Servidor() throws IOException{
        serSocket = new ServerSocket(PUERTO);
        socket = new Socket();
    }

    public void iniciarServidor() throws IOException {
        while (true) {
            System.out.println("SERVIDOR: Esperando conexión entrante...");
            socket = serSocket.accept();
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            out.writeUTF("SERVIDOR: Escribe tu nombre:");
            DataInputStream in = new DataInputStream(socket.getInputStream());
            System.out.println("SERVIDOR: Cliente conectado: " + in.readUTF());
            out.writeUTF("SERVIDOR: Escribe el número de tareas:");
            int tareas = in.readInt();
            System.out.println("SERVIDOR: He recibido "+ tareas +" tareas:");
            Tarea tarea;
            for (int i=0;i<tareas;i++){
                out.writeUTF("SERVIDOR: Introduce descripción de la tarea "+(i+1)+":");
                String descripcion = in.readUTF();
                System.out.println("SERVIDOR: Descripcion recibida de la tarea "+(i+1)+": "+descripcion);
                out.writeUTF("SERVIDOR: Introduce el estado de la tarea "+(i+1)+":");
                String estado = in.readUTF();
                System.out.println("SERVIDOR: Estado recibido de la tarea "+(i+1)+": "+estado);
                tarea = new Tarea(descripcion,estado);
                lista.add(tarea);
            }
            for (Tarea listaTarea : lista) out.writeUTF(""+listaTarea);
            socket.close();
        }
    }

}