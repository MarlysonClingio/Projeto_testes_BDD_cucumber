package br.ce.wcaquino.steps;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class InserirContasSteps {

	WebDriver driver = new ChromeDriver();
	
	@Dado("que desejo adicionar um usuario")
	public void queDesejoAdicionarUmUsuario() {
		driver.get("https://seubarriga.wcaquino.me");
		driver.findElement(By.id("email")).sendKeys("marlysonalmeida@gmail.com");
		driver.findElement(By.id("senha")).sendKeys("Resident 5");
		driver.findElement(By.tagName("button")).click();
		String mensagem = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
		assertEquals("Bem vindo, Marlyson Clingio Almeida Coutinho!", mensagem);
		driver.findElement(By.linkText("Contas")).click();
		driver.findElement(By.linkText("Adicionar")).click();
	}

	@Quando("informo a conta {string}")
	public void informo_a_conta(String conta) {
		driver.findElement(By.id("nome")).sendKeys(conta);
		driver.findElement(By.tagName("button")).click();
	}
	
	@Então("recebo a mensagem {string}")
	public void receboAMensagem(String mensagem) {
		String alert = driver.findElement(By.xpath("//div[starts-with(@class, 'alert alert-')]")).getText();
		assertEquals(mensagem, alert);
	}

	@After(value = "@funcionais")
	public void finalizandoTest() {
		driver.get("https://seubarriga.wcaquino.me");
		driver.findElement(By.linkText("reset")).click();
		driver.quit();
	}

}