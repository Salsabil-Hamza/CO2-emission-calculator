package com.emission_calculator;
import org.apache.commons.cli.*;
import java.text.DecimalFormat;
import java.util.HashMap;


public class App {

    public static void main(String[] args) {

        Options options = new Options();
        CommandLineParser parser = new DefaultParser();
        options.addOption("t", "transportation-method", true, "transportation-method");
        options.addOption("d", "distance", true, "distance");
        options.addOption("u", "unit-of-distance", true, "unit-of-distance");
        options.addOption("o", "output", true, "output");

        HashMap<String, Integer> transportCarboneDioxideData = new HashMap<String, Integer>();

        transportCarboneDioxideData.put("small-diesel-car", 142);
        transportCarboneDioxideData.put("small-petrol-car", 154);
        transportCarboneDioxideData.put("small-plugin-hybrid-car", 73);
        transportCarboneDioxideData.put("small-electric-car", 50);

        transportCarboneDioxideData.put("medium-diesel-car", 171);
        transportCarboneDioxideData.put("medium-petrol-car", 192);
        transportCarboneDioxideData.put("medium-plugin-hybrid-car", 110);
        transportCarboneDioxideData.put("medium-electric-car", 58);

        transportCarboneDioxideData.put("large-diesel-car", 209);
        transportCarboneDioxideData.put("large-petrol-car", 282);
        transportCarboneDioxideData.put("large-plugin-hybrid-car", 126);
        transportCarboneDioxideData.put("large-electric-car", 73);

        transportCarboneDioxideData.put("bus", 27);
        transportCarboneDioxideData.put("train", 6);


        try {
            CommandLine cmd = parser.parse(options, args);

            String transportationMethod = cmd.getOptionValue("transportation-method");
            Double distance = Double.parseDouble(cmd.getOptionValue("distance"));
            String unit = cmd.getOptionValue("unit-of-distance");
            String outputUnit = cmd.getOptionValue("output");

            if (outputUnit == null && unit == null) {
                outputUnit = "kg";
                unit = "";
            } else if (outputUnit == null && unit.equals("m")) {
                outputUnit = "g";
                unit = "";
            } else if (outputUnit == null && unit.equals("km")) {
                outputUnit = "kg";
                unit = "";
            } else if (unit == null) {
                unit = "";
            }

            double generatedOutput = calculateCarboneDioxideOutput(transportCarboneDioxideData, transportationMethod, unit, distance, outputUnit);
            System.out.println(String.format("Your trip caused %.1f%s of CO2-equivalent", generatedOutput, outputUnit));


        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }

    }

    static double calculateCarboneDioxideOutput(HashMap<String, Integer> transportList, String transport, String unit, double distance, String outputUnit) {
        double output;
        int amount = transportList.get(transport);

        if (unit == "" || unit.equals("km")) {
            output = (amount * distance) / 1000;
        } else if (unit.equals("m") && outputUnit.equals("kg")) {
            output = (amount * distance) / Math.pow(10, 6);
        } else if (unit.equals("m")) {
            output = (amount * distance) / Math.pow(10, 3);
        } else output = 0;

        DecimalFormat value = new DecimalFormat("#.#");
        value.format(output);

        return output;
    }


}

