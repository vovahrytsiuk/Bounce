public class Sync {
    private boolean isStopped = false;
    private boolean permission = true;
    private int symbolsCount;
    private int printedSymbolsCount = 0;

    public Sync(int newSymbolsCount) {
        symbolsCount = newSymbolsCount;
    }

    public boolean getIsStopped() {
        return isStopped;
    }

    public synchronized void runLogic(boolean control,char symbol) {
        while (permission != control) {
            try {
                wait();
            }
            catch (InterruptedException ex) {
            }
        }

        permission = !permission;
        System.out.print(symbol);
        printedSymbolsCount += 1;
        if (printedSymbolsCount % 100 == 0) {
            System.out.print("\n");
        }
        isStopped = printedSymbolsCount >= symbolsCount - 1;
        notifyAll();
    }
}
