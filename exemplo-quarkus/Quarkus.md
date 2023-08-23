## Basico

- Não termina por aqui, continuem estudando.

## Quarkus

- O que é, como, onde, pq
- Quarkus x Spring
- Site
- Novo projeto:
    - opções do site.
    - Estrutura padrão: 
            - application.properties.
            - escopos
            - panache + hibernate
            - api
            - migrações com o flyway
            - auth


ESCOPOS:
- CDI --> JSR
    - Injeção de dependencias:
		@Inject
		GreetingsRepository repo;
	- Comportamentos do objeto injetado:
    	- @ApplicationScoped -> Quando algum método chamar o repo -> 1 instancia
    	- @Singleton -> Chamando ou não ele ta iniciado -> 1 intancia
    	- @Dependent -> Chamando ou não ele ta iniciado -> 1 para cada ponto de injeção
    	- @RequestScoped -> Quando chamar a instancia em uma request -> 1 para cada request http
		- @SessionScoped -> Quando chamar a instancia em uma request -> 1 para cada sessao disparada
		- Posso criar a minha

