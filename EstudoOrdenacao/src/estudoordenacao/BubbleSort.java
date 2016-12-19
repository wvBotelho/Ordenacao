
package estudoordenacao;

import java.util.Arrays;

public class BubbleSort {
    private final int[] vetor;
    private int quantidadeDeTrocas;
    
    public BubbleSort (int[] vetor) 
    {        
        this.vetor = vetor;
        quantidadeDeTrocas = 0;
    }
    
    private void Bubble ()
    {
        int auxiliar;
        
        for (int cont = 0; cont < vetor.length; cont++)
        {
            for (int i = vetor.length - 1; i > cont; i--)
            {
                if (vetor[i - 1] > vetor[i])
                {
                    auxiliar = vetor[i - 1];
                    vetor[i - 1] = vetor[i];
                    vetor[i] = auxiliar;
                    quantidadeDeTrocas++;
                }
            }            
        }
    }
    
    public void ImprimirBubble ()    
    {
        long start = System.currentTimeMillis();
        Bubble();
        long stop = System.currentTimeMillis();
        
        System.out.println("Vetor ordenado:\n" + Arrays.toString(vetor));
        System.out.println("Quantidade de trocas: " + quantidadeDeTrocas);
        System.out.println("Tempo de execução em milisegundos: " + (stop - start)); 
    }
}
