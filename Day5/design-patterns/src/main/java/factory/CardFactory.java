package factory;

public class CardFactory extends Factory{

    public static CardProvider getCard(String bank) {
        if(bank.equals("pqr")) return new PqrCard();
        if(bank.equals("abc")) return new AbcCard();
        if(bank.equals("xyz")) return new XyzCard();
        throw new InvalidBankException("ATM Card Facility is not provided by "+bank);
    }

    public static Factory newInstance() {
        return new CardFactory();
    }
}
