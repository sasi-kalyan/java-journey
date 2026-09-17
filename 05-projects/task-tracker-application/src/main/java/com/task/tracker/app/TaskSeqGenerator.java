package com.task.tracker.app;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

/*
    TaskSeqGenerator - Utility class that generates the sequence
    number for tasks
 */
public class TaskSeqGenerator {

    final static String FILE = "task.json";

    ObjectMapper mapper = new ObjectMapper();

    public Long generateSeqId(){

        ArrayList<Long> seqArray = new ArrayList<>();

        try{
            File file = new File(FILE);
            JsonNode rootNode;
            rootNode = file.exists() ? mapper.readTree(file) : mapper.createObjectNode();
            ObjectNode objectNode = (ObjectNode) rootNode;
            ArrayNode tasks;

            if(objectNode.has("tasks")){
                tasks = (ArrayNode) objectNode.get("tasks");
            }else{
                tasks = mapper.createArrayNode();
                objectNode.set("tasks", tasks);
                mapper.writerWithDefaultPrettyPrinter().writeValue(file, objectNode);
            }

            for (int i = 0; i < tasks.size(); i++) {
                seqArray.add(tasks.get(i).get("id").asLong());
            }

            if(seqArray.isEmpty()) {
                seqArray.add(1L);
                return seqArray.get(0);
            }

            Collections.sort(seqArray);

            //new sequence id generated
            seqArray.add(seqArray.get(seqArray.size()-1)+1);

        }catch (Exception e){
            System.out.println("exeception occurred");
        }
        return seqArray.get(seqArray.size()-1);
    }
}
