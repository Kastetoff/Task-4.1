public class Person {
    private final String NAME;
    private final String SURNAME;
    private int age;
    private final int MIN_AGE = 0;
    private final int MAX_AGE = 130; //допустим, что дольше не живут ;(
    private boolean knownAge;
    private String address;

    public Person(String name, String surname, int age, String address) {
        this.NAME = name;
        this.SURNAME = surname;
        if (age >= MIN_AGE && age <= MAX_AGE) {
            this.age = age;
            knownAge = true;
            this.address = address;
        }
    }

    public Person(String name, String surname) {
        this.NAME = name;
        this.SURNAME = surname;
    }

    public Person(String name, String surname, int age) {
        this.NAME = name;
        this.SURNAME = surname;
        if (age >= MIN_AGE && age <= MAX_AGE) {
            this.age = age;
            knownAge = true;
        } else {
            throw new IllegalArgumentException("Неверно указан возраст");
        }
    }

    public Person(String name, String surname, String address) {
        this.NAME = name;
        this.SURNAME = surname;
        this.address = address;
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder()
                .setSurname(SURNAME)
                .setAddress(address);
    }

    public String getName() {
        return NAME;
    }

    public String getSurname() {
        return SURNAME;
    }

    public int getAge() {
        if (hasAge()) {
            return age;
        } else {
            System.out.println("Возраст неизвестен");
            return 0;
        }
    }

    public String getAddress() {
        return address;
    }

    public void setAge(int age) {
        if (!hasAge()) {
            this.age = age;
        } else throw new IllegalArgumentException("Возраст уже не изменить!");
    }

    public boolean hasAge() {
        return knownAge && age >= 0;
    }

    public void happyBirthday() {
        if (knownAge) {
            age++;
            System.out.println(String.format("%s %s, с Днём рождения!", this.getName(), this.getSurname()));
        } else {
            System.out.println("Возраст неизвестен");
        }
    }

    public boolean hasAddress() {
        return address != null;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "Name = '" + NAME + '\'' +
                ", Surname = '" + SURNAME + '\'' +
                ", Age = " + age +
                ", Address = '" + address + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
