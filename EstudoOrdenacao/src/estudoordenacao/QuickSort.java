
package estudoordenacao;

import java.util.Arrays;

public class QuickSort {
    private final int[] vetor;
    private int quantidadeDeTrocas;
    
    public QuickSort (int[] vetor)
    {
        this.vetor = vetor;
        quantidadeDeTrocas = 0;
    }
    
    private void Quick (int esquerda, int direita) 
    {
        int meio;
        if (esquerda < direita)
        {
            meio = Particiona(esquerda, direita);
            Quick(esquerda, meio);
            Quick(meio + 1, direita);
        }
    }

    private int Particiona(int esquerda, int direita)
    {
        int pivo = vetor[(esquerda + direita) / 2]; 
        int esquerdaAuxiliar = esquerda - 1;
        int direitaAuxiliar = direita + 1;
        
        while (esquerdaAuxiliar < direitaAuxiliar)
        {
            do
            {
                direitaAuxiliar--;
            } while (vetor[direitaAuxiliar] > pivo);
            
            do
            {
                esquerdaAuxiliar++;
            } while (vetor[esquerdaAuxiliar] < pivo);
            
            if (esquerdaAuxiliar < direitaAuxiliar)
            {
                Troca(esquerdaAuxiliar, direitaAuxiliar);
            }
        }
        return direitaAuxiliar;
    }

    private void Troca(int esquerdaAuxiliar, int direitaAuxiliar) 
    {
        int auxiliar = vetor[esquerdaAuxiliar];
        vetor[esquerdaAuxiliar] = vetor[direitaAuxiliar];
        vetor[direitaAuxiliar] = auxiliar;
        quantidadeDeTrocas++;
    }
    
    public void ImprimirQuickSort () 
    {
        long start = System.currentTimeMillis();
        Quick(0, vetor.length - 1);
        long stop = System.currentTimeMillis();
        
        System.out.println("Vetor ordenado:\n" + Arrays.toString(vetor));
        System.out.println("Quantidade de trocas: " + quantidadeDeTrocas);
        System.out.println("Tempo de execução em milisegundos: " + (stop - start));
    }    
}
