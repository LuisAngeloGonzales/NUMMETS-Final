
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;

public class LeastSquares {
    static Coordinates coordinates = new Coordinates();

    public static void main(String[] args) {

        coordinates.inputCoordinates();
        coordinates.printCoordinates();

        System.out.println("XY Plane");
        System.out.println(getEquation(coordinates.getxCoordinates(), coordinates.getyCoordinates(), "x", "y"));
        System.out.println("YZ Plane");
        System.out.println(getEquation(coordinates.getyCoordinates(), coordinates.getzCoordinates(), "y", "z"));
        System.out.println("XZ Plane");
        System.out.println(getEquation(coordinates.getxCoordinates(), coordinates.getzCoordinates(), "x", "z"));

    }

    public static float getAverage(ArrayList<Float> arrayList){
        Float average = getSum(arrayList) / arrayList.size();
        return average;
    }

    public static float getSum(ArrayList<Float> arrayList){
        Float sum = 0.0f;
        for(Float f: arrayList){
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

    public static ArrayList<Float> multiplyArrays(ArrayList<Float> arrayList1, ArrayList<Float> arrayList2){
        ArrayList<Float> resultArray = new ArrayList<>();
        Iterator<Float> aList1 = arrayList1.iterator();
        Iterator<Float> aList2 = arrayList2.iterator();
        while (aList1.hasNext() && aList2.hasNext()){
            resultArray.add(aList1.next()*aList2.next());
        }
        return resultArray;
    }

    public static String getEquation(ArrayList<Float> array1, ArrayList<Float> array2, String var1, String var2) {
        Float bar1 = getAverage(array1);
        Float bar2 = getAverage(array2);
        int n = array1.size();
        Float var1Sum = getSum(array1);
        Float var2Sum = getSum(array2);
        Float var1SquareSum = getSum(getSquared(array1));
        Float var1SumSquared = (float) Math.pow(var1Sum, 2);
        Float var1var2Sum = getSum(multiplyArrays(array1,array2));

        Float a1 = ((n*var1var2Sum)-(var1Sum*var2Sum))/((n*var1SquareSum)-var1SumSquared);
        Float a0 = (bar2 - (bar1)*a1);

        if (a1 < 0) return var2 + " = " + a0 + " " + a1 + var1;
        else return var2 + " = " + a0 + " +" + a1 + var1;
    }
}
