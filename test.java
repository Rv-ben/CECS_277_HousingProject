
import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


class test{
    static Scanner userInput;
    static FrontDesk desk = new FrontDesk();
    
    public static void main(String []args) throws Exception{
        Scanner cpuInput = new Scanner(new File("housings.txt"));
        userInput = new Scanner(new File("Demo.txt"));
        while(cpuInput.hasNext())
            loadHousings(cpuInput);
        while(userInput.hasNext())
            mainMenu();
            userInput = new Scanner(System.in);
        while(mainMenu());
        
    }

    public static void debug(){
        for(Reservation i: desk.reservations)
            System.out.println("R: "+i.name+" "+ i.reservationNum+" "+i.housingName);
        for(Reservation i: desk.waitList)
            System.out.println("W: "+i.name+" "+ i.reservationNum+" "+i.housingName);
    }

    public static boolean mainMenu(){

        System.out.println("C)reate a new reservation");
        System.out.println("V)iew Reservation");
        System.out.println("E)dit an existing reservation");

        switch(userInput.nextLine().charAt(0)){
            case 'C':
                try{
                createResUserInput();
                }catch(Exception x){
                    System.out.println(x);
                }
                break;
            case 'V':
                viewReservation();
                break;
            case 'E':
                editReservation();
                break;
            case 'D':
                debug();
                break;
            case 'S':
                return false;
        }
        return true;
    }

    public static void loadHousings(Scanner file){
        char type = file.nextLine().charAt(0);
        String houseName = file.nextLine();
        int costPerNight = Integer.parseInt(file.nextLine());
        Housing newType = null;
        switch(type){
            case 'B':
                newType = new Bungalow(houseName,costPerNight);
                break;
            case 'C':
                newType = new Cottage(houseName,costPerNight);
                break;
        }
        desk.housings.add(newType);
    }

    public static void createResUserInput() {
        System.out.println("Which Type Bungalow or Cottage? (B/C)");
        char choice = userInput.nextLine().charAt(0);

        switch(choice){
            case 'B':
                desk.displayHousingType(Bungalow.class);
                break;
            case 'C':
                desk.displayHousingType(Cottage.class);
                break;
        }

        System.out.println("Choose your housing:");

        String housingName = userInput.nextLine();

        Reservation res = new Reservation();

        System.out.println("Choose a check in date:");
        
        String checkIn = userInput.nextLine();

        System.out.println("How many days will you like to stay?");

        int daysStaying = Integer.parseInt(userInput.nextLine());

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate checkInDate = LocalDate.parse(checkIn,dateTimeFormatter);
        LocalDate checkOutDate = checkInDate.plusDays(daysStaying);



        res.upgradeDays = selectUpgrades(desk.findHousingByName(housingName));

        res.housingName = housingName;
        res.checkInDay = checkInDate;
        res.checkOutDate = checkOutDate;
        res.daysStaying = daysStaying;
        res.reservationNum = desk.generateReservationNumber();

        if(desk.isDaysStayingAv(res)){
            gatherUserInfo(res);
            desk.reservations.add(res);
        }
        else{
            System.out.println("WaitList (y/n)");
            char answer = userInput.nextLine().charAt(0);
            if(answer == 'y'){
                gatherUserInfo(res);
                desk.waitList.add(res);
            }
        }

        System.out.println("Your reservation number is: "+res.reservationNum);
    }

    public static int selectUpgrades(Housing housing){
        System.out.println("Would you like the following upgrade?");
        housing.displayUpgrades();
        
        char answer = userInput.nextLine().charAt(0);
        if(answer == 'Y'){
            System.out.println("How many nights?");
            return Integer.parseInt(userInput.nextLine())*housing.getUpgradeCost();
        }
        else{
            return 0;
        }


    } 

    public static void gatherUserInfo(Reservation res) {

        System.out.print("Enter name: ");
        res.name = userInput.nextLine();
        System.out.print("Enter address: ");
        res.address = userInput.nextLine();
        System.out.print("Enter Phone Number: ");
        res.phoneNumber = userInput.nextLine();
        System.out.print("Enter email: ");
        res.email = userInput.nextLine();
        
        res.cardInfo = getCardInfo();
    }

    public static Card getCardInfo(){
        Card temp = new Card();
        System.out.print("Enter name on card: ");
        temp.nameOnCard = userInput.nextLine();
        System.out.print("Enter card number: ");
        temp.number = userInput.nextLine();
        System.out.print("Enter exp date: ");
        temp.expDate = userInput.nextLine();
        System.out.print("Enter security: ");
        temp.securityCode = userInput.nextLine();
        return temp;
    }

    public static void viewReservation(){
        System.out.println("Enter reservation number");
        int resNum = Integer.parseInt(userInput.nextLine());
        Reservation temp = desk.getResFromNum(resNum);
        if(temp != null)
            temp.display();
    }

    public static void editReservation(){
        System.out.println("Enter Reservation Number");
        Reservation res = desk.getResFromNum(Integer.parseInt(userInput.nextLine()));
        if(res != null)
            editSubMenu(res);
    }

    public static void editSubMenu(Reservation res) {

        System.out.println("N)umber of nights");
        System.out.println("C)ancel Reservation");

        switch(userInput.nextLine().charAt(0)){
            case 'N':
                editNumOfDays(res);
                break;
            case 'C':
                desk.cancelReservation(res);
                break;
        }
    }

    public static void editNumOfDays(Reservation res) {
        System.out.println("Enter Number of Nights");
        int addedDays = Integer.parseInt(userInput.nextLine());
        Reservation temp = new Reservation();
        temp.checkInDay = res.checkOutDate;
        temp.checkOutDate = res.checkOutDate.plusDays(addedDays);

        if(desk.isDaysStayingAv(temp))
            res.checkOutDate = res.checkOutDate.plusDays(addedDays);
        else
            System.out.println("Sorry Dogg Can't adds these days");
    }
}