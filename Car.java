import greenfoot.*;
import java.util.List;
import java.util.ArrayList;

public class Car extends Actor {
    private int coinsCollected;

    public Car() {
        coinsCollected = 0;
    }

    public void act() {
        if (foundCoin()) {
            collectCoin();
        }
        else if (canMove()) {
            collect();
        }
        else {
            turnLeft();
        }
    }
    
    public void collect() {
        if (getY() >= 5) {
            goToX0();
            moveUp();
        } else {
            goToX0();
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
            move();
    }    
}

    public void moveUp() {
    turnRight();
    move();
    turnRight();
    for(int i = 0; i <= 10; i++) {
        move();
    }
    turnLeft();
    move();
    turnLeft();
    for(int i = 0; i <= 10; i++) {
        move();
    }
}
  
    public void move() {
        move(1);
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
            getCoinscollecten();
        }
    }
    
    public void setDirection(int direction) {
        if ((direction >= 0) && (direction <= 3)) {
            setRotation(direction * 90);
        }
    }
    
    /**
     * Test if we can move forward. Return true if we can, false otherwise.
     */
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
        System.out.println("Coins collected: " + coinsCollected);
        return coinsCollected;
    }
}
