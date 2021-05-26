package com.flb.fizzbuzz.showfizzbuzz

import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.flb.fizzbuzz.FizzbuzzManager
import com.flb.fizzbuzz.databinding.FizzbuzzAdapterContentItemBinding
import com.flb.fizzbuzz.databinding.FizzbuzzAdapterTitleItemBinding

class ShowFizzbuzzAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val title_viewtype = 0
    private val content_viewtype = 1

    // As adapter position starts at 0 but we want from 1 to limit,
    // we offset the position received in onBind to compute the value displayed
    private val offset = 1
    private val fizzbuzz = FizzbuzzManager.getFizzbuzz()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            title_viewtype -> {
                val binding = FizzbuzzAdapterTitleItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                TitleHolder(binding.root)
            }
            else -> {
                val binding = FizzbuzzAdapterContentItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                ContentHolder(binding.root)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ContentHolder -> {
                val computedValue = FizzbuzzManager.getComputedValue(position)
                if (computedValue.contains(fizzbuzz.buzzText) || computedValue.contains(fizzbuzz.fizzText)) {
                    holder.textView.setTypeface(null, Typeface.BOLD)
                } else {
                    holder.textView.setTypeface(null, Typeface.NORMAL)
                }
                holder.textView.text = computedValue
            }
        }
    }

    override fun getItemCount(): Int {
        return fizzbuzz.limitValue + offset
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == 0) {
            title_viewtype
        } else {
            content_viewtype
        }
    }

    class TitleHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {}

    class ContentHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView = itemView as TextView
    }
}
