package rs.ac.bg.fon.ps.communication;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Sender {

    private Socket socket;

    public Sender(Socket socket) {
        this.socket = socket;
    }

    public void send(Object object) throws IOException {
        try {
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            out.writeObject(object);
            out.flush();
        } catch (IOException e) {
            throw e;
        }
    }

}
