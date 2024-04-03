package socketTCP;

import java.net.*;
import java.io.*;

public class ClienteTCP {
    public static void main(String[] args) throws Exception{

        byte []datos = new byte[256]; // buffer de datos recibidos
        String dirIP; // variable para al macenar la IP del servidor
        String msg = "Hola soy un cliente Java\n"; //Mensaje a enviar
        System.out.println("Escriba la dirección IP del servidor a conectarse: "); // Preguntar la ip del servidor
        BufferedReader x = new BufferedReader(new InputStreamReader(System.in)); //Habilitar entrada del teclado
        dirIP=x.readLine(); //recibir la dirección del servidor

        Socket socket = new Socket(dirIP,5000); //inicia la comunicación con el servidor en el perto 5000
        DataInputStream din = new DataInputStream(socket.getInputStream()); //habilita el flujo de entrada para el socket
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream()); // habilita el flujo de salida para el socket

        System.out.println("Enviando un mensaje al servidor: "+ msg);
        dos.write(msg.getBytes());//enviar el mensaje al servidor en bytes
        dos.flush();

        din.read(datos,0,datos.length); // leer el mensaje del servidor
        String message = new String(datos); // convertir a cadena el mensaje recibido

        System.out.println(message); // imprimir el mensaje del servidor
        din.close(); //cerrar los flujos de entrada del socket
        dos.close(); //cerrar los flujos de salida del socket
        socket.close(); // cerrra socket y finalizar la comunicación 
    }    
}
