package hashtable;

public class OpenAddressingHashTable {

    private Integer table[];
    int numItems;
    static final Integer DELETED = -12345, NOT_FOUND = -1;

    public OpenAddressingHashTable(int size) {
        this.table = new Integer[size];
        this.numItems = 0;
        for(int i = 0; i < size; i++) table[i] = null;
    }

    private int hash(int i, Integer x) {
        return (x + i) % table.length;
    }

    public void insert(Integer x) {
        int slot;
        if (numItems == table.length) {
            System.out.println("해쉬테이블 공간이 없습니다.");
        }
        else{
            for (int i = 0; i < table.length; i++) { //Linear Probing
                slot = hash(i, x);
                if (table[slot] == null || table[slot] == DELETED) { //한개씩 증가하면서 빈 공간이 있는지 확인
                    table[slot] = x;
                    numItems++;
                    break;
                }
            }
        }
    }

    public Integer search(Integer x) {
        int slot;
        for (int i = 0; i < table.length; i++) {
            slot = hash(i, x);
            if (table[slot] == null) return NOT_FOUND;
            if (table[slot].compareTo(x) == 0) {
                return slot;
            }
        }
        return NOT_FOUND;
    }

    public void delete(Integer x) {
        int slot = 0;
        for (int i = 0; i < table.length; i++) {
            slot = hash(i, x);
            if (table[slot] == null) break; //지울 수 없어여
            if (table[slot].compareTo(x) == 0){
                table[slot] = DELETED;
                numItems--;
                break;
            }
        }
    }

    public Integer getItem(Integer i){
        return table[i];
    }
}
