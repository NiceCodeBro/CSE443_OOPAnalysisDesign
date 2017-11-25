package Part1;

public class test {
    public static void main(String[] args)
    {
        TransformCalculator tc = new DFT(false);
        tc.doProcess("numbers.txt","output.txt");
    }
}
