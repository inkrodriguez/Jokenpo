package com.example.jokenpo.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.jokenpo.R


class UserFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View ? {
        val view = inflater.inflate(R.layout.fragment_user, container, false)
        var btnSkin = view.findViewById<ImageView>(R.id.imgSkin)
        var imgUsuario = view.findViewById<ImageView>(R.id.imgUsuario)

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
        btnSkin.setOnClickListener {

            if(i >= listaSkin.size){
                i = 0
                imgUsuario.setImageResource(listaSkin[0])
            }else{

            while(i < listaSkin.size) {
                imgUsuario.setImageResource(listaSkin[i])
                i++
                break
            }
            }


        }

        return view
    }



}




