public class NeedSleepState extends PrintMessage implements State {
    private LifeCycle lifeCycle;


    public NeedSleepState(LifeCycle lifeCycle)
    {
        this.lifeCycle = lifeCycle;
    }

    @Override
    public void CaffeWork() {
        this.lifeCycle.setLifeCycleState(lifeCycle.getChronicIlnessState());
        super.supportedMessage(this,lifeCycle.getChronicIlnessState(), new Object(){}.getClass().getEnclosingMethod().getName());
    }

    @Override
    public void PerseveranceAndHardWork() {
        super.unSupportedMessage(this, new Object(){}.getClass().getEnclosingMethod().getName());
    }

    @Override
    public void Exercise() {
        super.unSupportedMessage(this, new Object(){}.getClass().getEnclosingMethod().getName());

    }

    @Override
    public void Cheating() {
        super.unSupportedMessage(this, new Object(){}.getClass().getEnclosingMethod().getName());

    }

    @Override
    public void Sleeping() {
        this.lifeCycle.setLifeCycleState(lifeCycle.getReadyState());
        super.supportedMessage(this,lifeCycle.getReadyState(), new Object(){}.getClass().getEnclosingMethod().getName());
    }

    @Override
    public void OutTillLate() {
        super.unSupportedMessage(this, new Object(){}.getClass().getEnclosingMethod().getName());

    }

    @Override
    public void BuyingGTX1080() {
        super.unSupportedMessage(this, new Object(){}.getClass().getEnclosingMethod().getName());

    }

}
