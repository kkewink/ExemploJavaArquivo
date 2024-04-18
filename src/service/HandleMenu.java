package service;

import java.util.List;
import java.util.Scanner;

import models.Usuario;
import utils.GerenciadorDeUsuarios;

public class HandleMenu {

	Scanner sc = new Scanner(System.in);

	// Gerenciador
	GerenciadorDeUsuarios gs = new GerenciadorDeUsuarios();

	public HandleMenu() {
		// tida vez qye a classe menu, for instanciada, o nosso arquivo sera verificado
		gs.verificaECria("usuarios.txt");
	}

	public void criar() {
		System.out.println("Digite o nome:");
		String nome = sc.next();
		System.out.println("Digite uma senha:");
		String senha = sc.next();

		int id = getNextId();
		Usuario u = new Usuario(id, nome, senha);
		gs.adicionarUsuario(u);
	}

	public void editar() {
		System.out.println("Digite o ID do usuario:");
		int id = sc.nextInt();
		System.out.println("Digite o novo nome:");
		String nome = sc.next();
		System.out.println("Digite a nova senha:");
		String senha = sc.next();
		
		
	}

	public void deletar() {
		System.out.println("Digite o ID do usuario a ser deletado:");
		int id = sc.nextInt();
		gs.deletarUsuario(id);
	}

	public void listar() {
		gs.listarUsuarios();
	}

	public int getNextId() {
		List<Usuario> usuarios = gs.lerUsuarios();
		int maxId = 0;
		// for => foreach
		// Unico usuario : Lista com todos
		for (Usuario usuario : usuarios) {
			int id = usuario.getId();
			// 1
			if (id > maxId) {
				maxId = id;
				// 10
			}
		}
		// soma 1 + o ultimo
		return maxId + 1;
	}

	public void listaEspecifico() {
		System.out.println("Digite o ID do usuario Especifico");
		int id = sc.nextInt();
		gs.listarEspecifico(id);
		
	}
	
	public void login() {
		System.out.println("Digite seu login :");
		String nome = sc.next();
		System.out.println("Digite uma senha:");
		String senha = sc.next();
		
		gs.login( nome, senha);
		
		
	}
	
}
