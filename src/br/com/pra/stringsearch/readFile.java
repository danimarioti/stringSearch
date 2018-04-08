package br.com.pra.stringsearch;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class readFile {

	public readFile() {

		    Scanner ler = new Scanner(System.in);
		 
		    System.out.printf("Informe o nome de arquivo texto:\n");
		    String nome = ler.nextLine();
		    
		    ler.close();
		    
		    try {
		      FileReader arq = new FileReader(nome);
		      BufferedReader lerArq = new BufferedReader(arq);
		 
		      String linha = lerArq.readLine();
		      
		      while (linha != null) {
		 
		        linha = lerArq.readLine();
		      }
		 
		      arq.close();
		    } catch (IOException e) {
		        System.err.printf("Erro na abertura do arquivo: %s.\n",
		          e.getMessage());
		    }
		 
		    System.out.println();
	}

}
