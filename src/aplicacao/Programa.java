package aplicacao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

import classes.Tipo;
import classes.Usuario;

public class Programa {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Collection<Usuario> usuarios = new ArrayList<Usuario>();

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
					if (dados.length < 2) {
						throw new RuntimeException("Erro: Informações insuficientes para cadastro.");
					}
					if (dados[1].equals("<a>")) {
						cadastrarUsuario(dados, usuarios);
					} else if (dados[1].equals("<u>")) {
						atualizarUsuario(dados, usuarios);
					} else {
						throw new RuntimeException("Erro: Opções para cdu são <a> ou <u>.");
					}
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

		usuarios.add(new Usuario(codigo, tipo, nome));
		System.out.println("Operação finalizada: Usuário cadastrado com sucesso.");
	}

	private static void atualizarUsuario(String[] dados, Collection<Usuario> usuarios) {
		String codigo = dados[2];
		Usuario copiaUsuario = new Usuario();
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
		System.out.println("Operação finalizada: Usuário atualizado com sucesso.");
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
