package lesson26;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Lazy;

@Getter
@Setter
//@RequiredArgsConstructor
public class BeanA {

    private BeanB bean;

    public void setBean(@Lazy BeanB bean) {
        this.bean = bean;
    }

    public void print() {
        System.out.println(bean);
    }
}
