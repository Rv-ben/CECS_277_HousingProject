

class Guest implements Observer{

    String guestName,housingWanted;

    int daysWanted;

    Guest(String name, String housingWanted,int daysWanted){
        this.guestName = name;
        this.housingWanted = housingWanted;
        this.daysWanted = daysWanted;
    }

    @Override
    public void update() {
        
    }

    /**
     * @param daysWanted the daysWanted to set
     */
    public void setDaysWanted(int daysWanted) {
        this.daysWanted = daysWanted;
    }

    /**
     * @param guestName the guestName to set
     */
    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    /**
     * @param housingWanted the housingWanted to set
     */
    public void setHousingWanted(String housingWanted) {
        this.housingWanted = housingWanted;
    }

    /**
     * @return the daysWanted
     */
    public int getDaysWanted() {
        return daysWanted;
    }

    /**
     * @return the guestName
     */
    public String getGuestName() {
        return guestName;
    }

    /**
     * @return the housingWanted
     */
    public String getHousingWanted() {
        return housingWanted;
    }
}