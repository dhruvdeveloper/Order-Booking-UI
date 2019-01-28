import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class mainsignupfile {

    static String name = "";
    public JFrame frmSignupPage;
    public JFrame frameforlogin;
    catlogNcontact c1 = new catlogNcontact();
    JPanel panel;
    JLabel l1;
    String ss2 = "";
    String ss1 = "";
    private JTextField t1;
    private JTextField tl1;
    private JTextField tl2;
    private JPasswordField t2;

    /**
     * Create the application.
     */
    public mainsignupfile() {
        initialize();
    }

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    mainsignupfile window = new mainsignupfile();
                    window.frmSignupPage.setVisible(true);
                    window.frameforlogin.setVisible(false);
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
        frmSignupPage = new JFrame();
        frmSignupPage.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Swaminarayan\\Desktop\\Untitled.png"));
        frmSignupPage.setForeground(new Color(255, 255, 0));
        frmSignupPage.setFont(new Font("Dialog", Font.BOLD, 12));
        frmSignupPage.setTitle("Signup page!");
        frmSignupPage.getContentPane().setBackground(new Color(47, 79, 79));
        frmSignupPage.getContentPane().setForeground(new Color(253, 245, 230));
        frmSignupPage.setBounds(300, 80, 880, 724);
        frmSignupPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmSignupPage.getContentPane().setLayout(null);

        panel = new JPanel();
        panel.setForeground(new Color(47, 79, 79));
        panel.setBackground(new Color(230, 230, 250));
        panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, new Color(95, 158, 160), new Color(95, 158, 160), new Color(95, 158, 160), new Color(95, 158, 160)));
        panel.setBounds(165, 248, 491, 404);
        frmSignupPage.getContentPane().add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel_1 = new JLabel("Signup");
        lblNewLabel_1.setForeground(new Color(47, 79, 79));
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 17));
        lblNewLabel_1.setBounds(205, 11, 173, 43);
        panel.add(lblNewLabel_1);

        JLabel lblEnterUserName = new JLabel("Enter User name :");
        lblEnterUserName.setForeground(new Color(47, 79, 79));
        lblEnterUserName.setBackground(new Color(169, 169, 169));
        lblEnterUserName.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblEnterUserName.setBounds(45, 82, 173, 29);
        panel.add(lblEnterUserName);

        t1 = new JTextField();
        t1.setBounds(248, 88, 184, 20);
        panel.add(t1);
        t1.setColumns(10);

        JLabel lblEnterPassword = new JLabel("Enter Password :");
        lblEnterPassword.setForeground(new Color(47, 79, 79));
        lblEnterPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblEnterPassword.setBounds(45, 144, 173, 36);
        panel.add(lblEnterPassword);

        l1 = new JLabel("Here it is...");
        l1.setForeground(new Color(47, 79, 79));
        l1.setFont(new Font("Tahoma", Font.BOLD, 14));
        l1.setBounds(45, 295, 333, 43);
        panel.add(l1);

        JButton btnConfirm = new JButton("confirm");

        btnConfirm.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnConfirm.setForeground(new Color(47, 79, 79));
        btnConfirm.setBounds(170, 233, 156, 43);
        panel.add(btnConfirm);


        t2 = new JPasswordField();
        t2.setBounds(248, 154, 184, 20);
        panel.add(t2);

        btnConfirm.addActionListener(new handler());

        JLabel lable1 = new JLabel("Welcome to Swaminarayan Agency");
        lable1.setBackground(new Color(250, 240, 230));
        lable1.setLabelFor(frmSignupPage);
        lable1.setForeground(new Color(255, 215, 0));
        lable1.setVerticalAlignment(SwingConstants.TOP);
        lable1.setBorder(new LineBorder(new Color(0, 0, 0), 0, true));
        lable1.setFont(new Font("Palatino Linotype", Font.BOLD, 42));
        lable1.setBounds(80, 41, 751, 83);
        //panel.add(lable1);
        frmSignupPage.getContentPane().add(lable1);

        JButton btnNewButton = new JButton("Login\r\n");

        btnNewButton.setBackground(new Color(47, 79, 79));

        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frmSignupPage.setVisible(false);
                frameforlogin.setVisible(true);
            }
        });

        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnNewButton.setForeground(new Color(255, 255, 0));
        btnNewButton.setBounds(533, 139, 169, 56);
        frmSignupPage.getContentPane().add(btnNewButton);

        JLabel lblNewLabel_2 = new JLabel("click this button if you have already account...");
        lblNewLabel_2.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 18));
        lblNewLabel_2.setForeground(new Color(240, 230, 140));
        lblNewLabel_2.setBounds(95, 148, 428, 36);
        frmSignupPage.getContentPane().add(lblNewLabel_2);

        frameforlogin = new JFrame();
        frameforlogin.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Swaminarayan\\Desktop\\Untitled.png"));
        frameforlogin.getContentPane().setBackground(new Color(244, 164, 96));
        frameforlogin.getContentPane().setForeground(new Color(0, 0, 128));
        frameforlogin.setBounds(500, 150, 617, 496);
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

        JLabel lablog1 = new JLabel("Enter Password :");
        lablog1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lablog1.setForeground(new Color(0, 0, 128));
        lablog1.setBounds(31, 109, 134, 14);
        panelforlogin.add(lablog1);

        tl1 = new JTextField();
        tl1.setBounds(175, 48, 188, 20);
        panelforlogin.add(tl1);
        tl1.setColumns(10);

        tl2 = new JPasswordField();
        tl2.setBounds(175, 108, 188, 20);
        panelforlogin.add(tl2);
        tl2.setColumns(10);

        JButton btnlogin = new JButton("Press Confirm");
        frameforlogin.getRootPane().setDefaultButton(btnlogin);
        btnlogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                try {
                    FileReader fr = new FileReader("signup.txt");
                    FileWriter fw = new FileWriter("signup.txt", true);
                    BufferedReader br = new BufferedReader(fr);
                    int temps = 0;
                    String s = null;
                    ss1 = tl1.getText();
                    ss2 = tl2.getText();
                    name = ss1;
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

                        frameforlogin.setVisible(false);
                        c1.frameofcatlog.setVisible(true);
                    } else {
                        tl1.setText(null);
                        tl2.setText(null);
                        ll1.setText("opps! you not got Entry!");
                        tl1.requestFocusInWindow();
                    }
                    br.close();
                    fw.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
        });
        btnlogin.setForeground(new Color(100, 149, 237));
        btnlogin.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnlogin.setBounds(134, 201, 134, 23);
        panelforlogin.add(btnlogin);


        JLabel lblYeahWeGet = new JLabel("yeah we get in!! Now You are in Login Field!!");
        lblYeahWeGet.setForeground(new Color(0, 0, 128));
        lblYeahWeGet.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblYeahWeGet.setBackground(SystemColor.menu);
        lblYeahWeGet.setBounds(137, 32, 332, 26);
        frameforlogin.getContentPane().add(lblYeahWeGet);
    }


    class handler implements ActionListener {


        @Override
        public void actionPerformed(ActionEvent arg0) {
            // TODO Auto-generated method stub
            try {

                FileReader fr = new FileReader("signup.txt");
                FileWriter fw = new FileWriter("signup.txt", true);
                BufferedReader br = new BufferedReader(fr);
                int temps = 0;
                String s = null;
                String ss1 = t1.getText();
                @SuppressWarnings("deprecation")
                String ss2 = t2.getText();
                while ((s = br.readLine()) != null) {
                    String words[] = s.split(" ");
                    if ((words[0].equals(ss1)) == true) {
                        temps = 5;
                    }
                }
                if ((temps != 5)) {
                    fw.write("\r\n");
                    fw.write(ss1 + " " + ss2);
                    l1.setText("yeah! you got Entry!");

                    frmSignupPage.setVisible(false);
                    frameforlogin.setVisible(true);
                } else {
                    t1.setText(null);
                    t2.setText(null);
                    l1.setText("this username has already in!! try another...!!");
                    t1.requestFocusInWindow();
                }
                //btnConfirm

                br.close();
                fw.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}