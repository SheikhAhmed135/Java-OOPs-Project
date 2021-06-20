package Home;

import java.io.FileReader;
import java.io.IOException;

public class Filer {
    String read(String name) {
        try {
            FileReader file = new FileReader("./src/Data/" + name + ".txt");
            int data;
            StringBuilder fileData = new StringBuilder();
            while ((data = file.read()) != -1) {
                fileData.append((char) data);
            }
            return fileData.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

}
