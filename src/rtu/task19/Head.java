package rtu.task19;

public class Head {
    int rotation;
    Head() {
        this.rotation = 0;
    }

    public void rotate(Orientation orientation) {
        if (orientation == Orientation.LEFT) {
            rotation++;
        }
        if (orientation == Orientation.RIGHT) {
            rotation--;
        }
    }
    @Override
    public String toString() {
        if (rotation == -1) {
            return "повёрнута влево";
        }
        if (rotation == 0) {
            return "никуда не повёрнута";
        }
        if (rotation == 1) {
            return "повёрнута вправо";
        }
        return "сломана";
    }
}
