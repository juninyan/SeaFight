import java.util.*;
public class DotComBust {
    private int numOfGuesses = 0;
    private GameHelper helper = new GameHelper();
    ArrayList<DotCom> dotComList = new ArrayList<DotCom>();
    private void setUpGame() {
        DotCom d1 = new DotCom();
        d1.setName("Pets.com");
        dotComList.add(d1);
        DotCom d2 =  new DotCom();
        d2.setName("Hehehe.com");
        dotComList.add(d2);
        DotCom d3 =  new DotCom();
        d3.setName("Hahaha.com");
        dotComList.add(d3);

        System.out.println("Привет! Сегодня мы сыграем в игру <Потопи сайт>. Ваша цель - потопить 3 сайта: Pets.com, Hehehe.com, Hahaha.com. Попытпйтесь сделать это за минимальное количество ходов");

        for (DotCom dotComToSet : dotComList) {
            ArrayList<String> newLocation = helper.placeDotCom(3);
            dotComToSet.setLocationCells(newLocation);
        }
    }
    private void startPlaying() {
        while(!dotComList.isEmpty()) {
            String userGuess = helper.getUserInput("Сделайте ход");
            checkUserGuess(userGuess);
        }
        finishGame();
    }
    private void checkUserGuess(String userGuess) {
        numOfGuesses++;
        String result = "Мимо";
        for (DotCom dotComToTest : dotComList) {
            result = dotComToTest.checkYourself(userGuess);
            if (result.equals("Попал")) {
                break;
            }
            if (result.equals("Потопил")) {
                dotComList.remove(dotComToTest);
                break;
            }
        }
        System.out.println(result);
    }
    private void finishGame() {
        System.out.println("Все сайты пошли ко дну!");
        if(numOfGuesses <=20) {
            System.out.println("Это заняло у вас всего " + numOfGuesses + " попыток. Вы молодец!");
        } else {
            System.out.println("Это заняло у вас целых " + numOfGuesses + " попыток. Вас сложно назвать молодцом(((");
        }
    }

    public static void main (String [] args) {
        DotComBust game = new DotComBust();
        game.setUpGame();
        game.startPlaying();
    }

}
