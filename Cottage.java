

class Cottage extends Housing{

    boolean cableAccess;

    Cottage(String nameOfHousing, int costPerNight){
        super("Cottage",costPerNight,nameOfHousing,.5);
        cableAccess = false;
    }

    public boolean addCableAccess(){

        if(cableAccess)
            return false;
        
        //adds 5 dollars to cost pernight
        costPerNight = costPerNightOriginal + 5;

        calculateDespoit();

        return true;
    }

    public void reset(){
        super.reset();
        cableAccess = false;
    }

    public void updateDaysRemaining(){
        super.updateDaysRemaining();
        if(this.isEmpty)
            reset();
    }

}