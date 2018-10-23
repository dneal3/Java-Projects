import java.util.Arrays;

public class OccurrenceSetTest {
    public static void main(String[]args){
        OccurrenceSet<Integer> intSet = new OccurrenceSet<>();
        intSet.add(1);
        intSet.add(3);
        intSet.add(5);
        intSet.add(5);
        intSet.add(3);
        intSet.add(3);
        intSet.add(1);
        System.out.println(intSet.toString());

        OccurrenceSet<String> stringSet = new OccurrenceSet<>();
        stringSet.add("hello");
        stringSet.add("hello");
        stringSet.add("world");
        stringSet.add("world");
        stringSet.add("world");
        stringSet.add("here");
        System.out.print(stringSet.toString());
    }
}
