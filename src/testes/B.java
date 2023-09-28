package testes;

import java.util.ArrayList;
import java.util.Collection;

import classes.Bicicleta;
import classes.Modelo;

public class B {

	public static void main(String[] args) {
		
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
		
		for (Bicicleta bicicleta:bicicletas) {
			System.out.println(bicicleta);
		}

	}

}