# spring-web-services-jaxb
Exemplo spring web service com jaxb

#Passos para execução
1. No eclipse selecionar a pasta generated-sources\xjc como "Source folder"
2. No diretório do projeto executar mvn jetty:run e verificar que o wsdl aparece na url http://localhost:8080/ws/pessoaService/pessoa.wsdl
3. Para testar usando o SoapUI clique em new SOAP Project e em Initial WSDL informe a url acima e cliqua em OK. Estará disponível o metodo "pessoas" verificar se na janela Request 1 a url é http://localhost:8080/ws/pessoaService.
