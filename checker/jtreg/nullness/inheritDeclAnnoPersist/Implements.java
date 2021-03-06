/*
 * @test
 * @summary Test that inherited declaration annotations are stored in bytecode.
 *
 * @compile -source 7 -target 7 ../PersistUtil.java Driver.java ReferenceInfoUtil.java Implements.java Interface.java
 * @run main Driver Implements
 */

import static com.sun.tools.classfile.TypeAnnotation.TargetType.*;

public class Implements {

    @ADescriptions({
        @ADescription(annotation = "org/checkerframework/checker/nullness/qual/EnsuresNonNull")
    })
    public String m1() {
        StringBuilder sb = new StringBuilder();
        sb.append("Object f;\n");
        sb.append("public Test() {f = new Object();}\n");
        sb.append("@Override public void setf() {f = new Object();}\n");
        sb.append("@Override public void setg() {}\n");
        return TestWrapper.wrap(sb.toString());
    }

}

class TestWrapper {
    public static String wrap(String method) {
        StringBuilder sb = new StringBuilder();
        sb.append("class Test implements Interface {\n");
        sb.append(method);
        sb.append("}");
        return sb.toString();
    }
}
