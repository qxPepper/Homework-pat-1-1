import java.util.Objects;
import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    protected int age;
    protected boolean knownAge;
    protected String address;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public Person(String name, String surname, String address) {
        this.name = name;
        this.surname = surname;
        this.address = address;
    }

    public Person(String name, String surname, int age, String address) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.address = address;
    }

    public boolean hasAge() {
        return getAge() != OptionalInt.empty();
    }

    public boolean hasAddress() {
        return address != null;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public OptionalInt getAge() {
        if (age == 0 && !knownAge) {
            return OptionalInt.empty();
        } else {
            return OptionalInt.of(age);
        }
    }

    public boolean getKnownAge() {
        return knownAge;
    }

    public String getAddress() {
        return address;
    }

    public void happyBirthday() {
        if (hasAge()) {
            age++;
        }
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder()
                .setSurname(getSurname())
                .setAge(0)
                .setKnownAge(true)
                .setAddress(getAddress());
    }

    @Override
    public String toString() {
        String result = "name='" + name + "'" + ", surname='" + surname + "'";

        if ((hasAge()) && (!hasAddress())) {
            result = result + ", age='" + age + "'";
        } else if ((!hasAge()) && (hasAddress())) {
            result = result + ", address='" + address + "'";
        } else if ((hasAge()) && (hasAddress())) {
            result = result + ", age='" + age + "'" + ", address='" + address + "'";
        }

        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return name.equals(person.name) && surname.equals(person.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname);
    }
}