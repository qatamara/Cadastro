package com.cadastro.Teste;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.assertEquals;

public class TesteMovimentacao {
    private WebDriver navegador;

    @BeforeClass
    public static void inicio(){
        WebDriverManager.firefoxdriver().setup();
    }
    @Before
    public void configura(){
        navegador=new FirefoxDriver();

        navegador.get("https://seubarriga.wcaquino.me");

        WebElement emailInput = navegador.findElement(By.id("email"));
        emailInput.sendKeys("tamara@teste.com");
        WebElement senhaInput = navegador.findElement(By.id("senha"));
        senhaInput.sendKeys("123456");
        WebElement entrarbotao = navegador.findElement(By.className("btn-primary"));
        entrarbotao.click();

        WebElement mensagemSucesso = navegador.findElement(By.className("alert-success"));


        assertEquals("Seu Barriga - Home",navegador.getTitle());
        System.out.println("Obter titulo da pagina:"
                +navegador.getTitle());
        WebElement movimentacaoOpcao = navegador.findElement(By.linkText("Criar Movimentação"));
        movimentacaoOpcao.click();

        WebElement combo = navegador.findElement(By.id("conta"));
        Select conta = new Select(combo);
        conta.selectByValue("758672");

        WebElement situacao = navegador.findElement(By.className("col-lg-3"));
        WebElement status = navegador.findElement(By.id("status_pago"));
        status.click();

        WebElement salvarBotao = navegador.findElement(By.className("btn-primary"));
        salvarBotao.click();

    }
    @Test
    public void testMensagemDeObrigatoriedadeCampos(){

        WebElement movimentacaoOpcao = navegador.findElement(By.linkText("Criar Movimentação"));
        movimentacaoOpcao.click();

        WebElement combo = navegador.findElement(By.id("conta"));
        Select conta = new Select(combo);
        conta.selectByValue("758672");

        WebElement tipoopcao = navegador.findElement(By.id("tipo"));
        Select tipo = new Select(tipoopcao);
        tipo.selectByValue("REC");



        WebElement descricaoinput= navegador.findElement(By.id("descricao"));
        descricaoinput.sendKeys("Quitar");



        WebElement comboI = navegador.findElement(By.id("conta"));
        Select contaI = new Select(comboI);
        conta.selectByValue("758672");

        WebElement situacao = navegador.findElement(By.className("col-lg-3"));
        WebElement status = navegador.findElement(By.id("status_pago"));
        status.click();

        WebElement salvarBotao = navegador.findElement(By.className("btn-primary"));
        salvarBotao.click();






    }
    @Test
    public void testDeErroValorDiferenteDeNumero(){
        WebElement movimentacaoOpcao = navegador.findElement(By.linkText("Criar Movimentação"));
        movimentacaoOpcao.click();

        WebElement combo = navegador.findElement(By.id("conta"));
        Select conta = new Select(combo);
        conta.selectByValue("758672");

        WebElement tipoopcao = navegador.findElement(By.id("tipo"));
        Select tipo = new Select(tipoopcao);
        tipo.selectByValue("REC");

        WebElement dataInput = navegador.findElement(By.id("data_transacao"));
        dataInput.sendKeys("10/09/2020");

        WebElement dataPagamentoinput= navegador.findElement(By.id("data_pagamento"));
        dataPagamentoinput.sendKeys("11/09/2020");

        WebElement descricaoinput= navegador.findElement(By.id("descricao"));
        descricaoinput.sendKeys("Quitar");

        WebElement interessadoinput= navegador.findElement(By.id("interessado"));
        interessadoinput.sendKeys("Manuela Teste");

        WebElement valorInput = navegador.findElement(By.id("valor"));
        valorInput.sendKeys("%&*#2");

        WebElement comboI = navegador.findElement(By.id("conta"));
        Select contaI = new Select(comboI);
        conta.selectByValue("758672");

        WebElement situacao = navegador.findElement(By.className("col-lg-3"));
        WebElement status = navegador.findElement(By.id("status_pago"));
        status.click();

        WebElement salvarBotao = navegador.findElement(By.className("btn-primary"));
        salvarBotao.click();
        Assert.assertEquals("Valor deve ser um número",navegador.findElement(By.className("alert-danger")).getText());


    }
    @Test
    public void testMovimentacaoCriadaComSucessoMensagem(){
        WebElement movimentacaoOpcao = navegador.findElement(By.linkText("Criar Movimentação"));
        movimentacaoOpcao.click();

        WebElement combo = navegador.findElement(By.id("conta"));
        Select conta = new Select(combo);
        conta.selectByValue("758672");

        WebElement tipoopcao = navegador.findElement(By.id("tipo"));
        Select tipo = new Select(tipoopcao);
        tipo.selectByValue("REC");

        WebElement dataInput = navegador.findElement(By.id("data_transacao"));
        dataInput.sendKeys("10/09/2020");

        WebElement dataPagamentoinput= navegador.findElement(By.id("data_pagamento"));
        dataPagamentoinput.sendKeys("11/09/2020");

        WebElement descricaoinput= navegador.findElement(By.id("descricao"));
        descricaoinput.sendKeys("Quitar");

        WebElement interessadoinput= navegador.findElement(By.id("interessado"));
        interessadoinput.sendKeys("Teste");

        WebElement valorInput = navegador.findElement(By.id("valor"));
        valorInput.sendKeys("1000.00");

        WebElement comboI = navegador.findElement(By.id("conta"));
        Select contaI = new Select(comboI);
        conta.selectByValue("758672");

        WebElement situacao = navegador.findElement(By.className("col-lg-3"));
        WebElement status = navegador.findElement(By.id("status_pago"));
        status.click();

        WebElement salvarBotao = navegador.findElement(By.className("btn-primary"));
        salvarBotao.click();

        Assert.assertEquals("Movimentação adicionada com sucesso!",navegador.findElement(By.className("alert-success")).getText());
    }

/*
    @After
    public void fechar(){
        navegador.quit();
    }
    */


}
