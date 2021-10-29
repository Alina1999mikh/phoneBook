import org.junit.Test;
import sample.Model.subscriber.NameType;
import sample.Model.subscriber.PhoneType;
import sample.Model.subscriber.Subscriber;
import sample.exeption.DataException;
import sample.exeption.storage.ExistStorageException;
import sample.phoneBook.entity.PhoneBookEntity;

import java.math.BigInteger;

import static org.junit.Assert.assertThrows;

public class TestPhoneBookEntity {
    PhoneBookEntity book = new PhoneBookEntity();

    public TestPhoneBookEntity() throws DataException {
    }

    @Test
    public void testFind() throws DataException {
        book.find(new NameType("Alena", "Kim"));
        book.find(new PhoneType(BigInteger.valueOf(8937465)));
        book.find(new NameType("Alena", null));
        book.find(new NameType(null, "Kim"));
        assertThrows(DataException.class, () -> book.find(new NameType(null, null)));
    }

    @Test
    public void testAdd() throws DataException {
        book.add(new Subscriber(new NameType("Alena", "Kim"), new PhoneType(BigInteger.valueOf(1000000))));
        assertThrows(DataException.class, () -> book.add(new Subscriber(new NameType("Alena", "Kim"), new PhoneType(BigInteger.valueOf(56)))));
        assertThrows(ExistStorageException.class, () -> book.add(new Subscriber(new NameType("Alena", "Kim"), new PhoneType(BigInteger.valueOf(1000000)))));
    }

    @Test
    public void testEdit() throws DataException {
        book.edit(new Subscriber(new NameType("Alena", "Kim"), new PhoneType(BigInteger.valueOf(8937465))), new Subscriber(new NameType("Alena", "Test"), new PhoneType(BigInteger.valueOf(8937465))));
    }

    @Test
    public void testRemove() throws DataException {
        book.remove(new Subscriber(new NameType("Alena", "Test"), new PhoneType(BigInteger.valueOf(8937465))));
    }
}