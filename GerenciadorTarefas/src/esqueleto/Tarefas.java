package esqueleto;

public class Tarefas {
	
	String status;
	String descricao;
	String titulo;

	public void setStatus(String novoStatus) {
        this.status = novoStatus;
    }

	public String getStatus() {
		return this.status;
	}
	
	public void setTitulo(String novoTitulo) {
        this.titulo = novoTitulo;
    }

	public String getTitulo() {
		return this.titulo;
	}
	
	public void setDescricao(String novaDescricao) {
        this.descricao = novaDescricao;
    }

	public String getDescricao() {
		return this.descricao;
	}
	
	@Override
	public String toString() { 
		return "Titulo - " + titulo + "\nDescricao - " + descricao + "\nStatus - " + status; // Quando o usuário optar por listar as moedas, isso será mostrado na tela
	}

}
