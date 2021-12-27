package org.isep.dei.pl19.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import org.isep.dei.pl19.model.FicheiroListaTarefas;
import org.isep.dei.pl19.model.ListaTarefas;
import org.isep.dei.pl19.model.Prioridade;

public class AplicacaoController {

    private ListaTarefas lista;
    private FicheiroListaTarefas ficheiroListaTarefas;

    //inicia atributos
    public AplicacaoController() {
        lista = new ListaTarefas();
        ficheiroListaTarefas = new FicheiroListaTarefas();
    }

    //adiciona uma nova tarefa na lista
    public boolean adicionarTarefa(String descricao, Prioridade prioridade) {
        return lista.adicionarTarefa(descricao, prioridade);
    }

    //elimina da lista todas as tarefas
    public void eliminarTarefas() {
        lista.eliminarTarefas();

    }

    //elimina apenas a última tarefa inserida na lista
    public boolean eliminarUltimaTarefa() {
        return lista.eliminarTarefa(lista.tamanho() - 1);

    }

    //elimina a tarefa, sob a forma de string, recebida por parâmetro
    public boolean eliminarTarefa(String tarefaSelecionada) {
        return lista.eliminarTarefa(tarefaSelecionada);
    }

    //verifica se lista está ou não vazia
    public boolean listaVazia() {
        return lista.estaVazia();
    }

    //retorna os elementos da lista, por ordem de inserção
    public String getListaTarefas() {
        return lista.toString();
    }

    //retorna os elementos da lista, por ordem de inserção, sob a forma de um List<String>
    public List<String> getArrayListTarefas() {
        return Arrays.asList(lista.toString().split("\n"));

    }

    //retorna os elementos da lista, por ordem decrescente de prioridade
    public String getListaTarefasPorPrioridade() {
        return lista.toStringOrdemPrioridades();
    }

    //retorna os elementos da lista, por ordem decrescente de prioridade, sob a forma de um List<String>
    public List<String> getArrayListTarefasPorPrioridade() {
        return Arrays.asList(lista.toStringOrdemPrioridades().split("\n"));
    }

    public void preencher() {
        final int LIMITE_SUPERIOR = 15;
        lista.preencherLista((new Random()).nextInt(LIMITE_SUPERIOR) + 1);
    }

    //retorna um array com todos os valores de Prioridade
    public Prioridade[] getPrioridades() {
        return Prioridade.values();
    }

    //guarda em ficheiro de texto a lista de tarefas
    public boolean guardarFicheiroTexto() {
        return ficheiroListaTarefas.guardarFicheiroTexto(lista);
    }

    //guarda em ficheiro binário a lista de tarefas
    public boolean guardarFicheiroBinario() {
        return ficheiroListaTarefas.guardarFicheiroBinario(lista);
    }

}
