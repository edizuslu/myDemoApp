package com.mycompany.app;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;

public class App{
    
    

    //this method returns true when multiplication of array1 with the last element of array2 equals 
    // multiplication of array2 and the last element of array1. Else this method returns false 
    public static boolean equalityOfExtendedArrays(ArrayList<Integer> array1 , ArrayList<Integer> array2 , int a1 , int a2){
    	
    	if (array1 == null) return false;
    	if (array2 == null) return false;
    	if (array1.size() == 0) return false;
    	if (array2.size() == 0) return false;
    	//you cant entry a emtpy array as array1 or array2

    	if (array1.size() != array2.size()) return false;
    	//you cant entry two array that have different sizes

    	ArrayList<Integer> array1MultiplyWithA1 = new ArrayList<Integer>();
		ArrayList<Integer> array2MultiplyWithA2 = new ArrayList<Integer>();
    	
    	//multiplication the array1 with the last element of array2
    	for (int element : array1){
    		array1MultiplyWithA1.add(element*a2);
    	}    	

    	//multiplication the array1 with the last element of array2
    	for (int element : array2){
    		array2MultiplyWithA2.add(element*a1);
    	}    	

    	boolean control = true;

    	for (int i = 0 ; i < array1MultiplyWithA1.size() ; i++ ){//same sizes

    		if (array1MultiplyWithA1.get(i) != array2MultiplyWithA2.get(i))
    			control = false;
    	}

    	return control;	
    } 



    public static void main(String[] args) {
        
        port(getHerokuAssignedPort());

        get("/", (req, res) -> "Hello, World");

        post("/compute", (req, res) -> {
        
        //input1
        String input1 = req.queryParams("input1");
        java.util.Scanner sc1 = new java.util.Scanner(input1);
        sc1.useDelimiter("[;\r\n]+");
        java.util.ArrayList<Integer> inputList = new java.util.ArrayList<>();
        while (sc1.hasNext()){
        	int value = Integer.parseInt(sc1.next().replaceAll("\\s",""));
            inputList.add(value);
        }
		System.out.println(inputList);

        //second input2
        String input2 = req.queryParams("input2");
        java.util.Scanner sc2 = new java.util.Scanner(input2);
        sc2.useDelimiter("[;\r\n]+");
        java.util.ArrayList<Integer> inputList2 = new java.util.ArrayList<>();
        while (sc2.hasNext()){
        	int value = Integer.parseInt(sc2.next().replaceAll("\\s",""));
            inputList2.add(value);
        }
        System.out.println(inputList2);
        
        //parameter 3 and 4
        int lastElementOfInputList1 = inputList.get(inputList.size()-1);//last element of first input
		int lastElementOfInputList2 = inputList2.get(inputList2.size()-1);//last element of second input


        boolean result = App.equalityOfExtendedArrays(inputList, inputList2 , lastElementOfInputList2 , lastElementOfInputList1 );

        Map map = new HashMap();
        map.put("result", result);
        return new ModelAndView(map, "compute.mustache");
        }, new MustacheTemplateEngine());


        get("/compute",
            (rq, rs) -> {
              Map map = new HashMap();
              map.put("result", "not computed yet!");
              return new ModelAndView(map, "compute.mustache");
            },
            new MustacheTemplateEngine());
    }

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }
}

