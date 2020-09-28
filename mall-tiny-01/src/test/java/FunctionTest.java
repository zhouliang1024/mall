import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Function实践
 *
 * @Author yuye
 * @Date 2020/9/25 11:39 上午
 */
public class FunctionTest<In, Out> {

    private Function<In, Out> processor = in -> {

        return (Out) new String("apply:" + in);

    };

    private Supplier<String> provide = () -> {

            return (String) "suppler";
    };

    public static void main(String[] args) {
        FunctionTest<String, String> functionTest = new FunctionTest();
        System.out.println(functionTest.provide.get());
    }
}
