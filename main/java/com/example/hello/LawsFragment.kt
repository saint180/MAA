package com.example.hello

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment

class LawsFragment : Fragment() {

    private var pressCount = 0
    private var lastPressTime = 0L

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_laws, container, false)

        // Set up the ListView
        val listView = view.findViewById<ListView>(R.id.listViewLaws)
        val lawCategories = arrayOf(
            "Civil Law", "Criminal Law", "Family Law", "Elder Law", "Employment Law",
            "Immigration Law", "Intellectual Property Law", "Environmental Law",
            "Corporate Law", "Tax Law", "Real Estate Law", "Contract Law",
            "Bankruptcy Law", "Healthcare Law", "Personal Injury Law",
            "Estate Planning Law", "Administrative Law", "International Law",
            "Consumer Protection Law", "Military Law", "Transportation Law"
        )
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, lawCategories)
        listView.adapter = adapter

        // Set up key listener for the fragment's view
        view.isFocusableInTouchMode = true
        view.requestFocus()
        view.setOnKeyListener { _, keyCode, event ->
            onKeyDown(keyCode, event)
        }

        return view
    }

    // Handle key press events
    private fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        if (keyCode == KeyEvent.KEYCODE_VOLUME_DOWN || keyCode == KeyEvent.KEYCODE_VOLUME_UP) {
            val currentTime = System.currentTimeMillis()
            if (currentTime - lastPressTime < 1000) {
                pressCount++
                if (pressCount == 5) {
                    checkCallPermissionAndMakeCall()
                    pressCount = 0
                }
            } else {
                pressCount = 1
            }
            lastPressTime = currentTime
            return true
        }
        return false
    }

    // Check call permission and make a call
    private fun checkCallPermissionAndMakeCall() {
        if (ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(arrayOf(Manifest.permission.CALL_PHONE), CALL_PERMISSION_REQUEST_CODE)
        } else {
            makeCall()
        }
    }

    // Make the call
    private fun makeCall() {
        val intent = Intent(Intent.ACTION_CALL)
        intent.data = Uri.parse("tel:1234567890") // Replace with the desired phone number
        startActivity(intent)
    }

    // Handle permission result
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        if (requestCode == CALL_PERMISSION_REQUEST_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                makeCall()
            } else {
                Toast.makeText(requireContext(), "Permission denied to make calls", Toast.LENGTH_SHORT).show()
            }
        }
    }

    companion object {
        private const val CALL_PERMISSION_REQUEST_CODE = 1
    }
}
