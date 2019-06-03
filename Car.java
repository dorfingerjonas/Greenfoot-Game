import greenfoot.*;
import java.util.*;

public class Car extends Actor {
    private int coinsCollected;
    private int coinsSpawned = Street.numberofCoins;

    public Car() {
        coinsCollected = 0;
    }
    
    public void act() {
        if (foundCoin()) {
            collectCoin();
        }
        
        if (Greenfoot.isKeyDown("right")) {
            turnRight();
            Greenfoot.delay(1);
        }
        
        if (Greenfoot.isKeyDown("left")) {
            turnLeft();
            Greenfoot.delay(1);
        }
        
        if (Greenfoot.isKeyDown("up") && canMove()) {
            move(1);
        }
        
        if (coinsSpawned == 0) {
            Street street = new Street();
            street.refillStreetWithCoins();
            System.out.println("refilled");
        }
    }
    
    public void goToX0() {
        for(int i = 0; i < getX(); i++) {
            if (getRotation() == 0) {
                turnLeft();
                turnLeft();
            } else if(getRotation() == 90) {
                turnLeft();
            } else if (getRotation() == 270) {
                turnRight();
            }
            move(1);
        }    
    }
    
    public void turnLeft() {
        turn(-90);
    }
    
    public void turnRight() {
        turn(90);
    }
       
    public boolean foundCoin() {
        Actor coin = getOneObjectAtOffset(0, 0, Coin.class);
        return coin != null;
    }
    
    public void collectCoin() {
        Actor coin = getOneObjectAtOffset(0, 0, Coin.class);
        if (coin != null) {
            getWorld().removeObject(coin);
            System.out.println("Coins collected: " + getCoinscollecten());
        }
        coinsSpawned--;
    }
    
    public void setDirection(int direction) {
        if ((direction >= 0) && (direction <= 3)) {
            setRotation(direction * 90);
        }
    }
    
    public boolean canMove() {
        int rotation = getRotation();
        int x = getX();
        int y = getY();
        boolean facingEdge = false;
        
        switch (rotation) {
            case 0:
                facingEdge = (x == getWorld().getWidth() - 1);
                break;
            case 90:
                facingEdge = (y == getWorld().getHeight() - 1);
                break;
            case 180:
                facingEdge = (x == 0);
                break;
            case 270:
                facingEdge = (y == 0);
                break;
        }
        
        return !facingEdge;
    }

    public int getCoinscollecten() {
        coinsCollected++;
        return coinsCollected;
    }
}
