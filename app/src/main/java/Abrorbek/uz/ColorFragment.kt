package Abrorbek.uz

import Abrorbek.uz.databinding.FragmentColorBinding
import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup

class ColorFragment : Fragment() {
    private lateinit var bitmap: Bitmap
    var hext=""
    var rgb=""
    private val binding by lazy {FragmentColorBinding.inflate(layoutInflater)}
    @SuppressLint("ClickableViewAccessibility")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding.ColorFragment.isDrawingCacheEnabled=true
        binding.ColorFragment.buildDrawingCache(true)
        binding.ColorFragment.setOnTouchListener { v, event ->
            if (event.action== MotionEvent.ACTION_DOWN || event.action == MotionEvent.ACTION_MOVE) {
                bitmap = binding.ColorFragment.drawingCache
                val pixel = bitmap.getPixel(event.x.toInt(), event.y.toInt())
                val r = Color.red(pixel)
                val g = Color.green(pixel)
                val b = Color.blue(pixel)
                hext = "#" + Integer.toHexString(pixel)
                rgb = "$r$g$b"
                binding.ColorFragment.setBackgroundColor(Color.rgb(r, g, b))
                MyObject.color = binding.ColorFragment.background
            }
            true}
        return binding.root
    }
}