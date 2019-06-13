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
public class Peca implements java.io.Serializable{
    private String descricao;
    private double preco;
    private int id;
    private int quantidade;
    private List<Peca> obrigacoes;
    private List<Peca> incompativeis;
    
    public Peca(){
        this.descricao = "n/e";
        this.preco = 0;
        this.id = 0;
        this.quantidade = 0;
        this.incompativeis = new ArrayList<>();
        this.obrigacoes = new ArrayList<>();
    }
    
    public Peca(Peca x){
        this.descricao = x.getDescricao();
        this.preco = x.getPreco();
        this.id = x.getId();
        this.quantidade = x.getQuantidade();
        this.incompativeis = x.getIncompativeis();
        this.obrigacoes = x.getObrigacoes();
    }
    
    public Peca(String d, double p, int i, int q){
        this.descricao = d;
        this.preco = p;
        this.id = i;
        this.quantidade = q;
    }
    
    public String getDescricao(){
        return this.descricao;
    }
    
    public double getPreco(){
        return this.preco;
    }
    
    public int getId(){
        return this.id;
    }
    
    public int getQuantidade(){
        return this.quantidade;
    }
    
    public List<Peca> getIncompativeis(){
        List<Peca> l = new ArrayList<>();
        for (Peca p : this.incompativeis) {
            l.add(p.clone());
        }
        return l;
    }
    
    public List<Peca> getObrigacoes(){
        List<Peca> l = new ArrayList<>();
        for (Peca p : this.obrigacoes) {
            l.add(p.clone());
        }
        return l;
    }
    
    public void setDescricao(String d){
        this.descricao = d;
    }
    
    public void setPreco(double p){
        this.preco = p;
    }
    
    public void setId(int i){
        this.id = i;
    }
    
    public void setQuantidade(int q){
        this.quantidade = q;
    }
    
    public void setIncompativeis(List<Peca> x){
        List<Peca> l = new ArrayList<>();
        for(Peca p : x) {
            l.add(p);
        }
        this.incompativeis = l;
    }
    
    public void setObrigacoes(List<Peca> x){
        List<Peca> l = new ArrayList<>();
        for(Peca p : x) {
            l.add(p);
        }
        this.obrigacoes = l;
    }
    
    public String toString(){
        StringBuilder sb = new StringBuilder();
        
        sb.append("Descricao: ");
        sb.append(this.descricao + "\n");
        sb.append("Preco: ");
        sb.append(this.preco + "\n");
        sb.append("Id: ");
        sb.append(this.id + "\n");
        sb.append("Quantidade: ");
        sb.append(this.quantidade + "\n");
        sb.append("Pecas Incompativeis");
        sb.append(this.incompativeis.toString() + "\n");
        sb.append("Pecas Obrigatorias");
        sb.append(this.obrigacoes.toString() + "\n");
        
        return sb.toString();
    }
    
    public boolean equals(Object o){
        if(o==this) return true;
        if(o==null || o.getClass() != this.getClass() ) return false;
        Peca c = (Peca) o;
        boolean ret = c.id == this.id && this.descricao.equals(c.descricao) && this.preco==c.preco && this.quantidade==c.quantidade && this.incompativeis.equals(c.incompativeis) && this.obrigacoes.equals(c.obrigacoes);
        return ret;
    }
    
    public Peca clone(){
        return new Peca(this);
    }
}
