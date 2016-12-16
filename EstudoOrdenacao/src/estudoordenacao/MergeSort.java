
package estudoordenacao;

import java.util.Random;

public class MergeSort {
    private int[] vetor = new int[15];
    private Random random = new Random ();
    
    public MergeSort ()
    {
        System.out.println("Vetor desordenado:");
        GerarVetorDesordenado();
    }
    
    private void GerarVetorDesordenado ()
    {
        for (int cont = 0; cont < vetor.length; cont++)
        {
            vetor[cont] = random.nextInt(1000);
            System.out.print(vetor[cont] + "|");
        }
        System.out.println("");
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
        int[] vetorAuxiliar = new int[15];
        
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
        
        System.out.println("Vetor ordenado:");
        
        for (int cont = 0; cont < vetor.length; cont++)
        {
            System.out.print(vetor[cont] + "|");
        }
        System.out.println("\nTempo de execução em milisegundos: " + (stop - start));
    }
}
