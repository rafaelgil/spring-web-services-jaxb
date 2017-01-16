package br.estudospringwebservice.ws;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;

import org.estudospringwebservice.pessoa.schema.beans.Pessoa;
import org.estudospringwebservice.pessoa.schema.beans.PessoasRequest;
import org.estudospringwebservice.pessoa.schema.beans.PessoasResponse;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mortbay.jetty.Handler;
import org.mortbay.jetty.Server;
import org.mortbay.jetty.servlet.Context;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;

import br.estudospringwebservice.client.PessoaClientWS;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:/jetty-context.xml"})
public class PessoaWsClientTest implements ApplicationContextAware {
    
    protected final static Integer ID = new Integer(1);
    protected final static String FIRST_NAME = "Joe";
    protected final static String LAST_NAME = "Smith";

    protected final static Integer SECOND_ID = new Integer(2);
    protected final static String SECOND_FIRST_NAME = "John";
    protected final static String SECOND_LAST_NAME = "Jackson";
    
    private ApplicationContext applicationContext;
    
    private static Server server;

    @Autowired
    protected PessoaClientWS client = null;
    
    public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.applicationContext = applicationContext;
		
	}
    
	@PostConstruct
    public void init() throws Exception {
                
        server = (Server) applicationContext.getBean("jettyServer");
        
        ServletContext servletContext = null;
        
        for (Handler handler : server.getHandlers()) {
            if (handler instanceof Context) {
                Context context = (Context) handler;

                servletContext = context.getServletContext();
            }
        }

        XmlWebApplicationContext wctx = new XmlWebApplicationContext();
        wctx.setParent(applicationContext);
        wctx.setConfigLocation("");
        wctx.setServletContext(servletContext);
        wctx.refresh();
        
        servletContext.setAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE, wctx);

        server.start();
    }
    
 
	@AfterClass
	public static void destroy(){
		
		try {
			if(server!=null && server.isRunning()){
				server.stop();
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
    @Test
    public void testRequestWsNomeAna() {
        
        PessoasRequest pessoasRequest = new PessoasRequest();
        pessoasRequest.setNome("Ana");
        
        PessoasResponse response = client.getPessoas(pessoasRequest);
        
        assertTrue(response.getPessoa().size() > 0);
        
        List<Pessoa> pessoas = response.getPessoa();
        for(Pessoa p : pessoas){
        	assertTrue(p.getNome().contains("Ana"));
        }
       
    }
    
    @Test
    public void testRequestWsNomeFulano() {
        
        PessoasRequest pessoasRequest = new PessoasRequest();
        pessoasRequest.setNome("Fulano");
        
        PessoasResponse response = client.getPessoas(pessoasRequest);
        
        assertTrue(response.getPessoa().isEmpty());
       
       
    }
    
}
