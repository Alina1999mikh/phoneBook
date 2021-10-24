package sample.Model.subscriber;

import lombok.Data;
import sample.exeption.DataException;

import java.util.Objects;
import java.util.regex.Pattern;

@Data
public class NameType extends AbstractType implements Comparable<NameType> {
    private static final String regexName = ("^([a-zA-Z]{2,}\\s[a-zA-Z]{1,}'?-?[a-zA-Z]{2,}\\s?([a-zA-Z]{1,})?)");
    private String firstName;
    private String secondName;

    public NameType(String firstName, String secondName) throws DataException {
        this.firstName = firstName;
        this.secondName = secondName;
        if (!isCorrect(firstName) || !isCorrect(secondName)) throw new DataException();
    }

    @Override
    boolean isCorrect(String str) {
        return Pattern.compile(NameType.regexName).matcher(str).matches();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NameType nameType = (NameType) o;
        return Objects.equals(firstName, nameType.firstName) && Objects.equals(secondName, nameType.secondName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, secondName);
    }

    @Override
    public int compareTo(NameType o) {
        if (this.secondName.compareTo(o.secondName) > 0) return 1;
        else if (this.secondName.compareTo(o.secondName) < 0) return -1;
        else {
            return Integer.compare(this.firstName.compareTo(o.firstName), 0);
        }
    }

    @Override
    public String toString() {
        return firstName + " " + secondName + '\'';
    }
}