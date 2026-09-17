package com.task.tracker.app;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
/*
    TaskJSONUpdate - Utility class that updates the task info like desc,
    updated timings in the JSON file and re-saves the content again.
 */
public class TaskJSONUpdate {

    final static String FILE = "task.json";
    ObjectMapper mapper = new ObjectMapper();

    public void updateTask(Long id, Task task){
        try{
            File file = new File(FILE);
            JsonNode rootNode = mapper.readTree(file);
            ObjectNode objectNode = (ObjectNode) rootNode;

            ArrayNode tasks = (ArrayNode) objectNode.get("tasks");

            for(int i=0;i< tasks.size();i++){
                if(tasks.get(i).get("id").asLong() == task.getId()){
                    if(task.getStatus() == null){
                        task.setStatus(TaskStatus.valueOf(tasks.get(i).get("status").asText()));
                    }
                    if(task.getCreatedAt() == null){
                        task.setCreatedAt(String.valueOf(tasks.get(i).get("createdAt")).replace("\"", ""));
                    }
                    tasks.remove(i);
                    tasks.add(mapper.valueToTree(task));
                }
            }

            mapper.writerWithDefaultPrettyPrinter().writeValue(file, objectNode);
            System.out.println("task updated successfully");

        }catch (Exception e){
            System.out.println("execption occurred");
        }
    }
}
