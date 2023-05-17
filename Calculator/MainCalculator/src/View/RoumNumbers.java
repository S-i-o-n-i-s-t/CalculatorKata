package View;

import java.util.HashMap;
import java.util.Map;

public enum RoumNumbers {
    I( 1), II(2) , III(3) , IV(4) , V(5),
    VI(6) , VII(7) , VIII(8) , IX(9) , X(10),
    XX(20) , XXX(30) , XL(40) , L(50) , LX(60) , LXX(70) , LXXX(80) , XD(90) , D(100) ;

    String txt;
    private final int num;
    RoumNumbers(int num) {
        this.num = num;
    }
    private static final Map<Integer,RoumNumbers> map;
    static {
        map = new HashMap<Integer,RoumNumbers>();
        for (RoumNumbers v : RoumNumbers.values()) {
            map.put(v.num, v);
        }
    }
    public static RoumNumbers findByKey(int i) {
        return map.get(i);
    }
    public int getNum(){
        return num;
    }
}
