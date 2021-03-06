package com.hyt.punchapp.view.activity.main

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.blankj.utilcode.util.ToastUtils
import com.dylanc.viewbinding.BindingViewHolder
import com.dylanc.viewbinding.newBindingViewHolder
import com.hyt.punchapp.R
import com.hyt.punchapp.databinding.ItemMainBinding

/**
 * author : Hyt
 * time : 2021/03/06
 * version : 1.0
 *
 */
class MainRVAdapter(private val mContext: Context) : RecyclerView.Adapter<BindingViewHolder<ItemMainBinding>>() {

    private var mList = mutableListOf<String>()

    private lateinit var listener: OnRVListener

    //override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingViewHolder<ItemMainBinding> {
      /*  val view = LayoutInflater.from(mContext).inflate(R.layout.item_main, parent, false)
        val mainRVHolder = MainRVHolder(view)
        mainRVHolder.text.setOnClickListener {
            if(::listener.isInitialized){
                listener.onClick(mainRVHolder.adapterPosition)
            }
        }*/
     /*   return  newBindingViewHolder(parent)
    }
*/
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingViewHolder<ItemMainBinding> = newBindingViewHolder(parent)


    override fun onBindViewHolder(holder: BindingViewHolder<ItemMainBinding>, position: Int) {

        holder.binding.itemMainText.text = "121245"
    }


    //  override fun onBindViewHolder(holder: MainRVHolder, position: Int) {
        /*
        holder.text.setOnClickListener {
            ToastUtils.showLong("单击了${holder.text.text} position:$position")
        }*/
   // }

    override fun getItemCount(): Int {
        return mList.size
    }

    fun setList(list: MutableList<String>){
        this.mList = list
        notifyDataSetChanged()
    }

    fun setItemListener(listener: OnRVListener){
        this.listener = listener
    }


}

class MainRVHolder(view: View) : RecyclerView.ViewHolder(view) {
    val text: TextView = view.findViewById(R.id.itemMain_text)

}

interface OnRVListener{
    fun onClick(position: Int)
}

