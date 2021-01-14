package com.example.generics;

import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

public class ProductCounter {
    // Create a Counting Map
    // Create a Name Mapping Map
    private Map <String, Long> partNumbers = new ConcurrentHashMap<>();
    private Map <String,String> productDescription = new TreeMap<>();

    public static void main(String[] args) {

        // List of part data
        String[] parts = new String[]{"1S01", "1S01", "1S01", "1S01", "1S01", "1S02", "1S02", "1S02", "1H01", "1H01", "1S02", "1S01", "1S01", "1H01", "1H01", "1H01", "1S02", "1S02", "1M02", "1M02", "1M02"};

        // Create Product Name Part Number map
        Map<String, String> productNames = new TreeMap<>();
        productNames.put("Blue Polo Shirt", "1S01");
        productNames.put("Black Polo Shirt", "1S02");
        productNames.put("Red Ball Cap", "1H01");
        productNames.put("Duke Mug   ", "1M02");
        productNames.put("test","1414");
        // Create Product Counter Object and process data
        System.out.println("=== Product Report ===");
        ProductCounter product = new ProductCounter(productNames);
        product.processList(parts);
        product.printReport();
    }

    public ProductCounter(Map<String,String> productNames) {
        for (Entry<String,String> entry : productNames.entrySet()) {
            productDescription.put(entry.getValue(), entry.getKey());
        }
    }

    public void processList(String[] list) {
        for (String string : list) {
            if (partNumbers.containsKey(string)){
                   Long count = partNumbers.get(string);
                   count ++;
                   partNumbers.put(string, count);
            } else {
                partNumbers.put(string, 1L);
            }
        }
    }

    public void printReport() {
       System.out.println("\n" + partNumbers);
       System.out.println("\n"+ productDescription);
    }
    
}
