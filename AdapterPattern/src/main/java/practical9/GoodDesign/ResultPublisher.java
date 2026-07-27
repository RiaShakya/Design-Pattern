package practical9.GoodDesign;

import java.util.ArrayList;
import java.util.List;

public class ResultPublisher {

    private final List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {

        observers.add(observer);

    }

    public void removeObserver(Observer observer) {

        observers.remove(observer);

    }

    public void publishResult() {

        System.out.println("Results Published");

        for (Observer observer : observers) {
            observer.update();
        }

    }

}