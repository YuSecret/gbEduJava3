import java.util.concurrent.atomic.AtomicInteger;

public class Tunnel extends Stage {
    private boolean finish;
    public Tunnel() {
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
    }
    @Override
    public void go(Car c) {
        try {
            try {
                //System.out.println(c.getName() + " готовится к этапу(ждет): " + description);
                System.out.println(c.getName() + " начал этап: " + description);
                AtomicInteger ai = c.getAthomic();
                ai.incrementAndGet();
                Thread.sleep(length / c.getSpeed() * 1000);
                System.out.println(c.getName() + " закончил этап: " + description+" №"+ai.get());
                if (ai.get()==c.getRace().getRaceCount()) {
                    c.numFinish.incrementAndGet();
                    System.out.println(c.getName() + " Финишировал "+c.numFinish.get());

                    if (c.numFinish.get()==c.getCarsCount()) {
                        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
