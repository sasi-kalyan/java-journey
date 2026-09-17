package com.task.tracker.app;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.*;

/*
    TaskJSONUpload - Utility class that adds new task into
     JSON file and saves the content.
 */
public class TaskJSONUpload {

    final static String FILE = "task.json";
    ObjectMapper mapper = new ObjectMapper();

    public void createNewTask(Task task){
        File file = new File(FILE);
        JsonNode rootNode;

        try{
            rootNode = file.exists() ? mapper.readTree(file) : mapper.createObjectNode();

            ObjectNode objectNode = (ObjectNode) rootNode;

            ArrayNode tasks;

            if(objectNode.has("tasks")){
                tasks = (ArrayNode) objectNode.get("tasks");
            }else{
                tasks = mapper.createArrayNode();
                objectNode.set("tasks", tasks);
            }

            tasks.add(mapper.valueToTree(task));

            mapper.writerWithDefaultPrettyPrinter().writeValue(file, objectNode);
            System.out.println("new task added successfully");

        }catch (Exception e){
            System.out.println("exception occurred");
        }
    }
}
