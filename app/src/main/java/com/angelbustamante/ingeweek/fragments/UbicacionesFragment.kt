package com.angelbustamante.ingeweek.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.angelbustamante.ingeweek.UbicacionItem
import com.angelbustamante.ingeweek.databinding.FragmentUbicacionesBinding
import com.angelbustamante.ingeweek.ui.UbicacionesAdapter

class UbicacionesFragment : Fragment() {

    private var _binding: FragmentUbicacionesBinding? = null
    private val binding get() = _binding!!
    private val adapter by lazy { UbicacionesAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUbicacionesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerUbicaciones.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerUbicaciones.adapter       = adapter
        loadUbicaciones()
    }

    private fun loadUbicaciones() {
        val sample = listOf(
            UbicacionItem("Plazuela de la UNS", "Campus UNS", "Lugar de la inauguración"),
            UbicacionItem("Auditorio Biblioteca Central", "Edificio Central UNS", "Sede de conferencias y seminarios"),
            UbicacionItem("Auditorio de Ingeniería en Energía", "Facultad de Energía", "Ceremonia central"),
            UbicacionItem("Capilla de la UNS", "Campus UNS", "Misa inaugural"),
            UbicacionItem("Complejo deportivo UNS", "Campus UNS", "Deportes, corso y clausura")
        )
        adapter.submitList(sample)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}