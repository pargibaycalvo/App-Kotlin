package com.example.pargibaycalvo.kotlin

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

//para acceder los objectos dentro del layout
import kotlinx.android.synthetic.main.fragment_blank_a.*
//para poder usar Anko y el toast
import org.jetbrains.anko.support.v4.toast


/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [BlankFragmentA.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [BlankFragmentA.newInstance] factory method to
 * create an instance of this fragment.
 */
 class BlankFragmentA:Fragment() {

 // TODO: Rename and change types of parameters
    private var mParam1:String? = null
private var mParam2:String? = null

private var mListener:OnFragmentInteractionListener? = null

public override fun onCreate(savedInstanceState:Bundle?) {
super.onCreate(savedInstanceState)
if (getArguments() != null)
{
mParam1 = getArguments().getString(ARG_PARAM1)
mParam2 = getArguments().getString(ARG_PARAM2)
}
}

    //AÑADIDO EN EL CÓDIGO PARA NUESTRA APP//
//--------------------------------------------------------------------------------------------------//

public override fun onCreateView(inflater:LayoutInflater?, container:ViewGroup?,
savedInstanceState:Bundle?):View? {
 // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.fragment_blank_a, container)
}


    //una vez cargado el layout pordemos utilizar sus elementos
    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // añadimos funcionalidad al boton
        main_button.setOnClickListener {
            // Mostramos una toast
            // Para utilizar este método necesitamos la librería Anko que completa las funcionalidades de Kotlin
            // https://github.com/Kotlin/anko
            // es necesario meterle las dependencias si no fallará
            toast("Mensaje: ${main_editText.text}")
            // mostramos en el TextView lo que introducimos en el EditText
            main_textview.text = main_editText.text
        }
    }




//--------------------------------------------------------------------------------------------------//

 // TODO: Rename method, update argument and hook method into UI event
     fun onButtonPressed(uri:Uri) {
if (mListener != null)
{
mListener!!.onFragmentInteraction(uri)
}
}

public override fun onAttach(context:Context?) {
super.onAttach(context)
if (context is OnFragmentInteractionListener)
{
mListener = context as OnFragmentInteractionListener?
}
else
{
throw RuntimeException((context!!.toString() + " must implement OnFragmentInteractionListener"))
}
}

public override fun onDetach() {
super.onDetach()
mListener = null
}

/**
 * This interface must be implemented by activities that contain this
 * fragment to allow an interaction in this fragment to be communicated
 * to the activity and potentially other fragments contained in that
 * activity.
 *
 *
 * See the Android Training lesson [Communicating with Other Fragments](http://developer.android.com/training/basics/fragments/communicating.html) for more information.
 */
     interface OnFragmentInteractionListener {
 // TODO: Update argument type and name
         fun onFragmentInteraction(uri:Uri)
}

companion object {
 // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private val ARG_PARAM1 = "param1"
private val ARG_PARAM2 = "param2"

/**
 * Use this factory method to create a new instance of
 * this fragment using the provided parameters.
 *
 * @param param1 Parameter 1.
 * @param param2 Parameter 2.
 * @return A new instance of fragment BlankFragmentA.
 */
    // TODO: Rename and change types and number of parameters
     fun newInstance(param1:String, param2:String):BlankFragmentA {
val fragment = BlankFragmentA()
val args = Bundle()
args.putString(ARG_PARAM1, param1)
args.putString(ARG_PARAM2, param2)
fragment.setArguments(args)
return fragment
}
}
}// Required empty public constructor
