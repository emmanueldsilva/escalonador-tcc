 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package escalonador.tarefas;

/**
 * 
 * 
 * @author Bill
 */

import java.io.*;
import java.util.*;
import org.jfree.ui.RefineryUtilities;

public class AlgGenetico {
    
    private String nomearqinstancia;        //Nome do arquivo de instância (gerado pelo GeradorInstancias.java) a ser lido.
    private int numindividuos;              //Número de indivíduos da população que será processada pelo algoritmo genético.
    private int numbitsdedicacao;           //Número de bits usados na representacão do valor de dedicação de cada empregado, ou seja, cada elemento da matriz de solução.
    private String instancia;            //Lista que representa a instância a ser resolvida pelo algoritmo genético. Cada elemento da lista é uma linha do arquivo de instancia.
    private ArrayList populacao;            //Lista de indivíduos da população, onde cada indivíduo é uma string de número binario que representa uma matriz de solução.
    private int numtarefas;
    private int numempregados;
    private int numhabilidades;
    private int numarestasgpt;
    private ArrayList arestasgpt;           //Lista de arestas do Task Precedence Graph(Gráfico de Precedência de Tarefas).
    private String[] precedenciatarefas;    //Array de Strings na forma Tarefa A: B C , onde B e C são tarefas que precisam ser realizadas antes da tarefa A.
    private double[] custotarefas;
    private int[] numhabtarefas;
    private String[] habtarefas;
    private int[] numhabempregados;
    private String[] habempregados;
    private double[] salarioempregados;
    private double[] aptidaopopulacao;
    private int[] rankingpopulacao;
    private double[] duracaopopulacao;
    private double[] custopopulacao;
    private boolean[] factivelpopulacao;
    private String nomearquivoresultados;   //Nome do arquivo de saida com resultados do algoritmo.
    private int numiteracoes;               //Número de iterações do loop do algoritmo genético.
    private int numruns;                    //Número de Runs do algoritmo genético.
    
    public int getNumruns() {
        return numruns;
    }

    public void setNumruns(int numruns) {
        this.numruns = numruns;
    }

    public String getNomearquivoresultados() {
        return nomearquivoresultados;
    }

    public void setNomearquivoresultados(String nomearquivoresultados) {
        this.nomearquivoresultados = nomearquivoresultados;
    }

    public int getNumiteracoes() {
        return numiteracoes;
    }

    public void setNumiteracoes(int numiteracoes) {
        this.numiteracoes = numiteracoes;
    }

    public boolean[] getFactivelpopulacao() {
        return factivelpopulacao;
    }

    public void setFactivelpopulacao(boolean[] factivelpopulacao) {
        this.factivelpopulacao = factivelpopulacao;
    }

    public double[] getCustopopulacao() {
        return custopopulacao;
    }

    public void setCustopopulacao(double[] custopopulacao) {
        this.custopopulacao = custopopulacao;
    }

    public double[] getDuracaopopulacao() {
        return duracaopopulacao;
    }

    public void setDuracaopopulacao(double[] duracaopopulacao) {
        this.duracaopopulacao = duracaopopulacao;
    }
    
    public int[] getRankingpopulacao() {
        return rankingpopulacao;
    }

    public void setRankingpopulacao(int[] rankingpopulacao) {
        this.rankingpopulacao = rankingpopulacao;
    }

    public double[] getAptidaopopulacao() {
        return aptidaopopulacao;
    }

    public void setAptidaopopulacao(double[] aptidaopopulacao) {
        this.aptidaopopulacao = aptidaopopulacao;
    }

    public ArrayList getArestasgpt() {
        return arestasgpt;
    }

    public void setArestasgpt(ArrayList arestasgpt) {
        this.arestasgpt = arestasgpt;
    }

    public String[] getPrecedenciatarefas() {
        return precedenciatarefas;
    }

    public void setPrecedenciatarefas(String[] precedenciatarefas) {
        this.precedenciatarefas = precedenciatarefas;
    }

    public int getNumarestasgpt() {
        return numarestasgpt;
    }

    public void setNumarestasgpt(int numarestasgpt) {
        this.numarestasgpt = numarestasgpt;
    }

    public double[] getSalarioempregados() {
        return salarioempregados;
    }

    public void setSalarioempregados(double[] salarioempregados) {
        this.salarioempregados = salarioempregados;
    }

    public String[] getHabempregados() {
        return habempregados;
    }

    public void setHabempregados(String[] habempregados) {
        this.habempregados = habempregados;
    }

    public int[] getNumhabempregados() {
        return numhabempregados;
    }

    public void setNumhabempregados(int[] numhabempregados) {
        this.numhabempregados = numhabempregados;
    }

    public String[] getHabtarefas() {
        return habtarefas;
    }

    public void setHabtarefas(String[] habtarefas) {
        this.habtarefas = habtarefas;
    }

    public int[] getNumhabtarefas() {
        return numhabtarefas;
    }

    public void setNumhabtarefas(int[] numhabtarefas) {
        this.numhabtarefas = numhabtarefas;
    }

    public double[] getCustotarefas() {
        return custotarefas;
    }

    public void setCustotarefas(double[] custotarefas) {
        this.custotarefas = custotarefas;
    }
    
    public String getNomearqinstancia() {
        return nomearqinstancia;
    }

    public void setNomearqinstancia(String nomearqinstancia) {
        this.nomearqinstancia = nomearqinstancia;
    }

    public ArrayList getPopulacao() {
        return populacao;
    }

    public void setPopulacao(ArrayList populacao) {
        this.populacao = populacao;
    }
    
    public int getNumbitsdedicacao() {
        return numbitsdedicacao;
    }
    
    public void setNumbitsdedicacao(int numbitsdedicacao) {
        this.numbitsdedicacao = numbitsdedicacao;
    }
    
    public int getNumindividuos() {
        return numindividuos;
    }

    public void setNumindividuos(int numindividuos) {
        this.numindividuos = numindividuos;
    }

    public int getNumhabilidades() {
        return numhabilidades;
    }

    public void setNumhabilidades(int numhabilidades) {
        this.numhabilidades = numhabilidades;
    }

    public int getNumempregados() {
        return numempregados;
    }

    public void setNumempregados(int numempregados) {
        this.numempregados = numempregados;
    }

    public int getNumtarefas() {
        return numtarefas;
    }

    public void setNumtarefas(int numtarefas) {
        this.numtarefas = numtarefas;
    }
    
    public String getInstancia() {
        return instancia;
    }

    public void setInstancia(String instancia) {
        this.instancia = instancia;
    }

    private String lerArqInstancia(String nomearq){
        /**
         * Lê arquivo de instancia gerado por GeradorInstancias.java e retorna
         * uma lista instancia onde cada elemento é uma linha do arquivo de
         * instância.
         */
        
        ArrayList instlist = new ArrayList();
        String inststring;
        
        try {
            BufferedReader in = new BufferedReader(new FileReader(nomearq));
            
            while (in.ready()) {
                instlist.add(in.readLine());
            }
            
            in.close();
            
        } catch (Exception e) {
            System.err.printf("\nErro: %s\n", e);
        }
        
        Collections.sort(instlist);
        
        inststring = instlist.toString();
        
        return inststring;
    }
    
    private int lerNumTarefas(){
        /**
         * Busca qual o número de tarefas presentes na instância reprensentada 
         * em uma lista instancia.
         */
        
        int numtar;
        int i1,i2;
        
        i1 = this.instancia.indexOf(" task.number=", 0);
        i2 = this.instancia.indexOf("]",i1);
        
        numtar = Integer.parseInt(this.instancia.substring(i1 + 13, i2));
        
        return numtar;
    }
    
    private int lerNumEmpregados(){
        /**
         * Busca qual o número de empregados presentes na instância reprensentada
         * em uma lista instancia.
         */
        
        int numemp;
        int i1,i2;
        
        i1 = this.instancia.indexOf(" employee.number=", 0);
        i2 = this.instancia.indexOf(", ",i1);
        
        numemp = Integer.parseInt(this.instancia.substring(i1 + 17, i2));
        
        return numemp;
    }
    
    private int lerNumHabilidades(){
        /**
         * Busca qual o número de abilidades presentes na instância reprensentada
         * em uma lista instancia.
         */
        
        int numhab;
        int i1,i2;
        
        i1 = this.instancia.indexOf(" skill.number=", 0);
        i2 = this.instancia.indexOf(", ",i1);
        
        numhab = Integer.parseInt(this.instancia.substring(i1 + 14, i2));
        
        return numhab;
    }
    
    private double[] lerCustoTarefas(){
        /**
         * Busca o custo das tarefas da instância reprensentada em uma lista
         * instancia.
         */
        
        double[] custtar = new double[this.numtarefas];
        double custo;
        int i1,i2,j=0;
        
        while (j < this.numtarefas){
            
            i1 = this.instancia.indexOf(" task.".concat((Integer.toString(j)).concat(".cost=")), 0);
            i2 = this.instancia.indexOf(", ",i1);
            
            custo = Double.parseDouble(this.instancia.substring(i1 + 12 + Integer.toString(j).length(), i2));
            if (custo<0){
                custtar[j] =-1*(Double.parseDouble(this.instancia.substring(i1 + 12 + Integer.toString(j).length(), i2)));
            }else{
                custtar[j] =Double.parseDouble(this.instancia.substring(i1 + 12 + Integer.toString(j).length(), i2));
            }
            
            
            j++;
        }
        
        return custtar;
    }
    
