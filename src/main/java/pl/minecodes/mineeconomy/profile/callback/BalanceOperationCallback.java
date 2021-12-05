package pl.minecodes.mineeconomy.profile.callback;

public interface BalanceOperationCallback {

    void done();

    void cancel(CancelReason reason);

    enum CancelReason {
        NEGATIVE_PARAMETER,
        NEGATIVE_BALANCE,
        NO_FOUNDS
    }

}
