package br.com.pra.stringsearch;

import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Naive implements SearchAlgorithms {

    @Override
    public void callAlgorithm(String valor,String nomeArquivo) {
        readFile reader = null;
        try {
            reader = new readFile(nomeArquivo);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Naive.class.getName()).log(Level.SEVERE, null, ex);
        }
        String text;
        int linha=0;
        while(reader.getLerArq().hasNext()){//enquanto não acabar o arquivo
            text=reader.getLerArq().nextLine();
            naiveStringMatcher(text, valor,linha++);
        }
    }

    /**
     * Implementation of Naive String matching algorithm.
     *
     * @param text
     * @param pattern
     */
    private static void naiveStringMatcher(String text, String pattern,int linha) {

        char[] txtArr = text.toCharArray();
        char[] patArr = pattern.toCharArray();

        int tLen = txtArr.length;
        int pLen = patArr.length;

        for (int i = 0; i < tLen - pLen; i++) {

            int charMatchCount = 0;
            for (int j = 0; j < pLen; j++) {

                /**
                 * If pattern mismatch, break next searching point.
                     *
                 */
                if (patArr[j] != txtArr[i + j]) {
                    break;
                }
                charMatchCount++;

            }
            if (charMatchCount == pLen) {
                print("String encontrada na " + (i + 1) + " posição da linha "+ linha);
                break;
            }
        }
    }

    private static void print(String string) {
        System.out.println(string);
    }
}
