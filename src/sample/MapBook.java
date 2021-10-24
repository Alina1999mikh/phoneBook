package sample;

import com.google.common.collect.TreeMultimap;
import sample.Model.subscriber.PhoneType;
import sample.Model.subscriber.Subscriber;

import java.util.Comparator;

public class MapBook implements Comparator<Subscriber> {
    TreeMultimap<PhoneType, Subscriber> base = TreeMultimap.create();

    @Override
    public int compare(Subscriber o1, Subscriber o2) {
        return o1.compareTo(o2);
    }

    public void add(Subscriber s) {
        base.put(s.getPhone(), s);
    }

    public void remove(Subscriber s) {
        base.remove(s.getPhone(), s);
    }

    @Override
    public String toString() {
        return base +
                "\n";
    }
}