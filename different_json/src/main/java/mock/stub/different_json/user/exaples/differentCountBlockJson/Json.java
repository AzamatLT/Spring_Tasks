package mock.stub.different_json.user.exaples.differentCountBlockJson;

import org.apache.kafka.common.protocol.types.Field;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Json {

    public final static String JSONDIFFERENTCOUNTBLOCK = """
            {
                "inn": "%s",
                "trace": "%s",
                "arreaTrace": [
                %s
                ]
            }""";
    public static String jsonDifferentCountBlock(String inn, String trace, String jsonTrace) {
        var values = IntStream.range(1,5).mapToObj(value ->
                jsonTrace
        ).collect(Collectors.joining(","));
        return JSONDIFFERENTCOUNTBLOCK.formatted(inn,trace,values);
    }


//    public static String jsonDifferentCountBlock(String inn, String trace) {
//        var values = IntStream.range(1,5).mapToObj(value ->
//                """
//                {
//                    "message": "Возвращает этот блок рандомное кол-во раз",
// не смог передать переменую в этот блок поэтому написал код выше и задаю json в контроллере
//                    }
//                    """
//                ).collect(Collectors.joining(","));
//        return JSONDIFFERENTCOUNTBLOCK.formatted(inn,trace,values);
//    }
}
