package esqueleto;

import java.util.ArrayList;

public class Gerenciador {

	private ArrayList<Tarefas> listaTarefas = new ArrayList<Tarefas>(); // cria a lista de tarefas
	
	public void criar (Tarefas adic) {
		getListaTarefas().add(adic);  // adiciona o objeto à lista
	}
	
	public void remover (Tarefas adic) {
		getListaTarefas().remove(adic); // remove o objeto da lista
	}
	
	public void listagemTarefas () {
		
		for (Tarefas adic : getListaTarefas()) { // para cada objeto dentro da lista de tarefas, o seguinte será aplicado
			System.out.println(adic); // o objeto é impresso
		}
	}
	
	public Tarefas buscarTarefaPorTitulo(String titulo) {
	    for (Tarefas tarefa : getListaTarefas()) {
	        if (tarefa.getTitulo().equals(titulo)) {
	            return tarefa;
	        }
	    }
	    return null; // Retorna null se a tarefa não for encontrada
	}

	private ArrayList<Tarefas> getListaTarefas() {
		return listaTarefas;
	}	
}
