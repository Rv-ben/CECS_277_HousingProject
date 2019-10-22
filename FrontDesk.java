import java.util.*;


class FrontDesk implements Subject,Observer{

    ArrayList<Housing> housings;
    ArrayList<Guest> waitList;

    FrontDesk(){
        housings = new ArrayList<Housing>();
        waitList = new ArrayList<Guest>();
    }

    @Override
    public void update() {
        notifyObservers();
    }

    @Override
    public void attach(Observer obs) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void detach(Observer obs) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void notifyObservers() {
        for(Housing currentHousing: housings){
            if(currentHousing.data.isEmpty){
                //find first guest needing this housing
                for(Guest currentGuest: waitList){
                    if(currentGuest.getHousingWanted().equalsIgnoreCase(currentHousing.nameOfHousing)){
                        //book guest or notify
                        bookGuest(currentGuest, currentHousing);
                        System.out.println("Booked");
                        waitList.remove(currentGuest);
                        break;
                    }    
                }
            }
        }
    }

    public void bookGuest(Guest currentGuest, Housing housingWanted){
        if(housingWanted.isEmpty())
            housingWanted.addGuest(currentGuest.getGuestName(),currentGuest.getDaysWanted());
        else    
            waitList.add(currentGuest);
    }



}