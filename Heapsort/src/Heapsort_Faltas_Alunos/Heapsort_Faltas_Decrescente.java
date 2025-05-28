package Heapsort_Faltas_Alunos;

import java.util.Scanner;

public class Heapsort_Faltas_Decrescente {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Alunos turma[] = new Alunos[8];
        for (int i = 0; i<turma.length; i++) {
            turma[i] = new Alunos();
            System.out.printf("Insira o nome do aluno %d: ", i);
            String nome = input.nextLine();
            turma[i].setNome(nome);
            System.out.printf("Insira o numero de faltas do aluno %d: ", i);
            int faltas = input.nextInt();
            turma[i].setNota(faltas);
            input.nextLine();       // limpa o buffer
            System.out.println("-");
        }

        heapsort(turma);

        for (int i = 0; i < turma.length; i++) {
            System.out.println(turma[i].getNome() + " - Nota: " + turma[i].getNota());
        }

        input.close();
    }

    public static void heapsort(Alunos vetor[]) {
        int n = vetor.length;

        // i = N / 2  (como vetor começa com 0, fazemos n/2 - 1) 
        // Construir o heap (reorganizar o vetor)
        for (int i = n/2 - 1; i >= 0; i--) {
            heap(vetor, n, i);
        }

        // Extrair elementos um por um do heap
        for (int i = n - 1; i > 0; i--) {
            // Troca o menor elemento (raiz) com o último elemento
            Alunos aux = vetor[0];
            vetor[0] = vetor[i];
            vetor[i] = aux;

            // chama heapify na raiz reduzindo o tamanho do heap
            heap(vetor, i, 0);
        }
    }

    // Para manter a propriedade do heap máximo
    public static void heap(Alunos vetor[], int n, int i) {
        int menor = i;       // raiz
        int esq = 2 * i + 1; // filho esquerdo
        int dir = 2 * i + 2; // filho direito

        // dir > esq
        if (esq < n && vetor[esq].getNota() < vetor[menor].getNota())
            menor = esq;

        // esq > dir
        if (dir < n && vetor[dir].getNota() < vetor[menor].getNota())
            menor = dir;

        // menor não é a raiz
        if (menor != i) {
            Alunos aux = vetor[i];
            vetor[i] = vetor[menor];
            vetor[menor] = aux;

            // chama heap recursivamente
            heap(vetor, n, menor);
        }
    }
}
