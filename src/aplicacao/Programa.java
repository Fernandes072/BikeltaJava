package aplicacao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

import classes.Bicicleta;
import classes.Corporativo;
import classes.Individual;
import classes.Modelo;
import classes.Tipo;
import classes.Usuario;

public class Programa {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Collection<Usuario> usuarios = new ArrayList<Usuario>();

		Collection<Modelo> modelos = new ArrayList<Modelo>();
		Modelo M01 = new Modelo("M01", "Caloi Vulcan Aro 29 com 21 Velocidades", "Caloi", "Comum", 21, 2021);
		modelos.add(M01);
		Modelo M02 = new Modelo("M02", "Caloi E-Vibe City", "Caloi", "Elétrica", 0, 2020);
		modelos.add(M02);
		Modelo M03 = new Modelo("M03", "Sense Bike Impulse E Trail Comp 2021/22", "Sense", "Elétrica", 0, 2022);
		modelos.add(M03);
		Modelo M04 = new Modelo("M04", "MTB KLS Sport Gold Aro 29 Freio Disco 21 Marchas", "KLS", "Comum", 21, 2019);
		modelos.add(M04);

		Collection<Bicicleta> bicicletas = new ArrayList<Bicicleta>();
		bicicletas.add(new Bicicleta("B001", M01, "C3C00010", "E01"));
		bicicletas.add(new Bicicleta("B002", M01, "C3C00018", "E02"));
		bicicletas.add(new Bicicleta("B003", M02, "C1E00002", "E01"));
		bicicletas.add(new Bicicleta("B004", M02, "C1E00027", "E02"));
		bicicletas.add(new Bicicleta("B005", M03, "S5E000010", "E01"));
		bicicletas.add(new Bicicleta("B006", M03, "S5E000011", "E02"));
		bicicletas.add(new Bicicleta("B007", M04, "K11C00046", "E01"));
		bicicletas.add(new Bicicleta("B008", M04, "K11C00057", "E02"));

