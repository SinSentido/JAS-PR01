import java.util.ArrayList;
import java.util.List;

public class Basket {

    private List<Doll> list = new ArrayList();

    public List<Doll> getList(){
        return list;
    }

    public synchronized Doll getDoll() throws InterruptedException {
        while(list.size() <= 0){
            wait();
        }
        return list.get(list.size()-1);
    }

    public synchronized void putDoll(Doll doll){
        list.add(doll);
        notifyAll();
    }

    public synchronized void removeDoll(Doll doll) {
        list.remove(doll);
    }
}
