package com.cadastro.Teste;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.assertEquals;

public class TestConta {

    private WebDriver navegador ;

    @BeforeClass
    public static void inicio(){

        WebDriverManager.firefoxdriver().setup();
    }



    @Before
    public void configura(){

        navegador=new FirefoxDriver();


        navegador.get("https://seubarriga.wcaquino.me/");
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
        WebElement addConta = navegador.findElement(By.className("dropdown-toggle"));
        addConta.click();

        WebElement adicionar = navegador.findElement(By.linkText("Adicionar"));
        adicionar.click();
        WebElement botao = navegador.findElement(By.className("btn-primary"));
        botao.click();




        //WebElement mensagemErro = navegador.findElement(By.className("alert-danger"));


    }

    @Test
    public void testCriacaoDeContaSemInformarNome() throws Exception {
        String  mensagemEsperada ="Informe o nome da conta";
        String  mensagemObtida = navegador.findElement(By.className("alert-danger")).getText();

        if(!mensagemEsperada.equals(mensagemObtida)){
            throw new Exception("TESTE FALHOU >  esperava  :"+mensagemEsperada+"obteve"+mensagemObtida);
        }
        else {
            System.out.println("TESTE PASSOU > é a mensagem esperada:"+mensagemEsperada+"obteve"+mensagemObtida);
        }

    }

    @Test
    public void testMensagemDeContaCriadaComSucesso(){


        WebElement nome = navegador.findElement(By.id("nome"));
        nome.sendKeys("Marcela Duarte");
        WebElement botao = navegador.findElement(By.className("btn-primary"));
        botao.click();

       Assert.assertEquals("Conta adicionada com sucesso!",navegador.findElement(By.className("alert-success")).getText());

    }

    @Test
    public void testApresentacaoContasNoListar(){

        WebElement contaBotao = navegador.findElement(By.className("dropdown-toggle"));
        contaBotao.click();

        WebElement listaropcao = navegador.findElement(By.linkText("Listar"));
        listaropcao.click();

    }

    @Test
    public void testMensagemDeSucessoNaAlteracaoDaConta(){

        WebElement contaBotao = navegador.findElement(By.className("dropdown-toggle"));
        contaBotao.click();

        WebElement listaropcao = navegador.findElement(By.linkText("Listar"));
        listaropcao.click();

        WebElement tabela = navegador.findElement(By.xpath(".//span[@class='glyphicon glyphicon-edit']"));
        tabela.click();
        WebElement nomeAlterar = navegador.findElement(By.className("form-control"));
        nomeAlterar.sendKeys("teste");
        WebElement botaoSalvar = navegador.findElement(By.className("btn-primary"));
        botaoSalvar.click();

        assertEquals("Conta alterada com sucesso!",navegador.findElement(By.className("alert-success")).getText());




    }

    @Test
    public void testRemoverConta(){
        WebElement contaBotao = navegador.findElement(By.className("dropdown-toggle"));
        contaBotao.click();

        WebElement listaropcao = navegador.findElement(By.linkText("Listar"));
        listaropcao.click();

        WebElement tabela = navegador.findElement(By.xpath(".//span[@class='glyphicon glyphicon-remove-circle']"));
        tabela.click();

        assertEquals("Conta removida com sucesso!",navegador.findElement(By.className("alert-success")).getText());

    }

    @After
    public void encerrar(){
        navegador.quit();
    }


}
