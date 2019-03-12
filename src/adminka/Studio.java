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


public class Studio {


    private String NameStudio;
    private String Director;
    private String DateStudio;
    private int ID2;

    
    
    public Studio(int ID,String NameStudio,String Director,String DateStudio){
    
        
        this.NameStudio = NameStudio;
        this.Director = Director;
        this.DateStudio = DateStudio; 
        this.ID2 = ID;
        
    }
    
 
  
  
  public String getNameStudio(){
      
     return NameStudio;
   
  }


public String getDirector(){
    
    return Director;

}


public String getDateStudio(){

    return DateStudio;

}
public int getID2(){
    
    return ID2;
   
}
  
    public Object getStudioRow(){
    
     Object[] rowGenre = {getNameStudio(),getDirector(),getDateStudio()};
        
      return rowGenre; 
     }
    
    
    
    
}
