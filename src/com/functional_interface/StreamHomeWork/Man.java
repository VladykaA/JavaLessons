package com.functional_interface.StreamHomeWork;

public class Man {
    private String firstName;
    private String lastName;
    private int age;
    private int kids;
    private Address address;

    public Man(String firstName, String lastName, int age, int kids, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.kids = kids;
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getKids() {
        return kids;
    }

    public void setKids(int kids) {
        this.kids = kids;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Man{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", kids=" + kids +
                ", address=" + address +
                '}';
    }
}
