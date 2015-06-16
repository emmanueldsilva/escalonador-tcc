/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package escalonador.tarefas;

import java.awt.Toolkit;
import java.io.*;
import java.util.*;

/**
 *
 * @author Bill
 */
public class EscalonadorDeTarefas {
    
    private static String lerArqResultados(String nomearq){
        /**
         * Lê arquivo de resultados gerado pelo AlgGenetico e adiciona tudo em
         * uma String para ser processada de acordo com a informação desejada.
         */
        
        ArrayList resultadoslist = new ArrayList();
        String resultadosstring;
        
        try {
            BufferedReader in = new BufferedReader(new FileReader(nomearq));
            
            while (in.ready()) {
                resultadoslist.add(in.readLine().replaceAll(",", "."));
            }
            
            in.close();
            
        } catch (Exception e) {
            System.err.printf("\nErro: %s\n", e);
        }
        
        Collections.sort(resultadoslist);
        
        resultadosstring = resultadoslist.toString();
        
        return resultadosstring;
    }
    
    private static double lerMediaDuracao(String resultados){
        /**
         * Le o valor das durações da última geração de cada run e retorna a média.
         */
        
        double mediaduracao;
        int i1,i2;
        
        i1 = resultados.indexOf("ag.mediaduracao=", 0);
        i2 = resultados.indexOf(", ",i1);
        
        mediaduracao=Double.parseDouble(resultados.substring(i1 + "ag.mediaduracao=".length(), i2));
        
        return mediaduracao;
    }
    
    private static double lerMediaDuracaoFactiveis(String resultados){
        /**
         * Le o valor das durações da última geração de cada run e retorna a média.
         */
        
        double mediaduracaofactiveis;
        int i1,i2;
        
        i1 = resultados.indexOf("ag.mediaduracaofactiveis=", 0);
        i2 = resultados.indexOf(", ",i1);
        
        mediaduracaofactiveis=Double.parseDouble(resultados.substring(i1 + "ag.mediaduracaofactiveis=".length(), i2));
        
        return mediaduracaofactiveis;
    }
    
    private static double lerMediaCusto(String resultados){
        /**
         * Le o valor dos custos da última geração de cada run e retorna a média.
         */
        
        double mediacusto;
        int i1,i2;
        
        i1 = resultados.indexOf("ag.mediacusto=", 0);
        i2 = resultados.indexOf(", ",i1);
        
        mediacusto=Double.parseDouble(resultados.substring(i1 + "ag.mediacusto=".length(), i2));
        
        return mediacusto;
    }
    
    private static double lerMediaCustoFactiveis(String resultados){
        /**
         * Le o valor das durações da última geração de cada run e retorna a média.
         */
        
        double mediacustofactiveis;
        int i1,i2;
        
        i1 = resultados.indexOf("ag.mediacustofactiveis=", 0);
        i2 = resultados.indexOf(", ",i1);
        
        mediacustofactiveis=Double.parseDouble(resultados.substring(i1 + "ag.mediacustofactiveis=".length(), i2));
        
        return mediacustofactiveis;
    }
    
    private static double lerHitHate(String resultados){
        /**
         * Le o hit-hate de um arquivo de resultados, ou seja, porcentagem de runs
         * que retornaram um resultado factível.
         */
        
        double hithate;
        int i1,i2;
        
        i1 = resultados.indexOf("ag.hithate=", 0);
        i2 = resultados.indexOf(", ",i1);
        
        hithate=Integer.parseInt(resultados.substring(i1 + "ag.hithate=".length(), i2));
        
        return hithate;
    }
    
    private static long lerTempoExecucao(String resultados){
        /**
         * Le o hit-hate de um arquivo de resultados, ou seja, quantas runs retornaram
         * um resultado factível.
         */
        
        long tempoexecucao;
        int i1,i2;
        
        i1 = resultados.indexOf("ag.tempoexecucao=", 0);
        i2 = resultados.indexOf(", ",i1);
        
        tempoexecucao=Long.parseLong(resultados.substring(i1 + "ag.tempoexecucao=".length(), i2));
        
        return tempoexecucao;
    }
    
    private static double lerMediaTnr(String resultados){
        /**
         * Le a média de tarefas não realizadas de um arquivo de resultados.
         */
        
        double mediatnr;
        int i1,i2;
        
        i1 = resultados.indexOf("ag.mediatnr=", 0);
        i2 = resultados.indexOf(", ",i1);
        
        mediatnr=Double.parseDouble(resultados.substring(i1 + "ag.mediatnr=".length(), i2));
        
        return mediatnr;
    }
    
    private static double lerMediaHabnec(String resultados){
        /**
         * Le a média de habilidades necessárias de um arquivo de resultados.
         */
        
        double mediahabnec;
        int i1,i2;
        
        i1 = resultados.indexOf("ag.mediahabnec=", 0);
        i2 = resultados.indexOf(", ",i1);
        
        mediahabnec=Double.parseDouble(resultados.substring(i1 + "ag.mediahabnec=".length(), i2));
        
        return mediahabnec;
    }
    
    private static double lerMediaTrabExtra(String resultados){
        /**
         * Le a média de trabahlho extra de um arquivo de resultados.
         */
        
        double mediatrabextra;
        int i1,i2;
        
        i1 = resultados.indexOf("ag.mediatrabextra=", 0);
        i2 = resultados.indexOf(", ",i1);
        
        mediatrabextra=Double.parseDouble(resultados.substring(i1 + "ag.mediatrabextra=".length(), i2));
        
        return mediatrabextra;
    }
    
