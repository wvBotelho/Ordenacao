
package estudoordenacao;

import java.util.Random;

public class SelectionSort {
    private int[] vetor = new int[15];
    private Random random = new Random ();
    
    public SelectionSort ()
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
    
    private void Selection ()
    {
        int numeroEleito;
        int menorNumero;
        int posicaoDoMenorNumero;
        
        for (int cont = 0; cont < vetor.length - 1; cont++)
        {
            numeroEleito = vetor[cont];
            menorNumero = vetor[cont + 1];
            posicaoDoMenorNumero = cont + 1;
            
            for (int i = cont + 2; i < vetor.length; i++)
            {
                if (vetor[i] < menorNumero)
                {
                    menorNumero = vetor[i];
                    posicaoDoMenorNumero = i;
                }
            }
            
            if (menorNumero < numeroEleito)
            {
                vetor[cont] = vetor[posicaoDoMenorNumero];
                vetor[posicaoDoMenorNumero] = numeroEleito;
            }
        }
    }
    
    public void ImprimirSelectionSort ()
    {
        Selection();
        System.out.println("Vetor ordenado:");
        
        for (int cont = 0; cont < vetor.length; cont++)
        {
            System.out.print(vetor[cont] + "|");
        }
    }
}
