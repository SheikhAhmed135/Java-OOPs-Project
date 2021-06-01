package Home;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm {
    private JPanel MainPanel;
    private JPanel LoginPanel;
    private JTextField emailText;
    private JPasswordField passwordField1;
    private JLabel icon2;
    private JLabel icon1;
    private JLabel email;
    private JLabel password;
    private JButton loginButton;
    private JCheckBox showPasswordCheckBox;


    public LoginForm() {
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = "user@gmail.com";
                String pass = "123";
                String ps = new String(passwordField1.getPassword());
                if ((emailText.getText().equals(email)) && (ps.equals(pass))) {
                    JOptionPane.showMessageDialog(null, "Login Successful");
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid email or password!");
                }
            }
        });
        showPasswordCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (showPasswordCheckBox.isSelected()) {
                    passwordField1.setEchoChar((char) 0);
                } else {
                    passwordField1.setEchoChar('*');
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("LOGIN");
        frame.setContentPane(new LoginForm().MainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 375);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setResizable(false); // maximize button disable
        frame.setVisible(true);
    }
}