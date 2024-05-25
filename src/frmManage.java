import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class frmManage extends JFrame{
    private static frmManage instance;
    private JPanel uni;
    private JLabel UNIVERSITYPLATFORMMAGANEMENTLabel;

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
