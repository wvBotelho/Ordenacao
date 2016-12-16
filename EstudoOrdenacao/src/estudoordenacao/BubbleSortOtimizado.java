
package estudoordenacao;

import java.util.Arrays;
import java.util.Random;

public class BubbleSortOtimizado {
    private int[] vetor = new int[20];
    private Random random = new Random ();
    private int quantidadeDeTrocas = 0;
    
    public BubbleSortOtimizado () 
    {        
        GerarVetorDesordenado();
    }

    private void GerarVetorDesordenado()
    {
        for (int cont = 0; cont < vetor.length; cont++)
        {
            vetor[cont] = random.nextInt(100);
        }
        System.out.println("Vetor desordenado:\n" + Arrays.toString(vetor));
    }
    
    private void BubbleOtimizado ()
    {
        int auxiliar;
        int numero = vetor.length;
        boolean invertido = true;
        
        while (invertido == true)
        {
            invertido = false;
            
            for (int cont = 0; cont < numero - 1; cont++)
            {
                if (vetor[cont] > vetor[cont + 1])
                {
                    auxiliar = vetor[cont];
                    vetor[cont] = vetor[cont + 1];
                    vetor[cont + 1] = auxiliar;
                    
                    quantidadeDeTrocas++;
                    invertido = true;
                }
            }
            numero--;
        }
    }
    
    public void ImprimirBubbleOtimizado ()
    {
        long start = System.currentTimeMillis();
        BubbleOtimizado();
        long stop = System.currentTimeMillis();
        
        System.out.println("Vetor ordenado:\n" + Arrays.toString(vetor));
        System.out.println("\nQuantidade de trocas: " + quantidadeDeTrocas);
        System.out.println("Tempo de execução em milisegundos: " + (stop - start));
    }    
}
