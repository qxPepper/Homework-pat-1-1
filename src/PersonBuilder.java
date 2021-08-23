public class PersonBuilder {
    protected String name;
    protected String surname;
    protected int age;
    protected boolean knownAge;
    protected String address;

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        this.age = age;
        knownAge = true;
        return this;
    }

    public PersonBuilder setKnownAge(boolean knownAge) {
        this.knownAge = knownAge;
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() {
        Person person = new Person(name, surname, age, address);
        person.knownAge = knownAge;

        if ((name == null) || (surname == null)) {
            throw new IllegalStateException("Не хватает обязательных полей.");
        }

        if (age < 0) {
            throw new IllegalArgumentException("Возраст недопустимый.");
        }

        if ((person.hasAge()) && (person.hasAddress())) {
            return person;
        } else if ((person.hasAge()) && (!person.hasAddress())) {
            return new Person(name, surname, age);
        } else if ((!person.hasAge()) && (person.hasAddress())) {
            return new Person(name, surname, address);
        } else {
            return new Person(name, surname);
        }
    }
}