    private int[] lerNumHabTarefas(){
        /**
         * Busca quantas habilidades cada tarefa da instância reprensentada em 
         * uma lista instancia possui.
         */
        
        int[] numhabtar = new int[this.numtarefas];
        int i1,i2,j=0;
        
        while (j < this.numtarefas){
            
            i1 = this.instancia.indexOf(" task.".concat((Integer.toString(j)).concat(".skill.number=")), 0);
            i2 = this.instancia.indexOf(", ",i1);
            
            numhabtar[j] = Integer.parseInt(this.instancia.substring(i1 + 20 + Integer.toString(j).length(), i2));
            
            j++;
        }
        return numhabtar;
    }
    
    private String[] lerHabTarefas (){
        /**
         * Busca quais habilidades cada tarefa da instância reprensentada em uma
         * lista instancia possui.
         */
        
        String[] habtar = new String[this.numtarefas];
        int i1,i2,j,k;
        String hab;
        
        k=0;
        while (k < this.numtarefas){
            hab = "";
            
            j = 0;
            while (j < this.numhabtarefas[k]){
                
                i1 = this.instancia.indexOf(" task.".concat(Integer.toString(k)).concat(".skill.").concat(Integer.toString(j)).concat("="), 0);
                i2 = this.instancia.indexOf(", ",i1);
                
                hab = hab.concat(this.instancia.substring(i1 + 14 + Integer.toString(k).length() + Integer.toString(j).length(), i2)).concat(" ");
                
                j++;
            }
            habtar[k] = hab.substring(0,hab.length());
            k++;
        }
        
        return habtar;
    }
    
    private double[] lerSalarioEmpregados(){
        /**
         * Busca o valor do salário de cada empregado da instância representada
         * em uma lista instancia.
         */
        
        double[] saremp = new double[this.numempregados];
        int i1,i2,j=0;
        
        while (j < this.numempregados){
            
            i1 = this.instancia.indexOf(" employee.".concat(Integer.toString(j)).concat(".salary="), 0);
            i2 = this.instancia.indexOf(", ",i1);
            
            saremp[j] = Double.parseDouble(this.instancia.substring(i1 + 18 + Integer.toString(j).length(), i2));
            
            j++;
        }
        
        return saremp;
    }
    
    private int[] lerNumHabEmpregados(){
        /**
         * Busca o número de habilidades que cada empregado a instância representada
         * por uma lista instancia possui.
         */
        
        int[] numhabemp = new int[this.numempregados];
        int i1,i2,j=0;
        
        while (j < this.numempregados){
            
            i1 = this.instancia.indexOf(" employee.".concat(Integer.toString(j)).concat(".skill.number="), 0);
            i2 = this.instancia.indexOf(", ",i1);
            
            numhabemp[j] = Integer.parseInt(this.instancia.substring(i1 + 24 + Integer.toString(j).length(), i2));
            
            j++;
        }
        return numhabemp;
    }
    
    private String[] lerHabEmpregados (){
        /**
         * Busca quais habilidades cada empregado da instância representada em
         * uma lista instancia possui.
         */
        
        String[] habemp = new String[this.numempregados];
        int i1,i2,j,k;
        String hab;
        
        k=0;
        while (k < this.numempregados){
            hab = "";
            
            j = 0;
            while (j < this.numhabempregados[k]){
                
                i1 = this.instancia.indexOf(" employee.".concat(Integer.toString(k)).concat(".skill.").concat(Integer.toString(j)).concat("="), 0);
                i2 = this.instancia.indexOf(", ",i1);
                
                hab = hab.concat(this.instancia.substring(i1 + 18 + Integer.toString(k).length() + Integer.toString(j).length(), i2)).concat(" ");
                
                j++;
            }
            habemp[k] = hab.substring(0,hab.length());
            k++;
        }
        
        return habemp;
    }
    
    private int lerNumArestasGPT(){
        /**
         * Busca quantas arestas o Grafo de Precedência de Tarefas presente na
         * instância repreentada em uma lista instancia possui.
         */
        
        int numare;
        int i1,i2;
        
        i1 = this.instancia.indexOf(" graph.arc.number=", 0);
        i2 = this.instancia.indexOf(", ",i1);
        
        numare = Integer.parseInt(this.instancia.substring(i1 + 18, i2));
        
        return numare;
    }
    
    private ArrayList lerArestasGPT(){
        /**
         * Busca a consiguração das arestas do Grafo de Precedência de Tarefas
         * presente na instância representada em uma lista instancia.
         */
        
        ArrayList arestas = new ArrayList();
        int i1,i2,j=0;
        
        while (j < this.numarestasgpt){
            
            i1 = this.instancia.indexOf(" graph.arc.".concat(Integer.toString(j)).concat("="), 0);
            i2 = this.instancia.indexOf(", ",i1);
            
            arestas.add(this.instancia.substring(i1 + 12 + Integer.toString(j).length(), i2));
            
            j++;
        }
        Collections.sort(arestas);
        
        return arestas;
    }
    
    private String[] lerPrecedenciaTarefas(){
        /**
         * Define a precedência das tarefas presentes na instância representada
         * em uma lista instancia usando o GPT dessa instância.
         */
        
        String[] prectarefas = new String[this.numtarefas];
        int i=0,j,itar;
        String str;
        
        while (i<this.arestasgpt.size()){
            
            str = this.arestasgpt.get(i).toString();
            j = str.lastIndexOf(" ");
            itar = Integer.parseInt(str.substring(j+1,str.length()));
            
            if (prectarefas[itar]==null){
                prectarefas[itar] = str.substring(0,j);
            }else{
                prectarefas[itar] = prectarefas[itar].concat(" ").concat(str.substring(0,j));
            }
            
            i++;
        }
        
        return prectarefas;
    }
    
    public void imprimirInstancia(){
        /**
         *  Procedimento de teste que imprime na tela o arquivo de instância.
         */
        int i=0;
        System.out.printf("\nInstancia:\n\n");
        
        System.out.printf("%s\n", this.instancia);
        i++;
    }
    
    public void imprimirInfoInstancia(){
        /**
         * Procedimento de teste que imprime na tela as informações gerais da instância, 
         * coletadas através da leitura do arquivo de instância.
         */
        System.out.printf("\nInfo Instancia:\n\n");
        System.out.printf("Numero de Tarefas: %s\n", this.numtarefas);
        System.out.printf("Numero de Empregados: %s\n", this.numempregados);
        System.out.printf("Numero de Habilidades: %s\n", this.numhabilidades);
        System.out.printf("Numero de Arestas do GPT: %d\n", this.numarestasgpt);
    }
    
    public void imprimirInfoTarefas(){
        /**
         * Procedimento de teste que imprime na tela as informações relacionadas 
         * as tarefas presentes na instância, coletadas através da leitura do 
         * arquivo de instância.
         */
        System.out.printf("\nInfo Tarefas: \n\n");
        for(int i=0;i<this.numtarefas;i++){
            System.out.printf("Tarefa %d:\n", i);
            System.out.printf("\tCusto: %f\n", this.custotarefas[i]);
            System.out.printf("\tNumero de Habilidades: %d\n", this.numhabtarefas[i]);
            System.out.printf("\tHabilidades: %s\n", this.habtarefas[i]);
        }
    }
    
    public void imprimirInfoEmpregados(){
        /**
         * Procedimento de teste queImprime na tela as informações relacionadas 
         * aos empregados presentes na instância, coletadas através da leitura 
         * do arquivo de instância.
         */
        System.out.printf("\nInfo Empregados: \n\n");
        for(int i=0;i<this.numempregados;i++){
            System.out.printf("Empregado %d:\n", i);
            System.out.printf("\tSalario: %f\n", this.salarioempregados[i]);
            System.out.printf("\tNumero de Habilidades: %d\n", this.numhabempregados[i]);
            System.out.printf("\tHabilidades: %s\n", this.habempregados[i]);
        }
    }
    
    public void imprimirArestasGPT(){
        /**
         * Procedimento de teste que imprime na tela a configuração das arestas 
         * do GPT da intância.
         */
        int i=0;
        System.out.printf("\nArestas:\n\n");
        while(i<this.arestasgpt.size()){
            System.out.printf("Aresta %d: %s\n",i, this.arestasgpt.get(i));
            i++;
        }
    }
    
    public void imprimirPrecedenciaTarefas(){
        /**
         * Procedimento de teste que imprime na tela a precedência das tarefas 
         * presentes na instância, definida pelo GPT presente nessa instância.
         */
        int i=0;
        System.out.printf("\nPrecedencia das Tarefas:\n\n");
        while(i<this.precedenciatarefas.length){
            System.out.printf("\tTarefa %d: %s\n",i, this.precedenciatarefas[i]);
            i++;
        }
    }
   
