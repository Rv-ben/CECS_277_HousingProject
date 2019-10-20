

abstract class Housing implements Subject{
    
    protected HousingData data;

    private int costPerNight;

    private String nameOfHousing;

    private double depositPecentage;

    Housing(){}

    Housing(String housingType, int cost, String nameOfHousing,double depositPecentage){
        this.data.housingType = housingType;
        this.costPerNight = cost;
        this.nameOfHousing = nameOfHousing;
        this.depositPecentage = depositPecentage;
    }

    @Override
    public abstract void attach(Observer obs);

    @Override
    public abstract void detach(Observer obs);

    @Override
    public abstract void notifyObservers();

    public void setHousingData(HousingData data){
        this.data = data;
    }
    
    public void setCostPerNight(int costPerNight){
        this.costPerNight = costPerNight;
    }

    public void setNameOfHosuing(String nameOfHousing){
        this.nameOfHousing = nameOfHousing;
    }

    public HousingData getHosuingData(){
        return data;
    }

    public int getCostPerNight(){
        return costPerNight;
    }

    public String getNameOfHousing(){
        return nameOfHousing;
    }

    public double getDepositPercentage(){
        return depositPecentage;
    }
}