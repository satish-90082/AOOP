package auction;

public abstract class Auction {
    protected Auctioneer auctioneer;

    public Auction(Auctioneer auctioneer) {
        this.auctioneer = auctioneer;
    }

    public final void conductAuction() {
        notifyItemAvailable();
        startBidding();
        endBidding();
    }

    protected void notifyItemAvailable() {
        auctioneer.notifyObservers("An item is available for auction.");
    }

    protected abstract void startBidding();

    protected void endBidding() {
        auctioneer.notifyObservers("The auction has ended.");
    }
}
