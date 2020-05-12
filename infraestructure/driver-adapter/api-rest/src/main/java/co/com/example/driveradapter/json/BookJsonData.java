package co.com.example.driveradapter.json;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public final class BookJsonData implements java.io.Serializable {

    private String userId;
    private String id;
    private String title;
    private String body;
}
