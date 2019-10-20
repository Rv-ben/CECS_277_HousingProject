import java.util.ArrayList;

abstract class Housing implements Subject {

    ArrayList<Observer> listofObservers;
    
    protected HousingData data;

    protected int costPerNightOriginal, costPerNight;

    protected String nameOfHousing, guestName;

    protected double depositPecentage,deposit;

    protected int daysRemaining;

    Housing(String housingType, int cost, String nameOfHousing,double depositPecentage){
        this.data.housingType = housingType;
        this.costPerNightOriginal = cost;
        this.nameOfHousing = nameOfHousing;
        this.depositPecentage = depositPecentage;
    }

    public void attach(Observer deskObserver){
        listofObservers.add(deskObserver);
    }

    public void detach (Observer deskObserver){
        listofObservers.remove(deskObserver);
    }

    public void notifyObservers(){
        listofObservers.get(0).update(data);
    }

    public void calculateDespoit(){
        deposit = costPerNight * depositPecentage;
    }

    protected boolean isEmpty(){
        return data.isEmpty;
    }

    protected void reset(){
        costPerNight = costPerNightOriginal;
        guestName = "";
    }

    protected void addGuest(String guestName, int daysStaying){
        this.guestName= guestName;
        this.daysRemaining = daysStaying;
    }

    protected void updateDaysRemaining(){
        if(daysRemaining != 0)
            daysRemaining--;
        else{
            notifyObservers();
            data.isEmpty = true;
        }
    }

    /**
     * @return the daysRemaining
     */
    public int getDaysRemaining() {
        return daysRemaining;
    }
    
}