package com.example.mobiledevelopmentcourselabapp.presentation.view.article

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.mobiledevelopmentcourselabapp.R
import com.example.mobiledevelopmentcourselabapp.databinding.FragmentArticleBinding

class ArticleFragment : Fragment() {

    private var likeScore = 0
        set(value) {
            field = value
            _binding?.likeResult?.text = field.toString()
        }

    private var dislikeScore = 0
        set(value){
            field = value
            _binding?.DisLikeResult?.text = field.toString()
        }

    private var _binding: FragmentArticleBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentArticleBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        likeScore = savedInstanceState?.getInt(LIKE_SCORE_TAG) ?: 0
        dislikeScore = savedInstanceState?.getInt(DISLIKE_SCORE_TAG) ?: 0

        context?.let {
            Glide.with(it)
                //.with(it)
                .load("https://img.championat.com/s/732x488/news/big/b/g/stal-izvesten-novyj-kandidat-na-zamenu-kloppu-v-liverpule_17065467721853904716.jpg")
                .placeholder(AppCompatResources.getDrawable(it, R.drawable.photo))
                .into(binding.mainPhoto)
        }

        binding.thumbUp.setOnClickListener {
            likeScore++
        }

        binding.thumbDown.setOnClickListener {
            dislikeScore++
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(LIKE_SCORE_TAG, likeScore)
        outState.putInt(DISLIKE_SCORE_TAG, dislikeScore)
        super.onSaveInstanceState(outState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        private const val LIKE_SCORE_TAG = "LIKE_SCORE"
        private  const val DISLIKE_SCORE_TAG = "DISLIKE_SCORE"
    }
}