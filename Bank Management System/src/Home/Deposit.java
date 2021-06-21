package Home;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class Deposit {
    private JPanel mainPanel;
    private JTextField amountText;
    private JButton enterButton;
    private JButton backButton;

    public Deposit() {
        enterButton.addActionListener(e -> {
            if (amountText.getText().isBlank()) {
                JOptionPane.showMessageDialog(null, "No Amount entered");
            } else {
                Filer file = new Filer();
                String userDataString = file.read("accountDetails");
                JsonObject userData = new Gson().fromJson(userDataString, JsonObject.class);
                double amount;
                amount = Double.parseDouble(amountText.getText().replaceAll("^\"|\"$", ""))
                        + Double.parseDouble(userData.get("amount").toString().replaceAll("^\"|\"$", ""));
                try {
                    FileWriter write = new FileWriter("./src/Data/accountDetails.txt");
                    Gson gson = new Gson();
                    Map<String, String> data = new HashMap<>();
                    data.put("Id", userData.get("Id").toString().replaceAll("^\"|\"$", ""));
                    data.put("username", userData.get("username").toString().replaceAll("^\"|\"$", ""));
                    data.put("address", userData.get("address").toString().replaceAll("^\"|\"$", ""));
                    data.put("gender", userData.get("gender").toString().replaceAll("^\"|\"$", ""));
                    data.put("nationality", userData.get("nationality").toString().replaceAll("^\"|\"$", ""));
                    data.put("dob", userData.get("dob").toString().replaceAll("^\"|\"$", ""));
                    data.put("doc", userData.get("doc").toString().replaceAll("^\"|\"$", ""));
                    data.put("amount", "" + amount);
                    String json = gson.toJson(data);
                    write.write(json);
                    write.close();
                } catch (IOException exception) {
                    exception.printStackTrace();
                }
                try {
                    FileWriter logs = new FileWriter("./src/Data/transactionLogs.txt", true);
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm:ss");
                    LocalDateTime now = LocalDateTime.now();
                    String dateTime = dtf.format(now);
                    logs.append("Amount '")
                            .append(amountText.getText())
                            .append("' added to your account ")
                            .append(String.valueOf(userData.get("Id")))
                            .append(" [").append(dateTime).append("] ")
                            .append("\n");
                    logs.close();
                    JOptionPane.showMessageDialog(null, "Amount depositted to your account");
                    MainMenu mainMenu = new MainMenu();
                    mainMenu.mainMenu(true);
                } catch (IOException exception) {
                    exception.printStackTrace();
                }
            }
        });
        amountText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char key = e.getKeyChar();
                if (!Character.isDigit(key)) {
                    e.consume();
                }
            }
        });
        backButton.addActionListener(e -> {
            MainMenu mainMenu = new MainMenu();
            mainMenu.mainMenu(true);
        });
    }

    void deposit() {
        JFrame frame = new JFrame("Deposit");
        frame.setContentPane(new Deposit().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 375);
        frame.pack();
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
