package org.academiadecodigo.group.academydefense.game;

import org.academiadecodigo.group.academydefense.entities.enemies.DiogoEnemy;
import org.academiadecodigo.group.academydefense.entities.enemies.Enemy;
import org.academiadecodigo.group.academydefense.entities.player.Player;
import org.academiadecodigo.group.academydefense.entities.towers.Bullet;
import org.academiadecodigo.group.academydefense.entities.towers.Tower;
import org.academiadecodigo.group.academydefense.grid.GridUtils;
import org.academiadecodigo.group.academydefense.grid.TilePictured;
import org.academiadecodigo.group.academydefense.grid.TileShape;
import org.academiadecodigo.group.academydefense.grid.TiledGrid;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Line;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private Player player;
    private TiledGrid grid;
    private Tower tower;
    private TilePictured sprite;


    private List<Enemy> enemies;

    public Game() {
        grid = new TiledGrid();
        sprite = new TilePictured(10, GridUtils.rowToY(0), "res/background.png");
        enemies = new ArrayList<>();
        player = new Player(this, grid);
    }

    public void setPositions(Enemy enemy) {
        tower.setTowerToEnemyCol(enemy);
        tower.setTowerToEnemyRow(enemy);
        tower.towerToEnemy = (int) (Math.sqrt((tower.getTowerToEnemyCol() * tower.getTowerToEnemyCol()) + (tower.getTowerToEnemyRow() * tower.getTowerToEnemyRow())));
    }

    public void start() throws InterruptedException {




        Picture background = new Picture(10,10, "res/background.png");
        Picture pidgeon = new Picture(10,10, "res/foreground-pigeon.png");

        grid.draw();
        background.draw();


        /*for(int i = 0; i < grid.getWidth()- 4; i++) {
            new TileShape(i * grid.getCellSize() +10,  330, grid.getCellSize() * 2, Color.BLACK).draw();
        }*/

        drawEnemies();
        pidgeon.draw();
        tower = new Tower(grid, 1600, 800, 1, 1, 200);

        while (enemies.size() != -1) { //Move
            moveAllEnemies();
            Thread.sleep(15);
        }
    }

    public void moveAllEnemies() {
        for (Enemy e : enemies) {

            System.out.println(e);
            setPositions(e);
            System.out.println(e);
            e.move();
            System.out.println(e);
            //while (!e.isDead() || tower.getTowerToEnemyDistance() < tower.getRange()){

            for(Tower t : Player.getTowersCreated()){
                t.shoot(e, t);
            }

        }


          /*  if (tower.getTowerToEnemyDistance() < tower.getRange()) {
                tower.shoot(e, tower);
            }*/
    }

    public List<Enemy> getEnemies() {
        return enemies;
    }

    public void drawEnemies() throws InterruptedException {
        for (Enemy e : enemies) {
            e.draw();
        }
    }

}

