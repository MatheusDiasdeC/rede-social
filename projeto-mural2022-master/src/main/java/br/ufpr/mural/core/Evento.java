package br.ufpr.mural.core;

import java.util.List;

public class Evento extends Post{

	
	//	DateTime dataHora;
	String local;
	List<Usuario> usuariosConfirmados;
	
	//Construtor
	public Evento(Usuario usuario, String texto) {
		super(usuario, texto);
	
	}
	
	//Métodos
	void confirmarPresenca(Usuario usuario) {
		usuariosConfirmados.add(usuario);
	}
	void desconfirmarPresenca(Usuario usuario) {}
	
//    List<Usuario> getUsuariosConfirmados(Usuario usuario) {
//    	
//    for (int i = 0; i < usuariosConfirmados.size(); i++) {
//    	System.out.println(usuariosConfirmados.get(i));
//    }
//    
//    return List<Usuario>;
//    }
}
