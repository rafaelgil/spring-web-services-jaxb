package br.estudospringwebservice.ws;

import org.estudospringwebservice.pessoa.schema.beans.PessoasRequest;
import org.estudospringwebservice.pessoa.schema.beans.PessoasResponse;

public interface PessoaService {
    
    public final static String NAMESPACE = "http://www.estudospringwebservice.org/pessoa/schema/beans";
    public final static String GET_PERSONS_REQUEST = "pessoas-request";

    /**
     * Gets person list.
     */
    public PessoasResponse getPessoas(PessoasRequest request);

}
