public class LifeCycle {
    private State readyState;
    private State needingSleepState;
    private State chronicIlnessState;
    private State graduateState;
    private State fitState;
    private State unabeleToBecomeARodForAnAxeState;

    private State currentState;
    public LifeCycle()
    {
        readyState = new ReadyState(this);
        needingSleepState = new NeedSleepState(this);
        chronicIlnessState = new ChronicIlnessState(this);
        graduateState = new GraduateState(this);
        fitState = new FitState(this);
        unabeleToBecomeARodForAnAxeState = new UnableToBecomeState(this);

        currentState = readyState;
        System.out.println("LifeCycle system object created with Ready State.");
    }




    public void CaffeWork() {
        this.currentState.CaffeWork();
    }


    public void PerseveranceAndHardWork() {
        this.currentState.PerseveranceAndHardWork();
    }

    public void Exercise() {
        this.currentState.Exercise();
    }

    public void Cheating() {
        this.currentState.Cheating();
    }

    public void Sleeping() {
        this.currentState.Sleeping();
    }

    public void OutTillLate() {
        this.currentState.OutTillLate();
    }

    public void BuyingGTX1080() {
        this.currentState.BuyingGTX1080();
    }





    /*   GETTER AND SETTER      */
    public void setLifeCycleState(State newLifeCycleState)
    {
        this.currentState = newLifeCycleState;
    }


    public State getReadyState() {
        return readyState;
    }

    public State getNeedingSleepState() {
        return needingSleepState;
    }

    public State getChronicIlnessState() {
        return chronicIlnessState;
    }

    public State getGraduateState() {
        return graduateState;
    }

    public State getFitState() {
        return fitState;
    }

    public State getUnabeleToBecomeARodForAnAxeState() {
        return unabeleToBecomeARodForAnAxeState;
    }
}
