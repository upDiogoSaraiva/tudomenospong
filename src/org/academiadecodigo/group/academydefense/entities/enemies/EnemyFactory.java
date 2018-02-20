package org.academiadecodigo.group.academydefense.entities.enemies;

/**
 * Creates of enemies
 */
public class EnemyFactory {

    public static Enemy makeEnemy(){
        return new DiogoEnemy();
    }
}