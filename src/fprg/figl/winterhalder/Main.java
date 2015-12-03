package fprg.figl.winterhalder;

import java.util.ArrayList;

public class Main {

    interface Imap<I,O>{
        O mapFunc(I input);
    }

    public static void main(String[] args) {

        //Integer
        ArrayList<Integer> inputInteger = new ArrayList<Integer>(){{
            add(3);
            add(7);
            add(15);
            add(44);
        }};

        ArrayList<Integer> resultIntegerPlusOne = map(x -> ( x + 1), inputInteger);
        ArrayList<Integer> resultIntegerTimes = map(x -> ( x * x), inputInteger);
        ArrayList<Integer> resultIntegerPlus = map(x -> ( x + x), inputInteger);

        System.out.println("--------Integer--------");
        System.out.println("resultIntegerPlusOne: " + resultIntegerPlusOne);
        System.out.println("resultIntegerTimes: " + resultIntegerTimes);
        System.out.println("resultIntegerPlus: " + resultIntegerPlus);

        //Double
        ArrayList<Double> inputDouble = new ArrayList<Double>(){{
            add(3.4);
            add(7.22);
            add(15.0);
            add(44.234);
        }};

        ArrayList<Double> resultDoublePlusOne = map( x -> ( x + 1), inputDouble);
        ArrayList<Double> resultDoubleTimes = map( x -> ( x * x), inputDouble);
        ArrayList<Double> resultDoublePlus = map( x -> ( x + x), inputDouble);

        System.out.println("--------Double--------");
        System.out.println("resultDoublePlusOne: " + resultDoublePlusOne);
        System.out.println("resultDoubleTimes: " + resultDoubleTimes);
        System.out.println("resultDoublePlus: " + resultDoublePlus);

        //String
        ArrayList<String> inputString = new ArrayList<String>() {{
            add("hello");
            add("functional");
            add("world");
            add("!");
        }};

        ArrayList<String> resultStringConcat = map( x -> ( x + x), inputString);
        ArrayList<String> resultStringUpper = map( x -> ( x.toUpperCase()), inputString);
        ArrayList<String> resultStringReplce = map( x -> ( x.replaceAll("l","q")), inputString);

        System.out.println("--------String--------");
        System.out.println("resultString: " + resultStringConcat);
        System.out.println("resultStringUpper: " + resultStringUpper);
        System.out.println("resultStringReplace: " + resultStringReplce);

        //Boolean
        ArrayList<Boolean> inputBoolean = new ArrayList<Boolean>() {{
            add(true);
            add(true);
            add(false);
            add(true);
        }};

        ArrayList<Boolean> resultBooleanTrue = map( x -> (x.equals(true)), inputBoolean);
        ArrayList<Boolean> resultBooleanFalse = map( x -> (x.equals(false)), inputBoolean);

        System.out.println("--------Boolean--------");
        System.out.println("resultBoolenTrue: " + resultBooleanTrue);
        System.out.println("resultBoolenFalse: " + resultBooleanFalse);
    }

    private static <I,O> ArrayList<O> map(Imap<I,O> func, ArrayList<I> input){

        ArrayList<O> output = new ArrayList<>();
        mapRec(func, input, output, 0);
        return output;

    }

    private static  <I,O> void mapRec(Imap<I,O> func, ArrayList<I> input, ArrayList<O> output, int count){

        // abbruch;
        if(count == input.size()){
            return;
        }
        output.add(func.mapFunc(input.get(count)));
        mapRec(func, input, output, count+1);
    }
}
