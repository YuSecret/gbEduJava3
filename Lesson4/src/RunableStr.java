public class RunableStr implements Runnable {
    PrintS ps;
    String symbol;
    public RunableStr(PrintS ps, String symbol) {
        this.ps = ps;
        this.symbol = symbol;
    }
    @Override
    public void run() {
        for(int i=0; i<5; i++) {
            //System.out.println("from runable for: " +symbol + "("+i+")");
            ps.printSymbol(symbol);
        }
    }
}
