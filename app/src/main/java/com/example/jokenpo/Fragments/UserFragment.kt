package com.example.jokenpo.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.jokenpo.R


class UserFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View ? {
        val view = inflater.inflate(R.layout.fragment_user, container, false)
        var btnRandom = view.findViewById<ImageView>(R.id.imgRandom)
        var btnBack = view.findViewById<ImageView>(R.id.imgBack)
        var btnNext = view.findViewById<ImageView>(R.id.imgNext)
        var imgUsuario = view.findViewById<ImageView>(R.id.imgUsuario)
        var btnPlay = view.findViewById<TextView>(R.id.tvPlay)

        btnPlay.setOnClickListener {
            findNavController().navigate(R.id.mainFragment)
        }

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

        return view
    }
}




