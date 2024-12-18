Feature: Store API - Ordenes de la tienda de mascotas
  Soy un Automatizador de Ntt dataa y Voy a automatizar la API de la tienda de mascotas
  @crearOrden
  Scenario Outline: Creación de un nuevo pedido en la tienda de mascotas
    Given la URL base "https://petstore.swagger.io/v2"
    When creo un pedido con ID <orderId>, petId <petId>, cantidad <quantity>, status "placed" y complete <complete>
    Then valido que el código de respuesta sea 200
    And valido que el body contenga el ID del pedido <orderId> y el status "placed"

    Examples:
      | orderId | petId | quantity | complete |
      | 101     | 10    | 2        | true     |
      | 102     | 20    | 1        | false    |

  @consultarOrden
  Scenario Outline: Consulta de un pedido existente por su ID
    Given la URL base "https://petstore.swagger.io/v2"
    When consulto el pedido con ID <orderId>
    Then valido que el código de respuesta sea 200
    And valido que el body contenga el ID del pedido <orderId> y el status "placed"

    Examples:
      | orderId |
      | 101     |
      | 102     |