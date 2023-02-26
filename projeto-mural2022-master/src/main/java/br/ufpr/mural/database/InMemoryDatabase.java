/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.mural.database;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

import br.ufpr.mural.core.Anuncio;
import br.ufpr.mural.core.Comentario;
import br.ufpr.mural.core.Evento;
import br.ufpr.mural.core.Lembrete;
import br.ufpr.mural.core.Mural;
import br.ufpr.mural.core.Post;
import br.ufpr.mural.core.Reacao;
import br.ufpr.mural.core.Sugestao;
import br.ufpr.mural.core.Usuario;
import br.ufpr.mural.database.DatabaseDao;

/**
 *
 * @author helio
 */
public class InMemoryDatabase implements DatabaseDao {  // DAO = Data Access Object
        
    //Sempre que inserir algo, crie um novo Map usando Integer(Id) como chave
	private Map<String, Usuario> usuarios;
	private Map<String, Mural> murais;
	private Map<String, Post> posts;
	//sempre que inserir algo aqui, insira em LimparBase();
	
	//Sempre criar um novo HashMap
	public InMemoryDatabase() {
		this.usuarios = new HashMap<>();
		this.murais = new HashMap<>();
		this.posts = new HashMap<>();
	}
	
    public void inserirUsuario(Usuario usuario){
        this.usuarios.put(usuario.getUserName(), usuario);
    }
    
    public Usuario getUsuario(String userName) {
    	return this.usuarios.get(userName);

    }
    
    public void inserirMural(Mural mural){
        this.murais.put(mural.getNome(), mural);
    }
    
    public Mural getMural(String nome) {
    	return this.murais.get(nome);
    }
    
//    public Mural getMural(int id) {
//    	return this.murais.get(id);
//    }
    
    public List<Mural> getMurais() {
    	List<Mural> murais = new ArrayList<Mural>();
    	murais.addAll(this.murais.values());
    	return murais;
    }

	@Override
	public void limparBase() {
		this.usuarios = new HashMap<>();
		this.murais = new HashMap<>();
	}

	@Override
	public void inserirPost(Anuncio post, Mural mural) {
		this.posts.put(post.getTexto(), post);
		
	}

	@Override
	public List<Post> getPost() {
		List<Post> posts = new ArrayList<Post>();
		posts.addAll(this.posts.values());
    	return posts;
	}

	@Override
	public void inserirPost(Evento post, Mural mural) {
		// TODO Auto-generated method stub
		
	}

	

	@Override
	public void inserirComentario(Comentario comentario, Post post) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Comentario> recuperarComentarios(Post post) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void inserirPostSalvo(Post post, Usuario usuario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Post> recuperarPostsSalvos(Usuario usuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void inserirReacao(Reacao reacao, Post post) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Reacao> recuperarReacoes(Post post) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removerReacao(Reacao reacao, Post post) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void inserirConfirmacaoEvento(Evento evento, Usuario usuario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Evento> recuperarEventosConfirmados(Usuario usuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removerConfirmacaoEvento(Evento evento, Usuario usuario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void inserirLembrete(Lembrete lembrete, Usuario usuario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Lembrete> recuperarLembretes(Usuario usuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void inserirSugestao(Sugestao sugestao) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Sugestao> recuperarSugestoesRecebidas(Usuario usuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Sugestao> recuperarSugestoesFeitas(Usuario usuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Sugestao> recuperarSugestoesPost(Post post) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTitulo(String titulo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Post[] getPosts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void muralAtual(Mural muralUsado) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getPost(Mural mural) {
		// TODO Auto-generated method stub
		
	}
}
