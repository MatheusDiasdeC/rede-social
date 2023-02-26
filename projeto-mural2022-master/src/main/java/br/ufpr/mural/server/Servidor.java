package br.ufpr.mural.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.ufpr.mural.core.Anuncio;
import br.ufpr.mural.core.Evento;
import br.ufpr.mural.core.Mural;
import br.ufpr.mural.core.Post;
import br.ufpr.mural.core.Usuario;
import br.ufpr.mural.database.DatabaseDao;
import br.ufpr.mural.database.InMemoryDatabase;

public class Servidor {

//	DateTimeFormatter formatador = ...

	private Usuario usuarioLogado = null;

	private static final int PORTA = 1234; // atributo de classe

	private DatabaseDao database; // atributo do objeto

	public Servidor(DatabaseDao database) {
		this.database = database;
	}

	public void iniciar() throws IOException {

		ServerSocket socket = new ServerSocket(PORTA);

		System.out.println("Servidor iniciado.");

		try {
			while (true) {
				atenderCliente(socket.accept());
			}
		} finally {
			socket.close();
		}
	}

	private void atenderCliente(final Socket cliente) {
		// A ideia basica para atender um cliente é
		// - ler comando
		// - processar comando (feito por meio do método tratarComando)
		// - escrever resposta

		new Thread() {

			@Override
			public void run() {

				ArrayList<String> listaDeResultado; // Lista de retorno

				String command = null;

				try {
					command = readLine(cliente.getInputStream());
				} catch (IOException ex) {
					Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
				}

				listaDeResultado = tratarComando(command);

				try {
					for (String line : listaDeResultado) {
						writeLine(cliente.getOutputStream(), line);
					}

					cliente.close();
				} catch (IOException ex) {
					Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
				}

			}

		}.start();
	}

