import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frmMain extends JFrame{
    private static frmMain instance;
    private JTextField textField1;
    private JButton EXECUTEButton;
    private JTable table1;
    private JLabel lblQuery;
    private JScrollPane scrollPanel;
    private JPanel big_panel;
    private frmMain() {
        // Initialize the JFrame
        setContentPane(big_panel);
        setTitle("Explorer"); // Set the title of the window
        setSize(800, 600); // Set the size of the window (width, height)
        setLocationRelativeTo(null); // Center the window on the screen
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // Exit the application when the window is closed

        // Add action listener to the button
        EXECUTEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EXECUTEButton.setEnabled(false);
                if (textField1.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(
                            null,
                            "Query cannot be empty.",
                            "Warning",
                            JOptionPane.WARNING_MESSAGE
                    );
                    EXECUTEButton.setEnabled(true);
                    return;
                }
                SwingWorker<Void, Void> worker = new SwingWorker<>() {
                    @Override
                    protected Void doInBackground() {
                        ConnectSQL.showQuery(textField1.getText(), table1);
                        return null;
                    }

                    @Override
                    protected void done() {
                        EXECUTEButton.setEnabled(true);
                    }
                };
                worker.execute();
            }
        });
    }

    public static synchronized frmMain getInstance() {
        if (instance == null) {
            synchronized (frmMain.class) {
                if (instance == null) {
                    instance = new frmMain();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                frmMain.getInstance().setVisible(true);
            }
        });
    }
}
