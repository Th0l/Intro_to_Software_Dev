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
public abstract class Utilizador implements java.io.Serializable{
    private String nome;
    private int id;
    private String password;

    public Utilizador(){
        this.id = 0;
        this.nome = "n/e";
        this.password = "n/e";
    }
    
    public Utilizador(String n, int id, String p){
        this.id = id;
        this.nome = n;
        this.password = p;
    }
    
    public Utilizador(Utilizador x){
        this.id = x.getId();
        this.nome = x.getNome();
        this.password = x.getPassword();
    }
    
    public int getId(){
        return this.id;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public String getPassword(){
        return this.password;
    }
    
    public void setId(int id){
        this.id=id;
    }
    
    public void setNome(String n){
        this.nome = n;
    }
    
    public void setPassword(String p){
        this.password = p;
    }
    
    public String toString(){
        StringBuilder sb = new StringBuilder();
        
        sb.append("Nome: ");
            sb.append(this.nome + "\n");
                sb.append("Password: ");
                        sb.append(this.password + "\n");
                                sb.append("Id: ");
                                        sb.append(this.id);
        return sb.toString();
    }
    
    public boolean equals(Object o){
        if(o==this) return true;
        if(o==null || o.getClass() != this.getClass() ) return false;
        Utilizador c = (Utilizador) o;
        boolean ret = c.id == this.id && this.nome.equals(c.nome) && this.password.equals(c.password);
        return ret;
    }
    
}
