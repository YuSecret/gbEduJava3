import java.sql.SQLOutput;

public class PrintS {
    private static volatile String res = "";
    private final String  template = "ABC";
    private String lastSym;
    public static void main(String[] args) throws InterruptedException {

        //1. Создать три потока, каждый из которых выводит определенную букву (A, B и C)
        // 5 раз (порядок – ABСABСABС). Используйте wait/notify/notifyAll.
        PrintS ps = new PrintS();
        RunableStr rA = new RunableStr(ps, "A");
        RunableStr rB = new RunableStr(ps, "B");
        RunableStr rC = new RunableStr(ps, "C");
        Thread tA = new Thread(rA);
        Thread tB = new Thread(rB);
        Thread tC = new Thread(rC);
        tA.start();
        tB.start();
        tC.start();
        tA.join();
        tB.join();
        tC.join();
        System.out.println("Result="+res);
    }
    public synchronized void printSymbol(String str)  {
        lastSym = getLastSymb();
      //  System.out.println("printSymbol res = "+res+" last = "+lastSym + " input = " + str);

        boolean needWait = false;
        if (str.equals("A") && (!lastSym.equals("C") && res!="")) {
            needWait = true;
         }
        if (str.equals("B") && !lastSym.equals("A")) {
            needWait = true;
        }
        if (str.equals("C") && !lastSym.equals("B")) {
            needWait = true;
        }
       // System.out.println("needwait =" +needWait);
        while (needWait) {
            lastSym = getLastSymb();
         //   System.out.println(str+" while res = " + res + " lastSym="+lastSym);
            needWait = false;
            if (str.equals("A") && (!lastSym.equals("C"))) {
                needWait = true;
            }
            if (str.equals("B") && !lastSym.equals("A")) {
                needWait = true;
            }
            if (str.equals("C") && !lastSym.equals("B")) {
                needWait = true;
            }
            try {
                //System.out.println(str+" wait... res = "+res +"needWait:"+needWait);
               if (needWait) wait();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        res = res + str;
        //System.out.println("Record to result= "+res);
       // if (res.equals(template)) res = "";
        notifyAll();

    }
    private String getLastSymb() {
        return res.equals("") ? "" : res.substring(res.length()-1, res.length());
    }
}
