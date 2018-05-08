package stringsearch;


import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.util.Scanner;

public class readFile {

    private final Scanner lerArq;

    public Scanner getLerArq() {
        return lerArq;
    }

    
    public readFile(String nomeArquivo) throws FileNotFoundException{
        File file;
        String filePath = Paths.get(".").toAbsolutePath().normalize().toString(); //pegar o diretório atual
        //filePath+=("/src/stringsearch/textos/"+nomeArquivo+".txt"); //adiciono o arquivo ao path
        filePath+=("/src/stringsearch/entradasDados/"+nomeArquivo+".txt"); //adiciono o arquivo ao path
        file= new File(filePath); //abre o arquivo
        lerArq = new Scanner(file); //cria um scanner pro arquivo aberto
    }
}