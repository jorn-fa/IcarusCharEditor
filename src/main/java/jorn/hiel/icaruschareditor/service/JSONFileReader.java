package jorn.hiel.icaruschareditor.service;

import jorn.hiel.icaruschareditor.pojo.IcarusCharacter;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Slf4j
public class JSONFileReader {

    Logger logger = LoggerFactory.getLogger(JSONFileReader.class);

    @Getter
    @Setter
    private String file = "";


    /**
     *
     * Reads data from file and parses towards object
     * @param fileName
     * @throws FileNotFoundException
     * @throws ParseException
     */
    public void process(String fileName) throws FileNotFoundException, ParseException {
        List<IcarusCharacter> characters = new ArrayList<>();


        logger.info("reading file with name -> " + fileName);
        File sourceFile = new File(fileName);
        if (sourceFile.exists()) {

            JSONParser parser = new JSONParser();
            try (FileReader reader = new FileReader(fileName)) {

                JSONObject data = (JSONObject) parser.parse(reader);//path to the JSON file.


                JSONArray results = (JSONArray) data.get("Characters.json");

                for (Object result : results) {
                    String test = (String) result;
                    org.json.JSONObject obj = new org.json.JSONObject(test);

                    IcarusCharacter character = new IcarusCharacter()
                            .setCharacterName(obj.getString("CharacterName"))
                            .setChrSlot(obj.getInt("ChrSlot"))
                            .setXP(obj.getInt("XP"))
                            .setXP_Debt(obj.getInt("XP_Debt"))
                            .setDead(obj.getBoolean("IsDead"))
                            .setAbandoned(obj.getBoolean("IsAbandoned"))
                            .setLastProspectID(obj.getString("LastProspectId"))
                            .setLocation(obj.getString("Location"));




                    character.addUnlockedFlags(obj.getJSONArray("UnlockedFlags"));
                    character.addMetaResources(obj.getJSONArray("MetaResources"));
                    character.addCosmetic(obj.getJSONObject("Cosmetic"));
                    character.addTalents(obj.getJSONArray("Talents"));


                    characters.add(character);

                }


            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        characters.forEach(System.out::println);




    }




}
