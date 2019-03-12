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
public class Status {
    private int SurnID;
    private int NameFilmID;
    private String NameFilm;
    private String Surn;
    private String Status;
    private int PeopleID;
    
    public Status (int SurnID,int NameFilmID, String NameFilm, String Surn, String Status,int PeopleID){
        
        this.SurnID = SurnID;
        this.NameFilmID = NameFilmID;
        this.NameFilm = NameFilm;
        this.Status = Status;
        this.Surn = Surn;
        this.PeopleID = PeopleID;
    
    
    }
    
public int getSurnID(){

return SurnID;
}

public int getNameFilmID(){

    return NameFilmID;
}

public String getNameFilm(){

return NameFilm;

}

public String getSurn(){

return Surn;

}

public String getStatus(){

    return Status;

}

public int getPeopleID(){

    return PeopleID;
} 

public Object getPeopleRow(){
    
     Object[] rowGenre = {getSurn(),getStatus()};
        
      return rowGenre; 
     }
    
    
    
    
}
