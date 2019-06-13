/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Encomenda;

import java.time.LocalDateTime;
import Componentes.*;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author pedrogoncalves
 */
public class Encomenda implements java.io.Serializable{
    private int iD;
    private double preco;
    private LocalDateTime data;
    private double desconto;
    private int estado;
    private Carro carro;
    private Pacote pacote;
    private List<Peca> pecas;
    
    public Encomenda(){
        this.iD = 0;
        this.preco = 0;
        this.data = LocalDateTime.now();
        this.desconto = 0;
        this.estado = 0;
        this.carro = new Carro();
        this.pacote = null;
        this.pecas = new ArrayList<>();
    }
    
    public Encomenda(int id, double p, LocalDateTime l, double d, int e, String m, String mot, String x, String ma, Pacote pp, ArrayList<Peca> xx){
        this.iD = id;
        this.preco = p;
        this.data = l;
        this.desconto = d;
        this.estado = e;
        this.carro = new Carro(m,mot,x,ma);
        this.pacote = pp;
        this.pecas = xx;
    }
    
    public Encomenda(Encomenda x){
        this.iD = x.getId();
        this.preco = x.getPreco();
        this.data = x.getData();
        this.desconto = x.getDesconto();
        this.estado = x.getEstado();
        this.carro = x.getCarro();
        this.pacote = x.getPacote();
        this.pecas = x.getPecas();
    }
    
    public void setId(int i){
        this.iD = i;
    }
   
    public void setPreco(double p){
        this.preco = p;
    }
    
    public void setData(LocalDateTime l){
        this.data = l;
    }
    
    public void setDesconto(double d){
        this.desconto = d;
    }
    
    public void setEstado(int e){
        this.estado = e;
    }
    
    public void setCarro(Carro c){
        this.carro = c;
    }
    
    public void setPacote(Pacote x){
        this.pacote = x;
    }
    
    public void setPecas(List<Peca> x){
        List<Peca> l = new ArrayList<>();
        for(Peca p : x) {
            l.add(p.clone());
        }
        this.pecas = l;
    }
    
    public int getId(){
        return this.iD;
    }
    
    public double getPreco(){
        return this.preco;
    }
    
    public LocalDateTime getData(){
        return this.data;
    }
    
    public double getDesconto(){
        return this.desconto;
    }
    
    public int getEstado(){
        return this.estado;
    }
    
    public Carro getCarro(){
        return this.carro;
    }
    
    public Pacote getPacote(){
        return this.pacote.clone();
    }
    
    public List<Peca> getPecas(){
        List<Peca> l = new ArrayList<>();
        for (Peca p : this.pecas) {
            l.add(p.clone());
        }
        return l;
    }
    
    public String toString(){
        StringBuilder sb = new StringBuilder();
        
        sb.append("ID: ");
        sb.append(this.iD + "\n");        
        sb.append("Preço: ");
        sb.append(this.preco + "\n");
        sb.append("Data: ");
        sb.append(this.data + "\n");
        sb.append("Desconto: ");
        sb.append(this.desconto + "\n");
        sb.append("Estado: ");
        sb.append(this.estado + "\n");
        sb.append("Carro: ");
        sb.append(this.carro.toString() + "\n");
        sb.append("Pacote: ");
        sb.append(this.pacote.toString() + "\n");
        sb.append("Peças: ");
        sb.append(this.pecas.toString() + "\n");
        
        return sb.toString();
    }
    
    public boolean equals(Object o){
        if(o==this) return true;
        if(o==null || o.getClass() != this.getClass() ) return false;
        Encomenda c = (Encomenda) o;
        boolean ret = c.iD == this.iD && c.preco == this.preco && this.data.equals(c.data) && this.desconto==c.desconto && this.estado==c.estado && this.carro.equals(c.carro) && this.pacote.equals(c.pacote) && this.pecas.equals(c.pecas);
        return ret;
    }
    
    public Encomenda clone(){
        return new Encomenda(this);
    }



    public boolean colisoes() {
        boolean v = false;
        List<Peca> l = this.getPecas();
        if (this.pacote != null) {
        for (Peca p : this.getPacote().getPecas()) {
            if (l.contains(p) == false) l.add(p);
        }
    }
        for (Peca e : l) {
            for(Peca x : e.getIncompativeis()) {
                if (l.contains(x)) v = true;
            }
        }
        return v;
    }

