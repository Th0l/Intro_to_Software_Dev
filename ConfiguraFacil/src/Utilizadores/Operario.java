/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilizadores;

/**
 *
 * @author pedrogoncalves
 */
public class Operario extends Utilizador implements java.io.Serializable{
    
    public Operario(){
        super();
    }
    
    public Operario(String n, int id, String p){
        super(n, id, p);
    }
    
    public Operario(Operario x){
        super(x);
    }
    
    public String toString(){
        return super.toString();
    }
    
    public Operario clone(){
        return new Operario(this);
    }
    
    public boolean equals(Object o){
        if(o==this) return true;
        if(o==null || o.getClass() != this.getClass() ) return false;
        Operario c = (Operario) o;
        boolean ret = super.getId() == c.getId() && super.getNome().equals(c.getNome()) && super.getPassword().equals(c.getPassword());
        return ret;
    }
}
