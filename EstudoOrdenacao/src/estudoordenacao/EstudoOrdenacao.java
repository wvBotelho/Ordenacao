
package estudoordenacao;

public class EstudoOrdenacao {

    public static void main(String[] args) {
//        InsertionSort insertion = new InsertionSort ();
//        insertion.ImprimirInsertionSort();
//        
//        SelectionSort selection = new SelectionSort ();
//        selection.ImprimirSelectionSort();
//        
//        MergeSort merge = new MergeSort ();
//        merge.ImprimirMergeSort();
//        
//        QuickSort quick = new QuickSort ();
//        quick.ImprimirQuickSort();

//        HeapSort heap = new HeapSort();
//        heap.ImprimirHeapSort();
        
        BubbleSort bubble = new BubbleSort();
        bubble.ImprimirBubble();

        BubbleSortOtimizado bubbleOtimizado = new BubbleSortOtimizado();
        bubbleOtimizado.ImprimirBubbleOtimizado();

    }    
}
