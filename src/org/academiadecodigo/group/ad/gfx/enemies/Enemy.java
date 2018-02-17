package org.academiadecodigo.group.ad.gfx.enemies;

import org.academiadecodigo.group.ad.gfx.grid.Grid;
import org.academiadecodigo.group.ad.gfx.map.Position;

/**
 * Created on 15/02/2018.
 * Good Luck, Have Fun codecadet
 */
public class Enemy {

    private int life;
    private int speed;
    private boolean dead;
    private int value;
    private Position position;
    private EnemyType enemyType;
    private Grid grid;

    public Enemy(EnemyType enemyType, int life, int speed, int value){
        this.enemyType = enemyType;
        this.life = life;
        this.speed = speed;
        this.dead = false;
        this.value = value;
        position = new Position(0,0);
    }

    abstract public void move();

    public void setGrid(Grid grid) {
        this.grid = grid;
    }
    public int getValue() {
        return value;
    }
}
