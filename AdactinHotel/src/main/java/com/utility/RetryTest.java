package com.utility;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;
import com.base.ProjectHooks;
import com.config.ConfigurationManager;

public class RetryTest extends ProjectHooks implements IRetryAnalyzer, IAnnotationTransformer {

	int retryCount = 0;

	@Override
	public boolean retry(ITestResult result) {
		if (retryCount < ConfigurationManager.configuration().maxRetry()) {
			retryCount++;
			return true;
		}
		return false;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		annotation.setRetryAnalyzer(this.getClass());
	}

}
