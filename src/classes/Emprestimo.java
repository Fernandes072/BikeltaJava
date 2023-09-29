package classes;

import java.time.LocalDateTime;

public class Emprestimo {
	
	private Bicicleta bicicleta;
	private LocalDateTime dataEmprestimo;
	private LocalDateTime dataDevolucao;
	
	public Emprestimo() {
		
	}

	public Emprestimo(Bicicleta bicicleta, LocalDateTime dataEmprestimo, LocalDateTime dataDevolucao) {
		this.bicicleta = bicicleta;
		this.dataEmprestimo = dataEmprestimo;
		this.dataDevolucao = dataDevolucao;
	}

	public LocalDateTime getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(LocalDateTime dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

	public Bicicleta getBicicleta() {
		return bicicleta;
	}

	public LocalDateTime getDataEmprestimo() {
		return dataEmprestimo;
	}
}
