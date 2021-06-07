package Home;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccountDetails {
    private JPanel mainPanel;
    private JTextField id;
    private JTextField username;
    private JTextField address;
    private JTextField gender;
    private JTextField nationality;
    private JTextField dob;
    private JTextField doc;
    private JButton editDetails;

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
            }
        });
    }

    public void accountDetail(boolean visible) {
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
