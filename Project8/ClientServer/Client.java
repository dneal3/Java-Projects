// Worked very closely with Mariah McRae and Daniel Loyd, our code for this one will be very similar.
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Client {
    public static void main(String[]args) throws Exception {
        ArrayList<Integer> inputs = new ArrayList<>();
        ArrayList<Integer> primesList;

        Socket clientSocket = new Socket(InetAddress.getLocalHost().getHostAddress(), 1996);
        Scanner clientInput = new Scanner(System.in);
        ObjectOutputStream outputStream = new ObjectOutputStream(clientSocket.getOutputStream());

        String lastReadLine;
        while (true) {
            System.out.println("Enter a list of integers (and use “!” to end the list).");
            lastReadLine = clientInput.nextLine();

            if (lastReadLine.equals("!")) {

                outputStream.writeObject(inputs);
                System.out.println("Sent: " + inputs);

                ObjectInputStream serverOutput = new ObjectInputStream(clientSocket.getInputStream());
                Object primes = serverOutput.readObject();
                primesList = (ArrayList<Integer>) primes;
                System.out.println("Received: " + primes);
                break;
            }
            else{
                inputs.add(Integer.valueOf(lastReadLine));
            }
        }
        clientInput.close();
        outputStream.close();
        clientSocket.close();
    }
}
