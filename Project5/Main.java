// Derrick Neal
// Assignment 5, 11-8-17
// Worked with Mariah McRae, and Daniel Loyd
// Used http://www.geeksforgeeks.org/merge-sort/ and https://en.wikipedia.org/wiki/Merge_sort
// as examples to help me visualize merge sort and write the recursive code for an ArrayList<> merge sort.
import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        ArrayList<Phonebook> arrayMain = processFile(new File("phonebook_test.txt"));
        locate(arrayMain,"Zu");
        ArrayList<Phonebook> arraySelective  = sortS(arrayMain);
        ArrayList<Phonebook> arrayMerge  = sortM(arrayMain);
        System.out.println(sortCheck(arrayMain));
        System.out.println(sortCheck(arraySelective));
        System.out.println(sortCheck(arrayMerge));
        sortTimer(arrayMain);
        }

    public static ArrayList<Phonebook> processFile(File filename) throws IOException {
        ArrayList<Phonebook> phoneBook = new ArrayList<>();
        String line;
        FileReader file = new FileReader(filename);
        BufferedReader reader = new BufferedReader(file);
        while ((line = reader.readLine()) != null) {
            String[] lineP = line.split(" ");
            Phonebook add = new Phonebook(lineP[0], lineP[1], lineP[2]);
            phoneBook.add(add);
        }
        file.close();
        return phoneBook;

    }

    public static void locate(ArrayList<Phonebook> array, String query) throws IOException {
        FileWriter in = new FileWriter("Output.txt");
        for (Phonebook person : array) {
            if (person.getFname().contains(query) || person.getLname().contains(query)) {
                String person1 = (person.getpNum() + " " + person.getLname() + " " + person.getFname());
                in.write(person1 + "\n");
            }
        }
        in.close();
    }

    public static ArrayList<Phonebook> sortS(ArrayList<Phonebook> array) {
        ArrayList<Phonebook> arrayClone = (ArrayList<Phonebook>) array.clone();
        ArrayList<Phonebook> arraySorted = new ArrayList<>(array.size());
        for (int i = 0; i < array.size(); i++) {
            Phonebook compareS = arrayClone.get(0);
            for (int j = 1; j < arrayClone.size(); j++) {
                if (compareS.getLname().compareToIgnoreCase(arrayClone.get(j).getLname()) > 0) {
                    compareS = arrayClone.get(j);
                }
                else if ((compareS.getLname().compareToIgnoreCase(arrayClone.get(j).getLname()) == 0)) {
                    if (compareS.getFname().compareToIgnoreCase(arrayClone.get(j).getFname()) > 0) {
                        compareS = arrayClone.get(j);
                    }
                }
            }
            arraySorted.add(compareS);
            arrayClone.remove(compareS);
        }
        return arraySorted;
    }
    public static ArrayList<Phonebook> sortM(ArrayList<Phonebook> array) {
        ArrayList<Phonebook> arrayClone = (ArrayList<Phonebook>) array.clone();
        ArrayList<Phonebook> l = new ArrayList<>();
        ArrayList<Phonebook> r = new ArrayList<>();

        int c = 0;
        if (arrayClone.size() == 1) {
            return arrayClone;
        } else {
            c = arrayClone.size()/2;
            for (int i=0; i<c; i++) {
                l.add(arrayClone.get(i));
                r.add(arrayClone.get(i+c));
            }
            l=sortM(l);
            r=sortM(r);

            mergerizer(l, r, arrayClone);
        }
        return arrayClone;
    }
    public static void mergerizer(ArrayList<Phonebook> l, ArrayList<Phonebook> r, ArrayList<Phonebook> arrayClone) {
        int lIndex=0;
        int rIndex=0;
        int arrayIndex=0;
        while (rIndex < r.size() && lIndex < l.size()) {
            if ( (r.get(rIndex).getLname().compareToIgnoreCase((l.get(lIndex).getLname())) < 0)) {
                arrayClone.set(arrayIndex, r.get(rIndex));
                rIndex++;
            }
            else {
                arrayClone.set(arrayIndex, l.get(lIndex));
                lIndex++;
            }
            arrayIndex++;
        }
        ArrayList<Phonebook> remainder;
        int remIndex = 0;
        if (lIndex >= l.size()) {
            remainder = r;
            remIndex = rIndex;
        }
        else {
            remainder = l;
            remIndex = lIndex;
        }
        for (int i=remIndex; i<remainder.size(); i++) {
            arrayClone.set(arrayIndex, remainder.get(i));
            arrayIndex++;
        }
    }

    public static boolean sortCheck(ArrayList<Phonebook> sortedArray){
        String a = sortedArray.get(0).getLname();
        int numErrors = 0;
        for (int i=0;i<sortedArray.size();i++){
            if (a.compareToIgnoreCase(sortedArray.get(i).getLname()) > 0){
                numErrors++;
            }
        }
        if (numErrors>0){
            return false;
        }
        else {
            return true;
        }
    }
    public static void sortTimer(ArrayList<Phonebook> array){
        double start = System.currentTimeMillis();
        sortS(array);
        double end = System.currentTimeMillis();

        double time1 = end - start;
        System.out.println("Selection Sort Time Elapsed: "+ time1/1000);

        start = System.currentTimeMillis();
        sortM(array);
        end = System.currentTimeMillis();
        double time2 = end - start;
        System.out.println("Merge Sort Time Elapsed: "+ time2/1000);
    }
}

