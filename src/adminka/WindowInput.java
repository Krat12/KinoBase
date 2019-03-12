/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adminka;




import User.UserForm;
import static adminka.MainWindow.con;
import com.sun.glass.events.KeyEvent;
import java.awt.Font;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;






public class WindowInput extends javax.swing.JFrame{

 private  int xx;
 private  int xy;
 private String status;
 
 public WindowInput() {

     try {
      con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","18lulego123");
    } catch (SQLException ex) {
      Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
    }
        initComponents();
        this.setLocationRelativeTo(null);
        jPanel2.setSize(0, 780);
        Left.setSize(0,0); 
   }
 

 public void Login(){
        
       PreparedStatement ps;
       ResultSet rs;
       
        try {
            ps = con.prepareStatement("SELECT rights FROM User WHERE Name = ? AND Password = ? ");
            ps.setString(1,txt_login.getText());
            ps.setString(2,String.valueOf(txt_password.getPassword()));
            rs = ps.executeQuery();  
           
          
            if (rs.next()){
                status = rs.getString("rights");
                if (status.equals("Admin")){
                    this.dispose();
                    MainWindow mw = new MainWindow();
                    mw.setVisible(true);
                }
                if(status.equals("User")){
                    this.dispose();
                    UserForm userform  = new UserForm(); 
                    userform.setVisible(true);
                }
               
            }else{JOptionPane.showMessageDialog(null,"Неверный логин или пороль");}
        } catch (SQLException ex) {
            Logger.getLogger(WindowInput.class.getName()).log(Level.SEVERE, null, ex);
        }
      
 }
 
 public boolean ChekEmail(){
 
    if (txt_mail.getText().matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")){
        String a = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9]+)*@[A-Z-a-z0-9]+(\\.[_A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        return true;
    }else{ return false;}
 
 }
 
 public boolean CheckEmptiness(){
 
     if(txt_UserName.getText().equals("") 
        || String.valueOf(txt_RegistrPassword.getPassword()).equals("")
        || txt_mail.getText().equals("")
        || String.valueOf(txt_RepeatPassword.getPassword()).equals(""))
     {
         return false;
     
     }else{return true;}
 
 }
 
