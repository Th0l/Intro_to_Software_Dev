/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Componentes;

/**
 *
 * @author pedrogoncalves
 */
public class Carro {
    private String modelo;
    private String motorizacao;
    private String cor;
    private String marca;
    
    public Carro(){
        this.modelo = "n/e";
        this.motorizacao = "n/e";
        this.cor = "n/e";
        this.marca = "n/e";
    }
    
    public Carro(Carro x){
        this.modelo = x.getModelo();
        this.motorizacao = x.getMotorizacao();
        this.cor = x.getCor();
        this.marca = x.getMarca();
    }
    
    public Carro(String m, String mot, String x, String ma){
        this.modelo = m;
        this.motorizacao = mot;
        this.cor = x;
        this.marca = ma;
    }
    
    public void setModelo(String m){
        this.modelo = m;
    }
    
    public void setMotorizacao(String m){
        this.motorizacao = m;
    }
    
    public void setCor(String x){
        this.cor = x;
    }
    
    public void setMarca(String m){
        this.marca = m;
    }
    
    public String getModelo(){
        return this.modelo;
    }
    
    public String getMotorizacao(){
        return this.motorizacao;
    }
    
    public String getCor(){
        return this.cor;
    }
    
    public String getMarca(){
        return this.marca;
    }
    
    public String toString(){
        StringBuilder sb = new StringBuilder();
        
        sb.append("Marca: ");
        sb.append(this.marca + "\n");
        sb.append("Modelo: ");
        sb.append(this.modelo + "\n");
        sb.append("Motorizacao: ");
        sb.append(this.motorizacao + "\n");
        sb.append("Cor: ");
        sb.append(this.cor + "\n");
        
        return sb.toString();
    }
    
    public boolean equals(Object o){
        if(o==this) return true;
        if(o==null || o.getClass() != this.getClass() ) return false;
        Carro c = (Carro) o;
        boolean ret = c.cor.equals(this.cor) && this.modelo.equals(c.modelo) && this.marca.equals(c.marca) && this.motorizacao.equals(c.motorizacao);
        return ret;
    }
    
    public Carro clone(){
        return new Carro(this);
    }
}
