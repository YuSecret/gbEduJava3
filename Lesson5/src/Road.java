import java.util.concurrent.atomic.AtomicInteger;

public class Road extends Stage {
    private boolean finish;
    public Road(int length) {
        this.length = length;
        this.description = "Дорога " + length + " метров";

    }
    @Override
    public void go(Car c) {
        try {
            System.out.println(c.getName() + " начал этап: " + description);
            AtomicInteger ai = c.getAthomic();
            ai.incrementAndGet();
            Thread.sleep(length / c.getSpeed() * 1000);

            System.out.println(c.getName() + " закончил этап: " + description+" №"+ai.get());
            if (ai.get()==c.getRace().getRaceCount()) {
                System.out.println(c.getName() + " Финишировал");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}