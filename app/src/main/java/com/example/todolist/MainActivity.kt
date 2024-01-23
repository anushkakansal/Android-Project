package com.example.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.TodoAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var todoAdapter: TodoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        todoAdapter = TodoAdapter(mutableListOf())

        val rvTodoItems: RecyclerView = findViewById(R.id.rvToDItems)
        rvTodoItems.adapter = todoAdapter
        rvTodoItems.layoutManager = LinearLayoutManager(this)

        val btnAddToDo: Button = findViewById(R.id.btnAddToDo)
        val btnDeleteToDo: Button = findViewById(R.id.btnDeleteDoneTodos)
        val txt: EditText = findViewById(R.id.etToDoTitle)

        btnAddToDo.setOnClickListener {
            val todoTitle = txt.text.toString()
            if (todoTitle.isNotEmpty()) {
                val todo = Todo(todoTitle)
                todoAdapter.addTodo(todo)
                txt.text.clear()
            }
        }
        btnDeleteToDo.setOnClickListener {
            todoAdapter.deleteDoneTodos()
        }
    }
}