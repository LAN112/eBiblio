package cracersy.ebiblio;

public class Item {

    String optionListName;
    int optionListImage;

    public Item(String optionName,int optionImage)
    {
        this.optionListImage=optionImage;
        this.optionListName=optionName;
    }
    public String getoptionName()
    {
        return optionListName;
    }
    public int getoptionImage()
    {
        return optionListImage;
    }
}