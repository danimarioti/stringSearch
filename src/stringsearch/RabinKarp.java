package stringsearch;

import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RabinKarp implements SearchAlgorithms {

    // d is the number of characters in input alphabet
    public final static int d = 256;

    @Override
    public int callAlgorithm(String valor, String nomeArquivo) {
        int result=0;
        int q=101;
        readFile reader = null;
        try {
            reader = new readFile(nomeArquivo);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Naive.class.getName()).log(Level.SEVERE, null, ex);
        }
        String text;
        int linha = 0;
        while (reader.getLerArq().hasNext()) {//enquanto não acabar o arquivo
            text = reader.getLerArq().nextLine();
            if(search(valor, text, q,linha++)==1)
                result++;
        }
        return result;
    }

    /* pat -> pattern
        txt -> text
        q -> A prime number
     */

    static int search(String pat, String txt, int q,int linha) {
        Scanner scanner = new Scanner(System.in);
        int M = pat.length();
        int N = txt.length();
        int i, j;
        int p = 0; // hash value for pattern
        int t = 0; // hash value for txt
        int h = 1;

        // The value of h would be "pow(d, M-1)%q"
        for (i = 0; i < M - 1; i++) {
            h = (h * d) % q;
        }

        // Calculate the hash value of pattern and first
        // window of text
        for (i = 0; i < M; i++) {
            if(txt.length()>0){
                p = (d * p + pat.charAt(i)) % q;
                t = (d * t + txt.charAt(i)) % q;
            }
        }

        // Slide the pattern over text one by one
        for (i = 0; i <= N - M; i++) {

            // Check the hash values of current window of text
            // and pattern. If the hash values match then only
            // check for characters on by one
            if (p == t) {
                /* Check for characters one by one */
                for (j = 0; j < M; j++) {
                    if (txt.charAt(i + j) != pat.charAt(j)) {
                        break;
                    }
                }

                // if p == t and pat[0...M-1] = txt[i, i+1, ...i+M-1]
                if (j == M) {
                    System.out.println("Palavra encontrada na coluna " + i+1+" que está na linha "+linha);
                    return 1;
                }
            }

            // Calculate hash value for next window of text: Remove
            // leading digit, add trailing digit
            if (i < N - M) {
                t = (d * (t - txt.charAt(i) * h) + txt.charAt(i + M)) % q;

                // We might get negative value of t, converting it
                // to positive
                if (t < 0) {
                    t = (t + q);
                }
            }
        }
        return 0;
    }
    
}
