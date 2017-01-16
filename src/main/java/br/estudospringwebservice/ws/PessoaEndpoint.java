package br.estudospringwebservice.ws;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.estudospringwebservice.pessoa.schema.beans.Pessoa;
import org.estudospringwebservice.pessoa.schema.beans.PessoasRequest;
import org.estudospringwebservice.pessoa.schema.beans.PessoasResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import br.estudospringwebservice.mass.PessoaMass;

@Endpoint
public class PessoaEndpoint implements PessoaService {

	private final Logger LOG = LoggerFactory.getLogger(PessoaEndpoint.class);

	@PayloadRoot(localPart = GET_PERSONS_REQUEST, namespace = NAMESPACE)
	@ResponsePayload
	public PessoasResponse getPessoas(@RequestPayload PessoasRequest request) {

		LOG.info("Nome informado no filtro ".concat(request.getNome()));

		List<Pessoa> pessoas = PessoaMass.createListaPessoas();
		List<Pessoa> retorno = new ArrayList<Pessoa>();

		retorno.addAll(pessoas.stream()
				.filter((p) -> (request.getNome().isEmpty() || p.getNome().contains(request.getNome())))
				.collect(Collectors.toList()));

		return new PessoasResponse().withPessoa(retorno);
	}

}
