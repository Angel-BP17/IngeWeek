package com.angelbustamante.ingeweek.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.angelbustamante.ingeweek.AgendaItem
import com.angelbustamante.ingeweek.databinding.FragmentAgendaBinding
import com.angelbustamante.ingeweek.ui.AgendaAdapter

class AgendaFragment : Fragment() {

    private var _binding: FragmentAgendaBinding? = null
    private val binding get() = _binding!!

    private val agendaAdapter by lazy { AgendaAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAgendaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        loadAgendaItems()
    }

    private fun setupRecyclerView() {
        binding.recyclerAgenda.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = agendaAdapter
        }
    }

    private fun loadAgendaItems() {
        // TODO: Load real data. For now, sample list:
        val sample = listOf(
            AgendaItem("09:00", "Ceremonia de Inauguración", "Plazuela de la UNS"),
            AgendaItem("10:00", "El ingeniero como agente de cambio", "Auditorio Biblioteca Central"),
            AgendaItem("10:45", "Desempeño sísmico de un edificio esencial...", "Auditorio Biblioteca Central"),
            AgendaItem("11:30", "Análisis de fallas en estructuras metálicas", "Auditorio Biblioteca Central"),
            AgendaItem("11:30", "Cimentaciones para edificaciones...", "Auditorio Biblioteca Central"),
            AgendaItem("09:00", "Misa de Celebración por la Semana de Ingeniería", "Capilla de la UNS"),
            AgendaItem("10:00", "Ceremonia Central por la Celebración...", "Auditorio de Ingeniería en Energía"),
            AgendaItem("15:00", "Corso Inter escuelas", "Complejo deportivo UNS"),
            AgendaItem("16:00", "Partido de Fútbol de Confraternidad", "Complejo deportivo UNS"),
            AgendaItem("09:00", "Campeonato Interescuelas", "Complejo Deportivo – UNS"),
            AgendaItem("13:00", "Compartir de Confraternidad: Almuerzo", "Complejo deportivo – UNS"),
            AgendaItem("14:00", "Compartir de confraternidad de la Facultad...", "Complejo deportivo - UNS"),
            AgendaItem("15:00", "Final de Campeonato Inter escuelas", "Complejo Deportivo – UNS"),
            AgendaItem("18:00", "Premiación de Equipos Ganadores", "Complejo deportivo UNS"),
            AgendaItem("18:15", "Clausura", "Complejo deportivo UNS")
        )
        agendaAdapter.submitList(sample)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}