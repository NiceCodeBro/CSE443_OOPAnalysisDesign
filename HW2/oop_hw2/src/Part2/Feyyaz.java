package Part2;

public class Feyyaz implements Runnable {
    private CominicationClass com;
    public Feyyaz(CominicationClass com)
    {
        this.com = com;
    }
    @Override
    public void run() {
        this.waiting();
        while (true)
        {

            if(com.isFeyyazFlag())
            {
                this.doProcess();
                com.resetFlags();
            }

        }
    }
    public void waiting()
    {
        System.out.println("Feyyaz is waiting for an input file and a transformer");
    }

    public void doProcess()
    {
        System.out.println("Feyyaz grabbed an input file and an transformer");
        System.out.println("Feyyaz is calculating the outputs");
        System.out.println("Feyyaz has delivered the outputs");
        waiting();
        com.setProcessFlag(true);
    }

}