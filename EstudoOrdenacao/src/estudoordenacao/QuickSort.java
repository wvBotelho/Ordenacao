
package estudoordenacao;

import java.util.Random;

public class QuickSort {
    private int[] vetor = new int[15];
    private Random random = new Random ();
    private int quantidadeDeTrocas = 0;
    
    public QuickSort ()
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
    
    private void Quick (int esquerda, int direita) 
    {
        int meio;
        if (esquerda < direita)
        {
            meio = Intercala(esquerda, direita);
            Quick(esquerda, meio);
            Quick(meio + 1, direita);
        }
    }

    private int Intercala(int esquerda, int direita)
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
        
        System.out.println("Vetor ordenado:");
        
        for (int cont = 0; cont < vetor.length; cont++)
        {
            System.out.print(vetor[cont] + "|");
        }
        System.out.println("\nQuantidade de trocas: " + quantidadeDeTrocas);
        System.out.println("Tempo de execução em milisegundos: " + (stop - start));
    }    
}
