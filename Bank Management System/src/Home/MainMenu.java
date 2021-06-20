package Home;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.IOException;

public class MainMenu {
    private JPanel mainPanel;
    private JButton accDetailsBtn;
    private JButton transHistoryBtn;
    private JButton withdrawCashBtn;
    private JButton depositCashBtn;
    private JButton logoutButton;
    private JTextField amount;
    private JTextField id;
    private JTextField username;

    public MainMenu() {
        id.setEnabled(true);
        id.setEditable(false);
        username.setEnabled(true);
        username.setEditable(false);
        amount.setEnabled(true);
        amount.setEditable(false);

        Filer filer = new Filer();
        String fileData = filer.read("accountDetails");
        JsonObject accountData = new Gson().fromJson(fileData, JsonObject.class);
        id.setText(accountData.get("Id").toString().replaceAll("^\"|\"$", ""));
        username.setText(accountData.get("username").toString().replaceAll("^\"|\"$", ""));
        amount.setText(accountData.get("amount").toString().replaceAll("^\"|\"$", ""));

        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        accDetailsBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AccountDetails accountDetails = new AccountDetails();
                try {
                    accountDetails.accountDetail(true);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
        depositCashBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Deposit deposit = new Deposit();
                deposit.deposit(true);
            }
        });
        withdrawCashBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Credit credit = new Credit();
                credit.credit(true);
            }
        });
        transHistoryBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TransactionLog transactionLog = new TransactionLog();
                transactionLog.transactionView(true);
            }
        });
    }

    public void mainMenu(boolean visible) {
        try {
            FileReader file = new FileReader("./src/Data/accountDetails.txt");
            int data;
            StringBuilder fileData = new StringBuilder();
            while ((data=file.read()) !=-1) {
                fileData.append((char) data);
            }
            if (!fileData.isEmpty()) {
//                Gson gson = new Gson();
                String stringData = fileData.toString();
                JsonObject accountDetails = new Gson().fromJson(stringData, JsonObject.class);
                id.setText(accountDetails.get("Id").toString());
                username.setText(accountDetails.get("username").toString());
            }
            file.close();

        } catch (IOException exception) {
            exception.printStackTrace();
        }
        JFrame mainMenu = new JFrame("Main Menu");
        mainMenu.setContentPane(new MainMenu().mainPanel);
        mainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainMenu.setSize(400, 375);
        mainMenu.pack();
        mainMenu.setLocationRelativeTo(null);
        mainMenu.setResizable(false); // maximize button disable
        mainMenu.setVisible(visible);
    }
}
