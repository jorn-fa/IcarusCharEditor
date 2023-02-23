package jorn.hiel.icaruschareditor.pojo;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter @ToString
public class IcarusCharacter {


    String characterName;
    int chrSlot;
    int XP;
    int XP_Debt;
    boolean isDead;
    boolean isAbandoned;
    String lastProspectID;
    String location;
    List<String> unlockedFlags;
    List<String> metaResources;
    Cosmetic cosmetic;
    List<Talent> talents;


    public IcarusCharacter() {
        talents=new ArrayList<>();
        unlockedFlags =new ArrayList<>();
        metaResources =new ArrayList<>();
    }

    public IcarusCharacter setCharacterName(String characterName) {
        this.characterName = characterName;
        return this;
    }

    public IcarusCharacter setChrSlot(int chrSlot) {
        this.chrSlot = chrSlot;
        return this;
    }

    public IcarusCharacter setXP(int XP) {
        this.XP = XP;
        return this;
    }

    public IcarusCharacter setXP_Debt(int XP_Debt) {
        this.XP_Debt = XP_Debt;
        return this;
    }

    public IcarusCharacter setDead(boolean dead) {
        isDead = dead;
        return this;
    }

    public IcarusCharacter setAbandoned(boolean abandoned) {
        isAbandoned = abandoned;
        return this;
    }

    public IcarusCharacter setLastProspectID(String lastProspectID) {
        this.lastProspectID = lastProspectID;
        return this;
    }

    public IcarusCharacter setLocation(String location) {
        this.location = location;
        return this;
    }



    public IcarusCharacter addUnlockedFlags(org.json.JSONArray source){
        source.forEach(a-> this.unlockedFlags.add(a.toString()));
        return this;
    }


    public IcarusCharacter addMetaResources(org.json.JSONArray source){
        source.forEach(a-> this.metaResources.add(a.toString()));
        return this;
    }

    public IcarusCharacter addCosmetic(JSONObject source){
        if (cosmetic==null){            cosmetic=new Cosmetic();        }

        cosmetic
                .setHead(source.getInt("Customization_Head"))
                .setHair(source.getInt("Customization_Hair"))
                .setHairColor(source.getInt("Customization_HairColor"))
                .setBody(source.getInt("Customization_Body"))
                .setBodyColor(source.getInt("Customization_BodyColor"))
                .setSkinTone(source.getInt("Customization_SkinTone"))
                .setHeadTattoo(source.getInt("Customization_HeadTattoo"))
                .setHeadScar(source.getInt("Customization_HeadScar"))
                .setHeadFacialHair(source.getInt("Customization_HeadFacialHair"))
                .setCapLogo(source.getInt("Customization_CapLogo"))
                .setMale(source.getBoolean("IsMale"))
                .setVoice(source.getInt("Customization_Voice"))
                .setEyeColor(source.getInt("Customization_EyeColor"));


        return this;
    }

    /**
     * Talent processing ( file -> object )
     *
     * @param source json source of talents
     * @return Icaruscharacter
     */

    public IcarusCharacter addTalents(org.json.JSONArray source){

        for (int i = 0; i < source.length(); i++) {
            JSONObject objects = source.getJSONObject(i);
            talents.add(new Talent(objects.getString("RowName"),objects.getInt("Rank")));
        }
        return this;
    }
}
