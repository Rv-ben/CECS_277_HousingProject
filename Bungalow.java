

class Bungalow extends Housing{

    boolean portableAC;

    Bungalow(String nameOfHousing,int costPerNight){
        super("Bungalow",costPerNight,nameOfHousing,.2);
        portableAC = false;
    }

    public boolean addCableAccess(){

        if(portableAC)
            return false;

        costPerNight = costPerNightOriginal +20;

        calculateDespoit();
        return true;

    }

    protected void reset(){
        super.reset();
        portableAC = false;
    }

    protected void updateDaysRemaining(){
        super.updateDaysRemaining();
        if(data.isEmpty)
            reset();
    }
}