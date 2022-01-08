package com.mgssoftware.mgsdashboard.adapters.avfastadapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mgssoftware.mgsdashboard.adapters.avfastadapter.avfastviewholder.AvfastGraphicViewHolder
import com.mgssoftware.mgsdashboard.data.avfastmodel.AvfastAPI
import com.mgssoftware.mgsdashboard.databinding.ItemAvfastGraphicBinding
import com.mgssoftware.mgsdashboard.ui.fragment.avfast.AvfastEnum

class AvfastGraphicAdapter(
    private val graphicsTitle: List<String>,
//    private val graphicsDescription: List<String>,
//    private val barBottomValue: List<String>,
    private val apiData: AvfastAPI
) : RecyclerView.Adapter<AvfastGraphicViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AvfastGraphicViewHolder {
        val view =
            ItemAvfastGraphicBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AvfastGraphicViewHolder(view)
    }

    override fun onBindViewHolder(holder: AvfastGraphicViewHolder, position: Int) {
        holder.setAvfastGraphTitle(graphicsTitle[position])

        when (position) {
            AvfastEnum.KAYITLI_KULLANICI.ordinal -> holder.usersInLastFiveMonths(
                apiData.monthlyTotalUsersChart,
                apiData.monthlyTotalUsersCount
            )
            AvfastEnum.GUNLUK_GIRIS.ordinal -> holder.dailyLoginUser(
                apiData.dailyLoggedInUsersChart,
                apiData.dailyLoggedInUsersCount
            )
            AvfastEnum.YENI_TASK.ordinal -> holder.weeklyTasksChart(
                apiData.weeklyTasksChart,
                apiData.weeklyTasksCount
            )
            AvfastEnum.BASVURMA.ordinal -> holder.weeklyAppliedTasks(
                apiData.weeklyAppliedTasksChart,
                apiData.weeklyAppliedTasksCount
            )
            AvfastEnum.KABUL_EDILEN.ordinal -> holder.weeklyEvaluatedTasks(
                apiData.weeklyEvaluatedTasksChart,
                apiData.weeklyEvaluatedTasksCount
            )
            AvfastEnum.TAMAMLANAN.ordinal -> holder.weeklyDoneTasks(
                apiData.weeklyDoneTasksChart,
                apiData.weeklyAppliedTasksCount
            )
        }
    }

    override fun getItemCount() = graphicsTitle.size
}