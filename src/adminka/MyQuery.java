/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adminka;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Admin
 */
public class MyQuery  {
   private static ArrayList<Film> Filmlist;


     
    public ArrayList<Film> getFilmList() {
       Connection con = MainWindow.con;
        
         Filmlist = new ArrayList<Film>();
         
         System.out.println(Filmlist.toArray().toString());
         //Filmlist = null;


        String QueryFilm = "SELECT NameFilmID, NameFilm, budget,s.NameStud,DateFilm,PictureFilm,f.NameStudID,c.Sign FROM films f LEFT JOIN studia s ON f.NameStudID=s.NameStudID LEFT JOIN Currency c ON f.CurrencyID = c.CurrencyID";

        Statement st;
        ResultSet rs;

        try {

            st = con.createStatement();
            rs = st.executeQuery(QueryFilm);

            while (rs.next()) {
                Film film = new Film(rs.getString("DateFilm"),
                        rs.getInt("Budget"),
                        rs.getString("Sign"),
                        rs.getString("NameFilm"),
                        rs.getString("NameStud"),
                        rs.getBytes("PictureFilm"),
                        rs.getInt("NameFilmID"),
                        rs.getInt("NameStudID"));

                Filmlist.add(film);
            }

        } catch (SQLException ex) {
            Logger.getLogger(MyQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return Filmlist;
    }
     
     
     public ArrayList<Studio> getStidioList(){
        
        Connection con = MainWindow.con;  
        ArrayList<Studio> StudioList = new ArrayList<Studio>();
     
    String QueryStudio = " SELECT NameStudID,NameStud,Director,DateFound FROM studia";
    Statement st;
    ResultSet rs;
    
     try {
            
            st = con.createStatement();
            rs = st.executeQuery(QueryStudio);
            
      while(rs.next())
      {
       Studio studio = new Studio(
                            rs.getInt("NameStudID"),
                            rs.getString("NameStud"),
                            rs.getString("Director"),
                            rs.getString("DateFound"));
                            
       StudioList.add(studio);
            }
                
            } catch (SQLException ex)
            {
            Logger.getLogger(MyQuery.class.getName()).log(Level.SEVERE, null, ex);
            }
         return StudioList; 
    
    
     
     }
     
       public ArrayList<Film> getSearchList(String Search){
         Connection con = MainWindow.con;
     ArrayList<Film>SearchList = new ArrayList<Film>();
     
     
     String QueryFilm = "SELECT NameFilmID, NameFilm, budget,s.NameStud,DateFilm,PictureFilm,f.NameStudID,c.Sign FROM films f LEFT JOIN studia s ON f.NameStudID=s.NameStudID LEFT JOIN Currency c ON f.CurrencyID = c.CurrencyID WHERE CONCAT(`NameFilm`) LIKE '%"+Search+"%'";
     Statement st;
     ResultSet rs;
            
        try {
            
            st = con.createStatement();
            rs = st.executeQuery(QueryFilm);
            
      while(rs.next())
      {
       Film film = new Film(rs.getString("DateFilm"),
                            rs.getInt("Budget"),
                            rs.getString("Sign"),
                            rs.getString("NameFilm"),
                            rs.getString("NameStud"),
                            rs.getBytes("PictureFilm"),
                            rs.getInt("NameFilmID"),
                            rs.getInt("NameStudID"));
                            
      SearchList.add(film);
            }
                
            } catch (SQLException ex)
            {
            Logger.getLogger(MyQuery.class.getName()).log(Level.SEVERE, null, ex);
            }  
         return SearchList; 
    }   
    
       
       
    public ArrayList<Award> getAwardList(){
       Connection con = MainWindow.con;
    ArrayList<Award> AwardList = new ArrayList<Award>();
     
    String QueryAward = "SELECT f.NameFilm,FilmAwardID,FilmAward,Nomination,Date,a.NameFilmID FROM Award a LEFT JOIN films f ON a.NameFilmID = f.NameFilmID ";
    Statement st;
    ResultSet rs;
    
     try {
            
            st = con.createStatement();
            rs = st.executeQuery(QueryAward);
            
      while(rs.next())
      {
       Award award = new Award(
                            rs.getString("NameFilm"),
                            rs.getString("FilmAward"),
                            rs.getString("Nomination"),
                            rs.getString("Date"),
                            rs.getInt("FilmAwardID"),
                            rs.getInt("NameFilmID"));
                            
       AwardList.add(award);
            }
                
            } catch (SQLException ex)
            {
            Logger.getLogger(MyQuery.class.getName()).log(Level.SEVERE, null, ex);
            }
             
         return AwardList; 
     }    
    
    
    
    
     public ArrayList<ForcmbCurrency> getComboBoxCurrency(String Name){
         Connection con = MainWindow.con;
     ArrayList<ForcmbCurrency>combolist = new ArrayList<ForcmbCurrency>();
      
     
     String QueryFilm = "select CurrencyID,Sign from currency where Sign = '"+Name+"'";
     java.sql.Statement st;
     ResultSet rs;
            
        try {
          
            st = con.createStatement();
            rs = st.executeQuery(QueryFilm);
            
      while(rs.next())
      {
       ForcmbCurrency Currency = new ForcmbCurrency(
               rs.getInt("CurrencyID"),
               rs.getString("Sign"));
                            
      combolist.add(Currency);
            }
                
            } catch (SQLException ex){
            Logger.getLogger(MyQuery.class.getName()).log(Level.SEVERE, null, ex);
            }
        
         return combolist;
        }
     
   public ArrayList<Genre> getGenre(){
        Connection con = MainWindow.con; 
       ArrayList<Genre> GenreList = new ArrayList<Genre>();
        
       String QueryGenre = "SELECT NameGenre,NameGenreID FROM genre";
       ResultSet rs;
       Statement st;
        try {
            
            st = con.createStatement();
            rs = st.executeQuery(QueryGenre);
            
            while (rs.next()){
                Genre genre = new Genre(rs.getString("NameGenre"),
                                        rs.getInt("NameGenreID"));
                GenreList.add(genre);
            
            }
        } catch (SQLException ex) {
            Logger.getLogger(MyQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
   
         return GenreList;   
   }  
   
   public ArrayList<FilmHasGenre> getGenreHasFilm(String Name){
       Connection con = MainWindow.con;     
       ArrayList<FilmHasGenre> GenreAndFilmList = new ArrayList<FilmHasGenre>();
       
       String QueryGenreHasFilm = "select g.NameGenre,ID,NameFilm,h.NameFilmID,h.NameGenreID from films f left join fimhasgenre h on f.NameFilmID = h.NameFilmID left join genre g on g.NameGenreID = h.NameGenreID Where f.NameFilm = '"+Name+"'";
       ResultSet rs;
       Statement st;
        try { 
            st = con.createStatement();
            rs = st.executeQuery(QueryGenreHasFilm);
            
            while (rs.next()){
                FilmHasGenre GenreFilm = new FilmHasGenre (rs.getInt("NameGenreID"),
                                                           rs.getInt("NameFilmID"),
                                                           rs.getInt("ID"),
                                                           rs.getString("NameGenre"),
                                                           rs.getString("NameFilm"));
                GenreAndFilmList.add(GenreFilm);
            
            }
        } catch (SQLException ex) 
        {
            Logger.getLogger(MyQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
   
         return GenreAndFilmList;   
   }  
   
  
   public ArrayList<People> getPeople(){
       Connection con = MainWindow.con; 
       ArrayList<People> PeopleList = new ArrayList<People>();
       
     String QueryPeople = "SELECT Surn,Status,SurnID FROM People ";
     java.sql.Statement st;
     ResultSet rs;
   try { 
            st = con.createStatement();
            rs = st.executeQuery(QueryPeople);
            
            while (rs.next()){
                People peoplelist = new People (rs.getString("Surn"),
                                                rs.getString("Status"),
                                                rs.getInt("SurnID"));
                PeopleList.add(peoplelist);
            
            }
        } catch (SQLException ex) 
        {
            Logger.getLogger(MyQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
   
         return PeopleList;   
   }
   
  public ArrayList<Status>getStatus(String Name){
  
  Connection con = MainWindow.con;
  ArrayList<Status> StatusList = new ArrayList<Status>();
 
  String QueryStatus ="SELECT s.NameFilmID,p.SurnID,p.Surn,p.Status,f.NameFilm,s.PeopleID FROM films f LEFT JOIN Status s ON f.NameFilmID = s.NameFilmID LEFT JOIN People p ON p.SurnID = s.SurnID WHERE f.NameFilm ='"+Name+"'"; 
  
  Statement st;
  ResultSet rs;
  
         try {
             st = con.createStatement();
             rs = st.executeQuery(QueryStatus);
             
             while(rs.next()){
                Status statuslist = new Status(rs.getInt("SurnID"),
                                           rs.getInt("NameFilmID"),
                                           rs.getString("NameFilm"),
                                           rs.getString("Surn"),
                                           rs.getString("Status"),
                                           rs.getInt("PeopleID"));
                StatusList.add(statuslist);
         
         }
             
         } catch (SQLException ex) {
             Logger.getLogger(MyQuery.class.getName()).log(Level.SEVERE, null, ex);
         }
  
         return StatusList;
  } 
   
    public ArrayList<FilmHasGenre> getGenreHasFilm(){
       Connection con = MainWindow.con;     
       ArrayList<FilmHasGenre> GenreAndFilmList = new ArrayList<FilmHasGenre>();
       
       String QueryGenreHasFilm = "select g.NameGenre,ID,NameFilm,h.NameFilmID,h.NameGenreID from films f left join fimhasgenre h on f.NameFilmID = h.NameFilmID left join genre g on g.NameGenreID = h.NameGenreID";
       ResultSet rs;
       Statement st;
        try { 
            st = con.createStatement();
            rs = st.executeQuery(QueryGenreHasFilm);
            
            while (rs.next()){
                FilmHasGenre GenreFilm = new FilmHasGenre (rs.getInt("NameGenreID"),
                                                           rs.getInt("NameFilmID"),
                                                           rs.getInt("ID"),
                                                           rs.getString("NameGenre"),
                                                           rs.getString("NameFilm"));
                GenreAndFilmList.add(GenreFilm);
            
            }
        } catch (SQLException ex) 
        {
            Logger.getLogger(MyQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
   
         return GenreAndFilmList;   
   } 
    
    public ArrayList<Studio> getSearchListStudio(String Search){
    Connection con = MainWindow.con;  
    ArrayList<Studio> StudioList = new ArrayList<Studio>();
     
    String QueryStudio = " SELECT NameStudID,NameStud,Director,DateFound FROM studia WHERE CONCAT(`NameStud`) LIKE '%"+Search+"%'";
    Statement st;
    ResultSet rs;
    
     try {
            
            st = con.createStatement();
            rs = st.executeQuery(QueryStudio);
            
      while(rs.next())
      {
       Studio studio = new Studio(
                            rs.getInt("NameStudID"),
                            rs.getString("NameStud"),
                            rs.getString("Director"),
                            rs.getString("DateFound"));
                            
       StudioList.add(studio);
            }
                
            } catch (SQLException ex)
            {
            Logger.getLogger(MyQuery.class.getName()).log(Level.SEVERE, null, ex);
            }
         return StudioList;   
    
    } 
    
      public ArrayList<Award> getBrowseAwardList(String Name){
       Connection con = MainWindow.con;
    ArrayList<Award> AwardList = new ArrayList<Award>();
     
    String QueryAward = "SELECT f.NameFilm,FilmAwardID,FilmAward,Nomination,Date,a.NameFilmID FROM Award a LEFT JOIN films f ON a.NameFilmID = f.NameFilmID Where f.NameFilm = '"+Name+"'";
    Statement st;
    ResultSet rs;
    
     try {
            
            st = con.createStatement();
            rs = st.executeQuery(QueryAward);
            
      while(rs.next())
      {
       Award award = new Award(
                            rs.getString("NameFilm"),
                            rs.getString("FilmAward"),
                            rs.getString("Nomination"),
                            rs.getString("Date"),
                            rs.getInt("FilmAwardID"),
                            rs.getInt("NameFilmID"));
                            
       AwardList.add(award);
            }
                
            } catch (SQLException ex)
            {
            Logger.getLogger(MyQuery.class.getName()).log(Level.SEVERE, null, ex);
            }
             
         return AwardList; 
     }    
}