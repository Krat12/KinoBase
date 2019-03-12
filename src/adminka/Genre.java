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
public class Genre {
    private String Genre;
    private int GenreID;
    
    public Genre(String genre,int GenreID){
        this.Genre = genre;
        this.GenreID = GenreID;
    }
    
    public String getGenre(){
        
        return Genre;
    
    }
    
    public int getGenreID(){
        
        return GenreID;
    }
    public Object getRow(){
    
        Object[] row = {getGenre()};
        
      return row;  
    }
    
}
