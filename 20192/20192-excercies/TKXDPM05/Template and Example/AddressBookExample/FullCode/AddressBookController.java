/*
 * Decompiled with CFR 0_115.
 */
import java.awt.Component;
import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class AddressBookController {
    private FileSystem fileSystem;

    public AddressBookController(FileSystem fileSystem) {
        this.fileSystem = fileSystem;
    }

    public void doAdd(AddressBookGUI addressBookGUI) {
        String[] arrstring = new String[]{"First Name", "Last Name", "Address", "City", "State", "ZIP", "Phone"};
        String[] arrstring2 = MultiInputPane.showMultiInputDialog((Component)addressBookGUI, arrstring, "Person to add");
        if (arrstring2 != null) {
            addressBookGUI.getAddressBook().addPerson(arrstring2[0], arrstring2[1], arrstring2[2], arrstring2[3], arrstring2[4], arrstring2[5], arrstring2[6]);
        }
    }

    public void doEdit(AddressBookGUI addressBookGUI, int n) {
        String string = addressBookGUI.getAddressBook().getFullNameOfPerson(n);
        String[] arrstring = new String[]{"Address", "City", "State", "ZIP", "Phone"};
        String[] arrstring2 = addressBookGUI.getAddressBook().getOtherPersonInformation(n);
        String[] arrstring3 = MultiInputPane.showMultiInputDialog(addressBookGUI, arrstring, arrstring2, "Edit " + string);
        if (arrstring3 != null) {
            addressBookGUI.getAddressBook().updatePerson(n, arrstring3[0], arrstring3[1], arrstring3[2], arrstring3[3], arrstring3[4]);
        }
    }

    public void doDelete(AddressBookGUI addressBookGUI, int n) {
        String string = addressBookGUI.getAddressBook().getFullNameOfPerson(n);
        if (JOptionPane.showConfirmDialog(addressBookGUI, "Are you sure you want to delete " + string + "?", "Confirm delete", 0) == 0) {
            addressBookGUI.getAddressBook().removePerson(n);
        }
    }

    public void doSortByName(AddressBookGUI addressBookGUI) {
        addressBookGUI.getAddressBook().sortByName();
    }

    public void doSortByZip(AddressBookGUI addressBookGUI) {
        addressBookGUI.getAddressBook().sortByZip();
    }

    public void doPrint(AddressBookGUI addressBookGUI) {
        addressBookGUI.getAddressBook().printAll();
    }

    public void doNew(AddressBookGUI addressBookGUI) {
        addressBookGUI.setAddressBook(new AddressBook());
    }

    public void doOpen(AddressBookGUI addressBookGUI) throws IOException, ClassCastException, ClassNotFoundException, InterruptedException, SecurityException {
        JFileChooser jFileChooser = new JFileChooser(System.getProperty("user.dir"));
        if (jFileChooser.showOpenDialog(addressBookGUI) != 0) {
            throw new InterruptedException("Cancelled by user");
        }
        File file = jFileChooser.getSelectedFile();
        addressBookGUI.setAddressBook(this.fileSystem.readFile(file));
    }

    public void doSave(AddressBookGUI addressBookGUI) throws IOException, InterruptedException, SecurityException {
        File file = addressBookGUI.getAddressBook().getFile();
        if (file == null) {
            this.doSaveAs(addressBookGUI);
        } else {
            this.fileSystem.saveFile(addressBookGUI.getAddressBook(), file);
        }
    }

    public void doSaveAs(AddressBookGUI addressBookGUI) throws IOException, InterruptedException, SecurityException {
        JFileChooser jFileChooser = new JFileChooser(System.getProperty("user.dir"));
        if (jFileChooser.showSaveDialog(addressBookGUI) != 0) {
            throw new InterruptedException("Cancelled by user");
        }
        File file = jFileChooser.getSelectedFile();
        this.fileSystem.saveFile(addressBookGUI.getAddressBook(), file);
    }

    public void doOfferSaveChanges(AddressBookGUI addressBookGUI) throws InterruptedException, IOException, SecurityException {
        int n = JOptionPane.showConfirmDialog(addressBookGUI, "There are unsaved changes.  Save them?", "Save changes", 1);
        switch (n) {
            case 1: {
                break;
            }
            case 0: {
                this.doSave(addressBookGUI);
                break;
            }
            default: {
                throw new InterruptedException("Cancelled by user");
            }
        }
    }
}

