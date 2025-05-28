import java.util.Arrays;
import java.util.Scanner;

public class HeapsortString {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String vetor[] = new String[9];
        System.out.println("Você tem um vetor de 9 posições, insira Strings nele!");
        for (int i = 0; i < vetor.length; i++) {
            System.out.printf("Insira a String %d do seu vetor: ", i);
            vetor[i] = input.nextLine();
        }

        heapsort(vetor);
        System.out.println("Vetor ordenado: " + Arrays.toString(vetor));

        input.close();
    }

    public static void heapsort(String vetor[]) {
        int n = vetor.length;

        // i = N / 2  (como vetor começa com 0, fazemos n/2 - 1) 
        // Construir o heap (reorganizar o vetor)
        for (int i = n/2 - 1; i >= 0; i--) {
            heap(vetor, n, i);
        }

        // Extrair elementos um por um do heap
        for (int i = n - 1; i > 0; i--) {
            // Troca o maior elemento (raiz) com o último elemento
            String aux = vetor[0];
            vetor[0] = vetor[i];
            vetor[i] = aux;

            // chama heapify na raiz reduzindo o tamanho do heap
            heap(vetor, i, 0);
        }
    }

    // Para manter a propriedade do heap máximo
    public static void heap(String vetor[], int n, int i) {
        int maior = i;       // raiz
        int esq = 2 * i + 1; // filho esquerdo
        int dir = 2 * i + 2; // filho direito

        // Se filho da esquerda for maior que a raiz
        if (esq < n && vetor[esq].compareTo(vetor[maior]) > 0) {
            maior = esq;

        // Se filho da direita for maior que o maior até agora
        if (dir < n && vetor[dir].compareTo(vetor[maior]) > 0)
            maior = dir;

        // Se o maior não é a raiz
        if (maior != i) {
            String troca = vetor[i];
            vetor[i] = vetor[maior];
            vetor[maior] = troca;

            // Recursivamente aplicar no sub-heap
            heap(vetor, n, maior);
        }
    }
}}
