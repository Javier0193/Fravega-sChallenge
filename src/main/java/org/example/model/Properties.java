package org.example.model;

import com.claro.sp.ta.db.util.Country;
import com.claro.sp.ta.db.util.Environment;
import org.junit.Assert;

public class Properties {

    public static String userCcard;
    public static String passwordCcard;

    public static String userProd;
    public static String passwordProd;

    public static String environment;
    public static String country;

    public static void validate() throws Exception {
        Assert.assertFalse("Parametro userCcard es null",userCcard == null);
        Assert.assertFalse("Parametro passwordCcard es null",passwordCcard == null);

        Assert.assertFalse("Parametro userProd es null",userProd == null);
        Assert.assertFalse("Parametro passwordProd es null",passwordProd == null);

        Assert.assertFalse("Parametro environment incorrecto. Valores posibles: DEV o TEST",!environment.equalsIgnoreCase(Environment.DEVELOP) && !environment.equalsIgnoreCase(Environment.TEST));
        Assert.assertFalse("Parametro country incorrecto. Valores posibles: AR, UY o PY",!country.equalsIgnoreCase(Country.ARGENTINA) && !country.equalsIgnoreCase(Country.PARAGUAY) && !country.equalsIgnoreCase(Country.URUGUAY));
    }
}
