package Home;

import com.google.gson.Gson;

import java.io.FileReader;
import java.io.FileWriter;

public class Filer {
    //    private FileReader file;
//    void read(String name) {
//        try {
//             file = new FileReader("./Data/"+name);
//        } catch (java.io.FileNotFoundException e) {
//            System.out.println("File not found!");
//            e.printStackTrace();
//        }
//    }

    void write(String name) {
        try {
            FileWriter file = new FileWriter("./src/Data/" + name);
            Gson gson = new Gson();
//            String json = gson.toJson();
//            System.out.println(json);
            file.close();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
}
