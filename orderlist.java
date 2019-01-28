import javax.swing.border.LineBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class orderlist extends mainsignupfile {

    public JFrame frmPlaceYourOrder;
    public JTextField textf1;
    mainsignupfile m1 = new mainsignupfile();
    String Y = "";
    String st3 = "";
    int p = 0;
    double total;
    int totalqty;
    Date d = new Date();
    String sdate = "";

    /**
     * Create the application.
     */
    public orderlist() {
        initialize();
    }

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    orderlist window = new orderlist();
                    window.frmPlaceYourOrder.setVisible(true);
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
        frmPlaceYourOrder = new JFrame();
        frmPlaceYourOrder.getContentPane().setBackground(new Color(230, 230, 250));
        frmPlaceYourOrder.getContentPane().setForeground(new Color(0, 0, 139));
        frmPlaceYourOrder.setForeground(new Color(165, 42, 42));
        frmPlaceYourOrder.setFont(new Font("Cambria", Font.BOLD, 12));
        frmPlaceYourOrder.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Swaminarayan\\Desktop\\Untitled.png"));
        frmPlaceYourOrder.setTitle("place your order");
        frmPlaceYourOrder.setBounds(250, 0, 750, 850);
        frmPlaceYourOrder.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmPlaceYourOrder.getContentPane().setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 204, 255));
        panel.setBorder(new LineBorder(new Color(153, 0, 102), 2, true));
        panel.setBounds(144, 44, 394, 231);
        frmPlaceYourOrder.getContentPane().add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("Enter Item Code : ");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel.setForeground(new Color(153, 0, 102));
        lblNewLabel.setBounds(44, 35, 145, 14);
        panel.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Enter Quntity :");
        lblNewLabel_1.setForeground(new Color(153, 0, 102));
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_1.setBounds(44, 105, 139, 14);
        panel.add(lblNewLabel_1);

        textf1 = new JTextField();
        textf1.setBounds(199, 102, 146, 20);
        panel.add(textf1);
        textf1.setColumns(10);


        JComboBox<String> CB1 = new JComboBox<>();
        CB1.setFont(new Font("Tahoma", Font.BOLD, 11));
        CB1.setBounds(199, 34, 146, 20);
        panel.add(CB1);
        CB1.setBackground(new Color(255, 255, 255));
        CB1.setForeground(new Color(0, 0, 102));
        CB1.setMaximumRowCount(15);
        CB1.setToolTipText("select code from catlog list");
        CB1.setModel(new DefaultComboBoxModel<String>(new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11"}));


        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(230, 230, 250));
        panel_1.setBounds(10, 286, 714, 398);
        frmPlaceYourOrder.getContentPane().add(panel_1);
        panel_1.setLayout(null);

        JTextArea t1 = new JTextArea();
        t1.setBounds(37, 5, 638, 382);
        t1.setEditable(false);
        t1.setForeground(new Color(0, 0, 0));
        t1.setFont(new Font("Monospaced", Font.BOLD, 12));
        t1.setText("\t\t          MRP PRICELIST\r\n\tTEL :91-22-61716666 \tFAX : 91-22-61716699\r\n\tE-MAIL : consumer.india@fhp-ww.com\r\n\tOFFICE : B-902/903/904, O2 Galleria, Plot No.23/24,\r\n\tMinerva Industrial Estate, Off LBS Marg,\r\n\tNear Asha Nagar, Mulund (West). Mumbai - 400080\r\n\r\nCODE\t SAP ID\tITEM \t\t\t\t  MRP\r\n1 \t132801\tSHERGRIP SINK BRUSH\t\t 69.00\r\n2 \t132746\tC.KITCHEN MOPPY    \t\t 65.00\r\n3 \t132763 \tHEXA BIG \t\t\t 90.00\r\n4\t132788\tPLUNGER MEDIUM\t\t \t 70.00\r\n5 \t132748\tC.KWICK N EAZEE\t\t    \t 50.00\r\n6 \t148993 \tSPONGE WIPE\t\t\t 41.00\r\n7 \t148994\tSPONGE WIPE COMBI SET (3PCS) \t 109.00\r\n8 \t148995 \tSPONGE WIPE COMBI SET (5PCS)\t 169.00\r\n9 \t132761 \tFRIDGE JAR CLEANER\t\t 80.00\r\n10 \t132823 \tTOILEX WITH SQUARE CONT\t\t 175.00\r\n11 \t132822 \tTOILEX WITH ROUNDY CONT.\t 199.00");
        panel_1.add(t1);

        //  HERE IS MORE ITEMS BUTTON..!! HELL YEAH..!!

        List<String> st = new ArrayList<String>();
        List<Integer> AI = new ArrayList<Integer>();

        JButton btnNewButton = new JButton("Add");
        frmPlaceYourOrder.getRootPane().setDefaultButton(btnNewButton);
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                int index = CB1.getSelectedIndex();
                String s = CB1.getItemAt(index);
                st.add(s);
                AI.add(Integer.parseInt(textf1.getText()));


//************************************************************************************************************************************************************************//

                try {

                    FileReader fr2 = new FileReader("catlog.txt");
                    BufferedReader br2 = new BufferedReader(fr2);
                    int i;
                    int j;
                    //int count=0;
                    String s1 = "";
                /*while((s=br2.readLine())!=null)
                {
					count=count+1;
				}*/
                    String s2[] = new String[11];
                    String s3[] = new String[11];
                    String s4[] = new String[11];
                    i = 0;
                    int y;
                    String s5[] = new String[11];


                    while ((s1 = br2.readLine()) != null) {
                        y = 0;
                        String words[] = s1.split(" ");
                        s2[i] = words[0];
                        s3[i] = s1;
                        s4[i] = words[words.length - 1];
                        for (y = 2; y < words.length - 1; y++) {
                            if (y == 2) {
                                s5[i] = words[y];
                            } else {
                                s5[i] = s5[i] + " " + words[y];
                            }
                        }
                        i = i + 1;
                    }

                    total = 0;
                    totalqty = 0;
                    int u = 1;
                    List<String> st2 = new ArrayList<String>();
                    for (i = 0; i < AI.size(); i++) {
                        for (j = 0; j < 11; j++) {
                            if (st.get(i).equals(s2[j])) {
                                double a = Double.parseDouble(s4[j]);
                                a = a * AI.get(i);
                                totalqty = totalqty + AI.get(i);
                                st2.add(("\t " + u + ". quantity : " + AI.get(i) + "  ||   total:" + (a) + "  ||   Name : " + s5[j]));
                                total = a + total;
                                u = u + 1;
                                break;
                            }
                        }
                    }

                    st3 = ("\t Total Quantity : " + totalqty + "\tGrand total : " + total);
                    while (p < st2.size()) {
                        Y = Y + st2.get(p) + "\n";
                        p++;
                    }
                    CB1.setSelectedIndex(0);
                    textf1.setText(null);
                    CB1.requestFocusInWindow();

                    br2.close();
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    System.out.println(e);
                }
//************************************************************************************************************************************************************************//
            }
        });
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnNewButton.setForeground(new Color(153, 0, 102));
        btnNewButton.setBounds(44, 171, 145, 23);
        panel.add(btnNewButton);

        JButton bill = new JButton("Click For Bill");
        frmPlaceYourOrder.getRootPane().setDefaultButton(bill);
        bill.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Y = Y + st3;
                t1.setText(Y);
                CB1.setSelectedIndex(0);
                textf1.setText(null);
            }
        });
        bill.setForeground(new Color(153, 0, 102));
        bill.setFont(new Font("Tahoma", Font.BOLD, 12));
        bill.setBounds(199, 171, 146, 23);
        panel.add(bill);

        JButton btnNewButton_1 = new JButton("save");
        frmPlaceYourOrder.getRootPane().setDefaultButton(btnNewButton_1);
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                Date date = new Date();
                if (btnNewButton_1.getText() == "cancel order!") {
                    try {
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection myconn = DriverManager.getConnection("jdbc:mysql://localhost:3306/myproject", "root", "root");
                        String sd = "DELETE FROM ORDERDATA WHERE DATETIME='" + sdate + "'";
                        PreparedStatement mystat = myconn.prepareStatement(sd);
                        mystat.execute();
                        btnNewButton_1.setText("save");
                        t1.setText("\n\n    Your order is canceled!!");
                    } catch (Exception E) {
                        System.out.println(E);
                    }
                } else if (btnNewButton_1.getText() == "save") {
                    sdate = date.toString();
                    try {
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection myconn = DriverManager.getConnection("jdbc:mysql://localhost:3306/myproject", "root", "root");
                        Statement stat = myconn.createStatement();
                        stat.executeUpdate("INSERT INTO `orderdata`(username,dateTime,Quantity,Total) VALUE ('" + name + "','" + sdate + "','" + totalqty + "'," + total + ")");
                        t1.setText("\n\n    Your data is succesfully stored!");
                        btnNewButton_1.setText("cancel order!");
                        myconn.close();
                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        });
        btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnNewButton_1.setForeground(new Color(139, 0, 139));
        btnNewButton_1.setBounds(48, 684, 279, 54);
        frmPlaceYourOrder.getContentPane().add(btnNewButton_1);

        JButton btnShowData = new JButton("Show Data");
        frmPlaceYourOrder.getRootPane().setDefaultButton(btnShowData);
        btnShowData.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                int O = 1;
                try {
                    Date d = new Date();
                    Connection myconn = DriverManager.getConnection("jdbc:mysql://localhost:3306/myproject", "root", "root");
                    Statement stat = myconn.createStatement();
                    ResultSet myrs = stat.executeQuery("select * from orderdata where username='" + name + "'");
                    String sforfrm = "";
                    while (myrs.next()) {
                        sforfrm = sforfrm + O + ". " + myrs.getString("dateTime") + "	    Total Items is : " + myrs.getInt(3) + "     Total Rupees : " + myrs.getInt(4) + ".00" + "\n";
                        O++;
                    }
                    t1.setText(sforfrm);
                } catch (Exception E) {

                }
            }
        });
        btnShowData.setForeground(new Color(139, 0, 139));
        btnShowData.setFont(new Font("Tahoma", Font.BOLD, 16));
        btnShowData.setBounds(397, 685, 279, 54);
        frmPlaceYourOrder.getContentPane().add(btnShowData);

        JMenuBar menuBar = new JMenuBar();
        frmPlaceYourOrder.setJMenuBar(menuBar);

        JMenu mnNewMenu_5 = new JMenu("contact");
        mnNewMenu_5.setFont(new Font("Segoe UI", Font.BOLD, 12));
        mnNewMenu_5.setForeground(new Color(0, 0, 0));
        menuBar.add(mnNewMenu_5);

        JMenu mnNewMenu = new JMenu("     State");
        mnNewMenu_5.add(mnNewMenu);
        mnNewMenu.setFont(new Font("Segoe UI", Font.BOLD, 12));

        JMenu mnNewMenu_1 = new JMenu("Gujarat");
        mnNewMenu.add(mnNewMenu_1);

        JMenuItem mntmNewMenuItem = new JMenuItem("ahmedabad");
        mntmNewMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                Numbers N = new Numbers();
                N.frame.setVisible(true);

            }
        });
        mnNewMenu_1.add(mntmNewMenuItem);

        JMenuItem mntmNewMenuItem_1 = new JMenuItem("surat");
        mntmNewMenuItem_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                Numbers N = new Numbers();
                N.frame.setVisible(true);

            }
        });
        mnNewMenu_1.add(mntmNewMenuItem_1);

        JMenuItem mntmNewMenuItem_2 = new JMenuItem("baroda");
        mntmNewMenuItem_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                Numbers N = new Numbers();
                N.frame.setVisible(true);

            }
        });
        mnNewMenu_1.add(mntmNewMenuItem_2);

        JMenuItem mntmNewMenuItem_3 = new JMenuItem("gandhinagar");
        mntmNewMenuItem_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                Numbers N = new Numbers();
                N.frame.setVisible(true);

            }
        });
        mnNewMenu_1.add(mntmNewMenuItem_3);

        JMenu mnNewMenu_2 = new JMenu("maharastra");
        mnNewMenu.add(mnNewMenu_2);

        JMenuItem mntmNewMenuItem_4 = new JMenuItem("mumbai");
        mntmNewMenuItem_4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                Numbers N = new Numbers();
                N.frame.setVisible(true);

            }
        });
        mnNewMenu_2.add(mntmNewMenuItem_4);

        JMenuItem mntmNewMenuItem_5 = new JMenuItem("pune");
        mntmNewMenuItem_5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                Numbers N = new Numbers();
                N.frame.setVisible(true);

            }
        });
        mnNewMenu_2.add(mntmNewMenuItem_5);

        JMenuItem mntmNewMenuItem_6 = new JMenuItem("nagpur");
        mntmNewMenuItem_6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                Numbers N = new Numbers();
                N.frame.setVisible(true);

            }
        });
        mnNewMenu_2.add(mntmNewMenuItem_6);

        JMenu mnNewMenu_3 = new JMenu("rajsthan");
        mnNewMenu.add(mnNewMenu_3);

        JMenuItem mntmNewMenuItem_15 = new JMenuItem("jaipur");
        mntmNewMenuItem_15.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                Numbers N = new Numbers();
                N.frame.setVisible(true);

            }
        });
        mnNewMenu_3.add(mntmNewMenuItem_15);

        JMenuItem mntmNewMenuItem_16 = new JMenuItem("udaipur");
        mntmNewMenuItem_16.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                Numbers N = new Numbers();
                N.frame.setVisible(true);

            }
        });
        mnNewMenu_3.add(mntmNewMenuItem_16);

        JMenu mnMadhyapradesh = new JMenu("madhyapradesh");
        mnNewMenu.add(mnMadhyapradesh);

        JMenuItem mntmNewMenuItem_14 = new JMenuItem("bhopal");
        mntmNewMenuItem_14.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                Numbers N = new Numbers();
                N.frame.setVisible(true);

            }
        });
        mnMadhyapradesh.add(mntmNewMenuItem_14);

        JMenu mnNewMenu_4 = new JMenu("karnataka");
        mnNewMenu.add(mnNewMenu_4);

        JMenuItem mntmNewMenuItem_10 = new JMenuItem("banglore");
        mntmNewMenuItem_10.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                Numbers N = new Numbers();
                N.frame.setVisible(true);

            }
        });
        mnNewMenu_4.add(mntmNewMenuItem_10);

        JMenuItem mntmNewMenuItem_7 = new JMenuItem("germany");
        mntmNewMenuItem_7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                Numbers N = new Numbers();
                N.frame.setVisible(true);

            }
        });
        mnNewMenu_5.add(mntmNewMenuItem_7);

        JMenu mnNewMenu_6 = new JMenu("offers");
        mnNewMenu_6.setForeground(new Color(0, 0, 0));
        mnNewMenu_6.setFont(new Font("Segoe UI", Font.BOLD, 12));
        menuBar.add(mnNewMenu_6);

        JMenuItem mntmJanuary = new JMenuItem("January");
        mntmJanuary.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                offer o = new offer();
                o.frame.setVisible(true);

            }
        });
        mnNewMenu_6.add(mntmJanuary);

        JMenuItem mntmNewMenuItem_8 = new JMenuItem("February");
        mntmNewMenuItem_8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                offer o = new offer();
                o.frame.setVisible(true);

            }
        });
        mnNewMenu_6.add(mntmNewMenuItem_8);

        JMenuItem mntmNewMenuItem_9 = new JMenuItem("March");
        mntmNewMenuItem_9.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                offer o = new offer();
                o.frame.setVisible(true);

            }
        });
        mnNewMenu_6.add(mntmNewMenuItem_9);

        JMenuItem mntmLogout = new JMenuItem("                                                                                                                                                                      Logout");
        mntmLogout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                logout l1 = new logout();
                frmPlaceYourOrder.dispose();
                l1.frame.setVisible(true);

            }
        });

        JMenu mnComplaint = new JMenu("complaint");
        mnComplaint.setForeground(Color.BLACK);
        mnComplaint.setFont(new Font("Segoe UI", Font.BOLD, 12));
        menuBar.add(mnComplaint);

        JMenu menu_1 = new JMenu("Report");
        mnComplaint.add(menu_1);

        JMenuItem menuItem_1 = new JMenuItem("on compny");
        menuItem_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                complaintoncompany c = new complaintoncompany();
                c.frame.setVisible(true);


            }
        });
        menu_1.add(menuItem_1);

        JMenuItem menuItem_2 = new JMenuItem("on distributer");
        menuItem_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                complaint c = new complaint();
                c.frame.setVisible(true);

            }
        });
        menu_1.add(menuItem_2);
        mntmLogout.setFont(new Font("Segoe UI", Font.BOLD, 11));
        menuBar.add(mntmLogout);
    }
}