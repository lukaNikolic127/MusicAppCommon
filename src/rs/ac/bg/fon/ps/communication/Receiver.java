package rs.ac.bg.fon.ps.communication;

import java.io.ObjectInputStream;
import java.net.Socket;

public class Receiver {
    
    private Socket socket;

    public Receiver(Socket socket) {
        this.socket = socket;
    }
    
    public Object receive() throws Exception {
        try {
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            return in.readObject();
        } catch (Exception e) {
            throw new Exception("Receiving object failed : " + e.getMessage());
        }
    }
}
