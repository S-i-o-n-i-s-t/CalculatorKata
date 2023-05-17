package View;

public class Number implements Scan{
    private String str;
    public String getStr() {
        return str;
    }
    public String createStr(){
        str = text();
        return str;
    }
}
