
package estudoordenacao;

import java.util.Arrays;

public class RadixSort {
    private int[] vetor;
    
    public RadixSort (int[] vetor)
    {
        this.vetor = vetor;
    }
    
    private void Radix ()    
    {
        int maiorElemento = 0;
        int posicao = 1;
        
        for (int cont = 0; cont < vetor.length; cont++)
        {
            if (vetor[cont] > maiorElemento)
            {
                maiorElemento = vetor[cont];
            }
        }
        
        while ((maiorElemento / posicao) > 0)
        {
            Count(posicao);
            posicao *= 10;
        }
    }

    private void Count(int posicao)
    {        
        int[] vetorContador = new int[10];
        
        for (int cont = 0; cont < vetor.length; cont++)
        {
            int indice = (vetor[cont] / posicao) % 10; 
            vetorContador[indice]++; 
        }
        
        for (int cont = 1; cont < vetorContador.length; cont++)
        {
            vetorContador[cont] += vetorContador[cont - 1];
        }
        
        int[] vetorAuxiliar = new int[vetor.length];
        
        for (int cont = vetor.length - 1; cont >= 0; cont--)
        {
            int indice = (vetor[cont] / posicao) % 10;
            vetorAuxiliar[vetorContador[indice] - 1] = vetor[cont];    
            vetorContador[indice]--;
        }              
        vetor = vetorAuxiliar;
    }
    
    public void ImprimirRadixSort ()
    {
        long start = System.currentTimeMillis();
        Radix();
        long stop = System.currentTimeMillis();
        
        System.out.println("Vetor ordenado:\n" + Arrays.toString(vetor));
        System.out.println("Tempo de execução em milisegundos: " + (stop - start));
    }
}
