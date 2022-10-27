package rtu.task14;

public class Client {
    public Chair chair;

    public void sit() {
        System.out.println("Now i'm sitting at " + chair);
    }

    public void setChair(Chair chair) {
        this.chair = chair;
    }

    public Client(Chair chair) {
        this.chair = chair;
    }
}
