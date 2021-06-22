package test.util;

public class Usc2Util {

    public static void main(String[] args){
        String content = "0076006900640065006F003A002000680074007400700073003A002F002F006200690074002E006C0079002F003200520063006100670064003400200E2A0E2D0E1A0E160E320E210E420E170E23003A00300032002D0031003100350038003800310034";
        String result = UCS2ToUtf8(content);
        System.out.println(result);
    }


    public static String UCS2ToUtf8(String theString) {

        // 对theString参数进行处理
        String strU = "\\u";
        String resultStr = "";
        int j = 0;
        int length = theString.trim().length();
        StringBuffer outBuffer = new StringBuffer(length);
        try {
            if (!(theString == null || theString.trim().equals(""))) {

                for (int i = -4; i < length - 4; i = i + 4) {
                    String temStr = theString.trim().substring(i + 4, j + 4);
                    resultStr = resultStr + strU + temStr;
                    j = j + 4;
                }
                char aChar;
                int len = resultStr.length();
                for (int x = 0; x < len; ) {
                    aChar = resultStr.charAt(x++);
                    if (aChar == '\\') {
                        aChar = resultStr.charAt(x++);
                        if (aChar == 'u') {
                            // Read the xxxx
                            int value = 0;
                            for (int i = 0; i < 4; i++) {
                                aChar = resultStr.charAt(x++);
                                switch (aChar) {
                                    case '0':
                                    case '1':
                                    case '2':
                                    case '3':
                                    case '4':
                                    case '5':
                                    case '6':
                                    case '7':
                                    case '8':
                                    case '9':
                                        value = (value << 4) + aChar - '0';
                                        break;
                                    case 'A':
                                    case 'B':
                                    case 'C':
                                    case 'D':
                                    case 'E':
                                    case 'F':
                                        value = (value << 4) + 10 + aChar - 'A';
                                        break;
                                    default:
                                        throw new IllegalArgumentException();
                                }
                            }
                            outBuffer.append((char) value);
                        } else {
                            if (aChar == 't')
                                aChar = ' ';
                            else if (aChar == 'r')
                                aChar = 'r';
                            else if (aChar == 'n')
                                aChar = 'n';
                            else if (aChar == 'f')
                                aChar = 'f';
                            outBuffer.append(aChar);
                        }
                    }
                }
            }
        }catch (Exception e) {
            return e.toString();

        }
        return outBuffer.toString();

}


}
