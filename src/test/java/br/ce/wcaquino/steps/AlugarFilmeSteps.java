package br.ce.wcaquino.steps;

import static org.junit.Assert.assertEquals;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import br.ce.wcaquino.entidades.Filme;
import br.ce.wcaquino.entidades.NotaAluguel;
import br.ce.wcaquino.entidades.TipoAluguel;
import br.ce.wcaquino.services.AluguelService;
import br.ce.wcaquino.utils.DateUtils;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class AlugarFilmeSteps {

	private Filme filme = new Filme();
	private AluguelService aluguel = new AluguelService();
	private NotaAluguel nota = new NotaAluguel();
	private String error;
	private TipoAluguel tipoAluguel = TipoAluguel.COMUM;

	@Dado("um filme com estoque de {int} unidade\\(s)")
	public void umFilmeComEstoqueDeUnidade(Integer int1) {
		filme.setEstoque(int1);
	}

	@Dado("que o preço do aluguel seja R$ {double}")
	public void queOPreçoDoAluguelSejaR$(double double1) {
		filme.setAluguel(double1);
	}

	@Dado("um filme")
	public void umFilme(DataTable dataTable) {
		Map<String, String> map = dataTable.asMap(String.class, String.class);
		filme.setEstoque(Integer.parseInt(map.get("estoque")));
		filme.setAluguel(Double.parseDouble(map.get("preco")));
	}

	@Quando("alugar")
	public void alugar() {
		try {
			nota = aluguel.alugar(filme, tipoAluguel);
		} catch (RuntimeException e) {
			error = e.getMessage();
		}
	}

	@Então("o preço do aluguel será R$ {double}")
	public void oPreçoDoAluguelSeráR$(double double1) {
		assertEquals(double1, nota.getPreco(), 0.0);
	}

	@Então("o estoque do filme será {int} unidade\\(s)")
	public void oEstoqueDoFilmeSeráUnidade(int int1) {
		assertEquals(int1, filme.getEstoque());
	}

	@Então("não será possível por falta de estoque")
	public void nãoSeráPossívelPorFaltaDeEstoque() {
		assertEquals("Filme sem estoque", error);
	}

	@Dado("que o tipo do aluguel seja extendido")
	public void queOTipoDoAluguelSejaExtendido() {
		tipoAluguel = TipoAluguel.EXTENDIDO;
	}

	@Dado("que o tipo do aluguel seja comum")
	public void queOTipoDoAluguelSejaComum() {
		tipoAluguel = TipoAluguel.COMUM;
	}

	@Dado("que o tipo do aluguel seja semanal")
	public void queOTipoDoAluguelSejaSemanal() {
		tipoAluguel = TipoAluguel.SEMANAL;
	}

	@Então("a data de entrega será em {int} dia\\(s)")
	public void aDataDeEntregaSeráEmDias(Integer int1) {
		Date dataEsperada = DateUtils.obterDataDiferencaDeDias(int1);
		Date dataReal = nota.getDataEntrega();

		DateFormat format = new SimpleDateFormat("dd/MM/yyyy");

		assertEquals(format.format(dataEsperada), format.format(dataReal));
	}

	@Então("a pontuação será de {int} ponto\\(s)")
	public void aPontuaçãoSeráDePontos(int int1) {
		assertEquals(int1, nota.getPontuacao());
	}
}