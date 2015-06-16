/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package escalonador.tarefas;

/**
 *
 * @author Bill
 */
import java.util.*;

public class Geracao {
    
    private int id;
    private ArrayList populacao;
    private int[] ranking;
    private double[] aptidaopopulacao;
    private double[] duracaopopulacao;
    private double[] custopopulacao;
    private boolean[] factivelpopulacao;

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

    public double[] getAptidaopopulacao() {
        return aptidaopopulacao;
    }

    public void setAptidaopopulacao(double[] aptidaopopulacao) {
        this.aptidaopopulacao = aptidaopopulacao;
    }

    public int[] getRanking() {
        return ranking;
    }

    public void setRanking(int[] ranking) {
        this.ranking = ranking;
    }

    public ArrayList getPopulacao() {
        return populacao;
    }

    public void setPopulacao(ArrayList populacao) {
        this.populacao = populacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Geracao(int id, ArrayList populacao, int[] ranking, double[] aptidaopopulacao, double[] duracaopopulacao, double[] custopopulacao, boolean[] factivelpopulacao) {
        this.id = id;
        this.populacao = populacao;
        this.ranking = ranking;
        this.aptidaopopulacao = aptidaopopulacao;
        this.duracaopopulacao = duracaopopulacao;
        this.custopopulacao = custopopulacao;
        this.factivelpopulacao = factivelpopulacao;
    }

}
