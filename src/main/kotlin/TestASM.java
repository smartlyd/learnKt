public class TestASM {
    public void sayHello() {
        System.out.println("say hello from lee");
        try {
            Thread.sleep(2 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
