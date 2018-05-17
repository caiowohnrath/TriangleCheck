package tradeshift;

import com.google.common.base.Strings;

public class TriangleCheck {

    public static void main(String[] args) {

        if (args.length == 1 && ("-h".equalsIgnoreCase(args[0]) || "-help".equalsIgnoreCase(args[0]))) {
            System.out.println("------------------------------");
            System.out.println("Triangle classification. \n\nEnter the size (int or double) of the triangle sides to check its classification.\n");
            System.out.println("Examples:\n10 10 10\n10 5 10\n7.5 8.5 12.3\n\n");
            System.exit(1);
        }

        if (args.length != 3) {
            System.out.println("Wrong number of inputs. You should enter the size of the triangle sides to check its classification.");
            System.exit(1);
        }

        try {
            classifyIntTriangle(args[0], args[1], args[2]);
        } catch (NumberFormatException e) {
            try {
                classifyDoubleTriangle(args[0], args[1], args[2]);
            } catch (NumberFormatException ex) {
                System.out.println("Wrong input format. All inputs should be numbers (int or double)");
                System.exit(1);
            }
        }
    }

    static void classifyIntTriangle(String arg0, String arg1, String arg2) {
        int a = convertStringToInt(arg0);
        int b = convertStringToInt(arg1);
        int c = convertStringToInt(arg2);
        System.out.println(String.format("The triangle %d, %d, %d is %s.", a, b, c, Triangle.classifyTriangle(a, b, c)));
    }

    static void classifyDoubleTriangle(String arg0, String arg1, String arg2) {
        double a = convertStringToDouble(arg0);
        double b = convertStringToDouble(arg1);
        double c = convertStringToDouble(arg2);
        System.out.println(String.format("The triangle %f, %f, %f is %s.", a, b, c, Triangle.classifyTriangle(a, b, c)));
    }

    static int convertStringToInt(String numberToConvert) {
        if (Strings.isNullOrEmpty(numberToConvert)) {
            throw new NumberFormatException("Wrong number");
        }

        return Integer.parseInt(numberToConvert);
    }

    static double convertStringToDouble(String numberToConvert) {
        if (Strings.isNullOrEmpty(numberToConvert)) {
            throw new NumberFormatException("Wrong number");
        }

        return Double.parseDouble(numberToConvert);
    }
}
