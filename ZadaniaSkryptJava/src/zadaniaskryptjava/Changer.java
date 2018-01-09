package zadaniaskryptjava;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Changer extends Thread {

    JTextArea window;
    volatile boolean end;

    public Changer(JTextArea comp) {
        window = comp;
        end = false;
    }

    public void run() {
        while (!end) {
            try {
                String text = window.getText();
                int indeks = text.indexOf("{");
                if (indeks >= 0) {
                    window.replaceRange("begin", indeks, indeks + 1);
                    window.setCaretPosition(text.length() + 4);
                } else {
                    indeks = text.indexOf("}");
                    if (indeks >= 0) {
                        window.replaceRange("end", indeks, indeks + 1);
                        window.setCaretPosition(text.length() + 2);
                    }
                }
                String newText = text;
                newText = newText.toLowerCase();
                if (newText.matches(".*(cholera)+.*")) {
                    JOptionPane.showMessageDialog(null, "dsada");
                }

                sleep(2000);
            } catch (Exception e) {
            }
        }
    }
}
