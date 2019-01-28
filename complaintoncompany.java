import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class complaintoncompany extends mainsignupfile {

    static int compcount;
    public JFrame frame;

    /**
     * Create the application.
     *
     * @wbp.parser.entryPoint
     */
    public complaintoncompany() {
        initialize();
    }

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    complaint window = new complaint();
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
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Swaminarayan\\Desktop\\Untitled.png"));
        frame.setTitle("complaint on company");
        frame.getContentPane().setBackground(new Color(47, 79, 79));
        frame.setBounds(650, 190, 756, 428);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JTextArea txtrDearUserWe = new JTextArea();
        txtrDearUserWe.setBackground(new Color(47, 79, 79));
        txtrDearUserWe.setForeground(new Color(245, 255, 250));
        txtrDearUserWe.setEditable(false);
        txtrDearUserWe.setText("Complaint on company reguarding issuse.\r\nDear User,\r\nWe sincerely apologize for the issue regarding to our software registration problem or\r\ntransporting services issuse.\r\n\r\nThank you.\r\n\r\nPlease help us to register your complaint on company platform.");
        txtrDearUserWe.setBounds(10, 11, 720, 151);
        frame.getContentPane().add(txtrDearUserWe);

        JCheckBox c1 = new JCheckBox("Serious issuse with distributer");
        c1.setBackground(new Color(47, 79, 79));
        c1.setForeground(new Color(245, 255, 250));
        c1.setBounds(54, 169, 312, 23);
        frame.getContentPane().add(c1);

        JCheckBox c2 = new JCheckBox("Less quantity");
        c2.setBackground(new Color(47, 79, 79));
        c2.setForeground(new Color(245, 255, 250));
        c2.setBounds(54, 195, 159, 23);
        frame.getContentPane().add(c2);

        JCheckBox c3 = new JCheckBox("poor Quality");
        c3.setBackground(new Color(47, 79, 79));
        c3.setForeground(new Color(245, 255, 250));
        c3.setBounds(54, 221, 159, 23);
        frame.getContentPane().add(c3);

        JCheckBox c4 = new JCheckBox("Replacing Items");
        c4.setBackground(new Color(47, 79, 79));
        c4.setForeground(new Color(245, 255, 250));
        c4.setBounds(54, 247, 185, 23);
        frame.getContentPane().add(c4);

        JTextArea t1 = new JTextArea();
        t1.setBackground(new Color(47, 79, 79));
        t1.setForeground(new Color(245, 255, 250));
        t1.setFont(new Font("Monospaced", Font.BOLD, 16));
        t1.setEditable(false);
        t1.setBounds(359, 199, 371, 110);
        frame.getContentPane().add(t1);

        JButton b1 = new JButton("Submit");
        b1.setBackground(new Color(47, 79, 79));
        b1.setForeground(new Color(245, 255, 250));
        b1.setFont(new Font("Tahoma", Font.BOLD, 14));
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String stemp = "";
                String stemp2 = "";
                FileWriter fwf, fwf2;
                FileReader frd;
                try {
                    frd = new FileReader("complaintcount.txt");
                    BufferedReader br = new BufferedReader(frd);
                    while ((stemp = br.readLine()) != null) {
                        stemp2 = stemp;
                    }
                    int count1 = Integer.parseInt(stemp2);
                    count1 = count1 + 1;
                    fwf = new FileWriter("complaintboxforcompany/complaint" + count1 + ".txt", true);
                    fwf.append(name + "\n\n\t" + "Serious issuse with distributer : " + c1.isSelected() + "\n\tLess quantity : " + c2.isSelected() + "\n\tpoor Quality : " + c3.isSelected() + "\n\tReplacing Items : " + c4.isSelected() + "\n\nFor Company : ");
                    t1.setText("Your complaint is succesfully sent!!\n" + "Your complaint number is : " + count1 + "\nThank You!");
                    String stemp3 = count1 + "";
                    fwf2 = new FileWriter("complaintcount.txt");
                    fwf2.write(stemp3);
                    fwf2.close();
                    fwf.close();
                    br.close();

                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }


                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection myconn = DriverManager.getConnection("jdbc:mysql://localhost:3306/myproject", "root", "root");
                    Statement stat = myconn.createStatement();
                    String sc1 = "";
                    if (c1.isSelected()) {
                        sc1 = "true";
                    } else {
                        sc1 = "false";
                    }
                    String sc2 = "";
                    if (c2.isSelected()) {
                        sc2 = "true";
                    } else {
                        sc2 = "false";
                    }
                    String sc3 = "";
                    if (c3.isSelected()) {
                        sc3 = "true";
                    } else {
                        sc3 = "false";
                    }
                    String sc4 = "";
                    if (c4.isSelected()) {
                        sc4 = "true";
                    } else {
                        sc4 = "false";
                    }
                    stat.executeUpdate("INSERT INTO `complaintoncompany`(issusewithdist,lessqunt,poorqual,replacing,username) VALUE ('" + sc1 + "','" + sc2 + "','" + sc3 + "','" + sc4 + "','" + name + "')");
                    myconn.close();
                } catch (Exception e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }


            }
        });
        b1.setBounds(54, 316, 159, 40);
        frame.getContentPane().add(b1);

        JButton btnNewButton = new JButton("Exit");
        btnNewButton.setBackground(new Color(47, 79, 79));
        btnNewButton.setForeground(new Color(245, 255, 250));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                frame.dispose();

            }
        });
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnNewButton.setBounds(249, 320, 150, 40);
        frame.getContentPane().add(btnNewButton);

    }
}
