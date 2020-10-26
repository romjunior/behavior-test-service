# language: pt
  Funcionalidade: Consulta de saldo e limites dos cartões

    Esquema do Cenario: Consulta de saldos e limites validos
      Dado que o usuario com o "<id>"
      Quando ele consultar o saldo e limites
      Entao ele deve retornar a seguinte resposta
      """
      {
          "available": "<available>",
          "creditAvaiable": "<creditAvaiable>",
          "creditTotal": "<creditTotal>",
          "debitAvailable": "<debitAvailable>",
          "debitTotal": "<debitTotal>"
      }
      """

      Exemplos:
        | id | available | creditAvaiable | creditTotal | debitAvailable | debitTotal |
        | a1 | 100.0     | 100.0          | 200.0       | 100.0          | 300.0      |
        | a2 | 150.0     | 110.0          | 220.0       | 130.0          | 260.0      |

    Cenario: Consulta para o cliente que não possua saldos
      Dado que o usuario com o "a11"
      Quando ele consultar o saldo e limites
      Entao ele deve retonar a resposta com o status "204"

