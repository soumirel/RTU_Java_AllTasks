package rtu.task3.subtask4;

public class MovableCircle implements Movable {
    private int radius;
    private MovablePoint center;

    public MovableCircle(int x, int y, int xSpeed, int ySpeed, int radius) {
        this.radius = radius;
        this.center = new MovablePoint(x, y, xSpeed, ySpeed);
    }

    @Override
    public String toString() {
        return "MovableCircle{" +
                "radius=" + radius +
                ", center=" + center +
                '}';
    }

    @Override
    public void moveUp() {
        System.out.println("rectangle moving up");
    }

    @Override
    public void moveDown() {
        System.out.println("rectangle moving down");
    }

    @Override
    public void moveLeft() {
        System.out.println("rectangle moving left");
    }

    @Override
    public void moveRight() {
        System.out.println("rectangle moving right");
    }
}
