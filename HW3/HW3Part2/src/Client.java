import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    private GraphSystem graphSystem;
    private final String hostname = "bulutcizge";
    private Graph graph ;
    private String graphDataType="";
    private IncidenceMatrix incidenceMatrix;
    private String userName = "";
    public Client()
    {

    }

    public void connectToServer()
    {
        String ipAdress = "";
        int port = 0;
        try {
            BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("WELCOME TO BULUT CIZGE SERVICES(CLIENT PANEL)");
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

            Registry registry = LocateRegistry.getRegistry(ipAdress, port);
            graphSystem = ((GraphSystem) registry.lookup(this.hostname));
            System.out.println("Client connected to Server");


        }catch (Exception e)
        {
            System.err.println(e.getMessage());
        }



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

    public boolean authenticationProcess()
    {
        BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
        boolean authenticate = false;
        String pass = "";
        System.out.println("\n" +
                           "1) Login");
        System.out.println("2) Register");
        try {
            String selection = "";
            do
            {
                System.out.print("Please authenticate to system to make transactions.. Enter 1 or 2: ");
                selection = bufferRead.readLine();
            }while (!selection.equals("1") && !selection.equals("2"));

            System.out.print("Username:");
            userName = bufferRead.readLine();
            System.out.print("Password:");
            pass = bufferRead.readLine();
            if(selection.equals("1"))
            {
                authenticate = graphSystem.checkIsUserInfValid(new User(userName,pass));
                if(authenticate)
                    System.out.println("You have successfully logged into the system.");
                else
                    System.out.println("Wrong user informations..");
            }
            else
            {
                graphSystem.addNewAccount(new User(userName,pass));
                authenticate = true;
            }
        }catch (Exception e)
        {
            System.err.println(e.getMessage());
        }

        return authenticate;
    }

    public boolean graphFillProcess()
    {
        BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
        String selection;

        try {

            System.out.println("Selected graph type: " + graphDataType);

            while (true)
            {
                System.out.println("Choose one process:");
                System.out.println("1) Add vertex");
                System.out.println("2) Add edge");
                System.out.println("3) Exit");
                selection = bufferRead.readLine();
                if(selection.equals("1"))
                {
                    System.out.print("Enter vertex: ");
                    selection = bufferRead.readLine();
                    try {
                        graph.addVertex(GraphTypeController.getObjectWithData(graphDataType,selection));
                    }catch (Exception e)
                    {
                        return false;
                    }
                }
                else if(selection.equals("2"))
                {
                    try {
                        String source, neighbor, weight;
                        System.out.print("Enter edge source("+graphDataType + "):");
                        source = bufferRead.readLine();
                        System.out.print("Enter edge neighbor("+graphDataType + "):");
                        neighbor = bufferRead.readLine();
                        System.out.print("Enter edge weight(Double): ");
                        weight = bufferRead.readLine();

                        graph.addEdge(GraphTypeController.getObjectWithData(graphDataType,source),GraphTypeController.getObjectWithData(graphDataType,neighbor),Double.parseDouble(weight));
                        graph.addEdge(GraphTypeController.getObjectWithData(graphDataType,neighbor),GraphTypeController.getObjectWithData(graphDataType,source),Double.parseDouble(weight));
                    }catch (Exception e)
                    {
                        return false;
                    }
                }
                else
                    return true;
            }



        }catch (Exception e)
        {
            System.err.println(e.getMessage());
        }
        return false;
    }
    public boolean graphTypeSelection()
    {
        BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
        String selection;
        try {
            System.out.println("What data type do you want to fill graph? ");
            System.out.println("1) Integer");
            System.out.println("2) Double");
            System.out.println("3) Character");
            System.out.println("4) String");

            selection = bufferRead.readLine();
            if(selection.equals("1"))
            {
                graph = new GraphImplementation<Integer>();
                incidenceMatrix = new IncidenceMatrix<Integer>();
                graphDataType = "Integer";
                return true;
            }
            else if(selection.equals("2"))
            {
                graph = new GraphImplementation<Double>();
                incidenceMatrix = new IncidenceMatrix<Double>();
                graphDataType = "Double";
                return true;
            }else if(selection.equals("3"))
            {
                graph = new GraphImplementation<Character>();
                incidenceMatrix = new IncidenceMatrix<Character>();
                graphDataType = "Character";
                return true;
            }else if(selection.equals("4"))
            {
                graph = new GraphImplementation<String>();
                incidenceMatrix = new IncidenceMatrix<String>();
                graphDataType = "String";
                return true;
            }
            else
            {
                System.err.println("Wrong selection");
                return false;
            }

        }catch (Exception e)
        {
            System.err.println(e.getMessage());
        }
        return false;
    }
    public boolean graphProcess()
    {
        BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
        String selection;
        try {
            System.out.println("We are two services;");
            System.out.println("1)Minimum spanning tree");
            System.out.println("2)Incidence Matrix");
            System.out.print("Selection:");
            selection = bufferRead.readLine();

            if(selection.equals("1"))
            {
                if(graphSystem.creditProcess("incidence",userName))
                {
                    System.out.println("\n" + graphSystem.giveMinimumSpanningTree(graph));
                    return true;
                }
                else
                    System.out.println("->>> Insufficient credit amount\n");

            }else if(selection.equals("2"))
            {
                if(graphSystem.creditProcess("mst",userName))
                {
                    System.out.println("\n" + graphSystem.giveIncidenceMatrix(incidenceMatrix,graph));
                    return true;
                }
                else
                    System.out.println("->>> Insufficient credit amount\n");

            }

        }catch (Exception e)
        {
            System.err.println(e.getMessage());
        }
        return false;

    }


    public void systemDriver()
    {
        BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
        String selection = "";
        connectToServer();
        while (!authenticationProcess());

        Boolean isTypeSelected = false;
        while (true)
        {
            try {
                System.out.println("\n\n1) Graph Type Selection");
                System.out.println("2) Fill Graph");
                System.out.println("3) Graph Services");
                System.out.println("4) Exit");
                System.out.print("Selection:");
                selection = bufferRead.readLine();

                if(!isTypeSelected && !selection.equals("1"))
                    System.out.println("\nFirstly you have to select graph type..");
                else
                    if(selection.equals("1"))
                    {
                        if(!graphTypeSelection())
                        {
                            System.out.println("An error occurred when graph type selection");
                            isTypeSelected = false;
                        }
                        else
                            isTypeSelected = true;
                    }
                    else if(selection.equals("2"))
                    {
                        if(!graphFillProcess())
                            System.out.println("An error occurred when graph filling");
                    }
                    else if(selection.equals("3"))
                    {
                        if(!graphProcess())
                            System.out.println();
                    }

                if(selection.equals("4"))
                {
                    System.out.println("Exiting the system");
                    break;
                }
            }catch (Exception e)
            {

            }

        }

    }
    public static void main(String[] args)
    {
        Client client = new Client();
        client.systemDriver();
    }
}
