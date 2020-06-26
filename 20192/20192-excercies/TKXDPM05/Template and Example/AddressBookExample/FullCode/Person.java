/*
 * Decompiled with CFR 0_115.
 */
import java.io.Serializable;
import java.util.Comparator;

public class Person
implements Serializable {
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String phone;

    public Person(String string, String string2, String string3, String string4, String string5, String string6, String string7) {
        this.firstName = string;
        this.lastName = string2;
        this.address = string3;
        this.city = string4;
        this.state = string5;
        this.zip = string6;
        this.phone = string7;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getAddress() {
        return this.address;
    }

    public String getCity() {
        return this.city;
    }

    public String getState() {
        return this.state;
    }

    public String getZip() {
        return this.zip;
    }

    public String getPhone() {
        return this.phone;
    }

    public void update(String string, String string2, String string3, String string4, String string5) {
        this.address = string;
        this.city = string2;
        this.state = string3;
        this.zip = string4;
        this.phone = string5;
    }

    public static class CompareByZip
    implements Comparator {
        public int compare(Object object, Object object2) {
            int n = ((Person)object).getZip().compareTo(((Person)object2).getZip());
            if (n != 0) {
                return n;
            }
            return new CompareByName().compare(object, object2);
        }

        public boolean equals(Object object, Object object2) {
            return this.compare(object, object2) == 0;
        }
    }

    public static class CompareByName
    implements Comparator {
        public int compare(Object object, Object object2) {
            int n = ((Person)object).getLastName().compareTo(((Person)object2).getLastName());
            if (n != 0) {
                return n;
            }
            return ((Person)object).getFirstName().compareTo(((Person)object2).getFirstName());
        }

        public boolean equals(Object object, Object object2) {
            return this.compare(object, object2) == 0;
        }
    }

}

