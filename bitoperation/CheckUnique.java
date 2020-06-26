package bitoperation;

/* Assume the input characters are the extended ASCII, we can use a 8 size
   int array to representing 256 positions
 */
public class CheckUnique {
    public boolean checkUnique(char[] chars) {
        try {
            if (chars == null || chars.length == 0) {
                throw new IllegalArgumentException();
            }

            int[] check = new int[8];
            for (char ch : chars) {
                int row = ch / 32;
                int col = ch % 32;
                int num = check[row];
                // Bit operation to find the bit
                if ((num & 1 << col) != 0) {
                    return false;
                }
                check[row] |= 1 << col;
            }

            return true;
        }
        catch (IllegalArgumentException e) {
            return false;
        }
        catch (Exception e) {
            // catch other exceptions
            return false;
        }
    }
}
