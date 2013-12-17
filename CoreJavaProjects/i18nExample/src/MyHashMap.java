import java.util.ArrayList;
import java.util.List;


public class MyHashMap {

    private Object dummy = new Object();


    class Container {
        Object key;
        Object value;


        public Container(Object k, Object v) {
            this.key = k;
            this.value = v;
        }
    }


    private List<Container> recordList;


    public MyHashMap() {

        this.recordList = new ArrayList<Container>();
    }


    public void put(Object k, Object v) {
        Container c = new Container(k, v);
        synchronized (dummy) {
            for (int i = 0; i < recordList.size(); i++) {
                Container c1 = recordList.get(i);
                if (c1.key.equals(k)) {
                    recordList.remove(i);
                    break;
                }
            }
            recordList.add(c);
        }

    }


    public Object get(Object k) {
        for (int i = 0; i < this.recordList.size(); i++) {
            Container con = recordList.get(i);
            if (k.toString() == con.key.toString()) {
                return con.value;
            }
        }
        return null;
    }


    public static void main(String[] args) {
        MyHashMap hm = new MyHashMap();
        hm.put("1", "1");
        hm.put("2", "2");
        hm.put("3", "3");
        System.out.println(hm.get("3"));
        hm.put("3", "4");
        System.out.println(hm.get("1"));
        System.out.println(hm.get("3"));
        System.out.println(hm.get("8"));;
    }
}
