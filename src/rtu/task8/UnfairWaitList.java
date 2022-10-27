package rtu.task8;

public class UnfairWaitList<E> extends WaitList<E> {
    public UnfairWaitList() {};

    public void remove(E el) {
        content.remove(el);
    }

    public void moveToBack(E el) {
        remove(el);
        super.add(el);
    }
}
