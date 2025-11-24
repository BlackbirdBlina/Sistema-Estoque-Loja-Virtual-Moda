package main.com.sistema.ordenacao;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MergeSort {

    /**
     * Método principal que inicia o processo de Merge Sort.
     * @param <T> O tipo dos elementos na lista.
     * @param list A lista a ser ordenada.
     * @param comparator O comparador a ser usado para a ordenação.
     * @return Uma nova lista ordenada.
     */
    public static <T> List<T> mergeSort(List<T> list, Comparator<? super T> comparator) {
        if (list.size() <= 1) {
            return list;
        }

        int mid = list.size() / 2;
        List<T> left = list.subList(0, mid);
        List<T> right = list.subList(mid, list.size());

        // Chamadas recursivas para ordenar as sublistas
        List<T> sortedLeft = mergeSort(left, comparator);
        List<T> sortedRight = mergeSort(right, comparator);

        // Mescla as sublistas ordenadas
        return merge(sortedLeft, sortedRight, comparator);
    }

    /**
     * Método para mesclar duas listas já ordenadas.
     * @param <T> O tipo dos elementos nas listas.
     * @param left A lista da esquerda ordenada.
     * @param right A lista da direita ordenada.
     * @param comparator O comparador a ser usado para a ordenação.
     * @return Uma nova lista mesclada e ordenada.
     */
    private static <T> List<T> merge(List<T> left, List<T> right, Comparator<? super T> comparator) {
        List<T> result = new ArrayList<>();
        int i = 0;
        int j = 0;

        while (i < left.size() && j < right.size()) {
            // Usa o comparator para determinar a ordem
            if (comparator.compare(left.get(i), right.get(j)) <= 0) {
                result.add(left.get(i));
                i++;
            } else {
                result.add(right.get(j));
                j++;
            }
        }

        // Adiciona elementos restantes, se houver
        while (i < left.size()) {
            result.add(left.get(i));
            i++;
        }

        while (j < right.size()) {
            result.add(right.get(j));
            j++;
        }

        return result;
    }
}
