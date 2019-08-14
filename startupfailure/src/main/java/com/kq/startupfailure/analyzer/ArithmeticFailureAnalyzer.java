package com.kq.startupfailure.analyzer;

import org.springframework.boot.diagnostics.AbstractFailureAnalyzer;
import org.springframework.boot.diagnostics.FailureAnalysis;

/**
 * ArithmeticFailureAnalyzer
 *
 * @author kq
 * @date 2019-08-13
 */
public class ArithmeticFailureAnalyzer extends AbstractFailureAnalyzer<ArithmeticException> {
    @Override
    protected FailureAnalysis analyze(Throwable rootFailure, ArithmeticException cause) {
        return new FailureAnalysis(cause.getMessage(), "check your logic.", cause);
    }
}
