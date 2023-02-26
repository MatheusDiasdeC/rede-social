package br.ufpr.mural.server;

public enum Comando {
	
	COLOCAR_SEM_NOCAO("colocar-sem-nocao"),
	
	CONFIRMAR_PRESENCA("confirmar-presenca"),
	
	CRIAR_LEMBTRETE("criar-lembrete"),
	CRIAR_MURAL("criar-mural"),
	CRIAR_USUARIO("criar-usuario"),
	
	CURTIR_POST("curtir-post"),
	
	DESCONFIRMAR_PRESENCA("desconfirmar-presenca"),
	
	EXCLUIR_COMENTARIO("excluir-comentario"),
	EXCLUIR_POST("excluir-post"),
	EXCLUIR_SALVOS("excluir-salvos"),
	
	LIMPAR_BANCO("limpar-banco"),
	
	LISTAR_COMENTARIOS("listar-comentarios"),
	LISTAR_EVENTOS_CONFIRMADOS("listar-eventos-confirmados"),
	LISTAR_MURAIS("listar-murais"),
	LISTAR_PARTICIPANTES("listar-participantes-evento"),
	LISTAR_POSTS("listar-posts"),
	LISTAR_REACOES("listar-reacoes"),
	LISTAR_SALVOS("listar-salvos"),
	LISTAR_SUGESTOES("listar-sugestoes"),
	
	LOGIN("login"),
	LOGOUT("logout"),
	
	ODIAR_POST("odiar-post"),
	
	POSTAR_ANUNCIO("postar-anuncio"),
	POSTAR_EVENTO("postar-evento"),
	
	REMOVER_LEMBRETE("remover-lembrete"),
	REMOVER_REACAO("remover-reacao"),
	
	SALVAR_POST("salvar-post"),
	SUGERIR("sugerir"),
	
	USAR_MURAL("usar-mural"),
	
	;

	private String nomeComando;
	
	Comando(String nomeComando) {
		this.nomeComando = nomeComando;
	}
	
	
	
	@Override
	public String toString() {
		return this.nomeComando;
	}

}
