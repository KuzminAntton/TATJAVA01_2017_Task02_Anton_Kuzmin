package com.epam.task2;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Shop {
    private final Integer ITEMS_LIMIT = 3;

    private Map<String,SportEquipment> goods = new HashMap<>();
    private Map<String, Integer> available = new HashMap<>();
    private Map<Person,HashMap<String,Integer>> tallySheet = new HashMap<>();

    public void fillShopItems(String wayToFile) throws Exception {
        List<String> lines = Files.readAllLines(Paths.get(wayToFile));
        String [] arr;
        for (String line : lines) {
            arr = line.split(",");
            if(arr.length != 4) {
                throw new Exception("invalid input from file");
            }
//            System.out.println(arr[0] + " " + arr[1] + " " + Integer.parseInt(arr[2]) +
//            " " + Integer.parseInt(arr[3].replace(" ","")));
            String goodName = arr[0] + "_" + arr[1];

           goods.put(goodName ,new SportEquipment(arr[0],arr[1],Integer.valueOf(arr[2])));
           available.put(goodName,Integer.valueOf(arr[3].replace(" ", "")));

        }
    }

    public void requestHandler (Person person, String category, String title,int quantity) throws Exception {
        String goodName = category + "_" + title;

        if(!tallySheet.containsKey(person)) {
            Map<String, Integer> userItemsList = new HashMap<>();
            tallySheet.put(person, (HashMap<String, Integer>) userItemsList);
        }
        int itemsTotal = 0;
        HashMap<String, Integer> personRepo = tallySheet.get(person);
        for(Integer quant : personRepo.values()) {
            itemsTotal += quant;
        }
        if (itemsTotal + quantity > ITEMS_LIMIT) {
            throw new Exception("Exceeded the limit of goods per person " + person );
        } else if (!available.containsKey(goodName) || available.get(goodName) < quantity) {
            throw new Exception("Insufficient number of goods in the shop");
        } else {
            available.put(goodName, available.get(goodName) - quantity);
            if (personRepo.containsKey(goodName)) {
                personRepo.put(goodName, personRepo.get(goodName) + quantity);
            }
            else {
                personRepo.put(goodName, quantity);
            }
        }
    }

    public void setEquipment(String goodName,int quantity) {
        available.put(goodName,quantity);
    }

    public void printAvilable() {
        for(Map.Entry<String,Integer> pair : available.entrySet()) {
            System.out.println(pair.getKey() + " " + pair.getValue());
        }
    }

    public void printTalltSheet() {
        for(Map.Entry<Person, HashMap<String, Integer>> pair : tallySheet.entrySet()) {
            System.out.println(pair.getKey() + " " + pair.getValue());
        }
    }

}
