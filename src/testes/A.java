package testes;

import java.time.LocalDateTime;
import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		
		LocalDateTime emprestimo = LocalDateTime.now();
		System.out.println(emprestimo.plusHours(5));

	}

}
