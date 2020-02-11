//Optional - новый класс в пакете java.util, является контейнером (оберткой)
//для значений которая также может безопасно содержать null.

import java.util.Optional;

public class OptionalExample {
    public static void main(String[] args) {

        // 1 Optional.of
//        Optional<String> name = Optional.of(null);
//        System.out.println(name);

        // 2 Optional.ofNullable
//        Optional<String> name2 = Optional.ofNullable(null);
//        System.out.println(name2);

        // 3 Optional.empty для создания пустого Optional
//        Optional<String> emptyOptional = Optional.empty();
//        System.out.println(emptyOptional);

        // 4 Optional isPresent
//        Optional<String> name = Optional.of("John"); // Optional.empty()
//        if (name.isPresent()) {
//            System.out.println(name.get());
//        }

        // 5 Optional orElse
//        Optional<String> name = Optional.of("John"); //Optional.empty()
//        System.out.println(name.orElse("blank")); //output John

        // 6 Optional orElseThrow
//        Optional<String> name = Optional.of("John"); //Optional.empty()
//        String nameValue = name.orElseThrow(() -> new RuntimeException());
//        System.out.println(nameValue);

        // 7  Optional map
//        Optional<String> name = Optional.of("JOHN"); //Optional.empty()
//        System.out.println(name.map(String::toLowerCase));
    }
}
