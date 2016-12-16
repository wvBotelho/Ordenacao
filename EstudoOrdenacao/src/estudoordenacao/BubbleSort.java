
package estudoordenacao;

import java.util.Random;

public class BubbleSort {
    private int[] vetor = new int[20];
    private Random random = new Random ();
    private int quantidadeDeTrocas = 0;
    
    public BubbleSort () 
    {
        System.out.println("Vetor desordenado:");
        GerarVetorDesordenado();
    }

    private void GerarVetorDesordenado()
    {
        for (int cont = 0; cont < vetor.length; cont++)
        {
            vetor[cont] = random.nextInt(100);
            System.out.printf(vetor[cont] + "|");
        }
        System.out.println("");
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
        
        System.out.println("Vetor ordenado:");
        
        for (int cont = 0; cont < vetor.length; cont++)
        {
            System.out.printf(vetor[cont] + "|");
        }
        System.out.println("\nQuantidade de trocas: " + quantidadeDeTrocas);
        System.out.println("Tempo de execução em milisegundos: " + (stop - start)); 
    }
}
