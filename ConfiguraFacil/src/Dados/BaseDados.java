/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dados;

import Componentes.Fabrica;
import Componentes.*;
import Utilizadores.*;
import Encomenda.*;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.io.*;
import java.util.Iterator;

/**
 *
 * @author thol
 */
public class BaseDados implements java.io.Serializable {
    private Fabrica fb; 
    private HashMap<Integer,Operario> hashOperarios;
    private HashMap<Integer,Vendedor> hashVendedores;
    
    public BaseDados()
    {
        fb = new Fabrica();
        hashOperarios = new HashMap<>();
        hashVendedores = new HashMap<>();
    }
    
    /**
    * Função que vai escrever atraves de serialização ambas as HashTables num ficheiro 
    */
    private void WriteData()
    {
        try {
            FileOutputStream fileOut = new FileOutputStream("ficheiros/dados.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(this.fb);
            out.writeObject(this.hashOperarios);
            out.writeObject(this.hashVendedores);
            out.close();
            fileOut.close();
        } catch (IOException i) {
            i.printStackTrace();
        }    
    }
    
    /**
     * Método que vai decifrar o ficheiro com a informação das hash's
     */
    private void LoadData()
    {
        File dir = new File("ficheiros/dados.ser");
        if(dir.exists())
        {
            try {
                FileInputStream fileIn = new FileInputStream("ficheiros/dados.ser");
                ObjectInputStream in = new ObjectInputStream(fileIn);
                this.fb = (Fabrica) in.readObject();
                this.hashOperarios = (HashMap) in.readObject();
                this.hashVendedores = (HashMap) in.readObject();
                in.close();
                fileIn.close();
                
            }catch (IOException i) {
                i.printStackTrace();
                return;
            }catch (ClassNotFoundException c) {
                System.out.println("Class not found exception");
                c.printStackTrace();
                return;
            }
        }
    }
    
    /**
     * Método usada para eliminar todos os conteudos do ficheiro
     */
    public void Fortnite()
    {
        Fabrica newFab = new Fabrica();
        HashMap<Integer,Operario> newHO = new HashMap<>();
        HashMap<Integer,Vendedor> newHV = new HashMap<>();
        try {
            FileOutputStream fileOut = new FileOutputStream("ficheiros/dados.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(newFab);
            out.writeObject(newHO);
            out.writeObject(newHV);
            out.close();
            fileOut.close();
        } catch (IOException i) {
            i.printStackTrace();
        }   
    }
    
    public void insertOperario(Operario op)
    {
        this.LoadData();
        hashOperarios.put(op.getId(), op);
        this.WriteData();
    }
    
    public void insertVendedor(Vendedor vd)
    {
        this.LoadData();
        hashVendedores.put(vd.getId(), vd);
        this.WriteData();
    }
    
    public void inscrsOperario(String n,int t,String p)
    {
        this.LoadData();
        Operario op = new Operario(n,t,p);
        hashOperarios.put(t, op);
        this.WriteData();
    }
    
    public void inscrsVendedor(String n,int t,String p)
    {
        this.LoadData();
        Vendedor vd = new Vendedor(n,t,p);
        hashVendedores.put(t, vd);
        this.WriteData();
    }
    
   public Fabrica getFb()
   {
       this.LoadData();
       return this.fb;
   }
   
   public HashMap<Integer,Operario> getOp()
   {
       this.LoadData();
       return this.hashOperarios;
   }
   
   public HashMap<Integer,Vendedor> getVd()
   {
       this.LoadData();
       return this.hashVendedores;
   }
   
   public void checkContent()
   {
       this.LoadData();
       System.out.println(this.fb.toString());
       System.out.println(this.hashOperarios.toString());
       System.out.println(this.hashVendedores.toString());
   }
   
   //userType = 1 == Operario
   //userType = 2 == Vendedor
   public boolean checkCredenciais(int id, String password, int userType)
   {
       this.LoadData();
       if(userType == 1)
       {
           if(this.hashOperarios.containsKey(id))
           {
               Operario op = this.hashOperarios.get(id);
               if(op.getPassword().compareTo(password) == 0)
               {
                   return true;
               }
           }
       }
       else
       {
           if(this.hashVendedores.containsKey(id))
           {
               Vendedor vd = this.hashVendedores.get(id);
               if(vd.getPassword().compareTo(password) == 0)
               {
                   return true;
               }
           }
       }
       return false;
   }
   
   //userType = 1 == Operario
   //userType = 2 == Vendedor
   public String getNome(int id, int userType)
   {
       this.LoadData();
       
       if(userType == 1)
       {
           Operario op = this.hashOperarios.get(id);
           return op.getNome();
       }
       else
       {
           Vendedor vd = this.hashVendedores.get(id);
           return vd.getNome();
       }
   }
   
   public String[] getEncomendas()
   {
       this.LoadData();
       
       List<Encomenda> oof = this.fb.getFila();
       ArrayList<String> oofy = new ArrayList<>();
       Iterator<Encomenda> it = oof.iterator();
       while(it.hasNext())
       {
           Encomenda ee = it.next();
           oofy.add(Integer.toString(ee.getId()));
       }
       
       String[] ret = oofy.toArray(new String[oof.size()]);
       
       return ret;
   }
   
   public String[] getPecasN(int id)
   {
       this.LoadData();
       
       List<Encomenda> search = fb.getFila();
       Iterator<Encomenda> it = search.iterator();
       Encomenda ee = new Encomenda();
       while(it.hasNext())
       {
           Encomenda xx = it.next();
           if(xx.getId() == id)
           {
               ee = new Encomenda(xx);
               break;
           }
       }
       
       ArrayList<String> convert = new ArrayList<>();
       List<Peca> peruse = ee.getPecas();
       Iterator<Peca> ite = peruse.iterator();
       while(ite.hasNext())
       {
           Peca pp = ite.next();
           convert.add(pp.getDescricao());
       }
       
       String[] ret = convert.toArray(new String[convert.size()]);
       
       return ret;
   }
   
   public String[] getPecasQ(int id)
   {
       this.LoadData();
       
       List<Encomenda> search = fb.getFila();
       Iterator<Encomenda> it = search.iterator();
       Encomenda ee = new Encomenda();
       while(it.hasNext())
       {
           Encomenda xx = it.next();
           if(xx.getId() == id)
           {
               ee = new Encomenda(xx);
               break;
           }
       }
       
       ArrayList<String> convert = new ArrayList<>();
       List<Peca> peruse = ee.getPecas();
       Iterator<Peca> ite = peruse.iterator();
       while(ite.hasNext())
       {
           Peca pp = ite.next();
           convert.add(Integer.toString(pp.getQuantidade()));
       }
       
       String[] ret = convert.toArray(new String[convert.size()]);
       
       return ret;
   }
   
    public String getModelo(int id)
   {
       this.LoadData();
       
       List<Encomenda> search = fb.getFila();
       Iterator<Encomenda> it = search.iterator();
       Encomenda ee = new Encomenda();
       while(it.hasNext())
       {
           Encomenda xx = it.next();
           if(xx.getId() == id)
           {
               ee = new Encomenda(xx);
               break;
           }
       }
       
       return ee.getCarro().getModelo();
   }
   
   public String[] getPecasFN()
   {
       this.LoadData();
      
       return fb.getPecasStock();
   }
   
   public String[] getPecasFQ()
   {
       this.LoadData();
       
       return fb.getPecasStockQuant();
   }
   
   public void atualizaStock(String d, int q)
   {
       this.LoadData();
       fb.atualiza(d,q);
       this.WriteData();
   }
   
   public String[] getMarca(){return fb.getMarcas();}
   
   public String[] getModelo(String marca){return fb.getModelos(marca);}
   
   public String[] getMotorizacoes(String marca,String modelo){return fb.getMotorizacoes(marca, modelo);}
   
   public String[] getCores(){return fb.getCores();}
   
   public String[] getPacotes(){return fb.getPacotes();}
   
   public Map<Integer,Peca> getTodasPecas(){this.LoadData(); return fb.getStock();}
   
   public int getNEnc(){this.LoadData(); return fb.getFila().size();}
   
   public void insertEncomenda(Encomenda e){this.LoadData();fb.adicionaFila(e);this.WriteData();}
   
   public void removeVendedor(int id){this.LoadData(); hashVendedores.remove(id); this.WriteData();}
   
   public void removeOperario(int id){this.LoadData(); hashOperarios.remove(id); this.WriteData();}
   
   public void insertPecas(HashMap<Integer,Peca> gg){this.LoadData();fb.setStock(gg);this.WriteData();}
}
