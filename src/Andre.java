import java.util.ArrayList;

public class Andre {

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList();
        a.add(1);
        a.add(3);
        a.add(4);
        ArrayList<Integer> b = new ArrayList();
        b.add(-1);
        b.add(2);
        b.add(3);
        b.add(5);

        System.out.println(mergeSort(a, b).toString());

    }

    private static ArrayList uniao(ArrayList a, ArrayList b) {
        a.addAll(b);
        return a;
    }

    private static ArrayList sort(ArrayList<Integer> a, ArrayList<Integer> b) {
        ArrayList<Integer> c = new ArrayList();
        addOrdenado(c, a);
        addOrdenado(c, b);
        return c;
    }

    private static ArrayList mergeSort(ArrayList<Integer> a, ArrayList<Integer> b) {
        ArrayList<Integer> c = uniao(a, b);
        MergeSort.sort(c);
        return c;
    }

    private static void addOrdenado(ArrayList<Integer> c, ArrayList<Integer> b) {
        int indice;

        for (int i = 0; i < b.size(); i++) {
            indice = -1;
            for (int j = 0; j < c.size(); j++) {
                if (c.get(j) >= b.get(i)) {
                    indice = j;
                    break;
                }
            }
            if (indice == -1) {
                c.add(b.get(i));
            } else {
                c.add(indice, b.get(i));
            }
        }
    }

    private static ArrayList interseccao(ArrayList a, ArrayList b) {
        ArrayList c = new ArrayList();
        for (int i = 0; i < b.size(); i++) {
            if (a.stream().anyMatch(b.get(i)::equals)) {
                c.add(b.get(i));
            }
        }
        return c;
    }

    private static ArrayList removeDuplicados(ArrayList a, ArrayList b) {
        ArrayList c = new ArrayList();
        c.addAll(a);
        for (int i = 0; i < b.size(); i++) {
            if (c.stream().anyMatch(b.get(i)::equals)) {
                c.remove(b.get(i));
            } else {
                c.add(b.get(i));
            }
        }
        return c;
    }
}
