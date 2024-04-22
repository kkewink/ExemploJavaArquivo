package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import models.Produto;

public class GerenciadorDeProdutos {

	private static final String NOME_ARQUIVO = "produtos.txt";

	// Verificar a existencia do nosso branco e criar caso não exista
	public void verificaECria(String nomeArquivo) {
		// file => arquivo
		File arquivo = new File(nomeArquivo);
		// Verificar se o arqvui existe
		if (arquivo.exists()) {
			System.out.println("Banco funcionando!");
		} else {
			// tent criar, caso de erro, exibir o erro
			try {
				// Criar o novo arquivo
				arquivo.createNewFile();
				System.out.println("Arquivo criado com sucesso!");
			} catch (IOException e) {
				System.err.println("Ocorreu um erro ao criar o arquivo: " + e.getMessage());
			}
		}
	}

	public void adicionarProduto(Produto produto) {
		// Writer => Escrever
		// BuffereWriter , FileWriter
		// BufferredWriter , proporciona uma eficiente escrita
		// FileWriter , escreva dentro de arquivo
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(NOME_ARQUIVO, true))) {
			bw.write(produto.toString()); // 1;Ernesto;123456
			bw.newLine(); // nova linha do arquivo.txt
			System.out.println("Produto adicionado com sucesso!");
		} catch (IOException e) {
			System.err.println("Ocorreu um erro ao criar o arquivo: " + e.getMessage());
		}
	}

	public List<Produto> lerProduto() {
		List<Produto> produtos = new ArrayList<Produto>();
		// Buffed, File, Reader
		try (BufferedReader br = new BufferedReader(new FileReader(NOME_ARQUIVO))) {
			String linha; // linha => 1;nome;senha
			// percorrer todas as linhas enquanto seja diferente de vazio
			while ((linha = br.readLine()) != null) {
				String[] partes = linha.split(";"); // Dividir em tres partes
				produtos.add(new Produto(Integer.parseInt(partes[0]), partes[1], Double.parseDouble(partes[2]),
						Integer.parseInt(partes[3])));
			}
		} catch (IOException e) {
			System.err.println("Ocorreu um erro ao ler o arquivo: " + e.getMessage());
		}
		return produtos;
	}

	public void reescreverArquivo(List<Produto> produtos) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(NOME_ARQUIVO))) {
			for (Produto produto : produtos) {
				bw.write(produto.toString());
				bw.newLine();
			}
		} catch (IOException e) {
			System.out.println("Ocurreu um erro ao reescrever o arquivo: " + e.getMessage());
		}
	}

	public void editarProduto(long idP, String novoNome, double novoPreco, int novaquantidade) {
		List<Produto> produtos = lerProduto();
		boolean encontrado = false;

		for (Produto produto : produtos) {
			if (produto.getIdP() == idP) {
				produto.setNome(novoNome);
				produto.setPreco(novoPreco);
				produto.setQuantidade(novaquantidade);
				reescreverArquivo(produtos);
				System.out.println("Produto editado com sucesso!");
				encontrado = true;
			}
		}
		if (!encontrado) {
			System.out.println("Produto não encontrado");

		}
	}

	public void deletarProduto(long idP) {
		List<Produto> produtos = lerProduto();

		if (produtos.removeIf(produto -> produto.getIdP() == idP)) {
			reescreverArquivo(produtos);
			System.out.println("Produto deletado com sucesso");
		} else {
			System.out.println("Produto não encontrado");
		}
	}

	public void listarProdutos() {
		List<Produto> produtos = lerProduto();

		if (produtos.isEmpty()) {
			System.err.println("Nenhum produto cadastrado");
		} else {
			System.out.println("Lista dos Produtos");
			for (Produto produto : produtos) {
				System.out.println("ID: " + produto.getIdP() + "| Nome: " + produto.getNome() + "| Preço: "
						+ produto.getPreco() + "| Quantidade: " + produto.getQuantidade());

			}
		}

	}

	public void produtoUnico(long idP) {
		List<Produto> produtos = lerProduto();
		boolean encontrado = false;
		for (Produto produto : produtos) {
			if (produto.getIdP() == idP) {
				System.out.println("ID: " + produto.getIdP() + "| Nome: " + produto.getNome() + "| Preço: "
						+ produto.getPreco() + "| Quantidade: " + produto.getQuantidade());
				encontrado = true;

			}

		}
		if (encontrado == false) {
			System.out.println("Produto nao encontrado");
		}
	}

	public void custoTotal() {
		List<Produto> produtos = lerProduto();
		double custo = 0;
		for (Produto produto : produtos) {
			custo += produto.getPreco()* produto.getQuantidade();
		}
		 System.out.println(custo);
	}
	public void totalProduto() {
		List<Produto> produtos = lerProduto();
		int total = 0;
		for(Produto produto : produtos) {
			total += produto.getQuantidade();
		}
		System.out.println(total);
	}

}
