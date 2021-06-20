package Home;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
    private JButton backButton;

    public AccountDetails() {
        id.setEnabled(true);
        id.setEditable(false);
        username.setEnabled(true);
        username.setEditable(false);
        address.setEnabled(true);
        address.setEditable(false);
        gender.setEnabled(true);
        gender.setEditable(false);
        nationality.setEnabled(true);
        nationality.setEditable(false);
        dob.setEnabled(true);
        dob.setEditable(false);
        doc.setEnabled(true);
        doc.setEditable(false);

        Filer filer = new Filer();
        String fileData = filer.read("accountDetails");
        JsonObject accountData = new Gson().fromJson(fileData, JsonObject.class);
        id.setText(accountData.get("Id").toString().replaceAll("^\"|\"$", ""));
        username.setText(accountData.get("username").toString().replaceAll("^\"|\"$", ""));
        address.setText(accountData.get("address").toString().replaceAll("^\"|\"$", ""));
        gender.setSelectedIndex(Integer.parseInt(accountData.get("gender").toString().replaceAll("^\"|\"$", "")));
        nationality.setText(accountData.get("nationality").toString().replaceAll("^\"|\"$", ""));
        dob.setText(accountData.get("dob").toString().replaceAll("^\"|\"$", ""));
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        doc.setText(dtf.format(now));
        gender.setEnabled(false);

        editDetails.addActionListener(e -> {
            id.setEnabled(true);
            id.setEditable(true);
            username.setEnabled(true);
            username.setEditable(true);
            address.setEnabled(true);
            address.setEditable(true);
            gender.setEnabled(true);
            nationality.setEnabled(true);
            nationality.setEditable(true);
            dob.setEnabled(true);
            dob.setEditable(true);
            saveButton.setEnabled(true);
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
        saveButton.addActionListener(e -> {
            try {
                FileWriter file = new FileWriter("./src/Data/accountDetails.txt");
                Gson gson = new Gson();
                Map<String, String> data = new HashMap<>();
                data.put("Id", id.getText());
                data.put("username", username.getText());
                data.put("address", address.getText());
                data.put("gender", "" + gender.getSelectedIndex());
                data.put("nationality", nationality.getText());
                data.put("dob", dob.getText());
                data.put("doc", doc.getText());
                data.put("amount", "0");
                String json = gson.toJson(data);
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
                JOptionPane.showMessageDialog(null, "Data is saved successfully");
            } catch (IOException ep) {
                ep.printStackTrace();
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
        backButton.addActionListener(e -> {
            MainMenu mainMenu = new MainMenu();
            mainMenu.mainMenu(true);
        });
    }

    public void accountDetail(boolean visible) throws IOException {
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
