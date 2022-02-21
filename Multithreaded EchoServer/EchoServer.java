import java.io.*;
import java.net.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EchoServer implements Runnable {

    private static final ExecutorService exec = Executors.newFixedThreadPool(5);

    Socket socket;

    public EchoServer(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            BufferedReader in;
            try (PrintWriter out = new PrintWriter(socket.getOutputStream(),
                    true)) {
                in = new BufferedReader(new InputStreamReader(
                        socket.getInputStream()));
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    out.println(inputLine);
                }
            }
            in.close();
            socket.close();
        } catch (IOException e) {
        }
    }

    public static void main(String[] args) throws IOException {
    	ServerSocket serverSocket = null;
    	try {
    		serverSocket = new ServerSocket(6666);
    	} catch (IOException e) {
    		System.out.println("Could not listen on port: 6666");
    	}
    	
    	Socket clientSocket = null;
        try {
        	while(true) {
        		clientSocket = serverSocket.accept();
        		exec.execute(new EchoServer(clientSocket));
        	}
        } catch (IOException e) {
            System.out.println("Accept failed: 6666");
            System.exit(-1);
        }
        
        clientSocket.close();
        serverSocket.close();
    }
}