    private static void testeSetarPesos(){
        //TESTE PARA SETAR PESOS.
        int i=0;
        
        i++;
        System.out.printf("Instancia %d/36\n", i);
        AlgGenetico ag = new AlgGenetico("D:\\UEM\\TCC\\Instancias\\Setar Pesos\\inst10-5-5",
                                         "D:\\UEM\\TCC\\Resultados\\Setar Pesos\\inst10-5-5",100,5000,64,3);
        i++;
        System.out.printf("Instancia %d/36\n", i);
        ag = new AlgGenetico("D:\\UEM\\TCC\\Instancias\\Setar Pesos\\inst10-5-10",
                             "D:\\UEM\\TCC\\Resultados\\Setar Pesos\\inst10-5-10",100,5000,64,3);
        i++;
        System.out.printf("Instancia %d/36\n", i);
        ag = new AlgGenetico("D:\\UEM\\TCC\\Instancias\\Setar Pesos\\inst10-5-10-5",
                             "D:\\UEM\\TCC\\Resultados\\Setar Pesos\\inst10-5-10-5",100,5000,64,3);
        i++;
        System.out.printf("Instancia %d/36\n", i);
        ag = new AlgGenetico("D:\\UEM\\TCC\\Instancias\\Setar Pesos\\inst10-5-10-7",
                             "D:\\UEM\\TCC\\Resultados\\Setar Pesos\\inst10-5-10-7",100,5000,64,3);
        i++;
        System.out.printf("Instancia %d/36\n", i);
        ag = new AlgGenetico("D:\\UEM\\TCC\\Instancias\\Setar Pesos\\inst10-10-5",
                             "D:\\UEM\\TCC\\Resultados\\Setar Pesos\\inst10-10-5",100,5000,64,3);
        i++;
        System.out.printf("Instancia %d/36\n", i);
        ag = new AlgGenetico("D:\\UEM\\TCC\\Instancias\\Setar Pesos\\inst10-10-10",
                             "D:\\UEM\\TCC\\Resultados\\Setar Pesos\\inst10-10-10",100,5000,64,3);
        i++;
        System.out.printf("Instancia %d/36\n", i);
        ag = new AlgGenetico("D:\\UEM\\TCC\\Instancias\\Setar Pesos\\inst10-10-10-5",
                             "D:\\UEM\\TCC\\Resultados\\Setar Pesos\\inst10-10-10-5",100,5000,64,3);
        i++;
        System.out.printf("Instancia %d/36\n", i);
        ag = new AlgGenetico("D:\\UEM\\TCC\\Instancias\\Setar Pesos\\inst10-10-10-7",
                             "D:\\UEM\\TCC\\Resultados\\Setar Pesos\\inst10-10-10-7",100,5000,64,3);
        i++;
        System.out.printf("Instancia %d/36\n", i);
        ag = new AlgGenetico("D:\\UEM\\TCC\\Instancias\\Setar Pesos\\inst10-15-5",
                             "D:\\UEM\\TCC\\Resultados\\Setar Pesos\\inst10-15-5",100,5000,64,3);
        i++;
        System.out.printf("Instancia %d/36\n", i);
        ag = new AlgGenetico("D:\\UEM\\TCC\\Instancias\\Setar Pesos\\inst10-15-10",
                             "D:\\UEM\\TCC\\Resultados\\Setar Pesos\\inst10-15-10",100,5000,64,3);
        i++;
        System.out.printf("Instancia %d/36\n", i);
        ag = new AlgGenetico("D:\\UEM\\TCC\\Instancias\\Setar Pesos\\inst10-15-10-5",
                             "D:\\UEM\\TCC\\Resultados\\Setar Pesos\\inst10-15-10-5",100,5000,64,3);
        i++;
        System.out.printf("Instancia %d/36\n", i);
        ag = new AlgGenetico("D:\\UEM\\TCC\\Instancias\\Setar Pesos\\inst10-15-10-7",
                             "D:\\UEM\\TCC\\Resultados\\Setar Pesos\\inst10-15-10-7",100,5000,64,3);
        i++;
        System.out.printf("Instancia %d/36\n", i);
        ag = new AlgGenetico("D:\\UEM\\TCC\\Instancias\\Setar Pesos\\inst20-5-5",
                             "D:\\UEM\\TCC\\Resultados\\Setar Pesos\\inst20-5-5",100,5000,64,3);
        i++;
        System.out.printf("Instancia %d/36\n", i);
        ag = new AlgGenetico("D:\\UEM\\TCC\\Instancias\\Setar Pesos\\inst20-5-10",
                             "D:\\UEM\\TCC\\Resultados\\Setar Pesos\\inst20-5-10",100,5000,64,3);
        i++;
        System.out.printf("Instancia %d/36\n", i);
        ag = new AlgGenetico("D:\\UEM\\TCC\\Instancias\\Setar Pesos\\inst20-5-10-5",
                             "D:\\UEM\\TCC\\Resultados\\Setar Pesos\\inst20-5-10-5",100,5000,64,3);
        i++;
        System.out.printf("Instancia %d/36\n", i);
        ag = new AlgGenetico("D:\\UEM\\TCC\\Instancias\\Setar Pesos\\inst20-5-10-7",
                             "D:\\UEM\\TCC\\Resultados\\Setar Pesos\\inst20-5-10-7",100,5000,64,3);
        i++;
        System.out.printf("Instancia %d/36\n", i);
        ag = new AlgGenetico("D:\\UEM\\TCC\\Instancias\\Setar Pesos\\inst20-10-5",
                             "D:\\UEM\\TCC\\Resultados\\Setar Pesos\\inst20-10-5",100,5000,64,3);
        i++;
        System.out.printf("Instancia %d/36\n", i);
        ag = new AlgGenetico("D:\\UEM\\TCC\\Instancias\\Setar Pesos\\inst20-10-10",
                             "D:\\UEM\\TCC\\Resultados\\Setar Pesos\\inst20-10-10",100,5000,64,3);
        i++;
        System.out.printf("Instancia %d/36\n", i);
        ag = new AlgGenetico("D:\\UEM\\TCC\\Instancias\\Setar Pesos\\inst20-10-10-5",
                             "D:\\UEM\\TCC\\Resultados\\Setar Pesos\\inst20-10-10-5",100,5000,64,3);
        i++;
        System.out.printf("Instancia %d/36\n", i);
        ag = new AlgGenetico("D:\\UEM\\TCC\\Instancias\\Setar Pesos\\inst20-10-10-7",
                             "D:\\UEM\\TCC\\Resultados\\Setar Pesos\\inst20-10-10-7",100,5000,64,3);
        i++;
        System.out.printf("Instancia %d/36\n", i);
        ag = new AlgGenetico("D:\\UEM\\TCC\\Instancias\\Setar Pesos\\inst20-15-5",
                             "D:\\UEM\\TCC\\Resultados\\Setar Pesos\\inst20-15-5",100,5000,64,3);
        i++;
        System.out.printf("Instancia %d/36\n", i);
        ag = new AlgGenetico("D:\\UEM\\TCC\\Instancias\\Setar Pesos\\inst20-15-10",
                             "D:\\UEM\\TCC\\Resultados\\Setar Pesos\\inst20-15-10",100,5000,64,3);
        i++;
        System.out.printf("Instancia %d/36\n", i);
        ag = new AlgGenetico("D:\\UEM\\TCC\\Instancias\\Setar Pesos\\inst20-15-10-5",
                             "D:\\UEM\\TCC\\Resultados\\Setar Pesos\\inst20-15-10-5",100,5000,64,3);
        i++;
        System.out.printf("Instancia %d/36\n", i);
        ag = new AlgGenetico("D:\\UEM\\TCC\\Instancias\\Setar Pesos\\inst20-15-10-7",
                             "D:\\UEM\\TCC\\Resultados\\Setar Pesos\\inst20-15-10-7",100,5000,64,3);
        i++;
        System.out.printf("Instancia %d/36\n", i);
        ag = new AlgGenetico("D:\\UEM\\TCC\\Instancias\\Setar Pesos\\inst30-5-5",
                             "D:\\UEM\\TCC\\Resultados\\Setar Pesos\\inst30-5-5",100,5000,64,3);
        i++;
        System.out.printf("Instancia %d/36\n", i);
        ag = new AlgGenetico("D:\\UEM\\TCC\\Instancias\\Setar Pesos\\inst30-5-10",
                             "D:\\UEM\\TCC\\Resultados\\Setar Pesos\\inst30-5-10",100,5000,64,3);
        i++;
        System.out.printf("Instancia %d/36\n", i);
        ag = new AlgGenetico("D:\\UEM\\TCC\\Instancias\\Setar Pesos\\inst30-5-10-5",
                             "D:\\UEM\\TCC\\Resultados\\Setar Pesos\\inst30-5-10-5",100,5000,64,3);
        i++;
        System.out.printf("Instancia %d/36\n", i);
        ag = new AlgGenetico("D:\\UEM\\TCC\\Instancias\\Setar Pesos\\inst30-5-10-7",
                             "D:\\UEM\\TCC\\Resultados\\Setar Pesos\\inst30-5-10-7",100,5000,64,3);
        i++;
        System.out.printf("Instancia %d/36\n", i);
        ag = new AlgGenetico("D:\\UEM\\TCC\\Instancias\\Setar Pesos\\inst30-10-5",
                             "D:\\UEM\\TCC\\Resultados\\Setar Pesos\\inst30-10-5",100,5000,64,3);
        i++;
        System.out.printf("Instancia %d/36\n", i);
        ag = new AlgGenetico("D:\\UEM\\TCC\\Instancias\\Setar Pesos\\inst30-10-10",
                             "D:\\UEM\\TCC\\Resultados\\Setar Pesos\\inst30-10-10",100,5000,64,3);
        i++;
        System.out.printf("Instancia %d/36\n", i);
        ag = new AlgGenetico("D:\\UEM\\TCC\\Instancias\\Setar Pesos\\inst30-10-10-5",
                             "D:\\UEM\\TCC\\Resultados\\Setar Pesos\\inst30-10-10-5",100,5000,64,3);
        i++;
        System.out.printf("Instancia %d/36\n", i);
        ag = new AlgGenetico("D:\\UEM\\TCC\\Instancias\\Setar Pesos\\inst30-10-10-7",
                             "D:\\UEM\\TCC\\Resultados\\Setar Pesos\\inst30-10-10-7",100,5000,64,3);
        i++;
        System.out.printf("Instancia %d/36\n", i);
        ag = new AlgGenetico("D:\\UEM\\TCC\\Instancias\\Setar Pesos\\inst30-15-5",
                             "D:\\UEM\\TCC\\Resultados\\Setar Pesos\\inst30-15-5",100,5000,64,3);
        i++;
        System.out.printf("Instancia %d/36\n", i);
        ag = new AlgGenetico("D:\\UEM\\TCC\\Instancias\\Setar Pesos\\inst30-15-10",
                             "D:\\UEM\\TCC\\Resultados\\Setar Pesos\\inst30-15-10",100,5000,64,3);
        i++;
        System.out.printf("Instancia %d/36\n", i);
        ag = new AlgGenetico("D:\\UEM\\TCC\\Instancias\\Setar Pesos\\inst30-15-10-5",
                             "D:\\UEM\\TCC\\Resultados\\Setar Pesos\\inst30-15-10-5",100,5000,64,3);
        i++;
        System.out.printf("Instancia %d/36\n", i);
        ag = new AlgGenetico("D:\\UEM\\TCC\\Instancias\\Setar Pesos\\inst30-15-10-7",
                             "D:\\UEM\\TCC\\Resultados\\Setar Pesos\\inst30-15-10-7",100,5000,64,3);
        
        //LER RESULTADOS
        double mediaduracao=0,mediacusto=0,novopesoduracao,novopesocusto; 
        double mediatnr=0,mediahabnec=0,mediatrabextra=0,novopesotnr,novopesohabnec,novopesotrabextra;
        String resultados;
        i=1;
        System.out.printf("Lendo instancia %d/36\n", i);
        resultados = lerArqResultados("D:\\UEM\\TCC\\Resultados\\Setar Pesos\\inst10-5-5");
        mediaduracao += lerMediaDuracao(resultados);
        mediacusto += lerMediaCusto(resultados);
        mediatnr += lerMediaTnr(resultados);
        mediahabnec += lerMediaHabnec(resultados);
        mediatrabextra += lerMediaTrabExtra(resultados);
        i++;
        System.out.printf("Lendo instancia %d/36\n", i);
        resultados = lerArqResultados("D:\\UEM\\TCC\\Resultados\\Setar Pesos\\inst10-5-10");
        mediaduracao += lerMediaDuracao(resultados);
        mediacusto += lerMediaCusto(resultados);
        mediatnr += lerMediaTnr(resultados);
        mediahabnec += lerMediaHabnec(resultados);
        mediatrabextra += lerMediaTrabExtra(resultados);
        i++;
        System.out.printf("Lendo instancia %d/36\n", i);
        resultados = lerArqResultados("D:\\UEM\\TCC\\Resultados\\Setar Pesos\\inst10-5-10-5");
        mediaduracao += lerMediaDuracao(resultados);
        mediacusto += lerMediaCusto(resultados);
        mediatnr += lerMediaTnr(resultados);
        mediahabnec += lerMediaHabnec(resultados);
        mediatrabextra += lerMediaTrabExtra(resultados);
        i++;
        System.out.printf("Lendo instancia %d/36\n", i);
        resultados = lerArqResultados("D:\\UEM\\TCC\\Resultados\\Setar Pesos\\inst10-5-10-7");
        mediaduracao += lerMediaDuracao(resultados);
        mediacusto += lerMediaCusto(resultados);
        mediatnr += lerMediaTnr(resultados);
        mediahabnec += lerMediaHabnec(resultados);
        mediatrabextra += lerMediaTrabExtra(resultados);
        i++;
        System.out.printf("Lendo instancia %d/36\n", i);
        resultados = lerArqResultados("D:\\UEM\\TCC\\Resultados\\Setar Pesos\\inst10-10-5");
        mediaduracao += lerMediaDuracao(resultados);
        mediacusto += lerMediaCusto(resultados);
        mediatnr += lerMediaTnr(resultados);
        mediahabnec += lerMediaHabnec(resultados);
        mediatrabextra += lerMediaTrabExtra(resultados);
        i++;
        System.out.printf("Lendo instancia %d/36\n", i);
        resultados = lerArqResultados("D:\\UEM\\TCC\\Resultados\\Setar Pesos\\inst10-10-10");
        mediaduracao += lerMediaDuracao(resultados);
        mediacusto += lerMediaCusto(resultados);
        mediatnr += lerMediaTnr(resultados);
        mediahabnec += lerMediaHabnec(resultados);
        mediatrabextra += lerMediaTrabExtra(resultados);
        i++;
        System.out.printf("Lendo instancia %d/36\n", i);
        resultados = lerArqResultados("D:\\UEM\\TCC\\Resultados\\Setar Pesos\\inst10-10-10-5");
        mediaduracao += lerMediaDuracao(resultados);
        mediacusto += lerMediaCusto(resultados);
        mediatnr += lerMediaTnr(resultados);
        mediahabnec += lerMediaHabnec(resultados);
        mediatrabextra += lerMediaTrabExtra(resultados);
        i++;
        System.out.printf("Lendo instancia %d/36\n", i);
        resultados = lerArqResultados("D:\\UEM\\TCC\\Resultados\\Setar Pesos\\inst10-10-10-7");
        mediaduracao += lerMediaDuracao(resultados);
        mediacusto += lerMediaCusto(resultados);
        mediatnr += lerMediaTnr(resultados);
        mediahabnec += lerMediaHabnec(resultados);
        mediatrabextra += lerMediaTrabExtra(resultados);
        i++;
        System.out.printf("Lendo instancia %d/36\n", i);
        resultados = lerArqResultados("D:\\UEM\\TCC\\Resultados\\Setar Pesos\\inst10-15-5");
        mediaduracao += lerMediaDuracao(resultados);
        mediacusto += lerMediaCusto(resultados);
        mediatnr += lerMediaTnr(resultados);
        mediahabnec += lerMediaHabnec(resultados);
        mediatrabextra += lerMediaTrabExtra(resultados);
        i++;
        System.out.printf("Lendo instancia %d/36\n", i);
        resultados = lerArqResultados("D:\\UEM\\TCC\\Resultados\\Setar Pesos\\inst10-15-10");
        mediaduracao += lerMediaDuracao(resultados);
        mediacusto += lerMediaCusto(resultados);
        mediatnr += lerMediaTnr(resultados);
        mediahabnec += lerMediaHabnec(resultados);
        mediatrabextra += lerMediaTrabExtra(resultados);
        i++;
        System.out.printf("Lendo instancia %d/36\n", i);
        resultados = lerArqResultados("D:\\UEM\\TCC\\Resultados\\Setar Pesos\\inst10-15-10-5");
        mediaduracao += lerMediaDuracao(resultados);
        mediacusto += lerMediaCusto(resultados);
        mediatnr += lerMediaTnr(resultados);
        mediahabnec += lerMediaHabnec(resultados);
        mediatrabextra += lerMediaTrabExtra(resultados);
        i++;
        System.out.printf("Lendo instancia %d/36\n", i);
        resultados = lerArqResultados("D:\\UEM\\TCC\\Resultados\\Setar Pesos\\inst10-15-10-7");
        mediaduracao += lerMediaDuracao(resultados);
        mediacusto += lerMediaCusto(resultados);
        mediatnr += lerMediaTnr(resultados);
        mediahabnec += lerMediaHabnec(resultados);
        mediatrabextra += lerMediaTrabExtra(resultados);
        i++;
        System.out.printf("Lendo instancia %d/36\n", i);
        resultados = lerArqResultados("D:\\UEM\\TCC\\Resultados\\Setar Pesos\\inst20-5-5");
        mediaduracao += lerMediaDuracao(resultados);
        mediacusto += lerMediaCusto(resultados);
        mediatnr += lerMediaTnr(resultados);
        mediahabnec += lerMediaHabnec(resultados);
        mediatrabextra += lerMediaTrabExtra(resultados);
        i++;
        System.out.printf("Lendo instancia %d/36\n", i);
        resultados = lerArqResultados("D:\\UEM\\TCC\\Resultados\\Setar Pesos\\inst20-5-10");
        mediaduracao += lerMediaDuracao(resultados);
        mediacusto += lerMediaCusto(resultados);
        mediatnr += lerMediaTnr(resultados);
        mediahabnec += lerMediaHabnec(resultados);
        mediatrabextra += lerMediaTrabExtra(resultados);
        i++;
        System.out.printf("Lendo instancia %d/36\n", i);
        resultados = lerArqResultados("D:\\UEM\\TCC\\Resultados\\Setar Pesos\\inst30-15-10-7");
        mediaduracao += lerMediaDuracao(resultados);
        mediacusto += lerMediaCusto(resultados);
        mediatnr += lerMediaTnr(resultados);
        mediahabnec += lerMediaHabnec(resultados);
        mediatrabextra += lerMediaTrabExtra(resultados);
        i++;
        System.out.printf("Lendo instancia %d/36\n", i);
        resultados = lerArqResultados("D:\\UEM\\TCC\\Resultados\\Setar Pesos\\inst20-5-10-5");
        mediaduracao += lerMediaDuracao(resultados);
        mediacusto += lerMediaCusto(resultados);
        mediatnr += lerMediaTnr(resultados);
        mediahabnec += lerMediaHabnec(resultados);
        mediatrabextra += lerMediaTrabExtra(resultados);
        i++;
        System.out.printf("Lendo instancia %d/36\n", i);
        resultados = lerArqResultados("D:\\UEM\\TCC\\Resultados\\Setar Pesos\\inst20-5-10-7");
        mediaduracao += lerMediaDuracao(resultados);
        mediacusto += lerMediaCusto(resultados);
        mediatnr += lerMediaTnr(resultados);
        mediahabnec += lerMediaHabnec(resultados);
        mediatrabextra += lerMediaTrabExtra(resultados);
        i++;
        System.out.printf("Lendo instancia %d/36\n", i);
        resultados = lerArqResultados("D:\\UEM\\TCC\\Resultados\\Setar Pesos\\inst20-10-5");
        mediaduracao += lerMediaDuracao(resultados);
        mediacusto += lerMediaCusto(resultados);
        mediatnr += lerMediaTnr(resultados);
        mediahabnec += lerMediaHabnec(resultados);
        mediatrabextra += lerMediaTrabExtra(resultados);
        i++;
        System.out.printf("Lendo instancia %d/36\n", i);
        resultados = lerArqResultados("D:\\UEM\\TCC\\Resultados\\Setar Pesos\\inst20-10-10");
        mediaduracao += lerMediaDuracao(resultados);
        mediacusto += lerMediaCusto(resultados);
        mediatnr += lerMediaTnr(resultados);
        mediahabnec += lerMediaHabnec(resultados);
        mediatrabextra += lerMediaTrabExtra(resultados);
        i++;
        System.out.printf("Lendo instancia %d/36\n", i);
        resultados = lerArqResultados("D:\\UEM\\TCC\\Resultados\\Setar Pesos\\inst20-10-10-5");
        mediaduracao += lerMediaDuracao(resultados);
        mediacusto += lerMediaCusto(resultados);
        mediatnr += lerMediaTnr(resultados);
        mediahabnec += lerMediaHabnec(resultados);
        mediatrabextra += lerMediaTrabExtra(resultados);
        i++;
        System.out.printf("Lendo instancia %d/36\n", i);
        resultados = lerArqResultados("D:\\UEM\\TCC\\Resultados\\Setar Pesos\\inst20-10-10-7");
        mediaduracao += lerMediaDuracao(resultados);
        mediacusto += lerMediaCusto(resultados);
        mediatnr += lerMediaTnr(resultados);
        mediahabnec += lerMediaHabnec(resultados);
        mediatrabextra += lerMediaTrabExtra(resultados);
        i++;
        System.out.printf("Lendo instancia %d/36\n", i);
        resultados = lerArqResultados("D:\\UEM\\TCC\\Resultados\\Setar Pesos\\inst20-15-5");
        mediaduracao += lerMediaDuracao(resultados);
        mediacusto += lerMediaCusto(resultados);
        mediatnr += lerMediaTnr(resultados);
        mediahabnec += lerMediaHabnec(resultados);
        mediatrabextra += lerMediaTrabExtra(resultados);
        i++;
        System.out.printf("Lendo instancia %d/36\n", i);
        resultados = lerArqResultados("D:\\UEM\\TCC\\Resultados\\Setar Pesos\\inst20-15-10");
        mediaduracao += lerMediaDuracao(resultados);
        mediacusto += lerMediaCusto(resultados);
        mediatnr += lerMediaTnr(resultados);
        mediahabnec += lerMediaHabnec(resultados);
        mediatrabextra += lerMediaTrabExtra(resultados);
        i++;
        System.out.printf("Lendo instancia %d/36\n", i);
        resultados = lerArqResultados("D:\\UEM\\TCC\\Resultados\\Setar Pesos\\inst20-15-10-5");
        mediaduracao += lerMediaDuracao(resultados);
        mediacusto += lerMediaCusto(resultados);
        mediatnr += lerMediaTnr(resultados);
        mediahabnec += lerMediaHabnec(resultados);
        mediatrabextra += lerMediaTrabExtra(resultados);
        i++;
        System.out.printf("Lendo instancia %d/36\n", i);
        resultados = lerArqResultados("D:\\UEM\\TCC\\Resultados\\Setar Pesos\\inst20-15-10-7");
        mediaduracao += lerMediaDuracao(resultados);
        mediacusto += lerMediaCusto(resultados);
        mediatnr += lerMediaTnr(resultados);
        mediahabnec += lerMediaHabnec(resultados);
        mediatrabextra += lerMediaTrabExtra(resultados);
        i++;
        System.out.printf("Lendo instancia %d/36\n", i);
        resultados = lerArqResultados("D:\\UEM\\TCC\\Resultados\\Setar Pesos\\inst30-5-5");
        mediaduracao += lerMediaDuracao(resultados);
        mediacusto += lerMediaCusto(resultados);
        mediatnr += lerMediaTnr(resultados);
        mediahabnec += lerMediaHabnec(resultados);
        mediatrabextra += lerMediaTrabExtra(resultados);
        i++;
        System.out.printf("Lendo instancia %d/36\n", i);
        resultados = lerArqResultados("D:\\UEM\\TCC\\Resultados\\Setar Pesos\\inst30-5-10");
        mediaduracao += lerMediaDuracao(resultados);
        mediacusto += lerMediaCusto(resultados);
        mediatnr += lerMediaTnr(resultados);
        mediahabnec += lerMediaHabnec(resultados);
        mediatrabextra += lerMediaTrabExtra(resultados);
        i++;
        System.out.printf("Lendo instancia %d/36\n", i);
        resultados = lerArqResultados("D:\\UEM\\TCC\\Resultados\\Setar Pesos\\inst30-5-10-5");
        mediaduracao += lerMediaDuracao(resultados);
        mediacusto += lerMediaCusto(resultados);
        mediatnr += lerMediaTnr(resultados);
        mediahabnec += lerMediaHabnec(resultados);
        mediatrabextra += lerMediaTrabExtra(resultados);
        i++;
        System.out.printf("Lendo instancia %d/36\n", i);
        resultados = lerArqResultados("D:\\UEM\\TCC\\Resultados\\Setar Pesos\\inst30-5-10-7");
        mediaduracao += lerMediaDuracao(resultados);
        mediacusto += lerMediaCusto(resultados);
        mediatnr += lerMediaTnr(resultados);
        mediahabnec += lerMediaHabnec(resultados);
        mediatrabextra += lerMediaTrabExtra(resultados);
        i++;
        System.out.printf("Lendo instancia %d/36\n", i);
        resultados = lerArqResultados("D:\\UEM\\TCC\\Resultados\\Setar Pesos\\inst30-10-5");
        mediaduracao += lerMediaDuracao(resultados);
        mediacusto += lerMediaCusto(resultados);
        mediatnr += lerMediaTnr(resultados);
        mediahabnec += lerMediaHabnec(resultados);
        mediatrabextra += lerMediaTrabExtra(resultados);
        i++;
        System.out.printf("Lendo instancia %d/36\n", i);
        resultados = lerArqResultados("D:\\UEM\\TCC\\Resultados\\Setar Pesos\\inst30-10-10");
        mediaduracao += lerMediaDuracao(resultados);
        mediacusto += lerMediaCusto(resultados);
        mediatnr += lerMediaTnr(resultados);
        mediahabnec += lerMediaHabnec(resultados);
        mediatrabextra += lerMediaTrabExtra(resultados);
        i++;
        System.out.printf("Lendo instancia %d/36\n", i);
        resultados = lerArqResultados("D:\\UEM\\TCC\\Resultados\\Setar Pesos\\inst30-10-10-5");
        mediaduracao += lerMediaDuracao(resultados);
        mediacusto += lerMediaCusto(resultados);
        mediatnr += lerMediaTnr(resultados);
        mediahabnec += lerMediaHabnec(resultados);
        mediatrabextra += lerMediaTrabExtra(resultados);
        i++;
        System.out.printf("Lendo instancia %d/36\n", i);
        resultados = lerArqResultados("D:\\UEM\\TCC\\Resultados\\Setar Pesos\\inst30-10-10-7");
        mediaduracao += lerMediaDuracao(resultados);
        mediacusto += lerMediaCusto(resultados);
        mediatnr += lerMediaTnr(resultados);
        mediahabnec += lerMediaHabnec(resultados);
        mediatrabextra += lerMediaTrabExtra(resultados);
        i++;
        System.out.printf("Lendo instancia %d/36\n", i);
        resultados = lerArqResultados("D:\\UEM\\TCC\\Resultados\\Setar Pesos\\inst30-15-5");
        mediaduracao += lerMediaDuracao(resultados);
        mediacusto += lerMediaCusto(resultados);
        mediatnr += lerMediaTnr(resultados);
        mediahabnec += lerMediaHabnec(resultados);
        mediatrabextra += lerMediaTrabExtra(resultados);
        i++;
        System.out.printf("Lendo instancia %d/36\n", i);
        resultados = lerArqResultados("D:\\UEM\\TCC\\Resultados\\Setar Pesos\\inst30-15-10");
        mediaduracao += lerMediaDuracao(resultados);
        mediacusto += lerMediaCusto(resultados);
        mediatnr += lerMediaTnr(resultados);
        mediahabnec += lerMediaHabnec(resultados);
        mediatrabextra += lerMediaTrabExtra(resultados);
        i++;
        System.out.printf("Lendo instancia %d/36\n", i);
        resultados = lerArqResultados("D:\\UEM\\TCC\\Resultados\\Setar Pesos\\inst30-15-10-5");
        mediaduracao += lerMediaDuracao(resultados);
        mediacusto += lerMediaCusto(resultados);
        mediatnr += lerMediaTnr(resultados);
        mediahabnec += lerMediaHabnec(resultados);
        mediatrabextra += lerMediaTrabExtra(resultados);
        i++;
        System.out.printf("Lendo instancia %d/36\n", i);
        resultados = lerArqResultados("D:\\UEM\\TCC\\Resultados\\Setar Pesos\\inst30-15-10-7");
        mediaduracao += lerMediaDuracao(resultados);
        mediacusto += lerMediaCusto(resultados);
        mediatnr += lerMediaTnr(resultados);
        mediahabnec += lerMediaHabnec(resultados);
        mediatrabextra += lerMediaTrabExtra(resultados);
        i++;
        
        //APRESENTAR NOVOS PESOS
        mediaduracao = mediaduracao/36;
        mediacusto = mediacusto/36;
        mediatnr = mediatnr/36;
        mediahabnec = mediahabnec/36;
        mediatrabextra = mediatrabextra/36;
        
        novopesoduracao = 1/mediaduracao;
        novopesocusto = 1/mediacusto;
        novopesotnr = 1/mediatnr;
        novopesohabnec = 1/mediahabnec;
        novopesotrabextra = 1/mediatrabextra;
        
        System.out.printf("\nmediaduracao: %.20f\n", mediaduracao);
        System.out.printf("mediacusto: %.20f\n", mediacusto);
        System.out.printf("mediatnr: %.20f\n", mediatnr);
        System.out.printf("mediahabnec: %.20f\n", mediahabnec);
        System.out.printf("mediatrabextra: %.20f\n", mediatrabextra);
        System.out.printf("\nnovopesoduracao: %.30f\n", novopesoduracao);
        System.out.printf("novopesocusto: %.30f\n", novopesocusto);
        System.out.printf("novopesotnr: %.30f\n", novopesotnr);
        System.out.printf("novopesohabnec: %.30f\n", novopesohabnec);
        System.out.printf("novopesotrabextra: %.30f\n", novopesotrabextra);
        
    }
    
