package Cliente;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Cliente cliente = new Cliente();
        System.out.println("Cliente conectado...");
        cliente.iniciarCliente();
    }
}
