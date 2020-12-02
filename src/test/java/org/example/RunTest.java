package org.example;

import org.example.model.Properties;
import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features="src/test/resources/features/modelo.feature")
public class RunTest {
    @BeforeClass
    public static void beforeTest() {
        try {
            //se obtienen las variables parametricas, utilizar las necesarias en cada caso
//            Properties.userCcard     = System.getProperty("UserCcard");
//            Properties.passwordCcard = System.getProperty("PasswordCcard");
//
//            Properties.userProd      = System.getProperty("UserProd");
//            Properties.passwordProd  = System.getProperty("PasswordProd");
//
//            Properties.environment   = System.getProperty("Environment");
//            Properties.country       = System.getProperty("Country");

            //Se validan que las propiedades no sean nulas o tengan los valores esperados
            //Si se agregan o se eliminan propiedades, se debe actualizar el validate()
            Properties.validate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
