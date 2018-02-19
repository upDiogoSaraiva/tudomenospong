package org.academiadecodigo.group.academydefense.game;

import org.academiadecodigo.group.academydefense.entities.enemies.DiogoEnemy;
import org.academiadecodigo.group.academydefense.entities.enemies.Enemy;
import org.academiadecodigo.group.academydefense.entities.player.Player;
import org.academiadecodigo.group.academydefense.entities.towers.Tower;
import org.academiadecodigo.group.academydefense.grid.TilePictured;
import org.academiadecodigo.group.academydefense.grid.TiledGrid;
import org.academiadecodigo.simplegraphics.graphics.Color;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private Player player;
    private TiledGrid grid;
    private Tower tower;
    private TilePictured gridPic;


    private List<Enemy> enemies;

    public Game() {
        grid = new TiledGrid();
        gridPic = new TilePictured();
        enemies = new ArrayList<>();
        player = new Player(grid);
        tower = new Tower(grid, 800, 448, 1, 1);
        enemies.add(new DiogoEnemy());
    }

    public void setPositions(Enemy enemy){
        tower.setTowerRoEnemyCol(enemy);
        tower.setTowerToEnemyRow(enemy);
        tower.setTowerToEnemy(tower.getTowerToEnemyRow(), tower.getTowerToEnemyCol());
    }

    public void start() throws InterruptedException {
        grid.draw();
        gridPic.getPicture()
        drawEnemies();
        tower = new Tower(grid, 800, 448, 1, 1);
        tower.draw(Color.BLUE);

        while(enemies.size() != -1){ //Move
            moveAllEnemies();
            Thread.sleep(20);
        }
    }

    public void moveAllEnemies(){
        for (Enemy e: enemies) {
            System.out.println(e);
            setPositions(e);
            System.out.println(e);
            e.move();
        }
    }

    public void drawEnemies(){
        for(Enemy e : enemies){
            e.draw();
        }
    }

}
