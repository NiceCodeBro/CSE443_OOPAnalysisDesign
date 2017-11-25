package Part1;

import java.util.ArrayList;
import java.util.List;

public class DFT extends TransformCalculator {

    public DFT()
    {

    }
    public DFT(boolean printExTime)
    {
        super.printExTime = printExTime;
    }
    @Override
    public List<Double>  transformNumbers(List<Double> numbers) {


        List<Double> fourirerNumbers = new ArrayList<Double>();
        for(int i = 0 ; i < numbers.size(); ++i)
        {
            double cos=0,sin=0;
            double constant = 0;
            double currNum = numbers.get(i);
            double newNumReal = 0;
            double newNumImag = 0;
            for(int j = 0; j < i+1; ++j)
            {
                constant += (2* Math.PI * i * j) / numbers.size();
                cos = Math.cos(constant);
                sin = Math.sin(constant);

                newNumReal += currNum * cos;
                newNumImag += currNum* sin;
            }
            fourirerNumbers.add(newNumReal);
            fourirerNumbers.add(newNumImag);
        }
        return fourirerNumbers;

    }


}
