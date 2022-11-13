import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {


    public static void main(String[] args) throws IOException {
        int cl = 7;
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < cl; i++) {
            try (Socket socket = new Socket("127.0.0.1", Server.port);) {
                try (PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                    BufferedReader in = new BufferedReader((new InputStreamReader((socket.getInputStream()))));) {
                    String ttt = in.readLine();
                    System.out.println(ttt);
                    String town = scanner.nextLine();
                    out.println(town);
                    ttt = in.readLine();
                    System.out.println(ttt);


                }
            }
        }
    }
}