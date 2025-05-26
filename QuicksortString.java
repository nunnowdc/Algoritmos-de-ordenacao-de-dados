import java.util.Arrays;
import java.util.Scanner;

public class QuicksortString {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        String vetor[] = new String[8];
        System.out.println("Voce tem um vetor de 8 posicoes, insira as palavras nele!");
        for (int i = 0; i < vetor.length; i++) {
            System.out.printf("Insira a palavra %d do seu vetor: ", i);
            vetor[i] = input.nextLine();
        }

        quicksortString(vetor, 0, vetor.length - 1);  // CORRIGIDO
        System.out.println("Vetor ordenado: " + Arrays.toString(vetor));

        
        input.close();
    }

    public static int particao(String vetor[], int inicio, int fim) {
    String cp = vetor[inicio];  // pivô
    boolean lado = true;        // true == esquerda  |  false == direita

    while (inicio != fim) {
        if (lado == true) {
            if (vetor[fim].compareTo(cp) < 0) {   // fim menor que cp
                vetor[inicio] = vetor[fim];
                inicio++;
                lado = false;
            } 
            else {
                fim--;
            }
        } 
        else {
            if (vetor[inicio].compareTo(cp) > 0) {  // inicio maior que cp
                vetor[fim] = vetor[inicio];
                fim--;
                lado = true;
            } 
            else {
                inicio++;
            }
        }
    }

    vetor[inicio] = cp;
    return inicio;
    }

    public static void quicksortString(String vetor[], int inicio, int fim) {
        if (fim > inicio) {
            int particao = particao(vetor, inicio, fim);
            quicksortString(vetor, inicio, particao - 1);
            quicksortString(vetor, particao + 1, fim);
        }
    }
}