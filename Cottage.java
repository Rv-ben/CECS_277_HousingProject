import java.util.ArrayList;

class Cottage extends Housing{

    ArrayList<Observer> listofObservers;

    boolean cableAccess;

    Cottage(String nameOfHousing, int costPerNight){
        super("Cottage",costPerNight,nameOfHousing,.5);
        listofObservers = new ArrayList<Observer>();
    }

    public void attach(Observer deskObserver){
        listofObservers.add(deskObserver);
    }

    public void detach (Observer deskObserver){
        listofObservers.remove(deskObserver);
    }

    public void notifyObservers(){
        FrontDesk desk = (FrontDesk)listofObservers.get(0);
        desk.update(data);
    }

    public boolean cottageEmpty(){
        return data.isEmpty;
    }
}