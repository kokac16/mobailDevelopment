package com.example.mobiledevelopmentcourselabapp.presentation.view.second

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.mobiledevelopmentcourselabapp.R
import com.example.mobiledevelopmentcourselabapp.databinding.CardfragmentBinding
import com.example.mobiledevelopmentcourselabapp.presentation.view.second.model.model

class CardFragment: Fragment() {
    private var _binding: CardfragmentBinding? = null
    private val binding: CardfragmentBinding get() = _binding!!
    private val player by lazy { arguments?.getSerializable(CARD_PLAYER_KEY) as? model }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = CardfragmentBinding.inflate(inflater, container, false)
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) { super.onViewCreated (view, savedInstanceState)
        setHasOptionsMenu(true)
        player?.let {
            binding.name.text = it.name
            binding.number.text = it. number.toString()
            binding.ageValue.text = it.age.toString()
            binding.teamValue.text = it.team
            binding.positionValue.text = it.position.rusName

            Glide.with(view).load(it.photoUrl).into(binding.icon)

        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.share){
            sharePlayerData()
            return true
        }
        return false
    }

    private fun sharePlayerData(){
        val intent  = Intent();
        intent.action = Intent.ACTION_SEND
        intent.type = "text/plain"
        intent.putExtra(Intent.EXTRA_TEXT, player.toString())

        val shareIntent = Intent.createChooser(intent, null)
        startActivity(shareIntent)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.card_menu, menu)
    }



    companion object{
        const val CARD_PLAYER_KEY = "PLAYER_DATA"
    }

}