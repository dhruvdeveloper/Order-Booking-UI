import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class offer {

    public JFrame frame;

    /**
     * Create the application.
     */
    public offer() {
        initialize();
    }

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    offer window = new offer();
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
        frame.setTitle("offer");
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Yash\\Desktop\\Untitled.png"));
        frame.getContentPane().setBackground(new Color(47, 79, 79));
        frame.setBounds(750, 250, 549, 273);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JTextArea txtrOn = new JTextArea();
        txtrOn.setEditable(false);
        txtrOn.setFont(new Font("Monospaced", Font.BOLD, 13));
        txtrOn.setForeground(new Color(47, 79, 79));
        txtrOn.setText("     21 % on Gala Brush's Products.\r\n     25% on Gala Proffesonal products.");
        txtrOn.setBounds(96, 68, 379, 52);
        frame.getContentPane().add(txtrOn);

        JPanel panel = new JPanel();
        panel.setBounds(169, 155, 187, 52);
        frame.getContentPane().add(panel);
        panel.setLayout(null);

        JButton btnNewButton = new JButton("Okay");
        frame.getRootPane().setDefaultButton(btnNewButton);

        btnNewButton.setBounds(0, 0, 187, 52);
        panel.add(btnNewButton);
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                frame.setVisible(false);
            }
        });
        btnNewButton.setForeground(new Color(47, 79, 79));
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
    }

}
