public  class SantaClaus  implements Runnable {

    private Works works;

    public SantaClaus(Works works) {
        this.works = works;
    }

    @Override
    public void run() {
        while (true) {
            works.santaclaus();
        }
    }

}
