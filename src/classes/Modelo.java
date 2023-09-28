package classes;

public class Modelo {

	private String codigo;
	private String descricao;
	private String marca;
	private String tipo;
	private int marchas;
	private int ano;

	public Modelo() {

	}

	public Modelo(String codigo, String descricao, String marca, String tipo, int marchas, int ano) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
		this.marca = marca;
		this.tipo = tipo;
		this.marchas = marchas;
		this.ano = ano;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getMarca() {
		return marca;
	}

	public String getTipo() {
		return tipo;
	}

	public int getMarchas() {
		return marchas;
	}

	public int getAno() {
		return ano;
	}

	@Override
	public String toString() {
		return "Código: " + getCodigo() + " | " + "Ano: " + getAno() + " | " + "Marca: " + getMarca() + " | " + "Tipo: "
				+ getTipo() + " | " + "Marchas: " + getMarchas() + " | " + "Descrição: " + getDescricao();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof Modelo) {
			Modelo modelo = (Modelo) obj;
			return getCodigo().equals(modelo.getCodigo());
		}
		return super.equals(obj);
	}
}