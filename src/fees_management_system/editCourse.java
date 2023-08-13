/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package fees_management_system;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
/**
 *
 * @author Akash
 */
public class editCourse extends javax.swing.JFrame {

    /**
     * Creates new form editCourse
     */
    
    DefaultTableModel model;
    
    public editCourse() {
        initComponents();
        SetRecordInTable();
        
    }

    
    public void SetRecordInTable(){
       try
       {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/fees_management","root","akash123");
            PreparedStatement pst=con.prepareStatement("select * from course");
            ResultSet rs = pst.executeQuery();
            while(rs.next())
            {
                String courseId = rs.getString("id");
                String cname = rs.getString("cname");
                String cost = rs.getString("cost");
                
                Object[] obj = {courseId, cname, cost};
                
                model = (DefaultTableModel)tbl_courseData.getModel();
                model.addRow(obj);
            }
       } 
       catch(Exception e)
       {
           e.printStackTrace();
       }
    }
    
    public void clearTable()
    {
        DefaultTableModel model = (DefaultTableModel)tbl_courseData.getModel();
        model.setRowCount(0);
    }
    
    public void addCourse(int id, String cname, int cost)
    {
       try
       {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/fees_management","root","akash123");
            PreparedStatement pst=con.prepareStatement("insert into course values(?,?,?)");
            pst.setInt(1, id);
            pst.setString(2, cname);
            pst.setInt(3, cost);
            
            int rowCount=pst.executeUpdate();
            if(rowCount==1)
            {
                JOptionPane.showMessageDialog(this,"Course added successfully");
                clearTable();
                SetRecordInTable();            }
            else
            {
                JOptionPane.showMessageDialog(this,"Course insertion falied");
            }
       }
              catch(Exception e)
       {
           JOptionPane.showMessageDialog(this,"Course insertion falied");
           e.printStackTrace();
       }
    }
    
    public void update(int id, String cname, int cost)
    {
        try
       {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/fees_management","root","akash123");
            PreparedStatement pst=con.prepareStatement("update course set cname=?,cost=? where id=?");
            
            pst.setString(1, cname);
            pst.setInt(2, cost);
            pst.setInt(3, id);
            
            int rowCount=pst.executeUpdate();
            if(rowCount==1)
            {
                JOptionPane.showMessageDialog(this,"Course updated successfully");
                clearTable();
                SetRecordInTable();            }
            else
            {
                JOptionPane.showMessageDialog(this,"Course updation falied");
            }
       }
              catch(Exception e)
       {
           JOptionPane.showMessageDialog(this,"Course updation falied");
           e.printStackTrace();
       }
    }
    
    public void delete(int id)
    {
        try
       {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/fees_management","root","akash123");
            PreparedStatement pst=con.prepareStatement("delete from course where id=?");
            
            pst.setInt(1, id);
            
            int rowCount=pst.executeUpdate();
            if(rowCount==1)
            {
                JOptionPane.showMessageDialog(this,"Course deleted successfully");
                clearTable();
                SetRecordInTable();            }
            else
            {
                JOptionPane.showMessageDialog(this,"Course deletion falied");
            }
       }
              catch(Exception e)
       {
           JOptionPane.showMessageDialog(this,"Course deletion falied");
           e.printStackTrace();
       }
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
        panelprint = new javax.swing.JPanel();
        btn_print = new javax.swing.JLabel();
        paneledit = new javax.swing.JPanel();
        btn_edit = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_courseData = new javax.swing.JTable();
        txt_coursePrice = new javax.swing.JTextField();
        txt_courseId = new javax.swing.JTextField();
        txt_courseName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
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

        panelSideBar.add(panelClist, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 260, 330, 70));

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

