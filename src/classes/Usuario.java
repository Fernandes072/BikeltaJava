package classes;

import java.util.ArrayList;
import java.util.Collection;

public abstract class Usuario {

	private String codigo;
	private Tipo tipo;
	private String nome;
	private Collection<Emprestimo> emprestimosAtivos = new ArrayList<Emprestimo>();
	private Collection<Emprestimo> emprestimosFinalizados = new ArrayList<Emprestimo>();

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

	public Collection<Emprestimo> getEmprestimosAtivos() {
		return emprestimosAtivos;
	}
	
	public Collection<Emprestimo> getEmprestimosFinalizados() {
		return emprestimosFinalizados;
	}
	
	protected void adicionaEmprestimo(Emprestimo emprestimo) {
		emprestimosAtivos.add(emprestimo);
	}
	
	protected void removeEmprestimo(Emprestimo emprestimo) {
		emprestimosAtivos.remove(emprestimo);
		emprestimosFinalizados.add(emprestimo);
	}

	@Override
	public String toString() {
		return "Código: " + getCodigo() + " / " + "Tipo: " + getTipo() + " / " + "Nome: " + getNome();
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
