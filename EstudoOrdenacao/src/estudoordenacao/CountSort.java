
package estudoordenacao;

import java.util.Arrays;

public class CountSort {
    private final int[] vetor;
    
    public CountSort (int[] vetor)
    {
        this.vetor = vetor;
    }
    
    private void Count ()
    {
        int maiorElemento = 0;
        
        for (int cont = 0; cont < vetor.length; cont++)
        {
            if (vetor[cont] > maiorElemento)
            {
                maiorElemento = vetor[cont];
            }
        }
        
        int[] vetorContador = new int[maiorElemento + 1];
                
        for (int cont = 0; cont < vetor.length; cont++)
        {
            vetorContador[vetor[cont]]++;
        }
        
        for (int cont = 1; cont < vetorContador.length; cont++)
        {
            vetorContador[cont] += vetorContador[cont - 1];
        }
        
        int[] vetorAuxiliar = new int[vetor.length];
        
        for (int cont = vetor.length - 1; cont >= 0; cont--)
        {
            vetorAuxiliar[--vetorContador[vetor[cont]]] = vetor[cont];            
        }
        
        System.arraycopy(vetorAuxiliar, 0, vetor, 0, vetorAuxiliar.length);
    }
    
    public void ImprimirCountSort ()
    {
        long start = System.currentTimeMillis();
        Count();
        long stop = System.currentTimeMillis();
        
        System.out.println("Vetor ordenado:\n" + Arrays.toString(vetor));
        System.out.println("Tempo de execução em milisegundos:" + (stop - start));
    }    
}