    public boolean missing() {
        boolean v = false;
        List<Peca> l = this.getPecas();
        if (this.pacote != null) {
        for (Peca p : this.getPacote().getPecas()) {
            if (l.contains(p) == false) l.add(p);
        }
    }
        for (Peca e : l) {
            for(Peca x : e.getObrigacoes()) {
                if (l.contains(x) != true) v = true;
            }
        } 
        return v;
    }



    static List<List<Peca>> combo(List<Peca> arr, Peca data[], int start, int end, int index, int r) { 
        List<List<Peca>> l = new ArrayList<>();
        if (index == r) { 
            List<Peca> aux = new ArrayList<>();
            for (int j=0; j<r; j++) 
                aux.add(data[j]);  
            l.add(aux);
            return l; 
        } 
  
        for (int i=start; i<=end && end-i+1 >= r-index; i++) { 
            data[index] = arr.get(i); 
            l.addAll(combo(arr, data, i+1, end, index+1, r)); 
        } 
        return l;
    }

    static List<List<Peca>> printCombination(List<Peca> arr, int n, int r) { 
        Peca data[]=new Peca[r]; 
        return combo(arr, data, 0, n-1, 0, r);
    }
  
    public double getPrecoFinal() // Vai para Encomenda
    {
        return ((this.preco) - this.desconto);
    }
    
    public double calculaPreco(){
        double vf;
        String modelo = this.carro.getModelo();
        String motor = this.carro.getMotorizacao();
        switch (modelo) {
            case "BZ1":
                vf = 13000;
                break;
            case "BZ1.5":
                vf = 18000;
                break;
            case "BZ2":
                vf = 25000;
                break;
            case "B-TEC":
                vf = 45000;
                break;
            case "RA-1":
                vf = 20000;
                break;
            case "RA-2":
                vf = 27000;
                break;
            case "RA-3":
                vf = 33000;
                break;
            case "RA-4":
                vf = 50000;
                break;
            case "FXX":
                vf = 10000000;
                break;
            case "FXX-K":
                vf = 15000000;
                break;
            case "FXX-K-Evo":
                vf = 18000000;
                break;
            case "KACHOW":
                vf = 30000000;
                break;
            default:
                vf = 0;
                break;
        }
        switch (motor) {
            case "xb1":
                vf += 0;
                break;
            case "xb2":
                vf += 1000;
                break;
            case "xb3":
                vf += 1200;
                break;
            case "xb4":
                vf += 1500;
                break;
            case "xb5":
                vf += 1800;
                break;
            case "xb6":
                vf += 2000;
                break;
            case "xb7":
                vf += 2500;
                break;
            case "xb8":
                vf += 3000;
                break;
            case "xr1":
                vf += 0;
                break;
            case "xr2":
                vf += 2000;
                break;
            case "xr3":
                vf += 2200;
                break;
            case "xr4":
                vf += 2500;
                break;
            case "xr5":
                vf += 2800;
                break;
            case "xr6":
                vf += 3000;
                break;
            case "xr7":
                vf += 3500;
                break;
            case "xr8":
                vf += 4000;
            default:
                vf += 0;
                break;
        }
        if(this.pacote!=null){vf+=this.pacote.getPreco();}
        for(Peca p: this.pecas)
        {
            vf += p.getPreco();
        }
        return vf;
    }

public void solver(List<Pacote> pacotes) { 
        
        List<Peca> arr = new ArrayList<>();
        
        // Se pacote tiver peças vai adicionar tudo a lista
        if (this.pacote != null) {
            for (Peca p : this.getPacote().getPecas()){
                if (arr.contains(p) == false) arr.add(p);
            }
        }

        // Adiciona peças extra à lista
        for (Peca p : this.getPecas()) {
            if (arr.contains(p) == false) arr.add(p);
        }

        // Adiciona peças de restrição à lista
        List<Peca> obgs = new ArrayList<>(); 
        for (Peca e : arr) {
            for (Peca x : e.getObrigacoes()) {
                if (arr.contains(x) == false) obgs.add(x);
            }
        }

        for(Peca p : obgs) {
            arr.add(p);
        }
    
        // Gera todas as combinações possíveis dentro da lista de peças
        int n = arr.size(); 
        List<List<Peca>> l = new ArrayList<>(); 
        for (int i = 0; i < n; i++) {
            l.addAll(printCombination(arr, n, i)); 
        } 

        List<Peca> res = new ArrayList<>();
        
        for(List<Peca> e : l) {
            boolean missing = false;
            boolean colisoes = false;
            
            for (Peca pp : e) {
                for(Peca x : pp.getObrigacoes()) {
                    if (e.contains(x) != true) missing = true;
                }
            }

            for (Peca pp : e) {
                for(Peca x : pp.getIncompativeis()) {
                    if (e.contains(x)) colisoes = true;
                }
            }
            // caso a lista cumpra todas as restrições, ela pode ser escolhida como a principal 
            if (missing == false && colisoes == false) {
                // É escolhida a lista com maior tamanho
                if (e.size() > res.size()) {
                    res = e;
                }
            }
        }
        Pacote pac = null;
        // Ve se existe um pacote
        int pc = -1;
        for(int i = 0; i < pacotes.size(); i++) {
            int j = 0;
            for(Peca pec : pacotes.get(i).getPecas()) {
                if (res.contains(pec)) j++;
            }
            if (j == pacotes.get(i).getPecas().size()) {
                pc = i;
            }
        }
        // se nao existir elementos que sejam um pacote ele fica a null
        if (pc == -1) pac = null;
        // se houver um pacote completo
        if (pc != -1) pac = pacotes.get(pc);

        if(pac != null) {
            for (Peca p : pac.getPecas()) {
                if (res.contains(p)) {
                    res.remove(p);
                }
            } 
        }
                
        this.setPacote(pac);        
        this.setPecas(res);
    } 

