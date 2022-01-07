package com.mgssoftware.mgsdashboard.adapters.petneradapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import com.mgssoftware.mgsdashboard.R
import com.mgssoftware.mgsdashboard.databinding.ItemPetnerGraphicBinding

class PetnerGraphicAdapter(
    private val graphicsTitle: List<String>,
    private val graphicsDescription: List<String>,
    private val barBottomValue: List<String>
) : RecyclerView.Adapter<PetnerGraphicAdapter.PetnerViewHolder>() {

    private lateinit var binding: ItemPetnerGraphicBinding

    inner class PetnerViewHolder(val itemBinding: ItemPetnerGraphicBinding) :
        RecyclerView.ViewHolder(itemBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PetnerViewHolder {
        binding =
            ItemPetnerGraphicBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PetnerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PetnerViewHolder, position: Int) {
        val currentGraphicsTitle = graphicsTitle[position]
        val currentGraphicsDescription = graphicsDescription[position]
        holder.itemBinding.graphicTitleText.text = currentGraphicsTitle
        holder.itemBinding.graphicDescription.text = currentGraphicsDescription
        val context = holder.itemView.context

        val barEntry = arrayListOf<BarEntry>()

        barEntry.add(BarEntry(1f, 100f))
        barEntry.add(BarEntry(2f, 200f))
        barEntry.add(BarEntry(3f, 300f))
        barEntry.add(BarEntry(4f, 400f))
        barEntry.add(BarEntry(5f, 500f))

        val barDataSet = BarDataSet(barEntry, "")
        barDataSet.color = ContextCompat.getColor(
            context,
            R.color.application_purple
        )
        val barData = BarData(barDataSet)
        barData.setDrawValues(false)
        barData.barWidth = 0.75f
        binding.barChart.apply {
            animateY(1750)
            setFitBars(true)
            data = barData
            description.isEnabled = false
            legend.formSize = 0f
            legend.textSize = 16f
            xAxis.valueFormatter = IndexAxisValueFormatter(barBottomValue)
            xAxis.textColor = ContextCompat.getColor(context, R.color.black)
            xAxis.position = XAxis.XAxisPosition.BOTTOM
            xAxis.isEnabled = true
            xAxis.textSize = 14f
            xAxis.axisLineWidth = 1f
            xAxis.axisLineColor = ContextCompat.getColor(context, R.color.black)
            xAxis.gridColor = ContextCompat.getColor(context, R.color.white)
            axisRight.isEnabled = false
            axisLeft.textColor = ContextCompat.getColor(context, R.color.black)
            axisLeft.axisLineColor = ContextCompat.getColor(context, R.color.black)
            axisLeft.axisLineWidth = 1f
            axisLeft.isEnabled = true
            axisLeft.textSize = 14f
            axisLeft.setDrawGridLines(false)
            invalidate()
        }
    }

    override fun getItemCount() = graphicsTitle.size
}