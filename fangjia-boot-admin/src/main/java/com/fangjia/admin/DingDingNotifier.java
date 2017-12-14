package com.fangjia.admin;

import com.fangjia.common.util.DingDingMessageUtil;
import de.codecentric.boot.admin.event.ClientApplicationEvent;
import de.codecentric.boot.admin.notify.AbstractStatusChangeNotifier;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;


/**
 * 自定义钉钉发消息
 *
 * @author yinjihuan
 *
 **/
public class DingDingNotifier extends AbstractStatusChangeNotifier {
    private Expression text;
    private final SpelExpressionParser parser = new SpelExpressionParser();

    public DingDingNotifier() {
        this.text = this.parser.parseExpression("#{application.name} (#{application.id})\nstatus changed from #{from.status} to #{to.status}\n\n#{application.healthUrl}", ParserContext.TEMPLATE_EXPRESSION);
    }

    @Override
    protected void doNotify(ClientApplicationEvent event) throws Exception {
        EvaluationContext context = new StandardEvaluationContext(event);
        String text = this.text.getValue(context, String.class);
        DingDingMessageUtil.sendTextMessage(text);
    }

    public void setText(String text) {
        this.text = this.parser.parseExpression(text, ParserContext.TEMPLATE_EXPRESSION);
    }

    public String getText() {
        return this.text.getExpressionString();
    }
}
