package com.nttdata;
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty"},
        features = "classpath:features",
        tags = "@crearOrden or @consultarOrden"   // Ejecutar ambos escenarios en orden
)
public class CucumberTestSuite {

}
