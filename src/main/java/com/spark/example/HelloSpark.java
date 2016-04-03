package com.spark.example;

import com.google.gson.Gson;
import spark.ModelAndView;
import spark.template.jade.JadeTemplateEngine;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static spark.Spark.*;

public class HelloSpark{

    //In memory list of todo
    private static List<Todo> todos = new ArrayList<>();

    private static JadeTemplateEngine templateEngine = new JadeTemplateEngine();
    //JSON transfomer
    private static Gson gson = new Gson();

    public static void main(String[] args) {
        //configure port
        port(8181);
        //static file location
        staticFileLocation("/public");

        //ModelAndView does not accept null
        get("/",(req,res) ->
                        new ModelAndView(new HashMap<String, Object>(),"index")
                , templateEngine);

        get("/todo", (req,res) -> todos, gson::toJson );
    }
}