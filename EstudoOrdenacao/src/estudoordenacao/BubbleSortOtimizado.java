
package estudoordenacao;

import java.util.Arrays;

public class BubbleSortOtimizado {
    private final int[] vetor;
    private int quantidadeDeTrocas;
    
    public BubbleSortOtimizado (int[] vetor) 
    {        
        this.vetor = vetor;
        quantidadeDeTrocas = 0;
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
        System.out.println("Quantidade de trocas: " + quantidadeDeTrocas);
        System.out.println("Tempo de execução em milisegundos: " + (stop - start));
    }    
}
