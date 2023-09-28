package classes;

public class Corporativo extends Usuario {

	public Corporativo(String codigo, Tipo tipo, String nome) {
		super(codigo, tipo, nome);
	}

	/*
	 * public void emprestimo() { if (getEmprestimos().size() == 1) { throw new
	 * RuntimeException("Erro: Limite de empréstimos atingido"); } }
	 */

}
