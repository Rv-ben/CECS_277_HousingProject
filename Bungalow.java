

class Bungalow extends Housing{

    Bungalow(String nameOfHousing,int costPerNight){
        super("Bungalow",costPerNight,nameOfHousing,.2);
    }

    public void displayUpgrades(){
        System.out.println("Add portable AC for 20 dollars a night");
    }

    public int getUpgradeCost(){
        return 20;
    }
}