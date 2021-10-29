package sample.phoneBook.entity;

import com.google.common.collect.Multimap;
import com.google.common.collect.TreeMultimap;
import sample.Model.subscriber.AbstractType;
import sample.Model.subscriber.NameType;
import sample.Model.subscriber.Subscriber;
import sample.exeption.DataException;
import sample.exeption.storage.ExistStorageException;
import sample.phoneBook.tools.Find;
import sample.phoneBook.tools.PrintMultiMap;
import sample.sqlHelper.Config;

import java.util.Collection;
import java.util.Comparator;

public class PhoneBookEntity implements Comparator<Subscriber>, PhoneBook {
    private static final Config INSTANCE = new Config();
    Multimap<NameType, Subscriber> entity = TreeMultimap.create();

    public PhoneBookEntity() throws DataException {
        entity.putAll(INSTANCE.getStorage().getAllSorted());
    }

    @Override
    public int compare(Subscriber s1, Subscriber s2) {
        return s1.compareTo(s2);
    }

    public void add(Subscriber s) throws DataException {
        if (!isExist(s)) entity.put(s.getName(), s);
        else throw new ExistStorageException(s);
    }

    @Override
    public void remove(Subscriber s) {
        entity.remove(s.getName(), s);
    }

    @Override
    public void clear() throws DataException {
        INSTANCE.getStorage().clear();
        entity.clear();
    }

    @Override
    public void edit(Subscriber old, Subscriber replacement) {
        remove(old);
        entity.put(replacement.getName(), replacement);
    }

    @Override
    public void save() throws DataException {
        INSTANCE.getStorage().save(entity);
    }

    @Override
    public <T extends AbstractType> Collection<Subscriber> find(T value) throws DataException {
        Find f = new Find(entity);
        return f.find(value);
    }

    @Override
    public String toString() {
        return PrintMultiMap.multiMapToString(entity);
    }

    private boolean isExist(Subscriber s) throws DataException {
        Collection<Subscriber> values = new Find(entity).find(s.getName());
        for (Subscriber v : values)
            if (v.equals(s))
                return true;
        return false;
    }
}