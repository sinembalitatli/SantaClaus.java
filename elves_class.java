

public  class Elves  implements Runnable{


    private Works works;

    public Elves(Works works) {
        this.works = works;
    }
    @Override
    public void run() {
        while (true) {
            works.elves();
        }

    }
}
