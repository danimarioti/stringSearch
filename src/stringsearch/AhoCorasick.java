package stringsearch;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Renato, Dniela, Carlos
 */

// https://en.wikipedia.org/wiki/Aho–Corasick_algorithm
public class AhoCorasick implements SearchAlgorithms {

  static final int ALPHABET_SIZE = 26;

  Node[] nodes;
  int nodeCount;
  
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
                if(search(valor.toLowerCase(), text.toLowerCase(), linha++)==1){
                    result++;
                }
            }
        }  catch (FileNotFoundException e) {
            logr.getLog().log(Level.SEVERE, "Arquivo "+nomeArquivo+" não encontrado",e);
        }
        logr.getLog().log(Level.INFO,"Saindo do Naive, resultado "+result);
        return result;
    }
   
 public int search(String valor, String texto, int linha) {
    addString(texto);

    String s = texto;
    int node = 0;
    List<Integer> positions = new ArrayList<>();
    for (int i = 0; i < s.length(); i++) {
      node = transition(node, s.charAt(i));
      if (nodes[node].leaf)
        System.out.println("String encontrada na " + (i + 1) + " posição da linha "+ linha);
       return 1;
    }
    return 0;   
  }
  public static class Node {
    int parent;
    char charFromParent;
    int suffLink = -1;
    int[] children = new int[ALPHABET_SIZE];
    int[] transitions = new int[ALPHABET_SIZE];
    boolean leaf;

    {
      Arrays.fill(children, -1);
      Arrays.fill(transitions, -1);
    }
  }

  public AhoCorasick() {
    nodes = new Node[1000];
    // create root
    nodes[0] = new Node();
    nodes[0].suffLink = 0;
    nodes[0].parent = -1;
    nodeCount = 1;
  }

  public void addString(String s) {
    int cur = 0;
    for (char ch : s.toCharArray()) {
      int c = ch - 'a';
      if (nodes[cur].children[c] == -1) {
        nodes[nodeCount] = new Node();
        nodes[nodeCount].parent = cur;
        nodes[nodeCount].charFromParent = ch;
        nodes[cur].children[c] = nodeCount++;
      }
      cur = nodes[cur].children[c];
    }
    
    nodes[cur].leaf = true;
  }

  public int suffLink(int nodeIndex) {
    Node node = nodes[nodeIndex];
    if (node.suffLink == -1)
      node.suffLink = node.parent == 0 ? 0 : transition(suffLink(node.parent), node.charFromParent);
    return node.suffLink;
  }

  public int transition(int nodeIndex, char ch) {
    int c = ch - 'a';
    Node node = nodes[nodeIndex];
    if (node.transitions[c] == -1)
      node.transitions[c] = node.children[c] != -1 ? node.children[c] : (nodeIndex == 0 ? 0 : transition(suffLink(nodeIndex), ch));
    return node.transitions[c];
  }
}
