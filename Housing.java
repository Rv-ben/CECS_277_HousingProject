import java.util.ArrayList;

abstract class Housing implements Subject {

    ArrayList<Observer> listofObservers;
    
    public HousingData data = new HousingData();

    protected int costPerNightOriginal, costPerNight;

    protected String nameOfHousing, guestName;

    protected double depositPecentage,deposit;

    protected int daysRemaining;

    Housing(String housingType, int cost, String nameOfHousing,double depositPecentage){
        this.data.housingType = housingType;
        this.costPerNightOriginal = cost;
        this.nameOfHousing = nameOfHousing;
        this.depositPecentage = depositPecentage;
        listofObservers = new ArrayList<Observer>();
    }

    public void attach(Observer deskObserver){
        listofObservers.add(deskObserver);
    }

    public void detach (Observer deskObserver){
        listofObservers.remove(deskObserver);
    }

    public void notifyObservers(){
        listofObservers.get(0).update();
    }

    public void calculateDespoit(){
        deposit = costPerNight * depositPecentage;
    }

    public boolean isEmpty(){
        return data.isEmpty;
    }

    public void reset(){
        costPerNight = costPerNightOriginal;
        guestName = "";
    }

    public void addGuest(String guestName, int daysStaying){
        this.guestName= guestName;
        this.daysRemaining = daysStaying;
        data.isEmpty = false;
    }

    public void updateDaysRemaining(){
        if(daysRemaining != 0)
            daysRemaining--;
        else{
            data.isEmpty = true;
            notifyObservers();
        }
    }

    /**
     * @return the daysRemaining
     */
    public int getDaysRemaining() {
        return daysRemaining;
    }

    public void stoString(){
        if(!data.isEmpty)
            System.out.println(this.guestName + " "+daysRemaining);
    }
    
}