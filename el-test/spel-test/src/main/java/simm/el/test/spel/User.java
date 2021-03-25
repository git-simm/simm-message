package simm.el.test.spel;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户实体
 * @author miscr
 */
@Data
@Builder
public class User {
   String name;
   Integer age;
   List<Interest> interestList;
}
