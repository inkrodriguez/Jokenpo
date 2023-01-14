package com.example.jokenpo.data

class Jogo {
    var player = Player()
    var maquina = Maquina()
    var opcoes = Opcoes()

    class Opcoes {
        var pedra = "pedra"
        var papel = "papel"
        var tesoura = "tesoura"

    }

    class Player {
        var nome = "Rodrigo"
        var highscore = 0
        var opcao = ""
        var vida = 3
    }

    class Maquina {
        var highscore = 0
        var opcao = listOf("pedra", "papel", "tesoura").random()
    }

        fun jogadas() {
            //VOCÊ GANHA//
            if ((player.opcao == "pedra") && (maquina.opcao == "tesoura")) {
                player.highscore = player.highscore + 1
            }
            //VOCÊ GANHA
            else if (player.opcao == "papel" && maquina.opcao == "pedra") {
                player.highscore = player.highscore + 1
            }
            //VOCÊ GANHA
            else if (player.opcao == "tesoura" && maquina.opcao == "papel") {
                player.highscore = player.highscore + 1
            }
            //VOCÊ EMPATA
            else if (player.opcao == maquina.opcao) {
            }
            //VOCÊ PERDE
            else {
                player.vida = player.vida - 1
                maquina.highscore = maquina.highscore + 1
            }
        }

    }