public class PrintMessage {
    public void supportedMessage(State fromState, State toState, String methodName) {
        System.out.println("State changed. (from " + fromState.getClass().getName() + " to "
                + toState.getClass().getName() +  " by " +  methodName + " method.)");
    }

    public void unSupportedMessage(State fromState, String methodName) {
        System.out.println("Unsupported state call. (from " + fromState.getClass().getName() +
                " by " +  methodName + " method.)");
    }
}
