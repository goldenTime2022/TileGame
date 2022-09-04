package com.yun.unm.titlegame;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import java.util.Random;

public class Tile extends StackPane {
    private static final Random random =new Random();
    private static Tile firstTile=null;
    private final Color shape1Color;
    private Color shape2Color;
    private Color shape3Color;
    private final Shape shape1;
    private final Shape shape2;
    private final Shape shape3;
    int currentStreak = 0;
    int longestStreak = 0;


    public Tile(){
        shape1Color=getColor();
        do {
            shape2Color = getColor();
        }while(shape1Color.equals(shape2Color));
        do{
            shape3Color=getColor();
        }while(shape2Color.equals(shape3Color));

        shape1 = getShape(shape1Color, 1);
        shape2 = getShape(shape2Color, 2);
        shape3 = getShape(shape3Color, 3);
        getChildren().addAll(shape3, shape2, shape1);
        setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event){
                if (firstTile==null){
                    firstTile=(Tile)event.getSource() ;

                }else{
                    Tile secondTile = (Tile)event.getSource();
                    if(firstTile.compareTiles(secondTile)){
                        System.out.println("two tile are same");
                    }else{
                        System.out.println("two tile are different");
                    }
                    firstTile=null;
                }
            }
        });
    }
    public boolean compareTiles(Tile tile){

        boolean tileMatches = false;
        if(shape1Color.equals(tile.shape1Color) && shape1.equals(tile.shape1)){
            getChildren().remove(shape1);
            tile.getChildren().remove(tile.shape1);
            System.out.println("shape1 matches");
            tileMatches=true;
        }
        if(shape2Color.equals(tile.shape2Color) && shape2.equals(tile.shape2)){
            getChildren().remove(shape2);
            tile.getChildren().remove(tile.shape2);
            System.out.println("shape2 matches");
            tileMatches=true;
        }
        if(shape3Color.equals(tile.shape3Color) && shape3.equals(tile.shape3)){
            getChildren().remove(shape3);
            tile.getChildren().remove(tile.shape3);
            System.out.println("shape3 matches");
            tileMatches=true;
        }
        if(tileMatches){
            currentStreak+=1;
            longestStreak+=1;
        }else{
            currentStreak=0;
        }
        return tileMatches;
    }
    private static Color getColor(){
        int rand= random.nextInt(5);
        return switch (rand) {
            case 0 -> Color.RED;
            case 1 -> Color.PURPLE;
            case 2 -> Color.GREEN;
            case 3 -> Color.BLUE;
            case 4 -> Color.YELLOW;
            default -> Color.BLACK;
        };
    }
    private static Shape getShape(Color color, int order){
        int size=10;
        if(order==2){
            size=30;
        }else if(order==3){
            size=60;
        }
        int rand = random.nextInt(2);
        return switch(rand) {
            case 0-> new Rectangle(size,size, color);
            case 1-> new Circle(size, color);
            default -> null;
        };

    }
}