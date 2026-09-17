package com.task.tracker.app;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;

/*
    TaskJSONDelete - Utility class that deletes the task from the
    JSON file and re-saves the content again.
 */
public class TaskJSONDelete {

    final static String FILE = "task.json";
    ObjectMapper mapper = new ObjectMapper();

    public void deleteTask(Long id) {
        File file = new File(FILE);

        try{
            JsonNode rootNode = mapper.readTree(file);
            ObjectNode objectNode = (ObjectNode) rootNode;

            ArrayNode tasks = (ArrayNode) objectNode.get("tasks");

            for(int i=0;i<tasks.size();i++){
                if(tasks.get(i).get("id").asLong() == id){
                    tasks.remove(i);
                    break;
                }
            }

            mapper.writerWithDefaultPrettyPrinter().writeValue(file, objectNode);
            System.out.println("task deleted successfully");

        }catch (Exception e){
            System.out.println("exception occurred");
        }

    }
}
