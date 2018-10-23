import java.util.concurrent.LinkedBlockingQueue;

public class Producer implements Runnable {
    private   LinkedBlockingQueue _q;
    public static boolean isRunning = true;
    private static int _pid;
    private final int ipid;
    public static int index = 0;

    public Producer(LinkedBlockingQueue q) {
        this._q = q;
        this._pid++;
        this.ipid = _pid;
    }

    @Override
    public synchronized void run() {
        for (int i = 0; i < 1000; i++) {
            Double r = Math.random();
            String d = r.toString();
            while (_q.remainingCapacity() == 0) {
                try {
                    Thread.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                _q.put(d);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (i % 100 == 0 && i != 0) {
                System.out.println("\"Producer " + ipid +"\""+ ": " + i + " events produced.");
            }
            index++;
        }
        isRunning = false;
        String prodKey ="\"Producer " + ipid + "\"";
        String prodVal = "produces " + index + " events.";
        Main.resultsP.put(prodKey, prodVal);
    }

}