	private static String readLine(InputStream in) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		return reader.readLine();
	}

	private static void writeLine(OutputStream out, String linhas) throws IOException {
		out.write(linhas.getBytes());
		out.write('\n');
	}

	private ArrayList<String> tratarComando(String comando) {

		ArrayList<String> listaDeResultado = new ArrayList<String>();

		if (comando == null) {
			listaDeResultado.add(Resposta.COMANDO_INVALIDO.toString());
			return listaDeResultado;
		}

		String[] comandoDividido = comando.split(" (?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1); // "criar-usuario joao" -->
		//System.out.println(comando);																					// ["criar-usuario", "joao"]

		String tipoComando = comandoDividido[0];

		if (tipoComando.equals(Comando.LIMPAR_BANCO.toString())) { // limpeza do banco para testes
			this.database.limparBase();
			listaDeResultado.add(Resposta.OK.toString());
			return listaDeResultado;
		}

		if (tipoComando.equals(Comando.CRIAR_USUARIO.toString())) {
			// System.out.println(command.split(" ").length);
			if (comandoDividido.length != 2) {
				listaDeResultado.add(Resposta.COMANDO_INVALIDO.toString());
				return listaDeResultado;
			}
			// else:
			String userName = comandoDividido[1];

			// TODO: testar se tamanho de userName é menor que 3 ou maior que 20

			if (userName.length() < 3 || userName.length() > 20) {
				listaDeResultado.add(Resposta.NOME_INVALIDO.toString());
				return listaDeResultado;
			}

			// LÓGICA DE NEGÓCIO

			// VERIFICAR SE USUARIO EXISTE:
			if (database.getUsuario(userName) != null) {
				listaDeResultado.add(Resposta.USUARIO_JA_EXISTE.toString());
				return listaDeResultado;
			}

			Usuario user = new Usuario(userName);

			database.inserirUsuario(user);

			// RETORNAR SAÍDA
			listaDeResultado.add("ok");

		}
		//LOGIN
		if (tipoComando.equals(Comando.LOGIN.toString())) {

			String userName = comandoDividido[1];
			Usuario usuario = database.getUsuario(userName);
			if (usuario == null) {
				listaDeResultado.add(Resposta.USUARIO_NAO_ENCONTRADO.toString());
				return listaDeResultado;
			}
			this.usuarioLogado = usuario;
			listaDeResultado.add(Resposta.OK.toString());
			return listaDeResultado;

		} else if (tipoComando.equals(Comando.LOGOUT.toString())) {

			this.usuarioLogado = null;
			listaDeResultado.add(Resposta.OK.toString());
			return listaDeResultado;

		}
		//Criar Mural
		if (tipoComando.equals(Comando.CRIAR_MURAL.toString())) {

			String nome = comandoDividido[1];
			Mural mural = new Mural(nome);
			database.inserirMural(mural);
			//System.out.println(mural);
			listaDeResultado.add(Resposta.OK.toString());
			return listaDeResultado;

		}
        //Listar Mural
		if (tipoComando.equals(Comando.LISTAR_MURAIS.toString())) {

//        	if (database.getMurais().isEmpty()) {
//            	listaDeResultado.add(Resposta.MURAL_VAZIO.toString());
//                return listaDeResultado;
//            }
			for (Mural mural : database.getMurais()) {

				listaDeResultado.add(mural.toString());
			}

//            	listaDeResultado.add(Resposta.MURAL_NAO_ENCONTRADO.toString());
//                return listaDeResultado;
		}
		
		//Listar
		if (tipoComando.equals(Comando.LISTAR_POSTS.toString())){
			
			String nome = comandoDividido[1];
			Mural muralPost = database.getMural(nome);
			
			//Mural não encontrado
			if(muralPost == null) {
				listaDeResultado.add(Resposta.MURAL_NAO_ENCONTRADO.toString());
				return listaDeResultado;
			}
			
			//Mural vazio
			List<Post> postagens = database.getMural(nome).getPosts();
			System.out.println(postagens);
			
			if (postagens.isEmpty()) {
				listaDeResultado.add(Resposta.MURAL_VAZIO.toString());
				
				return listaDeResultado;
			}else {
				for (Post post : database.getPosts()) {
					listaDeResultado.add(postagens.toString());
				return listaDeResultado;
				}
			}
			
//			if (postagens.contains(texto)) {
//				String r1 = texto;
//				listaDeResultado.add(r1.toString());
//				return listaDeResultado;
//			}else {
//				listaDeResultado.add(Resposta.MURAL_NAO_ENCONTRADO.toString());
//				return listaDeResultado;
//			}
			}

		//usar-mural
		
//		String mural = database.getMural(mural);
//		Mural muralAtual = database.getMural(mural);
//		Mural muralUsado = muralAtual;
		
		if(tipoComando.equals(Comando.USAR_MURAL.toString())) {
			
			String mural = comandoDividido[1];
			Mural muralAtual = database.getMural(mural);
			//Mural muralUsado = muralAtual;
			//System.out.println(muralAtual);
			listaDeResultado.add(Resposta.OK.toString());
			return listaDeResultado; 
		}
		
			//
		if (tipoComando.equals(Comando.POSTAR_ANUNCIO.toString())) { 
			
			if (comandoDividido.length != 2) {
				listaDeResultado.add(Resposta.MENSAGEM_INVALIDA.toString());
				return listaDeResultado;
			}
			
			String texto1 = comandoDividido[1];
			Anuncio anuncio = new Anuncio(usuarioLogado, texto1);
			String mural = comandoDividido[1];
			Mural muralAtual = database.getMural(mural);
			//Mural muralUsado = muralAtual;
			
			database.inserirPost(anuncio, muralAtual /*muralUsado*/);

//			//Debug
//			List<Post> anuncios = database.getMural(mural).getPosts();
//			System.out.println(anuncios);
			
			//Debug
			
			
			// RETORNAR SAÍDA
			listaDeResultado.add("ok");

//			
//			this.database.limparBase();
//			listaDeResultado.add(Resposta.OK.toString());
//			return listaDeResultado;
		}
			
			
			//muralUsado.inserirPost(Post texto1);
		
		// TODO...

//        	Evento
//        	String mensagem = comandoDividido[1];
//        	String data = comandoDividido[2];
//        	String hora = comandoDividido[3];
//        	String local = comandoDividido[4];
//        	
//        	String dataHoraStr = data + " " + hora;

		// Datetime..comando;.

		// this.usuarioLogadnull;
		return listaDeResultado;
		
}}
