$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/java/features/addMoviesAPI.feature");
formatter.feature({
  "line": 1,
  "name": "Title of your feature",
  "description": "I want to use this template for my feature file",
  "id": "title-of-your-feature",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 5,
  "name": "Add a Customer",
  "description": "",
  "id": "title-of-your-feature;add-a-customer",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 4,
      "name": "@tag1"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "User want to add a new movie",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "User adds movie with \"\u003cTitle\u003e\", \"\u003cDirector\u003e\",\"\u003cDescription\u003e\",\"\u003cCategories\u003e\",\"\u003cImageURL\u003e\",\"\u003cRating\u003e\"",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "Movie is added successfully",
  "keyword": "Then "
});
formatter.examples({
  "line": 10,
  "name": "",
  "description": "",
  "id": "title-of-your-feature;add-a-customer;",
  "rows": [
    {
      "cells": [
        "Title",
        "Director",
        "Description",
        "Categories",
        "ImageURL",
        "Rating"
      ],
      "line": 11,
      "id": "title-of-your-feature;add-a-customer;;1"
    },
    {
      "cells": [
        "Chhichhore",
        "Nitesh Talwar",
        "Great Comedy Movie",
        "Comedy",
        "https://akm-img-a-in.tosshub.com/indiatoday/images/story/201909/chhichhore-770x433.jpeg?FwxPwJC2sqo.UXyQWZ8DZGI9iaj1GjUP",
        "4"
      ],
      "line": 12,
      "id": "title-of-your-feature;add-a-customer;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 1617320,
  "status": "passed"
});
formatter.scenario({
  "line": 12,
  "name": "Add a Customer",
  "description": "",
  "id": "title-of-your-feature;add-a-customer;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 4,
      "name": "@tag1"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "User want to add a new movie",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "User adds movie with \"Chhichhore\", \"Nitesh Talwar\",\"Great Comedy Movie\",\"Comedy\",\"https://akm-img-a-in.tosshub.com/indiatoday/images/story/201909/chhichhore-770x433.jpeg?FwxPwJC2sqo.UXyQWZ8DZGI9iaj1GjUP\",\"4\"",
  "matchedColumns": [
    0,
    1,
    2,
    3,
    4,
    5
  ],
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "Movie is added successfully",
  "keyword": "Then "
});
formatter.match({
  "location": "addMoviesAPI.user_want_to_add_a_new_movie()"
});
formatter.result({
  "duration": 62517162,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Chhichhore",
      "offset": 22
    },
    {
      "val": "Nitesh Talwar",
      "offset": 36
    },
    {
      "val": "Great Comedy Movie",
      "offset": 52
    },
    {
      "val": "Comedy",
      "offset": 73
    },
    {
      "val": "https://akm-img-a-in.tosshub.com/indiatoday/images/story/201909/chhichhore-770x433.jpeg?FwxPwJC2sqo.UXyQWZ8DZGI9iaj1GjUP",
      "offset": 82
    },
    {
      "val": "4",
      "offset": 205
    }
  ],
  "location": "addMoviesAPI.user_adds_movie_with(String,String,String,String,String,String)"
});
formatter.result({
  "duration": 2120294684,
  "status": "passed"
});
formatter.match({
  "location": "addMoviesAPI.movie_is_added_successfully()"
});
formatter.result({
  "duration": 16411,
  "status": "passed"
});
formatter.after({
  "duration": 260631007,
  "error_message": "java.lang.NullPointerException\r\n\tat stepDefinition.Hooks.loginOut(Hooks.java:30)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(Unknown Source)\r\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(Unknown Source)\r\n\tat java.lang.reflect.Method.invoke(Unknown Source)\r\n\tat cucumber.runtime.Utils$1.call(Utils.java:40)\r\n\tat cucumber.runtime.Timeout.timeout(Timeout.java:16)\r\n\tat cucumber.runtime.Utils.invoke(Utils.java:34)\r\n\tat cucumber.runtime.java.JavaHookDefinition.execute(JavaHookDefinition.java:60)\r\n\tat cucumber.runtime.Runtime.runHookIfTagsMatch(Runtime.java:224)\r\n\tat cucumber.runtime.Runtime.runHooks(Runtime.java:212)\r\n\tat cucumber.runtime.Runtime.runAfterHooks(Runtime.java:206)\r\n\tat cucumber.runtime.model.CucumberScenario.run(CucumberScenario.java:46)\r\n\tat cucumber.runtime.model.CucumberScenarioOutline.run(CucumberScenarioOutline.java:46)\r\n\tat cucumber.runtime.model.CucumberFeature.run(CucumberFeature.java:165)\r\n\tat cucumber.api.testng.TestNGCucumberRunner.runCucumber(TestNGCucumberRunner.java:63)\r\n\tat testRunner.addMoviesAPI.Login(addMoviesAPI.java:39)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(Unknown Source)\r\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(Unknown Source)\r\n\tat java.lang.reflect.Method.invoke(Unknown Source)\r\n\tat org.testng.internal.MethodInvocationHelper.invokeMethod(MethodInvocationHelper.java:85)\r\n\tat org.testng.internal.Invoker.invokeMethod(Invoker.java:639)\r\n\tat org.testng.internal.Invoker.invokeTestMethod(Invoker.java:816)\r\n\tat org.testng.internal.TestMethodWithDataProviderMethodWorker.call(TestMethodWithDataProviderMethodWorker.java:75)\r\n\tat org.testng.internal.TestMethodWithDataProviderMethodWorker.call(TestMethodWithDataProviderMethodWorker.java:14)\r\n\tat java.util.concurrent.FutureTask.run(Unknown Source)\r\n\tat java.util.concurrent.Executors$RunnableAdapter.call(Unknown Source)\r\n\tat java.util.concurrent.FutureTask.run(Unknown Source)\r\n\tat java.util.concurrent.ThreadPoolExecutor.runWorker(Unknown Source)\r\n\tat java.util.concurrent.ThreadPoolExecutor$Worker.run(Unknown Source)\r\n\tat java.lang.Thread.run(Unknown Source)\r\n",
  "status": "failed"
});
});