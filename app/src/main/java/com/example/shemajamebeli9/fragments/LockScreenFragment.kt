package com.example.shemajamebeli9.fragments

import android.graphics.Color.green
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.graphics.green
import androidx.recyclerview.widget.GridLayoutManager
import com.example.shemajamebeli9.R
import com.example.shemajamebeli9.adapters.RecyclerAdapter
import com.example.shemajamebeli9.databinding.LockScreenFragmentBinding
import com.example.shemajamebeli9.models.Numbers

class LockScreenFragment : Fragment() {


    private lateinit var binding : LockScreenFragmentBinding

    private lateinit var adapter : RecyclerAdapter

    private val  numbers  = mutableListOf<Numbers>()

    private val pin = mutableListOf<Int>()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =LockScreenFragmentBinding.inflate(inflater,container,false)
        init()
        return binding.root
    }

    private fun init(){

        setNumbers()
        initRecycler()
        pin()
        checkPin()


    }


    private fun initRecycler(){
        adapter = RecyclerAdapter(numbers)
        binding.numbersRecycler.layoutManager = GridLayoutManager(context,3)
        binding.numbersRecycler.adapter = adapter
    }


    private fun setNumbers(){
        numbers.add(Numbers(number = 1))
        numbers.add(Numbers(number = 2))
        numbers.add(Numbers(number = 3))
        numbers.add(Numbers(number = 4))
        numbers.add(Numbers(number = 5))
        numbers.add(Numbers(number = 6))
        numbers.add(Numbers(number = 7))
        numbers.add(Numbers(number = 8))
        numbers.add(Numbers(number = 9))
        numbers.add(Numbers(img = R.drawable.ic_touchid))
        numbers.add(Numbers(number = 0))
        numbers.add(Numbers(img = R.drawable.delete))
    }


    private fun checkPin(){
        when(pin.size){
            0->{
                binding.firstrDot.setImageResource(R.drawable.ic_dot)
            }
            1->{binding.secondDot.setImageResource(R.drawable.ic_dot)}
            2->{binding.sirdDot.setImageResource(R.drawable.ic_dot)}
            3->{//aq uwevs  mtavari logika :D :D :D da ver vaswreb
                //aq und amoxdes shedareba pini sworia tu ara da tu sworia raunda moxdes da tu araa raunda moxdes
                // :D :D :D :D :D
            }

        }
    }

    private fun pin(){
        adapter.click = {
            when(it){
                12->{pin.removeLast()
                    checkPin()}
                10-> {

                    checkPin()
                //aq unda tuch idis logika

                }
                else ->{ pin.add(it)
                    checkPin()
                }
            }

        }
    }





}