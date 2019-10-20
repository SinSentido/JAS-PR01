import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Tailor implements Runnable {
    private String name;
    private Basket dollBasket, dressedBasket;
    private Date time = new Date();
    private DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    public Tailor(String name, Basket dollBasket, Basket dressedBasket){
        this.name = name;
        this.dollBasket = dollBasket;
        this.dressedBasket = dressedBasket;
    }

    @Override
    public void run() {
        dressDoll();
    }

    private void dressDoll(){
        Random rdm = new Random();

        while(true){
            try {
                Doll doll = dollBasket.getDoll();
                dollBasket.removeDoll(doll);
                System.out.printf("%s |Name: %s, Position: %s, Get a doll: %d%n%n",
                        dateFormat.format(time), name, this.getClass().getName(), doll.getSerialNumber());
                Thread.sleep(rdm.nextInt(3000)+1000);

                System.out.printf("%s |Name: %s, Position: %s, Put a doll: %d%n%n",
                        dateFormat.format(time), name, this.getClass().getName(), doll.getSerialNumber());
                dressedBasket.putDoll(doll);
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}
