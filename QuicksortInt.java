import java.util.Arrays;
import java.util.Scanner;


public class QuicksortInt {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        int vetor[] = new int[8];
        System.out.println("Voce tem um vetor de 8 posicoes, insira os valores nele!");
        for (int i = 0; i < vetor.length; i++) {
            System.out.printf("Insira o valor %d do seu vetor: ", i);
            vetor[i] = input.nextInt();
        }

        quicksortInt(vetor, 0, vetor.length - 1);  // CORRIGIDO
        System.out.println("Vetor ordenado: " + Arrays.toString(vetor));

        
        input.close();
    }

    public static int particao(int vetor[], int inicio, int fim) {
    int cp = vetor[inicio];
    boolean lado = true;    // true == esquerda  |  false == direita

    while(inicio != fim) {
        if (lado == true) {
            if (vetor[fim] < cp) {
                vetor[inicio] = vetor[fim];
                inicio++;
                lado = false;
            }
            else {
                fim--;
            }
        }
        else {
            if (vetor[inicio] > cp) {
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
    return inicio;  // ou fim, os dois estao na mesma posição
    }

    public static void quicksortInt(int vetor[], int inicio, int fim) {
        int particao;

        if (fim > inicio) {  // tamanho do segmento é maior que 1 ?
            particao = particao(vetor, inicio, fim);
            quicksortInt(vetor, inicio, particao - 1);
            quicksortInt(vetor, particao + 1, fim);
        }
    }
}
