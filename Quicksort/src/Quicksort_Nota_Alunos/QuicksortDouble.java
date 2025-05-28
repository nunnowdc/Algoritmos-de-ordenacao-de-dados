package Quicksort_Nota_Alunos;

import java.util.Scanner;

public class QuicksortDouble {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        aluno turma[] = new aluno[8];
        for (int i = 0; i<turma.length; i++) {
            turma[i] = new aluno();
            System.out.printf("Insira o nome do aluno %d: ", i);
            String nome = input.nextLine();
            turma[i].setNome(nome);
            System.out.printf("Insira a nota do aluno %d: ", i);
            double nota = input.nextDouble();
            turma[i].setNota(nota);
            input.nextLine();       // limpa o buffer
            System.out.println("-");
        }
        input.close();

        quicksortDouble(turma, 0, turma.length - 1);

        for (int i = 0; i < turma.length; i++) {
            System.out.println(turma[i].getNome() + " - Nota: " + turma[i].getNota());
        }
    }

    // vetor do tipo aluno
    public static int particao(aluno[] vetor, int inicio, int fim) {
        aluno cp = vetor[inicio];
        boolean lado = true;    // true == esquerda  |  false == direita

        while (inicio != fim) {
            if (lado == true) {
                if (vetor[fim].getNota() < cp.getNota()) {  
                    vetor[inicio] = vetor[fim];
                    inicio++;
                    lado = false;
                } 
                else {
                    fim--;
                }
            } 
            else {
                if (vetor[inicio].getNota() > cp.getNota()) {
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

    public static void quicksortDouble(aluno[] vetor, int inicio, int fim) {
        if (inicio < fim) {
            int p = particao(vetor, inicio, fim);
            quicksortDouble(vetor, inicio, p - 1);
            quicksortDouble(vetor, p + 1, fim);
        }
    }
}
