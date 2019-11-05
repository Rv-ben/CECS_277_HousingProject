import java.util.ArrayList;

abstract class Housing implements Subject {

    ArrayList<Observer> listofObservers;

    protected int costPerNight;

    protected String nameOfHousing, guestName;

    protected double depositPecentage, deposit;

    protected int daysRemaining;

    protected boolean isEmpty = true;

    protected String housingType;

    Housing(String housingType, int cost, String nameOfHousing, double depositPecentage) {
        this.housingType = housingType;
        this.costPerNight = cost;
        this.nameOfHousing = nameOfHousing;
        this.depositPecentage = depositPecentage;
        listofObservers = new ArrayList<Observer>();
    }

    public abstract void displayUpgrades();

    public abstract int getUpgradeCost();

    public void attach(Observer deskObserver) {
        listofObservers.add(deskObserver);
    }

    public void detach(Observer deskObserver) {
        listofObservers.remove(deskObserver);
    }

    public void notifyObservers() {
        listofObservers.get(0).update(this);
    }

    public void calculateDespoit(){
        deposit = costPerNight * depositPecentage;
    }

    public boolean isEmpty(){
        return isEmpty;
    }

    public void reset(){
        guestName = "";
    }

    public void addGuest(String guestName, int daysStaying){
        this.guestName= guestName;
        this.daysRemaining = daysStaying;
        this.isEmpty = false;
    }

    public void updateDaysRemaining(){
        if(daysRemaining != 0)
            daysRemaining--;
        else{
            this.isEmpty = true;
            notifyObservers();
        }
    }

    /**
     * @return the daysRemaining
     */
    public int getDaysRemaining() {
        return daysRemaining;
    }

    public String toString(){
        return nameOfHousing;
    }
    
}