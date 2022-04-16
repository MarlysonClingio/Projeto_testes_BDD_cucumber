#language: pt

@funcionais
Funcionalidade: Cadastro de contas
- Como um usuário 
- Gostaria de cadastrar contas
- Para que eu possa distribuir meu dinheiro de uma forma mais organizada


Contexto:
	Dado que desejo adicionar um usuario
	

Esquema do Cenário: Deve validar regras de cadastro de contas
	Quando informo a conta "<conta>"
	Então recebo a mensagem "<mensagem>"

Exemplos:
	|     conta			 |           mensagem						 		|
	|Conta para teste|   Conta adicionada com sucesso!	|
	|								 |     Informe o nome da conta		  |
	|Conta mesmo nome|Já existe uma conta com esse nome!|	