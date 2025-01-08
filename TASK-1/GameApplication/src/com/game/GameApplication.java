package com.game;
import java.util.*;

//Singleton Pattern for GameState
class GameState {
 private static GameState instance;
 private int currentLevel;
 private String difficulty;

 private GameState() {
     currentLevel = 1;
     difficulty = "Normal";
 }

 public static synchronized GameState getInstance() {
     if (instance == null) {
         instance = new GameState();
     }
     return instance;
 }

 public int getCurrentLevel() {
     return currentLevel;
 }

 public void setCurrentLevel(int level) {
     currentLevel = level;
 }

 public String getDifficulty() {
     return difficulty;
 }

 public void setDifficulty(String difficulty) {
     this.difficulty = difficulty;
 }
}

//Factory Method Pattern for Enemies
abstract class Enemy {
 public abstract void attack();
}

class Goblin extends Enemy {
 @Override
 public void attack() {
     System.out.println("Goblin attacks with a club!");
 }
}

class Troll extends Enemy {
 @Override
 public void attack() {
     System.out.println("Troll attacks with a massive hammer!");
 }
}

class EnemyFactory {
 public static Enemy createEnemy(String type) {
     switch (type) {
         case "Goblin":
             return new Goblin();
         case "Troll":
             return new Troll();
         default:
             throw new IllegalArgumentException("Unknown enemy type");
     }
 }
}

//Abstract Factory Pattern for Weapons and Power-Ups
interface GameElementFactory {
 Weapon createWeapon();
 PowerUp createPowerUp();
}

//Weapons
interface Weapon {
 void use();
}

class Sword implements Weapon {
 @Override
 public void use() {
     System.out.println("Swinging a sword!");
 }
}

class Bow implements Weapon {
 @Override
 public void use() {
     System.out.println("Shooting an arrow!");
 }
}

//Power-Ups
interface PowerUp {
 void activate();
}

class HealthPotion implements PowerUp {
 @Override
 public void activate() {
     System.out.println("Restoring health!");
 }
}

class SpeedBoost implements PowerUp {
 @Override
 public void activate() {
     System.out.println("Boosting speed!");
 }
}

//Concrete Factories
class EasyLevelFactory implements GameElementFactory {
 @Override
 public Weapon createWeapon() {
     return new Sword();
 }

 @Override
 public PowerUp createPowerUp() {
     return new HealthPotion();
 }
}

class HardLevelFactory implements GameElementFactory {
 @Override
 public Weapon createWeapon() {
     return new Bow();
 }

 @Override
 public PowerUp createPowerUp() {
     return new SpeedBoost();
 }
}

// Game Application

public class GameApplication {
	
	public static void main(String[] args) {
        // Initialize Game State
        GameState gameState = GameState.getInstance();
        System.out.println("Starting Level: " + gameState.getCurrentLevel());
        System.out.println("Difficulty: " + gameState.getDifficulty());

        // Set up factories based on difficulty
        GameElementFactory factory;
        if (gameState.getDifficulty().equals("Easy")) {
            factory = new EasyLevelFactory();
        } else {
            factory = new HardLevelFactory();
        }

        // Create and use game elements
        Weapon weapon = factory.createWeapon();
        PowerUp powerUp = factory.createPowerUp();

        weapon.use();
        powerUp.activate();

        // Create enemies for the level
        Enemy enemy1 = EnemyFactory.createEnemy("Goblin");
        Enemy enemy2 = EnemyFactory.createEnemy("Troll");

        enemy1.attack();
        enemy2.attack();

        // Progress to next level
        gameState.setCurrentLevel(gameState.getCurrentLevel() + 1);
        System.out.println("Progressed to Level: " + gameState.getCurrentLevel());
    }
}