        panelSideBar.add(panelHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 330, 70));

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

        panelSideBar.add(panelSrecord, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 330, 70));

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

        panelSideBar.add(panelLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 500, 330, 70));

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

        panelSideBar.add(panelEcourse, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, 330, 70));

        panelVallrecord.setBackground(new java.awt.Color(0, 102, 102));
        panelVallrecord.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelVallrecord.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnVallrecord.setFont(new java.awt.Font("Sylfaen", 0, 30)); // NOI18N
        btnVallrecord.setForeground(new java.awt.Color(255, 255, 255));
        btnVallrecord.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fees_management_system/images/view all record.png"))); // NOI18N
        btnVallrecord.setText(" View All Record");
        btnVallrecord.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnVallrecordMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnVallrecordMouseExited(evt);
            }
        });
        panelVallrecord.add(btnVallrecord, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 300, 70));

        panelSideBar.add(panelVallrecord, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 340, 330, 70));

        panelBack.setBackground(new java.awt.Color(0, 102, 102));
        panelBack.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelBack.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnBack.setFont(new java.awt.Font("Sylfaen", 0, 30)); // NOI18N
        btnBack.setForeground(new java.awt.Color(255, 255, 255));
        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fees_management_system/images/left-arrow.png"))); // NOI18N
        btnBack.setText(" Back");
        btnBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBackMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBackMouseExited(evt);
            }
        });
        panelBack.add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 290, 70));

        panelSideBar.add(panelBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 420, 330, 70));

        panelprint.setBackground(new java.awt.Color(0, 102, 102));
        panelprint.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelprint.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_print.setFont(new java.awt.Font("Sylfaen", 0, 30)); // NOI18N
        btn_print.setForeground(new java.awt.Color(255, 255, 255));
        btn_print.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fees_management_system/images/printer-.png"))); // NOI18N
        btn_print.setText(" Print");
        btn_print.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_printMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_printMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_printMouseExited(evt);
            }
        });
        panelprint.add(btn_print, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 280, 70));

        panelSideBar.add(panelprint, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 580, 330, 70));

        paneledit.setBackground(new java.awt.Color(0, 102, 102));
        paneledit.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        paneledit.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_edit.setFont(new java.awt.Font("Sylfaen", 0, 30)); // NOI18N
        btn_edit.setForeground(new java.awt.Color(255, 255, 255));
        btn_edit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fees_management_system/images/edit2.png"))); // NOI18N
        btn_edit.setText(" edit");
        btn_edit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_editMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_editMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_editMouseExited(evt);
            }
        });
        paneledit.add(btn_edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 280, 70));

        panelSideBar.add(paneledit, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 660, 330, 70));

        getContentPane().add(panelSideBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 540, 1040));

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_courseData.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tbl_courseData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Course_Id", "Course_Name", "Course_Price"
            }
        ));
        tbl_courseData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_courseDataMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_courseData);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 110, 460, 520));

        txt_coursePrice.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_coursePrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_coursePriceActionPerformed(evt);
            }
        });
        jPanel1.add(txt_coursePrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 300, 230, -1));

        txt_courseId.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_courseId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_courseIdActionPerformed(evt);
            }
        });
        jPanel1.add(txt_courseId, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 180, 230, -1));

        txt_courseName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_courseName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_courseNameActionPerformed(evt);
            }
        });
        jPanel1.add(txt_courseName, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 240, 230, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Course_Price");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 300, 110, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 25)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Edit Course Details");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 10, 240, 60));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Course_Name");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 240, 130, -1));

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton1.setText("DELETE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 380, 110, 30));

        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton2.setText("ADD");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 380, 100, 30));

        jButton5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton5.setText("UPDATE");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 380, 100, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Course_Id");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, 110, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fees_management_system/images/back1.png"))); // NOI18N
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 90, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 0, 1250, 890));

        setSize(new java.awt.Dimension(1800, 900));
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

    private void btnHomeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomeMouseEntered
        Color clr=new Color(0,153,153);
        panelHome.setBackground(clr);
    }//GEN-LAST:event_btnHomeMouseEntered

    private void btnHomeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomeMouseExited
        Color clr=new Color(0,103,103);
        panelHome.setBackground(clr);
    }//GEN-LAST:event_btnHomeMouseExited

    private void btnSrecordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSrecordMouseClicked
        searchRecord search=new searchRecord();
        search.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSrecordMouseClicked

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

    private void btn_printMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_printMouseClicked
        PrinterJob job = PrinterJob.getPrinterJob();
        job.setJobName("Print Data");

        job.setPrintable(new Printable(){
            public int print(Graphics pg,PageFormat pf, int pageNum){
                pf.setOrientation(PageFormat.LANDSCAPE);
                if(pageNum > 0){
                    return Printable.NO_SUCH_PAGE;
                }

                Graphics2D g2 = (Graphics2D)pg;
                g2.translate(pf.getImageableX(), pf.getImageableY());
                g2.scale(0.47,0.47);

                panelSideBar.print(g2);

                return Printable.PAGE_EXISTS;

            }
        });
        boolean ok = job.printDialog();
        if(ok){
            try{

                job.print();
            }
            catch (PrinterException ex){
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_btn_printMouseClicked

    private void btn_printMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_printMouseEntered
        Color clr=new Color(0,153,153);
        panelprint.setBackground(clr);
    }//GEN-LAST:event_btn_printMouseEntered

    private void btn_printMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_printMouseExited
        Color clr=new Color(0,103,103);
        panelprint.setBackground(clr);
    }//GEN-LAST:event_btn_printMouseExited

    private void btn_editMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_editMouseClicked
        UpdateFeesDetails update = new UpdateFeesDetails();
        update.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_editMouseClicked

    private void btn_editMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_editMouseEntered
        Color clr=new Color(0,153,153);
        paneledit.setBackground(clr);
    }//GEN-LAST:event_btn_editMouseEntered

    private void btn_editMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_editMouseExited
        Color clr=new Color(0,103,103);
        paneledit.setBackground(clr);
    }//GEN-LAST:event_btn_editMouseExited

    private void txt_coursePriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_coursePriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_coursePriceActionPerformed

    private void txt_courseIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_courseIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_courseIdActionPerformed

    private void txt_courseNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_courseNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_courseNameActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int id = Integer.parseInt(txt_courseId.getText());
    
        delete(id);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int id = Integer.parseInt(txt_courseId.getText());
         String cname = txt_courseName.getText();
         int cost = Integer.parseInt(txt_coursePrice.getText());
         
        addCourse(id , cname , cost);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        int id = Integer.parseInt(txt_courseId.getText());
         String cname = txt_courseName.getText();
         int cost = Integer.parseInt(txt_coursePrice.getText());
         
        update(id , cname , cost);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void tbl_courseDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_courseDataMouseClicked
      int rowNo = tbl_courseData.getSelectedRow();
      TableModel model = tbl_courseData.getModel();
      
      txt_courseId.setText(model.getValueAt(rowNo, 0).toString());
      txt_courseName.setText((String)model.getValueAt(rowNo, 1));
      txt_coursePrice.setText(model.getValueAt(rowNo, 2).toString());
      
      
    }//GEN-LAST:event_tbl_courseDataMouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        Home home = new Home();
        home.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel5MouseClicked

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
            java.util.logging.Logger.getLogger(editCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(editCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(editCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(editCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new editCourse().setVisible(true);
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
    private javax.swing.JLabel btn_edit;
    private javax.swing.JLabel btn_print;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelBack;
    private javax.swing.JPanel panelClist;
    private javax.swing.JPanel panelEcourse;
    private javax.swing.JPanel panelHome;
    private javax.swing.JPanel panelHome4;
    private javax.swing.JPanel panelHome5;
    private javax.swing.JPanel panelHome6;
    private javax.swing.JPanel panelLogout;
    private javax.swing.JPanel panelSideBar;
    private javax.swing.JPanel panelSrecord;
    private javax.swing.JPanel panelVallrecord;
    private javax.swing.JPanel paneledit;
    private javax.swing.JPanel panelprint;
    private javax.swing.JTable tbl_courseData;
    private javax.swing.JTextField txt_courseId;
    private javax.swing.JTextField txt_courseName;
    private javax.swing.JTextField txt_coursePrice;
    // End of variables declaration//GEN-END:variables
}
