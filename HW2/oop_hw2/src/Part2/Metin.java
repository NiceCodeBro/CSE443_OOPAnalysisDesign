package Part2;

public class Metin implements Runnable {
    private CominicationClass com;
    public Metin(CominicationClass com)
    {
        this.com = com;
    }
    @Override
    public void run() {
        waiting();
        while (true)
        {
            if(com.isMetinFlag())
            {
                this.doProcess();
                com.resetFlags();
            }

        }
    }

    public void waiting()
    {
        System.out.println("Metin is waiting for a transformer and an output file");
    }
    public void doProcess()
    {
        System.out.println("Metin grabbed an transformer and an output file");
        System.out.println("Metin is calculating the outputs");
        System.out.println("Metin has delivered the outputs");
        waiting();
        com.setProcessFlag(true);
    }
}
