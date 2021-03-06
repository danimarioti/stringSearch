package stringsearch;

import java.io.FileNotFoundException;
import java.util.logging.Level;

public class Naive implements SearchAlgorithms {

    /**
     *
     * @param valor
     * @param nomeArquivo
     * @param logr
     * @return
     */
    @Override
    public int callAlgorithm(String valor,String nomeArquivo, Log logr) {
        readFile reader = null;
        int result=0;
        try {
            logr.getLog().log(Level.INFO,"Abrindo arquivo");
            reader = new readFile(nomeArquivo);
            String text;
            int linha=0;
            logr.getLog().log(Level.INFO,"Lendo arquivo");
            while(reader.getLerArq().hasNext()){//enquanto não acabar o arquivo
                text=reader.getLerArq().nextLine();
                if(naiveStringMatcher(text, valor,++linha)==1){
                    result++;
                }
            }
        } catch (FileNotFoundException e) {
            logr.getLog().log(Level.SEVERE, "Arquivo "+nomeArquivo+" não encontrado");
        }
        logr.getLog().log(Level.INFO,"Saindo do Naive, resultado "+result);
        return result;
    }

    /**
     * Implementation of Naive String matching algorithm.
     *
     * @param text
     * @param pattern
     */
    private static int naiveStringMatcher(String text, String pattern,int linha) {

        char[] txtArr = text.toCharArray();
        char[] patArr = pattern.toCharArray();

        int tLen = txtArr.length;
        int pLen = patArr.length;
        for (int i = 0; i <= tLen - pLen; i++) {

            int charMatchCount = 0;
            for (int j = 0; j < pLen; j++) {

                /**
                 * If pattern mismatch, break next searching point.
                     *
                 */
                if (Character.toLowerCase(patArr[j]) != Character.toLowerCase(txtArr[i + j])) {
                    break;
                }
                charMatchCount++;

            }
            if (charMatchCount == pLen) {
                print("String encontrada na " + (i + 1) + " posição da linha "+ linha);
                return 1;
            }
        }
        return 0;
    }

    private static void print(String string) {
        System.out.println(string);
    }
}
