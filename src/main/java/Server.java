import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static final int port = 1456;

    public static void main(String[] args) throws IOException {
        String w = "";
        String a = "";
        try (ServerSocket serverSocket = new ServerSocket(port);) {
            while (true) {
                try (
                        Socket socket = serverSocket.accept();
                        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
                    if (w.equals("")) {
                        out.println("???");
                        w = in.readLine().toLowerCase();
                        out.println("OK");
                        a = w;
                    } else {
                        out.println("Last word is " + a);
                        w = in.readLine().toLowerCase();
                        if (w.charAt(0) == a.charAt(a.length() - 1)) {
                            a = w;
                            out.println("OK");
                        } else {
                            out.println("NOT OK");
                        }
                    }
                }
            }
        }
    }
}
