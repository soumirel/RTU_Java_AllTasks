package rtu.task19;

public class Hand implements Bended{

    private Boolean isBended;

    Orientation orientation;

    @Override
    public void bend() {
        isBended = !isBended;
    }

    Hand(Orientation orientation) {
        this.orientation = orientation;
        isBended = false;
    }

    @Override
    public String toString() {
        if (orientation == Orientation.LEFT) {
            if (isBended)
            {
                return "левая согнута";
            }
            return "левая";
        }
        if (isBended)
        {
            return "правая согнута";
        }
        return "правая";
    }
}
