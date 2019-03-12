/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adminka;

/**
 *
 * @author Admin
 */
public class FilmHasGenre {
    private int GenreID;
    private int NameFilmID;
    private int id;
    private String Genre;
    private String NameFilm;
        
    public FilmHasGenre(int GenreID, int NameFilmID, int ID,String Genre,String NameFilm) {
        
        this.GenreID = GenreID;
        this.NameFilmID = NameFilmID;
        this.id = ID;
        this.Genre = Genre;
        this.NameFilm = NameFilm;
    
    }
       
    public int getGenreID(){
        
        return GenreID;
    }
    
    
    public int getNameFilmID(){
  
    return NameFilmID;
    }
    
    public int getid(){
  
    return id;
    }
       
    public String getGenreFilm(){
        
        return Genre;
    }
 

public String getNameFilm(){
       return NameFilm; 
    }
    
    
     public Object geGenreInRow(){
    
     Object[] rowGenre = {getGenreFilm()};
        
      return rowGenre; 
     }
}
