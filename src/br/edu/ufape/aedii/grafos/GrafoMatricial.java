package br.edu.ufape.aedii.grafos;


//Esta é uma implementação concreta da interface Grafo usando uma matriz de adjacência.
//Uma matriz de adjacência é uma representação de um grafo onde a célula M[i][j] é verdadeira
//se houver uma aresta do vértice i para o vértice j.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GrafoMatricial implements Grafo {
	private boolean[][] matriz;
	private double[][] distancias;
	private List<String> mapa;
	private int numeroVertices;
	
	public GrafoMatricial(int numeroVertices) {
		this.numeroVertices = numeroVertices;
		this.mapa = new ArrayList<String>(numeroVertices);
		this.matriz = new boolean[numeroVertices][numeroVertices];
		this.distancias = new double[numeroVertices][numeroVertices];  // Inicializa a matriz de distâncias
	
		for(int i=0; i<numeroVertices; i++) {
			this.matriz[i][i] = true;
			Arrays.fill(this.distancias[i], Double.MAX_VALUE);  // Preenche a matriz de distâncias
			this.distancias[i][i] = 0;  // A distância de um vértice para ele mesmo é sempre 0
		}
	}
	

	public void adicionarDistancia(String v1, String v2, double distancia) {
		int i = getIndiceVertice(v1);
		int j = getIndiceVertice(v2);
		this.distancias[i][j] = distancia;
		this.distancias[j][i] = distancia;  // Assumindo que o grafo é não direcionado
	}
	
	@Override
    public double getDistancia(int v1, int v2) {
        // Retorna a distância entre os vértices v1 e v2
        return this.distancias[v1][v2];
    }

    @Override
    public String getNomeVertice(int v) {
        // Retorna o nome do vértice v
        return this.mapa.get(v);
    }

	@Override
	public void adicionarVertice(String v) {
		this.mapa.add(v);
	}
	
	@Override
	public int getIndiceVertice(String v) {
		return this.mapa.indexOf(v);
	}
	
	@Override
	public void adicionarAresta(String v1, String v2) {
		this.adicionarAresta(getIndiceVertice(v1), getIndiceVertice(v2));
	}
	
	@Override
	public void adicionarAresta(int v1, int v2) {
		this.matriz[v1][v2] = true; 
		this.matriz[v2][v1] = true;
	}
	
	@Override
	public void imprimirMapa() {
		for(String v: this.mapa)
			System.out.println(getIndiceVertice(v) + " - " + v);
	}
	
	@Override
	public List<Integer> listarAdjacencias(int v) {
		List<Integer> adjacentes = new ArrayList<Integer>(this.numeroVertices);
		for(int j=0; j<this.numeroVertices;j++)
			if(this.matriz[v][j] && v!=j) {
				adjacentes.add(j);
			}
		return adjacentes;
	}
	
	@Override
	public void imprimir() {
		for(int i=0; i < this.numeroVertices; i++ ) {
			for(int j=0; j < this.numeroVertices; j++) {
				System.out.print(this.matriz[i][j] + "\t");
			}
			System.out.println("");
		}
		System.out.println("");
	}
	
	
	public boolean[][] getMatriz() {
		return matriz;
	}

	public void setMatriz(boolean[][] matriz) {
		this.matriz = matriz;
	}

	public List<String> getMapa() {
		return mapa;
	}

	public void setMapa(List<String> mapa) {
		this.mapa = mapa;
	}

	@Override
	public int getNumeroVertices() {
		return numeroVertices;
	}

	public void setNumeroVertices(int numeroVertices) {
		this.numeroVertices = numeroVertices;
	}
	
}

