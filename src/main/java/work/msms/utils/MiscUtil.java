package work.msms.utils;


import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;

public interface MiscUtil {
    static String or(String src, String fallback) {
        return Optional.ofNullable(src).filter(not(String::isEmpty)).orElse(fallback);
    }

    @SuppressWarnings("unchecked")
    static <T> Predicate<T> not(Predicate<? super T> target) {
        Objects.requireNonNull(target);
        return (Predicate<T>)target.negate();
    }
}
