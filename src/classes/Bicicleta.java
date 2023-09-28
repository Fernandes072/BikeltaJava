package classes;

public class Bicicleta {

	private String codigo;
	private Modelo modelo;
	private String numeroSerie;
	private String estacao;
	private Usuario usuario;

	public Bicicleta(String codigo, Modelo modelo, String numeroSerie, String estacao) {
		this.codigo = codigo;
		this.modelo = modelo;
		this.numeroSerie = numeroSerie;
		this.estacao = estacao;
	}

	public String getCodigo() {
		return codigo;
	}

	public Modelo getModelo() {
		return modelo;
	}

	public String getNumeroSerie() {
		return numeroSerie;
	}

	public String getEstacao() {
		return estacao;
	}

	public void setEstacao(String estacao) {
		this.estacao = estacao;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("Código: " + getCodigo() + " | ");
		if (estacao != null) {
			sb.append("Estação: " + getEstacao());
		} else {
			sb.append("Usuário: " + usuario);
		}
		return sb.toString();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof Bicicleta) {
			Bicicleta bicicleta = (Bicicleta) obj;
			return getCodigo().equals(bicicleta.getCodigo());
		}
		return super.equals(obj);
	}
}
