package br.ufpr.mural.core;

import java.util.ArrayList;
import java.util.List;

public class Mural {

		private String nome;
		private List<Post> posts;
		private int id;
		private static int ultimoId = 0;
	    
	    private static synchronized void incrementarUltimoId() {
	    	ultimoId++;
	    }
	    public synchronized static void resetaIds() {
	        ultimoId = 0;
	    }
	    
	    //Construtor
	    public Mural(String nome) {
	    	
	    	incrementarUltimoId();
	    	this.id = ultimoId;
	    	this.nome = nome;
	    	this.posts = new ArrayList<Post>();
	    }
	    
	    //Métodos
		public void inserirPost(Post post) {
			posts.add(post);
		}
		public void removerPost(Post post) {			
		}
		public List<Post> getPosts() {
			return posts;
		}
//		public void muralAtual(Mural mural) {
//			return muralUsado;
//		}
		
		//Getters & Setters
		public int getId() {
			return id;
		}
		public String getNome() {
			return nome;
		}
		
		public String toString() {
			return this.nome;
		}
}
