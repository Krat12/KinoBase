/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adminka;

/**
 *
 * @author Студент
 */
public class Award {

  private final String AwardFilm;
  private final String Nomination;
  private final String DateAward;
  private final String NameFilm;
  private final int FilmAwardID;
  private final int NameFilmID_FK;
    public Award(String NameFilm,String awardfilm,String nomination,String DateAward,int FilmAwardID,int NameFilmID_FK ){
        
        this.AwardFilm = awardfilm;
        this.Nomination = nomination;
        this.DateAward = DateAward;
        this.NameFilm = NameFilm;
        this.FilmAwardID = FilmAwardID;
        this.NameFilmID_FK = NameFilmID_FK;
    }
    
   public String getAwardFilm(){
   
       return AwardFilm;
   } 
    
   public String getNomination(){
   
       return Nomination;
   
   }
   
   public String getDateAward(){
   
       return DateAward;
   }
  
  public String getNameFilm(){
      
      return NameFilm;
  
  }
  
  public int getFilmAwardID(){
  
      return FilmAwardID;
  
  }
  public int getNameFilmID_FK(){
  
  return NameFilmID_FK;
  }
    
}
