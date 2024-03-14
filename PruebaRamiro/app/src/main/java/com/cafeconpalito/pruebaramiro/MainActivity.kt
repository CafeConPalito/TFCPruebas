package com.cafeconpalito.pruebaramiro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cafeconpalito.pruebaramiro.TaskApplication.Companion.prefs

class MainActivity : AppCompatActivity() {

    lateinit var etAddTask: EditText
    lateinit var btAddTask: Button
    lateinit var rvTasks: RecyclerView

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
    }


    private fun initVariables() {
        etAddTask = findViewById(R.id.etAddTask)
        btAddTask = findViewById(R.id.btAddtask)
        rvTasks = findViewById(R.id.rvTasks)
    }

    private fun initListeners() {
        btAddTask.setOnClickListener {addTask()}
    }

    private fun addTask() {

        val newTask = etAddTask.text.toString()
        if (newTask.isNotBlank()) {
            tasks.add(newTask)
            prefs.saveTasks(tasks)
            adapter.notifyDataSetChanged()
            etAddTask.setText("")
        }
    }
}