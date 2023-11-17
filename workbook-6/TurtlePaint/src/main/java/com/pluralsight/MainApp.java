package com.pluralsight;

import com.pluralsight.forms.Turtle;
import com.pluralsight.forms.World;

import java.awt.*;

public class MainApp
{
    public static void main(String[] args)
    {
        // This starter code to get you familiar with how
        // the TurtleLogo application works

        // The world is your canvas
        World world = new World(320, 320);
        Turtle turtle = new Turtle(world,-100, 100);
        turtle.setDelay(0);
        turtle.setPenWidth(3);
        turtle.setColor(Color.RED);
        turtle.setShellSize(7);

        drawSquare(world, turtle);
        drawCircle(world, turtle);
        drawCircleWithChunk(world, turtle);
        drawGrid(world, turtle);





    }
    public static void drawSquare(World world, Turtle turtle){
        for(int i = 0; i < 4; i++) {
            turtle.forward(200);
            turtle.turnLeft(90);
        }

        world.saveAs("square.png");
        world.erase();
        turtle.penUp();
    }
    public static void drawCircle(World world, Turtle turtle){
        turtle.goTo(0, -100);
        turtle.penDown();

        for(int i = 0; i <360; i++){
            turtle.forward(2);
            turtle.turnLeft(1);
        }

        world.saveAs("circle.png");
        world.erase();
        turtle.penUp();
    }

    public static void drawCircleWithChunk(World world, Turtle turtle){
        turtle.goTo(100,0);
        turtle.penDown();
        turtle.turnLeft(90);
        for(int i = 0; i <270; i++){
            turtle.forward(2);
            turtle.turnLeft(1);
        }
        turtle.turnLeft(90);
        turtle.forward(113);
        turtle.turnRight(90);
        turtle.forward(113);

        turtle.penUp();
        turtle.turnRight(90);
        turtle.forward(10);
        turtle.turnLeft(90);
        turtle.forward(15);
        turtle.turnRight(90);
        turtle.setColor(Color.BLUE);

        turtle.penDown();
        for (int i = 0; i <90; i++){
            turtle.forward(2);
            turtle.turnRight(1);
        }
        turtle.turnRight(90);
        turtle.forward(113);
        turtle.turnRight(90);
        turtle.forward(113);

        world.saveAs("circleWithChunk.png");
        world.erase();
        turtle.penUp();
    }
    public static void drawGrid(World world, Turtle turtle){
        turtle.setColor(Color.BLACK);
        turtle.goTo(0,160);
        turtle.turnRight(90);
        turtle.penDown();

        turtle.forward(320);
        turtle.penUp();
        turtle.goTo(-160,0);
        turtle.turnLeft(90);
        turtle.penDown();
        turtle.forward(320);
        turtle.setPenWidth(1);


        for(int i = -140; i <= 140; i+=20) {
            turtle.penUp();
            turtle.goTo(-160, i);
            turtle.penDown();
            turtle.forward(320);
        }

        turtle.turnRight(90);
        for(int i = -140; i <= 140; i+=20) {
            turtle.penUp();
            turtle.goTo(i, 160);
            turtle.penDown();
            turtle.forward(320);
        }
        world.saveAs("grid.png");
        world.erase();
        turtle.penUp();
    }
}
