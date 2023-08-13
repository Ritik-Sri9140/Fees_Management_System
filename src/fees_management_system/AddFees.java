/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package fees_management_system;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
/**
 *
 * @author Akash
 */
public class AddFees extends javax.swing.JFrame {

    /**
     * Creates new form AddFees
     */
    public AddFees() {
        initComponents();
        displayCashFirst();
        fillComboBox();
        
        int receiptNo=getReceiptNo();
        txt_receiptNo.setText(Integer.toString(receiptNo));
    }
    
    public void displayCashFirst()
    {
        lbl_DDNo.setVisible(false);
        lbl_chequeNo.setVisible(false);
        lbl_bankName.setVisible(false);
        
        txt_DDNo.setVisible(false);
        txt_chequeNo.setVisible(false);
        txt_bankName.setVisible(false);
        
    }
    
    public boolean validation()
    {
        if(txt_receivedFrom.getText().equals(""))
        {
            JOptionPane.showMessageDialog(this,"Please enter user name");
            return false;
        }
        if(dateChooser.getDate()==null)
        {
            JOptionPane.showMessageDialog(this, "Please select a date");
            return false;
        }
        if(txt_amount.getText().equals("") || txt_amount.getText().matches("[0-9]+")==false)
        {
            JOptionPane.showMessageDialog(this,"Please enter amount");
            return false;
        }
        if(combo_paymentMode.getSelectedItem().toString().equalsIgnoreCase("cheque"))
        {
            if(txt_chequeNo.getText().equals(""))
            {
            JOptionPane.showMessageDialog(this,"Please enter cheque number");
            return false;
            }
            if(txt_bankName.getText().equals(""))
            {
            JOptionPane.showMessageDialog(this,"Please enter bank name");
            return false;
            }
        }
        
        if(combo_paymentMode.getSelectedItem().toString().equalsIgnoreCase("dd"))
        {
            if(txt_DDNo.getText().equals(""))
            {
            JOptionPane.showMessageDialog(this,"Please enter dd number");
            return false;
            }
            if(txt_bankName.getText().equals(""))
            {
            JOptionPane.showMessageDialog(this,"Please enter bank name");
            return false;
            }
        }
        
        if(combo_paymentMode.getSelectedItem().toString().equalsIgnoreCase("card"))
        {
            if(txt_bankName.getText().equals(""))
            {
            JOptionPane.showMessageDialog(this,"Please enter bank name");
            return false;
            }
        }
        return true;
    }
    
