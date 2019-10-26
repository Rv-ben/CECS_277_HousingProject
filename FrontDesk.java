import java.util.*;


class FrontDesk implements Observer{

    ArrayList<Housing> housings;
    ArrayList<Reservation> reservations;
    Date currentTime;

    FrontDesk(){
        housings = new ArrayList<Housing>();
        reservations = new ArrayList<Reservation>();
        currentTime = new Calendar.Builder(new Date());
    }

    @Override
    public void update() {
        for(Housing currentHousing: housings){
            if(currentHousing.isEmpty){
                for(Reservation currentReservation: reservations){
                    if(currentReservation.housingName.equalsIgnoreCase(currentHousing.nameOfHousing)){
                    }
                }
            }
        }
    }
    
    public void bookGuest(){
        
    }

    public void newReservation(Reservation newReservation){
        reservations.add(newReservation);
    }

    public boolean isHousingEmpty(String housingName){
        for(Housing i: housings){
            if(i.nameOfHousing.equalsIgnoreCase(housingName)){
                return i.isEmpty;
            }
        }
        return false;
    }

}