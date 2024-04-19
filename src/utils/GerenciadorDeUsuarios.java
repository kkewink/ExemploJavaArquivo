package utils;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import models.Usuario;

public class GerenciadorDeUsuarios {

	private static final String NOME_ARQUIVO = "usuarios.txt";

	// Verificar a existencia do nosso banco e criar caso não exista
	public void verificaECria(String nomeArquivo) {
		// file => arquivo
		File arquivo = new File(nomeArquivo);
		// Verificar se o arqvui existe
		if (arquivo.exists()) {
			System.out.println("Banco funcionando!");
		} else {
			// tenta criar, caso de erro, exibir o erro
			try {
				// Criar o novo arquivo
				arquivo.createNewFile();
				System.out.println("Arquivo criado com sucesso!");
			} catch (IOException e) {
				System.err.println("Ocorreu um erro ao criar o arquivo: " + e.getMessage());
			}
		}
	}

	public void adicionarUsuario(Usuario usuario) {
		// Writer => Escrever
		// BuffereWriter , FileWriter
		// BufferredWriter , proporciona uma eficiente escrita
		// FileWriter , escreva dentro de arquivo
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(NOME_ARQUIVO, true))) {
			bw.write(usuario.toString()); // 1;Ernesto;123456
			bw.newLine(); // nova linha do arquivo.txt
			System.out.println("Usuario adicionado com sucesso!");
		} catch (IOException e) {
			System.err.println("Ocorreu um erro ao criar o arquivo: " + e.getMessage());
		}
	}

	public List<Usuario> lerUsuarios() {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		// Buffed, File, Reader
		try (BufferedReader br = new BufferedReader(new FileReader(NOME_ARQUIVO))) {
			String linha; // linha => 1;nome;senha
			// percorrer todas as linhas enquanto seja diferente de vazio
			while ((linha = br.readLine()) != null) {
				String[] partes = linha.split(";"); // Dividir em tres partes
				usuarios.add(new Usuario(Integer.parseInt(partes[0]), partes[1], partes[2]));
			}
		} catch (IOException e) {
			System.err.println("Ocorreu um erro ao ler o arquivo: " + e.getMessage());
		}
		return usuarios;
	}

	public void deletarUsuario(int id) {
		List<Usuario> usuarios = lerUsuarios();

		if (usuarios.removeIf(usuario -> usuario.getId() == id)) {
			reescreverArquivo(usuarios);
			System.out.println("Usuario deletado com sucesso");
		} else {
			System.out.println("Usuario não encontrado");
		}
	}

	public void reescreverArquivo(List<Usuario> usuarios) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(NOME_ARQUIVO))) {
			for (Usuario usuario : usuarios) {
				bw.write(usuario.toString());
				bw.newLine();
			}
		} catch (IOException e) {
			System.out.println("Ocurreu um erro ao reescrever o arquivo: " + e.getMessage());
		}
	}

	public void listarUsuarios() {

		List<Usuario> usuarios = lerUsuarios();
		// nehum usuario
		if (usuarios.isEmpty()) {
			System.out.println("Nenhum usuario cadastrado");
		} else {
			System.out.println("Lista de usuarios");
			for (Usuario usuario : usuarios) {
				System.out.println("ID: " + usuario.getId() + "; Nome: " + usuario.getNome() + "" + "; Senha: "
						+ usuario.getSenha());
			}
		}
	}

	public void editarUsuario(int id, String novoNome, String novaSenha) {
		List<Usuario> usuarios = lerUsuarios();
		boolean encontrado = false;

		for (Usuario usuario : usuarios) {
			if (usuario.getId() == id) {
				usuario.setNome(novoNome);
				usuario.setSenha(novaSenha);
				encontrado = true;
				break;
			}
		}
		if (encontrado) {
			reescreverArquivo(usuarios);
			System.out.println("Usuario editado com sucesso!");
		} else {
			System.out.println("Usuario não encontrados");
		}

	}

	public void listarEspecifico(int id) {
		List<Usuario> usuarios = lerUsuarios();

		for (Usuario usuario : usuarios) {
			if (usuario.getId() == id) {
				System.out.println("ID: " + usuario.getId() + "; Nome: " + usuario.getNome() + "" + "; Senha: "
						+ usuario.getSenha());
			}
		}

	}

	public void login(String nomelogin, String senhaLogin) {
		List<Usuario> usuarios = lerUsuarios();

		boolean acesso = false;

		for (Usuario usuario : usuarios) {

			if (usuario.getNome().equals(nomelogin) && usuario.getSenha().equals(senhaLogin)) {
				acesso = true;
			} else {
				acesso = false;
			}
		}
		if (acesso) {
			System.out.println("Login Efetivado!");
		} else {
			System.out.println("ACESSO NEGADO");
		}

	}

	public void novaSenha(String login, String senha, String newSenha) {
		List<Usuario> usuarios = lerUsuarios();
		boolean acesso = false;

		for (Usuario usuario : usuarios) {
			if (usuario.getNome().equals(login) && usuario.getSenha().equals(senha)) {
				acesso = true;
				usuario.setSenha(newSenha);

			} else {

				acesso = false;
			}

		}
		if (acesso == true) {
			reescreverArquivo(usuarios);
			System.out.println("Login Atualizado!");
		} else {
			System.out.println("ACESSO NEGADO");
		}
	}

}