    private static void testeEmpregadosDiferentes(){
        //TESTE COM EMPREGADOS DIFERENTES
        System.out.print("TESTE COM EMPREGADOS DIFERENTES\n\n");
        int i=1;
        
        System.out.printf("Instancia %d/4\n", i);
        AlgGenetico ag = new AlgGenetico("D:\\UEM\\TCC\\Instancias\\Teste Empregados Diferentes\\inst10-5-1",
                                         "D:\\UEM\\TCC\\Resultados\\Teste Empregados Diferentes\\inst10-5-1",100,5000,256,3);
        i++;
        System.out.printf("Instancia %d/4\n", i);
        ag = new AlgGenetico("D:\\UEM\\TCC\\Instancias\\Teste Empregados Diferentes\\inst10-10-1",
                             "D:\\UEM\\TCC\\Resultados\\Teste Empregados Diferentes\\inst10-10-1",100,5000,256,3);
        i++;
        System.out.printf("Instancia %d/4\n", i);
        ag = new AlgGenetico("D:\\UEM\\TCC\\Instancias\\Teste Empregados Diferentes\\inst10-15-1",
                             "D:\\UEM\\TCC\\Resultados\\Teste Empregados Diferentes\\inst10-15-1",100,5000,256,3);
        i++;
        
        System.out.printf("Instancia %d/4\n", i);
        ag = new AlgGenetico("D:\\UEM\\TCC\\Instancias\\Teste Empregados Diferentes\\inst10-20-1",
                             "D:\\UEM\\TCC\\Resultados\\Teste Empregados Diferentes\\inst10-20-1",100,5000,256,3);
        i++;
        
    }
    
