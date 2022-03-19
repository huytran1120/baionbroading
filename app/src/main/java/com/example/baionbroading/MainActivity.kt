package com.example.baionbroading

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2

class MainActivity : AppCompatActivity() {
    private lateinit var onboardingItemsAdapter: OnboardingItemsAdapter
    private lateinit var indicatorsContainer: LinearLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setOnbroadingItem()
        //setupIndicators()
    }
    private fun setOnbroadingItem(){
        onboardingItemsAdapter = OnboardingItemsAdapter(
            listOf(
                OnbroadingItem(
                    R.drawable.logo12,
                    title = "Browse your  menu\n" +
                            "and order directly",
                    description = "Our app can send you everywhere, even space. For only $2.99 per month"
                ),
                OnbroadingItem(
                    R.drawable.logo22,
                    title = "Even to space with us! Together",
                    description = "Our app can send you everywhere, "
                ),
                OnbroadingItem(
                    R.drawable.logo32,
                    title = "Pickup delivery at your door",
                    description = "Our app can send you everywhere, even space. For only $2.99 per month"
                )
            )
        )
        val onboardingViewPager =findViewById<ViewPager2>(R.id.onboardingViewPager)
        onboardingViewPager.adapter=onboardingItemsAdapter
    }
    private fun setupIndicators(){
        indicatorsContainer = indicatorsContainer
        val indicator = arrayOfNulls<ImageView>(onboardingItemsAdapter.itemCount)
        val layoutParams: LinearLayout.LayoutParams =
            LinearLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT)
        layoutParams.setMargins(8,0,8,0)
        for (i in indicator.indices){
            indicator[i] = ImageView(applicationContext)
            indicator[i]?.let{
                it.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_inactive_background
                    )
                )
                it.layoutParams = layoutParams
                indicatorsContainer.addView(it)
            }
        }
    }
}