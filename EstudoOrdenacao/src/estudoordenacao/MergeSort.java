
package estudoordenacao;

import java.util.Arrays;

public class MergeSort {
    private final int[] vetor;
    
    public MergeSort (int[] vetor)
    {
        this.vetor = vetor;
    }
    
    private void Merge (int esquerda, int direita)
    {
        int meio;
        if (esquerda < direita)
        {
            meio = (esquerda + direita) / 2;
            Merge(esquerda, meio);
            Merge(meio + 1, direita);
            Intercala(esquerda, direita, meio);
        }
    }

    private void Intercala(int esquerda, int direita, int meio)
    {
        int posicao = esquerda;
        int esquerdaAuxiliar = esquerda;
        int meioAuxiliar = meio + 1;        
        int[] vetorAuxiliar = new int[vetor.length];
        
        while (esquerdaAuxiliar <= meio && meioAuxiliar <= direita)
        {
            if (vetor[esquerdaAuxiliar] <= vetor[meioAuxiliar])
            {
                vetorAuxiliar[posicao] = vetor[esquerdaAuxiliar];
                esquerdaAuxiliar++; 
            }
            else {
                vetorAuxiliar[posicao] = vetor[meioAuxiliar];
                meioAuxiliar++;
            }
            posicao++;
        }
        
        for (int cont = esquerdaAuxiliar; cont <= meio; cont++)
        {
            vetorAuxiliar[posicao] = vetor[cont];
            posicao++;
        }
        
        for (int i = meioAuxiliar; i <= direita; i++)
        {
            vetorAuxiliar[posicao] = vetor[i];
            posicao++;
        }
        
        for (int j = esquerda; j <= direita; j++)
        {
            vetor[j] = vetorAuxiliar[j];
        }
    }
    
    public void ImprimirMergeSort ()
    {
        long start = System.currentTimeMillis();
        Merge(0, vetor.length - 1);
        long stop = System.currentTimeMillis();
        
        System.out.println("Vetor ordenado:\n" + Arrays.toString(vetor));
        System.out.println("Tempo de execução em milisegundos: " + (stop - start));
    }
}
