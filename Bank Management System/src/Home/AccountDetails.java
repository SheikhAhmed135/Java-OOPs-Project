package Home;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class AccountDetails {
    private JPanel mainPanel;
    private JTextField id;
    private JTextField username;
    private JTextField address;
    private JComboBox gender;
    private JTextField nationality;
    private JTextField dob;
    private JTextField doc;
    private JButton editDetails;
    private JButton saveButton;

    public AccountDetails() {
        editDetails.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                id.setEnabled(true);
                username.setEnabled(true);
                address.setEnabled(true);
                gender.setEnabled(true);
                nationality.setEnabled(true);
                dob.setEnabled(true);
                doc.setEditable(true);
                saveButton.setEnabled(true);
            }
        });

        id.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char key = e.getKeyChar();
                if (!Character.isDigit(key)) {
                    e.consume();
                }
            }
        });
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    FileWriter file = new FileWriter("./src/Data/accountDetails.txt");
                    Gson gson = new Gson();
                    Map<String, String> data = new HashMap<>();
                    data.put("Id", id.getText());
                    data.put("username", username.getText());
                    data.put("address", address.getText());
                    data.put("gender", gender.getSelectedItem().toString());
                    data.put("nationality", nationality.getText());
                    data.put("dob", dob.getText());
                    data.put("doc", doc.getText());

                    String json = gson.toJson(data);
                    System.out.println(json);
                    file.write(json);
                    file.close();

                    id.setEnabled(false);
                    username.setEnabled(false);
                    address.setEnabled(false);
                    gender.setEnabled(false);
                    nationality.setEnabled(false);
                    dob.setEnabled(false);
                    doc.setEditable(false);
                    saveButton.setEnabled(false);

                } catch (java.io.IOException ep) {
                    ep.printStackTrace();
                }
            }
        });
        username.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char key = e.getKeyChar();
                if (Character.isDigit(key)) {
                    e.consume();
                }
            }
        });
    }

    public void accountDetail(boolean visible) throws IOException {
        try {
            FileReader file = new FileReader("./src/Data/accountDetails.txt");
            int data;
            StringBuilder fileData = new StringBuilder();
            while ((data=file.read()) !=-1) {
                fileData.append((char) data);
            }
            Gson gson = new Gson();
            String stringData = fileData.toString();
            JsonObject convertedObject = new Gson().fromJson(stringData, JsonObject.class);
            System.out.println(convertedObject.get("gender"));
        } catch (java.io.FileNotFoundException ex) {
            ex.printStackTrace();
        }
        JFrame account = new JFrame("Account Details");
        account.setContentPane(new AccountDetails().mainPanel);
        account.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        account.setSize(400, 375);
        account.pack();
        account.setLocationRelativeTo(null);
        account.setResizable(false);
        account.setVisible(visible);
    }
}