 public boolean CheckUserName(){
     
     if(txt_UserName.getText().matches("[a-zA-ZА-Яа-я][a-zA-ZА-Яа-я]*")){
     
         return true;
     
     }else{return false;}
 }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txt_login = new javax.swing.JTextField();
        txt_password = new javax.swing.JPasswordField();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        btn_input = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        txt_UserName = new javax.swing.JTextField();
        Left = new javax.swing.JLabel();
        txt_mail = new javax.swing.JTextField();
        txt_RegistrPassword = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btn_Registration = new javax.swing.JButton();
        sep_Password = new javax.swing.JSeparator();
        sep_email = new javax.swing.JSeparator();
        sep_Name = new javax.swing.JSeparator();
        txt_RepeatPassword = new javax.swing.JPasswordField();
        sep_RepeatPassword = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        Image = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(900, 540));
        setUndecorated(true);
        setSize(new java.awt.Dimension(900, 540));
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 161, 97));
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel1MouseDragged(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanel1MouseReleased(evt);
            }
        });

        txt_login.setBackground(new java.awt.Color(255, 161, 97));
        txt_login.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_login.setForeground(new java.awt.Color(255, 255, 255));
        txt_login.setBorder(null);
        txt_login.setCaretColor(new java.awt.Color(255, 255, 255));
        txt_login.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_loginKeyPressed(evt);
            }
        });

        txt_password.setBackground(new java.awt.Color(255, 161, 97));
        txt_password.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txt_password.setForeground(new java.awt.Color(255, 255, 255));
        txt_password.setBorder(null);
        txt_password.setCaretColor(new java.awt.Color(255, 255, 255));
        txt_password.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txt_password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_passwordKeyPressed(evt);
            }
        });

        jCheckBox1.setBackground(new java.awt.Color(255, 161, 97));
        jCheckBox1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBox1.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox1.setText("Просмотреть пороль");
        jCheckBox1.setBorder(null);
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Password");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Name");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("КиноБаза");

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));

        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));

        btn_input.setBackground(new java.awt.Color(255, 161, 97));
        btn_input.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_input.setForeground(new java.awt.Color(255, 255, 255));
        btn_input.setText("Get Started");
        btn_input.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        btn_input.setContentAreaFilled(false);
        btn_input.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_input.setFocusPainted(false);
        btn_input.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_inputActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(txt_login, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txt_password, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox1)
                    .addComponent(btn_input, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel6)
                .addGap(94, 94, 94)
                .addComponent(jLabel5)
                .addGap(6, 6, 6)
                .addComponent(txt_login, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jLabel4)
                .addGap(6, 6, 6)
                .addComponent(txt_password, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jCheckBox1)
                .addGap(61, 61, 61)
                .addComponent(btn_input, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 450, 540);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(null);

        txt_UserName.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_UserName.setForeground(new java.awt.Color(255, 161, 97));
        txt_UserName.setBorder(null);
        txt_UserName.setCaretColor(new java.awt.Color(255, 161, 97));
        jPanel2.add(txt_UserName);
        txt_UserName.setBounds(80, 105, 280, 15);

        Left.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_Sort_Left_40px_3.png"))); // NOI18N
        Left.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Left.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LeftMouseClicked(evt);
            }
        });
        jPanel2.add(Left);
        Left.setBounds(420, 180, 40, 40);

        txt_mail.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_mail.setForeground(new java.awt.Color(255, 161, 97));
        txt_mail.setBorder(null);
        txt_mail.setCaretColor(new java.awt.Color(255, 161, 97));
        jPanel2.add(txt_mail);
        txt_mail.setBounds(80, 225, 280, 15);

        txt_RegistrPassword.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_RegistrPassword.setForeground(new java.awt.Color(255, 161, 97));
        txt_RegistrPassword.setToolTipText("");
        txt_RegistrPassword.setBorder(null);
        txt_RegistrPassword.setCaretColor(new java.awt.Color(255, 161, 97));
        txt_RegistrPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_RegistrPasswordActionPerformed(evt);
            }
        });
        jPanel2.add(txt_RegistrPassword);
        txt_RegistrPassword.setBounds(80, 165, 280, 15);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 161, 97));
        jLabel1.setText("Password");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(80, 140, 80, 17);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 161, 97));
        jLabel7.setText("E-mail");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(80, 200, 50, 17);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 161, 97));
        jLabel8.setText("Confirm password");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(80, 260, 130, 17);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 161, 97));
        jLabel9.setText("Name");
        jPanel2.add(jLabel9);
        jLabel9.setBounds(80, 80, 50, 17);

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 161, 97));
        jLabel10.setText(" Registration");
        jPanel2.add(jLabel10);
        jLabel10.setBounds(70, 10, 115, 22);

        btn_Registration.setBackground(new java.awt.Color(255, 161, 97));
        btn_Registration.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_Registration.setForeground(new java.awt.Color(255, 161, 97));
        btn_Registration.setText("Registration");
        btn_Registration.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 161, 97)));
        btn_Registration.setContentAreaFilled(false);
        btn_Registration.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Registration.setFocusPainted(false);
        btn_Registration.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_RegistrationActionPerformed(evt);
            }
        });
        jPanel2.add(btn_Registration);
        btn_Registration.setBounds(80, 340, 290, 40);

        sep_Password.setBackground(new java.awt.Color(255, 161, 97));
        sep_Password.setForeground(new java.awt.Color(255, 161, 97));
        jPanel2.add(sep_Password);
        sep_Password.setBounds(80, 180, 280, 10);

        sep_email.setBackground(new java.awt.Color(255, 161, 97));
        sep_email.setForeground(new java.awt.Color(255, 161, 97));
        jPanel2.add(sep_email);
        sep_email.setBounds(80, 240, 280, 10);

        sep_Name.setBackground(new java.awt.Color(255, 161, 97));
        sep_Name.setForeground(new java.awt.Color(255, 161, 97));
        jPanel2.add(sep_Name);
        sep_Name.setBounds(80, 120, 280, 10);

        txt_RepeatPassword.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_RepeatPassword.setForeground(new java.awt.Color(255, 161, 97));
        txt_RepeatPassword.setToolTipText("");
        txt_RepeatPassword.setBorder(null);
        txt_RepeatPassword.setCaretColor(new java.awt.Color(255, 161, 97));
        txt_RepeatPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_RepeatPasswordActionPerformed(evt);
            }
        });
        jPanel2.add(txt_RepeatPassword);
        txt_RepeatPassword.setBounds(80, 285, 280, 15);

        sep_RepeatPassword.setBackground(new java.awt.Color(255, 161, 97));
        sep_RepeatPassword.setForeground(new java.awt.Color(255, 161, 97));
        jPanel2.add(sep_RepeatPassword);
        sep_RepeatPassword.setBounds(80, 300, 280, 10);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(450, 30, 450, 790);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 161, 97));
        jLabel2.setText("X");
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel2);
        jLabel2.setBounds(880, 0, 16, 32);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_Horizontal_Line_25px_2.png"))); // NOI18N
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel3);
        jLabel3.setBounds(860, 0, 17, 32);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        Image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_Play_100px.png"))); // NOI18N
        Image.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Image.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ImageMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ImageMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ImageMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(179, Short.MAX_VALUE)
                .addComponent(Image)
                .addGap(171, 171, 171))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(211, 211, 211)
                .addComponent(Image)
                .addContainerGap(229, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel4);
        jPanel4.setBounds(450, 0, 450, 540);

        setSize(new java.awt.Dimension(901, 534));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        if(jCheckBox1.isSelected()){
            txt_password.setEchoChar((char)0);
            Font f = new Font("Tahoma",Font.BOLD,14);
            txt_password.setFont(f);
        }else{txt_password.setEchoChar('●');}
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
      int x = evt.getXOnScreen();
      int y = evt.getYOnScreen();
      this.setLocation(x-xx, y-xy);
    }//GEN-LAST:event_jPanel1MouseDragged

    private void btn_inputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_inputActionPerformed
        Login();
       
    }//GEN-LAST:event_btn_inputActionPerformed

    private void txt_loginKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_loginKeyPressed
          if (evt.getKeyCode()==KeyEvent.VK_ENTER){
            Login();    
      }
    }//GEN-LAST:event_txt_loginKeyPressed

    private void txt_passwordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_passwordKeyPressed
           if (evt.getKeyCode()==KeyEvent.VK_ENTER){
            Login();    
      }
    }//GEN-LAST:event_txt_passwordKeyPressed

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        setOpacity((float)0.7);
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_jPanel1MousePressed

    private void jPanel1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseReleased
        setOpacity((float)1.0);
    }//GEN-LAST:event_jPanel1MouseReleased

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        System.exit(0);
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(WindowInput.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void ImageMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImageMouseExited
       Image.setIcon(new ImageIcon(getClass().getResource("/image/icons8_Play_100px.png")));

    }//GEN-LAST:event_ImageMouseExited

    private void ImageMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImageMouseEntered
        Image.setIcon(new ImageIcon(getClass().getResource("/image/icons8_Play_100px_1.png")));
        

    }//GEN-LAST:event_ImageMouseEntered

    private void ImageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImageMouseClicked

        Thread th = new Thread(){
            
            @Override
            public void run(){
                try{
                    for( int i = 0; i<=6 ; i++){
                        Thread.sleep(20);
                        if (i==1){jPanel2.setSize(75,780); Image.setSize(0,0);
                        Left.setSize(50,50);
                        }
                        if (i==2){jPanel2.setSize(150,780);
                        }
                        if (i==3){jPanel2.setSize(225,780);}
                        if (i==4){jPanel2.setSize(300,780);}
                        if (i==5){jPanel2.setSize(375,780);}
                        if (i==6){jPanel2.setSize(450,780);}

                    
                    }
                
                }catch(Exception ex){
                    System.out.print(ex);
                    
                }
            
            
            }
            
        };th.start();

    }//GEN-LAST:event_ImageMouseClicked

    private void LeftMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LeftMouseClicked
    Thread th = new Thread(){
            
            @Override
            public void run(){
                try{
                    for( int i = 0; i<=6 ; i++){
                        Thread.sleep(20);
                        if (i==1){jPanel2.setSize(375,780);Left.setSize(0,0);
                        }
                        if (i==2){jPanel2.setSize(300,780);}
                        if (i==3){jPanel2.setSize(225,780);}
                        if (i==4){jPanel2.setSize(150,780);}
                        if (i==5){jPanel2.setSize(75,780);}
                        if (i==6){jPanel2.setSize(0,780);Image.setSize(100,100);}
                    }
                
                }catch(Exception ex){
                     System.out.print(ex);
                    
                }
            
            
            }
            
        };th.start();
    }//GEN-LAST:event_LeftMouseClicked

    private void txt_RegistrPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_RegistrPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_RegistrPasswordActionPerformed

    private void btn_RegistrationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RegistrationActionPerformed
        if(CheckEmptiness()){
           if(ChekEmail()){
               if(CheckUserName()){
                 if(String.valueOf(txt_RegistrPassword.getPassword()).equals(String.valueOf(txt_RepeatPassword.getPassword())))
                 {
                     try {
                         PreparedStatement registr = con.prepareStatement("INSERT INTO user(Name,Password,Email,rights) values (?,?,?,?)");
                         registr.setString(1,txt_UserName.getText());
                         registr.setString(2,String.valueOf(txt_RegistrPassword.getPassword()));
                         registr.setString(3, txt_mail.getText());
                         registr.setString(4,"User");
                         JOptionPane.showMessageDialog(null, "Вы успешно зарегистрировались");
                         registr.executeUpdate();
                     } catch (SQLException ex) {
                         Logger.getLogger(WindowInput.class.getName()).log(Level.SEVERE, null, ex);
                     }
                     
                    }else{JOptionPane.showMessageDialog(null, "Пароли не совпадают");}
               }else{JOptionPane.showMessageDialog(null, "В поле 'Name' должны быть только буквы");}
               
            }else{JOptionPane.showMessageDialog(null,"Неправильный адрес электронной почты");}
             
        }else{ JOptionPane.showMessageDialog(null,"Заполните все поля");} 
            
       
    }//GEN-LAST:event_btn_RegistrationActionPerformed

    private void txt_RepeatPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_RepeatPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_RepeatPasswordActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(WindowInput.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WindowInput.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WindowInput.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WindowInput.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WindowInput().setVisible(true);
            }
        });
        
        
    }

    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Image;
    private javax.swing.JLabel Left;
    private javax.swing.JButton btn_Registration;
    private javax.swing.JButton btn_input;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator sep_Name;
    private javax.swing.JSeparator sep_Password;
    private javax.swing.JSeparator sep_RepeatPassword;
    private javax.swing.JSeparator sep_email;
    private javax.swing.JPasswordField txt_RegistrPassword;
    private javax.swing.JPasswordField txt_RepeatPassword;
    private javax.swing.JTextField txt_UserName;
    private javax.swing.JTextField txt_login;
    private javax.swing.JTextField txt_mail;
    private javax.swing.JPasswordField txt_password;
    // End of variables declaration//GEN-END:variables
}