    public void otima(double valor, List<Peca> arr, List<Pacote> pacotes) {
        List<Peca> res = new ArrayList<>();
        Pacote pac = null;
        // lista com todas as combinacoes de pecas possiveis
        int n = arr.size(); 
        List<List<Peca>> l = new ArrayList<>(); 
        for (int i = 0; i < n; i++) {
            l.addAll(printCombination(arr, n, i)); 
        }

        for(List<Peca> e : l) {
            boolean missing = false;
            boolean colisoes = false;
            
            for (Peca pp : e) {
                for(Peca x : pp.getObrigacoes()) {
                    if (e.contains(x) != true) missing = true;
                }
            }

            for (Peca pp : e) {
                for(Peca x : pp.getIncompativeis()) {
                    if (e.contains(x)) colisoes = true;
                }
            }
            // caso a lista cumpra todas as restrições, ela pode ser escolhida como a principal 
            if (missing == false && colisoes == false) {
                // tem que se ver o pacote antes de calcular o valor!!!!!!
                
                int pc = -1;
                for(int i = 0; i < pacotes.size(); i++) {
                    int j = 0;
                    for(Peca pec : pacotes.get(i).getPecas()) {
                        if (res.contains(pec)) j++;
                    }
                    if (j == pacotes.get(i).getPecas().size()) {
                        pc = i;
                    }
                }
                // se nao existir elementos que sejam um pacote ele fica a null
                if (pc == -1) pac = null;
                // se houver um pacote completo
                if (pc != -1) pac = pacotes.get(pc);
                
                double y = 0;

                if (pac == null) {
                    for(Peca p : e) {
                        y += p.getPreco();
                    }
                }
                else {
                    for (Peca p : e) {
                        if (pac.getPecas().contains(p) == false) y += p.getPreco();
                    }
                    y += pac.getPreco(); 
                }
                // É escolhida a lista de maior tamanho
                if (y <= valor) {
                    if(e.size() > res.size()) {
                        res = e;
                    }    
                }
            }
        }

        if(pac != null) {
            for (Peca p : pac.getPecas()) {
                if (res.contains(p)) {
                    res.remove(p);
                }
            } 
        }
        this.setPacote(pac);
        this.setPecas(res);
    }
}
