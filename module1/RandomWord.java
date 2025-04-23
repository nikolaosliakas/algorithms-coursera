import edu.princeton.cs.algs4.StdIn;

import edu.princeton.cs.algs4.StdRandom;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;



/**
 * StdIn.readString(): reads and returns the next string from standard input.
 * StdIn.isEmpty(): returns true if there are no more strings available on standard input, and false otherwise.
 * StdOut.println(): prints a string and terminating newline to standard output. It’s also fine to use System.out.println() instead.
 * StdRandom.bernoulli(p): returns true with probability p
 * and false with probability 1−p. */
public class RandomWord {

    public static void main(String... args) throws IOException {
        String firstToken = StdIn.readString();

        if(Objects.equals(firstToken, "<")){
            readFromFile(StdIn.readString());
        } else {
            String ans = StdRandom.bernoulli() ? firstToken : "";
            Iterator<String> wordStream = Arrays.stream(args).iterator();
            while(wordStream.hasNext()) {
                String word = wordStream.next();
                ans = StdRandom.bernoulli() ? word : ans;

            }
            System.out.println(ans);
        }
    }

    private static void readFromFile(String filename) throws IOException {
        try (FileReader fr = new FileReader(filename);
             BufferedReader br = new BufferedReader(fr)) {
            String line = br.readLine();
            String ans = "";
            while(!Objects.isNull(line)) {
                Iterator<String> wordStream = Arrays.stream(line.split(" ")).iterator();
                while(wordStream.hasNext()){

                    ans = StdRandom.bernoulli() ? wordStream.next() : ans;
                }
                line = br.readLine();
            }

            System.out.println(ans);
        }
    }

}
