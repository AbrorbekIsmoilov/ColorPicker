package Abrorbek.uz

import Abrorbek.uz.databinding.FragmentAsosiyBinding
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class AsosiyFragment : Fragment() {
    private val binding by lazy { FragmentAsosiyBinding.inflate(layoutInflater) }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding.colora.setOnClickListener {
            val colorFragment = ColorFragment()
            parentFragmentManager.beginTransaction()
                .addToBackStack(colorFragment.toString())
                .replace(R.id.my_container, colorFragment)
                .commit()
        }
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        if (MyObject.color != null) {
            binding.fram.background = MyObject.color
        }
    }
}