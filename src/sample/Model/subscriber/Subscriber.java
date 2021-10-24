package sample.Model.subscriber;

import lombok.Data;
import sample.exeption.DataException;

import java.math.BigInteger;
import java.util.Objects;

@Data
public class Subscriber implements Comparable<Subscriber> {
    private NameType name;
    private PhoneType phone;

    public Subscriber(NameType name, PhoneType phone) {
        this.name = name;
        this.phone = phone;
    }

    Subscriber(String name, String phone) throws DataException {
        this.name = new NameType(name, name);
        this.phone = new PhoneType(BigInteger.valueOf(Long.parseLong(phone)));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subscriber that = (Subscriber) o;
        return Objects.equals(name, that.name) && Objects.equals(phone, that.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, phone);
    }

    @Override
    public int compareTo(Subscriber o) {
        if (this.getName().compareTo(o.getName()) > 0) return 1;
        else if (this.getName().compareTo(o.getName()) < 0) return -1;
        else {
            return this.phone.compareTo(o.phone);
        }
    }

    public NameType getName() {
        return name;
    }

    public void setName(NameType name) {
        this.name = name;
    }

    public PhoneType getPhone() {
        return phone;
    }

    public void setPhone(PhoneType phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return name + " " + phone + "\n";
    }
}
