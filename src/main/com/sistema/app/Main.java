package main.com.sistema.app;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import main.com.sistema.arvore.ArvoreAVL;
import main.com.sistema.dominio.Acessorio;
import main.com.sistema.dominio.Produto;
import main.com.sistema.dominio.Roupa;
import main.com.sistema.ordenacao.MergeSort;
import main.com.sistema.repositorio.RepositorioAcessorio;
import main.com.sistema.repositorio.RepositorioRoupa;


public class Main {

    public static void imprimirOpcoes(){
        System.out.println("Digite 1 para CADASTRAR/CRIAR um Acessório.");
        System.out.println("Digite 2 para CADASTRAR/CRIAR uma Roupa.");
        System.out.println("Digite 3 para LISTAR Acessórios por preço.");
        System.out.println("Digite 4 para BUSCAR um Acessório.");
        System.out.println("Digite 5 para REMOVER um Acessório.");
        System.out.println("Digite 6 para LISTAR Roupas por preço.");
        System.out.println("Digite 7 para BUSCAR uma Roupa.");
        System.out.println("Digite 8 para REMOVER uma Roupa.");
        System.out.println("Digite 9 para LISTAR todos os produtos por preço."); //Uso da árvore
        System.out.println("Digite 0 para finalizar cadastros.");
    }

    public static void cadastrarAcessorio(Scanner scanner, RepositorioAcessorio repositorioAcessorio, ArvoreAVL<Double, Produto> arvore) {
        System.out.println("Digite o ID do Acessório:");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Digite o Nome do Acessório:");
        String nome = scanner.nextLine();
        System.out.println("Digite o Preço do Acessório.");
        double preco = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Digite a Categoria do Acessório.");
        String categoria = scanner.nextLine();
        System.out.println("Digite o Material do Acessório.");
        String material = scanner.nextLine();
        System.out.println("Digite a Cor do Acessório.");
        String cor = scanner.nextLine();

        Acessorio acessorio = new Acessorio(id, nome, preco, categoria, material, cor);
        repositorioAcessorio.adicionar(acessorio);
        arvore.inserir(acessorio.getPreco(), acessorio);

        System.out.println("Acessório" + acessorio.getNome() + ", adicionado com sucesso!");
    }

    public static void cadastrarRoupa(Scanner scanner, RepositorioRoupa repositorioRoupa, ArvoreAVL<Double, Produto> arvore) {
        System.out.println("Digite o ID da Roupa:");
        int id = scanner.nextInt();
        System.out.println("Digite o Nome da Roupa:");
        String nome = scanner.nextLine();
        System.out.println("Digite o Preço da Roupa.");
        double preco = scanner.nextDouble();
        System.out.println("Digite a Categoria da Roupa.");
        String categoria = scanner.nextLine();
        System.out.println("Digite a Tamanho da Roupa.");
        String tamanho = scanner.nextLine();
        System.out.println("Digite o Material da Roupa.");
        String material = scanner.nextLine();
        System.out.println("Digite a Cor da Roupa.");
        String cor = scanner.nextLine();

        Roupa roupa = new Roupa(id, nome, preco, categoria, tamanho, material, cor);
        repositorioRoupa.adicionar(roupa);
        arvore.inserir(roupa.getPreco(), roupa);

        System.out.println("Roupa" + roupa.getNome() + ", adicionada com sucesso!");

    }

    public static void listarAcessorios(RepositorioAcessorio repositorioAcessorio){
        Comparator<Acessorio> porPreco = Comparator.comparingDouble(p -> p.getPreco());
        List<Acessorio> acessoriosOrdenados = MergeSort.mergeSort(repositorioAcessorio.listar(), porPreco);
        for(Acessorio acessorio : acessoriosOrdenados){
            System.out.println(acessorio.getNome() + " " + acessorio.getPreco());
        }
    }

