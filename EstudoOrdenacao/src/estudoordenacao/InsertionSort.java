
package estudoordenacao;

import java.util.Random;

public class InsertionSort {
    private int[] vetor = new int[20];
    private Random random = new Random();
    private int quantidadeDeTrocas = 0;
    
    public InsertionSort ()
    {
        System.out.println("Vetor desordenado:");
        GerarVetorDesordenado();
    }
    
    private void GerarVetorDesordenado ()
    {
        for (int cont = 0; cont < vetor.length; cont++)
        {
            vetor[cont] = random.nextInt(100);
            System.out.print(vetor[cont] + "|");
        }
        System.out.println("");
    }
    
    private void Insertion ()
    {
        int numeroEleito;
        
        for (int cont = 1; cont < vetor.length; cont++)
        {
            numeroEleito = vetor[cont];
            
            for (int i = cont - 1; i >= 0 && vetor[i] > numeroEleito; i--)
            {
                vetor[i + 1] = vetor[i];
                vetor[i] = numeroEleito;
                quantidadeDeTrocas++;
            }    
        }
    }
    
    public void ImprimirInsertionSort ()
    {
        long start = System.currentTimeMillis();        
        Insertion();
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
