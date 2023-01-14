package com.example.jokenpo.Fragments

import android.content.Context
import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.jokenpo.R
import com.example.jokenpo.data.Jogo


class UserFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View ? {

        val view = inflater.inflate(R.layout.fragment_user, container, false)
        val btnRandom = view.findViewById<ImageView>(R.id.imgRandom)
        val btnBack = view.findViewById<ImageView>(R.id.imgBack)
        val btnNext = view.findViewById<ImageView>(R.id.imgNext)
        val imgUsuario = view.findViewById<ImageView>(R.id.imgUsuario)
        val btnPlay = view.findViewById<TextView>(R.id.tvPlay)
        val jogo = Jogo()

        Som()

        var listaSkin = listOf(
            R.drawable.avatar1,
            R.drawable.avatar2,
            R.drawable.avatar3,
            R.drawable.avatar4,
            R.drawable.avatar5,
            R.drawable.avatar6,
            R.drawable.avatar7,
            R.drawable.avatar8,
            R.drawable.avatar9,
            R.drawable.avatar10,
            R.drawable.avatar11,
            R.drawable.avatar12,
            R.drawable.avatar13
        )

        var i = 0

        btnBack.setOnClickListener {
            if (i == 0) {
                i = listaSkin.size-1
                imgUsuario.setImageResource(listaSkin[i])
            } else {
                while (i <= listaSkin.size) {
                    i--
                    imgUsuario.setImageResource(listaSkin[i])
                    break
                }
            }
        }

        btnNext.setOnClickListener {
            if (i == listaSkin.size - 1) {
                i = 0
                imgUsuario.setImageResource(listaSkin[i])
            } else {
                while (i <= listaSkin.size) {
                    i++
                    imgUsuario.setImageResource(listaSkin[i])
                    break
                }
            }
        }

        btnRandom.setOnClickListener {
            imgUsuario.setImageResource(listaSkin.random())
        }

        btnPlay.setOnClickListener {
            val imgUser = listaSkin[i]
            val direcao = UserFragmentDirections.actionUserFragmentToMainFragment(imgUser)
            findNavController().navigate(direcao)
        }

        return view
    }

    fun Som(){
        var background = R.raw.backgroundmusic
        var mediaPlayer: MediaPlayer = MediaPlayer.create(context, background);
        mediaPlayer.start();
    }
}




