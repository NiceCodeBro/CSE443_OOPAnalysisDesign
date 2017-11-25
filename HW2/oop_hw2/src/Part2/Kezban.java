package Part2;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Kezban  implements Runnable {
    private CominicationClass com;
    public Kezban(CominicationClass com)
    {
        this.com = com;
    }
    @Override
    public void run()
    {
        while (true)
        {                System.out.println("");

            com.setIngredient(this.giveIngredient());

            while (!com.getProcessFlag())
            {

            }
            System.out.println("Kezban has taken the outputs and left ");
            com.setProcessFlag(false);

            try {
                Thread.sleep(5000);
            }catch (InterruptedException e)
            {   }
        }

    }
    public void waiting()
    {


        System.out.println("Kezban is waiting for the outputs to be calculated");

    }

    public void exit()
    {
        System.out.println("Kezban has taken the outputs and left");
    }

    public KezbansIngredients giveIngredient()
    {
        Random r = new Random();
        int num = r.nextInt(3 ) + 1;

        if(num == 1)
        {
            System.out.println("Kezban brougt an input file and outputs");
            this.waiting();
            return KezbansIngredients.InputAndOutput;
        }
        else if(num == 2 )
        {
            System.out.println("Kezban brougt an input file and tranformer");
            this.waiting();
            return KezbansIngredients.InputAndTransformer;
        }
        else
        {
            System.out.println("Kezban brougt an transformer and outputs");
            this.waiting();
            return KezbansIngredients.TransformerAndOutput;
        }

    }
}