package utility;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {

    public static <T> T readJsonFile(String filepath, Class<T> valueType) {

    ObjectMapper objectMapper = new ObjectMapper();

    try {

        File file = new File(filepath);

        System.out.println("Reading File : " + file.getAbsolutePath());
        System.out.println("File Exists : " + file.exists());

        T obj = objectMapper.readValue(file, valueType);

        System.out.println("Object Created : " + obj);

        return obj;

    } catch (Exception e) {
        e.printStackTrace();
        throw new RuntimeException(e);
    }
    }

    public static <T> Object[][] dataDrivern(String filePath, Class<T> clazz)
            throws StreamReadException, DatabindException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<T> users = mapper.readValue(new File(filePath),
                mapper.getTypeFactory().constructCollectionType(List.class, clazz));

        Object[][] data = new Object[users.size()][1];

        for (int i = 0; i < users.size(); i++) {

            data[i][0] = users.get(i);

        }

        return data;
    }
}
