package br.edu.ufape.aedii.grafos;

import java.util.ArrayList;
import java.util.List;

public class CaixeiroViajante {
    private Grafo g;  // Adicione esta linha
    public CaixeiroViajante(Grafo g) {
        this.g = g;
    }

    public List<String> resolver() {
    List<String> caminho = new ArrayList<>();
    boolean[] visitado = new boolean[g.getNumeroVertices()];
    int atual = 0; // Começamos da cidade "Buíque"
    visitado[atual] = true;
    caminho.add(g.getNomeVertice(atual));

    for (int i = 0; i < g.getNumeroVertices() - 1; i++) {
        double menorDistancia = Double.MAX_VALUE;
        int proximo = -1;
        for (int j = 0; j < g.getNumeroVertices(); j++) {
            if (!visitado[j] && g.getDistancia(atual, j) < menorDistancia) {
                menorDistancia = g.getDistancia(atual, j);
                proximo = j;
            }
        }
        atual = proximo;
        visitado[atual] = true;
        caminho.add(g.getNomeVertice(atual));
    }

    // Volta para a cidade inicial
    caminho.add(g.getNomeVertice(0));

    return caminho;
}
}
