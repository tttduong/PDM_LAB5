import javax.swing.*;

public class frmManage extends JFrame{
    private static frmManage instance;
    private JPanel big_panel;
    private JLabel UNIVERSITYPLATFORMMAGANEMENTLabel;
    private JButton ADDSTUDENTButton;
    private JButton DELETEATTENDANCERECORDButton;
    private JButton ADDSUBJECTButton;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JButton QUERYSTUDENTSIDButton1;
    private JTextField textField1;
    private JButton ADDLESSONButton;


    private frmManage() {
        // Initialize the JFrame
        setContentPane(big_panel);
        setTitle("PDM Lab 6"); // Set the title of the window
        setSize(800, 500); // Set the size of the window (width, height)
        setLocationRelativeTo(null); // Center the window on the screen
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // Exit the application when the window is closed

//        // Add action listener to the button
//        EXECUTEButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                EXECUTEButton.setEnabled(false);
//                if (textField1.getText().trim().isEmpty()) {
//                    JOptionPane.showMessageDialog(
//                            null,
//                            "Query cannot be empty.",
//                            "Warning",
//                            JOptionPane.WARNING_MESSAGE
//                    );
//                    EXECUTEButton.setEnabled(true);
//                    return;
//                }
//                SwingWorker<Void, Void> worker = new SwingWorker<>() {
//                    @Override
//                    protected Void doInBackground() {
//                        ConnectSQL.showQuery(textField1.getText(), table1);
//                        return null;
//                    }
//
//                    @Override
//                    protected void done() {
//                        EXECUTEButton.setEnabled(true);
//                    }
//                };
//                worker.execute();
//            }
//        });
    }
    public static synchronized frmManage getInstance() {
        if (instance == null) {
            synchronized (frmMain.class) {
                if (instance == null) {
                    instance = new frmManage();
                }
            }
        }
        return instance;
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                frmManage.getInstance().setVisible(true);
            }
        });
    }


}
