class Driver {
    public static void main(String[] args) {

        Works wk = new Works();

        Thread S = new Thread(new SantaClaus(wk));
        Thread E = new Thread(new Elves(wk));
        Thread R = new Thread(new Reindeer(wk));
        S.start();
        E.start();
        R.start();


}
}