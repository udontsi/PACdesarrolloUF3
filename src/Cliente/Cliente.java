package Cliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

    private final String HOST = "localhost";
    private final int PUERTO = 9876;
    private Socket socket;

    public Cliente() throws IOException{
        socket = new Socket(HOST, PUERTO);
    }
    public void iniciarCliente() throws IOException{
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        Scanner scanner = new Scanner(System.in);
        System.out.println(in.readUTF());
        out.writeUTF(scanner.nextLine());
        System.out.println(in.readUTF());
        int numtareas = Integer.parseInt(scanner.nextLine());
        out.writeInt(numtareas);
        for (int i=0; i<numtareas;i++){
            System.out.println(in.readUTF());
            out.writeUTF(scanner.nextLine());
            System.out.println(in.readUTF());
            out.writeUTF(scanner.nextLine());
        }
        for (int i=0; i<numtareas;i++){
            System.out.println(in.readUTF());
        }
        out.close();
        in.close();
        socket.close();
    }
}
