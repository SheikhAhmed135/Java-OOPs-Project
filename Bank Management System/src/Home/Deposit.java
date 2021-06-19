package Home;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Deposit {
    private JPanel mainPanel;
    private JTextField amountText;
    private JButton enterButton;

    public Deposit() {
        enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Filer file = new Filer();
                String userDataString = file.read("accountDetails");
                JsonObject userData = new Gson().fromJson(userDataString, JsonObject.class);
                System.out.println(userData.entrySet());
            }
        });
    }

    void deposit(boolean visible) {
        JFrame frame = new JFrame("Deposit");
        frame.setContentPane(new Deposit().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 375);
        frame.pack();
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(visible);
    }
}
