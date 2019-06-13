/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package configurafacil;
import Componentes.Peca;
import Utilizadores.*;
import Encomenda.*;
import Dados.*;
import UI.Start;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author pedrogoncalves
 */
public class ConfiguraFacil {

    //private Map<Integer,Utilizador> users;
    //private Fabrica fabrica;
    
    //private static BaseDados bd;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        BaseDados bd = new BaseDados();
        bd.checkContent();
        //bd.Fortnite();
      
        
      Start start = new Start();
      start.main(args);
    }    
}
