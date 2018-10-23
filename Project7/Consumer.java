import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class Consumer implements Runnable {
    private LinkedBlockingQueue _q;
    private static int _cid;
    private final int icid;
    public int cindex = 0;

    public Consumer(LinkedBlockingQueue q) {
        _q = q;
        _cid++;
        icid = _cid;
    }

    @Override
    public void run() {
        Random r = new Random();
        while ((!_q.isEmpty()) || Producer.isRunning) {
            if (_q.poll() != null)
                cindex++;
            try {
                int p = r.nextInt(10);
                Thread.sleep(p);
                if (cindex % 100 == 0 && cindex !=0) {
                    System.out.println("\"Consumer " + icid+ "\"" + ": " + cindex + " events consumed.");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        String consKey ="\"Consumer " + icid + "\"";
        String consVal = "consumes " + cindex + " events.";
        Main.resultsC.put(consKey, consVal);
    }
}