    private double getElementoX(String indv, int itarefa, int iempregado, int numtar, int numbitsded){
        /**
         * Busca um elemento na matriz de solução representada por um indíviduo da 
         * população. O elemento é convertido de número binário para número real e 
         * só então retornado.
         */
        String s="";
        double x,f;
        int valormax;
        String esf;
        
        //System.fileoutappend.printf("getElementoX: \n\t");
        esf = indv.substring((iempregado*numtar+itarefa)*numbitsded,(iempregado*numtar+itarefa)*numbitsded+numbitsded);
        //System.fileoutappend.printf("esf: %s1\n\t", esf);
        
        for (int i=0;i<esf.length();i++){
            s = s.concat("1");
        }
        //System.fileoutappend.printf("s1 : %s1\n\t", s1);
        
        valormax = Integer.parseInt(s,2);
        //System.fileoutappend.printf("valormax: %d\n\t", valormax);
        f = Integer.parseInt(esf,2);
        //System.fileoutappend.printf("f: %f\n\t",f);
        
        x = f/valormax;
        //System.fileoutappend.printf("x: %f\n", x);
        
        return x;
    }
    
    public String getElementoXBinario(String indv, int itarefa, int iempregado, int numtar, int numbitsded){
        /**
         * Busca um elemento na matriz de solução representada por um indíviduo da 
         * população.O elemento não é convertido, sendo retornado como número binário.
         */
        
        String x;
        
        x = indv.substring((iempregado*numtar+itarefa)*numbitsded,(iempregado*numtar+itarefa)*numbitsded+numbitsded);
        
        return x;
    }
    
    public void imprimirMatrizX(){
        /**
         * Procedimento de teste que imprime na tela todos os indivíduos da 
         * população, cada um representado como uma matriz de solução de números reais.
         */
        int i,j,z;
        double x;
        
        System.out.printf("\nMatrizes de solução da população:\n\n");
        
        z=0;
        while(z<this.populacao.size()){
            
            System.out.printf("\tMatriz de solução do indivíduo %d: \n\t", z);
            
            i=0;
            while (i<this.numempregados){

                j=0;
                while (j<this.numtarefas){
                    x = getElementoX(String.valueOf(this.populacao.get(z)),j,i,this.numtarefas,this.numbitsdedicacao);
                    System.out.printf("%f ",x);

                    j++;
                }
                System.out.printf("\n\t");

                i++;
            }
            System.out.printf("\n");
            
            z++;
        }
        
    }
    
    public void imprimirMatrizXBinario(){
        /**
         * Procedimento de teste que imprime todos os indivíduos da população, 
         * cada um representado como uma matriz de solução de números binários.
         */
        int i,j,z;
        String x;
        
        System.out.printf("\nMatrizes de solução da população:\n\n");
        
        z=0;
        while(z<this.populacao.size()){
            
            System.out.printf("\tMatriz de solução binária indv %d: \n\t", z);
            
            i=0;
            while (i<this.numempregados){
                j=0;
                while (j<this.numtarefas){
                    x = getElementoXBinario(String.valueOf(this.populacao.get(z)),j,i,this.numtarefas,this.numbitsdedicacao);
                    System.out.printf("%s ",x);

                    j++;
                }
                System.out.printf("\n\t");
                i++;
            }
            System.out.printf("\n");
            
            z++;
        }
    }
    
    private double calcEsfTarefa(int itarefa, String indv, int numemp, int numtar, int numbitsded){
        /**
         * Calcula a dedicação total dos empregados para uma certa tarefa. Para isso,
         * soma os elementos da coluna da matriz de solução que equivale a essa tarefa.
         */
        double esftar=0;
        int iemp=0;
        
        while (iemp < numemp){
            esftar = esftar + getElementoX(indv,itarefa,iemp,numtar,numbitsded);
            iemp++;
        }
        
        return esftar;
    }
    
    public void imprimirEsfTarefas(){
        /**
         * Procedimento de teste que imprime a dedicação total de cada tarefa da 
         * matriz de solução para certo indivíduo.
         */
        
        int i=0;
        System.out.printf("\nEsforço das Tarefas:\n\n");
        while(i<this.numtarefas){
            System.out.printf("\tEsforço Tarefa %d: %f\n", i, calcEsfTarefa(i,String.valueOf(this.populacao.get(0)),this.numempregados,this.numtarefas,this.numbitsdedicacao));
            i++;
        }
    }
    
    private double calcDuracaoTarefa(int itarefa, String indv, int numemp, int numtar, int numbitsded){
        /**
         * Calcula a duração de certa tarefa.
         */
        double durtar,esftar;
        
        esftar = calcEsfTarefa(itarefa, indv, numemp, numtar, numbitsded);
        
        if(esftar==0){
            durtar = 0;
            return durtar;
        }
        
        durtar = this.custotarefas[itarefa]/esftar;
        
        return durtar;
    }
    
    public void imprimirDurTarefas(){
        /**
         * Procedimento de teste que imprime a duração das tarefas para certa 
         * matriz de solução do indivíduo dado.
         */
        int i=0;
        System.out.printf("\nDuração das Tarefas:\n\n");
        while(i<this.numtarefas){
            System.out.printf("\tDuração Tarefa %d: %f\n", i, calcDuracaoTarefa(i,String.valueOf(this.populacao.get(0)),this.numempregados,this.numtarefas,this.numbitsdedicacao));
            i++;
        }
    }
    
    private Periodo[] calcInicioFimTarefas(String indv, int numtar, int numemp, int numbitsded){
        /**
         * Calcula o início e fim das tarefas para certa matriz de solução do indivíduo dado.
         */
        Periodo[] periodostarefas = new Periodo[numtar];
        int i,j,imaistardia,itarefa;
        double datainicio,datafim,fim1,fim2;
        String[] tarefas;
        
        i=0;
        while (i<numtar){
            
            if (this.precedenciatarefas[i]==null){
                datainicio = 0;
                datafim = calcDuracaoTarefa(i,indv,numemp,numtar,numbitsded);
                
                periodostarefas[i] = new Periodo(datainicio,datafim);
                
            }else{
                tarefas = this.precedenciatarefas[i].split(" ");
                
                imaistardia = Integer.parseInt(tarefas[0]);
                
                if (tarefas.length==1){
                    datainicio = periodostarefas[imaistardia].getFim();
                    datafim = datainicio + calcDuracaoTarefa(i,indv,numemp,numtar,numbitsded);
                    
                    periodostarefas[i] = new Periodo(datainicio,datafim);
                    
                }else{
                    j=1;
                    while (j<tarefas.length){
                        fim1 = periodostarefas[imaistardia].getFim();
                        itarefa = Integer.parseInt(tarefas[j]);
                        fim2 = periodostarefas[itarefa].getFim();
                        
                        if (fim2>fim1){
                            imaistardia = itarefa;
                        }
                        j++;
                    }
                    datainicio = periodostarefas[imaistardia].getFim();
                    datafim = datainicio + calcDuracaoTarefa(i,indv,numemp,numtar,numbitsded);
                    
                    periodostarefas[i] = new Periodo(datainicio,datafim);
                }
            }
            i++;
        }
        
        return periodostarefas;
    }
    
