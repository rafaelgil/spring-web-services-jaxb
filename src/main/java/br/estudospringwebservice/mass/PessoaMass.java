package br.estudospringwebservice.mass;

import java.util.ArrayList;
import java.util.List;

import org.estudospringwebservice.pessoa.schema.beans.Pessoa;

public class PessoaMass {
	
	public static List<Pessoa> createListaPessoas(){
		
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		
		pessoas.add(new Pessoa().withId(1).withNome("Ana").withSobrenome("Montanna"));
		pessoas.add(new Pessoa().withId(2).withNome("Pedro").withSobrenome("Junior"));
		pessoas.add(new Pessoa().withId(3).withNome("Miguel").withSobrenome("Carneiro"));
		pessoas.add(new Pessoa().withId(4).withNome("Paulo").withSobrenome("Tonelli"));
		pessoas.add(new Pessoa().withId(5).withNome("Jose").withSobrenome("Machado"));
		pessoas.add(new Pessoa().withId(6).withNome("Fabio").withSobrenome("Araujo"));
		pessoas.add(new Pessoa().withId(7).withNome("Fernando").withSobrenome("Sessa"));
		pessoas.add(new Pessoa().withId(8).withNome("Carlos").withSobrenome("Barth"));
			
		return pessoas;
	}
	
}
