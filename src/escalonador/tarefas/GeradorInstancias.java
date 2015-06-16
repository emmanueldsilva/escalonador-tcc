/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package escalonador.tarefas;

/**
 *
 * @author Bill
 * 
 * Classe que usa a classe ProblemGenerator para criar x instancias dadas, 
 * considerando o arquivo de configuração dado e gerando arquivos de saída.
 */

import pfc.ingsw.ProblemGenerator;

public class GeradorInstancias {
    
    public void gerar(int x, String arqconf, String arqout){
        
        String[] args = {arqconf,arqout};
        
        int i;
        
        try{
            for (i=0;i<x;i++){
                //args[1] = arqout + i;
                
                ProblemGenerator.main(args);
                
                System.out.printf("Instancia %d gerada!\n",i);
            }
            System.out.printf("\nTodas as Instancias geradas!\n");
        } catch(Exception e) {
            System.out.printf("\nErro: %s\n",e);
        }
        
    }
}