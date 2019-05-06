import greenfoot.*;

public class Street extends World {
    /**
     * Create a new world with 10x10 cells and
     * with a cell size of 60x60 pixels.
     */
    public Street() {
        super(15, 15, 60);        
        setBackground("cell.jpg");
        setPaintOrder(Car.class, Coin.class); 
    }
    
    public void populate() {
        addObject(new Car(), 7, 1);
        randomLeaves(10);
    }
       
    public void randomLeaves(int howMany) {
        for (int i=0; i < howMany; i++) {
            Coin coin = new Coin();
            int x = Greenfoot.getRandomNumber(getWidth());
            int y = Greenfoot.getRandomNumber(getHeight());
            addObject(coin, x, y);
        }
    }
}
