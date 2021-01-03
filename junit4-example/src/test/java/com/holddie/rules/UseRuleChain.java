package com.holddie.rules;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.RuleChain;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

import static org.junit.Assert.assertTrue;

public class UseRuleChain {
    @Rule
    public final TestRule chain =
            RuleChain.outerRule(new LoggingRule("outer rule"))
                    .around(new LoggingRule("middle rule"))
                    .around(new LoggingRule("inner rule"));

    @Test
    public void example() {
        assertTrue(true);
    }

    private class LoggingRule implements TestRule {
        private String outRule;

        public LoggingRule(String outer_rule) {
            this.outRule = outer_rule;
        }

        @Override
        public Statement apply(Statement base, Description description) {
            return new Statement() {
                @Override
                public void evaluate() throws Throwable {
                    System.out.println(
                            description.getTestClass().getName()
                                    + '.'
                                    + description.getDisplayName());
                    base.evaluate();
                }
            };
        }
    }
}
