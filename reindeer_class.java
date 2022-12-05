public  class Reindeer implements Runnable {

    private Works works;
    private int id;

    public Reindeer(int id, Works works) {
        this.id = id;
        this.works = works;
    }

    @Override
    public void run() {
        while (true) {
            works.reindeer();
            Sleep.nap(4);
        }
    }
}
