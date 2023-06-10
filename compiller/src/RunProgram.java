import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;





public class RunProgram {
    public static void main(String[] args) {
        Map<String, Variable> variables = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader("SampleProgram.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith("#")) {
                    // Ignore comments
                    continue;
                } else if (line.contains(" = ")) {
                    String[] parts = line.split(" = ");
                    String variableDecl = parts[0].trim();
                    String expression = parts[1].trim();
                    String[] varInfo = variableDecl.split(" ");
                    String dataType = varInfo[0];
                    String name = varInfo[1];
                    String value = new Expression(expression).evaluate(variables);
                    variables.put(name, new Variable(dataType, name, value));
                } else if (line.startsWith("print")) {
                    new Expression(line).evaluate(variables);
                } else if (line.startsWith("loop")) {
                    Pattern pattern = Pattern.compile("loop\\((\\w+)\\) (.*)");
                    Matcher matcher = pattern.matcher(line);
                    if (matcher.find()) {
                        int times = Integer.parseInt(matcher.group(1));
                        String expression = matcher.group(2);
                        for (int i = 0; i < times; i++) {
                            new Expression(expression).evaluate(variables);
                        }
                    }
                } else if (line.startsWith("if")) {
                    Pattern pattern = Pattern.compile("if\\((.)\\) (.)");
                    Matcher matcher = pattern.matcher(line);
                    if (matcher.find()) {
                        String condition = matcher.group(1);
                        String expression = matcher.group(2);
                        if (condition.contains(">")) {
                            String[] parts = condition.split(">");
                            String variable = parts[0].trim();
                            int value = Integer.parseInt(parts[1].trim());
                            if (variables.get(variable).intValue() > value) {
                                new Expression(expression).evaluate(variables);
                            }
                        }
                    }
                }else{
                    System.out.println("Error was caught on this line:"+line);
                    System.exit(0);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Program ran successfully!");
    }
}