		System.out.println("+----------------------------------------------------+");
		System.out.println("|              ---- Sistema Bikelta ----             |");
		System.out.println("+----------------------------------------------------+");
		exibirMenu();
		String operacao = sc.nextLine();
		while (!operacao.equals("fim")) {
			String[] dados = operacao.split(" ");
			try {

				if (dados[0].equals("")) {
					throw new RuntimeException("Erro: Nenhuma informação digitada.");
				}

				if (dados[0].equals("cdu")) {
					if (dados.length < 4) {
						throw new RuntimeException("Erro: Informações insuficientes para cadastro.");
					}
					if (dados[1].equals("<a>")) {
						cadastrarUsuario(dados, usuarios);
					} else if (dados[1].equals("<u>")) {
						atualizarUsuario(dados, usuarios);
					} else {
						throw new RuntimeException("Erro: Opções para cdu são <a> ou <u>.");
					}
				} else if (dados[0].equals("emp")) {
					if (dados.length < 4) {
						throw new RuntimeException("Erro: Informações insuficientes para empréstimo.");
					}
					emprestarBicicleta(dados, bicicletas, usuarios);
				} else if (dados[0].equals("bik")) {
					if (dados.length < 2) {
						throw new RuntimeException("Erro: Informações insuficientes para informações do modelo.");
					}
					consultaBicicleta(dados, bicicletas, modelos);
				} else if (dados[0].equals("lis")) {
					for (Usuario usuario : usuarios) {
						System.out.println(usuario);
					}
				} else {
					throw new RuntimeException("Erro: Operação inválida.");
				}

			} catch (Exception e) {
				System.out.println(e.getMessage());
			} finally {
				exibirMenu();
				operacao = sc.nextLine();
			}
		}
		System.out.println();
		System.out.println("Sistema finalizado");
		sc.close();
	}

	private static void cadastrarUsuario(String[] dados, Collection<Usuario> usuarios) {
		String codigo = dados[2];
		for (Usuario usuario : usuarios) {
			if (usuario.getCodigo().equals(codigo)) {
				throw new RuntimeException("Erro: Usuário já existe.");
			}
		}

		Tipo tipo;
		if (dados[3].equals("ind")) {
			tipo = Tipo.IND;
		} else if (dados[3].equals("coo")) {
			tipo = Tipo.COO;
		} else {
			throw new RuntimeException("Erro: Tipo de usuário inválido.");
		}

		String nome = "";
		for (int i = 4; i < dados.length; i++) {
			if (i > 4) {
				nome += " ";
			}
			nome += dados[i];
		}
		Usuario usuario;
		if (tipo == Tipo.IND) {
			usuario = new Individual(codigo, tipo, nome);
		} else {
			usuario = new Corporativo(codigo, tipo, nome);
		}

		usuarios.add(usuario);
		System.out.println("Operação finalizada: Usuário cadastrado com sucesso.");
	}

	private static void atualizarUsuario(String[] dados, Collection<Usuario> usuarios) {
		String codigo = dados[2];
		Usuario copiaUsuario = null;
		boolean usuarioExiste = false;
		for (Usuario usuario : usuarios) {
			if (usuario.getCodigo().equals(codigo)) {
				usuarioExiste = true;
				copiaUsuario = usuario;
			}
		}
		if (!usuarioExiste) {
			throw new RuntimeException("Erro: Usuário não existe.");
		}

		Tipo tipo;
		if (dados[3].equals("ind")) {
			tipo = Tipo.IND;
		} else if (dados[3].equals("coo")) {
			tipo = Tipo.COO;
		} else {
			throw new RuntimeException("Erro: Tipo de usuário inválido.");
		}

		String nome = "";
		for (int i = 4; i < dados.length; i++) {
			if (i > 4) {
				nome += " ";
			}
			nome += dados[i];
		}

		copiaUsuario.setTipo(tipo);
		copiaUsuario.setNome(nome);
		if (tipo == Tipo.IND) {
			copiaUsuario = (Individual) copiaUsuario;
		} else {
			copiaUsuario = (Corporativo) copiaUsuario;
		}
		System.out.println("Operação finalizada: Usuário atualizado com sucesso.");
	}

	private static void emprestarBicicleta(String[] dados, Collection<Bicicleta> bicicletas,
			Collection<Usuario> usuarios) {
		boolean bicicletaExiste = false;
		boolean bicicletaDisponivel = false;
		for (Bicicleta bicicleta : bicicletas) {
			if (bicicleta.getCodigo().equals(dados[1])) {
				bicicletaExiste = true;
				if (bicicleta.getEstacao() != null) {
					if (bicicleta.getEstacao().equals(dados[2])) {
						bicicletaDisponivel = true;
					}
				}
			}
		}
		if (!bicicletaExiste) {
			throw new RuntimeException("Erro: Código de bicicleta inválido.");
		}

		if (!(dados[2].equals("E01") || dados[2].equals("E02"))) {
			throw new RuntimeException("Erro: Código de estação inválido.");
		}

		boolean usuarioExiste = false;
		for (Usuario usuario : usuarios) {
			if (usuario.getCodigo().equals(dados[3])) {
				usuarioExiste = true;
			}
		}
		if (!usuarioExiste) {
			throw new RuntimeException("Erro: Código de usuário inválido.");
		}

		if (!bicicletaDisponivel) {
			throw new RuntimeException("Erro: Bicicleta indisponível na estação.");
		}

		for (Bicicleta bicicleta : bicicletas) {
			if (bicicleta.getCodigo().equals(dados[1])) {
				for (Usuario usuario : usuarios) {
					if (usuario.getCodigo().equals(dados[3])) {
						if (usuario instanceof Individual) {
							((Individual) usuario).emprestimo(usuario, bicicleta);
						}
					}
				}
			}
		}

	}

	private static void consultaBicicleta(String[] dados, Collection<Bicicleta> bicicletas,
			Collection<Modelo> modelos) {
		if (dados[1].equals("*")) {
			for (Modelo modelo : modelos) {
				System.out.println(modelo);
			}
		} else {
			boolean modeloExiste = false;
			for (Bicicleta bicicleta : bicicletas) {
				if (bicicleta.getModelo().getCodigo().equals(dados[1])) {
					System.out.println(bicicleta);
					modeloExiste = true;
				}
			}
			if (!modeloExiste) {
				throw new RuntimeException("Erro: Modelo de bicicleta inválido.");
			}
		}

	}

	private static void exibirMenu() {
		System.out.println();
		System.out.println();
		System.out.println("+----------------------------------------------------+");
		System.out.println("|              ---- Menu de opções ----              |");
		System.out.println("+----------------------------------------------------+");
		System.out.println("|    Cadastro de usuário: cdu <a> U001 ind O Corisco |");
		System.out.println("| Atualização de usuário: cdu <u> U001 coo O CORISCO |");
		System.out.println("|             Empréstimo: emb B001 E01 U001          |");
		System.out.println("|              Devolução: dev B001 E02 U001          |");
		System.out.println("|                Reserva: res M01 U002               |");
		System.out.println("| Consulta de bicicletas: bik *                      |");
		System.out.println("|     Consulta de modelo: bik M01                    |");
		System.out.println("|    Consulta de usuário: usu U001                   |");
		System.out.println("|                   Sair: fim                        |");
		System.out.println("+----------------------------------------------------+");
		System.out.print("Operação: ");
	}

}
