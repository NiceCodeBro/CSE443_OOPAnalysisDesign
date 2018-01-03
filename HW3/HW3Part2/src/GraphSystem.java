import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface GraphSystem extends Remote {
    public String giveIncidenceMatrix(IncidenceMatrix incidenceMatrix,Graph graph) throws RemoteException;
    public void loadUsers() throws RemoteException;
    public List<User> getUserList() throws RemoteException;
    public void addNewAccount(User usr) throws RemoteException;
    public boolean checkIsUserInfValid(User user) throws RemoteException;
    public Graph getGraph() throws RemoteException;
    public boolean creditProcess(String processType, String username) throws RemoteException;
    public String giveMinimumSpanningTree(Graph graph) throws RemoteException;

}
