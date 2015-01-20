package org.springforpro.methodInvoke;

public abstract class AbstractLookupDemoBean implements DemoBean {

	@Override
	public abstract MyHelper getMyHelper();

	@Override
	public void someOperation() {
		getMyHelper().doSomethingHelpful();
	}

}
