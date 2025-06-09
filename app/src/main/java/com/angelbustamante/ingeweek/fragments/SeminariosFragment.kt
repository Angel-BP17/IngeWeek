package com.angelbustamante.ingeweek.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.angelbustamante.ingeweek.SeminarioItem
import com.angelbustamante.ingeweek.databinding.FragmentSeminariosBinding
import com.angelbustamante.ingeweek.ui.SeminariosAdapter

class SeminariosFragment : Fragment() {

    private var _binding: FragmentSeminariosBinding? = null
    private val binding get() = _binding!!
    private val adapter by lazy { SeminariosAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSeminariosBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerSeminarios.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerSeminarios.adapter = adapter
        loadSeminarios()
    }

    private fun loadSeminarios() {
        val sample = listOf(
            SeminarioItem("El ingeniero como agente de cambio", "Ponente no especificado", "02-06 10:00"),
            SeminarioItem("Desempeño sísmico de un edificio esencial...", "Ponente no especificado", "02-06 10:45"),
            SeminarioItem("Análisis de fallas en estructuras metálicas", "Ponente no especificado", "02-06 11:30"),
            SeminarioItem("Cimentaciones para edificaciones...", "Ponente no especificado", "02-06 11:30")
        )
        adapter.submitList(sample)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}