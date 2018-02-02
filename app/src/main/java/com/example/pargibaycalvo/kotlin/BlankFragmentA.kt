package com.example.pargibaycalvo.kotlin

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

//para acceder los objectos dentro del layout
import kotlinx.android.synthetic.main.fragment_blank_a.*
import kotlinx.android.synthetic.main.fragment_blank_b.*
//para poder usar Anko y el toast
import org.jetbrains.anko.support.v4.toast


class MainFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_blank_a, container)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // añadimos funcionalidad al boton
        main_button.setOnClickListener {
            // Mostramos una toast
            // Para utilizar este método necesitamos la librería Anko que completa las funcionalidades de Kotlin
            // https://github.com/Kotlin/anko
            // es necesario
            toast("Mensaje: ${main_editText.text}")
            // mostramos en el TextView  del (fragment_blank_b) lo que introducimos en el EditText del (fragment_blank_a)
            main2_textview.text  = main_editText.text
        }
    }
}
