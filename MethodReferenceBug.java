import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class MethodReferenceBug {

    public static void main(String[] args) {
        System.out.println(bug());
    }

    static List<List<Integer>> bug() {
        List<List<Double>> double2D = new ArrayList<>();
        return Stream.of(1, 2, 3)
                .map(i -> {
                    return double2D.stream()
                            .map(l -> l.get(i - 1))
                            .map(Double::intValue)
                            .collect(Collectors.toList());
                })
                .collect(Collectors.toList());
    }

}
