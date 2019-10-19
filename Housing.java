

abstract class Housing implements Subject{
    
    HousingData data;

    private int costPerNight;

    private String nameOfHousing;

    Housing(Boolean occupantStatus,Boolean cleanStatus, int cost, String nameOfHousing){
        this.data.clean = cleanStatus;
        this.data.isEmpty = occupantStatus;
        this.costPerNight = cost;
        this.nameOfHousing = nameOfHousing;
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

}