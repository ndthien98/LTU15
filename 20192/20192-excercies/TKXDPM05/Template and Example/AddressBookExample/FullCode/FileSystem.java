/*
 * Decompiled with CFR 0_115.
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class FileSystem {
    public AddressBook readFile(File file) throws IOException, ClassCastException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
        AddressBook addressBook = (AddressBook)objectInputStream.readObject();
        addressBook.setChangedSinceLastSave(false);
        addressBook.setFile(file);
        return addressBook;
    }

    public void saveFile(AddressBook addressBook, File file) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
        objectOutputStream.writeObject(addressBook);
        addressBook.setChangedSinceLastSave(false);
        addressBook.setFile(file);
    }
}

