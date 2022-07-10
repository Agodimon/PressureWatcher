package com.android.pressurewatcher.ui.main.viewholders

import android.annotation.SuppressLint
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.RecyclerView
import com.android.pressurewatcher.R
import com.android.pressurewatcher.data.models.Health
import com.android.pressurewatcher.databinding.ItemDataBinding
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

class ItemDateCteateViewHolder(
    private val viewBinding: ItemDataBinding
) : RecyclerView.ViewHolder(viewBinding.root) {
    @SuppressLint("NewApi")
    fun bind(health: Health) {
        val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss", Locale.ENGLISH)
        val currentDate = LocalDateTime.parse(health.time, formatter)
        val timeDateFormatter = DateTimeFormatter.ofPattern("HH:mm")
        val time = currentDate.format(timeDateFormatter)
        viewBinding.pulse.text = health.pulse.toString()
        viewBinding.heartBreak.text = health.heartBreak.toString()
        viewBinding.heart.text = health.heartBeat.toString()
        viewBinding.time.text = time
        if (checkNotNull(health.heartBeat) >= 90) {
            viewBinding.containerItemHealthInfo.background =
                AppCompatResources.getDrawable(viewBinding.root.context, R.drawable.back_ground_red)
        } else {
            viewBinding.containerItemHealthInfo.background =
                AppCompatResources.getDrawable(
                    viewBinding.root.context,
                    R.drawable.back_ground_green
                )
        }
    }
}