/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dados;
import Componentes.*;
import java.util.List;
import java.util.ArrayList;


/**
 *
 * @author thol
 */
public class InfoPacote {
    private Sport sp;
    private Executivo ex;
    private Conforto cf;
    
    public InfoPacote()
    {
        this.runPacotes();
    }
    
    public void runPacotes()
    {
        Peca p1 = new Peca("Jante Liga Leve 16",200.00,1,40);
        Peca p2 = new Peca("Jante Liga Leve 17",300.00,2,32);
        Peca p3 = new Peca("Jante Carbono 18", 1200.00, 3, 4);
        Peca p4 = new Peca("Estofo Clássico", 1500.00, 4, 60);
        Peca p5 = new Peca("Estofo Desportivo", 1600.00, 5, 28);
        Peca p6 = new Peca("AI Claro", 1000.00, 6, 100);
        Peca p7 = new Peca("AI Escuro", 1300.00, 7 , 83);
        Peca p8 = new Peca("Forro em Pele", 3000.00, 8, 24);
        Peca p9 = new Peca("Forro em Pano", 1200.00, 9, 52);
        Peca p10 = new Peca("Forro em Alcântara", 1800.00,10, 47);
        Peca p11 = new Peca("Faróis Led", 2050.00 , 11, 80);
        Peca p12 = new Peca("Faróis Laser", 3000.00, 12, 56);
        Peca p13 = new Peca("Vidro Com Proteção Solar", 200.00, 13, 200);
        Peca p14 = new Peca("Vidro Escurecido", 500.00, 14, 85);
        Peca p15 = new Peca("AC", 400.00, 15, 34);
        Peca p16 = new Peca("GPS", 500.00, 16, 25);
        Peca p17 = new Peca("Ecrã de Bordo", 1200.00, 17, 13);
        Peca p18 = new Peca("Câmara Traseira", 800.00, 18, 17);
        Peca p19 = new Peca("Câmara Dianteira", 700.00, 19, 21);
        Peca p20 = new Peca("Suspensão Pneumática", 2000.00, 20, 13);
        Peca p21 = new Peca("Suspensão Adaptativa", 1500.00, 21, 17);
        Peca p22 = new Peca("Suspensão Normal", 800.00, 22, 23);
        Peca p23 = new Peca("Pneu Normal", 300.00, 23, 36);
        Peca p24 = new Peca("Pneu Runflat", 400.00, 24, 32);
        Peca p25 = new Peca("Sensor de Estacionamento", 400.00, 25, 15);
 
        ArrayList<Peca> i1 = new ArrayList<>(); i1.add(p2); i1.add(p3);
        ArrayList<Peca> i2 = new ArrayList<>(); i2.add(p1); i2.add(p3);
        ArrayList<Peca> i3 = new ArrayList<>(); i3.add(p1); i3.add(p2);
        ArrayList<Peca> i4 = new ArrayList<>(); i4.add(p5);
        ArrayList<Peca> i5 = new ArrayList<>(); i5.add(p4);
        ArrayList<Peca> i6 = new ArrayList<>(); i6.add(p7);
        ArrayList<Peca> i7 = new ArrayList<>(); i7.add(p6);
        ArrayList<Peca> i8 = new ArrayList<>(); i8.add(p9); i8.add(p10);
        ArrayList<Peca> i9 = new ArrayList<>(); i9.add(p8); i9.add(p10);
        ArrayList<Peca> i10 = new ArrayList<>(); i10.add(p8); i10.add(p9);
        ArrayList<Peca> i11 = new ArrayList<>(); i11.add(p12);
        ArrayList<Peca> i12 = new ArrayList<>(); i12.add(p11);
        ArrayList<Peca> i13 = new ArrayList<>(); i13.add(p14);
        ArrayList<Peca> i14 = new ArrayList<>(); i14.add(p13);
        ArrayList<Peca> i15 = new ArrayList<>();
        ArrayList<Peca> i16 = new ArrayList<>();
        ArrayList<Peca> i17 = new ArrayList<>();
        ArrayList<Peca> i18 = new ArrayList<>();
        ArrayList<Peca> i19 = new ArrayList<>();
        ArrayList<Peca> i20 = new ArrayList<>(); i20.add(p21); i20.add(p22);
        ArrayList<Peca> i21 = new ArrayList<>(); i21.add(p20); i21.add(p22);
        ArrayList<Peca> i22 = new ArrayList<>(); i22.add(p20); i22.add(p21);
        ArrayList<Peca> i23 = new ArrayList<>(); i23.add(p24);
        ArrayList<Peca> i24 = new ArrayList<>(); i24.add(p23);
        ArrayList<Peca> i25 = new ArrayList<>();
 
 
        ArrayList<Peca> o1 = new ArrayList<>();
        ArrayList<Peca> o2 = new ArrayList<>();
        ArrayList<Peca> o3 = new ArrayList<>();
        ArrayList<Peca> o4 = new ArrayList<>();
        ArrayList<Peca> o5 = new ArrayList<>();
        ArrayList<Peca> o6 = new ArrayList<>();
        ArrayList<Peca> o7 = new ArrayList<>();
        ArrayList<Peca> o8 = new ArrayList<>();
        ArrayList<Peca> o9 = new ArrayList<>();
        ArrayList<Peca> o10 = new ArrayList<>();
        ArrayList<Peca> o11 = new ArrayList<>();
        ArrayList<Peca> o12 = new ArrayList<>();
        ArrayList<Peca> o13 = new ArrayList<>();
        ArrayList<Peca> o14 = new ArrayList<>();
        ArrayList<Peca> o15 = new ArrayList<>();
        ArrayList<Peca> o16 = new ArrayList<>(); o16.add(p17);
        ArrayList<Peca> o17 = new ArrayList<>();
        ArrayList<Peca> o18 = new ArrayList<>(); o18.add(p17); o18.add(p25);
        ArrayList<Peca> o19 = new ArrayList<>(); o19.add(p17); o19.add(p25);
        ArrayList<Peca> o20 = new ArrayList<>();
        ArrayList<Peca> o21 = new ArrayList<>();
        ArrayList<Peca> o22 = new ArrayList<>();
        ArrayList<Peca> o23 = new ArrayList<>();
        ArrayList<Peca> o24 = new ArrayList<>();
        ArrayList<Peca> o25 = new ArrayList<>();
 
 
        p1.setIncompativeis(i1);
        p1.setObrigacoes(o1);
        p2.setIncompativeis(i2);
        p2.setObrigacoes(o2);
        p3.setIncompativeis(i3);
        p3.setObrigacoes(o3);
        p4.setIncompativeis(i4);
        p4.setObrigacoes(o4);
        p5.setIncompativeis(i5);
        p5.setObrigacoes(o5);
        p6.setIncompativeis(i6);
        p6.setObrigacoes(o6);
        p7.setIncompativeis(i7);
        p7.setObrigacoes(o7);
        p8.setIncompativeis(i8);
        p8.setObrigacoes(o8);
        p9.setIncompativeis(i9);
        p9.setObrigacoes(o9);
        p10.setIncompativeis(i10);
        p10.setObrigacoes(o10);
        p11.setIncompativeis(i11);
        p11.setObrigacoes(o11);
        p12.setIncompativeis(i12);
        p12.setObrigacoes(o12);
        p13.setIncompativeis(i13);
        p13.setObrigacoes(o13);
        p14.setIncompativeis(i14);
        p14.setObrigacoes(o14);
        p15.setIncompativeis(i15);
        p15.setObrigacoes(o15);
        p16.setIncompativeis(i16);
        p16.setObrigacoes(o16);
        p17.setIncompativeis(i17);
        p17.setObrigacoes(o17);
        p18.setIncompativeis(i18);
        p18.setObrigacoes(o18);
        p19.setIncompativeis(i19);
        p19.setObrigacoes(o19);
        p20.setIncompativeis(i20);
        p20.setObrigacoes(o20);
        p21.setIncompativeis(i21);
        p21.setObrigacoes(o21);
        p22.setIncompativeis(i22);
        p22.setObrigacoes(o22);
        p23.setIncompativeis(i23);
        p23.setObrigacoes(o23);
        p24.setIncompativeis(i24);
        p24.setObrigacoes(o24);
        p25.setIncompativeis(i25);
        p25.setObrigacoes(o25);

        ArrayList<Peca> lista1 = new ArrayList<>();
        lista1.add(p3);
        lista1.add(p5);
        lista1.add(p7);
        lista1.add(p10);
        lista1.add(p14);
        lista1.add(p21);
        lista1.add(p24);

        ArrayList<Peca> lista2 = new ArrayList<>();
        lista2.add(p1);
        lista2.add(p4);
        lista2.add(p6);
        lista2.add(p9);
        lista2.add(p13);
        lista2.add(p22);
        lista2.add(p23);
        lista2.add(p25);
 
        ArrayList<Peca> lista3 = new ArrayList<>();
        lista3.add(p2);
        lista3.add(p4);
        lista3.add(p6);
        lista3.add(p8);
        lista3.add(p12);
        lista3.add(p14);
        lista3.add(p15);
        lista3.add(p16);
        lista3.add(p17);
        lista3.add(p18);
        lista3.add(p19);
        lista3.add(p20);
        lista3.add(p24);
        lista3.add(p25);
 
        sp = new Sport(14000.00 , lista1);
        cf = new Conforto( 7000.00 , lista2);
        ex = new Executivo ( 16000.00 , lista3);
    }
    
    public Sport getSport(){return this.sp;}
    public Conforto getConforto(){return this.cf;}
    public Executivo getExecutivo(){return this.ex;}
    
}
