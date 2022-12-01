package rtu.task14;

public class ChairFactory implements AbstractChairFactory{

    @Override
    public VictorianChair createVictorianChair(int age) {
        return new VictorianChair(age);
    }

    @Override
    public MagicChair createMagicChair() {
        return new MagicChair();
    }

    @Override
    public FunctionlChair createFunctionlChair() {
        return new FunctionlChair();
    }
}
