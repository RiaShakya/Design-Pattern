package observer;

import java.util.ArrayList;
import java.util.List;

public class LibraryNotification {

    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer){

        observers.add(observer);

    }

    public void notifyObservers(String message){

        for(Observer observer : observers){

            observer.update(message);

        }

    }

}