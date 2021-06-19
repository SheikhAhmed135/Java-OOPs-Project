package Home;

import com.google.gson.JsonObject;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MainApplication {
    public static void main(String[] args) {
        LoginForm login = new LoginForm();
        login.loginPage(true);
    }
}