    public static void buscarAcessorio(Scanner scanner, RepositorioAcessorio repositorioAcessorio) {
        System.out.println("Digite o número do id:");
        int id = scanner.nextInt();
        Acessorio acessorio = repositorioAcessorio.buscar(id);
        if (acessorio != null) {
            System.out.println("Mostrando informações encontradas:");
            System.out.println(acessorio.getId());
            System.out.println(acessorio.getNome());
            System.out.println(acessorio.getPreco());
            System.out.println(acessorio.getCategoria());
            System.out.println(acessorio.getMaterial());
            System.out.println(acessorio.getCor());
        } else {
            System.out.println("Acessório não encontrado.");
        }

    }

    public static void removerAcessorio(Scanner scanner, RepositorioAcessorio repositorioAcessorio) {
        System.out.println("Digite o número do id:");
        int id = scanner.nextInt();
        Acessorio acessorio = repositorioAcessorio.buscar(id);
        if (acessorio != null){
            repositorioAcessorio.remover(id);
            System.out.println("Acessório removido com sucesso!");
        }
    }

    public static void listarRoupas(RepositorioRoupa repositorioRoupa){
        Comparator<Roupa> porPreco = Comparator.comparingDouble(p -> p.getPreco());
        List<Roupa> roupaOrdenadas = MergeSort.mergeSort(repositorioRoupa.listar(), porPreco);
        for(Roupa roupa : roupaOrdenadas){
            System.out.println(roupa.getNome() + " " + roupa.getPreco());
        }
    }

    public static void buscarRoupa(Scanner scanner, RepositorioRoupa repositorioRoupa) {
        System.out.println("Digite o número do id:");
        int id = scanner.nextInt();
        Roupa roupa = repositorioRoupa.buscar(id);
        if (roupa != null) {
            System.out.println("Mostrando informações encontradas:");
            System.out.println(roupa.getId());
            System.out.println(roupa.getNome());
            System.out.println(roupa.getPreco());
            System.out.println(roupa.getCategoria());
            System.out.println(roupa.getTamanho());
            System.out.println(roupa.getMaterial());
            System.out.println(roupa.getCor());
        } else {
            System.out.println("Roupa não encontrado.");
        }

    }

    public static void removerRoupa(Scanner scanner, RepositorioRoupa repositorioRoupa) {
        System.out.println("Digite o número do id:");
        int id = scanner.nextInt();
        Roupa roupa = repositorioRoupa.buscar(id);
        if (roupa != null){
            repositorioRoupa.remover(id);
            System.out.println("Roupa removida com sucesso!");
        }
    }

    public static void listarProdutos(ArvoreAVL<Double, Produto> arvore) {
        List<Produto> produtos = arvore.emOrdem();
        for(Produto produto : produtos){
            System.out.println(produto.getNome() + " " + produto.getPreco());
        }
    }

    public static void main(String[] args) {
        ArvoreAVL<Double, Produto> arvore = new ArvoreAVL<>();
        RepositorioRoupa repositorioRoupa = new RepositorioRoupa();
        RepositorioAcessorio repositorioAcessorio = new RepositorioAcessorio();
        Scanner scanner = new Scanner(System.in);
        boolean controle = true;
        while(controle == true){
            imprimirOpcoes();
            int opcao = scanner.nextInt();
            scanner.nextLine();
            if (opcao == 1) {
                cadastrarAcessorio(scanner, repositorioAcessorio, arvore);
            } else if (opcao == 2) {
                cadastrarRoupa(scanner, repositorioRoupa, arvore);
            } else if (opcao == 3) {
                listarAcessorios(repositorioAcessorio);
            } else if (opcao == 4) {
                buscarAcessorio(scanner, repositorioAcessorio);
            } else if (opcao == 5) {
                removerAcessorio(scanner, repositorioAcessorio);
            } else if (opcao == 6) {
                listarRoupas(repositorioRoupa);
            } else if (opcao == 7) {
                buscarRoupa(scanner, repositorioRoupa);
            } else if (opcao == 8) {
                removerRoupa(scanner, repositorioRoupa);
            } else if (opcao == 9) {
                listarProdutos(arvore);
            } else if (opcao == 0) {
                controle = false;
                System.out.println("Finalizando cadastros.");
            } else {
                System.out.println("Opção inválida, por favor digite 1 para acessório ou 2 para roupa");
            }
        }
    }


}

