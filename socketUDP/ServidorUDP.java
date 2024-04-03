package socketUDP;

import java.net.*;

public class ServidorUDP {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket(5000); // Inicializa el socket UDP en el puerto 5000
        byte[] datosRecibidos = new byte[256]; // Buffer para los datos recibidos
        System.out.println("Servidor UDP iniciado en el puerto 5000. Esperando clientes...");

        while (true) {
            DatagramPacket paqueteRecibido = new DatagramPacket(datosRecibidos, datosRecibidos.length);
            socket.receive(paqueteRecibido); // Recibe el paquete del cliente

            String mensaje = new String(paqueteRecibido.getData(), 0, paqueteRecibido.getLength());
            System.out.println("Cliente dice: " + mensaje);

            InetAddress direccionIP = paqueteRecibido.getAddress();
            int puerto = paqueteRecibido.getPort();
            String respuesta = "Hola cliente, te habla un servidor Java";
            byte[] datosEnviados = respuesta.getBytes();
            DatagramPacket paqueteEnviado = new DatagramPacket(datosEnviados, datosEnviados.length, direccionIP, puerto);
            socket.send(paqueteEnviado); // Envía la respuesta al cliente
        }
        // No es necesario cerrar el socket en este ejemplo simplificado, pero sería buena práctica hacerlo en una aplicación real.
    }
}
    