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
public class Vendedor extends Utilizador implements java.io.Serializable{
    
    /*
        Construtor vazio
    */
    public Vendedor(){
        super();
    }
    
    public Vendedor(String n, int id, String p){
        super(n, id, p);
    }
    
    public Vendedor(Vendedor x){
        super(x);
    }
    
    public String toString(){
        return super.toString();
    }
    
    public Vendedor clone(){
        return new Vendedor(this);
    }
    
    public boolean equals(Object o){
        if(o==this) return true;
        if(o==null || o.getClass() != this.getClass() ) return false;
        Vendedor c = (Vendedor) o;
        boolean ret = super.getId() == c.getId() && super.getNome().equals(c.getNome()) && super.getPassword().equals(c.getPassword());
        return ret;
    }
    
}
