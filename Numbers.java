import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Numbers {

    public JFrame frame;

    /**
     * Create the application.
     */
    public Numbers() {
        initialize();
    }

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Numbers window = new Numbers();
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
        frame.setTitle("city's distributer");
        frame.getContentPane().setBackground(new Color(47, 79, 79));
        frame.getContentPane().setForeground(new Color(211, 211, 211));
        frame.setBounds(750, 350, 818, 314);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JTextArea txtrDasdasdasd = new JTextArea();
        txtrDasdasdasd.setBackground(new Color(211, 211, 211));
        txtrDasdasdasd.setEditable(false);
        txtrDasdasdasd.setFont(new Font("Monospaced", Font.BOLD, 13));
        txtrDasdasdasd.setForeground(new Color(47, 79, 79));
        txtrDasdasdasd.setText("   \r\n    125-b Shivalik tower, SG-Road, satellite, Ahmedabad, Gujarat-380015\r\n    Phone-number : 840215-21241\r\n    fax-number : AZ-4574-C-454\r\n\r\n    Name : Dhruv Thakkar");
        txtrDasdasdasd.setBounds(80, 48, 616, 127);
        frame.getContentPane().add(txtrDasdasdasd);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(47, 79, 79));
        panel.setBounds(281, 208, 178, 57);
        frame.getContentPane().add(panel);
        panel.setLayout(null);

        JButton button = new JButton("okay");
        frame.getRootPane().setDefaultButton(button);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
            }
        });
        button.setBounds(30, 5, 138, 41);
        button.setForeground(new Color(47, 79, 79));
        button.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(button);
    }

}
