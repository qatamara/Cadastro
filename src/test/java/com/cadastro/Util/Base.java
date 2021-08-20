package com.cadastro.Util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;


public class Base {

    private WebDriver navegador;

    @BeforeClass
    public static void preparandoAmbiente(){

        WebDriverManager.firefoxdriver().setup();
    }




}
