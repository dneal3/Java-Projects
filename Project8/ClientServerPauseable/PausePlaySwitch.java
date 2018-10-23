// Worked very closely with Mariah McRae and Daniel Loyd, our code for this one will be very similar.
import java.util.Scanner;

public class PausePlaySwitch implements Runnable {
    private int count;
    @Override
    public void run() {
        while (ClientXC.kill) {
            System.out.println("Please enter ! to start/stop, # to quit.");
            Scanner userIn = new Scanner(System.in);
            String lastEntered = userIn.nextLine();

            if (lastEntered.equals("!")){
                count++;
                switch (count % 2){
                    case 0:
                        ClientXC.ex = false;
                        break;
                    case 1:
                        ClientXC.ex = true;
                        break;
                }
            } else if (lastEntered.equals("#")) {
             ClientXC.kill = false;
            }
        }
    }
}
