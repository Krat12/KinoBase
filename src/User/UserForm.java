/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User;

/**
 *
 * @author Admin
 */
public class UserForm extends javax.swing.JFrame {

    public static UserForm user;
    int xx;
    int xy;
    public UserForm() {
        initComponents();
        setLocationRelativeTo(null);
        user = this;
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbl_WatchFilm = new javax.swing.JLabel();
        lbl_BaseFilm = new javax.swing.JLabel();
        lbl_likeFilm = new javax.swing.JLabel();
        lbl_User = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setSize(new java.awt.Dimension(1009, 605));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
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
        jPanel1.setLayout(null);

        lbl_WatchFilm.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_WatchFilm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/clipboard-4-128.png"))); // NOI18N
        lbl_WatchFilm.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_WatchFilm.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lbl_WatchFilmMouseMoved(evt);
            }
        });
        lbl_WatchFilm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbl_WatchFilmMouseExited(evt);
            }
        });
        jPanel1.add(lbl_WatchFilm);
        lbl_WatchFilm.setBounds(45, 166, 211, 200);

        lbl_BaseFilm.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_BaseFilm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/play-128.png"))); // NOI18N
        lbl_BaseFilm.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_BaseFilm.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lbl_BaseFilmMouseMoved(evt);
            }
        });
        lbl_BaseFilm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_BaseFilmMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbl_BaseFilmMouseExited(evt);
            }
        });
        jPanel1.add(lbl_BaseFilm);
        lbl_BaseFilm.setBounds(284, 166, 200, 200);

        lbl_likeFilm.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_likeFilm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/favorite-4-128.png"))); // NOI18N
        lbl_likeFilm.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_likeFilm.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lbl_likeFilmMouseMoved(evt);
            }
        });
        lbl_likeFilm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_likeFilmMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbl_likeFilmMouseExited(evt);
            }
        });
        jPanel1.add(lbl_likeFilm);
        lbl_likeFilm.setBounds(521, 166, 211, 200);

        lbl_User.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_User.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/User.png"))); // NOI18N
        lbl_User.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_User.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lbl_UserMouseMoved(evt);
            }
        });
        lbl_User.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbl_UserMouseExited(evt);
            }
        });
        jPanel1.add(lbl_User);
        lbl_User.setBounds(758, 166, 211, 200);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 161, 97));
        jLabel5.setText("Профиль");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(830, 340, 80, 17);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 161, 97));
        jLabel6.setText(" База фильмов");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(330, 340, 120, 20);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 161, 97));
        jLabel7.setText("Просмотренные фильмы");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(60, 340, 190, 17);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 161, 97));
        jLabel8.setText("Избранные фильмы");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(560, 340, 150, 17);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setText("X");
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel9);
        jLabel9.setBounds(990, 0, 20, 22);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1009, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 605, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lbl_WatchFilmMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_WatchFilmMouseMoved
       lbl_WatchFilm.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,161,97)));
    }//GEN-LAST:event_lbl_WatchFilmMouseMoved

    private void lbl_WatchFilmMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_WatchFilmMouseExited
       lbl_WatchFilm.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,255,255)));

    }//GEN-LAST:event_lbl_WatchFilmMouseExited

    private void lbl_BaseFilmMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_BaseFilmMouseMoved
       lbl_BaseFilm.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,161,97)));
    }//GEN-LAST:event_lbl_BaseFilmMouseMoved

    private void lbl_BaseFilmMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_BaseFilmMouseExited
       lbl_BaseFilm.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,255,255)));
    }//GEN-LAST:event_lbl_BaseFilmMouseExited

    private void lbl_likeFilmMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_likeFilmMouseMoved
        lbl_likeFilm.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,161,97)));
    }//GEN-LAST:event_lbl_likeFilmMouseMoved

    private void lbl_likeFilmMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_likeFilmMouseClicked
       
    }//GEN-LAST:event_lbl_likeFilmMouseClicked

    private void lbl_UserMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_UserMouseMoved
      lbl_User.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,161,97)));
    }//GEN-LAST:event_lbl_UserMouseMoved

    private void lbl_UserMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_UserMouseExited
      lbl_User.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,255,255)));
    }//GEN-LAST:event_lbl_UserMouseExited

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel9MouseClicked

    private void lbl_likeFilmMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_likeFilmMouseExited
      lbl_likeFilm.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,255,255)));
    }//GEN-LAST:event_lbl_likeFilmMouseExited

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
      int x = evt.getXOnScreen();
      int y = evt.getYOnScreen();
      this.setLocation(x-xx, y-xy);
    }//GEN-LAST:event_jPanel1MouseDragged

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        setOpacity((float)0.7);
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_jPanel1MousePressed

    private void jPanel1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseReleased
        setOpacity((float)1.0);
    }//GEN-LAST:event_jPanel1MouseReleased

    private void lbl_BaseFilmMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_BaseFilmMouseClicked
        BaseFilm base = new BaseFilm();
        this.dispose();
        base.setVisible(true);
    }//GEN-LAST:event_lbl_BaseFilmMouseClicked

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
            java.util.logging.Logger.getLogger(UserForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbl_BaseFilm;
    private javax.swing.JLabel lbl_User;
    private javax.swing.JLabel lbl_WatchFilm;
    private javax.swing.JLabel lbl_likeFilm;
    // End of variables declaration//GEN-END:variables
}
