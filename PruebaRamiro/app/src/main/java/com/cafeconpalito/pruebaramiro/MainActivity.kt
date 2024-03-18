package com.cafeconpalito.pruebaramiro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cafeconpalito.pruebaramiro.TaskApplication.Companion.prefs

class MainActivity : AppCompatActivity() {

    lateinit var etAddTask: EditText
    lateinit var btAddTask: Button
    lateinit var rvTasks: RecyclerView
    lateinit var btChgView: Button

    lateinit var adapter:TaskAdapter

    var tasks = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initUi()
    }

    private fun initUi() {
        initVariables()
        initListeners()
        initRecyclerView()
    }

    private fun initRecyclerView() {
        tasks = prefs.getTasks()
        rvTasks.layoutManager = LinearLayoutManager(this)
        adapter = TaskAdapter(tasks, this::deleteTask)
        rvTasks.adapter = adapter

    }

    private fun deleteTask(position: Int) {
        tasks.removeAt(position)
        adapter.notifyDataSetChanged()
        prefs.saveTasks(tasks)
        Toast.makeText(this, "The task has been deleted", Toast.LENGTH_SHORT).show()
    }


    private fun initVariables() {
        btChgView = findViewById(R.id.btChgView)
        etAddTask = findViewById(R.id.etAddTask)
        btAddTask = findViewById(R.id.btAddtask)
        rvTasks = findViewById(R.id.rvTasks)
    }

    private fun initListeners() {
        btAddTask.setOnClickListener {addTask()}
        btChgView.setOnClickListener {changeView()}

    }

    private fun changeView() {
        intent.setClass(this, MainActivity2::class.java)
        startActivity(intent)
    }

    private fun addTask() {

        val newTask = etAddTask.text.toString()
        if (newTask.isNotBlank()) {
            tasks.add(newTask)
            prefs.saveTasks(tasks)
            adapter.notifyDataSetChanged()
            etAddTask.setText("")
            Toast.makeText(this, "The task has been added", Toast.LENGTH_SHORT).show()

        }
    }
}