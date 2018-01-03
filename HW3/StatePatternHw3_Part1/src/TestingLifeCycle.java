public class TestingLifeCycle {
    public static void main(String[] args)
    {
        LifeCycle lifeCycle = new LifeCycle();
        lifeCycle.OutTillLate();
        lifeCycle.Sleeping();
        lifeCycle.Exercise();
        lifeCycle.PerseveranceAndHardWork();
        lifeCycle.CaffeWork();

        System.out.println();
        LifeCycle lifeCycle1 = new LifeCycle();
        lifeCycle1.BuyingGTX1080();
        lifeCycle1.Sleeping();

        System.out.println();
        LifeCycle lifeCycle2 = new LifeCycle();
        lifeCycle2.Cheating();
        lifeCycle2.Exercise();

        System.out.println();
        LifeCycle lifeCycle3 = new LifeCycle();
        lifeCycle3.OutTillLate();
        lifeCycle3.CaffeWork();
        lifeCycle3.BuyingGTX1080();


    }
}
