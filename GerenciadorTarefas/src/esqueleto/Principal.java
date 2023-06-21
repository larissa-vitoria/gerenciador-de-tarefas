package esqueleto;

import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;

public class Principal {
	
	public Scanner scan;
	
	public static void main(String[] args) {
		
		try (Scanner teclado = new Scanner (System.in)) {
			
			Gerenciador gerenciador = new Gerenciador();
			Tarefas tarefa = new Tarefas();
			int opcaoMenu;
			String vencimentoString;
			
			System.out.println("Bem-vindo! Digite uma das opcoes: ");
			System.out.println("1 - Criar nova tarefa");
			System.out.println("2 - Listar tarefas");
			System.out.println("3 - Remover tarefa");
			System.out.println("0 - Sair");
			opcaoMenu = teclado.nextInt(); // o próximo valor inteiro digitado será a opção
			
			while(opcaoMenu !=0) {// quando o valor digitado for 0, o programa será encerrado
				
				switch(opcaoMenu) {
				
				case 1:
					
					System.out.println("Digite o titulo da nova tarefa: ");
					tarefa.setTitulo(teclado.next());
					
					teclado.nextLine();
					
					System.out.println("Digite a descricao da tarefa: ");
					tarefa.setDescricao(teclado.nextLine());
					
					System.out.println("Defina a data de vencimento da tarefa (dd/MM/yyyy): ");
					vencimentoString = teclado.nextLine();
					
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // formata a data
					
					try {
						
						LocalDate dataVencimento = LocalDate.parse(vencimentoString, formatter);
						LocalDate dataAtual = LocalDate.now();
						
						if (dataVencimento.isBefore(dataAtual)) {
							tarefa.setStatus("Vencido");
			            } 
						
						else if (dataVencimento.isEqual(dataAtual)) {
							tarefa.setStatus("Vence hoje");
			            } 
						
						else {
							tarefa.setStatus("Não-vencido");
			            }
						
						String status = tarefa.getStatus();
						System.out.println("Status da tarefa: " + status);
						
			        } 
					
					catch (Exception e) {
			            System.out.println("Formato de data inválido. Certifique-se de usar o formato dd/MM/yyyy.");
			        }
					
					gerenciador.criar(tarefa);
					
					break;
					
				case 2:
					
					gerenciador.listagemTarefas();
					break;
				
				case 3:
					
					
					System.out.println("Digite o titulo da tarefa a ser removida: ");
				    String tituloRemover = teclado.next();
				    Tarefas tarefaRemover = gerenciador.buscarTarefaPorTitulo(tituloRemover);
				    if (tarefaRemover != null) {
				        gerenciador.remover(tarefaRemover);
				        System.out.println("Tarefa removida com sucesso!");
				    } else {
				        System.out.println("Tarefa nao encontrada!");
				    }
				    break;
					
				default: 
					
					System.out.println("Opcao invalida. Tente novamente."); 
					System.out.println();
				}
				
				System.out.println("Bem-vindo! Digite uma das opcoes: ");
				System.out.println("1 - Criar nova tarefa");
				System.out.println("2 - Listar tarefas");
				System.out.println("3 - Remover tarefa");
				System.out.println("0 - Sair");
				opcaoMenu = teclado.nextInt();
			}
		}
		System.out.println("Obrigada por usar nosso sistema! :) ");
	}
	
}
