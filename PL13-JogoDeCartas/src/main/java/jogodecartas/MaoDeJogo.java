package jogodecartas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Representa uma mão de jogo.
 *
 * @author ISEP-DEI-PPROG
 */
public class MaoDeJogo {

     /**
     * A mão de jogo.
     */
    private List<Carta> maoDeJogo;
    
    /**
     * Constrói uma instância de {@code MaoDeJogo} recebendo um conjunto de
     * cartas.
     * 
     * @param mao o conjunto de cartas.
     */
    public MaoDeJogo(List<Carta> mao) {
        maoDeJogo = new ArrayList(mao);
    }

    /**
     * Constrói uma instância de {@code MaoDeJogo} vazia, ou seja, sem cartas.
     */
    public MaoDeJogo() {
        maoDeJogo = new ArrayList<>();
    }
    
    /**
     * Constrói uma instância de {@code MaoDeJogo} com as mesmas caraterísticas
     * da mão de jogo recebida por parâmetro.
     * 
     * @param outraMaoDeJogo a mão de jogo com as caraterísticas a copiar.
     */
    public MaoDeJogo(MaoDeJogo outraMaoDeJogo) {
        maoDeJogo = new ArrayList<>();
        for(Carta c : outraMaoDeJogo.maoDeJogo) {
            maoDeJogo.add(new Carta(c));
        }
    }

    /**
     * Devolve a mão de jogo.
     *
     * @return mão de jogo.
     */
    public List<Carta> getMaoDeJogo() {
        return new ArrayList<Carta>(maoDeJogo);
    }
    
    public boolean equals(Object outroObjeto){
         if (this == outroObjeto) {
            return true;
        }
        if (outroObjeto == null || getClass() != outroObjeto.getClass()) {
            return false;
        }
        MaoDeJogo outraMaoDeJogo = (MaoDeJogo) outroObjeto;
        if(this.maoDeJogo.size() != outraMaoDeJogo.maoDeJogo.size())
            return false;
        
        List<Carta> outraMaoDeJogoTemp = new ArrayList<Carta>(outraMaoDeJogo.maoDeJogo);
        List<Carta> maoDeJogoTemp = new ArrayList<Carta>(maoDeJogo);
        
        Collections.sort(outraMaoDeJogoTemp);
        Collections.sort(maoDeJogoTemp);
        return false;
    }
    
    /**
     * Devolve a descrição textual da mão de jogo (uma carta por linha).
     * 
     * @return caraterísticas das cartas da mão de jogo.
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Carta c : maoDeJogo) {
            s.append(c.toString());
            s.append("\n");
        }
        return s.toString();
    }

    /**
     * Devolve um conjunto com os vários tipos de carta (duque, terno, etc.)
     * existentes na mão de jogo.
     * 
     * @return {@code List} com os tipos de carta existentes na mão de jogo.
     */
    public List<Carta.Tipo> tiposDeCarta() {
        List<Carta.Tipo> tc = new ArrayList<>();
        for( Carta c : maoDeJogo) {
            if(!tc.contains(c.getTipo())){
                tc.add(c.getTipo());
            }
        }
        return tc;
    }

    /**
     * Determina quantas cartas de um dado tipo existem na mão de jogo.
     * 
     * @param tipo o tipo de carta.
     * @return quantidade de cartas do tipo, que existem na mão de jogo.
     */
    public int contarCartasDoTipo(Carta.Tipo tipo) {
        int n = 0;
        for(Carta c : maoDeJogo) {
            if(c.getTipo()== tipo) {
                n++;
            }
        }
        return n;
    }

    /**
     * Ordena a mão de jogo por naipe e, dentro do mesmo naipe, ordena por tipo.
     */
    public void ordenar() {
        Collections.sort(maoDeJogo);
    }

}
