package classes;

import java.util.ArrayList;
import java.util.Collection;

public abstract class Usuario {

	private String codigo;
	private Tipo tipo;
	private String nome;
	private Collection<Bicicleta> emprestimos = new ArrayList<Bicicleta>();

	public Usuario() {

	}

	public Usuario(String codigo, Tipo tipo, String nome) {
		this.codigo = codigo;
		this.tipo = tipo;
		this.nome = nome;
	}

	public String getCodigo() {
		return codigo;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Collection<Bicicleta> getEmprestimos() {
		return emprestimos;
	}
	
	protected void adicionaEmprestimo(Bicicleta bicicleta) {
		emprestimos.add(bicicleta);
	}

	@Override
	public String toString() {
		return getCodigo() + " " + getTipo() + " " + getNome();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof Usuario) {
			Usuario usuario = (Usuario) obj;
			return getCodigo().equals(usuario.getCodigo());
		}
		return false;
	}
}
