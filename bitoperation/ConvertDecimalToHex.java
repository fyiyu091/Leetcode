package bitoperation;

/* Convert decimal to hex
 */
public class ConvertDecimalToHex {
    public String convertDecimalToHex(int n) {
        char[] hexSymbols = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append(hexSymbols[n % 16]);
            n /= 16;
        }

        return "0x" + sb.reverse().toString();
    }

    public static void main(String[] args) {
        ConvertDecimalToHex test = new ConvertDecimalToHex();
        System.out.println(test.convertDecimalToHex(21378));
    }
}
