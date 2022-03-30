package com.olivier.todo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView tvTodos;
    Context context;

    private static final String TODOLIST_KEY = "TODOLIST_KEY";
    private List<Todo>  todos = new ArrayList<>();

    private RecyclerView recyclerView;
    private TodoAdapter todoAdapter;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
        //return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.itAddTodo:

                Intent intent = new Intent(context, AddTodoActivity.class);

                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();

        TodoDAO todoDAO = new TodoDAO(context);
        List<Todo> todos = todoDAO.list();

        TodoAdapter todoAdapter = new TodoAdapter(todos, new TodoAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Todo todo) {
                Intent intent = new Intent(context, DetailActivity.class);
                startActivity(intent);
            }
        });

/*        String text = "";

        for( Todo todo : todos){
            text += String.format(" %s / %s \n", todo.getName(), todo.getUrgency());
        }

        tvTodos.setText(text);*/
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        setContentView(R.layout.recyclerview_main);

        // tvTodos = findViewById(R.id.tvTodos);
        recyclerView = findViewById(R.id.tvTodos);/* TODO on call pas le bon main je pense ou c le tvTodos qui est pas du bon type dans les init... */
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        todoAdapter = new TodoAdapter(todos);
        recyclerView.setAdapter(todoAdapter);


        context = getApplicationContext();



    }
}