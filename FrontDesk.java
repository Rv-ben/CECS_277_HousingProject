import java.time.LocalDate;
import java.util.*;


class FrontDesk implements Observer{

    public ArrayList<Housing> housings;
    public ArrayList<Reservation> reservations;
    public ArrayList<Reservation> waitList;
    public ArrayList<Integer> resNumbers;
    public LocalDate currentTime;

    FrontDesk(){
        housings = new ArrayList<Housing>();
        reservations = new ArrayList<Reservation>();
        resNumbers = new ArrayList<Integer>();
        currentTime = LocalDate.now();
    }

    @Override
    public void update(Object update) {
        Housing temp = (Housing)update;
        for(Reservation i: reservations)
            if(i.checkInDay.compareTo(currentTime) == 0)
                if(i.housingName.equals(temp.nameOfHousing))
                    temp.addGuest(i.name, i.daysStaying);
    }
    
    public void bookGuest(Reservation guestRes){
        String housingName = guestRes.housingName;
        Housing temp = findHousingByName(housingName);
        if(temp!= null)
            temp.addGuest(guestRes.name, guestRes.daysStaying);
    }

    public void newReservation(Reservation newReservation){
        if(isDaysStayingAv(newReservation)){
            reservations.add(newReservation);
            Collections.sort(reservations);
        }
        else{System.out.println("not av");}
    }

    public boolean isHousingEmpty(String housingName){
        for(Housing i: housings){
            if(i.nameOfHousing.equalsIgnoreCase(housingName)){
                return i.isEmpty;
            }
        }
        return false;
    }

    public void displayHousingType(Class houseType){
        for(Housing i: housings){
            if(i.getClass().equals(houseType)){
                System.out.println(i.toString());
            }
        }
    }

    public Housing findHousingByName(String houseName){
        for(Housing i: housings){
            if(i.nameOfHousing.equals(houseName)){
                return i;
            }
        }
        return null;
    }

    public boolean isOverLap(Reservation res1,Reservation res2){
        return (res2.checkInDay.isBefore(res1.checkOutDate) && res2.checkOutDate.isAfter(res1.checkInDay));
    }

    public boolean isDaysStayingAv(Reservation res){
        Housing temp = findHousingByName(res.housingName);
        for(Reservation i : reservations){
            if(i.housingName.equals(temp.nameOfHousing)&&!(res.name.equals(i.name)))
                if(isOverLap(res, i))
                    return false;
        }

        return true ;
    }

    public void printSummary(Reservation res){
        System.out.println("Deposit Charged: "+res.deposit);
        System.out.println();
    }

    public Reservation getResFromNum(int reservationNum){
        for(Reservation i: reservations)
            if(i.reservationNum == reservationNum)
                return i;
        return null;
    }

    public void cancelReservation(Reservation res){
        reservations.remove(res);
        System.out.println("Res cancelled");
        for(Reservation i:waitList)
            if(res.housingName.equals(i.housingName)){
                if(isOverLap(res, i)){
                    reservations.add(i);
                    waitList.remove(i);
                    System.out.println("WaitList Updated");
                    break;
                }
            }
    }

    public int generateReservationNumber(){
        Random ran = new Random();
        int newResNum = ran.nextInt(1000)+100;
        //check if new res is already a res num
        while(isInList(newResNum))
            newResNum = ran.nextInt(1000)+100;
        return newResNum;
    }

    public boolean isInList(int newResNum){
        for(int i: resNumbers){
            if(i == newResNum)
                return true;
        }
        return false;
    }

}