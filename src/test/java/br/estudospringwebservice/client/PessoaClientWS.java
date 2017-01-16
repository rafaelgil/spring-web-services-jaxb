package br.estudospringwebservice.client;

import org.estudospringwebservice.pessoa.schema.beans.PessoasRequest;
import org.estudospringwebservice.pessoa.schema.beans.PessoasResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.WebServiceTemplate;

import br.estudospringwebservice.ws.PessoaService;

@Component
public class PessoaClientWS implements PessoaService {

	@Autowired
	private WebServiceTemplate wsTemplate;

	public PessoasResponse getPessoas(PessoasRequest request) {
		PessoasResponse pessoasResponse = (PessoasResponse) wsTemplate.marshalSendAndReceive(request);

		return pessoasResponse;
	}

}
