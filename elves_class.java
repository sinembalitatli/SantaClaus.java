public  class Elves  implements Runnable{
    private Works works;
    private int id;
    public Elves(int id, Works works) {
        this.id = id;
        this.works = works;
    }
    @Override
    public void run() {
        while (true) {
            works.elves();
            Sleep.nap(4);
        }

    }
}
