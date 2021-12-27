/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tp2;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author raulcoelho & miguelsilva
 */
public class MainOlxyz {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Anunciante[] arr = new Anunciante[5];

        //Telemoveis a anunciar pelos anunciantes 
        Telemoveis t1 = new Telemoveis("Samsung", 300);
        Telemoveis t2 = new Telemoveis("IPhone", 600);

        //Apartamentos a anunciar pelos anunciantes
        Apartamentos ap1 = new Apartamentos("Rua da Senhora", "4500-023", "Lisboa", 100, 650);
        Apartamentos ap2 = new Apartamentos("Rua da luz", "4500-323", "Porto", 120, 400);
        Apartamentos ap3 = new Apartamentos("Rua da maria", "4030-123", "Aveiro", 230, 800);
        Apartamentos ap4 = new Apartamentos("Rua do Fernando", "4533-043", "Santo Tirso", 180, 500);

        //Automoveis a anunciar pelos anunciantes
        Automoveis au1 = new Automoveis("BMW", "X2", 0, 1000);
        Automoveis au2 = new Automoveis("Mercedes", "CLS", 40000, 0);

        List<Vendaveis> listaV1 = new ArrayList<>();
        List<Alugaveis> listaA1 = new ArrayList<>();

        List<Vendaveis> listaV2 = new ArrayList<>();
        List<Alugaveis> listaA2 = new ArrayList<>();

        List<Vendaveis> listaV3 = new ArrayList<>();
        List<Alugaveis> listaA3 = new ArrayList<>();

        listaV1.add(t1);
        listaA1.add(au1);
        listaA1.add(ap1);

        listaV2.add(au2);
        listaV2.add(t2);
        listaA2.add(ap2);

        listaA3.add(ap3);
        listaA3.add(ap4);

        Anunciante a1 = new Anunciante("José", "Rua da Senhora", "4500-023", "Porto", listaV1, listaA1);
        Anunciante a2 = new Anunciante("Raul", "Rua do Facho", "4825-023", "Santo Tirso", listaV2, listaA2);
        Anunciante a3 = new Anunciante("Miguel", "Rua de Freitas", "4795-205", "Rebordões", listaV3, listaA3);

        arr[0] = a1;
        arr[1] = a2;
        arr[2] = a3;

        //5)
        System.out.println("\n\n### TOTAL DE ARTIGOS DISPONÍVEIS PARA ALUGAR NA PLATAFORMA ###");
        int total = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null) {
                total += arr[i].calcularTotalProdutosAlugar();
            }
        }
        System.out.println("\nTotal de artigos: " + total);

        //6)
        System.out.println("\n\n### CATACTERISTICAS DOS ANUNCIANTES QUE PRETENDEM VENDER ###");
        for (int i = 0; i < arr.length; i++) {
            float total1;
            if (arr[i] != null) {
                if (arr[i].getListaVendaveis().size() != 0) {
                    total1 = arr[i].calcularValorPossivelVendas();
                    System.out.printf("%n%s %nTOTAL DAS VENDAS: %s€%n", arr[i].toString(), total1);
                }
            }
        }

        //7)
        System.out.println("\n\n### CATACTERISTICAS DO ALUGAVEL MAIS CARO DE CADA ANUNCIANTE ###");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null) {
                if (arr[i].getListaAlugaveis().size() != 0) {
                    Alugaveis maisCaro = arr[i].getAluguerMaisCaro();
                    System.out.printf("%nANUNCIANTE%nNOME: %s%nTIPO: %s%nLUCRO GERADO: %.2f€%n",
                            arr[i].getNome(), maisCaro.getClass().getSimpleName(), (maisCaro.calcularValorAluguer() - maisCaro.getValorAluguer()));
                }
            }
        }

    }
}
