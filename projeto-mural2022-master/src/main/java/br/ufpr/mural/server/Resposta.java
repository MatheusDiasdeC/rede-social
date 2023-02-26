package br.ufpr.mural.server;

public enum Resposta {
	
	OK("ok"),
	COMANDO_INVALIDO("comando-invalido"),
	NOME_INVALIDO("nome-invalido"),
	MENSAGEM_INVALIDA("mensagem-invalida"),
	MURAL_NAO_ENCONTRADO("mural-nao-encontrado"),
	MURAL_VAZIO("mural-vazio"),
	USUARIO_JA_EXISTE("usuario-ja-existe"),
	USUARIO_NAO_ENCONTRADO("usuario-nao-encontrado");

	private String nomeMensagem;
	
	Resposta(String nomeMensagem) {
		this.nomeMensagem = nomeMensagem;
	}
	
	@Override
	public String toString() {
		return nomeMensagem;
	}
	

}
