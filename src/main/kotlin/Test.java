public class Test {

    public void sayHello(){

        final String d = "ffff";
        long var1 = System.currentTimeMillis();
        System.out.println("say hello from lee");
        long var3 = System.currentTimeMillis() - var1;
        long var4 = System.currentTimeMillis() - var1;
        System.out.println("The cost time of sayHello is" + var3);

    }
}
