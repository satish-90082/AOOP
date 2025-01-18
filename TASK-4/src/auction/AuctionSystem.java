package auction;

public class AuctionSystem {
    public static void main(String[] args) {
        // Create Auctioneer (Subject)
        Auctioneer auctioneer = new Auctioneer();

        // Create Bidders (Observers)
        Bidder bidder1 = new Bidder("Alice");
        Bidder bidder2 = new Bidder("Bob");

        // Subscribe Bidders to Auctioneer
        auctioneer.subscribe(bidder1);
        auctioneer.subscribe(bidder2);

        // Conduct Standard Auction
        Auction standardAuction = new StandardAuction(auctioneer);
        standardAuction.conductAuction();

        // Conduct Reserve Auction
        Auction reserveAuction = new ReserveAuction(auctioneer, 500.0);
        reserveAuction.conductAuction();
    }
}

