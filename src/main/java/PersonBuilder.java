public class PersonBuilder {
    private String name;
    private String surname;
    private int age;
    private boolean knownAge = false;
    private String address;

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (!knownAge) {
            if (age > -1) {
                this.age = age;
                this.knownAge = true;
                return this;
            } else throw new IllegalArgumentException("Возраст указан неверно");
        } else throw new IllegalArgumentException("Возраст уже не изменить");
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() {
        if (name != null && surname != null) {
            if (knownAge) {
                return new Person(name, surname, age, address);
            }
            return new Person(name, surname, address);
        } else throw new IllegalStateException("Необходимо указать имя и фамилию!");
    }
}
