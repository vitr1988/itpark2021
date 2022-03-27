package lesson32.event;

import lombok.Getter;
import lombok.ToString;
import org.springframework.context.ApplicationEvent;

@ToString
public class PrintEvent extends ApplicationEvent {

    @Getter
    private final String value;

    public PrintEvent(Object source, String value) {
        super(source);
        this.value = value;
    }

}
