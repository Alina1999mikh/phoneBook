package sample.phoneBook.entity;

import sample.Model.subscriber.AbstractType;
import sample.Model.subscriber.Subscriber;
import sample.exeption.DataException;

import java.util.Collection;

public interface PhoneBook {
    void add(Subscriber s) throws DataException;

    void remove(Subscriber s);

    void clear() throws DataException;

    void save() throws DataException;

    void edit(Subscriber s1, Subscriber s2);

    <T extends AbstractType> Collection<Subscriber> find(T value) throws DataException;
}
