/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package escalonador.tarefas;

/**
 *
 * @author Bill
 */
public class Periodo {
    
    private double inicio;
    private double fim;
    private double duracao;

    public double getDuracao() {
        return duracao;
    }

    public void setDuracao(double duracao) {
        this.duracao = duracao;
    }

    public double getFim() {
        return fim;
    }

    public void setFim(double fim) {
        this.fim = fim;
    }

    public double getInicio() {
        return inicio;
    }

    public void setInicio(double inicio) {
        this.inicio = inicio;
    }

    public Periodo(double inicio, double fim) {
        this.inicio = inicio;
        this.fim = fim;
        this.duracao = fim - inicio;
    }
    
}
