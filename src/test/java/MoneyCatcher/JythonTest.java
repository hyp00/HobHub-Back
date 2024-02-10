package MoneyCatcher;
import java.util.*;
import org.python.util.PythonInterpreter;
public class JythonTest {
    private static PythonInterpreter interpreter;
    public static void main(String[] args)
    {
        Scanner scannner = new Scanner(System.in);

        interpreter = new PythonInterpreter();
        interpreter.execfile("C:/vscode_folder/pyTest.py");
        interpreter.exec("user_input=input()");
    }

}
