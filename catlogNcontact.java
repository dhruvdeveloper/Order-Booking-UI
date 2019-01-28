import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class catlogNcontact {

    public JFrame frameofcatlog;

    /**
     * Create the application.
     */
    public catlogNcontact() {
        initialize();
    }

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    catlogNcontact window = new catlogNcontact();
                    window.frameofcatlog.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Initialize the contents of the frame.
     */
    public void initialize() {
        frameofcatlog = new JFrame();
        frameofcatlog.setFont(new Font("Dialog", Font.BOLD, 16));
        frameofcatlog.setTitle("Login");
        frameofcatlog.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Swaminarayan\\Desktop\\Untitled.png"));
        frameofcatlog.getContentPane().setBackground(new Color(255, 248, 220));
        frameofcatlog.setBounds(400, 100, 789, 655);
        frameofcatlog.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameofcatlog.getContentPane().setLayout(null);

        JEditorPane tm1 = new JEditorPane();
        tm1.setEditable(false);
        tm1.setText("click on button!!");
        tm1.setBackground(new Color(255, 248, 220));
        tm1.setFont(new Font("Tahoma", Font.PLAIN, 22));
        tm1.setForeground(new Color(0, 0, 128));
        tm1.setBounds(79, 162, 622, 420);
        frameofcatlog.getContentPane().add(tm1);

        JButton btnNewButton = new JButton("Contact");
        frameofcatlog.getRootPane().setDefaultButton(btnNewButton);
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tm1.setText("Shree swaminarayan agency"
                        + "\nAdress:6/Jyoti Jalaram Socity, Jivrajpark, Ahmedabad - 380015"
                        + "\nContact Number : 9879007662"
                        + "\nEmail-id : dktthakkar@gmail.com"
                        + "\nDHANANJAY THAKKAR");
            }
        });
        btnNewButton.setForeground(new Color(128, 0, 128));
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnNewButton.setBounds(79, 59, 173, 43);
        frameofcatlog.getContentPane().add(btnNewButton);

        JButton btnNewButton_1 = new JButton("Catalog");
        frameofcatlog.getRootPane().setDefaultButton(btnNewButton_1);
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tm1.setText("1 132801 SHERGRIP SINK BRUSH 69.00"
                        + "\n2 132746 C.KITCHEN MOPPY 65.00"
                        + "\n3 132763 HEXA BIG 90.00"
                        + "\n4 132788 PLUNGER MEDIUM 70.00"
                        + "\n5 132748 C.KWICK N EAZEE 50.00"
                        + "\n6 148993 SPONGE WIPE 41.00"
                        + "\n7 148994 SPONGE WIPE COMBI SET (3PCS) 109.00"
                        + "\n8 148995 SPONGE WIPE COMBI SET (5PCS) 169.00"
                        + "\n9 132761 FRIDGE JAR CLEANER 80.00"
                        + "\n10 132823 TOILEX WITH SQUARE CONT 175.00"
                        + "\n11 132822 TOILEX WITH ROUNDY CONT. 199.00");
            }
        });
        btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnNewButton_1.setForeground(new Color(0, 128, 128));
        btnNewButton_1.setBounds(306, 59, 173, 43);
        frameofcatlog.getContentPane().add(btnNewButton_1);

        JButton btnNewButton_3 = new JButton("Order");
        frameofcatlog.getRootPane().setDefaultButton(btnNewButton_3);
        btnNewButton_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                orderlist ol = new orderlist();
                frameofcatlog.setVisible(false);
                ol.frmPlaceYourOrder.setVisible(true);
            }
        });
        btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 16));
        btnNewButton_3.setForeground(new Color(0, 100, 0));
        btnNewButton_3.setBounds(528, 59, 173, 43);
        frameofcatlog.getContentPane().add(btnNewButton_3);

        JMenuBar menuBar = new JMenuBar();
        frameofcatlog.setJMenuBar(menuBar);

        JMenu mnNewMenu_1 = new JMenu("     complaint");
        mnNewMenu_1.setForeground(new Color(0, 0, 0));
        mnNewMenu_1.setFont(new Font("Segoe UI", Font.BOLD, 12));
        menuBar.add(mnNewMenu_1);

        JMenu mnReport = new JMenu("Report");
        mnNewMenu_1.add(mnReport);

        JMenuItem mntmNewMenuItem_1 = new JMenuItem("on compny");
        mntmNewMenuItem_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                complaintoncompany c = new complaintoncompany();
                c.frame.setVisible(true);

            }
        });
        mnReport.add(mntmNewMenuItem_1);

        JMenuItem mntmNewMenuItem_2 = new JMenuItem("on distributer");
        mntmNewMenuItem_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                complaint c = new complaint();
                c.frame.setVisible(true);

            }
        });
        mnReport.add(mntmNewMenuItem_2);

        JMenuItem mntmLogout = new JMenuItem("                                                                                                                                                                                                               Logout");
        mntmLogout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                logout l1 = new logout();
                frameofcatlog.dispose();
                l1.frame.setVisible(true);
            }
        });
        mntmLogout.setFont(new Font("Segoe UI", Font.BOLD, 11));
        menuBar.add(mntmLogout);
    }
}