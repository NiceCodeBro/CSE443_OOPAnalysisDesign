import java.io.*;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Server implements  GraphSystem{
    private List<User> userList;
    private final String hostname = "bulutcizge";

    public Server()
    {
        userList = new ArrayList<>();
        loadUsers();
    }

    @Override
    public Graph getGraph() throws RemoteException{
        return null;
    }

    public void startServer()
    {
        String ipAdress = "";
        int port = 0;
        try {
            BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("WELCOME TO BULUT CIZGE SERVICES (SERVER PANEL)");
            do {

                System.out.println("Please enter valid Ip Adress ");
                ipAdress = bufferRead.readLine();
            }while (!isIPv4Address(ipAdress));



            try {
                System.out.println("Please enter valid port number");
                port = Integer.parseInt(bufferRead.readLine());
            }catch (Exception e)
            {

            }

            System.setProperty("java.rmi.server.hostname", ipAdress);
            GraphSystem stub = ((GraphSystem)   UnicastRemoteObject.exportObject(this, port));
            Registry reg = LocateRegistry.createRegistry(port);
            reg.rebind(hostname,stub);

        }catch (Exception e)
        {
            System.err.println(e.getMessage());
        }
    }
    public void loadUsers()
    {
        try {
            ObjectInputStream inputStream  = new ObjectInputStream(new FileInputStream("Users.bin"));
            while (true) {
                try {
                    userList.add(((User) inputStream.readObject()));
                } catch (EOFException ex) {
                    break;
                } catch (ClassNotFoundException e) {
                    System.err.println(e.getMessage());
                }
            }
            inputStream.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public boolean checkIsUserInfValid(User user)
    {
        if(userList.contains(user))
            return true;
        return false;
    }
    public void saveAllUsers()
    {
        try {
            ObjectOutputStream out = null;
            out = new ObjectOutputStream(new FileOutputStream("Users.bin"));
            for(User user: userList)
            {
                out.writeObject(user);
            }
            out.close();
        }catch (Exception e)
        {
            System.err.println( e.getMessage());
        }
    }

    public String giveMinimumSpanningTree(Graph graph)
    {
        Date callingTime = Calendar.getInstance().getTime();
        long startTime = System.nanoTime();
        System.out.println("Minimum Spannig Tree method called. Time" + Calendar.getInstance().getTime());
        String mst = "minimum spanning tree";
        long endTime = System.nanoTime();

        System.out.println(callingTime + " Incidence Matrix method called. Execution time(milisecond): " +(float)(endTime - startTime)/1000000);

        return mst;
    }
    public String giveIncidenceMatrix(IncidenceMatrix incidenceMatrix,Graph graph)
    {
        Date callingTime = Calendar.getInstance().getTime();
        long startTime = System.nanoTime();
        String incidence = incidenceMatrix.giveIncidenceMatrix(graph);
        long endTime = System.nanoTime();

        System.out.println(callingTime + " Incidence Matrix method called. Execution time(milisecond): " + (float)(endTime - startTime)/1000000);


        return incidence;
    }
    public boolean creditProcess(String processType, String username)
    {
        User user = getUser(username);
        if(processType.equals("incidence"))
        {
            if(user.getCredit()>20)
            {
                user.setCredit(user.getCredit()-20);
                return true;
            }
            return false;
        }
        else if(processType.equals("mst"))
        {
            if(user.getCredit()>40)
            {
                user.setCredit(user.getCredit()-40);
                return true;
            }
            return false;
        }
        return false;
    }
    private User getUser(String username)
    {
        for(User user:userList)
        {
            if(user.getUserName().equals(username))
                return user;
        }
        return null;
    }
    public void addNewAccount(User usr)
    {
        if(!userList.contains(usr))
            userList.add(usr);
        saveAllUsers();
        System.out.println("Registered new user named "+ usr.getUserName());
    }
    public List<User> getUserList() {
        return userList;
    }


    //source https://stackoverflow.com/questions/5667371/validate-ipv4-address-in-java
    public static Boolean isIPv4Address(String address) {
        if (address.isEmpty()) {
            return false;
        }
        try {
            Object res = InetAddress.getByName(address);
            return res instanceof Inet4Address || res instanceof Inet6Address;
        } catch (final UnknownHostException ex) {
            return false;
        }
    }

    public static void main(String[] args)
    {
        Server server = new Server();
        server.startServer();
    }
}

