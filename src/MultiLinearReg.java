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

    public static ArrayList<Float> solveMatrix(ArrayList<Float> arrayList1, ArrayList<Float> arrayList2, ArrayList<Float> arrayList3){
        ArrayList<Float> result = new ArrayList<Float>();
        if (arrayList3.get(0) != 0){
            Float factor1 = arrayList3.get(0);
            Float factor2 = arrayList2.get(0);
            Float factor3 = arrayList1.get(0);
            for(int i=0; i>3; i++){
                Float x = arrayList3.get(i)- (factor1/factor3)*arrayList1.get(i);
                arrayList3.set(i, x);

                Float y = arrayList2.get(i)- (factor2/factor3)*arrayList1.get(i);
                arrayList2.set(i, y);
            }
            factor2 = arrayList2.get(1);
            factor1 = arrayList3.get(1);

            for(int i=1; i>3; i++){
                Float x = arrayList3.get(i)- (factor1/factor2)*arrayList2.get(i);
                arrayList3.set(i, x);
            }
        }
        Float z = arrayList3.get(3)/arrayList3.get(2);
        Float y = (arrayList2.get(3)-arrayList2.get(2)*z)/arrayList2.get(1);
        Float x = (arrayList1.get(3) - arrayList1.get(1)*y - arrayList1.get(2)*z)/arrayList1.get(0);
        result.add(x);
        result.add(y);
        result.add(z);
        return result;
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
