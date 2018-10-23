import java.util.Random;
import java.util.ArrayList;
public class Main {

    private static double nextDouble() {
        Random r = new Random();
        double res = r.nextDouble();
        while (res == 0.0) {
            res = r.nextDouble();
        }
        return res;
    }
    private static double calculateSum(ArrayList<Measurable> array) {
        double total = 0.0;
        for (Measurable measurable : array){
            total = total + measurable.getArea();
        }
        return total;
    }
    public static void main(String[] args) {
        int rects = 0;
        int boxes = 0;
        int circles = 0;
        int spheres = 0;
        ArrayList<Measurable> array = new ArrayList<>();
        for (int z = 0; z < 1000; z++) {
            double randS = nextDouble();
            double randF = nextDouble();
            double randG = nextDouble();
            double randD = Math.random();

            if (randD < .25) {
                Measurable recta = new Rectangle(randS, randF);
                array.add(recta);
                rects++;
            }
            else if (randD >= .25 && randD < .5) {
                Measurable box = new Box(randS,randF, randG);
                array.add(box);
                boxes++;
            }
            else if (randD >= .5 && randD < .75) {
                Measurable circle = new Circle(randS);
                array.add(circle);
                circles++;
            }
            else if (randD >= .75) {
                Measurable sphere = new Sphere(randS);
                array.add(sphere);
                spheres++;
            }

        }
        double sum = calculateSum(array);
        System.out.println("rects: " + rects + " boxes: " + boxes + " circles: " + circles + " spheres: " + spheres);
        System.out.println("sum: " + sum);
    }

}

