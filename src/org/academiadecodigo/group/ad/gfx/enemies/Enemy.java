package org.academiadecodigo.group.ad.gfx.enemies;

import org.academiadecodigo.group.ad.gfx.grid.Grid;
import org.academiadecodigo.group.ad.gfx.grid.position.GridPosition;
import org.academiadecodigo.group.ad.gfx.map.Position;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

/**
 * Created on 15/02/2018.
 * Good Luck, Have Fun codecadet
 */

public class Enemy {

    private int life;
    private int speed;
    private boolean dead;
    private int value;
    private EnemyType enemyType;
    private GridPosition gridPosition;
    private Position startPosition;
    private Grid grid;
    private Rectangle enemyDrawed;


    public Enemy(EnemyType enemyType, int life, int speed, int value, Grid grid) {
        this.enemyType = enemyType;
        this.life = life;
        this.speed = speed;
        this.dead = false;
        this.value = value;
        this.gridPosition = grid.makeGridPosition(0,0);
        enemyDrawed = new Rectangle(10,10,20,20);



        draw();
    }



    private void draw(){

        enemyDrawed.setColor(Color.BLACK);
        enemyDrawed.fill();

    }

    public void move() {

    }

    public GridPosition getPos() {
        return gridPosition;
    }

    public boolean isDead() {
        return dead;
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }

    public int getValue() {
        return value;
    }




    @Override
    public String toString() {
        return "Enemy{" +
                "life=" + life +
                ", speed=" + speed +
                ", dead=" + dead +
                ", value=" + value +
                ", enemyType=" + enemyType +
                ", grid=" + grid +
                ", pos=" + gridPosition +
                ", position=" + startPosition +
                '}';
    }
}

