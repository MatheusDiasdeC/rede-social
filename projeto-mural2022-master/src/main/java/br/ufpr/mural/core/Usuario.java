/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.mural.core;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
	
	private int id;
    private String userName;  // identificador
    private ArrayList<Post> postsSalvos = new ArrayList<Post>();
    private ArrayList<Evento> eventosConfirmados = new ArrayList<Evento>();
    private ArrayList<Lembrete> lembretes = new ArrayList<Lembrete>();
    private ArrayList<Sugestao> sugestoesRecebidas = new ArrayList<Sugestao>();
    private ArrayList<Sugestao> sugestoesFeitas = new ArrayList<Sugestao>();
    private static int ultimoId = 0;
    
    private static synchronized void incrementarUltimoId() {
    	
    	ultimoId++;
    }
    
    public synchronized static void resetaIds() {
        ultimoId = 0;
    }
    
    public Usuario(String userName) {
    	
    	incrementarUltimoId();
    	this.id = ultimoId;
    	this.userName = userName;
    	this.postsSalvos = new ArrayList<>();
    	
    }

    //Métodos
    void salvarPost(Post post) {
    	postsSalvos.add(post);
    }
   
    public List<Post> getPostsSalvos() {
		return postsSalvos;
	}
    
//    public void salvarPost(Post post) {
//    	this.postsSalvos.add(post);
//    }

    //Getters & Setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    
    public String getUserName() {
        return userName;
    }
    

//    void excluirPostSalvo(Post post) {
//    	if(postSalvos.get(post) = 0 || null) {
//    		System.out.println("Post não encontrado")}else{
//    			postSalvos.remove(post);
//    		};
//    	}
//    void addEventoConfirmado (Evento evento) {...}
//    void criarLembrete(Post post, DateTime dataHora) {...}
//    
//    void sugerirPost(Post post, Usuario usuarioSugestor) {...}
    
    
    
    
    
    

    

    
    
    
    
    
    
}
