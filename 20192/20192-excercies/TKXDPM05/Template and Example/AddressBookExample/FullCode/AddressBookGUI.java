/*
 * Decompiled with CFR 0_115.
 */
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Frame;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import javax.swing.AbstractListModel;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListModel;
import javax.swing.border.Border;

public class AddressBookGUI
extends JFrame
implements Observer {
    private NameListModel nameListModel;
    private JList nameList;
    private JButton addButton;
    private JButton editButton;
    private JButton deleteButton;
    private JButton sortByNameButton;
    private JButton sortByZipButton;
    private JMenuItem newItem;
    private JMenuItem openItem;
    private JMenuItem saveItem;
    private JMenuItem saveAsItem;
    private JMenuItem printItem;
    private JMenuItem quitItem;
    private AddressBookController controller;
    private AddressBook addressBook;

    public AddressBookGUI(final AddressBookController addressBookController, AddressBook addressBook) {
        this.controller = addressBookController;
        JMenuBar jMenuBar = new JMenuBar();
        JMenu jMenu = new JMenu("File");
        this.newItem = new JMenuItem("New", 78);
        jMenu.add(this.newItem);
        this.openItem = new JMenuItem("Open...", 79);
        jMenu.add(this.openItem);
        jMenu.addSeparator();
        this.saveItem = new JMenuItem("Save", 83);
        jMenu.add(this.saveItem);
        this.saveAsItem = new JMenuItem("Save As...");
        jMenu.add(this.saveAsItem);
        jMenu.addSeparator();
        this.printItem = new JMenuItem("Print", 80);
        jMenu.add(this.printItem);
        jMenu.addSeparator();
        this.quitItem = new JMenuItem("Quit", 81);
        jMenu.add(this.quitItem);
        jMenuBar.add(jMenu);
        this.setJMenuBar(jMenuBar);
        this.nameListModel = new NameListModel();
        this.setAddressBook(addressBook);
        this.nameList = new JList(this.nameListModel);
        JScrollPane jScrollPane = new JScrollPane(this.nameList);
        this.nameList.setVisibleRowCount(10);
        jScrollPane.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10), BorderFactory.createLineBorder(Color.gray, 1)));
        this.getContentPane().add((Component)jScrollPane, "Center");
        JPanel jPanel = new JPanel();
        this.addButton = new JButton("     Add    ");
        jPanel.add(this.addButton);
        this.editButton = new JButton("    Edit    ");
        jPanel.add(this.editButton);
        this.deleteButton = new JButton("   Delete   ");
        jPanel.add(this.deleteButton);
        this.sortByNameButton = new JButton("Sort by name");
        jPanel.add(this.sortByNameButton);
        this.sortByZipButton = new JButton("Sort by ZIP ");
        jPanel.add(this.sortByZipButton);
        jPanel.setBorder(BorderFactory.createEmptyBorder(5, 10, 10, 10));
        this.getContentPane().add((Component)jPanel, "South");
        this.addButton.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent actionEvent) {
                addressBookController.doAdd(AddressBookGUI.this);
                int n = AddressBookGUI.this.getAddressBook().getNumberOfPersons() - 1;
                AddressBookGUI.this.nameList.ensureIndexIsVisible(n);
            }
        });
        this.editButton.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent actionEvent) {
                int n = AddressBookGUI.this.nameList.getSelectedIndex();
                if (n < 0) {
                    AddressBookGUI.this.reportError("You must select a person");
                } else {
                    addressBookController.doEdit(AddressBookGUI.this, n);
                }
            }
        });
        this.deleteButton.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent actionEvent) {
                int n = AddressBookGUI.this.nameList.getSelectedIndex();
                if (n < 0) {
                    AddressBookGUI.this.reportError("You must select a person");
                } else {
                    addressBookController.doDelete(AddressBookGUI.this, n);
                }
            }
        });
        this.sortByNameButton.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent actionEvent) {
                addressBookController.doSortByName(AddressBookGUI.this);
            }
        });
        this.sortByZipButton.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent actionEvent) {
                addressBookController.doSortByZip(AddressBookGUI.this);
            }
        });
        this.newItem.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    if (AddressBookGUI.this.getAddressBook().getChangedSinceLastSave()) {
                        addressBookController.doOfferSaveChanges(AddressBookGUI.this);
                    }
                    addressBookController.doNew(AddressBookGUI.this);
                }
                catch (IOException var2_2) {
                    AddressBookGUI.this.reportError("Problem writing the file: " + var2_2);
                }
                catch (InterruptedException var2_3) {
                }
                catch (SecurityException var2_4) {
                    AddressBookGUI.this.reportError("Operation disallowed: " + var2_4);
                }
            }
        });
        this.openItem.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    if (AddressBookGUI.this.getAddressBook().getChangedSinceLastSave()) {
                        addressBookController.doOfferSaveChanges(AddressBookGUI.this);
                    }
                    addressBookController.doOpen(AddressBookGUI.this);
                }
                catch (IOException var2_2) {
                    AddressBookGUI.this.reportError("Problem reading or writing the file: " + var2_2);
                }
                catch (InterruptedException var2_3) {
                }
                catch (SecurityException var2_4) {
                    AddressBookGUI.this.reportError("Operation disallowed: " + var2_4);
                }
                catch (Exception var2_5) {
                    AddressBookGUI.this.reportError("This file did not contain an address book");
                }
            }
        });
        this.saveItem.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    addressBookController.doSave(AddressBookGUI.this);
                }
                catch (IOException var2_2) {
                    AddressBookGUI.this.reportError("Problem writing the file: " + var2_2);
                }
                catch (InterruptedException var2_3) {
                }
                catch (SecurityException var2_4) {
                    AddressBookGUI.this.reportError("Operation disallowed: " + var2_4);
                }
            }
        });
        this.saveAsItem.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    addressBookController.doSaveAs(AddressBookGUI.this);
                }
                catch (IOException var2_2) {
                    AddressBookGUI.this.reportError("Problem writing the file: " + var2_2);
                }
                catch (InterruptedException var2_3) {
                }
                catch (SecurityException var2_4) {
                    AddressBookGUI.this.reportError("Operation disallowed: " + var2_4);
                }
            }
        });
        this.printItem.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent actionEvent) {
                addressBookController.doPrint(AddressBookGUI.this);
            }
        });
        this.quitItem.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent actionEvent) {
                AddressBookApplication.quitApplication();
            }
        });
        this.setDefaultCloseOperation(0);
        this.addWindowListener(new WindowAdapter(){

            public void windowClosing(WindowEvent windowEvent) {
                try {
                    if (AddressBookGUI.this.getAddressBook().getChangedSinceLastSave()) {
                        addressBookController.doOfferSaveChanges(AddressBookGUI.this);
                    }
                    AddressBookGUI.this.dispose();
                    if (Frame.getFrames().length == 0) {
                        AddressBookApplication.quitApplication();
                    }
                }
                catch (IOException var2_2) {
                    AddressBookGUI.this.reportError("Problem writing the file: " + var2_2);
                }
                catch (InterruptedException var2_3) {
                }
                catch (SecurityException var2_4) {
                    AddressBookGUI.this.reportError("Operation disallowed: " + var2_4);
                }
            }
        });
        this.nameList.addMouseListener(new MouseAdapter(){

            public void mouseClicked(MouseEvent mouseEvent) {
                if (mouseEvent.getClickCount() == 2) {
                    int n = AddressBookGUI.this.nameList.locationToIndex(mouseEvent.getPoint());
                    addressBookController.doEdit(AddressBookGUI.this, n);
                }
            }
        });
        this.pack();
    }

    public AddressBook getAddressBook() {
        return this.addressBook;
    }

    public void setAddressBook(AddressBook addressBook) {
        if (this.addressBook != null) {
            this.addressBook.deleteObserver(this);
        }
        this.addressBook = addressBook;
        addressBook.addObserver(this);
        this.update(addressBook, null);
    }

    public void reportError(String string) {
        JOptionPane.showMessageDialog(this, string, "Error message", 0);
    }

    public void update(Observable observable, Object object) {
        if (observable == this.addressBook) {
            this.setTitle(this.addressBook.getTitle());
            this.saveItem.setEnabled(this.addressBook.getChangedSinceLastSave());
            this.nameListModel.contentsChanged();
        }
    }

    private class NameListModel
    extends AbstractListModel {
        private NameListModel() {
        }

        void contentsChanged() {
            super.fireContentsChanged(this, 0, 0);
        }

        public Object getElementAt(int n) {
            return AddressBookGUI.this.getAddressBook().getFullNameOfPerson(n);
        }

        public int getSize() {
            return AddressBookGUI.this.getAddressBook().getNumberOfPersons();
        }
    }

}

