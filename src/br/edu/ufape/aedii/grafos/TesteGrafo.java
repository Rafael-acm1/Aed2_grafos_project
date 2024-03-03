package br.edu.ufape.aedii.grafos;

import java.util.List;

public class TesteGrafo {
	public static void main(String[] args) {
		Grafo g = new GrafoMatricial(4);

		g.imprimir();
		
		g.adicionarVertice("A");
		g.adicionarVertice("B");
		g.adicionarVertice("C");
		g.adicionarVertice("D");
		
		g.adicionarAresta("A", "B");
		g.adicionarDistancia("A", "B", 1);
		g.adicionarAresta("B", "C");
		g.adicionarDistancia("B", "C", 4);
		g.adicionarAresta("C", "D");
		g.adicionarDistancia("C", "D", 2);
		g.adicionarAresta("D", "A");
		g.adicionarDistancia("D", "A", 1);

		
		CaixeiroViajante cv = new CaixeiroViajante(g);
		List<String> caminho = cv.resolver();

		System.out.println(caminho);
		

	}
}
