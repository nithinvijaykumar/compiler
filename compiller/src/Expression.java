import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Expression {
    private String logic;

    public Expression(String logic) {
        this.logic = logic;
    }

    public String evaluate(Map<String, Variable> variables) {
        if (logic.startsWith("input")) {
            String name = logic.substring(6);
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter value for " + name + ": ");
            String value = scanner.nextLine();
            return value;
        } else if (logic.startsWith("add")) {
            String[] varNames = parse("add");
            int var1 = variables.get(varNames[0]).intValue();
            int var2 = variables.get(varNames[1]).intValue();
            return String.valueOf(var1 + var2);
        } else if (logic.startsWith("sub")) {
            String[] varNames = parse("sub");
            int var1 = variables.get(varNames[0]).intValue();
            int var2 = variables.get(varNames[1]).intValue();
            return String.valueOf(var1 - var2);
        } else if (logic.startsWith("mult")) {
            String[] varNames = parse("mult");
            int var1 = variables.get(varNames[0]).intValue();
            int var2 = variables.get(varNames[1]).intValue();
            return String.valueOf(var1 * var2);
        } else if (logic.startsWith("div")) {
            String[] varNames = parse("div");
            int var1 = variables.get(varNames[0]).intValue();
            int var2 = variables.get(varNames[1]).intValue();
            return String.valueOf(var1 / var2);
        } else if (logic.startsWith("print")) {
            String var = logic.replace("print(", "").replace(")", "");
            System.out.println(variables.get(var).strValue());
            return variables.get(var).strValue();
        } else {
            return logic;
        }
    }

    private String[] parse(String functionName) {
        Pattern pattern = Pattern.compile(functionName + "\\((\\w+),(\\w+)\\)");
        Matcher matcher = pattern.matcher(logic);
        if (matcher.find()) {
            String var1 = matcher.group(1);
            String var2 = matcher.group(2);
            return new String[]{var1, var2};
        }
        return null;
    }
}