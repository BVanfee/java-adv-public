package collectionsclass;

import java.util.*;

public class Lottery {
    /*Implementálj egy lottó gépet ahol megadható a lottó típusa (ötös, hatos, stb.)
     és az is, hogy hány számból válasszon (golyók száma). Írj egy Lottery osztályt,
      amely létrehozza a golyókat (List<Integer> értékek), összekeveri, majd megcsinálja
       a “húzást”, azaz kiválaszt a lottó típusának megfelelő számú golyót, majd
       a kihúzott számokat növekvő sorba rendezi és úgy adja vissza!
A húzást a selectWinningNumbers(int lotteryType, int ballCount) metódus végzi,
amely egy List<Integer>-ben adja vissza a nyerő számokat. (A visszaadott számok
pozitív egész számok, és nem lehetnek nagyobbak, mint amennyi golyó van.
A golyók számozása egytől kezdődik. Ugyanaz a szám nem szerepelhet kétszer,
sem azok között, ahonnan húzunk, sem a visszaadottak között.)

Ha a selectWinningNumbers(int lotteryType, int ballCount)
 metódust rossz paraméterekkel hívták meg (több vagy ugyanannyi számot
  kellene kihúzni, mint amennyit generál), a metódus dobjon egy
  IllegalArgumentException kivételt!*/


    private Random random = new Random();

    public Lottery() {
    }

    public List<Integer> selectWinningNumbers(int lotteryType, int ballCount) {
        Set<Integer> numbers = new TreeSet<>();
        if (ballCount <= lotteryType) {
            throw new IllegalArgumentException("There must be more balls than the winning numbers!");
        }
        while (numbers.size() != lotteryType) {
            int number = random.nextInt(ballCount) + 1;
            numbers.add(number);
        }
        return new ArrayList<>(numbers);
    }
}