    public int getReceiptNo()
    {
        int receiptNo = 0;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/fees_management","root","akash123");
            PreparedStatement pst=con.prepareStatement("select max(receipt_no) from fees_Details");
            ResultSet rs= pst.executeQuery();
            if(rs.next()==true)
            {
                receiptNo = rs.getInt(1);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return receiptNo+1;
    }
    
    
    void fillComboBox()
    {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/fees_management","root","akash123");
            PreparedStatement pst=con.prepareStatement("select cname from course");
            ResultSet rs= pst.executeQuery();
            while(rs.next())
            {
                comboCourse.addItem(rs.getString("cname"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
    }
    public String insertData()
    { 
        String status = "";
        
        int receiptNo = Integer.parseInt(txt_receiptNo.getText());
        String studentName = txt_receivedFrom.getText();
        String rollNo = (txt_rollNo.getText());
        String paymentMode = combo_paymentMode.getSelectedItem().toString();
        String chequeNo = txt_chequeNo.getText();
        String bankName = txt_bankName.getText();
        String ddNo = txt_DDNo.getText();
        String courseName = txt_courseName.getText();
        String gstin = txt_GSTNo.getText();
        float totalAmount = Float.parseFloat(txt_total.getText());
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date=dateFormat.format(dateChooser.getDate());
        float initialAmount = Float.parseFloat(txt_amount.getText());
        float cgst = Float.parseFloat(txt_CGST.getText());
        float sgst = Float.parseFloat(txt_SGST.getText());
        String totalInWords = txt_total_words.getText();
        String remark = txt_remark.getText();
        int year1 = Integer.parseInt(txt_year1.getText());
        int year2 = Integer.parseInt(txt_year2.getText());
        
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/fees_management","root","akash123");
            PreparedStatement pst=con.prepareStatement("insert into fees_details value(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1,receiptNo);
            pst.setString(2,studentName);
            pst.setString(3,rollNo);
            pst.setString(4,paymentMode);
            pst.setString(5,chequeNo);
            pst.setString(6,bankName);
            pst.setString(7,ddNo);
            pst.setString(8,courseName);
            pst.setString(9,gstin);
            pst.setFloat(10,totalAmount);
            pst.setString(11,date);
            pst.setFloat(12,initialAmount);
            pst.setFloat(13,cgst);
            pst.setFloat(14,sgst);
            pst.setString(15,totalInWords);
            pst.setString(16,remark);
            pst.setInt(17,year1);
            pst.setInt(18,year2);
            
           int rowCount = pst.executeUpdate();
           if(rowCount == 1){
               status = "Successful";
           }
            else
               status = "Failed";
          }
        catch(Exception e)
                {
                    e.printStackTrace();
                }
        return status;
    }
    
    
    
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelSideBar = new javax.swing.JPanel();
        panelClist = new javax.swing.JPanel();
        btnClist = new javax.swing.JLabel();
        panelHome4 = new javax.swing.JPanel();
        btnHome4 = new javax.swing.JLabel();
        panelHome5 = new javax.swing.JPanel();
        btnHome5 = new javax.swing.JLabel();
        panelHome6 = new javax.swing.JPanel();
        btnHome6 = new javax.swing.JLabel();
        panelHome = new javax.swing.JPanel();
        btnHome = new javax.swing.JLabel();
        panelSrecord = new javax.swing.JPanel();
        btnSrecord = new javax.swing.JLabel();
        panelLogout = new javax.swing.JPanel();
        btnLogout = new javax.swing.JLabel();
        panelEcourse = new javax.swing.JPanel();
        btnEcourse = new javax.swing.JLabel();
        panelVallrecord = new javax.swing.JPanel();
        btnVallrecord = new javax.swing.JLabel();
        panelBack = new javax.swing.JPanel();
        btnBack = new javax.swing.JLabel();
        panelParent = new javax.swing.JPanel();
        txt_GSTNo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbl_DDNo = new javax.swing.JLabel();
        lbl_chequeNo = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt_receiptNo = new javax.swing.JTextField();
        txt_DDNo = new javax.swing.JTextField();
        txt_chequeNo = new javax.swing.JTextField();
        dateChooser = new com.toedter.calendar.JDateChooser();
        panelChild = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txt_receivedFrom = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txt_year2 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        comboCourse = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txt_total_words = new javax.swing.JTextField();
        txt_courseName = new javax.swing.JTextField();
        txt_amount = new javax.swing.JTextField();
        txt_CGST = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        txt_SGST = new javax.swing.JTextField();
        txt_total = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_remark = new javax.swing.JTextArea();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel20 = new javax.swing.JLabel();
        btn_print = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        txt_year1 = new javax.swing.JTextField();
        txt_rollNo = new javax.swing.JTextField();
        lbl_bankName = new javax.swing.JLabel();
        txt_bankName = new javax.swing.JTextField();
        combo_paymentMode = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelSideBar.setBackground(new java.awt.Color(0, 102, 102));
        panelSideBar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelClist.setBackground(new java.awt.Color(0, 102, 102));
        panelClist.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelClist.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnClist.setFont(new java.awt.Font("Sylfaen", 0, 30)); // NOI18N
        btnClist.setForeground(new java.awt.Color(255, 255, 255));
        btnClist.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fees_management_system/images/list_1.png"))); // NOI18N
        btnClist.setText(" Course List");
        btnClist.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnClistMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnClistMouseExited(evt);
            }
        });
        panelClist.add(btnClist, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 300, 70));

