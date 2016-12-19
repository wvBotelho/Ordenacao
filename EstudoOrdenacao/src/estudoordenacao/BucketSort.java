
package estudoordenacao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class BucketSort {
    private int[] vetor = new int[20];
    private Random random = new Random ();
    private List<Integer> vetorDeArray[];
    private int quantidadeDeTrocas = 0;
    
    public BucketSort ()
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
    
    private void Bucket (int maiorElemento)    
    {        
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
        Bucket(99);     
        long stop = System.currentTimeMillis();
        
        System.out.println("Vetor ordenado:\n" + Arrays.toString(vetor));
        System.out.println("Quantidade de trocas: " + quantidadeDeTrocas);
        System.out.println("Tempo de execução em milisegundos: " + (stop - start));
    }
}
