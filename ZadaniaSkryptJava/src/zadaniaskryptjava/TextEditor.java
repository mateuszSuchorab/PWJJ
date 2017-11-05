package zadaniaskryptjava;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class TextEditor {

    String text;

    public TextEditor(String text) {
        this.text = text;

    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void saveToFile() throws FileNotFoundException, IOException {

        OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream("plik.txt"), StandardCharsets.UTF_8);
        out.write(text);
        out.close();
    }
}
