
package estudoordenacao;

import java.util.Arrays;
import java.util.Random;

public class EstudoOrdenacao {
    private static int[] vetor = new int[20];
    private static Random random = new Random ();
    
    public static void main(String[] args) {
        GerarVetorDesordenado();
        //InsertionSort insertion = new InsertionSort (vetor);
        //insertion.ImprimirInsertionSort();
        
        //SelectionSort selection = new SelectionSort (vetor);
        //selection.ImprimirSelectionSort();
        
        //MergeSort merge = new MergeSort (vetor);
        //merge.ImprimirMergeSort();
        
        //QuickSort quick = new QuickSort (vetor);
        //quick.ImprimirQuickSort();

        //HeapSort heap = new HeapSort(vetor);
        //heap.ImprimirHeapSort();
        
        //BubbleSort bubble = new BubbleSort (vetor);
        //bubble.ImprimirBubble();

        //BubbleSortOtimizado bubbleOtimizado = new BubbleSortOtimizado(vetor);
        //bubbleOtimizado.ImprimirBubbleOtimizado();

        //TimSort tim = new TimSort (vetor);
        //tim.ImprimirTimSort();

        //BucketSort bucket = new BucketSort(vetor);
        //bucket.ImprimirBucketSort();

        //BoboSort bobo = new BoboSort (vetor);
        //bobo.ImprimirBoboSort();
        
        //CountSort count = new CountSort (vetor);
        //count.ImprimirCountSort();
        
        RadixSort radix = new RadixSort (vetor);
        radix.ImprimirRadixSort();
    }
    
    private static void GerarVetorDesordenado()
    {
        for (int cont = 0; cont < vetor.length; cont++)
        {
            vetor[cont] = random.nextInt(100);
        }
        System.out.println("Vetor desordenado:\n" + Arrays.toString(vetor));
    }    
}
