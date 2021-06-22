package test;

/**
 *
 * KPM 搜索法
 * @author david
 */
public class TestKMP {

    public static void main(String[] args){
        String s = "bcbd acbacd acbcacb";
        String p = "acbcacb" ;
        int[] next = generateNext(p);
        int index = kpmSearch(s,p,next);
        int m = s.indexOf(p);
        System.out.println("index ===" +index);
    }



    public static int[] generateNext(String p){
        int[] next = new int[p.length()];
        char[] pch = p.toCharArray();
        int k = -1;
        next[0] =  -1;
        int j = 0;
        int plen = p.length();
        while (j < plen -1){
            if(k == -1 || pch[j] == pch [k]){
                ++k;
                ++j;
                if(pch[j] != pch[k]){
                    next[j] = k;
                }else {
                    next[j] = next[k];
                }
            }else {
                k = next[k];
            }
        }
        return next;
    }

    public static int kpmSearch(String s,String p,int[] next){
        char[] pchar = p.toCharArray();
        char[] schar = s.toCharArray();
        int plen = p.length();
        int slen = s.length();
        int j = 0;
        int i = 0;
        while (j < plen && i < slen){
            if( j == -1 || pchar[j] == schar[i]){
                i ++ ;
                j ++ ;
            }else {
                j = next[j];
            }
        }
        if(j == plen){
            return i-j;
        }else {
            return -1;
        }
    }

}