    private static void testeTarefasDiferentes(){
        //TESTE COM TAREFAS DIFERENTES
        System.out.print("TESTE COM TAREFAS DIFERENTES\n\n");
        int i=1;
        
        System.out.printf("Instancia %d/4\n", i);
        AlgGenetico ag = new AlgGenetico("D:\\UEM\\TCC\\Instancias\\Teste Tarefas Diferentes\\inst10-10-1",
                                         "D:\\UEM\\TCC\\Resultados\\Teste Tarefas Diferentes\\inst10-10-1",100,5000,256,3);
        i++;
        System.out.printf("Instancia %d/4\n", i);
        ag = new AlgGenetico("D:\\UEM\\TCC\\Instancias\\Teste Tarefas Diferentes\\inst15-10-1",
                             "D:\\UEM\\TCC\\Resultados\\Teste Tarefas Diferentes\\inst15-10-1",100,5000,256,3);
        i++;
        System.out.printf("Instancia %d/4\n", i);
        ag = new AlgGenetico("D:\\UEM\\TCC\\Instancias\\Teste Tarefas Diferentes\\inst20-10-1",
                             "D:\\UEM\\TCC\\Resultados\\Teste Tarefas Diferentes\\inst20-10-1",100,5000,256,3);
        i++;
        System.out.printf("Instancia %d/4\n", i);
        ag = new AlgGenetico("D:\\UEM\\TCC\\Instancias\\Teste Tarefas Diferentes\\inst30-10-1",
                             "D:\\UEM\\TCC\\Resultados\\Teste Tarefas Diferentes\\inst30-10-1",100,5000,256,3);
        i++;
        
    }
    
