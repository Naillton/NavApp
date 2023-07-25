package com.example.navapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.navapp.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    // criando binding da Screen home
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
            binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)

            // Usando evento de click no botao para acessar a segunda Screen
            binding.btnSubmit.setOnClickListener{
                // criando validacao para verificar se o edit text esta vazio
                // Inflate the layout for this fragment and use DataBinding
                    if (binding.edtText.text.toString().isEmpty()) {
                        Toast.makeText(
                            activity,
                            "Informe um valor no edit text",
                            Toast.LENGTH_LONG
                        ).show()
                    } else {
                    // enviando informacoes via bundle
                    // aqui criamos uma constante bundle que recebe um bundleOf() passando como chave
                    // o name e como o valor da chave o que digitarmos no edit text
                    val bundle = bundleOf("name" to binding.edtText.text.toString())

                    // para enviar valores entre scrrens adcionamos a nossa constante ao navigate
                    // metodo usado para encontrar o controlle de navegacao e setar a rota a ser acessada
                    // precisamos fazer referencia a nossa acao de mudanca de telas usando o seu id
                    it.findNavController().navigate(R.id.action_homeFragment_to_secondFragment, bundle)
                }
            }

        return binding.root
    }
}