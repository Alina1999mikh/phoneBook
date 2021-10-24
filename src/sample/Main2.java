package sample;

import sample.Model.subscriber.NameType;
import sample.Model.subscriber.PhoneType;
import sample.Model.subscriber.Subscriber;
import sample.exeption.DataException;

import java.math.BigInteger;

public class Main2 {
    public static void main(String[] args) throws DataException {
        MapBook book = new MapBook();
        book.add(new Subscriber(new NameType("Alina", "Mikhaleva"), new PhoneType(BigInteger.valueOf(2705541))));
        book.add(new Subscriber(new NameType("Max", "Dorn"), new PhoneType(BigInteger.valueOf(8907765))));
        System.out.println(book);
        book.remove(new Subscriber(new NameType("Max", "Dorn"), new PhoneType(BigInteger.valueOf(8907765))));
        System.out.println(book);
        book.add(new Subscriber(new NameType("Max", "Dorn"), new PhoneType(BigInteger.valueOf(8907765))));
        book.add(new Subscriber(new NameType("Max7", "Dorn"), new PhoneType(BigInteger.valueOf(8907765))));
        System.out.println(book);


    }
}
