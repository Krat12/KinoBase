package adminka;

import com.sun.glass.events.KeyEvent;
import java.awt.Color;

import java.awt.HeadlessException;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author Admin
 */
public class MainWindow extends javax.swing.JFrame {

    public static Connection con;
    public static MainWindow frmMain;
    public ImageIcon myImage;
    public ImageIcon image;
    public static Image img2;
    private int PeopleID;

    public MainWindow() {

        initComponents();

        ShowFilmInJTable();
        CmbCurrency();
        ShowStudioInJTable();
        ShowHasFilmGenreInJTable();
        ShowGenreInJTable();
        ShowAwardInJTable();
        ShowPeopleinTable();
        ShowStatusInJTable();
        frmMain = this;
        //Jframe();
        setFocusable(true);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setSize(900, 900);
        setLocationRelativeTo(null);

    }

    String ID;
    String ID2;
    String ImagePatch;
    String Currency;
    int cardshow = 1;
    int id_genre;
    int GenreID;
    String txt_factor;
    String FilmNameID;
    String FilmNameID2;
    int factor;
    int FilmAwardID;
    int factorID;
    int Proverka;
    int SurnID;
    public String CheckFilm;
    private String txt_factor2;
    private String text = "";

    public ImageIcon ResizeImage(String imagePath, byte[] pic) {

        if (imagePath != null) {
            myImage = new ImageIcon(imagePath);

        } else {
            myImage = new ImageIcon(pic);
            System.out.println(myImage);
        }
        img2 = myImage.getImage().getScaledInstance(lbl_Image.getWidth(), lbl_Image.getHeight(), Image.SCALE_SMOOTH);
        myImage = null;
        System.gc();
        //  System.out.println(myImage);

        if (image == null) {
            image = new ImageIcon(img2);

        } else {
            image = null;

        }
        if (image == null) {

            image = new ImageIcon(img2);

        }
        return image;

    }

    public void ShowPeopleinTable() {
        MyQuery mq = new MyQuery();
        ArrayList<People> peoplelist = mq.getPeople();
        DefaultTableModel model = (DefaultTableModel) jTable6.getModel();
        model.setRowCount(0);
        Object[] row;
        for (int i = 0; i < peoplelist.size(); i++) {
            row = (Object[]) peoplelist.get(i).getRow();
            model.addRow(row);
        }
        jTable6.setModel(model);

    }

    public void ShowFilmInJTable() {
        //  jTable1.getColumnModel().getColumn(0).setCellRenderer(new Render());
        txt_NameStudio.setEditable(false);
        txt_NameFilm1.setEditable(false);
        jPanel3.setVisible(false);

        MyQuery mq = new MyQuery();
        // ArrayList<Film> list =mq.getFilmList();
        // ArrayList<Film> SearchList =mq.getSearchList(txt_search.getText());
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);

        if (txt_search.getText().trim().length() > 0) {
            ArrayList<Film> SearchList = mq.getSearchList(txt_search.getText());
            Object[] row;
            for (int i = 0; i < SearchList.size(); i++) {
                row = (Object[]) SearchList.get(i).getRow();
                model.addRow(row);
            }

        } else {
            ArrayList<Film> list = mq.getFilmList();
            Object[] row2 = new Object[5];
            for (int i = 0; i < list.size(); i++) {
                row2 = (Object[]) list.get(i).getRow();

                model.addRow(row2);
            }
        }

