package sistema;

import java.util.Scanner;
import service.HandleMenu;
import service.HandleMenuP;

public class Sistema {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		int opcaoM = 0;
		int escolhaU = 0;
		int escolhaP = 0;
		
		do {
			System.out.println("Banco de Dados\n1 - Usuarios \n2 - Produto \n9 - Sair");

			opcaoM = sc.nextInt();
			switch(opcaoM) {
			case 1:{
				HandleMenu hm = new HandleMenu();
				do {
					
					System.out.println("Bando de Dados Usuarios\n1 - Criar \n2 - Editar \n3 - Deletar\n4 - Listar\n5 - Dado Unico \n6 - Login\n7 - Trocar Senha \n9 - Sair");
					escolhaU = sc.nextInt();
					switch(escolhaU) {
					case 1:{
						hm.criar();
						break;
					}
					case 2: {
						hm.editar();
						break;
					}
					case 3:{
						hm.deletar();
						break;
					}
					case 4:{
						hm.listar();
						break;
					}
					case 5:{
						hm.dadoUnico();
						break;
					}
					case 6:{
						hm.login();
						break;
					}
					case 7:{
						hm.trocarSenha();
						break;
					}
					case 9: {
						break;
					}
					default:
						System.out.println("");
						break;
					}
					
				}while(escolhaU != 9);
				break;
			}
			case 2:{
				HandleMenuP hmp = new HandleMenuP();
				do {
					
					System.out.println("Bando de Dados Produto\n1 - Criar \n2 - Editar \n3 - Deletar\n4 - Listar\n5 - Dado Unico \n6 - Custo total \n7- Total de produtos\n9 - Sair");
					escolhaP = sc.nextInt();
					
					switch(escolhaP ) {
					case 1:{
						hmp.criarP();
						break;
					}
					case 2:{
						hmp.editarProduto();
						break;
					}
					case 3:{
						hmp.deletaProduto();
						break;
					}
					case 4:{
						hmp.listarProdutos();
						break;
					}
					case 5:{
						hmp.produtoUnico();
						break;
					}
					case 6:{
						hmp.custoTotal();
						break;
					}
					case 7:{
						hmp.totalProduto();
						break;
					}
					case 9: {
						break;
					}
					default:
						System.out.println("");
						break;
					}
					
				}while(escolhaP != 9);
				
			}
			}		
		
		}while(opcaoM != 9);
	
	
	
		
	}

}
