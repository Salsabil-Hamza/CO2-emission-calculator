package com.emission_calculator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.emission_calculator.App;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Before
    public void setUp() throws Exception {


    }

    @Test
    public void calculateCarboneDioxideOutputTest() {

        App myTest = new App();

        HashMap<String, Integer> transportCarbonData = new HashMap<String, Integer>();
        transportCarbonData.put("aircraft", 200);
        transportCarbonData.put("train", 154);

        double output_1 = myTest.calculateCarboneDioxideOutput(transportCarbonData,"train", "m",14500 ,"kg");
        double output_2 = myTest.calculateCarboneDioxideOutput(transportCarbonData,"aircraft", "m",14500 ,"");

        assertEquals("--transportation-method train --distance 14500 --unit-of-distance m --output kg",2.3,output_1,0.1);
        assertEquals("--transportation-method aircraft --distance 14500 --unit-of-distance m ",2900,output_2,0.1);
    }
}
