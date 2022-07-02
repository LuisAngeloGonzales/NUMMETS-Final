import java.util.ArrayList;
import java.util.Scanner;

public class Coordinates {

    private ArrayList<Float> xCoordinates = new ArrayList<>();
    private ArrayList<Float> yCoordinates = new ArrayList<>();
    private ArrayList<Float> zCoordinates = new ArrayList<>();

    public void inputCoordinates(){

        Scanner input = new Scanner(System.in);
        String[] readInput;
        System.out.println("Enter X-Coordinates: (Ex: 1.0 2.3 4.5)");
        readInput = input.nextLine().split(" ");
        for (String s: readInput){
            xCoordinates.add(Float.parseFloat(s));
        }

        System.out.println("Enter Y-Coordinates: (Ex: 1.0 2.3 4.5)");
        readInput = input.nextLine().split(" ");
        for (String s: readInput){
            yCoordinates.add(Float.parseFloat(s));
        }

        System.out.println("Enter Z-Coordinates: (Ex: 1.0 2.3 4.5)");
        readInput = input.nextLine().split(" ");
        for (String s: readInput){
            zCoordinates.add(Float.parseFloat(s));
        }

    }

    public void printCoordinates(){
        System.out.println("X\t\tY\t\tZ");
        for (int i = 0; i < xCoordinates.size(); i++){
            System.out.println(xCoordinates.get(i)+"\t\t"+yCoordinates.get(i)+"\t\t"+zCoordinates.get(i));
        }
    }



    public ArrayList<Float> getxCoordinates() {
        return xCoordinates;
    }

    public ArrayList<Float> getyCoordinates() {
        return yCoordinates;
    }

    public ArrayList<Float> getzCoordinates() {
        return zCoordinates;
    }
}
