package com.mycompany.app;
import java.util.ArrayList;
import java.util.Arrays;

//import junit.framework.TestCase;

/**
 * Hello world!
 *
 */
public class App {

	public static boolean search(ArrayList<Integer> array, int e) {
        System.out.println("inside search");
        if (array == null) return false;
  
        for (int elt : array) {
          if (elt == e) return true;
        }
        
        return false;
    }



    public static void main( String[] args ){
        
        System.out.println( "Hello World!" );
    }
}
