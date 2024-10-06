package com.example.hello

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment

class PersonalInfoFragment : Fragment() {

    private lateinit var profileImageView: ImageView
    private lateinit var nameTextView: TextView
    private lateinit var emailTextView: TextView
    private lateinit var phoneTextView: TextView
    private lateinit var addressTextView: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_personal_info, container, false)

        // Initialize views
        profileImageView = view.findViewById(R.id.profile_image)
        nameTextView = view.findViewById(R.id.text_name)
        emailTextView = view.findViewById(R.id.text_email)
        phoneTextView = view.findViewById(R.id.text_phone)
        addressTextView = view.findViewById(R.id.text_address)

        // Set initial data (You can get this data from a database or shared preferences)
        setPersonalInfo()

        return view
    }

    private fun setPersonalInfo() {
        // Set static personal information, this can be retrieved from a database or preferences
        nameTextView.text = "Sachin"
        emailTextView.text = "sachin9820246@gmail.com"
        phoneTextView.text = "6361688905"
        addressTextView.text = "Kormangala"
    }
}
