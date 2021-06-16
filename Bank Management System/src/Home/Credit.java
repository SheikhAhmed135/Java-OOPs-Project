package Home;

import javax.swing.*;

public class Credit {
    private JPanel mainPanel;
    private JTextField textField1;
    private JButton enterButton;

    void credit(boolean visible) {
        JFrame frame = new JFrame();
        frame.setContentPane(new Credit().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 375);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(visible);
    }
}
