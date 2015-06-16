/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package escalonador.tarefas;

/**
 *
 * @author Bill
 */
public class Momento {
    
    private double inicio;
    private double fim;
    private double duracao;
    private String tarefasconcomitantes;

    
    public String getTarefasconcomitantes() {
        return tarefasconcomitantes;
    }

    public void setTarefasconcomitantes(String tarefasconcomitantes) {
        this.tarefasconcomitantes = tarefasconcomitantes;
    }
    
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
    
    public void addTarefa(String tarefa){
        String tarefas = "";
        tarefas = tarefas.concat(" ").concat(tarefa);
        
        setTarefasconcomitantes(tarefas);
    }

    public Momento(double inicio, double fim, String tarefasconcomitantes) {
        this.inicio = inicio;
        this.fim = fim;
        this.duracao = fim - inicio;
        this.tarefasconcomitantes = tarefasconcomitantes;
    }

}
