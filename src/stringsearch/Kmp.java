package stringsearch;

import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Kmp implements SearchAlgorithms {

    @Override
    public int callAlgorithm(String valor, String nomeArquivo, Log logr) {
        readFile reader = null;
        int result=0;
        try {
            logr.getLog().log(Level.INFO,"Abrindo arquivo");
            reader = new readFile(nomeArquivo);
            String text;
            int linha = 0;
            logr.getLog().log(Level.INFO,"Lendo arquivo");
            while (reader.getLerArq().hasNext()) {
                text = reader.getLerArq().nextLine();
                if (KMPSearch(text.toLowerCase(), valor.toLowerCase(), linha++)==1)
                    result++;
            }
        }  catch (FileNotFoundException e) {
            logr.getLog().log(Level.SEVERE, "Arquivo "+nomeArquivo+" não encontrado",e);
        }
        logr.getLog().log(Level.INFO,"Saindo do Naive, resultado "+result);
        return result;
    }

    int KMPSearch(String txt, String pat, int linha) {
        int M = pat.length();
        int N = txt.length();

        // create lps[] that will hold the longest
        // prefix suffix values for pattern
        int lps[] = new int[M];
        int j = 0;  // index for pat[]

        // Preprocess the pattern (calculate lps[]
        // array)
        computeLPSArray(pat, M, lps);

        int i = 0;  // index for txt[]
        while (i < N) {
            if (pat.charAt(j) == txt.charAt(i)) {
                j++;
                i++;
            }
            if (j == M) {
                System.out.println("Palavra encontrada "
                        + "no íncice " + (i - j + 1) + " da linha " + linha);
                j = lps[j - 1];
                return 1;
                
            } // mismatch after j matches
            else if (i < N && pat.charAt(j) != txt.charAt(i)) {
                // Do not match lps[0..lps[j-1]] characters,
                // they will match anyway
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i = i + 1;
                }
            }
        }
        return 0;
    }

    void computeLPSArray(String pat, int M, int lps[]) {
        // length of the previous longest prefix suffix
        int len = 0;
        int i = 1;
        lps[0] = 0;  // lps[0] is always 0

        // the loop calculates lps[i] for i = 1 to M-1
        while (i < M) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else // (pat[i] != pat[len])
            {
                // This is tricky. Consider the example.
                // AAACAAAA and i = 7. The idea is similar 
                // to search step.
                if (len != 0) {
                    len = lps[len - 1];

                    // Also, note that we do not increment
                    // i here
                } else // if (len == 0)
                {
                    lps[i] = len;
                    i++;
                }
            }
        }
    }

}
