/*
 * Decompiled with CFR 0_115.
 */
import javax.swing.JApplet;

public class AddressBookApplet
extends JApplet {
    public void init() {
        FileSystem fileSystem = new FileSystem();
        AddressBookController addressBookController = new AddressBookController(fileSystem);
        AddressBookGUI addressBookGUI = new AddressBookGUI(addressBookController, new AddressBook());
        addressBookGUI.show();
    }
}

