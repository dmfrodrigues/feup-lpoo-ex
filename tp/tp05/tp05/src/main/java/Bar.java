import java.util.ArrayList;
import java.util.List;

public abstract class Bar {
    abstract public boolean isHappyHour();
    abstract void startHappyHour();
    abstract void endHappyHour();

    List<BarObserver> observers = new ArrayList<>();

    public void addObserver(BarObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(BarObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (BarObserver observer : observers)
            if (isHappyHour()) observer.happyHourStarted(this);
            else observer.happyHourEnded(this);
    }
}
