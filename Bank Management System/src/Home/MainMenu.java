package Home;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
                accountDetails.accountDetail(true);
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
