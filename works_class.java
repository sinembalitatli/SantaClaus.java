import java.util.concurrent.Semaphore;

public class Works{

    public  int elfCount;
    public  int reindeerCount;
    public  Semaphore santaSem;
    public  Semaphore reindeerSem;
    public  Semaphore elfSem;
    public Semaphore mutex;
    public   Semaphore elfMutex;

    public Works(){
        this.elfCount = 0;
        this. reindeerCount = 0;

        this. santaSem = new Semaphore(0);
        this. reindeerSem = new Semaphore(0);
        this.elfSem = new Semaphore(0);

        this.mutex = new Semaphore(1);
        this.  elfMutex = new Semaphore(1);

    }

    public void prepareSleigh(){
        System.out.println("Santa Claus: preparing sleigh");
    }
    public  void helpElves(){
        System.out.println("Santa Claus: helping elves");
    }

    public void getHitched(){
        System.out.println("This is reindeer "+reindeerCount);

    }

    public  void getHelp(){
        System.out.println("This is elve "+ elfCount);
    }
    public void santaclaus(){
        try {
            santaSem.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            mutex.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        if (reindeerCount>= 9) {
            prepareSleigh();
            for (int i=0;i<9;i++) {
                reindeerSem.release();
                reindeerCount--;
                Sleep.nap(2);
            }
        }else if (elfCount == 3) {
            helpElves();
        }
        mutex.release();

    }
    public void elves(){
        try {
            elfMutex.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            mutex.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        elfCount++;

        if (elfCount == 3) {
            santaSem.release();
        } else {
            elfMutex.release();

        }
        mutex.release();
        getHelp();    
        Sleep.nap(2);
        try {
            mutex.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        elfCount--;

        if (elfCount == 0) {
            elfMutex.release();

        }
        mutex.release();
        System.out.println("Elve "+ elfCount+ " at work");

    }

    public void reindeer(){
        try {
            mutex.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        reindeerCount++;
        System.out.println("Reindeer "+ reindeerCount+" getting hitched *");
        if (reindeerCount == 9) {
            santaSem.release();
        }
        mutex.release();
        getHitched();

        try {
            reindeerSem.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Sleep.nap(2);
    }




















}