    public void imprimirInicioFimTarefas(){
        /**
         * Procedimento de teste que imprime o início e fim das tarefas em forma 
         * de um diagrama Gantt para certa matriz de solução do indivíduo dado.
         */
        int i=0;
        Periodo[] periodo;
        
        periodo = calcInicioFimTarefas(String.valueOf(this.populacao.get(0)),this.numtarefas,this.numempregados,this.numbitsdedicacao);
        
        System.out.printf("\nInicio e Fim das Tarefas:\n\n");
        while(i<this.numtarefas){
            System.out.printf("\tTarefa %d Inicio : %f\n\t\t Fim: %f\n", i, periodo[i].getInicio(),periodo[i].getFim());
            i++;
        }
        
        final DiagramaGantt demo = new DiagramaGantt("Diagrama Gantt do Projeto",periodo);
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);
        
    }
    
    private double calcDuracaoProjeto(String indv, int numtar, int numemp, int numbitsded){
        /**
         * Calcula a duração total do projeto para certa matriz de solução do indivíduo dado.
         */
        int i;
        double ifim,maiorfim;
        Periodo[] periodo;
        
        periodo = calcInicioFimTarefas(indv,numtar,numemp,numbitsded);
        
        maiorfim=0;
        i=0;
        while(i<periodo.length){
            ifim = periodo[i].getFim();
            if(ifim>maiorfim){
                maiorfim = ifim;
            }
            i++;
        }
        
        if(Double.isNaN(maiorfim)||Double.isInfinite(maiorfim)){
            System.out.printf("calcDuracaoProjeto:\n\t"
                    + "maiorfim: %f\n",maiorfim);
        }
        
        return maiorfim;
    }
    
    public void imprimirDuracaoProjeto(){
        /**
         * Procedimento de teste que imprime a duração total do projeto.
         */
        double durprojeto;
        
        durprojeto = calcDuracaoProjeto(String.valueOf(this.populacao.get(0)),this.numtarefas,this.numempregados,this.numbitsdedicacao);
        
        System.out.printf("Duracao do Projeto: %f Meses\n",durprojeto);
    }
    
    private double calcCustoProjeto(String indv, int numtar, int numemp, int numbitsded){
        /**
         * Calcula o custo total do projeto,ou seja o gasto total com salários dos
         * empregados, para certa matriz de solução do indivíduo dado.
         */
        int i,j;
        double custoprojeto,salario,durtar,esforco;
        
        custoprojeto = 0;
        
        i=0;
        while (i<numemp){
            
            salario = this.salarioempregados[i];
            
            j=0;
            while (j<numtar){
                esforco = getElementoX(indv,j,i,numtar,numbitsded);
                durtar = calcDuracaoTarefa(j,indv,numemp,numtar,numbitsded);
                
                custoprojeto = custoprojeto + (salario*esforco*durtar);
                
                j++;
            }
            i++;
        }
        
        return custoprojeto;
    }
    
    public void imprimirCustoProjeto(){
        /**
         * Procedimento de teste que imprime o custo total do projeto.
         */
        
        double durprojeto;
        
        durprojeto = calcCustoProjeto(String.valueOf(this.populacao.get(0)),this.numtarefas,this.numempregados,this.numbitsdedicacao);
        
        System.out.printf("Custo do Projeto: %f Dinheiros\n",durprojeto);
    }
    
    private ArrayList defTarefasConcomitantes(String indv, int numtar, int numemp, int numbitsded){
        /**
         * Verifica quais tarefas são realizadas no mesmo momento para certa matriz 
         * de solução do indivíduo dado.
         */
        int i,j;
        ArrayList momentos = new ArrayList();
        Periodo[] periodostarefas = calcInicioFimTarefas(indv,numtar,numemp,numbitsded);
        double inicio,iniciomomento,fim,fimmomento,fimprojeto;
        Momento m;
        String tarefas;
        
        //System.fileoutappend.printf("\nInicio de defTarefasConcomitantes!\n\n");
        
        i=0;
        fimmomento = 0;
        fimprojeto = calcDuracaoProjeto(indv,numtar,numemp,numbitsded);
        while(true){
            //System.fileoutappend.printf("Iteração Externa %d:\n",i);
            iniciomomento = fimmomento;
            //System.fileoutappend.printf("\tiniciomomento = %f\n",iniciomomento);
            fimmomento = fimprojeto;
            //System.fileoutappend.printf("\tfimmomento = %f\n",fimmomento);
            tarefas = "";
            //System.fileoutappend.printf("\ttarefas = %s1\n",tarefas);
            
            j=0;
            while(j<periodostarefas.length){
                //System.fileoutappend.printf("\n\tIteração Interna %d:\n", j);
                
                inicio = periodostarefas[j].getInicio();
                //System.fileoutappend.printf("\t\tinicio = %f\n",inicio);
                fim = periodostarefas[j].getFim();
                //System.fileoutappend.printf("\t\tfim = %s1\n",fim);
                
                if (inicio==iniciomomento){
                    //System.fileoutappend.printf("\t\tinicio==iniciomomento -> %f==%f\n",inicio,iniciomomento);
                    tarefas = tarefas.concat(Integer.toString(j)).concat(" ");
                    //System.fileoutappend.printf("\t\ttarefas = %s1\n",tarefas);
                    if ((fim<fimmomento)&&(fim!=iniciomomento)){
                        //System.fileoutappend.printf("\t\tfim<fimmomento -> %f<%f\n",fim,fimmomento);
                        fimmomento=fim;
                        //System.fileoutappend.printf("\t\tfimmomento = %f\n",fimmomento);
                    }
                }else if((inicio<iniciomomento)&&(fim>iniciomomento)){
                    //System.fileoutappend.printf("\t\t(inicio<iniciomomento)&&(fim>iniciomomento) -> (%f<%f)&&(%f>%f)\n",inicio,iniciomomento,fim,iniciomomento);
                    tarefas = tarefas.concat(Integer.toString(j)).concat(" ");
                    //System.fileoutappend.printf("\t\ttarefas = %s1\n",tarefas);
                    if ((fim<fimmomento)&&(fim!=iniciomomento)){
                        //System.fileoutappend.printf("\t\tfim<fimmomento -> %f<%f\n",fim,fimmomento);
                        fimmomento=fim;
                        //System.fileoutappend.printf("\t\tfimmomento = %f\n",fimmomento);
                    }
                }else{
                    //System.fileoutappend.printf("\t\tTarefa não esta no momento.\n");
                }
                
                j++;
            }
            //System.fileoutappend.printf("\n\tFim da Iteração Interna!\n\n");
            
            //System.fileoutappend.printf("\tiniciomomento = %f\n",iniciomomento);
            //System.fileoutappend.printf("\tfimmomento = %f\n",fimmomento);
            //System.fileoutappend.printf("\ttarefas = %s1\n",tarefas);
            
            m = new Momento(iniciomomento,fimmomento,tarefas);
            
            momentos.add(m);
            
            if (fimmomento >= fimprojeto){
                //System.fileoutappend.printf("\tfimmomento>=fimprojeto -> %f==%f\n",fimmomento,fimprojeto);
                //System.fileoutappend.printf("\nFim de defTarefasConcomitantes!\n\n");
                break;
            }
            
            i++;
        }
        
        return momentos;
    }
    
    public void imprimirTarefasConcomitantes(){
        /**
         * Procedimento de teste que imprime quais tarefas são realizadas no mesmo momento.
         */
        int i;
        ArrayList momentos;
        Momento m;
        
        momentos = defTarefasConcomitantes(String.valueOf(this.populacao.get(0)),this.numtarefas,this.numempregados,this.numbitsdedicacao);
        
        System.out.printf("\nMomentos: \n\n");
        i=0;
        while(i<momentos.size()){
            m = (Momento) momentos.get(i);
            System.out.printf("\tMomento %d: \n\tInicio: %f Fim: %f Tarefas: %s\n",i,m.getInicio(),m.getFim(),m.getTarefasconcomitantes());
            i++;
        }
    }
    
    private double calcTrabExtraEmpregado(String indv, int iempregado, int numtar, int numemp, int numbitsded){
        /**
         * Calcula o trabalho extra realizado por cada empregado para certa matriz 
         * de solução do indivíduo dado.
         */
        
        int i,j,tarefa;
        double duracao,trabalho,trabextremp;
        ArrayList momentos;
        String[] tarefas;
        Momento m;
        
        momentos = defTarefasConcomitantes(indv, numtar, numemp, numbitsded);
        
        i=0;
        trabextremp = 0;
        while (i<momentos.size()){
            
            m = (Momento) momentos.get(i);
            tarefas = m.getTarefasconcomitantes().split(" ");
            duracao = m.getDuracao();
            
            j=0;
            trabalho = 0;
            while(j<tarefas.length){
                
                tarefa = Integer.parseInt(tarefas[j]);
                
                trabalho = trabalho + getElementoX(indv,tarefa,iempregado,numtar,numbitsded);
                
                j++;
            }
            
            if (trabalho>1){
                trabextremp = trabextremp + (trabalho-1) * duracao;
            }
            
            i++;
        }
        
        return trabextremp;
    }
    
    public void imprimirTrabExtraEmpregado(){
        /**
         * Procedimento de teste que imprime o trabalho extra realizado por um empregado.
         */
        
        double trabextraemp;
        
        trabextraemp = calcTrabExtraEmpregado(String.valueOf(this.populacao.get(0)),0,this.numtarefas,this.numempregados,this.numbitsdedicacao);
        
        System.out.printf("\nTrabalho Extra do Empregado 0: %f \n\n",trabextraemp);
        
    }
    
    private double calcTrabExtraProjeto(String indv, int numtar, int numemp, int numbitsded){
        /**
         * Calcula o trabalho extra realiado por todos os empregados no projeto.
         */
        
        int i;
        double trabextraproj;
        
        i=0;
        trabextraproj = 0;
        while(i<numemp){
            
            trabextraproj = trabextraproj + calcTrabExtraEmpregado(indv, i, numtar, numemp, numbitsded);
            
            i++;
        }
        
        return trabextraproj;
    }
    
    public void imprimirTrabExtraProjeto(){
        /**
         * Procedimento de teste que imprime o trabalho extra realiado por todos 
         * os empregados no projeto.
         */
        double trabextraproj;
        
        trabextraproj = calcTrabExtraProjeto(String.valueOf(this.populacao.get(0)),this.numtarefas,this.numempregados,this.numbitsdedicacao);
        
        System.out.printf("\nTrabalho Extra do Projeto: %f\n\n",trabextraproj);
    }
    
    private int verificarQuantasTarNaoRealizadas(String indv, int numtar, int numemp, int numbitsded){
        /**
         * Verifica se todas as tarefas do projeto são realizadas por pelo menos um
         * funcionário. Retorna o número total de tarefas não realizadas.
         */
        
        int itar, numtarnaorealizadas=0;
        double somacoluna;
        
        itar = 0;
        while(itar<numtar){
            
            somacoluna = calcEsfTarefa(itar,indv,numemp,numtar,numbitsded);
            
            if(somacoluna==0){
                numtarnaorealizadas++;
            }
            
            itar++;
        }
        
        return numtarnaorealizadas;
    }
    
    public void imprimirVerificarQuantasTarNaoRealizadas(){
        /*
         * Procedimento de teste que imprime o resultado de verificarQuantasTarNaoRealizadas()
         * para todos os indivíduos da população.
         */
        
        int numtarnaorealizadas;
        int i=0;
        while (i<this.populacao.size()){
            System.out.printf("\nIndv %d...\n",i);
            
            numtarnaorealizadas = verificarQuantasTarNaoRealizadas(String.valueOf(this.populacao.get(i)),this.numtarefas,this.numempregados,this.numbitsdedicacao);
            System.out.printf("\tNúmero de tarefas não realizadas: %d\n", numtarnaorealizadas);
            
            i++;
        }
    }
    
    private int verificarQuantasHabAindaNecParaCompProjeto(String indv, int numtar, int numemp, int numbitsded){
        /**
         * Para cada tarefa de uma dada solução, verifica se as habilidades necessárias da tarefa 
         * está contida na união das habilidades dos empregados que realizam essa tarefa. Faz isso
         * para todas as tarefas da instância e retorna o número de habilidades ainda necessárias
         * para que as tarefas possam ser completadas.
         */
        int iemp,itar,j,iaux,habaindanecessarias;
        double x;
        String habemp, str;
        String[] habtar;
        
        habaindanecessarias=0;
        itar=0;
        while(itar<numtar){
            
            iemp=0;
            habemp = " ";
            while(iemp<numemp){
                
                x = getElementoX(indv,itar,iemp,numtar,numbitsded);
                
                if(x>0){
                    habemp = habemp.concat(this.habempregados[iemp]);
                }
                
                iemp++;
            }
            
            habtar = this.habtarefas[itar].split(" ");
            
            j=0;
            while(j<habtar.length){
                
                str = " ".concat(habtar[j]).concat(" ");
                iaux = habemp.indexOf(str);
                
                if (iaux<0){
                    habaindanecessarias++;
                }
                
                j++;
            }
            
            itar++;
        }
        
        return habaindanecessarias;
    }
    
    public void imprimirVerificarQuantasHabAindaNecParaCompProjeto(){
        /*
         * Procedimento de teste que imprime quantas habilidades ainda são necesárias
         * para completar o projeto para cada indivíduo da população.
         */
        int habaindanecessarias;
        int i=0;
        while (i<this.populacao.size()){
            System.out.printf("\nIndv %d...\n",i);
            
            habaindanecessarias = verificarQuantasHabAindaNecParaCompProjeto(String.valueOf(this.populacao.get(i)),this.numtarefas,this.numempregados,this.numbitsdedicacao);
            System.out.printf("\tNúmero de tarefas que necessitam habilidades: %d\n", habaindanecessarias);
            
            i++;
        }
    }
    
    private boolean calcFactivelProjeto(String indv,int numtar, int numemp, int numbitsded){
        /*
         * Método que verifica se um projeto representado por um indivíduo da população
         * é factível.
         */
        
        double trabextra;
        int tnr, habnec;
        
        tnr = verificarQuantasTarNaoRealizadas(indv, numtar, numemp, numbitsded);
        habnec = verificarQuantasHabAindaNecParaCompProjeto(indv, numtar, numemp, numbitsded);
        trabextra = calcTrabExtraProjeto(indv, numtar, numemp, numbitsded);
        
        if (tnr>0||habnec>0||trabextra>0){
            //Se não-factível
            return false;
        }else{
            //Se factível
            return true;
        }
        
    }
    
    private double funcaoAptidao(String indv,int numtar, int numemp, int numbitsded){
        /*
         * Calcula a função de aptidão para um indivíduo da população.
         * A função de aptidão tem a forma:
         *      
         *      f(x) = 1/q se factível
         *      ou
         *      f(x) = 1/q+p se não-factível
         *      onde    
         *          q = pesocusto*custoprojeto+pesocuracao*duracaoprojeto
         *          p = pesopenal+pesotnr*tnr+pesohabnec*habnec+pesotrabextra*trabextra
         * 
         *      Importante! Pesos precisam ser setados na mesma ordem de magnitude.(ALBA e CHICANO, Software Project Management with GAs, pág 8)
         */
        
        double q,p;
        double aptidao,aptdivisor;
        double pesocusto=0.0000005,pesoduracao=0.045,pesopenal=100,pesotnr=1,pesohabnec=1,pesotrabextra=1;
        double custo,duracao,trabextra;
        int tnr, habnec;
        
        custo = calcCustoProjeto(indv, numtar, numemp, numbitsded);
        duracao = calcDuracaoProjeto(indv, numtar, numemp, numbitsded);
        
        q = pesocusto*custo + pesoduracao*duracao;
        
        if (calcFactivelProjeto(indv,numtar,numemp,numbitsded)){
            //Se factível
            aptdivisor = q;
        }else{
            //Se não-factível
            tnr = verificarQuantasTarNaoRealizadas(indv, numtar, numemp, numbitsded);
            habnec = verificarQuantasHabAindaNecParaCompProjeto(indv, numtar, numemp, numbitsded);
            trabextra = calcTrabExtraProjeto(indv, numtar, numemp, numbitsded);
            
            p = pesopenal + pesotnr*tnr + pesohabnec*habnec + pesotrabextra*trabextra;
            
            aptdivisor = q+p;
        }
        
        aptidao = 1/aptdivisor;
        
        /*
        System.fileoutappend.printf("Funcao Aptidao: \n\t"
                + "custo: %f\n\t"
                + "duracao: %f\n\t"
                + "tnr: %f\n\t"
                + "habnec: %f\n\t"
                + "trabextra: %f\n\t"
                ,custo,duracao,tnr,habnec,trabextra);
        
        System.fileoutappend.printf("q: %f\n\t"
                + "p: %f\n\t",q,p);
        
        System.fileoutappend.printf("aptdivisor: %f\n\t"
                + "aptidao: %f\n",aptdivisor,aptidao);
        */
        return aptidao;
    }
    
    private double[] calcDuracaoPopulacao (ArrayList pop, int numtar, int numemp, int numbitsded){
        /*
         * Calcula a duração do projeto para todos os indivíduos da população dada e 
         * retorna um array com os resultados
         */
        
        double[] durpop = new double[pop.size()];
        int i;
        
        i=0;
        while(i<pop.size()){
            durpop[i] = calcDuracaoProjeto(String.valueOf(pop.get(i)),numtar,numemp,numbitsded);
            i++;
        }
        
        return durpop;
    }
    
    private double[] calcCustoPopulacao (ArrayList pop, int numtar, int numemp, int numbitsded){
        /*
         * Calcula o custo do projeto para todos os indivíduos da população dada e 
         * retorna um array com os resultados
         */
        
        double[] custpop = new double[pop.size()];
        int i;
        
        i=0;
        while(i<pop.size()){
            custpop[i] = calcCustoProjeto(String.valueOf(pop.get(i)),numtar,numemp,numbitsded);
            i++;
        }
        
        return custpop;
    }
    
    private double[] calcAptidaoPopulacao(ArrayList pop, int numtar, int numemp, int numbitsded){
        /*
         * Calcula a Função de Aptidão de todos os indivíduos da população dada e 
         * retorna um array com os resultados
         */
        
        double[] aptpop = new double[pop.size()];
        int i;
        
        i=0;
        while(i<pop.size()){
            aptpop[i] = funcaoAptidao(String.valueOf(pop.get(i)),numtar,numemp,numbitsded);
            i++;
        }
        
        return aptpop;
    }
    
    public void imprimirAptidaoPopulacao(){
        /*
         * Procedimento de teste que imprime o resultado da Função de Aptidão para 
         * todos os indivíduos da população.
         */
        int i;
        
        System.out.printf("\nAptidão da População: \n");
        i=0;
        while(i<this.aptidaopopulacao.length){
            System.out.printf("\tAptidão do indivíduo %d: %f\n",i,this.aptidaopopulacao[i]);
            i++;
        }
    }
    
    private boolean[] calcFactivelPopulacao(ArrayList pop, int numtar, int numemp, int numbitsded){
        /*
         * Calcula a Função de Aptidão de todos os indivíduos da população dada e 
         * retorna um array com os resultados
         */
        
        boolean[] factpop = new boolean[pop.size()];
        int i;
        
        i=0;
        while(i<pop.size()){
            factpop[i] = calcFactivelProjeto(String.valueOf(pop.get(i)),numtar,numemp,numbitsded);
            
            i++;
        }
        
        return factpop;
    }
    
    private int[] calcRankingPopulacao(double[] aptpop){
        /*
         * Calcula um ranking para populacao dado um array aptpop que contém a 
         * aptidao de cada indivíduo e cada posição do array corresponde a posição
         * do indivíduo na população.
         * O ranking é uma lista de inteiros onde cada inteiro representa a posição
         * de um indivíduo na população e a lista vai do melhor indivíduo para o pior.
         */
        int[] ranking = new int[aptpop.length];
        int i,j,jmaiorapt;
        double maiorapt,apt;
        boolean[] processado = new boolean[aptpop.length];
        
        i=0;
        while(i<ranking.length){
            
            maiorapt=0;
            jmaiorapt=0;
            j=0;
            while(j<aptpop.length){
                apt = aptpop[j];
                if(apt>maiorapt&&processado[j]==false){
                    maiorapt = apt;
                    jmaiorapt = j;
                }
                j++;
            }
            
            ranking[i]= jmaiorapt;
            processado[jmaiorapt] = true;
            
            i++;
        }
        
        return ranking;
    }
    
    public void imprimirRankingPopulacao(){
        /*
         * Procedimento de teste que mostra o ranking da população atual.
         */
        System.out.printf("Ranking da população: \n\n");
        int i=0;
        while(i<this.rankingpopulacao.length){
            System.out.printf("\tPosição %d: indivíduo %d\n", i,this.rankingpopulacao[i]);
            i++;
        }
    }
    
    private ArrayList inicPopulacao(int numemp, int numtar, int numbitsded, int numindv){
        /**
         * Inicializa a população para inicio do algoritmo genético. Cada indivíduo
         * é uma matriz de números binários inicializada randomicamente. Cada elemento
         * Xij da matriz, representa o nível de dedicação do empregado i para a 
         * tarefa j.
         * Metade da população é gerada aleatóriamente e a outra metade é a inversão
         * dos bits da segunda, para gerar uma população com maior variedade.
         */
        
        ArrayList pop = new ArrayList();
        String indv;
        int randombit;
        int tamcrom = numemp*numtar*numbitsded;
        RandomGenerator rg = new RandomGenerator();
        
        for (int i=0;i<numindv/2;i++){
            indv="";
            for (int j=0;j<tamcrom;j++){
                randombit = rg.randint(2);
                indv = indv.concat(Integer.toString(randombit));
            }
            pop.add(indv);
        }
        
        for (int i=numindv/2;i<numindv;i++){
            indv = String.valueOf(pop.get(i-numindv/2));
            indv = indv.replaceAll("1", "x");
            indv = indv.replaceAll("0", "1");
            indv = indv.replaceAll("x", "0");
            pop.add(indv);
        }
        
        return pop;
    }

    public void imprimirPopulacao(){
        /**
         * Procedimento de teste que imprime a população atual do algoritmo genético.
         */
        int i=0;
        System.out.printf("\nPopulacao:\n\n");
        while(i<this.populacao.size()){
            System.out.printf("\tIndividuo %d: %s\n", i, this.populacao.get(i));
            i++;
        }
    }
    
    private String[] selecTorneio(int tamtorneio, ArrayList pop, int numtar, int numemp, int numbitsded){
        /*
         * Seleção por Torneio simples(sem probabilidade). Variável tamtorneio representa 
         * o tamanho do torneio desejado.
         */
        String[] selecionados = new String[2];
        int i,iaux,iindvmax;
        String[] individuos= new String[tamtorneio];
        double aptidao,aptidaomax;
        
        RandomGenerator rg = new RandomGenerator();
        
        i=0;
        while(i<tamtorneio){
            iaux = rg.randint(pop.size());
            individuos[i] = String.valueOf(pop.get(iaux));
            i++;
        }
        
        aptidaomax=0;
        iindvmax=0;
        i=0;
        while(i<tamtorneio){
            aptidao = funcaoAptidao(individuos[i],numtar,numemp,numbitsded);
            if(aptidao>aptidaomax){
                aptidaomax=aptidao;
                iindvmax=i;
            }
            i++;
        }
        
        selecionados[0] = individuos[iindvmax];
        
        i=0;
        while(i<tamtorneio){
            iaux = rg.randint(pop.size());
            individuos[i] = String.valueOf(pop.get(iaux));
            i++;
        }
        
        aptidaomax=0;
        iindvmax=0;
        i=0;
        while(i<tamtorneio){
            aptidao = funcaoAptidao(individuos[i],numtar,numemp,numbitsded);
            if(aptidao>aptidaomax){
                aptidaomax=aptidao;
                iindvmax=i;
            }
            i++;
        }
        
        selecionados[1] = individuos[iindvmax];
        
        return selecionados;
    }
    
    public void imprimirSelecTorneio(){
        /*
         * Procedimento de teste que imprime o resultado da Seleção por Torneio.
         */
        int i=0;
        String[] selecionados;
        System.out.printf("\nSelecionados:\n\n");
        selecionados = selecTorneio(2,this.populacao,this.numtarefas,this.numempregados,this.numbitsdedicacao);
        while(i<2){
            System.out.printf("\t%s\n", selecionados[i]);
            i++;
        }
    }
    
    private String[] singlePointCrossover2D(String pai1,String pai2, int numtar,int numemp, int numbitsded){
        /*
         * Crossover que escolhe randomicamente uma linha e uma coluna(os mesmos 
         * para ambos os pais) da matriz de solução dos dois pais e então troca 
         * os elementos do primeiro quadrante esquerdo e do quadrante inferior 
         * direito entre os pais.
         * 
         * Numeração dos quadrantes:
         * 
         *          Q1|Q2
         *          -----
         *          Q3|Q4
         * 
         * DUVIDA: Este crossover parece gerar 2 filhos diferentes. Preciso pesquisar
         * se devo usar ambos os filhos ou escolher somente 1.
         */
        
        String[] filhos = new String[2];
        String filho1,filho2;
        RandomGenerator rg = new RandomGenerator();
        int i,j,linha,coluna;
        
        //System.fileoutappend.printf("\nsinglePointCrossover2D\n\n");
        
        linha = rg.randint(numemp-1);
        coluna = rg.randint(numtar-1);
        //System.fileoutappend.printf("(linha,coluna)=(%d,%d)\n", linha,coluna);
        
        //Construindo primeiro filho.
        //System.fileoutappend.printf("Construindo primeiro filho: \n");
        filho1="";
        //System.fileoutappend.printf("filho1: %s\n", filho1);
        i=0;
        //System.fileoutappend.printf("Inserindo quadrantes 1 e 2: \n");
        //System.fileoutappend.printf("while(i<linha+1)\n");
        while(i<linha+1){
            //Inserindo quadrante 1(esquerdo superior) do pai 1 e quadrante 2(direito superior) do pai 2.
            //System.fileoutappend.printf("\ti: %d\n", i);
            j=0;
            //System.fileoutappend.printf("\twhile(j<coluna+1)\n");
            while(j<coluna+1){
                //System.fileoutappend.printf("\t\tj: %d\n", j);
                filho1 = filho1.concat(getElementoXBinario(pai1,j,i,numtar,numbitsded));
                //System.fileoutappend.printf("\t\tfilho1: %s\n",filho1);
                j++;
            }
            //System.fileoutappend.printf("\twhile(j<numtar)\n");
            while(j<numtar){
                //System.fileoutappend.printf("\t\tj: %d\n", j);
                filho1 = filho1.concat(getElementoXBinario(pai2,j,i,numtar,numbitsded));
                //System.fileoutappend.printf("\t\tfilho1: %s\n",filho1);
                j++;
            }
            i++;
        }
        //System.fileoutappend.printf("Inserindo quadrantes 3 e 4: \n");
        //System.fileoutappend.printf("while(i<numemp)\n");
        while(i<numemp){
            //Inserindo quadrante 3(inferior esquerdo) do pai 2 e quadrante 4 (inferior direito) do pai 1.
            //System.fileoutappend.printf("\ti: %d\n", i);
            j=0;
            //System.fileoutappend.printf("\twhile(j<coluna+1)\n");
            while(j<coluna+1){
                //System.fileoutappend.printf("\t\tj: %d\n", j);
                filho1 = filho1.concat(getElementoXBinario(pai2,j,i,numtar,numbitsded));
                //System.fileoutappend.printf("\t\tfilho1: %s\n",filho1);
                j++;
            }
            //System.fileoutappend.printf("\twhile(j<numtar)\n");
            while(j<numtar){
                //System.fileoutappend.printf("\t\tj: %d\n", j);
                filho1 = filho1.concat(getElementoXBinario(pai1,j,i,numtar,numbitsded));
                //System.fileoutappend.printf("\t\tfilho1: %s\n",filho1);
                j++;
            }
            i++;
        }
        
        //Construindo segundo filho.
        //System.fileoutappend.printf("Construindo segundo filho: \n");
        filho2="";
        //System.fileoutappend.printf("filho2: %s", filho2);
        i=0;
        //System.fileoutappend.printf("Inserindo quadrantes 1 e 2\n");
        //System.fileoutappend.printf("while(i<linha+1)\n");
        while(i<linha+1){
            //Inserindo quadrante 1(esquerdo superior) do pai 2 e quadrante 2(direito superior) do pai 1.
            //System.fileoutappend.printf("\ti: %d\n", i);
            j=0;
            //System.fileoutappend.printf("\twhile(j<coluna+1)\n");
            while(j<coluna+1){
                //System.fileoutappend.printf("\t\tj: %d\n", j);
                filho2 = filho2.concat(getElementoXBinario(pai2,j,i,numtar,numbitsded));
                //System.fileoutappend.printf("\t\tfilho2: %s\n",filho2);
                j++;
            }
            //System.fileoutappend.printf("\twhile(j<numtar)\n");
            while(j<numtar){
                //System.fileoutappend.printf("\t\tj: %d\n", j);
                filho2 = filho2.concat(getElementoXBinario(pai1,j,i,numtar,numbitsded));
                //System.fileoutappend.printf("\t\tfilho2: %s\n",filho2);
                j++;
            }
            i++;
        }
        //System.fileoutappend.printf("Inserindo quadrantes 3 e 4\n");
        //System.fileoutappend.printf("while(i<numemp)\n");
        while(i<numemp){
            //Inserindo quadrante 3(inferior esquerdo) do pai 1 e quadrante 4 (inferior direito) do pai 2.
            //System.fileoutappend.printf("\ti: %d\n", i);
            j=0;
            //System.fileoutappend.printf("\twhile(j<coluna+1)\n");
            while(j<coluna+1){
                //System.fileoutappend.printf("\t\tj: %d\n", j);
                filho2 = filho2.concat(getElementoXBinario(pai1,j,i,numtar,numbitsded));
                //System.fileoutappend.printf("\t\tfilho2: %s\n",filho2);
                j++;
            }
            //System.fileoutappend.printf("\twhile(j<numtar)\n");
            while(j<numtar){
                //System.fileoutappend.printf("\t\tj: %d\n", j);
                filho2 = filho2.concat(getElementoXBinario(pai2,j,i,numtar,numbitsded));
                //System.fileoutappend.printf("\t\tfilho2: %s\n",filho2);
                j++;
            }
            i++;
        }
        //System.fileoutappend.printf("\nFim de singlePointCrossover2D\n\n");
        filhos[0]=filho1;
        filhos[1]=filho2;
        
        return filhos;
    }
    
    public void imprimirSinglePointCrossover2D(){
        /*
         * Procedimento de teste que imprime o resultado de um 2D single point 
         * crossover.
         */
        String[] filhos;
        String s;
        int i,j,z;
        
        System.out.printf("2D Single Point Crossover para a população gerada: \n\n");
        
        z=0;
        while(z<this.populacao.size()){
            
            System.out.printf("\tIndivíduo %d x indivíduo %d: \n",z,z+1);
            filhos = singlePointCrossover2D(String.valueOf(this.populacao.get(z)),
                                            String.valueOf(this.populacao.get(z+1)),
                                            this.numtarefas,this.numempregados,this.numbitsdedicacao);
            
            System.out.printf("\t\tFilho 1: \n\t\t");
            i=0;
            while (i<this.numempregados){
                j=0;
                while (j<this.numtarefas){
                    s = getElementoXBinario(filhos[0],j,i,this.numtarefas,this.numbitsdedicacao);
                    System.out.printf("%s ",s);
                    j++;
                }
                System.out.printf("\n\t\t");
                i++;
            }
            System.out.printf("\n");
            
            System.out.printf("\t\tFilho 2: \n\t\t");
            i=0;
            while (i<this.numempregados){
                j=0;
                while (j<this.numtarefas){
                    s = getElementoXBinario(filhos[1],j,i,this.numtarefas,this.numbitsdedicacao);
                    System.out.printf("%s ",s);
                    j++;
                }
                System.out.printf("\n\t\t");
                i++;
            }
            System.out.printf("\n");
            
            z += 2;
        }
    }
    
    private String mutacaoBitFlip(String indv, int numtar, int numemp, int numbitsded){
        /*
         * Faz a mutação do indivíduo dado, trocando o valor de um bit randomico dele.
         */
        String indvmutado="";
        char c;
        RandomGenerator rg = new RandomGenerator();
        int i = rg.randint(indv.length());
        //System.fileoutappend.printf("\tbit: %d\n", i);
        
        c = indv.charAt(i);
        
        if (c=='1'){
            indvmutado = indv.substring(0, i).concat("0").concat(indv.substring(i+1, indv.length()));
        }
        if (c=='0'){
            indvmutado = indv.substring(0, i).concat("1").concat(indv.substring(i+1, indv.length()));
        }
        
        return indvmutado;
    }
    
    public void imprimirMutacaoBitFlip(){
        /*
         * Procedimento de teste que faz mutação bit flip de todos os indivíduos
         * da população.
         */
        System.out.printf("Mutação Bit Flip: \n\n");
        int i=0;
        while(i<this.populacao.size()){
            System.out.printf("\tIndivíduo %d:        %s\n",i,this.populacao.get(i));
            System.out.printf("\tIndivíduo %d mutado: %s\n",i,mutacaoBitFlip(String.valueOf(this.populacao.get(i)),
                                                                           this.numtarefas,
                                                                           this.numempregados,
                                                                           this.numbitsdedicacao));
            i++;
        }
    }
    
    private boolean contemIndividuo(ArrayList pop, String indv){
        /*
         * Método que verifica se a população dada contém o indivíduo dado. A populacao
         * deve ser um ArrayList ontendo somente Strings onde cada String representa
         * a matriz de solução de um indivíduo.
         */
        String s;
        
        int i=0;
        while(i<pop.size()){
            s = String.valueOf(pop.get(i));
            if(s.equals(indv)){
                return true;
            }
            i++;
        }
        
        return false;
    }
    
    public AlgGenetico(String nomearqinstancia, String nomearquivoresultados, int numruns, int numiteracoes, int numindividuos, int numbitsdedicacao) {
        long tempoexecucao = System.currentTimeMillis();
        Date datasistema = new Date(tempoexecucao);
        this.nomearqinstancia = nomearqinstancia;
        this.nomearquivoresultados = nomearquivoresultados;
        this.numruns = numruns;
        this.numindividuos = numindividuos;
        this.numiteracoes = numiteracoes;
        this.numbitsdedicacao = numbitsdedicacao;
        this.instancia = lerArqInstancia(nomearqinstancia);
        this.numempregados = lerNumEmpregados();
        this.numtarefas = lerNumTarefas();
        this.numhabilidades = lerNumHabilidades();
        this.numarestasgpt = lerNumArestasGPT();
        this.arestasgpt = lerArestasGPT();
        this.precedenciatarefas = lerPrecedenciaTarefas();
        this.custotarefas = lerCustoTarefas();
        this.numhabtarefas = lerNumHabTarefas();
        this.habtarefas = lerHabTarefas();
        this.salarioempregados = lerSalarioEmpregados();
        this.numhabempregados = lerNumHabEmpregados();
        this.habempregados = lerHabEmpregados();
        
        String[] selecionados;
        String[] filhos;
        double aptidaofilho1,duracaofilho1,custofilho1,aptidaofilho2,duracaofilho2,custofilho2;
        double mediaduracao=0,mediacusto=0,mediacustofactiveis=0,mediaduracaofactiveis=0,hithate=0;
        double mediatnr=0,mediahabnec=0,mediatrabextra=0;
        boolean factivelfilho1,factivelfilho2;
        int i,piorindv1,piorindv2;
        RandomGenerator rg;
        FileOutputStream fileout;
        
        System.out.printf("Instancia: %s\n",this.nomearqinstancia);
        
        //Cria arquivo de resultados.
        try{
            fileout = new FileOutputStream (this.nomearquivoresultados);
            
            new PrintStream(fileout).printf(Locale.ENGLISH,"#Resultados do AG para a instancia: %s\n",this.nomearqinstancia);
            new PrintStream(fileout).printf(Locale.ENGLISH,"#AG: %d runs, %d iteracoes, %d individuos, %d numbitsded\n",this.numruns,this.numiteracoes,this.numindividuos,this.numbitsdedicacao);
            new PrintStream(fileout).printf(Locale.ENGLISH,"#Data: %s\n",datasistema);
            new PrintStream(fileout).printf(Locale.ENGLISH,"ag.numruns=%d\n",this.numruns);
            new PrintStream(fileout).printf(Locale.ENGLISH,"ag.numiteracoes=%d\n",this.numiteracoes);
            new PrintStream(fileout).printf(Locale.ENGLISH,"ag.numindividuos=%d\n",this.numindividuos);
            new PrintStream(fileout).printf(Locale.ENGLISH,"ag.numbitsdedicacao=%d\n",this.numbitsdedicacao);
            
            fileout.close();		
        }catch (Exception e){
                System.err.printf("\nErro: %s\n", e);
        }
        
        //Número de runs desejado.
        int run=0;
        while(run<this.numruns){
            System.out.printf(Locale.ENGLISH,"\tRun %d/%d\n",run+1,this.numruns);
            
            //Cria geracao inicial.
            this.populacao = inicPopulacao(this.numempregados,this.numtarefas,numbitsdedicacao,numindividuos);
            this.duracaopopulacao = calcDuracaoPopulacao(this.populacao,this.numtarefas,this.numempregados,numbitsdedicacao);
            this.custopopulacao = calcCustoPopulacao(this.populacao,this.numtarefas,this.numempregados,numbitsdedicacao);
            this.factivelpopulacao = calcFactivelPopulacao(this.populacao,this.numtarefas,this.numempregados,numbitsdedicacao);
            this.aptidaopopulacao = calcAptidaoPopulacao(this.populacao,this.numtarefas,this.numempregados,numbitsdedicacao);
            this.rankingpopulacao = calcRankingPopulacao(this.aptidaopopulacao);
            
            //Armazena geração inicial no arquivo de resultados.
            try{
                PrintWriter fileoutappend = new PrintWriter(new BufferedWriter(new FileWriter(this.nomearquivoresultados, true)));
                
                fileoutappend.printf(Locale.ENGLISH,"run.%d.geracao.0.melhoraptidao=%f\n",run,this.aptidaopopulacao[this.rankingpopulacao[0]]);
                
                fileoutappend.close();		
            }catch (Exception e){
                    System.err.printf("\nErro: %s\n", e);
            }
            
            //Iteração do Algoritmo Genético. Número de iterações arbitrária de acordo com o número de gerações desejado.
            i=0;
            while(i<this.numiteracoes){

                //Seleção
                selecionados = selecTorneio(2,this.populacao,this.numtarefas,this.numempregados,this.numbitsdedicacao);

                //Crossover
                filhos = singlePointCrossover2D(selecionados[0],selecionados[1],this.numtarefas,this.numempregados,this.numbitsdedicacao);

                //Mutação filho 1 com 0.01 de chance
                rg = new RandomGenerator();
                if (rg.randint(100)==0){
                    filhos[0] = mutacaoBitFlip(filhos[0],this.numtarefas,this.numempregados,this.numbitsdedicacao);
                }
                //Mutação filho 2 com 0.01 de chance
                rg = new RandomGenerator();
                if (rg.randint(100)==0){
                    filhos[1] = mutacaoBitFlip(filhos[1],this.numtarefas,this.numempregados,this.numbitsdedicacao);
                }
                
                //Processa filhos somente se já não há indivíduos identicos a eles na população
                if ( !(contemIndividuo(this.populacao,filhos[0]))&&!(contemIndividuo(this.populacao,filhos[1])) ){
                    //Ambos filhos não estão na população

                    //Calcular aptidão, duração, custo e factível dos filhos
                    aptidaofilho1 = funcaoAptidao(filhos[0],this.numtarefas,this.numempregados,this.numbitsdedicacao);
                    duracaofilho1 = calcDuracaoProjeto(filhos[0],this.numtarefas,this.numempregados,this.numbitsdedicacao);
                    custofilho1 = calcCustoProjeto(filhos[0],this.numtarefas,this.numempregados,this.numbitsdedicacao);
                    factivelfilho1 = calcFactivelProjeto(filhos[0],this.numtarefas,this.numempregados,this.numbitsdedicacao);
                    aptidaofilho2 = funcaoAptidao(filhos[1],this.numtarefas,this.numempregados,this.numbitsdedicacao);
                    duracaofilho2 = calcDuracaoProjeto(filhos[1],this.numtarefas,this.numempregados,this.numbitsdedicacao);
                    custofilho2 = calcCustoProjeto(filhos[1],this.numtarefas,this.numempregados,this.numbitsdedicacao);
                    factivelfilho2 = calcFactivelProjeto(filhos[1],this.numtarefas,this.numempregados,this.numbitsdedicacao);

                    //Substituindo os 2 piores indivíduos da população
                    piorindv1 = this.rankingpopulacao[this.rankingpopulacao.length-1];
                    piorindv2 = this.rankingpopulacao[this.rankingpopulacao.length-2];
                    this.populacao.set(piorindv1, filhos[0]);
                    this.populacao.set(piorindv2, filhos[1]);
                    this.aptidaopopulacao[piorindv1] = aptidaofilho1;
                    this.duracaopopulacao[piorindv1] = duracaofilho1;
                    this.custopopulacao[piorindv1] = custofilho1;
                    this.factivelpopulacao[piorindv1] = factivelfilho1;
                    this.aptidaopopulacao[piorindv2] = aptidaofilho2;
                    this.duracaopopulacao[piorindv2] = duracaofilho2;
                    this.custopopulacao[piorindv2] = custofilho2;
                    this.factivelpopulacao[piorindv2] = factivelfilho2;

                    //Refazer ranking da população
                    this.rankingpopulacao = calcRankingPopulacao(this.aptidaopopulacao);

                }else if ( !(contemIndividuo(this.populacao,filhos[0])) ){
                    //Somente filho1 não está na população

                    //Calcular aptidão, duração, custo e factível dos filho 1
                    aptidaofilho1 = funcaoAptidao(filhos[0],this.numtarefas,this.numempregados,this.numbitsdedicacao);
                    duracaofilho1 = calcDuracaoProjeto(filhos[0],this.numtarefas,this.numempregados,this.numbitsdedicacao);
                    custofilho1 = calcCustoProjeto(filhos[0],this.numtarefas,this.numempregados,this.numbitsdedicacao);
                    factivelfilho1 = calcFactivelProjeto(filhos[0],this.numtarefas,this.numempregados,this.numbitsdedicacao);

                    //Substituindo o pior indivíduo da população
                    piorindv1 = this.rankingpopulacao[this.rankingpopulacao.length-1];
                    this.populacao.set(piorindv1, filhos[0]);
                    this.aptidaopopulacao[piorindv1] = aptidaofilho1;
                    this.duracaopopulacao[piorindv1] = duracaofilho1;
                    this.custopopulacao[piorindv1] = custofilho1;
                    this.factivelpopulacao[piorindv1] = factivelfilho1;

                    //Refazer ranking da população
                    this.rankingpopulacao = calcRankingPopulacao(this.aptidaopopulacao);

                }else if ( !(contemIndividuo(this.populacao,filhos[1])) ){
                    //Somente filho 2 não está na população

                    //Função de Aptidão filho 2
                    aptidaofilho2 = funcaoAptidao(filhos[1],this.numtarefas,this.numempregados,this.numbitsdedicacao);
                    duracaofilho2 = calcDuracaoProjeto(filhos[1],this.numtarefas,this.numempregados,this.numbitsdedicacao);
                    custofilho2 = calcCustoProjeto(filhos[1],this.numtarefas,this.numempregados,this.numbitsdedicacao);
                    factivelfilho2 = calcFactivelProjeto(filhos[1],this.numtarefas,this.numempregados,this.numbitsdedicacao);

                    //Substituindo o pior indivíduo da população
                    piorindv1 = this.rankingpopulacao[this.rankingpopulacao.length-1];
                    this.populacao.set(piorindv1, filhos[1]);
                    this.aptidaopopulacao[piorindv1] = aptidaofilho2;
                    this.duracaopopulacao[piorindv1] = duracaofilho2;
                    this.custopopulacao[piorindv1] = custofilho2;
                    this.factivelpopulacao[piorindv1] = factivelfilho2;

                    //Refazer ranking da população
                    this.rankingpopulacao = calcRankingPopulacao(this.aptidaopopulacao);
                }
                
                i++;
                
                //Armazena geração atual em arquivo.
                try{
                    PrintWriter fileoutappend = new PrintWriter(new BufferedWriter(new FileWriter(this.nomearquivoresultados, true)));
                    
                    fileoutappend.printf(Locale.ENGLISH,"run.%d.geracao.%d.melhoraptidao=%f\n",run,i,this.aptidaopopulacao[this.rankingpopulacao[0]]);
                    
                    fileoutappend.close();		
                }catch (Exception e){
                        System.err.printf("\nErro: %s\n", e);
                }
                
            }
            
            if(this.factivelpopulacao[this.rankingpopulacao[0]]){
                hithate++;
                mediaduracaofactiveis += this.duracaopopulacao[this.rankingpopulacao[0]];
                mediacustofactiveis += this.custopopulacao[this.rankingpopulacao[0]];
            }
            mediaduracao += this.duracaopopulacao[this.rankingpopulacao[0]];
            mediacusto += this.custopopulacao[this.rankingpopulacao[0]];
            mediatnr += verificarQuantasTarNaoRealizadas(String.valueOf(this.populacao.get(this.rankingpopulacao[0])), this.numtarefas, this.numempregados, this.numbitsdedicacao);
            mediahabnec += verificarQuantasHabAindaNecParaCompProjeto(String.valueOf(this.populacao.get(this.rankingpopulacao[0])), this.numtarefas, this.numempregados, this.numbitsdedicacao);
            mediatrabextra += calcTrabExtraProjeto(String.valueOf(this.populacao.get(this.rankingpopulacao[0])), this.numtarefas, this.numempregados, this.numbitsdedicacao);
            run++;
        }
        
        //Armazenar em arquivo o hithate, média de duração e média de custo das runs.
        mediaduracaofactiveis = mediaduracaofactiveis/hithate;
        mediaduracao = mediaduracao/this.numruns;
        mediacustofactiveis = mediacustofactiveis/hithate;
        mediacusto = mediacusto/this.numruns;
        mediatnr = mediatnr/this.numruns;
        mediahabnec = mediahabnec/this.numruns;
        mediatrabextra = mediatrabextra/this.numruns;
        hithate = hithate/this.numruns;
        
        try{
            PrintWriter fileoutappend = new PrintWriter(new BufferedWriter(new FileWriter(this.nomearquivoresultados, true)));
            
            fileoutappend.printf(Locale.ENGLISH,"ag.hithate=%f\n",hithate);
            fileoutappend.printf(Locale.ENGLISH,"ag.mediaduracaofactiveis=%f\n",mediaduracaofactiveis);
            fileoutappend.printf(Locale.ENGLISH,"ag.mediaduracao=%f\n",mediaduracao);
            fileoutappend.printf(Locale.ENGLISH,"ag.mediacustofactiveis=%f\n",mediacustofactiveis);
            fileoutappend.printf(Locale.ENGLISH,"ag.mediacusto=%f\n",mediacusto);
            fileoutappend.printf(Locale.ENGLISH,"ag.mediatnr=%f\n",mediatnr);
            fileoutappend.printf(Locale.ENGLISH,"ag.mediahabnec=%f\n",mediahabnec);
            fileoutappend.printf(Locale.ENGLISH,"ag.mediatrabextra=%f\n",mediatrabextra);
            tempoexecucao = System.currentTimeMillis() - tempoexecucao;
            fileoutappend.printf(Locale.ENGLISH,"ag.tempoexecucao=%d\n",tempoexecucao);
            
            fileoutappend.close();		
        }catch (Exception e){
                System.err.printf("\nErro: %s\n", e);
        }
        
    }
}
