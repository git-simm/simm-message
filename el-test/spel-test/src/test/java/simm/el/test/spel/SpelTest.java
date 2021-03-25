package simm.el.test.spel;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * 表达式测试
 */
//@ExtendWith(MockitoExtension.class)
public class SpelTest {
    public static User user = null;
    @BeforeEach
    public void setup(){
        List<Interest> interestList = new ArrayList<>();
        interestList.add(Interest.builder().desc("音乐").build());
        interestList.add(Interest.builder().desc("美术").build());
        user = User.builder().name("张三").age(20).interestList(interestList).build();
    }
    @Test
    public void rootTest(){
        //user为root对象
        ExpressionParser parser = new SpelExpressionParser();
        EvaluationContext context = new StandardEvaluationContext(user);
        System.out.println(parser.parseExpression("#root").getValue(context, user.getClass()));
        parser.parseExpression("#root.name").setValue(context, "路人甲java");
        System.out.println(parser.parseExpression("#root").getValue(context, user.getClass()));
        Assertions.assertTrue(true);
    }

    @Test
    public void contextTest(){
        //user为root对象
        ExpressionParser parser = new SpelExpressionParser();
        EvaluationContext context = new StandardEvaluationContext();
        context.setVariable("user",user);
        System.out.println(parser.parseExpression("#user").getValue(context));
        parser.parseExpression("#user.name").setValue(context, "路人乙java");
        System.out.println(parser.parseExpression("#user").getValue(context));
        System.out.println(parser.parseExpression("#user.interestList[0].desc").getValue(context));
        Assertions.assertTrue(true);
    }
}
