package socketTCP;

import java.net.*;
import java.io.*;

public class ServidorTCP {
    public static void main(String[] args) throws Exception {

        ServerSocket server = new ServerSocket(5000); //Inicializa el socket de escucha en el puerto 5000
        String msg = "Hola cliente te habla un servidor Jav\n"; //Mensaje pa enviar al cliente

        byte []datos = new byte [256]; //Buffer de datos recibidos
        System.out.println("Iniciando el servidor en el puerto 5000...");

        while (true) {
            System.out.println("Hecho. Esperando clientes...\n");
            Socket socket = server.accept(); // aceptar al cliente y establecer comunicación con el mismo
            
            DataInputStream dis = new DataInputStream(socket.getInputStream()); //Hsbilita el flujo de entrada para el socket
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream()); //Habilita el flujo de salida para el socket

            dis.read(datos,0,datos.length); // Capta el mensaje del cliente
            System.out.println("Se ha detectado a un cliente.\n  -El Cliente dice: "+ new String(datos)); // Imprime el mensaje
            System.out.println("Enviado el mensaje de respuesta: "+msg+"..."); //Enviar el mensaje de respuesta
            dos.write(msg.getBytes(),0,msg.length()); // Se le envia al cliente

            dis.close();
            dos.close();
            socket.close();
        }
    }    
}
