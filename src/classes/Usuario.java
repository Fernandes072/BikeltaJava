package classes;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

public abstract class Usuario {

	private String codigo;
	private Tipo tipo;
	private String nome;
	private Collection<Emprestimo> emprestimosAtivos = new ArrayList<Emprestimo>();
	private Collection<Emprestimo> emprestimosFinalizados = new ArrayList<Emprestimo>();
	private Collection<Reserva> reservas = new ArrayList<Reserva>();

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
	
	public Collection<Reserva> getReservas() {
		return reservas;
	}

	protected void adicionaEmprestimo(Emprestimo emprestimo) {
		emprestimosAtivos.add(emprestimo);
	}
	
	protected void removeEmprestimo(Emprestimo emprestimo) {
		emprestimosAtivos.remove(emprestimo);
		emprestimosFinalizados.add(emprestimo);
	}
	
	protected void removeReserva(Reserva reserva) {
		reservas.remove(reserva);
	}
	
	public void adicionaReserva(Modelo modelo) {
		if (reservas.size() == 2) {
			throw new RuntimeException("Erro: Limite de reservas atingido.");
		}
		reservas.add(new Reserva(modelo, LocalDateTime.now()));
		System.out.println("Operação finalizada: Reserva realizada com sucesso.");
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