    private static void testeHabilidadesDiferentes(){
        //TESTE COM TAREFAS DIFERENTES
        System.out.print("TESTE COM HABILIDADES DIFERENTES\n\n");
        int i=1;
        
        System.out.printf("Instancia %d/5\n", i);
        AlgGenetico ag = new AlgGenetico("D:\\UEM\\TCC\\Instancias\\Teste Habilidades Diferentes\\inst10-10-10-2",
                                         "D:\\UEM\\TCC\\Resultados\\Teste Habilidades Diferentes\\inst10-10-10-2",100,5000,256,3);
        i++;
        System.out.printf("Instancia %d/5\n", i);
        ag = new AlgGenetico("D:\\UEM\\TCC\\Instancias\\Teste Habilidades Diferentes\\inst10-10-10-4",
                             "D:\\UEM\\TCC\\Resultados\\Teste Habilidades Diferentes\\inst10-10-10-4",100,5000,256,3);
        i++;
        System.out.printf("Instancia %d/5\n", i);
        ag = new AlgGenetico("D:\\UEM\\TCC\\Instancias\\Teste Habilidades Diferentes\\inst10-10-10-6",
                             "D:\\UEM\\TCC\\Resultados\\Teste Habilidades Diferentes\\inst10-10-10-6",100,5000,256,3);
        i++;
        System.out.printf("Instancia %d/5\n", i);
        ag = new AlgGenetico("D:\\UEM\\TCC\\Instancias\\Teste Habilidades Diferentes\\inst10-10-10-8",
                             "D:\\UEM\\TCC\\Resultados\\Teste Habilidades Diferentes\\inst10-10-10-8",100,5000,256,3);
        i++;
        System.out.printf("Instancia %d/5\n", i);
        ag = new AlgGenetico("D:\\UEM\\TCC\\Instancias\\Teste Habilidades Diferentes\\inst10-10-10-10",
                             "D:\\UEM\\TCC\\Resultados\\Teste Habilidades Diferentes\\inst10-10-10-10",100,5000,256,3);
    }
    
