import java.util.Arrays;
import java.util.Scanner;

public class HeapsortInt {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int vetor[] = new int[9];
        System.out.println("Você tem um vetor de 9 posições, insira os valores nele!");
        for (int i = 0; i < vetor.length; i++) {
            System.out.printf("Insira o valor %d do seu vetor: ", i);
            vetor[i] = input.nextInt();
        }

        heapsort(vetor);
        System.out.println("Vetor ordenado: " + Arrays.toString(vetor));

        input.close();
    }

    public static void heapsort(int vetor[]) {
        int n = vetor.length;

        // i = N / 2  (como vetor começa com 0, fazemos n/2 - 1) 
        // Construir o heap (reorganizar o vetor)
        for (int i = n/2 - 1; i >= 0; i--) {
            heap(vetor, n, i);
        }

        // Extrair elementos um por um do heap
        for (int i = n - 1; i > 0; i--) {
            // Troca o maior elemento (raiz) com o último elemento
            int aux = vetor[0];
            vetor[0] = vetor[i];
            vetor[i] = aux;

            // chama heapify na raiz reduzindo o tamanho do heap
            heap(vetor, i, 0);
        }
    }

    // Para manter a propriedade do heap máximo
    public static void heap(int vetor[], int n, int i) {
        int maior = i;       // raiz
        int esq = 2 * i + 1; // filho esquerdo
        int dir = 2 * i + 2; // filho direito

        // dir > esq
        if (esq < n && vetor[esq] > vetor[maior])
            maior = esq;

        // esq > dir
        if (dir < n && vetor[dir] > vetor[maior])
            maior = dir;

        // maior não é a raiz
        if (maior != i) {
            int troca = vetor[i];
            vetor[i] = vetor[maior];
            vetor[maior] = troca;

            // chama heap recursivamente
            heap(vetor, n, maior);
        }
    }
}
