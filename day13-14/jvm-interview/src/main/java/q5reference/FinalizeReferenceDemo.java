package q5reference;

import java.io.IOException;

//-verbose:gc
public class FinalizeReferenceDemo {
    public static void main(String[] args) throws IOException {
        Demo demo = new Demo();
        demo = null;

        System.gc();

        System.in.read();
    }
}


class Demo{
    @Override
    protected void finalize() throws Throwable {
        System.out.println("触发finalize");
        super.finalize();
    }
}