        jTable1.setModel(model);
    }

    public void ShowStudioInJTable() {
        jTable2.setAutoResizeMode(jTable2.AUTO_RESIZE_OFF);
        TableColumn col = jTable2.getColumnModel().getColumn(1);
        col.setPreferredWidth(200);
        col = jTable2.getColumnModel().getColumn(2);
        col.setPreferredWidth(157);
        col = jTable2.getColumnModel().getColumn(0);
        col.setPreferredWidth(200);
        MyQuery mq = new MyQuery();
        ArrayList<Studio> list = mq.getStidioList();
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();

        model.setRowCount(0);
        Object[] row;
        for (int i = 0; i < list.size(); i++) {
            row = (Object[]) list.get(i).getStudioRow();

            model.addRow(row);
        }
    }

    public void ShowAwardInJTable() {

        jTable5.setAutoResizeMode(jTable5.AUTO_RESIZE_OFF);
        TableColumn col = jTable5.getColumnModel().getColumn(0);
        col.setPreferredWidth(330);
        col = jTable5.getColumnModel().getColumn(1);
        col.setPreferredWidth(75);
        col = jTable5.getColumnModel().getColumn(2);
        col.setPreferredWidth(380);
        col = jTable5.getColumnModel().getColumn(3);
        col.setPreferredWidth(123);
        MyQuery mq = new MyQuery();
        ArrayList<Award> Awardlist = mq.getAwardList();
        DefaultTableModel model = (DefaultTableModel) jTable5.getModel();

        model.setRowCount(0);
        Object[] row = new Object[5];
        for (int i = 0; i < Awardlist.size(); i++) {
            row[0] = Awardlist.get(i).getNameFilm();
            row[1] = Awardlist.get(i).getAwardFilm();
            row[2] = Awardlist.get(i).getNomination();
            row[3] = Awardlist.get(i).getDateAward();

            model.addRow(row);
        }
        jTable5.setModel(model);
    }

    public void ShowHasFilmGenreInJTable() {

        jTable3.setAutoResizeMode(jTable3.AUTO_RESIZE_OFF);
        TableColumn col = jTable3.getColumnModel().getColumn(0);
        col.setPreferredWidth(186);
        MyQuery mq = new MyQuery();
        ArrayList<FilmHasGenre> FilmHasGenreList = mq.getGenreHasFilm(txt_genre.getText());

        ArrayList<Film> FilmHasGenreList2 = mq.getSearchList(txt_genre.getText());
        DefaultTableModel model = (DefaultTableModel) jTable3.getModel();
        model.setRowCount(0);
        text = "";
        Object[] row = new Object[2];
        for (int i = 0; i < FilmHasGenreList.size(); i++) {
            row = (Object[]) (FilmHasGenreList.get(i).geGenreInRow());
            model.addRow(row);
            id_genre = FilmHasGenreList.get(i).getid();

            text = text + FilmHasGenreList.get(i).getGenreFilm() + ",";

        }
        txt_probagenre.setText(text);
        text = "";

        for (int i = 0; i < FilmHasGenreList2.size(); i++) {
            FilmNameID = Integer.toString(FilmHasGenreList2.get(i).getNameFilmID());

        }
    }

    public void ShowStatusInJTable() {

        MyQuery mq = new MyQuery();
        ArrayList<Status> StatusList = mq.getStatus(txt_NameFilm3.getText());
        DefaultTableModel model = (DefaultTableModel) jTable7.getModel();
        model.setRowCount(0);
        Object[] row;
        for (int i = 0; i < StatusList.size(); i++) {
            row = (Object[]) (StatusList.get(i).getPeopleRow());
            model.addRow(row);
        }
    }

    public void ShowItemStatus(int index) {

        MyQuery mq = new MyQuery();
        PeopleID = mq.getStatus(txt_NameFilm3.getText()).get(index).getPeopleID();

    }

    public void ShowItemPeople(int index) {
        MyQuery mq = new MyQuery();

        SurnID = mq.getPeople().get(index).getSurnID();

    }

    public void ShowGenreInJTable() {
        jTable4.setAutoResizeMode(jTable4.AUTO_RESIZE_OFF);
        TableColumn col = jTable4.getColumnModel().getColumn(0);
        col.setPreferredWidth(186);
        MyQuery mq = new MyQuery();
        ArrayList<Genre> list = mq.getGenre();
        DefaultTableModel model = (DefaultTableModel) jTable4.getModel();

        model.setRowCount(0);
        Object[] row = new Object[2];
        for (int i = 0; i < list.size(); i++) {
            row = (Object[]) (list.get(i).getRow());
            model.addRow(row);

        }

    }

    public void ShowItemAward(int index) {
        MyQuery mq = new MyQuery();
        FilmAwardID = mq.getAwardList().get(index).getFilmAwardID();
        txt_award.setText(mq.getAwardList().get(index).getAwardFilm());
        txt_nomination.setText(mq.getAwardList().get(index).getNomination());

        Date addDate = null;
        try {
            addDate = new SimpleDateFormat("yyyy-MM-dd").parse(mq.getAwardList().get(index).getDateAward());
        } catch (ParseException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        txt_DateFaund.setDate(addDate);
        txt_NameFilm1.setText(mq.getAwardList().get(index).getNameFilm());
        factor = mq.getAwardList().get(index).getFilmAwardID();
        factorID = mq.getAwardList().get(index).getNameFilmID_FK();
        ID = Integer.toString(mq.getAwardList().get(index).getNameFilmID_FK());

    }

    public void ShowItemGenre(int index) {
        MyQuery mq = new MyQuery();
        GenreID = mq.getGenre().get(index).getGenreID();

    }

    public void ShowItemFilmHasGenre(int index) {
        MyQuery mq = new MyQuery();
        id_genre = mq.getGenreHasFilm(txt_genre.getText()).get(index).getid();
        txt_factor = mq.getGenreHasFilm(txt_genre.getText()).get(index).getGenreFilm();

    }

    public void ShowItemFilm(int index) {
        MyQuery mq = new MyQuery();

        if (txt_search.getText().trim().length() > 0) {

            CheckFilm = mq.getSearchList(txt_search.getText()).get(index).getNameFilm();
            txt_NameFilm.setText(mq.getSearchList(txt_search.getText()).get(index).getNameFilm());
            txt_budget.setText(Integer.toString(mq.getSearchList(txt_search.getText()).get(index).getBudget()));
            txt_NameStudio.setText(mq.getSearchList(txt_search.getText()).get(index).getNameStud());
            ID = Integer.toString(mq.getSearchList(txt_search.getText()).get(index).getNameFilmID());
            ID2 = Integer.toString(mq.getSearchList(txt_search.getText()).get(index).getID2());
            cmb_Currency.setSelectedItem(mq.getSearchList(txt_search.getText()).get(index).getSign());
            txt_genre.setText(mq.getSearchList(txt_search.getText()).get(index).getNameFilm());
            txt_NameFilm3.setText(mq.getSearchList(txt_search.getText()).get(index).getNameFilm());
            factorID = mq.getSearchList(txt_search.getText()).get(index).getNameFilmID();

            try {
                Date addDate = null;
                addDate = new SimpleDateFormat("yyyy-MM-dd").parse((String) mq.getSearchList(txt_search.getText()).get(index).getDateFilm());
                txt_DateFilm.setDate(addDate);

            } catch (ParseException ex) {
                Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
            }

            lbl_Image.setIcon(ResizeImage(null, mq.getSearchList(txt_search.getText()).get(index).getImage()));

        } else {
            CheckFilm = mq.getFilmList().get(index).getNameFilm();
            txt_NameFilm.setText(mq.getFilmList().get(index).getNameFilm());
            txt_budget.setText(Integer.toString(mq.getFilmList().get(index).getBudget()));
            txt_NameStudio.setText(mq.getFilmList().get(index).getNameStud());
            ID = Integer.toString(mq.getFilmList().get(index).getNameFilmID());
            ID2 = Integer.toString(mq.getFilmList().get(index).getID2());
            cmb_Currency.setSelectedItem(mq.getSearchList(txt_search.getText()).get(index).getSign());
            txt_genre.setText(mq.getFilmList().get(index).getNameFilm());
            factorID = mq.getFilmList().get(index).getNameFilmID();
            txt_NameFilm3.setText(mq.getFilmList().get(index).getNameFilm());

            try {
                Date addDate = null;
                addDate = new SimpleDateFormat("yyyy-MM-dd").parse((String) mq.getFilmList().get(index).getDateFilm());
                txt_DateFilm.setDate(addDate);

            } catch (ParseException ex) {
                Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
            }

            lbl_Image.setIcon(ResizeImage(null, mq.getFilmList().get(index).getImage()));

        }

    }

    public void ShowItemStudio(int index) {

        MyQuery mq = new MyQuery();

        txt_NameStudio2.setText(mq.getStidioList().get(index).getNameStudio());
        txt_Director.setText(mq.getStidioList().get(index).getDirector());
        ID2 = Integer.toString(mq.getStidioList().get(index).getID2());
        txt_NameStudio.setText(mq.getStidioList().get(index).getNameStudio());
        try {
            Date addDate = null;
            addDate = new SimpleDateFormat("yyyy-MM-dd").parse((String) mq.getStidioList().get(index).getDateStudio());
            txt_DateStudio.setDate(addDate);

        } catch (ParseException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void CmbCurrency() {
        Statement st;
        ResultSet rs;
        cmb_Currency.removeAllItems();
        try {
            st = con.createStatement();
            rs = st.executeQuery("SELECT Sign,CurrencyID FROM Currency");
            while (rs.next()) {
                cmb_Currency.addItem(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean CheckInput() {
        if (txt_budget.getText() == null
                || txt_DateFilm.getDate() == null) {
            return false;
        } else {
            try {
                Integer.parseInt(txt_budget.getText());
                return true;
            } catch (Exception ex) {
                return false;
            }

        }
    }

    public boolean CheckInputStudio() {
        if (txt_NameStudio2.getText().trim().length() > 0
                && txt_Director.getText().trim().length() > 0
                && txt_DateStudio.getDate() != null) {
            return true;
        } else {
            return false;
        }

    }

    public void ForSelectFilm(int index) {

        MyQuery mq = new MyQuery();
        if (txt_search.getText().trim().length() > 0) {
            factor = mq.getSearchList(txt_search.getText()).get(index).getNameFilmID();
            factorID = mq.getSearchList(txt_search.getText()).get(index).getNameFilmID();
            txt_genre.setText(mq.getSearchList(txt_search.getText()).get(index).getNameFilm());
            Proverka = mq.getSearchList(txt_search.getText()).get(index).getNameFilmID();
            txt_NameFilm3.setText(mq.getSearchList(txt_search.getText()).get(index).getNameFilm());

        } else {
            factor = mq.getFilmList().get(index).getNameFilmID();
            factorID = mq.getFilmList().get(index).getNameFilmID();
            txt_genre.setText(mq.getFilmList().get(index).getNameFilm());
            Proverka = mq.getFilmList().get(index).getNameFilmID();
            txt_NameFilm3.setText(mq.getFilmList().get(index).getNameFilm());
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel9 = new javax.swing.JPanel();
        sidePane = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        btn_Home = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btn_studio = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btn_award = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btn_people = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btn_genre = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        btn_image = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btn_insert = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        Btn_update = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        btn_delete = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        Parent = new javax.swing.JPanel();
        Home = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel28 = new javax.swing.JLabel();
        txt_search = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btn_add_Film8 = new javax.swing.JPanel();
        jLabel63 = new javax.swing.JLabel();
        txt_NameFilm = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        txt_NameStudio = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        txt_budget = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        cmb_Currency = new javax.swing.JComboBox<>();
        txt_DateFilm = new com.toedter.calendar.JDateChooser();
        jLabel26 = new javax.swing.JLabel();
        lbl_Image = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txt_probagenre = new javax.swing.JTextField();
        jLabel57 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        studio = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        txt_NameStudio2 = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        txt_Director = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        txt_DateStudio = new com.toedter.calendar.JDateChooser();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        genre = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        txt_genre = new javax.swing.JTextField();
        btn_add_Film6 = new javax.swing.JPanel();
        jLabel67 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        people = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        txt_NameFilm3 = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        txt_Status = new javax.swing.JTextField();
        jLabel50 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable6 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable7 = new javax.swing.JTable();
        btn_add_Film7 = new javax.swing.JPanel();
        jLabel68 = new javax.swing.JLabel();
        txt_Surn = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        award = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        jLabel55 = new javax.swing.JLabel();
        btn_add_Film5 = new javax.swing.JPanel();
        jLabel62 = new javax.swing.JLabel();
        txt_NameFilm1 = new javax.swing.JTextField();
        txt_award = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        txt_nomination = new javax.swing.JTextField();
        txt_DateFaund = new com.toedter.calendar.JDateChooser();
        jLabel56 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAutoRequestFocus(false);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocationByPlatform(true);
        setSize(new java.awt.Dimension(1000, 1080));

        jPanel9.setBackground(new java.awt.Color(255, 204, 204));
        jPanel9.setLayout(new javax.swing.BoxLayout(jPanel9, javax.swing.BoxLayout.LINE_AXIS));

        sidePane.setBackground(new java.awt.Color(255, 190, 90));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("КиноБаза");

        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("____________________________");

        btn_Home.setBackground(new java.awt.Color(255, 190, 90));
        btn_Home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_HomeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_HomeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_HomeMouseExited(evt);
            }
        });
        btn_Home.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_Home_15px_2.png"))); // NOI18N
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_Home.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 0, 32, 50));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Главная");
        jLabel11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Home.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 11, 64, 28));

        btn_studio.setBackground(new java.awt.Color(255, 190, 90));
        btn_studio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_studioMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_studioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_studioMouseExited(evt);
            }
        });

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_Batman_18px.png"))); // NOI18N
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Студия");
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout btn_studioLayout = new javax.swing.GroupLayout(btn_studio);
        btn_studio.setLayout(btn_studioLayout);
        btn_studioLayout.setHorizontalGroup(
            btn_studioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_studioLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btn_studioLayout.setVerticalGroup(
            btn_studioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btn_studioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
        );

        btn_award.setBackground(new java.awt.Color(255, 190, 90));
        btn_award.setPreferredSize(new java.awt.Dimension(380, 50));
        btn_award.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_awardMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_awardMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_awardMouseExited(evt);
            }
        });

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_Trophy_15px_1.png"))); // NOI18N
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Награды");
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout btn_awardLayout = new javax.swing.GroupLayout(btn_award);
        btn_award.setLayout(btn_awardLayout);
        btn_awardLayout.setHorizontalGroup(
            btn_awardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_awardLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btn_awardLayout.setVerticalGroup(
            btn_awardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btn_awardLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
        );

        btn_people.setBackground(new java.awt.Color(255, 190, 90));
        btn_people.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_peopleMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_peopleMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_peopleMouseExited(evt);
            }
        });

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_People_15px_2.png"))); // NOI18N
        jLabel7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Люди");
        jLabel8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout btn_peopleLayout = new javax.swing.GroupLayout(btn_people);
        btn_people.setLayout(btn_peopleLayout);
        btn_peopleLayout.setHorizontalGroup(
            btn_peopleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_peopleLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btn_peopleLayout.setVerticalGroup(
            btn_peopleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btn_peopleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
        );

        btn_genre.setBackground(new java.awt.Color(255, 190, 90));
        btn_genre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_genreMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_genreMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_genreMouseExited(evt);
            }
        });

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_Theatre_Mask_15px.png"))); // NOI18N
        jLabel13.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Жанры");
        jLabel14.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout btn_genreLayout = new javax.swing.GroupLayout(btn_genre);
        btn_genre.setLayout(btn_genreLayout);
        btn_genreLayout.setHorizontalGroup(
            btn_genreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_genreLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btn_genreLayout.setVerticalGroup(
            btn_genreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btn_genreLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
        );

        btn_image.setBackground(new java.awt.Color(255, 190, 90));
        btn_image.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_imageMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_imageMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_imageMouseExited(evt);
            }
        });

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_Photo_Gallery_15px.png"))); // NOI18N
        jLabel9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Выбрать картинку");
        jLabel10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout btn_imageLayout = new javax.swing.GroupLayout(btn_image);
        btn_image.setLayout(btn_imageLayout);
        btn_imageLayout.setHorizontalGroup(
            btn_imageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_imageLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btn_imageLayout.setVerticalGroup(
            btn_imageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btn_imageLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
        );

        btn_insert.setBackground(new java.awt.Color(255, 190, 90));
        btn_insert.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_insertMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_insertMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_insertMouseExited(evt);
            }
        });

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_Add_Database_15px_1.png"))); // NOI18N
        jLabel15.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Добавить");
        jLabel16.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout btn_insertLayout = new javax.swing.GroupLayout(btn_insert);
        btn_insert.setLayout(btn_insertLayout);
        btn_insertLayout.setHorizontalGroup(
            btn_insertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_insertLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btn_insertLayout.setVerticalGroup(
            btn_insertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btn_insertLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
        );

        Btn_update.setBackground(new java.awt.Color(255, 190, 90));
        Btn_update.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Btn_updateMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Btn_updateMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Btn_updateMouseExited(evt);
            }
        });

        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_Update_15px_1.png"))); // NOI18N
        jLabel17.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Изменить");
        jLabel18.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout Btn_updateLayout = new javax.swing.GroupLayout(Btn_update);
        Btn_update.setLayout(Btn_updateLayout);
        Btn_updateLayout.setHorizontalGroup(
            Btn_updateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Btn_updateLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );
        Btn_updateLayout.setVerticalGroup(
            Btn_updateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Btn_updateLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
        );

        btn_delete.setBackground(new java.awt.Color(255, 190, 90));
        btn_delete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_deleteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_deleteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_deleteMouseExited(evt);
            }
        });

        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_Delete_Database_15px_1.png"))); // NOI18N
        jLabel19.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Удалить");
        jLabel20.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout btn_deleteLayout = new javax.swing.GroupLayout(btn_delete);
        btn_delete.setLayout(btn_deleteLayout);
        btn_deleteLayout.setHorizontalGroup(
            btn_deleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_deleteLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btn_deleteLayout.setVerticalGroup(
            btn_deleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btn_deleteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout sidePaneLayout = new javax.swing.GroupLayout(sidePane);
        sidePane.setLayout(sidePaneLayout);
        sidePaneLayout.setHorizontalGroup(
            sidePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sidePaneLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(sidePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(Btn_update, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_insert, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_image, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_genre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_people, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_studio, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_Home, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_delete, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_award, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sidePaneLayout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(sidePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(sidePaneLayout.createSequentialGroup()
                        .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(23, 23, 23))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sidePaneLayout.createSequentialGroup()
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(80, 80, 80))))
        );
        sidePaneLayout.setVerticalGroup(
            sidePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidePaneLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(sidePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(sidePaneLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(btn_Home, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btn_studio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btn_award, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btn_people, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btn_genre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btn_image, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btn_insert, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(Btn_update, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1476, Short.MAX_VALUE))
        );

        jPanel9.add(sidePane);

        Parent.setBackground(new java.awt.Color(255, 0, 102));
        Parent.setLayout(new java.awt.CardLayout());

        Home.setBackground(new java.awt.Color(204, 153, 0));
        Home.setLayout(new javax.swing.BoxLayout(Home, javax.swing.BoxLayout.Y_AXIS));

        jPanel7.setBackground(new java.awt.Color(255, 161, 97));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Основаня информация о фильмах ");

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Administration/Films");

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_Search_25px_2.png"))); // NOI18N
        jLabel28.setText("jLabel28");
        jLabel28.setAutoscrolls(true);
        jLabel28.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel28.setDoubleBuffered(true);
        jLabel28.setFocusCycleRoot(true);
        jLabel28.setFocusTraversalPolicyProvider(true);
        jLabel28.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel28MouseClicked(evt);
            }
        });

        txt_search.setBackground(new java.awt.Color(255, 161, 97));
        txt_search.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_search.setForeground(new java.awt.Color(255, 255, 255));
        txt_search.setAutoscrolls(false);
        txt_search.setBorder(null);
        txt_search.setCaretColor(new java.awt.Color(255, 255, 255));
        txt_search.setVerifyInputWhenFocusTarget(false);
        txt_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_searchActionPerformed(evt);
            }
        });
        txt_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_searchKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 358, Short.MAX_VALUE)
                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSeparator1)
                            .addComponent(txt_search, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE))
                        .addGap(157, 157, 157))))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Home.add(jPanel7);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        btn_add_Film8.setBackground(new java.awt.Color(255, 161, 97));

        jLabel63.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel63.setForeground(new java.awt.Color(255, 255, 255));
        jLabel63.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel63.setText("Выбрать студию");
        jLabel63.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel63.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel63.setDoubleBuffered(true);
        jLabel63.setFocusCycleRoot(true);
        jLabel63.setFocusTraversalPolicyProvider(true);
        jLabel63.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel63MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btn_add_Film8Layout = new javax.swing.GroupLayout(btn_add_Film8);
        btn_add_Film8.setLayout(btn_add_Film8Layout);
        btn_add_Film8Layout.setHorizontalGroup(
            btn_add_Film8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        btn_add_Film8Layout.setVerticalGroup(
            btn_add_Film8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btn_add_Film8Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        txt_NameFilm.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel25.setText("Название фильма:");

        txt_NameStudio.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_NameStudio.setText("Выберите студию");
        txt_NameStudio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_NameStudioActionPerformed(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel24.setText("Студия:");

        txt_budget.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel23.setText("Бюджет:");

        cmb_Currency.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmb_Currency.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmb_Currency.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_CurrencyActionPerformed(evt);
            }
        });

        txt_DateFilm.setBackground(new java.awt.Color(255, 255, 255));
        txt_DateFilm.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel26.setText("Дата создание фильма:");

        lbl_Image.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_Image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/default.png"))); // NOI18N
        lbl_Image.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Слой 12.png"))); // NOI18N
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txt_probagenre.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel57.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel57.setText("Жанры:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addComponent(lbl_Image, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(144, 144, 144)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel57)
                                    .addComponent(jLabel24)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel26))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_budget, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txt_NameStudio, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmb_Currency, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txt_NameFilm, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txt_DateFilm, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn_add_Film8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txt_probagenre, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_NameFilm, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_budget, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_NameStudio, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmb_Currency, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel57)
                    .addComponent(txt_probagenre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txt_DateFilm, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel26))
                    .addComponent(btn_add_Film8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(lbl_Image, javax.swing.GroupLayout.PREFERRED_SIZE, 562, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(400, 400, 400)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(1296, 1296, 1296))
        );

        jScrollPane1.setBorder(null);

        jTable1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jTable1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "NameFilm", "NameStudio", "Budget", "Val", "DateFilm"
            }
        ){public boolean isCellEditable(int row, int column){return false;}});
        jTable1.setAlignmentX(0.1F);
        jTable1.setAlignmentY(0.1F);
        jTable1.setGridColor(new java.awt.Color(255, 255, 255));
        jTable1.setIntercellSpacing(new java.awt.Dimension(5, 5));
        jTable1.setRowHeight(25);
        jTable1.setSelectionBackground(new java.awt.Color(255, 161, 97));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable1KeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 888, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1298, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 113, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1066, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Home.add(jPanel5);

        Parent.add(Home, "card2");

        studio.setBackground(new java.awt.Color(204, 153, 0));
        studio.setLayout(new javax.swing.BoxLayout(studio, javax.swing.BoxLayout.PAGE_AXIS));

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setFocusTraversalPolicyProvider(true);

        jLabel30.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel30.setText(" Author Igor Romanov");

        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_Java_48px.png"))); // NOI18N
        jLabel31.setText("jLabel29");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel30)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1429, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel30, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        studio.add(jPanel10);

        jPanel11.setBackground(new java.awt.Color(255, 161, 97));
        jPanel11.setPreferredSize(new java.awt.Dimension(1679, 139));

        jLabel32.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("Основаня информация о студии ______________________________________________");

        jLabel33.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("Administration/Studio");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 1406, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(195, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        studio.add(jPanel11);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        txt_NameStudio2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel34.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel34.setText("  Название студии:");

        jLabel35.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel35.setText("Директор:");

        txt_Director.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_Director.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_DirectorActionPerformed(evt);
            }
        });

        jLabel37.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel37.setText("Дата создание студии:");

        txt_DateStudio.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jTable2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NameStudio", "Director", "DateStudio"
            }
        ){public boolean isCellEditable(int row, int column){return false;}});
        jTable2.setGridColor(new java.awt.Color(255, 255, 255));
        jTable2.setIntercellSpacing(new java.awt.Dimension(5, 5));
        jTable2.setRowHeight(25);
        jTable2.setSelectionBackground(new java.awt.Color(255, 161, 97));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel35)
                            .addComponent(jLabel34))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_Director, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                            .addComponent(txt_NameStudio2)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel37)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_DateStudio, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 602, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 562, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_NameStudio2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_Director, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel37)
                    .addComponent(txt_DateStudio, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1815, Short.MAX_VALUE)
        );

        studio.add(jPanel6);

        Parent.add(studio, "card2");

        genre.setBackground(new java.awt.Color(204, 153, 0));
        genre.setLayout(new javax.swing.BoxLayout(genre, javax.swing.BoxLayout.PAGE_AXIS));

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setFocusTraversalPolicyProvider(true);

        jLabel36.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel36.setText(" Author Igor Romanov");

        jLabel38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_Java_48px.png"))); // NOI18N
        jLabel38.setText("jLabel29");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel36)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1416, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel36, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel38, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        genre.add(jPanel12);

        jPanel13.setBackground(new java.awt.Color(255, 161, 97));
        jPanel13.setPreferredSize(new java.awt.Dimension(1679, 139));

        jLabel39.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setText("Основаня информация о жанрах ______________________________________________");

        jLabel40.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setText("Administration/Genre");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 1406, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(182, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        genre.add(jPanel13);

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane6.setBorder(null);

        jTable4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jTable4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Genre"
            }
        ){public boolean isCellEditable(int row, int column){return false;}});
        jTable4.setGridColor(new java.awt.Color(255, 255, 255));
        jTable4.setIntercellSpacing(new java.awt.Dimension(5, 5));
        jTable4.setRowHeight(25);
        jTable4.setSelectionBackground(new java.awt.Color(255, 161, 97));
        jTable4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable4MouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(jTable4);

        jScrollPane7.setBorder(null);

        jTable3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jTable3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "NameFilm"
            }
        ){public boolean isCellEditable(int row, int column){return false;}});
        jTable3.setGridColor(new java.awt.Color(255, 255, 255));
        jTable3.setIntercellSpacing(new java.awt.Dimension(5, 5));
        jTable3.setRowHeight(25);
        jTable3.setSelectionBackground(new java.awt.Color(255, 161, 97));
        jTable3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable3MouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(jTable3);

        txt_genre.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        btn_add_Film6.setBackground(new java.awt.Color(255, 161, 97));

        jLabel67.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel67.setForeground(new java.awt.Color(255, 255, 255));
        jLabel67.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel67.setText("Выбрать фильм");
        jLabel67.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel67.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel67.setDoubleBuffered(true);
        jLabel67.setFocusCycleRoot(true);
        jLabel67.setFocusTraversalPolicyProvider(true);
        jLabel67.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel67MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btn_add_Film6Layout = new javax.swing.GroupLayout(btn_add_Film6);
        btn_add_Film6.setLayout(btn_add_Film6Layout);
        btn_add_Film6Layout.setHorizontalGroup(
            btn_add_Film6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel67, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        btn_add_Film6Layout.setVerticalGroup(
            btn_add_Film6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btn_add_Film6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel67, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel43.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_Right_2_70px.png"))); // NOI18N

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel43))
                    .addComponent(txt_genre))
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                    .addComponent(btn_add_Film6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(1096, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_add_Film6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_genre))
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 628, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 628, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(270, 270, 270)
                        .addComponent(jLabel43)))
                .addContainerGap(1122, Short.MAX_VALUE))
        );

        genre.add(jPanel14);

        Parent.add(genre, "card2");

        people.setBackground(new java.awt.Color(204, 153, 0));
        people.setLayout(new javax.swing.BoxLayout(people, javax.swing.BoxLayout.PAGE_AXIS));

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));
        jPanel15.setFocusTraversalPolicyProvider(true);

        jLabel44.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel44.setText(" Author Igor Romanov");

        jLabel45.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_Java_48px.png"))); // NOI18N
        jLabel45.setText("jLabel29");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel44)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1416, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel44, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel45, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        people.add(jPanel15);

        jPanel16.setBackground(new java.awt.Color(255, 161, 97));
        jPanel16.setPreferredSize(new java.awt.Dimension(1679, 139));

        jLabel46.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(255, 255, 255));
        jLabel46.setText("Основаня информация о людях ______________________________________________");

        jLabel47.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(255, 255, 255));
        jLabel47.setText("Administration/people");

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 1406, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(182, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        people.add(jPanel16);

        jPanel17.setBackground(new java.awt.Color(255, 255, 255));

        txt_NameFilm3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel48.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel48.setText("Название фильма:");

        jLabel49.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel49.setText("ФИО:");

        txt_Status.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel50.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel50.setText("Статус:");

        jTable6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTable6.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NameSurn", "Status"
            }
        ){public boolean isCellEditable(int row, int column){return false;}});
        jTable6.setGridColor(new java.awt.Color(255, 255, 255));
        jTable6.setIntercellSpacing(new java.awt.Dimension(5, 5));
        jTable6.setRowHeight(25);
        jTable6.setSelectionBackground(new java.awt.Color(255, 161, 97));
        jTable6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable6MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTable6);

        jTable7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTable7.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NameSurn", "Status"
            }
        ){public boolean isCellEditable(int row, int column){return false;}});
        jTable7.setGridColor(new java.awt.Color(255, 255, 255));
        jTable7.setIntercellSpacing(new java.awt.Dimension(5, 5));
        jTable7.setRowHeight(25);
        jTable7.setSelectionBackground(new java.awt.Color(255, 161, 97));
        jTable7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable7MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable7);

        btn_add_Film7.setBackground(new java.awt.Color(255, 161, 97));

        jLabel68.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel68.setForeground(new java.awt.Color(255, 255, 255));
        jLabel68.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel68.setText("Выбрать фильм");
        jLabel68.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel68.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel68.setDoubleBuffered(true);
        jLabel68.setFocusCycleRoot(true);
        jLabel68.setFocusTraversalPolicyProvider(true);
        jLabel68.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel68MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btn_add_Film7Layout = new javax.swing.GroupLayout(btn_add_Film7);
        btn_add_Film7.setLayout(btn_add_Film7Layout);
        btn_add_Film7Layout.setHorizontalGroup(
            btn_add_Film7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel68, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        btn_add_Film7Layout.setVerticalGroup(
            btn_add_Film7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel68, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        txt_Surn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_Right_2_70px.png"))); // NOI18N

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(jLabel48)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_NameFilm3, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_add_Film7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel29)
                        .addGap(27, 27, 27)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(47, 47, 47)
                .addComponent(jLabel49)
                .addGap(18, 18, 18)
                .addComponent(txt_Surn, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jLabel50)
                .addGap(18, 18, 18)
                .addComponent(txt_Status, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(140, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                .addContainerGap(876, Short.MAX_VALUE)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_Surn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel50)
                        .addComponent(txt_Status, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_NameFilm3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_add_Film7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel17Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 875, Short.MAX_VALUE)
                                    .addComponent(jScrollPane4)))
                            .addGroup(jPanel17Layout.createSequentialGroup()
                                .addGap(330, 330, 330)
                                .addComponent(jLabel29)))))
                .addContainerGap())
        );

        people.add(jPanel17);

        Parent.add(people, "card2");

        award.setBackground(new java.awt.Color(204, 153, 0));
        award.setLayout(new javax.swing.BoxLayout(award, javax.swing.BoxLayout.PAGE_AXIS));

        jPanel18.setBackground(new java.awt.Color(255, 255, 255));
        jPanel18.setFocusTraversalPolicyProvider(true);

        jLabel51.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel51.setText(" Author Igor Romanov");

        jLabel52.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_Java_48px.png"))); // NOI18N
        jLabel52.setText("jLabel29");

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel51)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1429, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel51, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel52, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        award.add(jPanel18);

        jPanel19.setBackground(new java.awt.Color(255, 161, 97));
        jPanel19.setPreferredSize(new java.awt.Dimension(1679, 139));

        jLabel53.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(255, 255, 255));
        jLabel53.setText("Основаня информация о наградах ______________________________________________");

        jLabel54.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(255, 255, 255));
        jLabel54.setText("Administration/Award");

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 1406, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(195, Short.MAX_VALUE))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        award.add(jPanel19);

        jPanel20.setBackground(new java.awt.Color(255, 255, 255));

        jLabel55.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel55.setText("Название фильма:");

        btn_add_Film5.setBackground(new java.awt.Color(255, 161, 97));

        jLabel62.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel62.setForeground(new java.awt.Color(255, 255, 255));
        jLabel62.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel62.setText("Выбрать фильм");
        jLabel62.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel62.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel62.setDoubleBuffered(true);
        jLabel62.setFocusCycleRoot(true);
        jLabel62.setFocusTraversalPolicyProvider(true);
        jLabel62.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel62MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btn_add_Film5Layout = new javax.swing.GroupLayout(btn_add_Film5);
        btn_add_Film5.setLayout(btn_add_Film5Layout);
        btn_add_Film5Layout.setHorizontalGroup(
            btn_add_Film5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_add_Film5Layout.createSequentialGroup()
                .addComponent(jLabel62, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        btn_add_Film5Layout.setVerticalGroup(
            btn_add_Film5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btn_add_Film5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel62, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        txt_NameFilm1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        txt_award.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel41.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel41.setText("Награда:");

        jLabel42.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel42.setText("Номинация:");

        txt_nomination.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        txt_DateFaund.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel56.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel56.setText("Дата вручение награды:");

        jScrollPane5.setBorder(null);

        jTable5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jTable5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTable5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NameFilm", "Award", "Nomination", "DateAward"
            }
        ){public boolean isCellEditable(int row, int column){return false;}});
        jTable5.setGridColor(new java.awt.Color(255, 255, 255));
        jTable5.setIntercellSpacing(new java.awt.Dimension(5, 5));
        jTable5.setRowHeight(25);
        jTable5.setSelectionBackground(new java.awt.Color(255, 161, 97));
        jTable5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable5MouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(jTable5);

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel20Layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel55)
                                    .addComponent(jLabel41)))
                            .addGroup(jPanel20Layout.createSequentialGroup()
                                .addGap(107, 107, 107)
                                .addComponent(jLabel42)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_award)
                            .addComponent(txt_NameFilm1)
                            .addComponent(txt_nomination, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(jLabel56)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_DateFaund, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_add_Film5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 908, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(91, 91, 91))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_NameFilm1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_award, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_nomination, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel56)
                    .addComponent(txt_DateFaund, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_add_Film5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1815, Short.MAX_VALUE)
        );

        award.add(jPanel20);

        Parent.add(award, "card2");

        jPanel9.add(Parent);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, 1906, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, 2006, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_NameStudioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_NameStudioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_NameStudioActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int index = jTable1.getSelectedRow();
        ShowItemFilm(index);
        ShowHasFilmGenreInJTable();
        ShowStatusInJTable();
        jPanel3.setVisible(true);
    }//GEN-LAST:event_jTable1MouseClicked

    private void btn_HomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_HomeMouseClicked
        Parent.removeAll();
        Parent.add(Home, "2");
        Parent.repaint();
        Parent.revalidate();
        int cardshow1 = 1;
        cardshow = cardshow1;

    }//GEN-LAST:event_btn_HomeMouseClicked

    private void btn_studioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_studioMouseClicked
        Parent.removeAll();
        Parent.add(studio, "3");
        Parent.repaint();
        Parent.revalidate();
        int cardshow2 = 2;
        cardshow = cardshow2;

    }//GEN-LAST:event_btn_studioMouseClicked

    private void btn_awardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_awardMouseClicked
        Parent.removeAll();
        Parent.add(award, "4");
        Parent.repaint();
        Parent.revalidate();
        int cardshow3 = 3;
        cardshow = cardshow3;


    }//GEN-LAST:event_btn_awardMouseClicked

    private void btn_peopleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_peopleMouseClicked
        Parent.removeAll();
        Parent.add(people, "5");
        Parent.repaint();
        Parent.revalidate();
        int cardshow5 = 5;
        cardshow = cardshow5;
    }//GEN-LAST:event_btn_peopleMouseClicked

    private void btn_genreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_genreMouseClicked
        Parent.removeAll();
        Parent.add(genre, "6");
        Parent.repaint();
        Parent.revalidate();
        int cardshow6 = 6;
        cardshow = cardshow6;
    }//GEN-LAST:event_btn_genreMouseClicked

    private void btn_imageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_imageMouseClicked

        if (cardshow == 1) {
            JFileChooser file = new JFileChooser();
            file.setCurrentDirectory(new File(System.getProperty("user.home")));

            FileNameExtensionFilter filter = new FileNameExtensionFilter("*.images", "jpg", "png");
            file.setFileFilter(filter);
            int result = file.showSaveDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = file.getSelectedFile();
                String path = selectedFile.getAbsolutePath();
                ;

                lbl_Image.setIcon(ResizeImage(path, null));
                ImagePatch = path;

            }
        } else {
            JOptionPane.showMessageDialog(null, "Функция не подходит для данного раздела");
        }
    }//GEN-LAST:event_btn_imageMouseClicked

    private void btn_insertMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_insertMouseClicked

        MyQuery mq = new MyQuery();
        if (cardshow == 1) {

            ArrayList<Film> FilmList = mq.getFilmList();
            for (int i = 0; i < FilmList.size(); i++) {
                txt_factor = FilmList.get(i).getNameFilm();
                if (txt_NameFilm.getText().equals(txt_factor)) {
                    break;
                }
            }

            if (txt_NameFilm.getText().equals(txt_factor)) {
                JOptionPane.showMessageDialog(null, "Такой фильм уже существует");
            } else {
                if (CheckInput() && ImagePatch != null) {

                    try {
                        PreparedStatement ps = con.prepareStatement("INSERT INTO Films "
                                + "(NameFilm,Budget,DateFilm,PictureFilm,NameStudID,CurrencyID)values(?,?,?,?,?,?)");
                        ps.setString(1, txt_NameFilm.getText());
                        ps.setString(2, txt_budget.getText());
                        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
                        String addDate = dateformat.format(txt_DateFilm.getDate());
                        ps.setString(3, addDate);
                        InputStream img = null;
                        img = new FileInputStream(new File(ImagePatch));
                        ps.setBlob(4, img);
                        ps.setInt(5, Integer.parseInt(ID2));
                        ps.setString(6, Currency);
                        ps.executeUpdate();
                        ShowFilmInJTable();
                        JOptionPane.showMessageDialog(null, "Фильм добавлен");
                    } catch (HeadlessException | NumberFormatException | SQLException ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Заполните все поля");
                }

            }

        }

        if (cardshow == 2) {

            ArrayList<Studio> list = mq.getStidioList();
            for (int i = 0; i < list.size(); i++) {
                txt_factor = list.get(i).getNameStudio();
                if (txt_factor.equals(txt_NameStudio2.getText())) {
                    break;
                }
            }

            if (txt_Director.getText().trim().length() > 0
                    && txt_NameStudio2.getText().trim().length() > 0
                    && txt_DateStudio.getDate() != null) {

                if (txt_factor.equals(txt_NameStudio2.getText())) {
                    JOptionPane.showMessageDialog(null, "Такая студия уже существует");
                } else {
                    try {
                        PreparedStatement stud = con.prepareStatement("INSERT INTO Studia (NameStud,Director,DateFound)values (?,?,?)");
                        stud.setString(1, txt_NameStudio2.getText());
                        stud.setString(2, txt_Director.getText());
                        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
                        String addDate = dateformat.format(txt_DateStudio.getDate());
                        stud.setString(3, addDate);
                        stud.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Студия добавлена");
                        ShowStudioInJTable();
                        txt_NameStudio2.setText("");
                        txt_Director.setText("");
                        txt_DateStudio.setDate(null);
                    } catch (HeadlessException | SQLException ex) {
                        JOptionPane.showMessageDialog(null, "Ошибка");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Заполните все поля ");
            }

        }
        if (cardshow == 3) {

            if (txt_award.getText().trim().length() > 0
                    && txt_nomination.getText().trim().length() > 0
                    && txt_DateFaund.getDate() != null
                    && txt_NameFilm1.getText().trim().length() > 0) {

                try {
                    PreparedStatement award = con.prepareStatement("INSERT INTO award (FilmAward,Nomination,Date,NameFilmID) values (?,?,?,?)");
                    award.setString(1, txt_award.getText());
                    award.setString(2, txt_nomination.getText());
                    SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
                    String addDate = dateformat.format(txt_DateFaund.getDate());
                    award.setString(3, addDate);
                    if (factor == factorID) {
                        award.setInt(4, factorID);
                        award.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Награда добавлена");
                        ShowAwardInJTable();
                    } else {
                        award.setString(4, ID);
                        award.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Награда добавлена");
                        ShowAwardInJTable();
                    }

                } catch (SQLException ex) {
                    Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else {
                JOptionPane.showMessageDialog(null, "Заполните все поля");
            }

        }

        if (cardshow == 5) {

            ArrayList<People> peoplelist = mq.getPeople();
            for (int i = 0; i < peoplelist.size(); i++) {
                txt_factor = peoplelist.get(i).getSurn();
                txt_factor2 = peoplelist.get(i).getStatus();
                if (txt_Surn.getText().equals(txt_factor) && txt_Status.getText().equals(txt_factor2)) {
                    break;
                }
            }

            if (txt_Surn.getText().equals(txt_factor) && txt_Status.getText().equals(txt_factor2)) {
                JOptionPane.showMessageDialog(null, "Такой человек уже зарегистрирован");

            } else {

                if (txt_Surn.getText().trim().length() > 0
                        && txt_Status.getText().trim().length() > 0) {

                    try {
                        PreparedStatement people = con.prepareStatement("INSERT INTO people (Surn,Status) values (?,?)");
                        people.setString(1, txt_Surn.getText());
                        people.setString(2, txt_Status.getText());
                        people.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Человек добавлен");
                        ShowPeopleinTable();
                    } catch (SQLException ex) {
                        Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Заполните все поля");
                }

            }

            if (cardshow == 6) {
                JOptionPane.showMessageDialog(null, "Для добавления жанра щелкните по таблице");
            }

        }

    }//GEN-LAST:event_btn_insertMouseClicked

    private void Btn_updateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_updateMouseClicked
        if (cardshow == 1) {

            if (CheckInput() && ID != null) {
                String UpdateQuery = null;
                PreparedStatement ps = null;

                if (ImagePatch == null) {
                    try {
                        UpdateQuery = "UPDATE Films SET NameStudID = ?, NameFilm = ?"
                                + ",Budget = ?,DateFilm =?,CurrencyID = ?  WHERE NameFilmID = ?";
                        ps = con.prepareStatement(UpdateQuery);
                        ps.setInt(1, Integer.parseInt(ID2));
                        ps.setString(2, txt_NameFilm.getText());
                        ps.setInt(3, Integer.parseInt(txt_budget.getText()));
                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                        String addDate = dateFormat.format(txt_DateFilm.getDate());
                        ps.setString(4, addDate);
                        ps.setString(5, Currency);
                        ps.setInt(6, Integer.parseInt(ID));
                        ps.executeUpdate();
                        ps.close();
                        ShowFilmInJTable();
                        JOptionPane.showMessageDialog(null, "Фильм обновился");

                    } catch (SQLException ex) {
                        Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    try {
                        InputStream img = new FileInputStream(new File(ImagePatch));

                        UpdateQuery = "UPDATE Films SET NameStudID = ?, NameFilm = ?"
                                + ",Budget = ?,DateFilm =?,PictureFilm =?,CurrencyID = ? WHERE NameFilmID = ?";

                        ps = con.prepareStatement(UpdateQuery);
                        ps.setInt(1, Integer.parseInt(ID2));
                        ps.setString(2, txt_NameFilm.getText());
                        ps.setInt(3, Integer.parseInt(txt_budget.getText()));
                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                        String addDate = dateFormat.format(txt_DateFilm.getDate());
                        ps.setString(4, addDate);
                        ps.setBlob(5, img);
                        ps.setString(6, Currency);
                        ps.setInt(7, Integer.parseInt(ID));
                        ps.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Фильм обновился");
                        ShowFilmInJTable();
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Ошибка");
            }
        }

        ImagePatch = null;

        if (cardshow == 2) {

            if (CheckInputStudio() && ID2 != null) {

                try {
                    String UpdateQuery = "UPDATE Studia SET  NameStud = ?"
                            + ",Director = ?,DateFound =? WHERE NameStudID = ?";
                    PreparedStatement ps = con.prepareStatement(UpdateQuery);
                    ps.setString(1, txt_NameStudio2.getText());
                    ps.setString(2, txt_Director.getText());
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    String addDate = dateFormat.format(txt_DateStudio.getDate());
                    ps.setString(3, addDate);
                    ps.setInt(4, Integer.parseInt(ID2));
                    ps.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Студия изменена");
                    ShowStudioInJTable();
                    ShowFilmInJTable();
                    txt_NameStudio.repaint();
                } catch (SQLException ex) {
                    Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else {
                JOptionPane.showMessageDialog(null, "Заполните все поля");
            }
        }

        if (cardshow == 3) {

            if (txt_award.getText().trim().length() > 0
                    && txt_nomination.getText().trim().length() > 0
                    && txt_DateFaund.getDate() != null) {

                try {
                    PreparedStatement award = con.prepareStatement("UPDATE award SET FilmAward = ?,Nomination = ?,Date =? WHERE FilmAwardID = ?");
                    award.setString(1, txt_award.getText());
                    award.setString(2, txt_nomination.getText());
                    SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
                    String addDate = dateformat.format(txt_DateFaund.getDate());
                    award.setString(3, addDate);

                    if (factor == FilmAwardID) {

                        award.setInt(4, FilmAwardID);
                        award.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Награда  изменена");
                        ShowAwardInJTable();
                    } else {
                        JOptionPane.showMessageDialog(null, "Выберите награду из таблицы напротив!");
                    }

                } catch (SQLException ex) {
                    Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else {
                JOptionPane.showMessageDialog(null, "Заполните все поля");
            }

        }
    }//GEN-LAST:event_Btn_updateMouseClicked

    private void btn_deleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_deleteMouseClicked
        if (cardshow == 1) {
            if (ID != null) {
                try {

                    PreparedStatement ps = con.prepareStatement("DELETE FROM films WHERE NameFilmID = ?");
                    int Filmid = Integer.parseInt(ID);
                    ps.setInt(1, Filmid);
                    ps.executeUpdate();
                    ShowFilmInJTable();
                    txt_NameFilm.setText("");
                    txt_NameStudio.setText("Выберите студию");
                    txt_budget.setText("");
                    txt_DateFilm.setDate(null);
                    lbl_Image.setIcon(new ImageIcon("default.png"));
                    JOptionPane.showMessageDialog(null, "Фильм удален");
                } catch (SQLException ex) {
                    Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "При удаление фильма произошла ошибка");
                }

            } else {
                JOptionPane.showMessageDialog(null, "Фильм не удаляется нет индефикатора удаления");
            }
        }

        if (cardshow == 2) {

            if (ID2 != null) {

                try {
                    PreparedStatement ps = con.prepareStatement("DELETE FROM studia WHERE NameStudID = ?");
                    int StudioID = Integer.parseInt(ID2);
                    ps.setInt(1, StudioID);
                    ps.executeUpdate();
                    ShowStudioInJTable();
                    txt_NameStudio2.setText("");
                    txt_Director.setText("");
                    txt_DateStudio.setDate(null);
                    ID2 = null;

                    JOptionPane.showMessageDialog(null, "Студия удалена");

                } catch (SQLException ex) {
                    Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "При удаление студии произошла ошибка");

                }

            } else {
                JOptionPane.showMessageDialog(null, "Студия не удаляется нет модификатора удаления");
            }
        }

        if (cardshow == 3) {

            if (Integer.toString(factor) != null) {

                try {
                    PreparedStatement ps = con.prepareStatement("DELETE FROM award WHERE FilmAwardID = ?");
                    int FilmAwardID = factor;
                    ps.setInt(1, FilmAwardID);
                    ps.executeUpdate();
                    ShowAwardInJTable();
                    txt_NameFilm1.setText("");
                    txt_award.setText("");
                    txt_nomination.setText("");
                    txt_DateFaund.setDate(null);
                    JOptionPane.showMessageDialog(null, "Награда удалена");

                } catch (SQLException ex) {
                    Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "При удаление награды произошла ошибка");

                }

            } else {
                JOptionPane.showMessageDialog(null, "Награда не удаляется нет модификатора удаления");
            }

        }

        if (cardshow == 5) {

            if (Integer.toString(SurnID) != null) {
                try {
                    PreparedStatement ps = con.prepareStatement("DELETE FROM people WHERE SurnID = ?");
                    ps.setInt(1, SurnID);
                    ps.executeUpdate();
                    ShowPeopleinTable();
                    ShowStatusInJTable();
                    JOptionPane.showMessageDialog(null, "Удален");

                } catch (SQLException ex) {
                    Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "При произошла ошибка");

                }

            } else {
                JOptionPane.showMessageDialog(null, "Не удаляется нет модификатора удаления");
            }

        }
    }//GEN-LAST:event_btn_deleteMouseClicked

    private void txt_DirectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_DirectorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_DirectorActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        int index = jTable2.getSelectedRow();
        ShowItemStudio(index);
        String a = txt_NameStudio2.getText();
        txt_NameStudio.setText(a);
    }//GEN-LAST:event_jTable2MouseClicked

    private void jTable4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable4MouseClicked

        MyQuery mq = new MyQuery();
        int index = jTable4.getSelectedRow();
        ShowItemGenre(index);
        ArrayList<FilmHasGenre> FilmHasGenreList = mq.getGenreHasFilm(txt_genre.getText());
        for (int i = 0; i < FilmHasGenreList.size(); i++) {
            factor = FilmHasGenreList.get(i).getGenreID();

            if (GenreID == factor) {
                break;
            }

        }
        //txt_probagenre.setText(text);

        if (cardshow == 6) {

            if (GenreID != factor) {

                if (factorID == Proverka) {
                    try {
                        PreparedStatement Genre = con.prepareStatement("INSERT INTO fimhasgenre (NameFilmID,NameGenreID) VALUES (?,?)");
                        Genre.setInt(1, Proverka);
                        Genre.setInt(2, GenreID);
                        Genre.executeUpdate();
                        ShowHasFilmGenreInJTable();
                        Genre.close();
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Ошибка");
                    }
                } else {
                    try {
                        PreparedStatement Genre = con.prepareStatement("INSERT INTO fimhasgenre (NameFilmID,NameGenreID) VALUES (?,?)");
                        Genre.setInt(1, Integer.parseInt(ID));
                        Genre.setInt(2, GenreID);
                        Genre.executeUpdate();
                        ShowHasFilmGenreInJTable();
                        Genre.close();
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Ошибка");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Такой жанр уже существует");
            }
        }

    }//GEN-LAST:event_jTable4MouseClicked

    private void jTable3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MouseClicked

        int index = jTable3.getSelectedRow();
        ShowItemFilmHasGenre(index);

        try {
            PreparedStatement FilmHasGenre = con.prepareStatement("DELETE FROM fimhasgenre WHERE ID = ?");
            FilmHasGenre.setString(1, Integer.toString(id_genre));
            FilmHasGenre.executeUpdate();
            JOptionPane.showMessageDialog(null, "Удален");
            ShowHasFilmGenreInJTable();
        } catch (SQLException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jTable3MouseClicked

    private void jTable6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable6MouseClicked
        MyQuery mq = new MyQuery();
        int index = jTable6.getSelectedRow();
        ShowItemPeople(index);
        ArrayList<Status> StatusList = mq.getStatus(txt_NameFilm3.getText());
        for (int i = 0; i < StatusList.size(); i++) {
            factor = StatusList.get(i).getSurnID();

            if (SurnID == factor) {
                break;
            }
        }
        if (cardshow == 5) {

            if (SurnID != factor) {

                if (factorID == Proverka) {

                    try {
                        PreparedStatement Status = con.prepareStatement("INSERT INTO Status (NameFilmID,SurnID) VALUES (?,?)");
                        Status.setInt(1, Proverka);
                        Status.setInt(2, SurnID);
                        Status.executeUpdate();
                        ShowStatusInJTable();
                        Status.close();
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "Ошибка");
                    }
                } else {
                    try {
                        PreparedStatement Genre = con.prepareStatement("INSERT INTO Status (NameFilmID,SurnID) VALUES (?,?)");
                        Genre.setInt(1, Integer.parseInt(ID));
                        Genre.setInt(2, SurnID);
                        Genre.executeUpdate();
                        ShowStatusInJTable();
                        Genre.close();
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Ошибка");
                    }
                }

            } else {
                JOptionPane.showMessageDialog(null, "Такой человек уже есть");
            }

        }

    }//GEN-LAST:event_jTable6MouseClicked

    private void cmb_CurrencyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_CurrencyActionPerformed
        MyQuery mq = new MyQuery();
        ArrayList<ForcmbCurrency> list = mq.getComboBoxCurrency((String) cmb_Currency.getSelectedItem());
        for (int i = 0; i < list.size(); i++) {
            Currency = Integer.toString(list.get(i).getCurrencyID());

        }
    }//GEN-LAST:event_cmb_CurrencyActionPerformed

    private void jLabel62MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel62MouseClicked
        SelectFilm sel = new SelectFilm();
        sel.setVisible(true);
    }//GEN-LAST:event_jLabel62MouseClicked

    private void jTable5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable5MouseClicked
        int index = jTable5.getSelectedRow();
        ShowItemAward(index);


    }//GEN-LAST:event_jTable5MouseClicked

    private void jLabel67MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel67MouseClicked
        SelectFilm sel = new SelectFilm();
        sel.setVisible(true);
    }//GEN-LAST:event_jLabel67MouseClicked

    private void jLabel68MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel68MouseClicked
        SelectFilm sel = new SelectFilm();
        sel.setVisible(true);
    }//GEN-LAST:event_jLabel68MouseClicked

    private void jTable1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            int index = jTable1.getSelectedRow();
            ShowItemFilm(index);
        }
    }//GEN-LAST:event_jTable1KeyPressed

    private void jLabel63MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel63MouseClicked
        SelectStudio sel = new SelectStudio();
        sel.setVisible(true);
    }//GEN-LAST:event_jLabel63MouseClicked

    private void txt_searchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_searchKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            ShowFilmInJTable();
        }
    }//GEN-LAST:event_txt_searchKeyPressed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        BrowseAwards BroAward = new BrowseAwards();
        BroAward.setVisible(true);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void btn_HomeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_HomeMouseEntered
        setColor(btn_Home);
    }//GEN-LAST:event_btn_HomeMouseEntered

    private void btn_HomeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_HomeMouseExited
        resetColor(btn_Home);
    }//GEN-LAST:event_btn_HomeMouseExited

    private void btn_studioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_studioMouseEntered
        setColor(btn_studio);
    }//GEN-LAST:event_btn_studioMouseEntered

    private void btn_studioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_studioMouseExited
        resetColor(btn_studio);
    }//GEN-LAST:event_btn_studioMouseExited

    private void btn_awardMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_awardMouseEntered
        setColor(btn_award);
    }//GEN-LAST:event_btn_awardMouseEntered

    private void btn_awardMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_awardMouseExited
        resetColor(btn_award);
    }//GEN-LAST:event_btn_awardMouseExited

    private void btn_peopleMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_peopleMouseEntered
        setColor(btn_people);
    }//GEN-LAST:event_btn_peopleMouseEntered

    private void btn_peopleMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_peopleMouseExited
        resetColor(btn_people);
    }//GEN-LAST:event_btn_peopleMouseExited

    private void btn_genreMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_genreMouseEntered
        setColor(btn_genre);
    }//GEN-LAST:event_btn_genreMouseEntered

    private void btn_genreMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_genreMouseExited
        resetColor(btn_genre);
    }//GEN-LAST:event_btn_genreMouseExited

    private void btn_imageMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_imageMouseEntered
        setColor(btn_image);
    }//GEN-LAST:event_btn_imageMouseEntered

    private void btn_imageMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_imageMouseExited
        resetColor(btn_image);
    }//GEN-LAST:event_btn_imageMouseExited

    private void btn_insertMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_insertMouseEntered
        setColor(btn_insert);
    }//GEN-LAST:event_btn_insertMouseEntered

    private void btn_insertMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_insertMouseExited
        resetColor(btn_insert);
    }//GEN-LAST:event_btn_insertMouseExited

    private void Btn_updateMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_updateMouseEntered
        setColor(Btn_update);
    }//GEN-LAST:event_Btn_updateMouseEntered

    private void Btn_updateMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_updateMouseExited
        resetColor(Btn_update);
    }//GEN-LAST:event_Btn_updateMouseExited

    private void btn_deleteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_deleteMouseEntered
        setColor(btn_delete);
    }//GEN-LAST:event_btn_deleteMouseEntered

    private void btn_deleteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_deleteMouseExited
        resetColor(btn_delete);
    }//GEN-LAST:event_btn_deleteMouseExited

    private void txt_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_searchActionPerformed

    }//GEN-LAST:event_txt_searchActionPerformed

    private void jLabel28MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel28MouseClicked
        ShowFilmInJTable();
    }//GEN-LAST:event_jLabel28MouseClicked

    private void jTable7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable7MouseClicked
        int index = jTable7.getSelectedRow();
        ShowItemStatus(index);

        try {
            PreparedStatement status = con.prepareStatement("DELETE FROM status WHERE PeopleID = ?");
            status.setInt(1, PeopleID);
            status.executeUpdate();
            JOptionPane.showMessageDialog(null, "Удален");
            ShowStatusInJTable();
        } catch (SQLException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTable7MouseClicked

    void setColor(JPanel panel) {
        panel.setBackground(new Color(255, 204, 102));
    }

    void resetColor(JPanel panel) {
        panel.setBackground(new Color(255, 190, 90));
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Window".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Btn_update;
    private javax.swing.JPanel Home;
    private javax.swing.JPanel Parent;
    private javax.swing.JPanel award;
    private javax.swing.JPanel btn_Home;
    private javax.swing.JPanel btn_add_Film5;
    private javax.swing.JPanel btn_add_Film6;
    private javax.swing.JPanel btn_add_Film7;
    private javax.swing.JPanel btn_add_Film8;
    private javax.swing.JPanel btn_award;
    private javax.swing.JPanel btn_delete;
    private javax.swing.JPanel btn_genre;
    private javax.swing.JPanel btn_image;
    private javax.swing.JPanel btn_insert;
    private javax.swing.JPanel btn_people;
    private javax.swing.JPanel btn_studio;
    private javax.swing.JComboBox<String> cmb_Currency;
    private javax.swing.JPanel genre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    public javax.swing.JTable jTable3;
    public javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;
    public javax.swing.JTable jTable6;
    public javax.swing.JTable jTable7;
    private javax.swing.JLabel lbl_Image;
    private javax.swing.JPanel people;
    private javax.swing.JPanel sidePane;
    private javax.swing.JPanel studio;
    private com.toedter.calendar.JDateChooser txt_DateFaund;
    private com.toedter.calendar.JDateChooser txt_DateFilm;
    private com.toedter.calendar.JDateChooser txt_DateStudio;
    private javax.swing.JTextField txt_Director;
    private javax.swing.JTextField txt_NameFilm;
    public javax.swing.JTextField txt_NameFilm1;
    private javax.swing.JTextField txt_NameFilm3;
    public javax.swing.JTextField txt_NameStudio;
    private javax.swing.JTextField txt_NameStudio2;
    private javax.swing.JTextField txt_Status;
    private javax.swing.JTextField txt_Surn;
    private javax.swing.JTextField txt_award;
    private javax.swing.JTextField txt_budget;
    private javax.swing.JTextField txt_genre;
    private javax.swing.JTextField txt_nomination;
    private javax.swing.JTextField txt_probagenre;
    private javax.swing.JTextField txt_search;
    // End of variables declaration//GEN-END:variables

}
