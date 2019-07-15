package my.onotolo.android.andrset.example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_main.*
import my.onotolo.android.andrset.example.settings.ImageShrinkValue
import my.onotolo.android.andrset.example.settings.IsImageShown

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        handleImageVisibility()
        handleImageShrinkValue()

        setting_switch.setOnCheckedChangeListener { buttonView, isChecked ->

            IsImageShown[this] = !IsImageShown[this]
            handleImageVisibility()
        }

        shrink_seek_bar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if (!fromUser)
                    return

                ImageShrinkValue[this@MainActivity] = progress
                handleImageShrinkValue()
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })
    }

    private fun handleImageVisibility() {

        val isImageVisible = IsImageShown[this]

        cat_view?.visibility = when(isImageVisible) {
            true -> View.VISIBLE
            false -> View.INVISIBLE
        }

        setting_switch.isChecked = isImageVisible
    }

    private fun handleImageShrinkValue() {
        val shrinkValue = ImageShrinkValue[this] + 1

        val scale = 1f / shrinkValue

        cat_view?.scaleX = scale
        cat_view?.scaleY = scale
    }
}
