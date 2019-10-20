import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class DollMaker implements Runnable{
    private String name;
    private int counter = 0;
    private Basket dollBasket;
    private Date time = new Date();
    private DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    public DollMaker(String name, Basket dollBasket){
        this.name = name;
        this.dollBasket = dollBasket;
    }

    @Override
    public void run() {
        makeDoll();
    }

    private void makeDoll(){
        Random rdm = new Random();

        while(true){
            Doll doll = new Doll();
            try {
                Thread.sleep(rdm.nextInt(4000)+4000);
            } catch (InterruptedException e) {
                return;
            }
            System.out.printf("%s |Name: %s, Position: %s, Put a doll: %d%n%n",
                    dateFormat.format(time), name, this.getClass().getName(), doll.getSerialNumber());
            dollBasket.putDoll(doll);
        }

    }
}
