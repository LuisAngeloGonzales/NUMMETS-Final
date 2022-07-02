import jdk.incubator.vector.VectorOperators;

import java.util.ArrayList;

public class LeastSquares {
    static Coordinates coordinates = new Coordinates();

    public static void main(String[] args) {
        Float xBar, yBar, zBar;

        coordinates.inputCoordinates();
        coordinates.printCoordinates();

        xBar = getAverage(coordinates.getxCoordinates());
        yBar = getAverage(coordinates.getyCoordinates());
        zBar = getAverage(coordinates.getzCoordinates());

    }

    public static float getAverage(ArrayList<Float> array){
        Float average = getSum(array) / array.size();
        return average;
    }

    public static float getSum(ArrayList<Float> array){
        Float sum = 0.0f;
        for(Float f: array){
            sum += f;
        }
        return sum;
    }

    public static ArrayList<Float> getSquared(ArrayList<Float> arrayList){
        ArrayList<Float> squareList = new ArrayList<>();
        for(Float f: arrayList){
            squareList.add((float) Math.pow(f,2));
        }
        return squareList;
    }

    public static String getEquation(ArrayList<Float> array1, ArrayList<Float> array2, String var1, String var2) {
        Float bar1 = getAverage(array1);
        Float bar2 = getAverage(array2);

        return "";
    }

}
