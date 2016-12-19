
package estudoordenacao;

import java.util.Arrays;
import java.util.Random;

public class BoboSort {
    private int[] vetor = new int[10];
    private Random random = new Random ();
    private int quantidadeDeTrocas = 0;
    
    public BoboSort ()
    {
        GerarVetorDesordenado();
    }

    private void GerarVetorDesordenado()
    {
        for (int cont = 0; cont < vetor.length; cont++)
        {
            vetor[cont] = random.nextInt(vetor.length);
        }
        System.out.println("Vetor desordenado:\n" + Arrays.toString(vetor));
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
