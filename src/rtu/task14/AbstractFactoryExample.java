package rtu.task14;

public class AbstractFactoryExample {
    public static void main(String[] args) {
        AbstractChairFactory factory = new ChairFactory();
        Chair mCh = factory.createMagicChair();
        Client client = new Client(mCh);
        client.sit();
        Chair fCh = factory.createFunctionlChair();
        client.setChair(fCh);
        client.sit();
        Chair vCh = factory.createVictorianChair(100);
        client.setChair(vCh);
        client.sit();
    }
}
