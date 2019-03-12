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
public class ForcmbCurrency {
    
    private int CurrencyID;
    private String Sign;
    
  public  ForcmbCurrency (int CurrencyID,String Sign){
  
      this.CurrencyID =CurrencyID;
      this.Sign = Sign;
  }
  
  public int getCurrencyID(){

    return CurrencyID;
}
  public String getSign(){
  
      return Sign;
  }
  
  
    
}
