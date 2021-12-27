package org.isep.dei.pl18.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ListaTarefas {


    public enum ORDENACAO {
        INSERCAO, PRIORIDADE
    }

    private List<Tarefa> listaTarefas;

    //implementar todas as funcionalidades necessárias
    public ListaTarefas() {
        listaTarefas = new ArrayList<>();
    }

    public boolean adicionarTarefa(String descricao, Prioridade prioridade) {
        Tarefa tarefa = new Tarefa(descricao, prioridade);
        return listaTarefas.contains(tarefa) ? false : listaTarefas.add(tarefa);
    }

    public void eliminarTarefas() {
        listaTarefas.clear();
    }

    public boolean eliminarUltimaTarefa() {
        return listaTarefas.remove(listaTarefas.remove(listaTarefas.get(listaTarefas.size()-1)));
    }

    public boolean estaVazia() {
        return listaTarefas.isEmpty();
    }
    
    public int tamanho() {
        return listaTarefas.size();
    }
    
    public String toString() {
        StringBuilder s = new StringBuilder();
        
        for(Tarefa tarefa : listaTarefas) {
            s.append(tarefa);
            s.append("\n");
        }
        
        return s.toString().trim();
    }
    
    public String toStringOrdemPrioridades() {
        List<Tarefa> copia = new ArrayList<>(listaTarefas);
        
        Collections.sort(copia, Collections.reverseOrder());
        StringBuilder s = new StringBuilder();
        
        for(Tarefa tarefa : copia) {
            s.append(tarefa);
            s.append("\n");
        }
        
        return s.toString().trim();
    }
    
    
    public void preencherLista(int tam){
        int numberItems = listaTarefas.size();
        for (int i = 0; i < tam; i++) {
            adicionarTarefa(String.format("t%03d", numberItems+i),
                    Prioridade.values()[new Random().nextInt(Prioridade.values().length)]);
        }
    }
}