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
public class People {
    private final String Surn;
    private final String Status;
    private final int SurnID;
    
public People(String Surn,String Status,int SurnID){

    this.Status = Status;
    this.Surn = Surn;
    this.SurnID = SurnID;

}    


public String getSurn(){
return Surn;
}

public String getStatus(){

return Status;

}
public int getSurnID(){

 return SurnID;
}

public Object getRow(){
    
 Object[] row = {getSurn(),getStatus()};
        
  return row;  
} 
    
    
}
