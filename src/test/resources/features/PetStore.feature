Feature: PetStore API
  @consulta
  Scenario: Consulta mascota
    Given la url "https://petstore.swagger.io/v2"
    When consulto la mascota con ID 1
    Then valido el cod de re sponse sea 200
    And valido el nombre de la mascota sea "Pinky"
@crearmascota
    Scenario: CRear mascota
      Given la url "https://petstore.swagger.io/v2"
      When creo la mascota "Rocky" con ID "347"
      Then valido el cod de re sponse sea 200

