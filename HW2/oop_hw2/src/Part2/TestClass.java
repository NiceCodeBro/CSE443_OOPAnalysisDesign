package Part2;

public class TestClass {
    public static void main(String[] arg)
    {
        CominicationClass cc = new CominicationClass();
        Metin metin = new Metin(cc);
        Ali ali = new Ali(cc);
        Feyyaz feyyaz = new Feyyaz(cc);

        Kezban kezban = new Kezban(cc);

        Thread threadMetin = new Thread(metin);
        Thread threadAli = new Thread(ali);
        Thread threadFeyyaz = new Thread(feyyaz);

        Thread threadKezban = new Thread(kezban);


        threadMetin.start();
        threadAli.start();
        threadFeyyaz.start();

        threadKezban.start();


    }
}
