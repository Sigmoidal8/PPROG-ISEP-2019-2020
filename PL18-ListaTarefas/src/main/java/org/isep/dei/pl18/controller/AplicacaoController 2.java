package org.isep.dei.pl18.controller;

import java.util.Random;
import org.isep.dei.pl18.model.ListaTarefas;
import org.isep.dei.pl18.model.Prioridade;

public class AplicacaoController {

    private ListaTarefas lista;

    //inicia atributos
    public AplicacaoController() {
        lista = new ListaTarefas();
    }

    //adiciona uma nova tarefa na lista
    public boolean adicionarTarefa(String descricao, Prioridade prioridade) {
        return lista.adicionarTarefa(descricao, prioridade);
    }

    //elimina de lista todas as tarefas
    public void eliminarTarefas() {
        lista.eliminarTarefas();
    }

    //elimina apenas a última tarefa inserida na lista
    public boolean eliminarUltimaTarefa() {
        return lista.eliminarUltimaTarefa();
    }

    //verifica se lista está ou não vazia
    public boolean listaVazia() {
        return lista.estaVazia();
    }

    //retorna os elementos da lista, por ordem de inserção
    public String getListaTarefas() {
        return lista.toString();
    }

    //retorna os elementos da lista, por decrescente de prioridade
    public String getListaTarefasPorPrioridade() {
        return lista.toStringOrdemPrioridades();
    }
    
    public void preencher() {
        final int limSuperior = 15;
        lista.preencherLista((new Random()).nextInt(limSuperior)+1);
    }

    //retorna um array com todos os valores de Prioridade
    public Prioridade[] getPrioridades() {
        return Prioridade.values();
    }
}
