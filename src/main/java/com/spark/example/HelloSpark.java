package com.spark.example;

import com.google.gson.Gson;
import spark.ModelAndView;
import spark.template.jade.JadeTemplateEngine;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;

public class HelloSpark{

    //In memory list of todo
    private static List<Todo> todos = new ArrayList<>();
    private static Map<String, List<Todo>> todoMap = new HashMap<>();

    private static JadeTemplateEngine templateEngine = new JadeTemplateEngine();
    //To gson transfomer
    private static Gson gson = new Gson();
    public static void main(String[] args) {

        port(8181);
        staticFileLocation("/public");

        todos.add( 0, new Todo().setDescription("Learn Java 8")
                .setDone(false));

        todos.add( 0, new Todo().setDescription("Read ES6")
                .setDone(false));

        todos.add( 0, new Todo().setDescription("Create React.js pet project")
                .setDone(false));

        todos.add( 0, new Todo().setDescription("Finish \"Will power instict\" book " )
                .setDone(false));
        todos.add( 0, new Todo().setDescription("Use Redux")
                .setDone(false));
        todoMap.put("todos", todos);

        get("/",(req,res) ->
                        new ModelAndView(todoMap,"index")
                , templateEngine);
        get("/todo", (req,res) -> todos, gson::toJson );
    }
}