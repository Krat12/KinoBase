/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User;

import java.awt.BorderLayout;
import javax.swing.JFrame;

/**
 *
 * @author Admin
 */
public class BaseFilm extends javax.swing.JFrame {

    
  
    
    public BaseFilm() {
        initComponents();
        JFrame();
        
    }

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menu = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lbl_main = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lbl_top100 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        chance = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        lbl_help = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 51, 102));

        menu.setBackground(new java.awt.Color(255, 161, 97));
        menu.setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(255, 161, 97));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_Batman_Logo_96px.png"))); // NOI18N

        jLabel2.setBackground(new java.awt.Color(255, 161, 97));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("КиноБаза");

        jPanel3.setBackground(new java.awt.Color(255, 161, 97));
        jPanel3.setPreferredSize(new java.awt.Dimension(102, 22));

        lbl_main.setBackground(new java.awt.Color(255, 161, 97));
        lbl_main.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_main.setForeground(new java.awt.Color(255, 255, 255));
        lbl_main.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_main.setText("Главная");
        lbl_main.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_main.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lbl_mainMouseMoved(evt);
            }
        });
        lbl_main.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_mainMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbl_mainMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_main, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_main, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(255, 161, 97));

        lbl_top100.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_top100.setForeground(new java.awt.Color(255, 255, 255));
        lbl_top100.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_top100.setText("Топ-100 ");
        lbl_top100.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_top100.setPreferredSize(new java.awt.Dimension(78, 2));
        lbl_top100.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lbl_top100MouseMoved(evt);
            }
        });
        lbl_top100.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbl_top100MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_top100, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_top100, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel4.setBackground(new java.awt.Color(255, 161, 97));
        jPanel4.setPreferredSize(new java.awt.Dimension(101, 22));

        chance.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        chance.setForeground(new java.awt.Color(255, 255, 255));
        chance.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        chance.setText("Случайное");
        chance.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        chance.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                chanceMouseMoved(evt);
            }
        });
        chance.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                chanceMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(chance, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(chance, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel5.setBackground(new java.awt.Color(255, 161, 97));

        lbl_help.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_help.setForeground(new java.awt.Color(255, 255, 255));
        lbl_help.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_help.setText("Помощь");
        lbl_help.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_help.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lbl_helpMouseMoved(evt);
            }
        });
        lbl_help.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbl_helpMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_help, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_help, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 479, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(24, 24, 24))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        menu.add(jPanel1, java.awt.BorderLayout.PAGE_END);

        jPanel6.setBackground(new java.awt.Color(245, 245, 245));
        jPanel6.setLayout(new java.awt.BorderLayout());

        jPanel7.setBackground(new java.awt.Color(204, 0, 51));
        jPanel7.setLayout(new java.awt.BorderLayout());

        jButton1.setText("jButton1");
        jPanel7.add(jButton1, java.awt.BorderLayout.PAGE_START);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 989, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, 610, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lbl_mainMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_mainMouseMoved
       
       lbl_main.setForeground(new java.awt.Color(255,161,97));
       jPanel3.setBackground(new java.awt.Color(255,255,255));
       
    }//GEN-LAST:event_lbl_mainMouseMoved

    private void lbl_mainMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_mainMouseExited
        jPanel3.setBackground(new java.awt.Color(255,161,97));
        lbl_main.setForeground(new java.awt.Color(255,255,255));
    }//GEN-LAST:event_lbl_mainMouseExited

    private void lbl_top100MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_top100MouseMoved
        lbl_top100.setForeground(new java.awt.Color(255,161,97));
        jPanel2.setBackground(new java.awt.Color(255,255,255));
    }//GEN-LAST:event_lbl_top100MouseMoved

    private void lbl_top100MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_top100MouseExited
        jPanel2.setBackground(new java.awt.Color(255,161,97));
        lbl_top100.setForeground(new java.awt.Color(255,255,255));
    }//GEN-LAST:event_lbl_top100MouseExited

    private void chanceMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chanceMouseMoved
       jPanel4.setBackground(new java.awt.Color(255,255,255));
        chance.setForeground(new java.awt.Color(255,161,97));
    }//GEN-LAST:event_chanceMouseMoved

    private void chanceMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chanceMouseExited
       jPanel4.setBackground(new java.awt.Color(255,161,97));
        chance.setForeground(new java.awt.Color(255,255,255));
    }//GEN-LAST:event_chanceMouseExited

    private void lbl_helpMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_helpMouseMoved
     jPanel5.setBackground(new java.awt.Color(255,255,255));
      lbl_help.setForeground(new java.awt.Color(255,161,97));
    }//GEN-LAST:event_lbl_helpMouseMoved

    private void lbl_helpMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_helpMouseExited
        jPanel5.setBackground(new java.awt.Color(255,161,97));
        lbl_help.setForeground(new java.awt.Color(255,255,255));
    }//GEN-LAST:event_lbl_helpMouseExited

    private void lbl_mainMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_mainMouseClicked
       UserForm user = UserForm.user;
       this.dispose();
       user.setVisible(true);
    }//GEN-LAST:event_lbl_mainMouseClicked

   public void JFrame(){
    setSize(900, 900);
    setLocationRelativeTo(null);
    setVisible(true);
    setExtendedState(MAXIMIZED_BOTH);
   }
    
    
    
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
            java.util.logging.Logger.getLogger(BaseFilm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BaseFilm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BaseFilm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BaseFilm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BaseFilm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel chance;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JLabel lbl_help;
    private javax.swing.JLabel lbl_main;
    private javax.swing.JLabel lbl_top100;
    private javax.swing.JPanel menu;
    // End of variables declaration//GEN-END:variables
}
