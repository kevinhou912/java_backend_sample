package levvel.io.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Data
public class Comment {



    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime lastModifiedDate;

    String author;
    String text;

    
    public Comment( String author, String text){
        this.author = author;
        this.text = text;
    }
}