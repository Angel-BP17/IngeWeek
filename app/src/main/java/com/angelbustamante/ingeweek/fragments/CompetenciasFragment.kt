package com.angelbustamante.ingeweek.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.angelbustamante.ingeweek.CompetenciaItem
import com.angelbustamante.ingeweek.databinding.FragmentCompetenciasBinding
import com.angelbustamante.ingeweek.ui.CompetenciasAdapter

class CompetenciasFragment : Fragment() {

    private var _binding: FragmentCompetenciasBinding? = null
    private val binding get() = _binding!!
    private val adapter by lazy { CompetenciasAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCompetenciasBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerCompetencias.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerCompetencias.adapter = adapter
        loadCompetencias()
    }

    private fun loadCompetencias() {
        val sample = listOf(
            CompetenciaItem("Campeonato Interescuelas", "Deporte general entre facultades", "06-06 09:00"),
            CompetenciaItem("Final de Campeonato Inter escuelas", "Partido final del torneo", "06-06 15:00"),
            CompetenciaItem("Partido de Fútbol de Confraternidad", "Partido amistoso", "05-06 16:00")
        )
        adapter.submitList(sample)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}