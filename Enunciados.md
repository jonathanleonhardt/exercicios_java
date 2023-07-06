**EXERCICIO 01**

Crie uma classe denominada Elevador para armazenar as informações de um elevador dentro de um prédio.

A classe deve armazenar o andar atual (térreo = 0), total de andares no prédio (desconsiderando o térreo), capacidade do elevador e quantas pessoas estão presentes nele. A classe deve também disponibilizar os seguintes métodos:

- Inicializa : que deve receber como parâmetros a capacidade do elevador e o total de andares no prédio (os elevadores sempre começam no térreo e vazio);
- Entra : para acrescentar uma pessoa no elevador (só deve acrescentar se ainda houver espaço);
- Sai : para remover uma pessoa do elevador (só deve remover se houver alguém dentro dele);
- Sobe : para subir um andar (não deve subir se já estiver no último andar);
- Desce : para descer um andar (não deve descer se já estiver no térreo);

Encapsular todos os atributos da classe (criar os métodos set e get).


-----------------------------------------------------------------------------

**EXERCICIO 02**

Dada uma livraria que comercializa livros, revistas e jornais.

- Os livros possuem titulo, um ou mais autores, editora, data de publicação e o preço da venda;
- A revista possui editora, numero da edição, data de publicação, preço de venda e os artigos que por sua vez, possuem titulo, o texto da publicação e autores.
- E os jornais possuem valor de venda, titulo, data de publicação e as reportagens, que possuem titulo, um ou mais autores, texto da reportagem;

Implemente o gerenciamento dos itens da livraria:

- Inclusão de um novo item;
- Listagem dos itens da livraria para à venda: Todas as informações de cada um dos itens;
- Listagem dos itens da livraria: código + tipo de item + título;
- Alteração de informações de um item já existente;
- Modalidades de venda: Estudante: possui 50% de desconto na compra de um livro ou revista, mas paga o valor integral para os jornais enquanto os demais clientes: pagam o valor integral dos itens;


-----------------------------------------------------------------------------

**EXERCICIO 03**

Desenvolva um sistema para uma hamburgueria controlar os pedidos internamente.
A forma que você irá implementar este sistema será de sua responsabilidade, mas no decorrer do exercício tente explorar vários dos conceitos demonstrados em aula.

Este sistema deve ter obrigatoriamente o cadastro da:
- hamburgueria, clientes, pedidos e produtos fornecidos, mas pode haver outras entidades.

A Hamburgueria lhe encaminhou uma lista de requisitos para o sistema:

- O fluxo padrão: cadastra cliente, monta pedido, seleciona pagamento e retirada/entrega.
- Ao realizar o pedido, o cliente deve ter cadastro básico para contato.
- Limite de 50 pedidos por dia.
- Atualizar o status do pedido manualmente.
- Programar o envio de mensagens aos clientes.

*EXTRA*

Considerando o sistema interno da hamburgueria, desenvolva uma estrutura de acesso para o cliente:

- O cliente pode acessar seu cadastro com email e senha.
- Acompanhar o status do pedido.
- Editar o proprio cadastro.
- Cancelar o pedido.

Agora a hamburgueria irá precisar de mais requisitos:

- Cadastro de promoções e combos.
- Sistema de pontos de fidelidade.