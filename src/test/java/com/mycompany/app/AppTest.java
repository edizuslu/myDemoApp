package com.mycompany.app;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.ArrayList;
import java.util.Arrays;

import junit.framework.TestCase;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName ){
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite(){
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp(){
        assertTrue( true );
    }

    

    public void testNullFirstArray() {
        ArrayList<Integer> array = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        assertFalse(new App().equalityOfExtendedArrays(null , array , 4 , 0 ));
    }


    public void testNullSecondArray() {
        ArrayList<Integer> array = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        assertFalse(new App().equalityOfExtendedArrays(array , null , 0 , 4 ));
    }

    public void testEmptyArray1() {
      ArrayList<Integer> array = new ArrayList<>();
      ArrayList<Integer> array2 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        
      assertFalse(new App().equalityOfExtendedArrays(array, array2 , 4 , 0 ));
    }

    public void testEmptyArray2() {
      ArrayList<Integer> array = new ArrayList<>();
      ArrayList<Integer> array2 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        
      assertFalse(new App().equalityOfExtendedArrays(array2, array , 0 , 4));
    }

    public void notEqualTheMultiplicationOfTheArrays(){//array1 multiply with the last element of array2
      ArrayList<Integer> array1 = new ArrayList<>(Arrays.asList(4, 3, 2, 1));//for example multiply with 3 the array1  
      ArrayList<Integer> array2 = new ArrayList<>(Arrays.asList(9, 10, 4, 3));//for example multiply with 1 the array2  
      //expected arrays : array1 =  4 3 2 1 , array2 12 9 6 3 it will return true because 4 3 2 1 is multiplyied with 3 and 12 9 6 3 mul with 1
      assertFalse(new App().equalityOfExtendedArrays(array1 , array2 , 1 , 3));
    }

    public void equalTheMultiplicationOfTheArrays(){//multiply with the last element of array
      ArrayList<Integer> array1 = new ArrayList<>(Arrays.asList(4, 3, 2, 1));//for example multiply with 2 the array1  
      ArrayList<Integer> array2 = new ArrayList<>(Arrays.asList(8, 6, 4, 2));//for example multiply with 1 the array2  
      
      assertTrue(new App().equalityOfExtendedArrays(array1 , array2 , 2 , 1));
    }
}
