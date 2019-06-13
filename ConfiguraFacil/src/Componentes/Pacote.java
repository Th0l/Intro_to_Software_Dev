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
public abstract class Pacote {
    private double preco;
    private List<Peca> pecas;
    
    public Pacote(Pacote x){
        this.preco = x.getPreco();
        this.pecas = x.getPecas();
    }
    
    public Pacote(double c, List<Peca> x){
        this.preco = c;
        this.pecas = x;
    }
    
    public void setPreco(double p){
        this.preco = p;
    }
    
    public void setPecas(List<Peca> x){
        List<Peca> l = new ArrayList<>();
        for(Peca p : x) {
            l.add(p.clone());
        }
        this.pecas = l;
    }
    
    public double getPreco(){
        return this.preco;
    }
    
    public List<Peca> getPecas(){
        List<Peca> l = new ArrayList<>();
        for (Peca p : this.pecas) {
            l.add(p.clone());
        }
        return l;
    }
    
    public boolean equals(Object o){
        if(o==this) return true;
        if(o==null || o.getClass() != this.getClass() ) return false;
        Pacote c = (Pacote) o;
        boolean ret = c.preco == this.preco && c.pecas.equals(this.pecas);
        return ret;
    }
    
    public String toString(){
        StringBuilder sb = new StringBuilder();
        
        sb.append("Preco: ");
        sb.append(this.preco + "\n");
        sb.append("Pecas: ");
        sb.append(this.pecas.toString() + "\n");
        
        return sb.toString();
    }
    
    // Tem que ser implmentatado nas classes descendentes
    public abstract Pacote clone();
}
