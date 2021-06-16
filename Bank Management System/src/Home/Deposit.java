package Home;

import javax.swing.*;

public class Deposit {
    private JPanel mainPanel;
    private JTextField amountText;
    private JButton enterButton;

    void deposit(boolean visible) {
        JFrame frame = new JFrame();
        frame.setContentPane(new Deposit().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 375);
        frame.pack();
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(visible);
    }
}
