package com.example.workoutlog

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.workoutlog.data.Workout
import com.example.workoutlog.databinding.FragmentAddExerciseBinding
import com.example.workoutlog.databinding.FragmentAddWorkoutBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AddExerciseFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AddExerciseFragment : Fragment() {
    // TODO: Rename and change types of parameters

    lateinit var workout: Workout
    private var param1: String? = null
    private var param2: String? = null
    private var _binding: FragmentAddExerciseBinding? = null
    private val binding get() = _binding!!
    private lateinit var workoutName: String
    private val navigationArgs: AddExerciseFragmentArgs by navArgs()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_add_exercise, container, false)
        _binding = FragmentAddExerciseBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.saveBtn.setOnClickListener {
            val action = AddExerciseFragmentDirections.actionAddExerciseFragmentToSecondFragment(workout.workoutName, workout.id)
            findNavController().navigate(action)
        }
    }
    private fun saveExercise(){
        val stringInTextField = binding.repInput1.text.toString()
        val rep1 = stringInTextField.toIntOrNull()
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment AddExerciseFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AddExerciseFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}