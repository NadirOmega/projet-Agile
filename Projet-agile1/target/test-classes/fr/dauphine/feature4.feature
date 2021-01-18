Feature: Feature4

  Scenario: Le travail de fusion
    Given La creation de fusion "X" qui se compose du avenger "a" et "b" qui ont du pouvoir "10" et "20"
    When La fusion happens
    Then La fusion "X" se fait on a la somme du pouvoir "a" et "b" qui ont "10" et "20" a puissance "30"
