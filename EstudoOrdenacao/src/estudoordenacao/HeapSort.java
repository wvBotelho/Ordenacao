
package estudoordenacao;

import java.util.Arrays;

public class HeapSort {
    private final int[] vetor;
    private int quantidadeDeTrocas;
    
    public HeapSort (int[] vetor)
    {
        this.vetor = vetor;
        quantidadeDeTrocas = 0;
    }
    
    private void Heap () 
    {
        CriaHeap();
        int numero = vetor.length;
        
        for (int cont = vetor.length - 1; cont > 0; cont--)
        {
            Troca(cont, 0);        
            ArrumaHeap(0, --numero);
        }
    }
    
    private void CriaHeap ()
    {
        for (int cont = (vetor.length / 2) - 1; cont >= 0; cont--)
        {
            ArrumaHeap(cont, vetor.length);            
        }
    }

    private void ArrumaHeap(int pai, int fim)
    {
        int filhoDireito = pai * 2;
        int filhoEsquerdo = (pai * 2) + 1;
        int elementoMaior;
        
        if (filhoEsquerdo < fim && vetor[filhoEsquerdo] > vetor[pai])
        {            
            elementoMaior = filhoEsquerdo;
        }
        else{
            elementoMaior = pai;
        }
        
        if (filhoDireito < fim && vetor[filhoDireito] > vetor[elementoMaior])
        {
            elementoMaior = filhoDireito;
        }
        
        if (elementoMaior != pai)
        {
            Troca(pai, elementoMaior);
            ArrumaHeap(elementoMaior, fim);
        }
    }

    private void Troca(int pai, int elementoMaior)
    {
        int auxiliar = vetor[pai];
        vetor[pai] = vetor[elementoMaior];
        vetor[elementoMaior] = auxiliar;
        quantidadeDeTrocas++;
    }
    
    public void ImprimirHeapSort ()
    {
        long start = System.currentTimeMillis();
        Heap();
        long stop = System.currentTimeMillis();
        
        System.out.println("Vetor ordenado:\n" + Arrays.toString(vetor));
        System.out.println("Quantidade de trocas: " + quantidadeDeTrocas);
        System.out.println("Tempo de execução em milisegundos: " + (stop - start)); 
    }
}
