package com.cafeconpalito.pruebas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import androidx.core.os.bundleOf
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cafeconpalito.pruebas.BottonMenuFragment.Companion.BUNDLE_NOMBRE
import com.cafeconpalito.pruebas.BottonMenuFragment.Companion.BUNDLE_SALUDO
import com.cafeconpalito.pruebas.TaskApplication.Companion.prefs
import com.cafeconpalito.pruebas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //Se utiliza para obtener toda la componentes e informacion que tiene un Layout
    private lateinit var binding: ActivityMainBinding

    private lateinit var rvTasks: RecyclerView
    private lateinit var etAddTask: EditText

    //Inicializados con Binding
    //lateinit var btnAddTask: Button
    //lateinit var btComics: Button

    private lateinit var adapter:TaskAdapter

    private var tasks = mutableListOf<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Inicializo el binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

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
        initFragments()
    }

    //Intanciando mi menu inferior
    private fun initFragments() {

        /*
        //SE OCUPA DE CARGAR EL FRAGMENTO!
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            add<BottonMenuFragment>(R.id.fragmentContainerView)
        }
        */

        //LO MISMO CON ARGUMENTOS CON ARGUMENTOS!
        val bundle = bundleOf(BUNDLE_SALUDO to "Hola Holita", BUNDLE_NOMBRE to " Ramiro")
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            add<BottonMenuFragment>(R.id.fragmentContainerView, args = bundle)
        }

    }

    /**
     * Le dice donde se encuentran los elementos de la vista activity_main.xml
     */
    private fun initVariables() {

        etAddTask = binding.etAddTask

        rvTasks = binding.rvTasks
        //rvTasks = findViewById(R.id.rvTasks)

        //Declaracion anulada con Binding
        //btnAddTask = findViewById(R.id.btAddTask)
        //btComics = findViewById(R.id.btComics)

    }

    /**
     * inicializa todos los listener que quiera en este metodo
     */
    private fun initListeners() {
        //boton AddTask Listener on click
        binding.btAddTask.setOnClickListener {addTask()}
        binding.btComics.setOnClickListener {changeViewToComics()}
        //etTask.setOnKeyListener { addTask() }
    }

    /**
     * Cambiar de vista
     */
    private fun changeViewToComics() {

        //Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        val intent =  Intent(this,comicActivity::class.java)

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

        val newTask = etAddTask.text.toString()
        if (newTask.isNotBlank()) { // Si el texto esta vacio no hace nada
            tasks.add(newTask)
            prefs.saveTasks(tasks) // Guardar la info en una persistencia.



            //Seria el Correcto no me gusta tanto me quedo con el que revisa todo.
            //adapter.notifyItemInserted(tasks.size)

            adapter.notifyDataSetChanged()

            //Limpia el campo de texto
            etAddTask.text.clear()
            //etTask.setText("")
        }

    }

    /**
     * Borra la tarea de la lista y actualiza la lista.
     */
    private fun deleteTask(position: Int){
        tasks.removeAt(position)
        prefs.saveTasks(tasks)

        //Correcto aviso de que borro algo
        adapter.notifyItemRemoved(position)
        //Metodo antiguo que revisa toda la lista
        //adapter.notifyDataSetChanged()
    }

}