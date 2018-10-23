import java.util.*;
// Derrick Neal, Assignment 6, Fall 2017, 17-15-11
// Worked in collaboration with Daniel Loyd and Mariah McRae for the whole of Assignment 6.
public class OccurrenceSet<T> implements Set<T> {
    public HashMap<T,Integer> Hashy = new HashMap<>();

    @Override
    public int size() {
        return Hashy.size();
    }

    @Override
    public boolean isEmpty() {
        return Hashy.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return Hashy.containsKey(o);
    }

    @Override
    public Iterator<T> iterator() {
        return this.iterator();
    }
    // Daniel Loyd, Mariah McRae, and I worked very closely on this one so our code will be very similar.
    @Override
    public Object[] toArray() {
        Set<Map.Entry<T, Integer>> entryset = Hashy.entrySet();
        ArrayList<Map.Entry<T, Integer>> entrylist = new ArrayList<>(entryset);
        Collections.sort(entrylist, new Comparator<Map.Entry<T, Integer>>(){
            @Override
            public int compare(Map.Entry<T, Integer> o1, Map.Entry<T, Integer> o2) {
                if(o1.getValue() == o2.getValue()) {
                    return 0;
                }
                if (o1.getValue() > o2.getValue()) {
                    return 1;
                }
                else {
                    return -1;
                }
            }});
        Object[] SortedA = new Object[entrylist.size()];
        int i =0;
        for (Object o : entrylist){
            String a = o.toString();
            String b = a.split("=")[0];
            SortedA[i] = b;
            i++;
        }
        return SortedA;
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean add(T t) {
        if (Hashy.get(t) != null) {
            int index = Hashy.get(t);
            Hashy.put(t, index + 1);
            return false;
        }
        else {
            Hashy.put(t,1);
            return true;
        }
    }

    @Override
    public boolean remove(Object o) {
        return (Hashy.remove(o,Hashy.get(o)));

    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object i : c) {
            if (!Hashy.containsKey(i)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        int s = Hashy.size();
        for(T item: c){
            this.add(item);
        }
        if (s != Hashy.size()){
            return true;
        }
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        int s = Hashy.size();
        for (Object o: Hashy.keySet()){
            if (!c.contains(o)){
                this.remove(o);
            }
        }
        if (s != Hashy.size()){
            return true;
        }
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        int s = Hashy.size();
        for(Object item: c){
            this.remove(item);
        }
        if (s != Hashy.size()){
            return true;
        }
        return false;
    }

    @Override
    public void clear() {
        Hashy.clear();
    }

    @Override
    public String toString(){
        return Arrays.toString(this.toArray());
    }
}
