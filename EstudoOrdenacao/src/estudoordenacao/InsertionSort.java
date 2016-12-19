
package estudoordenacao;

import java.util.Arrays;

public class InsertionSort {
    private final int[] vetor;
    private int quantidadeDeTrocas;
    
    public InsertionSort (int[] vetor)
    {
        this.vetor = vetor;
        quantidadeDeTrocas = 0;
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
        System.out.println("Quantidade de trocas: " + quantidadeDeTrocas);
        System.out.println("Tempo de execução em milisegundos: " + (stop - start));
    }
}
