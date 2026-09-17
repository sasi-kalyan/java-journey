package com.task.tracker.app;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.scheduling.config.Task;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
    ShowAllTasks - Utility class that iterates over the JSON file and
    echoes the task related data on the console/ filters the data as per
    task status
 */
public class ShowAllTasks {

    final static String FILE = "task.json";
    ObjectMapper mapper = new ObjectMapper();

    public void showAllTasks(){

        Map<Long, ArrayList<String>> taskList = new HashMap<>();

        try{
            File file = new File(FILE);
            JsonNode rootNode = mapper.readTree(file);
            ObjectNode objectNode = (ObjectNode) rootNode;
            ArrayNode tasks = (ArrayNode) objectNode.get("tasks");

            for(int i=0;i<tasks.size();i++){
                ArrayList<String> list = new ArrayList<>();
                list.add(0, tasks.get(i).get("taskDesc").asText());
                list.add(1, tasks.get(i).get("status").asText());

                taskList.put(tasks.get(i).get("id").asLong(), list);
            }

            for(Map.Entry<Long, ArrayList<String>> entry : taskList.entrySet()){
                Long id = entry.getKey();
                ArrayList<String> taskData = entry.getValue();
                System.out.println(id + " >> "+taskData.get(0)+" >> "+taskData.get(1));
            }
        }catch (Exception e){
            System.out.println("exception occurred");
        }
    }

    public void showAllToDo(){

        Map<Long, ArrayList<String>> taskList = new HashMap<>();

        try{
            File file = new File(FILE);
            JsonNode rootNode = mapper.readTree(file);
            ObjectNode objectNode = (ObjectNode) rootNode;
            ArrayNode tasks = (ArrayNode) objectNode.get("tasks");

            for(int i=0;i<tasks.size();i++){

                if(TaskStatus.valueOf(tasks.get(i).get("status").asText()).equals(TaskStatus.TODO)) {
                    ArrayList<String> list = new ArrayList<>();
                    list.add(0, tasks.get(i).get("taskDesc").asText());
                    list.add(1, tasks.get(i).get("status").asText());

                    taskList.put(tasks.get(i).get("id").asLong(), list);
                }
            }

            for(Map.Entry<Long, ArrayList<String>> entry : taskList.entrySet()){
                Long id = entry.getKey();
                ArrayList<String> taskData = entry.getValue();
                System.out.println(id + " >> "+taskData.get(0)+" >> "+taskData.get(1));
            }
        }catch (Exception e){
            System.out.println("exception occurred");
        }
    }

    public void showInProgress() {

        Map<Long, ArrayList<String>> taskList = new HashMap<>();

        try {
            File file = new File(FILE);
            JsonNode rootNode = mapper.readTree(file);
            ObjectNode objectNode = (ObjectNode) rootNode;
            ArrayNode tasks = (ArrayNode) objectNode.get("tasks");

            for (int i = 0; i < tasks.size(); i++) {

                if (TaskStatus.valueOf(tasks.get(i).get("status").asText()).equals(TaskStatus.IN_PROGRESS)) {
                    ArrayList<String> list = new ArrayList<>();
                    list.add(0, tasks.get(i).get("taskDesc").asText());
                    list.add(1, tasks.get(i).get("status").asText());

                    taskList.put(tasks.get(i).get("id").asLong(), list);
                }
            }

            for (Map.Entry<Long, ArrayList<String>> entry : taskList.entrySet()) {
                Long id = entry.getKey();
                ArrayList<String> taskData = entry.getValue();
                System.out.println(id + " >> " + taskData.get(0) + " >> " + taskData.get(1));
            }
        } catch (Exception e) {
            System.out.println("exception occurred");
        }
    }

    public void showDone(){

        Map<Long, ArrayList<String>> taskList = new HashMap<>();

        try{
            File file = new File(FILE);
            JsonNode rootNode = mapper.readTree(file);
            ObjectNode objectNode = (ObjectNode) rootNode;
            ArrayNode tasks = (ArrayNode) objectNode.get("tasks");

            for(int i=0;i<tasks.size();i++){

                if(TaskStatus.valueOf(tasks.get(i).get("status").asText()).equals(TaskStatus.DONE)) {
                    ArrayList<String> list = new ArrayList<>();
                    list.add(0, tasks.get(i).get("taskDesc").asText());
                    list.add(1, tasks.get(i).get("status").asText());

                    taskList.put(tasks.get(i).get("id").asLong(), list);
                }
            }

            for(Map.Entry<Long, ArrayList<String>> entry : taskList.entrySet()){
                Long id = entry.getKey();
                ArrayList<String> taskData = entry.getValue();
                System.out.println(id + " >> "+taskData.get(0)+" >> "+taskData.get(1));
            }
        }catch (Exception e){
            System.out.println("exception occurred");
        }
    }
}
