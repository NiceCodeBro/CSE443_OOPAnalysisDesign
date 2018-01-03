public class GraphTypeController {
    public static Object getObjectWithData(String dataType, String data)
    {
        if(dataType.equals("String"))
        {
            return new String(data);
        }
        else if(dataType.equals("Integer"))
        {
            return new Integer(Integer.parseInt(data));
        }
        else if(dataType.equals("Double"))
        {
            return new Double(Double.parseDouble(data));
        }
        else
            return new Character(data.charAt(0));

    }


}
