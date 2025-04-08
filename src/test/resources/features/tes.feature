#language: es

Característica:  Automatizar Selección de una fecha en jqueryui

  @happyPath

  Esquema del escenario: Seleccionar una fecha valida

    Dado  Que me encuentro en la pagina de jqueryui
    Cuando  selecciona la fecha '<fecha>'
    Entonces Visualizare '<fecha>' en la seleccion

    Ejemplos:
      | fecha      |
      | 08/04/2025 |
      | 08/05/2025 |
