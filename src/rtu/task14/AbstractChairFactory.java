package rtu.task14;

public interface AbstractChairFactory {
    public VictorianChair createVictorianChair(int age);

    public MagicChair createMagicChair();

    public FunctionlChair createFunctionlChair();
}
