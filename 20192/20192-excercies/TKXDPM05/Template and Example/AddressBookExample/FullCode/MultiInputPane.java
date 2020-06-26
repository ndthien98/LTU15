/*
 * Decompiled with CFR 0_115.
 */
import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MultiInputPane
extends JOptionPane {
    private JTextField[] fields;
    private boolean ok;

    public static String[] showMultiInputDialog(Component component, String[] arrstring, String[] arrstring2, String string) {
        MultiInputPane multiInputPane = new MultiInputPane(arrstring, arrstring2);
        JDialog jDialog = multiInputPane.createDialog(component, string != null ? string : "MultiInputPane");
        jDialog.pack();
        jDialog.show();
        if (!multiInputPane.ok) {
            return null;
        }
        String[] arrstring3 = new String[arrstring.length];
        for (int i = 0; i < arrstring.length; ++i) {
            arrstring3[i] = multiInputPane.fields[i].getText();
        }
        return arrstring3;
    }

    public static String[] showMultiInputDialog(Component component, String[] arrstring, String string) {
        return MultiInputPane.showMultiInputDialog(component, arrstring, null, string);
    }

    public static String[] showMultiInputDialog(Component component, String[] arrstring, String[] arrstring2) {
        return MultiInputPane.showMultiInputDialog(component, arrstring, arrstring2, null);
    }

    public static String[] showMultiInputDialog(Component component, String[] arrstring) {
        return MultiInputPane.showMultiInputDialog(component, arrstring, null, null);
    }

    private MultiInputPane(String[] arrstring, String[] arrstring2) {
        this.removeAll();
        this.setLayout(new GridLayout(arrstring.length + 1, 2, 5, 5));
        this.fields = new JTextField[arrstring.length];
        for (int i = 0; i < arrstring.length; ++i) {
            this.add(new JLabel(arrstring[i]));
            this.fields[i] = new JTextField();
            this.add(this.fields[i]);
            if (arrstring2 == null || arrstring2[i] == null) continue;
            this.fields[i].setText(arrstring2[i]);
        }
        JPanel jPanel = new JPanel();
        JButton jButton = new JButton("OK");
        jPanel.add(jButton);
        this.add(jPanel);
        JPanel jPanel2 = new JPanel();
        JButton jButton2 = new JButton("Cancel");
        jPanel2.add(jButton2);
        this.add(jPanel2);
        jButton.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent actionEvent) {
                MultiInputPane.this.ok = true;
                MultiInputPane.this.getTopLevelAncestor().setVisible(false);
            }
        });
        jButton2.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent actionEvent) {
                MultiInputPane.this.getTopLevelAncestor().setVisible(false);
            }
        });
    }

}

