package auction;


public class StandardAuction extends Auction {
    public StandardAuction(Auctioneer auctioneer) {
        super(auctioneer);
    }

    @Override
    protected void startBidding() {
        auctioneer.notifyObservers("Bidding has started for the standard auction.");
    }
}