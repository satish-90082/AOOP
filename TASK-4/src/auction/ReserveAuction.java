package auction;

public class ReserveAuction extends Auction {
    private double reservePrice;

    public ReserveAuction(Auctioneer auctioneer, double reservePrice) {
        super(auctioneer);
        this.reservePrice = reservePrice;
    }

    @Override
    protected void startBidding() {
        auctioneer.notifyObservers("Bidding has started for the reserve auction with a reserve price of " + reservePrice);
    }
}