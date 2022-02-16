public class SyncPrint implements Runnable{
    private final char symbol;
    private final boolean control;
    private final Sync sync;

    public SyncPrint(char newSymbol, boolean runControl, Sync newSync) {
        symbol = newSymbol;
        control = runControl;
        sync = newSync;
    }
    @Override
    public void run() {
        while (sync.getIsStopped() == false) {
            sync.runLogic(control, symbol);
        }
    }
}