        panelHome4.setBackground(new java.awt.Color(0, 102, 102));
        panelHome4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelHome4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnHome4.setFont(new java.awt.Font("Sylfaen", 0, 30)); // NOI18N
        btnHome4.setForeground(new java.awt.Color(255, 255, 255));
        btnHome4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fees_management_system/images/home.png"))); // NOI18N
        btnHome4.setText("  HOME");
        btnHome4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnHome4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnHome4MouseExited(evt);
            }
        });
        panelHome4.add(btnHome4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 260, 70));

        panelClist.add(panelHome4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 400, 330, 70));

        panelHome5.setBackground(new java.awt.Color(0, 102, 102));
        panelHome5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelHome5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnHome5.setFont(new java.awt.Font("Sylfaen", 0, 30)); // NOI18N
        btnHome5.setForeground(new java.awt.Color(255, 255, 255));
        btnHome5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fees_management_system/images/home.png"))); // NOI18N
        btnHome5.setText("  HOME");
        btnHome5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnHome5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnHome5MouseExited(evt);
            }
        });
        panelHome5.add(btnHome5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 260, 70));

        panelHome6.setBackground(new java.awt.Color(0, 102, 102));
        panelHome6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelHome6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnHome6.setFont(new java.awt.Font("Sylfaen", 0, 30)); // NOI18N
        btnHome6.setForeground(new java.awt.Color(255, 255, 255));
        btnHome6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fees_management_system/images/home.png"))); // NOI18N
        btnHome6.setText("  HOME");
        btnHome6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnHome6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnHome6MouseExited(evt);
            }
        });
        panelHome6.add(btnHome6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 260, 70));

        panelHome5.add(panelHome6, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 400, 330, 70));

        panelClist.add(panelHome5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 400, 330, 70));

        panelSideBar.add(panelClist, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 400, 330, 70));

        panelHome.setBackground(new java.awt.Color(0, 102, 102));
        panelHome.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelHome.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnHome.setFont(new java.awt.Font("Sylfaen", 0, 30)); // NOI18N
        btnHome.setForeground(new java.awt.Color(255, 255, 255));
        btnHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fees_management_system/images/home.png"))); // NOI18N
        btnHome.setText("  HOME");
        btnHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHomeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnHomeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnHomeMouseExited(evt);
            }
        });
        panelHome.add(btnHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 300, 70));

        panelSideBar.add(panelHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 330, 70));

        panelSrecord.setBackground(new java.awt.Color(0, 102, 102));
        panelSrecord.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelSrecord.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSrecord.setFont(new java.awt.Font("Sylfaen", 0, 30)); // NOI18N
        btnSrecord.setForeground(new java.awt.Color(255, 255, 255));
        btnSrecord.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fees_management_system/images/search2.png"))); // NOI18N
        btnSrecord.setText(" Search Record");
        btnSrecord.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSrecordMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSrecordMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSrecordMouseExited(evt);
            }
        });
        panelSrecord.add(btnSrecord, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 300, 70));

        panelSideBar.add(panelSrecord, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 200, 330, 70));

        panelLogout.setBackground(new java.awt.Color(0, 102, 102));
        panelLogout.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelLogout.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnLogout.setFont(new java.awt.Font("Sylfaen", 0, 30)); // NOI18N
        btnLogout.setForeground(new java.awt.Color(255, 255, 255));
        btnLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fees_management_system/images/logout.png"))); // NOI18N
        btnLogout.setText(" Logout");
        btnLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLogoutMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLogoutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLogoutMouseExited(evt);
            }
        });
        panelLogout.add(btnLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 280, 70));

        panelSideBar.add(panelLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 700, 330, 70));

        panelEcourse.setBackground(new java.awt.Color(0, 102, 102));
        panelEcourse.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelEcourse.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnEcourse.setFont(new java.awt.Font("Sylfaen", 0, 30)); // NOI18N
        btnEcourse.setForeground(new java.awt.Color(255, 255, 255));
        btnEcourse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fees_management_system/images/edit2.png"))); // NOI18N
        btnEcourse.setText(" Edit Courses");
        btnEcourse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEcourseMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEcourseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEcourseMouseExited(evt);
            }
        });
        panelEcourse.add(btnEcourse, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 300, 70));

        panelSideBar.add(panelEcourse, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 300, 330, 70));

        panelVallrecord.setBackground(new java.awt.Color(0, 102, 102));
        panelVallrecord.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelVallrecord.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnVallrecord.setFont(new java.awt.Font("Sylfaen", 0, 30)); // NOI18N
        btnVallrecord.setForeground(new java.awt.Color(255, 255, 255));
        btnVallrecord.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fees_management_system/images/view all record.png"))); // NOI18N
        btnVallrecord.setText(" View All Record");
        btnVallrecord.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnVallrecordMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnVallrecordMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnVallrecordMouseExited(evt);
            }
        });
        panelVallrecord.add(btnVallrecord, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 300, 70));

        panelSideBar.add(panelVallrecord, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 500, 330, 70));

        panelBack.setBackground(new java.awt.Color(0, 102, 102));
        panelBack.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelBack.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnBack.setFont(new java.awt.Font("Sylfaen", 0, 30)); // NOI18N
        btnBack.setForeground(new java.awt.Color(255, 255, 255));
        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fees_management_system/images/left-arrow.png"))); // NOI18N
        btnBack.setText(" Back");
        btnBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBackMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBackMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBackMouseExited(evt);
            }
        });
        panelBack.add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 290, 70));

        panelSideBar.add(panelBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 600, 330, 70));

        getContentPane().add(panelSideBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 540, 1040));

        panelParent.setBackground(new java.awt.Color(0, 153, 153));
        panelParent.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_GSTNo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_GSTNo.setText("22HVE563");
        panelParent.add(txt_GSTNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 80, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Receipt no :  SET-");
        panelParent.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Mode of Payment :");
        panelParent.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        lbl_DDNo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_DDNo.setText("DD no :");
        panelParent.add(lbl_DDNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        lbl_chequeNo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_chequeNo.setText("Cheque no :");
        panelParent.add(lbl_chequeNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setText("Date :");
        panelParent.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 40, 50, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setText("GSTIN :");
        panelParent.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 80, -1, -1));

        txt_receiptNo.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        txt_receiptNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_receiptNoActionPerformed(evt);
            }
        });
        panelParent.add(txt_receiptNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 40, 150, 30));

        txt_DDNo.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        txt_DDNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_DDNoActionPerformed(evt);
            }
        });
        panelParent.add(txt_DDNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 140, 160, -1));

        txt_chequeNo.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        txt_chequeNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_chequeNoActionPerformed(evt);
            }
        });
        panelParent.add(txt_chequeNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 140, 160, -1));
        panelParent.add(dateChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 40, 120, -1));

        panelChild.setBackground(new java.awt.Color(0, 153, 153));
        panelChild.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("The following payment in the college ofice for the year");
        panelChild.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel11.setText("Recieved From :");
        panelChild.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        txt_receivedFrom.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        txt_receivedFrom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_receivedFromActionPerformed(evt);
            }
        });
        panelChild.add(txt_receivedFrom, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, 270, 40));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel12.setText("to");
        panelChild.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 48, -1, -1));

        txt_year2.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        txt_year2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_year2ActionPerformed(evt);
            }
        });
        panelChild.add(txt_year2, new org.netbeans.lib.awtextra.AbsoluteConstraints(658, 46, 78, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel13.setText("SGST 9 %");
        panelChild.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 310, -1, 20));

        comboCourse.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        comboCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboCourseActionPerformed(evt);
            }
        });
        panelChild.add(comboCourse, new org.netbeans.lib.awtextra.AbsoluteConstraints(163, 94, 262, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel14.setText("Roll No :");
        panelChild.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(552, 94, -1, -1));
        panelChild.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 148, 810, 9));
        panelChild.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 194, 810, 15));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel15.setText("Heads");
        panelChild.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(167, 163, -1, -1));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel16.setText("Sr. No.");
        panelChild.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 163, -1, -1));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel17.setText("Amount(Rs)");
        panelChild.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(556, 163, -1, -1));

        txt_total_words.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        txt_total_words.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_total_wordsActionPerformed(evt);
            }
        });
        panelChild.add(txt_total_words, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 404, 311, 40));

        txt_courseName.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        txt_courseName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_courseNameActionPerformed(evt);
            }
        });
        panelChild.add(txt_courseName, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 227, 291, -1));

        txt_amount.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        txt_amount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_amountActionPerformed(evt);
            }
        });
        panelChild.add(txt_amount, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 220, 169, 30));

        txt_CGST.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        txt_CGST.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_CGSTActionPerformed(evt);
            }
        });
        panelChild.add(txt_CGST, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 260, 169, 30));
        panelChild.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(529, 336, 224, -1));

        txt_SGST.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        txt_SGST.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_SGSTActionPerformed(evt);
            }
        });
        panelChild.add(txt_SGST, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 300, 169, -1));

        txt_total.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        txt_total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_totalActionPerformed(evt);
            }
        });
        panelChild.add(txt_total, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 350, 169, 30));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel18.setText("Remark :");
        panelChild.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 466, -1, -1));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel19.setText("Total in Words :");
        panelChild.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 404, -1, -1));

        txt_remark.setColumns(20);
        txt_remark.setRows(5);
        jScrollPane1.setViewportView(txt_remark);

        panelChild.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 466, 311, 77));
        panelChild.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(527, 424, 226, -1));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel20.setText("Reciever Signature");
        panelChild.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(564, 435, -1, -1));

        btn_print.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        btn_print.setText("Print");
        btn_print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_printActionPerformed(evt);
            }
        });
        panelChild.add(btn_print, new org.netbeans.lib.awtextra.AbsoluteConstraints(593, 499, 85, -1));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel21.setText("Course");
        panelChild.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 96, -1, -1));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel22.setText("CGST 9 %");
        panelChild.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 280, -1, 20));

        txt_year1.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        txt_year1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_year1ActionPerformed(evt);
            }
        });
        panelChild.add(txt_year1, new org.netbeans.lib.awtextra.AbsoluteConstraints(482, 46, 78, -1));

        txt_rollNo.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        panelChild.add(txt_rollNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 92, 110, 30));

        panelParent.add(panelChild, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 1310, 780));

        lbl_bankName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_bankName.setText("Bank Name :");
        panelParent.add(lbl_bankName, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, -1));

        txt_bankName.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        txt_bankName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_bankNameActionPerformed(evt);
            }
        });
        panelParent.add(txt_bankName, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 200, 150, -1));

        combo_paymentMode.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        combo_paymentMode.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DD", "Cheque", "Cash", "Card" }));
        combo_paymentMode.setSelectedIndex(2);
        combo_paymentMode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_paymentModeActionPerformed(evt);
            }
        });
        panelParent.add(combo_paymentMode, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 90, 150, -1));

        getContentPane().add(panelParent, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 0, 1310, 1040));

        setSize(new java.awt.Dimension(2035, 1043));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnClistMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClistMouseEntered
        Color clr=new Color(0,153,153);
        panelClist.setBackground(clr);
    }//GEN-LAST:event_btnClistMouseEntered

    private void btnClistMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClistMouseExited
        Color clr=new Color(0,103,103);
        panelClist.setBackground(clr);
    }//GEN-LAST:event_btnClistMouseExited

    private void btnHomeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomeMouseEntered
        Color clr=new Color(0,153,153);
        panelHome.setBackground(clr);
    }//GEN-LAST:event_btnHomeMouseEntered

    private void btnHomeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomeMouseExited
        Color clr=new Color(0,103,103);
        panelHome.setBackground(clr);
    }//GEN-LAST:event_btnHomeMouseExited

    private void btnSrecordMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSrecordMouseEntered
        Color clr=new Color(0,153,153);
        panelSrecord.setBackground(clr);
    }//GEN-LAST:event_btnSrecordMouseEntered

    private void btnSrecordMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSrecordMouseExited
        Color clr=new Color(0,103,103);
        panelSrecord.setBackground(clr);
    }//GEN-LAST:event_btnSrecordMouseExited

    private void btnLogoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogoutMouseEntered
        Color clr=new Color(0,153,153);
        panelLogout.setBackground(clr);
    }//GEN-LAST:event_btnLogoutMouseEntered

    private void btnLogoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogoutMouseExited
        Color clr=new Color(0,103,103);
        panelLogout.setBackground(clr);
    }//GEN-LAST:event_btnLogoutMouseExited

    private void btnHome4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHome4MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHome4MouseEntered

    private void btnHome4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHome4MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHome4MouseExited

    private void btnHome5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHome5MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHome5MouseEntered

    private void btnHome5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHome5MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHome5MouseExited

    private void btnHome6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHome6MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHome6MouseEntered

    private void btnHome6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHome6MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHome6MouseExited

    private void btnEcourseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEcourseMouseEntered
        Color clr=new Color(0,153,153);
        panelEcourse.setBackground(clr);
    }//GEN-LAST:event_btnEcourseMouseEntered

    private void btnEcourseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEcourseMouseExited
        Color clr=new Color(0,103,103);
        panelEcourse.setBackground(clr);
    }//GEN-LAST:event_btnEcourseMouseExited

    private void btnVallrecordMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVallrecordMouseEntered
        Color clr=new Color(0,153,153);
        panelVallrecord.setBackground(clr);        
    }//GEN-LAST:event_btnVallrecordMouseEntered

    private void btnVallrecordMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVallrecordMouseExited
        Color clr=new Color(0,103,103);
        panelVallrecord.setBackground(clr); 
    }//GEN-LAST:event_btnVallrecordMouseExited

    private void btnBackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackMouseEntered
        Color clr=new Color(0,153,153);
        panelBack.setBackground(clr); 
    }//GEN-LAST:event_btnBackMouseEntered

    private void btnBackMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackMouseExited
        Color clr=new Color(0,103,103);
        panelBack.setBackground(clr); 
    }//GEN-LAST:event_btnBackMouseExited

    private void txt_receivedFromActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_receivedFromActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_receivedFromActionPerformed

    private void txt_receiptNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_receiptNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_receiptNoActionPerformed

    private void txt_DDNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_DDNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_DDNoActionPerformed

    private void txt_chequeNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_chequeNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_chequeNoActionPerformed

    private void txt_bankNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_bankNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_bankNameActionPerformed

    private void txt_year2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_year2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_year2ActionPerformed

    private void txt_total_wordsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_total_wordsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_total_wordsActionPerformed

    private void txt_courseNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_courseNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_courseNameActionPerformed

    private void txt_amountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_amountActionPerformed
        Float amnt = Float.parseFloat(txt_amount.getText());
        
        Float cgst = (float)(amnt*0.09); 
        Float sgst = (float)(amnt*0.09);
        
        txt_CGST.setText(cgst.toString());
        txt_SGST.setText(cgst.toString());
        
        float total = amnt + cgst + sgst;
        
        txt_total.setText(Float.toString(total));
        
        txt_total_words.setText(NumberToWordsConverter.convert((int)total) + " only");
    }//GEN-LAST:event_txt_amountActionPerformed

    private void txt_CGSTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_CGSTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_CGSTActionPerformed

    private void txt_SGSTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_SGSTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_SGSTActionPerformed

    private void txt_totalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_totalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_totalActionPerformed

    private void txt_year1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_year1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_year1ActionPerformed

    private void combo_paymentModeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_paymentModeActionPerformed
        if(combo_paymentMode.getSelectedIndex()==0)
        {
            lbl_DDNo.setVisible(true);
            txt_DDNo.setVisible(true);
            lbl_chequeNo.setVisible(false);
            txt_chequeNo.setVisible(false);
            lbl_bankName.setVisible(true);
            txt_bankName.setVisible(true);
        }
        if(combo_paymentMode.getSelectedIndex()==1)
        {
            lbl_DDNo.setVisible(false);
            txt_DDNo.setVisible(false);
            lbl_chequeNo.setVisible(true);
            txt_chequeNo.setVisible(true);
            lbl_bankName.setVisible(true);
            txt_bankName.setVisible(true);
        }
        if(combo_paymentMode.getSelectedIndex()==2)
        {
            lbl_DDNo.setVisible(false);
            txt_DDNo.setVisible(false);
            lbl_chequeNo.setVisible(false);
            txt_chequeNo.setVisible(false);
            lbl_bankName.setVisible(false);
            txt_bankName.setVisible(false);
        }
        if(combo_paymentMode.getSelectedItem().equals("Card"))
        {
            lbl_DDNo.setVisible(false);
            txt_DDNo.setVisible(false);
            lbl_chequeNo.setVisible(false);
            txt_chequeNo.setVisible(false);
            lbl_bankName.setVisible(true);
            txt_bankName.setVisible(true);
        }
    }//GEN-LAST:event_combo_paymentModeActionPerformed

    private void btn_printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_printActionPerformed
        if(validation()==true)
        {
           String result = insertData();
           if(result.equals("Successful")){
          JOptionPane.showMessageDialog(this,"Record Inserted Successfully");
               PrintReceipt p=new PrintReceipt();
               p.setVisible(true);
               this.dispose();
           }
           else
               JOptionPane.showMessageDialog(this,"Record Insertion Failed");
        }
    }//GEN-LAST:event_btn_printActionPerformed

    private void comboCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboCourseActionPerformed
        txt_courseName.setText(comboCourse.getSelectedItem().toString());
    }//GEN-LAST:event_comboCourseActionPerformed

    private void btnSrecordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSrecordMouseClicked
