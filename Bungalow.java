

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

    public void reset(){
        super.reset();
        portableAC = false;
    }

    public void updateDaysRemaining(){
        super.updateDaysRemaining();
        if(data.isEmpty)
            reset();
    }
}