package br.ufpr.mural.database;

import br.ufpr.mural.core.Usuario;

public class MainTestDB {
		public static void main(String[] args) {
			
			
			JdbcSqlDatabaseDao dao = new JdbcSqlDatabaseDao();
			Usuario usuario = new Usuario("fulano");
			dao.inserirUsuario(usuario);
			
			dao.getUsuario("fulano");
		}
}