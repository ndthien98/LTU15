/*
 * Decompiled with CFR 0_115.
 */
import java.io.File;
import java.io.PrintStream;
import java.io.Serializable;
import java.util.Collections;
import java.util.Observable;
import java.util.Vector;

public class AddressBook
extends Observable
implements Serializable {
    private Vector collection = new Vector();
    private transient File file = null;
    private transient boolean changedSinceLastSave = false;

    public int getNumberOfPersons() {
        return this.collection.size();
    }

    public void addPerson(String string, String string2, String string3, String string4, String string5, String string6, String string7) {
        this.collection.addElement(new Person(string, string2, string3, string4, string5, string6, string7));
        this.setChangedSinceLastSave(true);
    }

    public String getFullNameOfPerson(int n) {
        Person person = (Person)this.collection.elementAt(n);
        return person.getFirstName() + " " + person.getLastName();
    }

    public String[] getOtherPersonInformation(int n) {
        Person person = (Person)this.collection.elementAt(n);
        String[] arrstring = new String[]{person.getAddress(), person.getCity(), person.getState(), person.getZip(), person.getPhone()};
        return arrstring;
    }

    public void updatePerson(int n, String string, String string2, String string3, String string4, String string5) {
        ((Person)this.collection.elementAt(n)).update(string, string2, string3, string4, string5);
        this.setChangedSinceLastSave(true);
    }

    public void removePerson(int n) {
        this.collection.removeElementAt(n);
        this.setChangedSinceLastSave(true);
    }

    public void sortByName() {
        Collections.sort(this.collection, new Person.CompareByName());
        this.setChangedSinceLastSave(true);
    }

    public void sortByZip() {
        Collections.sort(this.collection, new Person.CompareByZip());
        this.setChangedSinceLastSave(true);
    }

    public void printAll() {
        for (int i = 0; i < this.collection.size(); ++i) {
            Person person = (Person)this.collection.elementAt(i);
            System.out.println(person.getFirstName() + " " + person.getLastName());
            System.out.println(person.getAddress());
            System.out.println(person.getCity() + " " + person.getState() + " " + person.getZip());
            System.out.println(person.getPhone());
            System.out.println();
        }
    }

    public File getFile() {
        return this.file;
    }

    public String getTitle() {
        if (this.file == null) {
            return "Untitled";
        }
        return this.file.getName();
    }

    public void setFile(File file) {
        this.file = file;
        this.setChanged();
        this.notifyObservers();
    }

    public boolean getChangedSinceLastSave() {
        return this.changedSinceLastSave;
    }

    public void setChangedSinceLastSave(boolean bl) {
        this.changedSinceLastSave = bl;
        this.setChanged();
        this.notifyObservers();
    }

    void setupTests() {
        this.addPerson("Anthony", "Aardvark", "10 Skunk Hollow Lane", "Wenham", "MA", "01984", "927-2300");
        this.addPerson("Zelda", "Zebra", "5 Zoo Road", "Beverly", "MA", "01915", "927-0001");
        this.addPerson("George", "Gopher", "Tunnel 37", "Hamilton", "MA", "01936", "468-5555");
        this.addPerson("Clarence", "Cat", "127 Litter Box Ln", "Ipswich", "MA", "01938", "356-9999");
        this.addPerson("Charlene", "Cat", "127 Litter Box Ln", "Ipswich", "MA", "01938", "356-9999");
        this.addPerson("Boris", "Buffalo", "Town Common", "Hamilton", "MA", "01936", "468-5555");
        this.addPerson("Bertha", "Buffalo", "14 Grassy Fields Rd", "Wenham", "MA", "01984", "927-2300");
    }
}

