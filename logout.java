import javax.swing.*;
import java.awt.*;


public class logout {

    public JFrame frame;

    /**
     * Create the application.
     */
    public logout() {
        initialize();
    }

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    logout window = new logout();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Yash\\Desktop\\Untitled.png"));
        frame.setTitle("Good Bye");
        frame.getContentPane().setBackground(new Color(176, 224, 230));
        frame.getContentPane().setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(176, 224, 230));
        panel.setBounds(10, 11, 815, 120);
        frame.getContentPane().add(panel);

        JTextArea txtrThanksForVisiting = new JTextArea();
        txtrThanksForVisiting.setFont(new Font("Monospaced", Font.BOLD, 15));
        txtrThanksForVisiting.setBackground(new Color(176, 224, 230));
        txtrThanksForVisiting.setText("\r\n\r\n\r\nThanks for visiting..!! You are successfully Logout!!");
        panel.add(txtrThanksForVisiting);

        JLabel lblthakkardhruv_1 = new JLabel("@thakkardhruv");
        lblthakkardhruv_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
        lblthakkardhruv_1.setForeground(new Color(0, 0, 128));
        lblthakkardhruv_1.setBounds(726, 194, 109, 21);
        frame.getContentPane().add(lblthakkardhruv_1);
        frame.setBounds(350, 250, 851, 264);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
