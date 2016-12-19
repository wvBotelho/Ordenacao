
package estudoordenacao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BucketSort {
    private final int[] vetor;
    private List<Integer> vetorDeArray[];
    private int quantidadeDeTrocas;
    
    public BucketSort (int[] vetor)
    {
        this.vetor = vetor;
        quantidadeDeTrocas = 0;
    }
    
    private void Bucket ()    
    {        
        int maiorElemento = 0;        
        for (int cont = 0; cont < vetor.length; cont++)
        {
            if (vetor[cont] > maiorElemento)
            {
                maiorElemento = vetor[cont];
            }
        }
        
        vetorDeArray = new ArrayList[vetor.length];
        
        for (int cont = 0; cont < vetor.length; cont++)
        {
            vetorDeArray[cont] = new ArrayList<>();                                    
        }
        
        for (int cont = 0; cont < vetor.length; cont++)
        {
            int indice = (vetor[cont] * vetor.length) / (maiorElemento + 1);                          
            vetorDeArray[indice].add(vetor[cont]);                     
        }   
        OrdenaBucket();
    }

    private void OrdenaBucket()
    {
        for (int cont = 0; cont < vetorDeArray.length; cont++) 
        {
            Insertion(vetorDeArray[cont]);
        }               
        
        int indice = 0;
        for (int cont = 0; cont < vetorDeArray.length; cont++)
        {
            for (int i = 0; i < vetorDeArray[cont].size(); i++)
            {
                vetor[indice] = vetorDeArray[cont].get(i);
                indice++;
            }
        }        
    }
    
    private void Insertion (List<Integer> vetorDeArray)
    {
        int numeroEleito;
        int indice = 1;
        
        for (int cont = 0; cont < vetorDeArray.size() - 1; cont++)
        {
            numeroEleito = vetorDeArray.get(indice);
            
            for (int i = cont; i >= 0 && vetorDeArray.get(i) > numeroEleito; i--)
            {
                vetorDeArray.remove(i + 1);
                vetorDeArray.add(i + 1, vetorDeArray.get(i));
                vetorDeArray.remove(i);
                vetorDeArray.add(i, numeroEleito);
                quantidadeDeTrocas++;
            }  
            indice++;         
        }
    }
    
    public void ImprimirBucketSort ()
    {
        long start = System.currentTimeMillis();
        Bucket();     
        long stop = System.currentTimeMillis();
        
        System.out.println("Vetor ordenado:\n" + Arrays.toString(vetor));
        System.out.println("Quantidade de trocas: " + quantidadeDeTrocas);
        System.out.println("Tempo de execução em milisegundos: " + (stop - start));
    }
}
