// Worked very closely with Mariah McRae and Daniel Loyd, our code for this one will be very similar.
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class ClientXC  {
    public static boolean kill = true;
    public static boolean ex = false;

    public static void main(String[]args) throws Exception {
        Thread initThread = new Thread(new PausePlaySwitch());
        initThread.start();

        ArrayList<Integer> inputs = new ArrayList<>();
        ArrayList<Integer> primesList;

        Socket clientSocket = new Socket(InetAddress.getLocalHost().getHostAddress(), 1996);

        while (kill) {
            while (ex) {
                for (int i=0;i<5;i++){
                    int randomInt = 2 + (int) (Math.random() * (100-2));
                    inputs.add(Integer.valueOf(randomInt));
                }
                ObjectOutputStream outputStream = new ObjectOutputStream(clientSocket.getOutputStream());
                outputStream.writeObject(inputs);
                System.out.println("Sent: " + inputs);

                ObjectInputStream serverOutput = new ObjectInputStream(clientSocket.getInputStream());
                Object primes = serverOutput.readObject();
                primesList = (ArrayList<Integer>) primes;
                System.out.println("Received: " + primes);

                inputs.clear();
                primesList.clear();

                Thread.sleep(1000);
                if (!kill){
                    break;
                }
            }
            Thread.sleep(50);
        }
        clientSocket.close();
    }
}

