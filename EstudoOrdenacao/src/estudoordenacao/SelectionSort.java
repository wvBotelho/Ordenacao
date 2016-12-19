
package estudoordenacao;

import java.util.Arrays;

public class SelectionSort {
    private int[] vetor;
    private int quantidadeDeTrocas;
    
    public SelectionSort (int[] vetor)
    {
        this.vetor = vetor;
        quantidadeDeTrocas = 0;
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
                quantidadeDeTrocas++;
            }
        }
    }
    
    public void ImprimirSelectionSort ()
    {
        long start = System.currentTimeMillis();
        Selection();
        long stop = System.currentTimeMillis();
        
        System.out.println("Vetor ordenado:\n" + Arrays.toString(vetor));
        System.out.println("Quantidade de trocas: " + quantidadeDeTrocas);
        System.out.println("Tempo de execução em milisegundos: " + (stop - start));
    }
}
