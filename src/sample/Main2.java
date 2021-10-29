package sample;

import sample.Model.subscriber.NameType;
import sample.Model.subscriber.PhoneType;
import sample.exeption.DataException;
import sample.phoneBook.entity.PhoneBookEntity;

import java.math.BigInteger;

public class Main2 {
    public static void main(String[] args) throws DataException {
        PhoneBookEntity book = new PhoneBookEntity();
        book.save();
        System.out.println("1     " + book.find(new NameType("Alena", "Kim")));
        System.out.println("2     " + book.find(new PhoneType(BigInteger.valueOf(8937465))));
        System.out.println("3     " + book.find(new NameType("Alena", null)));
        System.out.println("4     " + book.find(new NameType(null, "Kim")));
    }
}