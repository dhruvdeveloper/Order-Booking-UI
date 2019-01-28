import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class mainloginfile {

    private JFrame frameforlogin;
    private JTextField tl1;
    private JTextField tl2;

    /**
     * Create the application.
     */
    public mainloginfile() {
        initialize();
    }

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    mainloginfile window = new mainloginfile();
                    window.frameforlogin.setVisible(true);
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
        frameforlogin = new JFrame();
        frameforlogin.getContentPane().setBackground(new Color(244, 164, 96));
        frameforlogin.getContentPane().setForeground(new Color(0, 0, 128));
        frameforlogin.setBounds(100, 100, 617, 496);
        frameforlogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameforlogin.getContentPane().setLayout(null);

        JPanel panelforlogin = new JPanel();
        panelforlogin.setBackground(new Color(173, 216, 230));
        panelforlogin.setBounds(98, 97, 411, 305);
        frameforlogin.getContentPane().add(panelforlogin);
        panelforlogin.setLayout(null);

        JLabel ll1 = new JLabel("here it is..");
        ll1.setFont(new Font("Tahoma", Font.BOLD, 15));
        ll1.setBounds(66, 245, 175, 28);
        panelforlogin.add(ll1);

        JLabel lblNewLabel = new JLabel("Enter UserName :");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel.setForeground(new Color(0, 0, 128));
        lblNewLabel.setBounds(31, 42, 134, 28);
        panelforlogin.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Enter Password :");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_1.setForeground(new Color(0, 0, 128));
        lblNewLabel_1.setBounds(31, 109, 134, 14);
        panelforlogin.add(lblNewLabel_1);

        tl1 = new JTextField();
        tl1.setBounds(175, 48, 188, 20);
        panelforlogin.add(tl1);
        tl1.setColumns(10);

        tl2 = new JTextField();
        tl2.setBounds(175, 108, 188, 20);
        panelforlogin.add(tl2);
        tl2.setColumns(10);

        JButton btnConfirm = new JButton("Press Confirm");
        btnConfirm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                try {
                    FileReader fr = new FileReader("signup.txt");
                    FileWriter fw = new FileWriter("signup.txt", true);
                    BufferedReader br = new BufferedReader(fr);
                    int temps = 0;
                    String s = null;
                    String ss1 = tl1.getText();
                    String ss2 = tl2.getText();
                    while ((s = br.readLine()) != null) {
                        String words[] = s.split(" ");
                        if ((words[0].equals(ss1)) == true) {
                            if ((words[1].equals(ss2)) == true) {
                                temps = 5;
                            }
                        }
                    }
                    if ((temps == 5)) {
                        ll1.setText("yeah! you got Entry!");
                    } else {
                        tl1.setText(null);
                        tl2.setText(null);
                        ll1.setText("opps! you not got Entry!");
                    }
                    br.close();
                    fw.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
        });
        btnConfirm.setForeground(new Color(100, 149, 237));
        btnConfirm.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnConfirm.setBounds(134, 201, 134, 23);
        panelforlogin.add(btnConfirm);


        JLabel lblYeahWeGet = new JLabel("yeah we get in!! Now You are in Login Field!!");
        lblYeahWeGet.setForeground(new Color(0, 0, 128));
        lblYeahWeGet.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblYeahWeGet.setBackground(SystemColor.menu);
        lblYeahWeGet.setBounds(137, 32, 332, 26);
        frameforlogin.getContentPane().add(lblYeahWeGet);
    }
}
