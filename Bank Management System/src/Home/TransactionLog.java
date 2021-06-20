package Home;

import javax.swing.*;

public class TransactionLog {
    private JPanel mainPanel;
    private JLabel accountTitle;
    private JTextPane logs;
    private JButton backButton;

    public TransactionLog() {
        logs.setEnabled(true);
        logs.setEditable(false);
        Filer filer = new Filer();
        String data = filer.read("transactionLogs");
        logs.setText(data);
        backButton.addActionListener(e -> {
            MainMenu mainMenu = new MainMenu();
            mainMenu.mainMenu(true);
        });
    }

    public void transactionView(boolean visible) {
        JFrame log = new JFrame("Transaction Logs");
        log.setContentPane(new TransactionLog().mainPanel);
        log.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        log.setSize(600, 600);
        log.pack();
        log.setLocationRelativeTo(null);
//        log.setResizable(false);
        log.setVisible(visible);
    }
}
