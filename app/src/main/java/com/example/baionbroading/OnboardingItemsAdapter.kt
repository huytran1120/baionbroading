package com.example.baionbroading

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class OnboardingItemsAdapter(private val onbroadingItem: List<OnbroadingItem>):
    RecyclerView.Adapter<OnboardingItemsAdapter.OnboardingItemViewHolder>(){

    inner class OnboardingItemViewHolder(view: View): RecyclerView.ViewHolder(view){
        private val imageOnboarding = view.findViewById<ImageView>(R.id.imageOnboarding)
        private  val textTitle = view.findViewById<TextView>(R.id.textTitle)
        private  val textDescription = view.findViewById<TextView>(R.id.textDescription)

        fun bind(onbroadingItem: OnbroadingItem){
            imageOnboarding.setImageResource(onbroadingItem.onbroadingImage)
            textTitle.text = onbroadingItem.title
            textDescription.text = onbroadingItem.description
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnboardingItemViewHolder {
        return OnboardingItemViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.onbroading_item_container,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: OnboardingItemViewHolder, position: Int) {
        holder.bind(onbroadingItem[position])
    }

    override fun getItemCount(): Int {
        return onbroadingItem.size
    }
}