/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leonaprojects.gson.util;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Raghu
 */
public class GsonUtilTest {
    
    public GsonUtilTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    
    /**
     * Test of addToJsonObject method, of class GsonUtil.
     */
    @Test
    public void testToJsonObjet() {
        System.out.println("toJsonObjet");
        
        String key1 = "key1";
        Object property1 = "value1";
        String key2 = "key2";
        Object property2 = "value2";
        GsonUtil instance = GsonUtil.instance();
        JsonObject expResult = new JsonObject();
        expResult.addProperty(key1, (String) property1);
        expResult.addProperty(key2, (String) property2);
        
        JsonObject result = instance.toJsonObjet( key1, property1);
         result = instance.addToJsonObject(result, key2, property2);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of addToJsonArray method, of class GsonUtil.
     */
    @Test
    public void testAddToJsonArray() {
        System.out.println("addToJsonArray");
        JsonArray jsonArray = new JsonArray();
        Object element = 2L;
        GsonUtil instance = GsonUtil.instance();
        JsonArray expResult = new JsonArray();
        expResult.add(new JsonPrimitive(2L));
        JsonArray result = instance.addToJsonArray(jsonArray, element);
        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of constructPrimitive method, of class GsonUtil.
     */
    @Test
    public void testConstructPrimitive() {
        System.out.println("constructPrimitive");
        Object object = 2L;
        GsonUtil instance =  GsonUtil.instance();
        JsonPrimitive expResult = new JsonPrimitive(2L);
        JsonPrimitive result = instance.constructPrimitive(object);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

  

    

   
    
}
