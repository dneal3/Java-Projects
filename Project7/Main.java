//Derrick Neal
// Assignment 7: Threads
// CIS 212 Fall 2017, 20-11-17
// Worked with Mariah McRae and Daniel Loyd on this Assignment.
// I used the code from this https://stackoverflow.com/questions/43688506/how-to-format-the-output-of-a-treemap
// as a basis to make the lambda for printing the summary at the end of the program.
import java.util.TreeMap;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {
    public static TreeMap<String, String> resultsP = new TreeMap<>();
    public static TreeMap<String, String> resultsC = new TreeMap<>();

    public static void main(String[] args) throws InterruptedException {

        LinkedBlockingQueue q = new LinkedBlockingQueue(100);
        Thread producer = new Thread(new Producer(q));
        Thread consumer = new Thread(new Consumer(q));
        Thread consumer2 = new Thread(new Consumer(q));
        Thread consumer3 = new Thread(new Consumer(q));
        Thread consumer4 = new Thread(new Consumer(q));
        producer.start();
        consumer.start();
        consumer2.start();
        consumer3.start();
        consumer4.start();
        producer.join();
        consumer.join();
        consumer2.join();
        consumer3.join();
        consumer4.join();
        System.out.println();
        System.out.println("Summary:");
        resultsP.forEach((Producer,produced) -> System.out.println(Producer + " " + produced));
        resultsC.forEach((Consumer,consumed) -> System.out.println(Consumer + " " + consumed));

    }
}
