package Part1;

import java.util.ArrayList;
import java.util.List;

public class DCT extends TransformCalculator{

    @Override
    public List<Double> transformNumbers(List<Double> numbers) {

        List<Double> fourirerNumbers = new ArrayList<Double>();
        for(int i = 0 ; i < numbers.size(); ++i)
        {
            double newNum = 0;
            for(int j = 0; j < numbers.size(); ++j)
            {
                newNum += numbers.get(j) * Math.cos( ( Math.PI/numbers.size() ) * ( j + 0.5) * i );
            }
            fourirerNumbers.add(newNum);
        }
        return fourirerNumbers;
    }


}
