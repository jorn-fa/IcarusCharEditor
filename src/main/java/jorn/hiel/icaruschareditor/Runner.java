package jorn.hiel.icaruschareditor;

import jorn.hiel.icaruschareditor.service.JSONFileReader;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.IOException;


public class Runner {

    public static void main(String[] args) throws IOException {
        System.out.println("Running");

        String location = "E:\\\\temp\\\\Characters.json";

        //String lines = Files.readString(Path.of(location));


        JSONFileReader reader = new JSONFileReader();
        reader.setFile(location);
        try {
            reader.process(location);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (ParseException e) {
            System.out.println("parsing error");
        }


    }



}
