
package estudoordenacao;

import java.util.Arrays;
import java.util.Random;

public class BoboSort {
    private final int[] vetor;
    private Random random;
    private int quantidadeDeTrocas;
    
    public BoboSort (int[] vetor)
    {
        this.vetor = vetor;
        random = new Random ();
        quantidadeDeTrocas = 0;
    }
    
    private void Bobo ()
    {
        while (!IsOrdenado())
        {
            for (int cont = 0; cont < vetor.length; cont++)  
            {
                int numeroRandomico = random.nextInt(vetor.length);
                int auxiliar = vetor[cont];
                vetor[cont] = vetor[numeroRandomico];
                vetor[numeroRandomico] = auxiliar;
                quantidadeDeTrocas++;
            }
        }
    }
    
    private boolean IsOrdenado ()
    {
        for (int cont = 0; cont < vetor.length-1; cont++)
        {
            if (vetor[cont] > vetor[cont + 1])
            {
                return false;
            }
        }
        return true;
    }
    
    public void ImprimirBoboSort ()    
    {
        long start = System.currentTimeMillis();
        Bobo();
        long stop = System.currentTimeMillis();
        
        System.out.println("Vetor ordenado:\n" + Arrays.toString(vetor));
        System.out.println("Quantidade de trocas: " + quantidadeDeTrocas);
        System.out.println("Tempo de execução em milisegundos: " + (stop - start));
    }
}
