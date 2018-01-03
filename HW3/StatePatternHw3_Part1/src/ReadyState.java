public class ReadyState extends PrintMessage implements State  {
    private LifeCycle lifeCycle;

    public ReadyState(LifeCycle lifeCycle)
    {
        this.lifeCycle = lifeCycle;
    }
    @Override
    public void CaffeWork() {
        super.unSupportedMessage(this, new Object(){}.getClass().getEnclosingMethod().getName());
    }

    @Override
    public void PerseveranceAndHardWork() {
        lifeCycle.setLifeCycleState(lifeCycle.getGraduateState());
        super.supportedMessage(this,lifeCycle.getGraduateState(), new Object(){}.getClass().getEnclosingMethod().getName());
    }

    @Override
    public void Exercise() {
        lifeCycle.setLifeCycleState(lifeCycle.getFitState());
        super.supportedMessage(this,lifeCycle.getFitState(), new Object(){}.getClass().getEnclosingMethod().getName());
    }

    @Override
    public void Cheating() {
        lifeCycle.setLifeCycleState(lifeCycle.getUnabeleToBecomeARodForAnAxeState());
        super.supportedMessage(this,lifeCycle.getUnabeleToBecomeARodForAnAxeState(), new Object(){}.getClass().getEnclosingMethod().getName());
    }

    @Override
    public void Sleeping() {
        super.unSupportedMessage(this, new Object(){}.getClass().getEnclosingMethod().getName());
    }

    @Override
    public void OutTillLate() {
        lifeCycle.setLifeCycleState(lifeCycle.getNeedingSleepState());
        super.supportedMessage(this,lifeCycle.getNeedingSleepState(), new Object(){}.getClass().getEnclosingMethod().getName());
    }

    @Override
    public void BuyingGTX1080() {
        lifeCycle.setLifeCycleState(lifeCycle.getUnabeleToBecomeARodForAnAxeState());
        super.supportedMessage(this,lifeCycle.getUnabeleToBecomeARodForAnAxeState(), new Object(){}.getClass().getEnclosingMethod().getName());
    }

}
