/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adminka;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Admin
 */
public class Film {
    private final String datafilm;
    private final int budget;
    private final String nameFilm;
    private final byte[] picture;
    private final String NameStud;
    private final int NameFilmID;
    private final int ID2;
    private final String Sign;
   

    
    public Film(String DateFilm, int Budget,String Sign, String NameFilm,String NameStud,byte[] picimg,int NameFilmID,int ID){
    
      
        this.datafilm = DateFilm;
        this.budget = Budget;
        this.nameFilm = NameFilm;
        this.picture = picimg;
        this.NameStud = NameStud;
        this.NameFilmID = NameFilmID;
        this.ID2 = ID;
        this.Sign = Sign;
        
        
    
    }


    
public String getNameFilm(){
       return nameFilm; 
    }

    
 public String getDateFilm(){
      return datafilm;
    }  
    
    
    public int getBudget(){
        return budget;
    }
    
   public String getNameStud(){
        
    return NameStud;
    
    }
   public byte[] getImage(){
        
    return picture;
   }

public int getNameFilmID(){
  
    return NameFilmID;
    }
  public int getID2(){
      
     return ID2;
}

public String getSign(){

  return Sign;
}
  
  public Object getRow(){
      
  Object [] row = {getNameFilm(),getNameStud(),getBudget(),getSign(),getDateFilm()};
  
  return row;
  }
  
public Object getRows(){
      
  Object [] row2 = {getNameFilm()};
  
  return row2;
  
        }

}
   

   
   


 

    

