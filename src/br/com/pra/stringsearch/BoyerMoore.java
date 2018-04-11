package br.com.pra.stringsearch;

import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BoyerMoore implements SearchAlgorithms {

    private final int R=256;     // the radix
    private String pat;      // or as a string
    private int[] right;
    
    @Override
    public void callAlgorithm(String valor, String nomeArquivo) {
        this.pat = valor;
        right = new int[R];
        for (int c = 0; c < R; c++)
            right[c] = -1;
        for (int j = 0; j < pat.length(); j++)
            right[pat.charAt(j)] = j;
        
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
            search(text, linha++);
        }
    }
    

    /**
     * Returns the index of the first occurrrence of the pattern string in the
     * text string.
     *
     * @param txt the text string
     * @return the index of the first occurrence of the pattern string in the
     * text string; n if no such match
     */
    public int search(String txt,int linha) {
        int m = pat.length();
        int n = txt.length();
        int skip;
        for (int i = 0; i <= n - m; i += skip) {
            skip = 0;
            for (int j = m - 1; j >= 0; j--) {
                if (pat.charAt(j) != txt.charAt(i + j)) {
                    skip = Math.max(1, j - right[txt.charAt(i + j)]);
                    break;
                }
            }
            if (skip == 0) {
                System.out.println("String encontrada na " + (i + 1) + " posição da linha "+ linha);
                return i;    // found
            }
        }
        return n;                       // not found
    }

}
