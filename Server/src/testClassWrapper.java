import java.io.Serializable;
public class testClassWrapper implements Serializable{
    boolean valid = false;
    testClass test;
    testClassWrapper(boolean _valid, testClass _test){
        test = _test;
        valid = _valid;
    }
}
