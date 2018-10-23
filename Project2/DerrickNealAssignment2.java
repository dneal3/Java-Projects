import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
// Worked with Mariah McRae and Daniel Loyd over the course of this project.
// 11 October 2017
public class DerrickNealAssignment2 {
    public static void main(String[] args) {
        // Part 8

        // Just the stub from part one so that I can use the user assigned variables
        // because there's no way to return two values when one is int and the other is double
        System.out.println("Please enter a length for an integer Array.");
        Scanner scan1 = new Scanner(System.in);
        Integer scan1Res = scan1.nextInt();
        while (scan1Res < 0) {
            System.out.println("Input invalid. Please enter a length for an integer Array that is above 0.");
            scan1Res = scan1.nextInt();
        }
        System.out.println("Enter an array density between [0.0,1.0].");
        Double scan2Res = scan1.nextDouble();
        while (scan2Res <= 0.0 || scan2Res > 1.0) {
            System.out.println("Input invalid. Enter an array density between [0.0,1.0].");
            scan2Res = scan1.nextDouble();
        }
        // Create Dense Array
        double starttime = System.nanoTime();
        int[] denseArray = initDeArray(scan1Res,scan2Res);
        double endtime = (System.nanoTime() - starttime)/1000000;
        System.out.println("Create Dense Length: " + denseArray.length);
        System.out.println("Time: " + endtime);

        // Convert Dense Array to Sparse Array
        starttime = System.nanoTime();
        ArrayList<int[]> newSparse = denseToSparse(denseArray);
        endtime = (System.nanoTime() - starttime)/1000000;
        System.out.println("Convert Dense to Sparse Length: " + newSparse.size());
        System.out.println("Time: " + endtime);

        // Create Sparse Array
        starttime = System.nanoTime();
        ArrayList<int[]> sparseArray = initSpArray(scan1Res, scan2Res);
        endtime = (System.nanoTime() - starttime)/1000000;
        System.out.println("Create Sparse Length: " + sparseArray.size());
        System.out.println("Time: " + endtime);

        // Convert Sparse Array to Dense Array
        starttime = System.nanoTime();
        int[] newDense = sparseToDense(sparseArray,scan1Res);
        endtime = (System.nanoTime() - starttime)/1000000;
        System.out.println("Convert Sparse to Dense Length: " + newDense.length);
        System.out.println("Time: " + endtime);

        // Find Max (Dense Array)
        starttime = System.nanoTime();
        dMaxValue(denseArray);
        endtime = (System.nanoTime() - starttime)/1000000;
        System.out.println("Time: " + endtime);

        // Find Max (Sparse Array)
        starttime = System.nanoTime();
        sMaxValue(sparseArray);
        endtime = (System.nanoTime() - starttime)/1000000;
        System.out.println("Time: " + endtime);

        // My findings over the course of testing these methods was pretty much as I expected
        // iterating through Dense Arrays was almost always slower than Sparse Arrays
        // I believe mostly because they are just larger in general. for finding the max
        // sparse was much faster, but again i think it's because there are fewer things to iterate over.


    }
    // Part 1
    public static int[] askforarray() {
        System.out.println("Please enter a length for an integer Array.");
        Scanner scan1 = new Scanner(System.in);
        Integer scan1Res = scan1.nextInt();
        while (scan1Res < 0){
            System.out.println("Input invalid. Please enter a length for an integer Array that is above 0.");
            scan1Res = scan1.nextInt();
        }
        int[] a = new int[scan1Res];
        System.out.println("Enter an array density between [0.0,1.0].");
        Double scan2Res = scan1.nextDouble();
        while (scan2Res < 0.0 || scan2Res > 1.0) {
            System.out.println("Input invalid. Enter an array density between [0.0,1.0].");
            scan2Res = scan1.nextDouble();
        }
        return a;
    }

    // Part 2 Revised
    public static int[] initDeArray(int deLength, double deDensity) {
        int[] denseArray = new int[deLength];
        Random rand = new Random();
        for (int i = 0; i < deLength; i++) {
            if (Math.random() < deDensity) {
                denseArray[i] = rand.nextInt(1000000) + 1;
            }
            else {
                denseArray[i] = 0;
            }
        }
        return denseArray;
    }

    // Part 3 Revised
    public static ArrayList<int[]> initSpArray(int spLength, double spDensity) {
        ArrayList<int[]> sparseArray = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < spLength; i++) {
            if (Math.random() < spDensity) {
                int[] tempArray = new int[2];
                tempArray[0] = i;
                tempArray[1] = rand.nextInt(1000000) + 1;
                sparseArray.add(tempArray);
            }
        }
        return sparseArray;
    }

    // Part 4 Revised
    public static ArrayList<int[]> denseToSparse(int[] denseArray) {
        ArrayList<int[]> newSparse = new ArrayList<>();
        for (int i = 0; i < denseArray.length; i++) {
            if (denseArray[i] != 0) {
                int[] tempArray = new int[2];
                tempArray[0] = i;
                tempArray[1] = denseArray[i];
                newSparse.add(tempArray);
            }
        }
        return newSparse;
    }

    //Part 5 Revised
    public static int[] sparseToDense(ArrayList<int[]> sparseArray, int deLength) {
        int spIndex = 0;
        int[] newDense = new int[deLength];
        for (int i = 0; i < newDense.length; i++) {
            if (sparseArray.get(spIndex)[0] == spIndex) {
                newDense[spIndex] = sparseArray.get(spIndex)[1];
                spIndex++;

            }
        }
        return newDense;
    }

    //Part 6 Revised
    public static int dMaxValue(int[] denseArray) {
        int denseMax = denseArray[0];
        int indexC = 0;
        for (int i = 1; i < denseArray.length; i++) {
            if (denseArray[i] > denseMax) {
                denseMax = denseArray[i];
                indexC = i;
            }
        }
        System.out.println("Max (Dense): " + denseMax + ", at index: " +indexC);
        return denseMax;
    }
    //Part 7 Revised
    public static int sMaxValue(ArrayList<int[]> sparseArray){
        int sparseMax = sparseArray.get(0)[1];
        int sparseIndex = sparseArray.get(0)[0];
        for (int i =1; i< sparseArray.size(); i++ ){
            if (sparseArray.get(i)[1] > sparseMax){
                sparseMax = sparseArray.get(i)[1];
                sparseIndex = sparseArray.get(i)[0];
         }
     }
     System.out.println("Max (Sparse): " + sparseMax + ", at index: " +sparseIndex);
     return sparseMax;
    }
}



