package jorn.hiel.icaruschareditor.pojo;


import lombok.*;
import lombok.experimental.Accessors;

@NoArgsConstructor
@Setter
@Accessors(chain = true)
@ToString
public class Cosmetic {

    int head;
    int hair;
    int hairColor;
    int body;
    int bodyColor;
    int skinTone;
    int headTattoo;
    int headScar;
    int headFacialHair;
    int capLogo;
    boolean male;
    int voice;
    int eyeColor;

        }