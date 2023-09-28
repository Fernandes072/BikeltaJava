package classes;

public class Individual extends Usuario {

	public Individual(String codigo, Tipo tipo, String nome) {
		super(codigo, tipo, nome);
	}

	public void emprestimo(Usuario usuario, Bicicleta bicicleta) {

		if (getEmprestimos().size() == 1) {
			throw new RuntimeException("Erro: Limite de empréstimos atingido");
		}

		// implementar condição da reserva

		System.out.println(bicicleta.getModelo());
		System.out.println(usuario);
		bicicleta.setUsuario(usuario);
		bicicleta.setEstacao(null);
		usuario.adicionaEmprestimo(bicicleta);

		/*
		 * for (Bicicleta bicicleta : bicicletas) { if
		 * (bicicleta.getCodigo().equals(dados[1])) { for (Usuario usuario : usuarios) {
		 * if (usuario.getCodigo().equals(dados[3])) {
		 * System.out.println(bicicleta.getModelo()); System.out.println(usuario);
		 * bicicleta.setUsuario(usuario); bicicleta.setEstacao(null);
		 * usuario.adicionaEmprestimo(bicicleta); } } } }
		 */

		System.out.println("Operação finalizada: Empréstimo realizado com sucesso.");
	}
}
