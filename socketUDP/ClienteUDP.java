package socketUDP;

import java.net.*;
import java.io.*;

public class ClienteUDP {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket(); // Crea el socket UDP
        byte[] datosEnviados = "Hola, soy un cliente Java".getBytes();
        byte[] datosRecibidos = new byte[256];

        System.out.println("Ingrese la dirección IP del servidor:"); //pregunta la dirección del servidor
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); //habilida entrada de teclado
        String direccionIPString = reader.readLine(); // leee la entrada del cliente

        InetAddress direccionIP = InetAddress.getByName(direccionIPString); // Usa "localhost" o la dirección IP del servidor
        DatagramPacket paqueteEnviado = new DatagramPacket(datosEnviados, datosEnviados.length, direccionIP, 5000);
        socket.send(paqueteEnviado); // Envía el paquete al servidor

        DatagramPacket paqueteRecibido = new DatagramPacket(datosRecibidos, datosRecibidos.length);
        socket.receive(paqueteRecibido); // Recibe la respuesta del servidor
        String respuesta = new String(paqueteRecibido.getData(), 0, paqueteRecibido.getLength());

        System.out.println("Servidor dice: " + respuesta);
        socket.close(); // Cierra el socket
    }
}
