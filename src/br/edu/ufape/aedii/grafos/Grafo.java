package br.edu.ufape.aedii.grafos;


// Esta é uma interface que define os métodos que qualquer implementação de um grafo deve ter.
//Isso inclui métodos para adicionar vértices e arestas, obter o índice de um vértice, listar as adjacências de um vértice,
//imprimir o grafo e obter o número de vértices no grafo.
import java.util.List;

public interface Grafo {

	void adicionarVertice(String v);

	int getIndiceVertice(String v);

	void adicionarAresta(String v1, String v2);

	void adicionarAresta(int v1, int v2);

	void imprimirMapa();

	List<Integer> listarAdjacencias(int v);

	void imprimir();

	int getNumeroVertices();

	double getDistancia(int v1, int v2);

	String getNomeVertice(int v);

	void adicionarDistancia(String v1, String v2, double distancia);

}