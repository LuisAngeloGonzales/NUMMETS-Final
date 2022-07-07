import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;

public class MultiLinearReg {

    public static void main(String[] args) {
        Coordinates coordinates = new Coordinates();
        coordinates.inputCoordinates();
        coordinates.printCoordinates();

        System.out.println("Plane Equation: ");
        String equation = getEquation(coordinates.getxCoordinates(), coordinates.getyCoordinates(), coordinates.getzCoordinates(), "x", "y", "z");
        System.out.println(equation);

    }

    public static float getAverage(ArrayList<Float> arrayList){
        return getSum(arrayList) / arrayList.size();
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

    public static String getEquation(ArrayList<Float> array1, ArrayList<Float> array2, ArrayList<Float> array3, String var1, String var2, String var3){
        Float a0, a1, a2;
        String equation = "";

        Float var1Sum = getSum(array1);     //Ex
        Float var2Sum = getSum(array2);     //Ey
        Float var3Sum = getSum(array3);  //Ez
        Float var1SquaredSum = getSum(getSquared(array1)); //Ex^2
        Float var2SquaredSum = getSum(getSquared(array2)); //Ey^2
        Float var3SquaredSum = getSum(getSquared(array3)); //Ez^2
        Float var2var1Sum = getSum(multiplyArrays(array1,array2));  //Eyx
        Float var2var3Sum = getSum(multiplyArrays(array3,array2));  //Eyz
        Float var1var3Sum = getSum(multiplyArrays(array1,array3));  //Exz

        return equation;
    }
}
