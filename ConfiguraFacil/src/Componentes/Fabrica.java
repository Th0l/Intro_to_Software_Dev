/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Componentes;

import Componentes.*;
import Encomenda.Encomenda;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author pedrogoncalves
 */
public class Fabrica implements java.io.Serializable{
    private Map<Integer,Peca> stock;
    private List<Encomenda> fila;

public Fabrica(){
    this.stock = new HashMap<>();
    this.fila = new ArrayList<>();
}

public Fabrica(Map<Integer,Peca> x, List<Encomenda> c){
    this.stock = x;
    this.fila = c;
}

public Fabrica(Fabrica x){
    this.fila = x.getFila();
    this.stock = x.getStock();
}

public void setStock(Map<Integer,Peca> x){
    this.stock = x;
}

public void setFila(List<Encomenda> x){
    List<Encomenda> l = new ArrayList<>();
    for(Encomenda p : x) {
        l.add(p.clone());
    }
    this.fila = l;
}

public Map<Integer,Peca> getStock(){
    return this.stock;
}

public List<Encomenda> getFila(){
    List<Encomenda> l = new ArrayList<>();
    for (Encomenda p : this.fila) {
        l.add(p.clone());
    }
    return l;
}

public String[] getPacotes(){
  String[] ret2 = new String[] {"Pacote Conforto","Pacote Sport","Pacote Executivo"};
  return  ret2;
}

public String[] getMarcas() {
  String[] ret2 = new String[] {"Biat","Razda","Kerrari"};
  return ret2;
}

public String[] getModelos(String marca) {
  if(marca.equals("Biat"))
  {
    String[] ret2 = new String[]{"BZ1","BZ1.5","BZ2","B-TEC"};
    return ret2;
  }
  else if(marca.equals("Razda"))
       {
         String[] ret2 = new String[]{"RA-1","RA-2","RA-3","RA-4"};
         return ret2;
       }
       else if(marca.equals("Kerrari"))
            {
              String[] ret2 = new String[]{"FXX","FXX-K","FXX-K-Evo","KACHOW"};
              return ret2;
            }
    return null;
}

public String[] getCores() {
  String[] ret2 = new String[]{"Vermelho","Preto","Branco","Amarelo","Cinzento","Verde"};
  return ret2;
}

public String[] getMotorizacoes(String marca,String modelo) {
  String[] ret;
  ret = null;

  if(marca.equals("Biat"))
  {
      if(modelo.equals("BZ1")){ret = new String[]{"xb1","xb2"};}
      else if(modelo.equals("BZ1.5")){ret = new String[]{"xb3","xb4"};}
      else if(modelo.equals("BZ2")){ret = new String[]{"xb5","xb6"};}
      else if(modelo.equals("B-TEC")){ret = new String[]{"xb7","xb8"};}

  }else if(marca.equals("Razda"))
        {
          if(modelo.equals("RA-1")){ret = new String[]{"xr1","xr2"};}
          else if(modelo.equals("RA-2")){ret = new String[]{"xr3","xr4"};}
          else if(modelo.equals("RA-3")){ret = new String[]{"xr5","xr6"};}
          else if(modelo.equals("RA-4")){ret = new String[]{"xr7","xr8"};}

        }else if(marca.equals("Kerrari"))
              {
                if(modelo.equals("FXX")){ret = new String[]{"xk1"};}
                else if(modelo.equals("FXX-K")){ret = new String[]{"xk3"};}
                else if(modelo.equals("FXX-K-Evo")){ret = new String[]{"xk5"};}
                else if(modelo.equals("KACHOW")){ret = new String[]{"xk7"};}
              }

  return ret;
}

public String[] getPecasStock() // Vai para Fabrica
{
    ArrayList<String> temp = new ArrayList<>();
    HashMap<Integer,Peca> percorrer = (HashMap) this.getStock();

    Iterator it = percorrer.entrySet().iterator();
    while(it.hasNext())
    {
      Map.Entry pair = (Map.Entry) it.next();
      Peca pc = (Peca) pair.getValue();
      String desc = pc.getDescricao();
      temp.add(desc);
    }

    String[] ret = temp.toArray(new String[temp.size()]);

    return ret;
}

public String[] getPecasStockQuant() // Vai para Fabrica
{
    ArrayList<String> temp = new ArrayList<>();
    HashMap<Integer,Peca> percorrer = (HashMap) this.getStock();

    Iterator it = percorrer.entrySet().iterator();
    while(it.hasNext())
    {
      Map.Entry pair = (Map.Entry) it.next();
      Peca pc = (Peca) pair.getValue();
      String desc = Integer.toString(pc.getQuantidade());
      temp.add(desc);
    }

    String[] ret = temp.toArray(new String[temp.size()]);

    return ret;
}

public void adicionaFila(Encomenda e) // Vai para Fabrica
{
  this.fila.add(e);
}

public void atualiza(String descricao,int quant) // Vai para Fabrica
{
  HashMap<Integer,Peca> percorrer = (HashMap) this.getStock();

  Iterator it = percorrer.entrySet().iterator();
  while(it.hasNext())
  {
    Map.Entry pair = (Map.Entry) it.next();
    Peca pc = (Peca) pair.getValue();
    String dc = pc.getDescricao();
    if(dc.equals(descricao))
    {
      int set = pc.getQuantidade();
      int id = pc.getId();

      set+=quant;

      pc.setQuantidade(set);
      this.stock.replace(id,pc);

      break;
    }
  }
}

public String toString()
{
    StringBuilder sb = new StringBuilder();
    sb.append("Todas as Peças em Stock\n");
    sb.append(this.stock.toString());
    sb.append("\n");
    sb.append("Todas as Encomendas na Fila");
    sb.append(this.fila.toString());
    return sb.toString();
}

/*
public Fabrica clone(){
    return new Fabrica(this);
}
*/

}
