package com.example.mobiledevelopmentcourselabapp.presentation.view.second

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.mobiledevelopmentcourselabapp.R
import com.example.mobiledevelopmentcourselabapp.databinding.FragmentSecondBinding
import com.example.mobiledevelopmentcourselabapp.presentation.view.adapter.PlayerAdapter
import com.example.mobiledevelopmentcourselabapp.presentation.view.second.model.PlayerPosition
import com.example.mobiledevelopmentcourselabapp.presentation.view.second.model.model

class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private val adapter by lazy { PlayerAdapter(:: onPlayerClicked) }

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.playerList.adapter = adapter
        adapter.updateItems(arrayListOf(
            model(
            name = "Konstantin ya",
            photoUrl = "https://img-fotki.yandex.ru/get/6614/30348152.149/0_69e5b_13fd8d5b_orig",
            number = 1,
            team = "OGkod",
            age = 12,
            position = PlayerPosition.GOALKEEPER

            ),
            model(
                name = "Konstantin ya",
                photoUrl = "https://img-fotki.yandex.ru/get/6614/30348152.149/0_69e5b_13fd8d5b_orig",
                number = 1,
                team = "OGkod",
                age = 12,
                position = PlayerPosition.GOALKEEPER

            ),
            model(
                name = "Konstantin ya",
                photoUrl = "https://img-fotki.yandex.ru/get/6614/30348152.149/0_69e5b_13fd8d5b_orig",
                number = 1,
                team = "OGkod",
                age = 12,
                position = PlayerPosition.GOALKEEPER

            )
        ))

        // Обращайся к элементам View здесь
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun onPlayerClicked(player: model){
        val bundle =  bundleOf(CardFragment.CARD_PLAYER_KEY to player)
        view?.findNavController()?.navigate(R.id.action_to_navigation_card, bundle)
    }
}