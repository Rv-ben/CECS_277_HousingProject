

class Cottage extends Housing{

    Cottage(String nameOfHousing, int costPerNight){
        super("Cottage",costPerNight,nameOfHousing,.5);
    }

    public void displayUpgrades(){
        System.out.println("Add cable access for 5 dollars a night");
    }

    public int getUpgradeCostPerNight(){
        return 5;
    }

}