package com.example.shemajamebeli9.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shemajamebeli9.databinding.NumbersBinding
import com.example.shemajamebeli9.models.Numbers

typealias click = (position : Int) -> Unit

class RecyclerAdapter( private val  numbers : MutableList<Numbers>):RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {



    lateinit var click :  click


    inner class ViewHolder(val binding : NumbersBinding ):RecyclerView.ViewHolder(binding.root){

        private lateinit var model : Numbers
        fun bind(){
            model = numbers[adapterPosition]
            if (adapterPosition==10){
            binding.button.setBackgroundResource(model.img!!)
            }else if(adapterPosition==12){
                binding.button.setBackgroundResource(model.img!!)
            }
            else{
               binding.button.text = model.number.toString()
            }

            binding.button.setOnClickListener {
                click.invoke(adapterPosition)
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            NumbersBinding.inflate(LayoutInflater.from(parent.context),
                parent,
                false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount()=numbers.size

}