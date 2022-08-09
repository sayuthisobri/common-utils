package work.msms.utils;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@Slf4j
public class MiscUtilTests {
    @Test
    void testOr() {
        String src1 = "value";
        String fallback = "value2";
        List<String> res = Stream.of(src1, "", null)
            .map(v -> {
                log.debug("Execute src = [{}]", v);
                return MiscUtil.or(v, fallback);
            })
            .collect(Collectors.toList());
        Assertions.assertEquals(res.size(), 3, "Should return 3 record");
        Assertions.assertEquals(res.get(0), src1, "Should return non empty src value");
        Assertions.assertEquals(res.get(1), fallback, "Return fallback if src is empty");
        Assertions.assertEquals(res.get(2), fallback, "Return fallback if src is null");
    }
}
