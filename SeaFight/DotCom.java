import java.util.ArrayList;
public class DotCom {
    public String name;

    public void setName(String name) {
        this.name = name;
    }

    private int numOfHits = 0;
    private ArrayList<String> locationCells;

    public String checkYourself(String userInput) {
        String result = "Мимо";
        int index = locationCells.indexOf(userInput);
        if (index >= 0) {
            locationCells.remove(index);
            if (locationCells.isEmpty()) {
                result = "Потопил";
                System.out.println("Вы потопили " + name + "  : ( ");
            } else {
                result = "Попал";
            }
        }
        return result;
    }
    public void setLocationCells(ArrayList<String> locs) {
        locationCells = locs;
    }
}
