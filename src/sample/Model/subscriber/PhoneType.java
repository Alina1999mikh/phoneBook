package sample.Model.subscriber;

import lombok.Data;
import lombok.EqualsAndHashCode;
import sample.exeption.DataException;

import java.math.BigInteger;

@EqualsAndHashCode(callSuper = true)
@Data
public class PhoneType extends AbstractType implements Comparable<PhoneType> {
    private static final int phoneSize = 7;
    private BigInteger phone;

    public PhoneType(BigInteger phone) throws DataException {
        this.phone = phone;
        if (!isCorrect(String.valueOf(phone))) throw new DataException();
    }

    @Override
    boolean isCorrect(String str) {
        return str.length() == phoneSize;
    }

    @Override
    public int compareTo(PhoneType o) {
        return this.phone.compareTo(o.phone);
    }

    @Override
    public String toString() {
        return phone.toString();
    }
}