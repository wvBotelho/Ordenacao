
package estudoordenacao;

import java.util.Arrays;
import java.util.Random;

public class TimSort {
    private int[] vetor = new int[20];
    private Random random = new Random ();
    private int quantidadeDeTrocas = 0;
    
    public TimSort ()
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
    
    private void Tim (int esquerda, int direita, int vetorMinimo)   
    {
        int meio;
        int auxiliar = esquerda - direita;
        
        if (esquerda <= direita)
        {
        }
        
        if (auxiliar > vetorMinimo)
        {
            meio = (esquerda + direita) / 2;
            Tim(esquerda, meio, vetorMinimo);
            Tim(meio + 1, direita, vetorMinimo);
            Intercala(esquerda, direita, meio);
        }
        else{
            Insertion(esquerda, direita);
        }
    }
    
    private void Intercala(int esquerda, int direita, int meio)
    {
        int posicao = esquerda;
        int esquerdaAuxiliar = esquerda;
        int meioAuxiliar = meio + 1;        
        int[] vetorAuxiliar = new int[20];
        
        while (esquerdaAuxiliar <= meio && meioAuxiliar <= direita)
        {
            if (vetor[esquerdaAuxiliar] <= vetor[meioAuxiliar])
            {
                vetorAuxiliar[posicao] = vetor[esquerdaAuxiliar];
                esquerdaAuxiliar++; 
            }
            else {
                vetorAuxiliar[posicao] = vetor[meioAuxiliar];
                meioAuxiliar++;
            }
            posicao++;
        }
        
        for (int cont = esquerdaAuxiliar; cont <= meio; cont++)
        {
            vetorAuxiliar[posicao] = vetor[cont];
            posicao++;
        }
        
        for (int i = meioAuxiliar; i <= direita; i++)
        {
            vetorAuxiliar[posicao] = vetor[i];
            posicao++;
        }
        
        for (int j = esquerda; j <= direita; j++)
        {
            vetor[j] = vetorAuxiliar[j];
        }
    }
    
    private void Insertion (int esquerda, int direita)
    {
        int numeroEleito;
        
        for (int cont = esquerda + 1; cont < direita; cont++)
        {
            numeroEleito = vetor[cont];
            
            for (int i = cont - 1; i >= 0 && vetor[i] > numeroEleito; i--)
            {
                vetor[i + 1] = vetor[i];
                vetor[i] = numeroEleito;
                quantidadeDeTrocas++;
            }    
        }
    }
    
    public void ImprimirTimSort ()
    {
        long start = System.currentTimeMillis();
        Tim(0, vetor.length, 4);
        long stop = System.currentTimeMillis();
              
        System.out.println("Vetor ordenado:\n" + Arrays.toString(vetor));
        System.out.println("quantidade de trocas: " + quantidadeDeTrocas);
        System.out.println("Tempo de execução em milisegundos: " + (stop - start)); 
    }
}
