/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Componentes;
import java.util.List;
import java.util.ArrayList;


/**
 *
 * @author pedrogoncalves
 */
public class Sport extends Pacote {
    
    public Sport(Pacote x) {
        super(x);
    }
    
    public Sport(double c, List<Peca> x){
        super(c,x);
    }
    
   public String toString(){
        return super.toString();
    }
   
   public Sport clone()
   {
       return new Sport(this);
   }
    
}
