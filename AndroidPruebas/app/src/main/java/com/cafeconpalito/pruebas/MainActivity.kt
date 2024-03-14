package com.cafeconpalito.pruebas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cafeconpalito.pruebas.TaskApplication.Companion.prefs
class MainActivity : AppCompatActivity() {

    lateinit var etTask: EditText
    lateinit var btnAddTask: Button
    lateinit var rvTasks: RecyclerView
    lateinit var btComics: Button

    lateinit var adapter:TaskAdapter

    var tasks = mutableListOf<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initUi() //Inicializa la UI
    }

    /**
     * Esto inicializa los valores necesarios para funcionar.
     * Arranca las var que tienen lateinit
     */
    private fun initUi() {
        initVariables()
        initListeners()
        initRecyclerView()
    }

    /**
     * Le dice donde se encuentran los elementos de la vista activity_main.xml
     */
    private fun initVariables() {
        etTask = findViewById(R.id.etAddTask)
        btnAddTask = findViewById(R.id.btAddTask)
        rvTasks = findViewById(R.id.rvTasks)
        btComics = findViewById(R.id.btComics)
    }

    /**
     * inicializa todos los listener que quiera en este metodo
     */
    private fun initListeners() {
        //boton AddTask Listener on click
        btnAddTask.setOnClickListener {addTask()}
        btComics.setOnClickListener {changeViewToComics()}
        //etTask.setOnKeyListener { addTask() }
    }

    /**
     * Cambiar de vista
     */
    private fun changeViewToComics() {

        //Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        val intent:Intent =  Intent(this,comicController::class.java)

        startActivity(intent)

    }

    /**
     * Inicializa el Recicler View para que añada la lista de elementos si los hubiera.
     */
    private fun initRecyclerView(){
        //Para iniciar el RV necesito actualizar las Tasks.
        tasks = prefs.getTasks()

        //El estilo del la lista de Objetos para mostrar (lista vertical normalita)
        rvTasks.layoutManager = LinearLayoutManager(this)
        //Le paso la lista al adaptador inicialmente.
        // Con lambda
        adapter = TaskAdapter(tasks) { deleteTask(it) }
        //Sin lambda
        //adapter = TaskAdapter(tasks, {deleteTask(it)})
        //le paso el adaptador a el Recycler View
        rvTasks.adapter = adapter



    }

    /**
     * Metodo que añade tareas a la lista, llamado desde el listener del Boton!
     */
    private fun addTask() {

        val newTask = etTask.text.toString()
        if (!newTask.isBlank()) { // Si el texto esta vacio no hace nada
            tasks.add(newTask)
            prefs.saveTasks(tasks) // Guardar la info en una persistencia.
            adapter.notifyDataSetChanged()
            //Limpia el campo de texto
            etTask.text.clear()
            //etTask.setText("")
        }

    }

    /**
     * Borra la tarea de la lista y actualiza la lista.
     */
    private fun deleteTask(position: Int){
        tasks.removeAt(position)
        prefs.saveTasks(tasks)
        adapter.notifyDataSetChanged()
    }

}