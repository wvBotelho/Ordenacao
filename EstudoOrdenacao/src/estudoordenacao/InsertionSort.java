
package estudoordenacao;

import java.util.Arrays;
import java.util.Random;

public class InsertionSort {
    private int[] vetor = new int[20];
    private Random random = new Random();
    private int quantidadeDeTrocas = 0;
    
    public InsertionSort ()
    {
        GerarVetorDesordenado();
    }
    
    private void GerarVetorDesordenado ()
    {
        for (int cont = 0; cont < vetor.length; cont++)
        {
            vetor[cont] = random.nextInt(100);
        }
        System.out.println("Vetor desordenado:\n" + Arrays.toString(vetor));
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
        
        System.out.println("Vetor ordenado:\n" + Arrays.toString(vetor));
        System.out.println("\nQuantidade de trocas: " + quantidadeDeTrocas);
        System.out.println("Tempo de execução em milisegundos: " + (stop - start));
    }
}
