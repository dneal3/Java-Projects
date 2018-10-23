// Worked very closely with Mariah McRae and Daniel Loyd, our code for this one will be very similar.
import java.io.EOFException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ServerXC {

    public static void main(String[]args) throws Exception{

        ServerSocket server = new ServerSocket(1996);
        System.out.println("Server started.");
        System.out.println("Waiting for a client ...");

        Socket socket = server.accept();
        System.out.println("Client accepted.");
        while (ClientXC.kill) {
            try {
                ArrayList<Integer> fromClient = new ArrayList<>();
                ArrayList<Integer> isPrimeList = new ArrayList<>();
                ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());

                try {
                    Object thing = inputStream.readObject();
                    fromClient = (ArrayList<Integer>) thing;
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                for (Object num : fromClient) {
                    if (isPrime((Integer) num)) {
                        isPrimeList.add((Integer) num);
                    }
                }
                ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
                output.writeObject(isPrimeList);

            } catch (EOFException e){
                break;
            }
        }
    }
    //In the examples given for the project 2 is not considered as prime, even though 2 is technically a prime.
    public static boolean isPrime(int n){
        if ( n <= 2){
            return false;
        }
        for (int i=2;i<n;i++){
            if (n%i == 0){
                return false;
            }

        }
        return true;

    }

}

