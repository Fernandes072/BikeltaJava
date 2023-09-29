package classes;

import java.time.LocalDateTime;

public class Individual extends Usuario {

	public Individual(String codigo, Tipo tipo, String nome) {
		super(codigo, tipo, nome);
	}

	public void emprestimo(Usuario usuario, Bicicleta bicicleta) {

		if (getEmprestimosAtivos().size() == 1) {
			throw new RuntimeException("Erro: Limite de empréstimos atingido.");
		}

		// implementar condição da reserva

		System.out.println(bicicleta.getModelo());
		System.out.println(usuario);
		bicicleta.setUsuario(usuario);
		bicicleta.setEstacao(null);
		
		usuario.adicionaEmprestimo(new Emprestimo(bicicleta, LocalDateTime.now(),LocalDateTime.now().plusHours(1)));
		System.out.println("Operação finalizada: Empréstimo realizado com sucesso.");
	}
	
	public void devolucao(Emprestimo emprestimo, String estacao) {

		System.out.println(emprestimo.getBicicleta().getModelo());
		System.out.println(emprestimo.getBicicleta().getUsuario());
		
		emprestimo.setDataDevolucao(LocalDateTime.now());
		emprestimo.getBicicleta().getUsuario().removeEmprestimo(emprestimo);
		emprestimo.getBicicleta().setUsuario(null);
		emprestimo.getBicicleta().setEstacao(estacao);
		System.out.println("Operação finalizada: Devolução realizada com sucesso.");
	}
}
