import java.util.ArrayList;

public class TBox<T> {
    private T [] tarr;

    public TBox(T[] tmp) {
        this.tarr = tmp;
    }

    public T[] getTmp() {
        return tarr;
    }
    public void changeTwoElements(int one, int two) {
        T tmp = tarr[one];
        tarr[one] = tarr[two];
        tarr[two] = tmp;
    }
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        for (int i = 0; i < tarr.length ; i++) {
            sb.append( (tarr.length-1!=i) ? tarr[i].toString() + ", " : tarr[i].toString() );
        }
        sb.append(" ]");
        return sb.toString();
    }
    public ArrayList<T> convertToArrayList() {
        ArrayList<T> arrayList = new ArrayList<T>();
        for (int i = 0; i < tarr.length ; i++) {
            arrayList.add(tarr[i]);
        }
        return arrayList;
    }
}
