package br.ufpr.mural.core;

import java.util.ArrayList;

public abstract class Post {

	//private String titulo;
	private String texto;
	private Usuario usuarioCriador;
//	private DateTime dataCriacao;
	private ArrayList<Reacao> reacoes;
	private ArrayList<Comentario> comentarios;
	private int id;
	private static int ultimoId = 0;
    
	//Métodos
    private static synchronized void incrementarUltimoId() {
    	ultimoId++;
    }
    public synchronized static void resetaIds() {
        ultimoId = 0;
    }
    
    //Construtor
    public Post(Usuario usuario, String texto) {
    	
    	incrementarUltimoId();
    	this.id = ultimoId;
    	//this.titulo = titulo;
    	this.usuarioCriador = usuario;
    	this.texto = texto;
    	this.reacoes = new ArrayList<Reacao>();
    	this.comentarios = new ArrayList<Comentario>();
    	
    }
//	Getters & Setters
    public String getTexto() {
		return texto;
	}
//	void curtir(Usuario usuario) {...}
//	void odiar(Usuario usuario) {...}
//	void semNocao(Usuario usuario) {...}
//	void excluirReacao(Usuario usuario, Reacao reacao) {...}
//	ArrayList<Reacao> getReacoes(){...}
//	void comentar(Usuario usuario, String mensagem) {...}
}
