package zadaniaskryptjava;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class GzipCompression {

    public static void compress() {
        byte[] buffer = new byte[1024];
        try {
            FileInputStream in = new FileInputStream("fileToGzip.txt");
            GZIPOutputStream gzos = new GZIPOutputStream(new FileOutputStream("fileToGzip.gz"));
            int length;
            while ((length = in.read(buffer)) > 0) {
                gzos.write(buffer, 0, length);
            }
            in.close();
            gzos.finish();
            gzos.close();
        } catch (IOException db) {
            System.out.println("Error while compression!");
        }
    }

    public static void decompress() {
        byte[] buffer = new byte[1024];
        try {
            GZIPInputStream in = new GZIPInputStream(new FileInputStream("fileToGzip.gz"));
            FileOutputStream fout = new FileOutputStream("gzipFile.txt");
            int length;
            while((length = in.read(buffer)) != -1){
                fout.write(buffer, 0, length);
            }
            //close resources
            fout.close();
            in.close();
        } catch (IOException db) {
            System.out.println("Error while compression!");
        }
    }
}
