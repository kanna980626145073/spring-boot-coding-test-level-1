package com.codejam.demo.constants;

import lombok.experimental.UtilityClass;

@UtilityClass
public class PathConstants {

    public final String RESOURCE_PATH = "api/v" + PathConstants.RESOURCE_VERSION;

    public final String RESOURCE_VERSION = "1";

    public final String TODO_PATH = "/todo/{id}";

    public final String DEMO_PATH = "/demo";

    public final String UNIT_TEST_PATH = "/unit-test";

    public final String PERSONS_PATH = "/persons";

    public final String RANDOM_PERSON_PATH = "/random-person";

    public final String REVENUES_PATH = "/revenues";

    public final String SCHEDULES_PATH = "/schedules";



}
