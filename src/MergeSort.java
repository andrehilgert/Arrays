import java.util.ArrayList;

public class MergeSort {
    protected static void sort(ArrayList<Integer> a) {
        int tamanho = a.size();

        if (tamanho < 2) {
            return; //Caso tenha apenas um elemento não tem mais como dividir
        }

        int pontoMedio = tamanho / 2;
        ArrayList<Integer> primeiraMetade = new ArrayList();
        ArrayList<Integer> segundaMetade = new ArrayList();

        for (int i = 0; i < tamanho; i++) {//divide em dois arrays
            if (i < pontoMedio) {
                primeiraMetade.add(a.get(i));
            } else {
                segundaMetade.add(a.get(i));
            }
        }

        sort(primeiraMetade);
        sort(segundaMetade);

        mesclar(a, primeiraMetade, segundaMetade);
    }

    private static void mesclar(ArrayList<Integer> a, ArrayList<Integer> primeiraMetade, ArrayList<Integer> segundaMetade) {
        a.clear();//limpa o array original, pois será reescrito, na ordem
        int tamanhoPrimeira = primeiraMetade.size();
        int tamanhoSegunda = segundaMetade.size();
        int posPrimeira = 0;
        int posSegunda = 0;

        do {//adiciona para o array original, na ordem crescente
            if (primeiraMetade.get(posPrimeira) < segundaMetade.get(posSegunda)) {
                a.add(primeiraMetade.get(posPrimeira));
                posPrimeira++;//avança, pois já utilizou este elemento.
            } else {
                a.add(segundaMetade.get(posSegunda));
                posSegunda++;//avança, pois já utilizou este elemento.
            }
        } while (posPrimeira < tamanhoPrimeira && posSegunda < tamanhoSegunda);

        //adiciona os elementos que sobraram ao final do array, pois são maiores que os já adicionados.
        for (; posPrimeira < tamanhoPrimeira; posPrimeira++) {
            a.add(primeiraMetade.get(posPrimeira));
        }

        for (; posSegunda < tamanhoSegunda; posSegunda++) {
            a.add(segundaMetade.get(posSegunda));
        }
    }
}
