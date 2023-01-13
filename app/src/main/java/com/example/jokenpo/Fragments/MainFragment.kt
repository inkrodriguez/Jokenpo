package com.example.jokenpo.Fragments

import android.content.Context
import android.media.Image
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.jokenpo.R
import com.example.jokenpo.data.Jogo

class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_main, container, false)

        val argumentos by navArgs<MainFragmentArgs>()

        val imgUser = view.findViewById<ImageView>(R.id.imgUser)
        val btnPedra = view.findViewById<ImageView>(R.id.imgPedra)
        val btnPapel = view.findViewById<ImageView>(R.id.imgPapel)
        val btnTesoura = view.findViewById<ImageView>(R.id.imgTesoura)
        val imgYourChoice = view.findViewById<ImageView>(R.id.imgYourChoice)
        val imgMachineChoice = view.findViewById<ImageView>(R.id.imgMachineChoice)
        val imgPlayMain = view.findViewById<ImageView>(R.id.imgPlayMain)
        val tvHighscore = view.findViewById<TextView>(R.id.tvHighscore)
        val tvVida = view.findViewById<TextView>(R.id.tvVida)
        val jogo = Jogo()

        imgUser.setImageResource(argumentos.imgUser)

        val listaOpcoes = listOf(
            (R.drawable.pedra2),
            R.drawable.papel2,
            R.drawable.tesoura2
        )

        btnPedra.setOnClickListener {
            imgYourChoice.setImageResource(R.drawable.pedra2)
            jogo.player.opcao = "pedra"
        }

        btnPapel.setOnClickListener {
            imgYourChoice.setImageResource(R.drawable.papel2)
            jogo.player.opcao = "papel"
        }

        btnTesoura.setOnClickListener {
            imgYourChoice.setImageResource(R.drawable.tesoura2)
            jogo.player.opcao = "tesoura"
        }


        imgPlayMain.setOnClickListener {

            if (jogo.player.vida == 1) {
                val pontuacaoFinal: Int = jogo.player.highscore
                val direcao = MainFragmentDirections.actionMainFragmentToHighscoreFragment(pontuacaoFinal)
                findNavController().navigate(direcao)
            } else {
                var listaOpcoesRandom = listaOpcoes.random()
                imgMachineChoice.setImageResource(listaOpcoesRandom)

                when (listaOpcoesRandom) {
                    R.drawable.pedra2 -> jogo.maquina.opcao = "pedra"
                    R.drawable.papel2 -> jogo.maquina.opcao = "papel"
                    R.drawable.tesoura2 -> jogo.maquina.opcao = "tesoura"
                }
                jogo.jogar()
                tvHighscore.text = jogo.player.highscore.toString()
                tvVida.text = jogo.player.vida.toString()
            }
        }

        return view
    }


}