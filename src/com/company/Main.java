package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String[] dataDaRelacao = null;

        System.out.println("Quando o namoro começou? (dia/mes/ano)");
        Scanner teclado = new Scanner(System.in);
        String data = teclado.nextLine();
        dataDaRelacao = data.split("/",3);

        teclado.close();

        int dia = Integer.parseInt(dataDaRelacao[0]);
        int mes = (Integer.parseInt(dataDaRelacao[1])-1);
        int ano = Integer.parseInt(dataDaRelacao[2]);

        GregorianCalendar dataInicioNamoro = new GregorianCalendar();
        dataInicioNamoro.set(ano,mes,dia,0,0);

        DatasEspeciais datasEspeciais = new DatasEspeciais(dataInicioNamoro);
        System.out.println(datasEspeciais.toString());

        System.out.println("sou foda");


    }



}
