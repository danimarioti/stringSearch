package stringsearch;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;

public class RabinKarp implements SearchAlgorithms {

    // d is the number of characters in input alphabet
    public final static int d = 256;

    @Override
    public int callAlgorithm(String valor, String nomeArquivo, Log logr) {
        int result=0;
        int q=101;
        readFile reader = null;
        try {
            logr.getLog().log(Level.INFO,"Abrindo arquivo");
            reader = new readFile(nomeArquivo);
            String text;
            int linha = 0;
            logr.getLog().log(Level.INFO,"Lendo arquivo");
            while (reader.getLerArq().hasNext()) {//enquanto não acabar o arquivo
                text = reader.getLerArq().nextLine();
                if(search(valor.toLowerCase(), text.toLowerCase(), q,linha++)==1)
                    result++;
            }
        }  catch (FileNotFoundException e) {
            logr.getLog().log(Level.SEVERE, "Arquivo "+nomeArquivo+" não encontrado",e);
        }
        logr.getLog().log(Level.INFO,"Saindo do Naive, resultado "+result);
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
