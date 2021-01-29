package runners;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import api.Tests;

@RunWith(Suite.class)
@Suite.SuiteClasses({ Tests.class })
public class ApiRunner {

}
