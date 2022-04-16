#language: pt

Funcionalidade: Alugar Filme
	- Como um Usuário
	- Eu quero cadastrar aluguéis de filmes
	- Para controlar preços e datas de entrega
	
Cenário: Deve alugar um filme com sucesso
	Dado um filme
	| estoque | 2 |
	|  preco  | 3 |
	Quando alugar
	Então o preço do aluguel será R$ 3,0
	E a data de entrega será em 1 dia(s)
	E o estoque do filme será 1 unidade(s)

Cenário: Não deve alugar filme sem estoque
	Dado um filme com estoque de 0 unidade(s)
	Quando alugar
	Então não será possível por falta de estoque
	E o estoque do filme será 0 unidade(s)
	
Esquema do Cenário:	Deve dar condições conforme tipo de aluguel
	Dado um filme com estoque de 2 unidade(s)
	E que o preço do aluguel seja R$ <preco>
	E que o tipo do aluguel seja <tipo>
	Quando alugar
	Então o preço do aluguel será R$ <valor>
	E a data de entrega será em <qtdDias> dia(s)
	E a pontuação será de <pontuacao> ponto(s)
	
Exemplos:
	| preco |   tipo 	| valor | qtdDias | pontuacao |
	|  4,0	|extendido|	 8,0 	|		3			|			2			|
	|	 4,0	|  comum  |	 4,0 	|		1			|		  1			|
	|	 5,0	| semanal |	15,0	|		7			|		  3			|
		
	
	