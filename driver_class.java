
class Driver {
    public static void main(String[] args) {

        Works wk = new Works();
        Thread Santa = new Thread(new SantaClaus(wk));
        Thread[] Elves = new Thread[9];
        Thread[] Reindeer = new Thread[9];

        for (int i = 0; i < 9; i++) {
            Elves[i] = new Thread(new Elves(i, wk));
            Reindeer[i] = new Thread(new Reindeer(i, wk)); //Yeni
        }

        for (int i = 0; i < 9; i++) {
            Elves[i].start();
            Reindeer[i].start();
        }
        /*for (int i = 0; i < 15; i++) {
            Reindeer[i] = new Thread(new Reindeer(i, wk));
        }

        for (int i = 0; i < 15; i++) {
            Reindeer[i].start();
        }
        */

        Santa.start();

    }
}
