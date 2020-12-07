public class Card
{
    private String value;
    private String suit;

    public Card(String valueAssigned, String suitAssigned)
    {
        value = valueAssigned;
        suit = suitAssigned;
    }

    public String valueIs()
    {
        return value;
    }

    public String suitIs()
    {
        return suit;
    }
}
