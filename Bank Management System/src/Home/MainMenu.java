package Home;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MainMenu {
    private JPanel mainPanel;
    private JButton accDetailsBtn;
    private JButton transHistoryBtn;
    private JButton withdrawCashBtn;
    private JButton depositCashBtn;
    private JButton logoutButton;

    public MainMenu() {
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
    }

    public void mainMenu(boolean visible) {
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
