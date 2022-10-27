package rtu.task14;

public class AbstractFactoryExample {
    public static void main(String[] args) {
        AbstractChairFactory factory = new ChairFactory();
        Chair mCh = factory.createVMagicChair();
        Client client = new Client(mCh);
        client.sit();
        FunctionlChair fCh = factory.createFunctionlChair();
        client.setChair(fCh);
        client.sit();
    }
}
