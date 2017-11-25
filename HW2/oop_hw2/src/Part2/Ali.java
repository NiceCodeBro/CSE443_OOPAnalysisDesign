package Part2;

public class Ali implements Runnable {
    private CominicationClass com;
    public Ali(CominicationClass com)
    {
        this.com = com;
    }
    @Override
    public void run() {
        waiting();
        while (true)
        {
            if(com.isAliFlag())
            {
                this.doProcess();
                com.resetFlags();
            }

        }
    }
    public void waiting()
    {
        System.out.println("Ali is waiting for an input file and an output file");
    }
    public void doProcess()
    {
        System.out.println("Ali grabbed an input file and an output file");
        System.out.println("Ali is calculating the outputs");
        System.out.println("Ali has delivered the outputs");
        waiting();
        com.setProcessFlag(true);
    }
}