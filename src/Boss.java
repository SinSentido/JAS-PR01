import java.util.ArrayList;
import java.util.List;

public class Boss {
    public static void main(String[] args){
        //Baskets
        Basket dollBasket = new Basket();
        Basket dressedBasket = new Basket();
        Basket distributionBasket = new Basket();

        //Workers
        Thread dollMaker1 = new Thread(new DollMaker("Francisco", dollBasket));
        Thread dollMaker2 = new Thread(new DollMaker("Sara", dollBasket));
        Thread tailor = new Thread(new Tailor("Clara", dollBasket, dressedBasket));
        Thread packer = new Thread(new Packer("Diego", dressedBasket, distributionBasket));

        //Launch threads
        dollMaker1.start();
        dollMaker2.start();
        tailor.start();
        packer.start();

        //Interrupt threads
        try{
            Thread.sleep(60000);
            dollMaker1.interrupt();
            dollMaker2.interrupt();
            tailor.interrupt();
            packer.interrupt();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Working time is over!!!");
    }
}
