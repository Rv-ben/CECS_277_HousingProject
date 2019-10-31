import java.time.LocalDate;

class Reservation implements Comparable<Reservation>{
    
    public int reservationNum,daysStaying,upgradeDays;

    public String housingType,housingName;

    public String name,address,phoneNumber,email;

    public LocalDate checkInDay,checkOutDate;
    
    public Card cardInfo;

    public double totalCost,deposit;

    public int compareTo(Reservation otherRev){
        return this.checkInDay.compareTo(otherRev.checkInDay);
    }

    public void display(){
        System.out.println("Reservation Number: "+reservationNum);
        System.out.println("Days Staying: "+daysStaying);
        System.out.println("Upgrade Days: "+upgradeDays);
        System.out.println("Housing: "+housingName +" "+ housingType);
        System.out.println("Name: "+name+" Address: "+address+" Phone Number: "+phoneNumber+" Email: "+email);
        System.out.println("Check in Day: "+checkInDay.toString()+" Check out date: "+checkOutDate.toString());
        System.out.println("Card Info: "+cardInfo.toString());
        System.out.println("Total Cost: "+totalCost+" Desposit: "+ deposit);
    }

}