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
		String nome = "";
		String senha = "";
		int id = 0;

		boolean nomeE = false;
		while (nomeE == false) {
			System.out.println("Digite o nome:");
			try {
				nome = sc.nextLine();
				if (nome.length() == 0) {
					System.err.println("NÂO DEIXE ESPAÇO EM BRANCO");
				}
				if (nome.length() < 3) {
					System.err.println("MINIMO DE CARACTERES = 3");
				} else {
					nomeE = true;
				}

			} catch (Exception e) {

			}
		}

		boolean senhaE = false;
		while (senhaE == false) {
			System.out.println("Digite uma senha:");
			try {
				senha = sc.next();
				if (senha.length() < 6) {
					System.err.println("MINIMO 6");
				}
				if (senha.equalsIgnoreCase(nome)) {
					System.err.println("NOME E SENHA NÂO PODEM SER IGUAIS");
				} else {
					senhaE = true;
				}
			} catch (Exception e) {
			}
		}

		id = getNextId();
		Usuario u = new Usuario(id, nome, senha);
		gs.adicionarUsuario(u);
	}

	public void editar() {
		System.out.println("Digite o ID do usuario:");

		int id = 0;

		boolean idE = false;
		while (idE == false) {
			System.out.println("Digite a nova quantidade:");
			try {
				id = sc.nextInt();
				if (id < 0) {
					System.err.println("DIGITE UM VALOR POSITIVO");
				} else {
					idE = true;
				}
			} catch (Exception e) {
				System.err.println("DIGITE APENAS NUMEROS");
			}

		}

		String nome = "";

		boolean nomeE = false;
		while (nomeE == false) {
			System.out.println("Digite o novo nome:");
			try {
				nome = sc.next();
				if (nome.length() == 0) {
					System.err.println("NÂO DEIXE ESPAÇO EM BRANCO");

				}
				if (nome.length() < 3) {
					System.err.println("MINIMO DE CARACTERES = 3");

				} else {

					nomeE = true;
				}

			} catch (Exception e) {
			}
		}

		String senha = "";

		boolean senhaE = false;
		while (senhaE == false) {
			System.out.println("Digite a nova senha:");
			try {
				senha = sc.next();
				if (senha.length() < 6) {
					System.err.println("MINIMO 6");
				}
				if (senha.equalsIgnoreCase(nome)) {
					System.err.println("NOME E SENHA NÂO PODEM SER IGUAIS");
				} else {
					senhaE = true;
				}
			} catch (Exception e) {
			}
		}

		gs.editarUsuario(id, nome, senha);
	}

	public void deletar() {
		int id = 0;

		boolean idE = false;
		while (idE == false) {
			System.out.println("Digite o ID do usuario a ser deletado:");
			try {
				id = sc.nextInt();
				if (id < 0) {
					System.err.println("DIGITE UM VALOR POSITIVO");

				} else {
					idE = true;
				}
			} catch (Exception e) {
				System.err.println("DIGITE APENAS NUMEROS");
			}
		}
		
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

	public void dadoUnico() {
		int id = 0;

		boolean idE = false;
		while (idE == false) {
			System.out.println("Digite o ID do usuario Especifico:");
			try {
				id = sc.nextInt();
				if (id < 0) {
					System.err.println("DIGITE UM VALOR POSITIVO");

				} else {
					idE = true;
				}
			} catch (Exception e) {
				System.err.println("DIGITE APENAS NUMEROS");
			}
		}
		gs.listarEspecifico(id);

	}

	public void login() {
		String nome = "";

		boolean nomeE = false;
		while (nomeE == false) {
			System.out.println("Digite seu login :");
			try {
				nome = sc.nextLine();
				if (nome.length() == 0) {
					System.err.println("NÂO DEIXE ESPAÇO EM BRANCO");
				}
				if (nome.length() < 3) {
					System.err.println("MINIMO DE CARACTERES = 3");
				} else {
					nomeE = true;
				}

			} catch (Exception e) {

			}
		}
		String senha = sc.next();

		boolean senhaE = false;
		while (senhaE == false) {
			System.out.println("Digite sua senha :");
			try {
				senha = sc.next();
				if (senha.length() < 6) {
					System.err.println("MINIMO 6");
				}
				if (senha.equalsIgnoreCase(nome)) {
					System.err.println("NOME E SENHA NÂO PODEM SER IGUAIS");
				} else {
					senhaE = true;
				}
			} catch (Exception e) {
			}
		}
		gs.login(nome, senha);

	}

	public void trocarSenha() {
		String nome = "";

		boolean nomeE = false;
		while (nomeE == false) {
			System.out.println("Digite seu login :");
			try {
				nome = sc.nextLine();
				if (nome.length() == 0) {
					System.err.println("NÂO DEIXE ESPAÇO EM BRANCO");
				}
				if (nome.length() < 3) {
					System.err.println("MINIMO DE CARACTERES = 3");
				} else {
					nomeE = true;
				}

			} catch (Exception e) {

			}
		}

		String senha = sc.next();
		boolean senhaE = false;
		while (senhaE == false) {
			System.out.println("Digite uma senha:");
			try {
				senha = sc.next();
				if (senha.length() < 6) {
					System.err.println("MINIMO 6");
				}
				if (senha.equalsIgnoreCase(nome)) {
					System.err.println("NOME E SENHA NÂO PODEM SER IGUAIS");
				} else {
					senhaE = true;
				}
			} catch (Exception e) {
			}
		}

		String newSenha = "";
		boolean nsenhaE = false;
		while (nsenhaE == false) {
			System.out.println("Digite a nova senha:");
			try {
				newSenha = sc.next();
				if (newSenha.length() < 6) {
					System.err.println("MINIMO 6");
				}
				if (newSenha.equalsIgnoreCase(senha) && newSenha.equalsIgnoreCase(nome)) {
					System.err.println("NOME E SENHA NÂO PODEM SER IGUAIS");
				} else {
					senhaE = true;
				}
			} catch (Exception e) {
			}
		}
		gs.novaSenha(nome, senha, newSenha);
	}

}