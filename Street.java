import greenfoot.*;

public class Street extends World {
    
    public static int numberofCoins = 0;
    
    public Street() {
        super(15, 15, 60);        
        setBackground("cell.jpg");
        setPaintOrder(Car.class, Coin.class); 
    }
    
    public void populate() {
        addObject(new Car(), 0, 0);
        randomCoins(15);
        numberofCoins += 15;
    }
       
    public void randomCoins(int howMany) {
        for (int i = 0; i < howMany; i++) {
            Coin coin = new Coin();
            int x = Greenfoot.getRandomNumber(getWidth());
            int y = Greenfoot.getRandomNumber(getHeight());
            addObject(coin, x, y);
        }
        numberofCoins += howMany;
    }
    
    public void refillStreetWithCoins() {
        for (int i = 0; i < 15; i++) {
            Coin coin = new Coin();
            int x = Greenfoot.getRandomNumber(getWidth());
            int y = Greenfoot.getRandomNumber(getHeight());
            addObject(coin, x, y);
        }
        numberofCoins += 15;
    }
}
