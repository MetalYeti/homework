package ru.geekbrains.builder;

public class Person {
    private String firstName;
    private String lastName;
    private String middleName;
    private String country;
    private String address;
    private String phone;
    private int age;
    private String gender;

    private Person() {
    }

    public static Builder getBuilder(){
        return new Builder();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getCountry() {
        return country;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", country='" + country + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }

    public static class Builder {
        private final Person person;

        public Builder() {
            this.person = new Person();
        }

        public Builder setFirstName(String firstName) {
            this.person.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {
            this.person.lastName = lastName;
            return this;
        }

        public Builder setMiddleName(String middleName) {
            this.person.middleName = middleName;
            return this;
        }

        public Builder setCountry(String country) {
            this.person.country = country;
            return this;
        }

        public Builder setAddress(String address) {
            this.person.address = address;
            return this;
        }

        public Builder setPhone(String phone) {
            this.person.phone = phone;
            return this;
        }

        public Builder setAge(int age) {
            this.person.age = age;
            return this;
        }

        public Builder setGender(String gender) {
            this.person.gender = gender;
            return this;
        }

        public Person build(){
            return this.person;
        }

    }
}
