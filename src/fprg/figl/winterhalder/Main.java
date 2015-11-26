package fprg.figl.winterhalder;

import java.util.ArrayList;
import java.util.function.Function;

public class Main {

    interface Imap<I,O>{
        O mapFunc(I input);
    }

    public static void main(String[] args) {

        ArrayList<Integer> input = new ArrayList<>();
        input.add(1);
        input.add(2);
        input.add(3);
        input.add(4);
        ArrayList<Integer> result = map( x -> ( x + 1), input);
        System.out.println(result);
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