    private static void testeIndividuosDiferentes(){
        //TESTE COM INDIVIDUOS DIFERENTES
        System.out.print("TESTE COM INDIVIDUOS DIFERENTES\n\n");
        
        System.out.print("Instancia 1/2 Teste 1/4\n");
        AlgGenetico ag = new AlgGenetico("D:\\UEM\\TCC\\Instancias\\Teste Individuos Diferentes\\inst10-5-5",
                                         "D:\\UEM\\TCC\\Resultados\\Teste Individuos Diferentes\\inst10-5-5-ind32",100,5000,32,3);
        
        System.out.print("Instancia 1/2 Teste 2/4\n");
        ag = new AlgGenetico("D:\\UEM\\TCC\\Instancias\\Teste Individuos Diferentes\\inst10-5-5",
                             "D:\\UEM\\TCC\\Resultados\\Teste Individuos Diferentes\\inst10-5-5-ind64",100,5000,64,3);
        
        System.out.print("Instancia 1/2 Teste 3/4\n");
        ag = new AlgGenetico("D:\\UEM\\TCC\\Instancias\\Teste Individuos Diferentes\\inst10-5-5",
                             "D:\\UEM\\TCC\\Resultados\\Teste Individuos Diferentes\\inst10-5-5-ind128",100,5000,128,3);
        
        System.out.print("Instancia 1/2 Teste 4/4\n");
        ag = new AlgGenetico("D:\\UEM\\TCC\\Instancias\\Teste Individuos Diferentes\\inst10-5-5",
                             "D:\\UEM\\TCC\\Resultados\\Teste Individuos Diferentes\\inst10-5-5-ind256",100,5000,256,3);
        
        System.out.print("Instancia 2/2 Teste 1/4\n");
        ag = new AlgGenetico("D:\\UEM\\TCC\\Instancias\\Teste Individuos Diferentes\\inst20-10-10",
                             "D:\\UEM\\TCC\\Resultados\\Teste Individuos Diferentes\\inst20-10-10-ind32",100,5000,32,3);
        
        System.out.print("Instancia 2/2 Teste 2/4\n");
        ag = new AlgGenetico("D:\\UEM\\TCC\\Instancias\\Teste Individuos Diferentes\\inst20-10-10",
                             "D:\\UEM\\TCC\\Resultados\\Teste Individuos Diferentes\\inst20-10-10-ind64",100,5000,64,3);
        
        System.out.print("Instancia 2/2 Teste 3/4\n");
        ag = new AlgGenetico("D:\\UEM\\TCC\\Instancias\\Teste Individuos Diferentes\\inst20-10-10",
                             "D:\\UEM\\TCC\\Resultados\\Teste Individuos Diferentes\\inst20-10-10-ind128",100,5000,128,3);
        
        System.out.print("Instancia 2/2 Teste 4/4\n");
        ag = new AlgGenetico("D:\\UEM\\TCC\\Instancias\\Teste Individuos Diferentes\\inst20-10-10",
                             "D:\\UEM\\TCC\\Resultados\\Teste Individuos Diferentes\\inst20-10-10-ind256",100,5000,256,3);
    }
    
    public static void main(String[] args) {
        
        
        
        //Som de alerta quando o programa terminar de rodar.
        Toolkit.getDefaultToolkit().beep();
    }
    
}
