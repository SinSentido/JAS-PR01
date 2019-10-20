public class Doll {
    static int counter = 0;
    private int serialNumber;

    public Doll(){
        this.serialNumber = ++counter;
    }

    public int getSerialNumber(){
        return serialNumber;
    }
}
