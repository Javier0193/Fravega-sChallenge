#language: es
@Cucumber
Característica: Test backend

  @CP1
  Esquema del escenario: Openbrewery
    Dado que invoco al servicio <URL> con el parametro <PARAM> con valor <VALOR>
    Y filtro cervecerías con key <KEY> valor <VALOR2>
    Cuando obtengo el detalle de la cervecería con clave <CLAVE> y valor <VALOR3> desde la URL <URL2>
    Entonces  la cervecería resultante tiene id 761, name Lagunitas Brewing Co, street 1280 N McDowell Blvd, phone 7077694495

    Ejemplos:
      | URL                                                   | PARAM | VALOR     |   KEY    |    VALOR2            |   CLAVE    |    VALOR3      |   URL2                                   |
      | https://api.openbrewerydb.org/breweries/autocomplete  | query | lagunitas |   name   | Lagunitas Brewing Co |   state    |    California  | https://api.openbrewerydb.org/breweries/ |

