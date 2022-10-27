package rtu.task3.subtask4;

public class MovablePoint implements Movable{
    protected int x, y, xSpeed, ySpeed;

    public MovablePoint(int x, int y, int xSpeed, int ySpeed) {
        this.x = x;
        this.y = y;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    @Override
    public String toString() {
        return "MovablePoint{" +
                "x=" + x +
                ", y=" + y +
                ", xSpeed=" + xSpeed +
                ", ySpeed=" + ySpeed +
                '}';
    }

    @Override
    public void moveUp() {
        System.out.println("point moving up");
    }

    @Override
    public void moveDown() {
        System.out.println("point moving down");
    }

    @Override
    public void moveLeft() {
        System.out.println("point moving left");
    }

    @Override
    public void moveRight() {
        System.out.println("point moving right");
    }
}
