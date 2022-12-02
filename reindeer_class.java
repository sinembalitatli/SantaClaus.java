public  class Reindeer implements Runnable {

    private Works works;

    public Reindeer(Works works) {
        this.works = works;
    }

    @Override
    public void run() {
        while (true) {
            works.reindeer();
        }
    }
}