searchRecord search=new searchRecord();
        search.setVisible(true);
        this.dispose();       
    }//GEN-LAST:event_btnSrecordMouseClicked

    private void btnHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomeMouseClicked
        Home home = new Home();
        home.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnHomeMouseClicked

    private void btnEcourseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEcourseMouseClicked
        editCourse edit=new editCourse();
        edit.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnEcourseMouseClicked

    private void btnVallrecordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVallrecordMouseClicked
        ViewAllRecords allRecords=new ViewAllRecords();
        allRecords.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVallrecordMouseClicked

    private void btnBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackMouseClicked
        Home home = new Home();
        home.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBackMouseClicked

    private void btnLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogoutMouseClicked
           Login login = new Login();
        login.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnLogoutMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AddFees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddFees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddFees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddFees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddFees().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnBack;
    private javax.swing.JLabel btnClist;
    private javax.swing.JLabel btnEcourse;
    private javax.swing.JLabel btnHome;
    private javax.swing.JLabel btnHome4;
    private javax.swing.JLabel btnHome5;
    private javax.swing.JLabel btnHome6;
    private javax.swing.JLabel btnLogout;
    private javax.swing.JLabel btnSrecord;
    private javax.swing.JLabel btnVallrecord;
    private javax.swing.JButton btn_print;
    private javax.swing.JComboBox<String> comboCourse;
    private javax.swing.JComboBox<String> combo_paymentMode;
    private com.toedter.calendar.JDateChooser dateChooser;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel lbl_DDNo;
    private javax.swing.JLabel lbl_bankName;
    private javax.swing.JLabel lbl_chequeNo;
    private javax.swing.JPanel panelBack;
    private javax.swing.JPanel panelChild;
    private javax.swing.JPanel panelClist;
    private javax.swing.JPanel panelEcourse;
    private javax.swing.JPanel panelHome;
    private javax.swing.JPanel panelHome4;
    private javax.swing.JPanel panelHome5;
    private javax.swing.JPanel panelHome6;
    private javax.swing.JPanel panelLogout;
    private javax.swing.JPanel panelParent;
    private javax.swing.JPanel panelSideBar;
    private javax.swing.JPanel panelSrecord;
    private javax.swing.JPanel panelVallrecord;
    private javax.swing.JTextField txt_CGST;
    private javax.swing.JTextField txt_DDNo;
    private javax.swing.JLabel txt_GSTNo;
    private javax.swing.JTextField txt_SGST;
    private javax.swing.JTextField txt_amount;
    private javax.swing.JTextField txt_bankName;
    private javax.swing.JTextField txt_chequeNo;
    private javax.swing.JTextField txt_courseName;
    private javax.swing.JTextField txt_receiptNo;
    private javax.swing.JTextField txt_receivedFrom;
    private javax.swing.JTextArea txt_remark;
    private javax.swing.JTextField txt_rollNo;
    private javax.swing.JTextField txt_total;
    private javax.swing.JTextField txt_total_words;
    private javax.swing.JTextField txt_year1;
    private javax.swing.JTextField txt_year2;
    // End of variables declaration//GEN-END:variables
}
