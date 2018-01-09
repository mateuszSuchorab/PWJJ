package zadaniaskryptjava;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class NewJFrame extends JFrame {

    private JScrollPane jScrollPane1;
    private JTextArea jTextArea1;
    private Changer thread;

    public NewJFrame() {
        initComponents();
        setSize(350, 250);
        thread = new Changer(jTextArea1);
        thread.start();
    }

    private void initComponents() {
        jScrollPane1 = new JScrollPane();
        jTextArea1 = new JTextArea();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        jTextArea1.setPreferredSize(new Dimension(300, 200));
        jScrollPane1.setViewportView(jTextArea1);
        getContentPane().add(jScrollPane1, BorderLayout.CENTER);
        pack();
    }

    private void formWindowClosing(WindowEvent evt) {
        thread.end = true;
        thread = null;
    }
}
