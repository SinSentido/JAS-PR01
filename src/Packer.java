import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Packer implements Runnable {
    private String name;
    private Basket dressedBasket, distributionBasket;
    private Date time = new Date();
    private DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    public Packer(String name, Basket dressedBasket, Basket distributionBasket){
            this.name = name;
            this.dressedBasket = dressedBasket;
            this.distributionBasket = distributionBasket;
    }

    @Override
    public void run() {
        packDoll();
    }

    private void packDoll(){
        Random rdm = new Random();

        while(true){
            try {
                Doll doll = dressedBasket.getDoll();
                dressedBasket.removeDoll(doll);
                System.out.printf("%s |Name: %s, Position: %s, Get a doll: %d%n%n",
                        dateFormat.format(time), name, this.getClass().getName(), doll.getSerialNumber());
                Thread.sleep(rdm.nextInt(2000) + 1000);

                System.out.printf("%s |Name: %s, Position: %s, Put a doll: %d%n%n",
                        dateFormat.format(time), name, this.getClass().getName(), doll.getSerialNumber());
                distributionBasket.putDoll(doll);
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}
