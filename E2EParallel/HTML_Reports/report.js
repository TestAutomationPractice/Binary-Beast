$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/java/features/login.feature");
formatter.feature({
  "line": 2,
  "name": "Login to Mercury demo tours site",
  "description": "1. User should Not be able to login to the application with invalid credentials\n2. User should be able to login to the application with valid credentials",
  "id": "login-to-mercury-demo-tours-site",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@login"
    }
  ]
});
formatter.scenarioOutline({
  "line": 6,
  "name": "Login with Invalid credentials",
  "descripti{
  "line": 7,
  "name": "Search a Round trip flight",
  "description": "",
  "id": "login-to-mercury-demo-tours-site-and-search-for-a-flight;searc);
formatter.step({
  "line": 7,
  "name": "The user opens mercury tour demo site",
  "keyword": "Given "{
  
formatter.step({
  "line": 8,
  "name": "The user enters \u0027\u003cuser_name\u003e\u0027 and \u0027\u003cpassword\u003e\u0027 and click on login button",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "The home page should not be displayed",
  "keyword": "Then "
}{
  "line": 10,
  "nam{
  "line": 11,
  "name": "",
  "description": "",
  "id": "login-to-mercury-demo-tours-site;login-with-invalid-credentials;",
  "rows": [
    {
      "cells": [
        "user_name",
        "password"
      ],
      "line": 12,
      "id": "login-to-mercury-demo-tours-site;login-with-invalid-credentials;;1"
    },
    {
      "cells": [
        "test",
        "test"
      ],
      "line": 13,
      "id": "login-to-mercury-demo-tours-site;login-with-invalid-credentials;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 3677534861,
  "status": "passed"
});
formatter.scenario({
  "line": 13,
  "name": "Login with Invalid credentials",
  "description": "",
  "id": "login-to-mercury-demo-tours-site;login-with-invalid-credentials;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@login"
    }
  ]
});
formatter.step({
  "line": 7,
  "name": "The user opens mercury tour demo site",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "The user enters \u0027test\u0027 and \u0027test\u0027 and click on login button",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "The home page should not be displayed",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginStepdefinition.the_browser_is_open_with_URL()"
});
formatter.result({
  "duration": 4856504890,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "test",
      "offset": 17
    },
    {
      "val": "test",
      "offset": 28
    }
  ],
  "location": "LoginStepdefinition.the_user_enters_valid_user_name_and_password_and_click_on_login_button(String,String)"
});
formatter.result({
  "duration": 3206620910,
  "status": "passed"
});
formatter.match({
  "location": "LoginStepdefinition.the_home_page_shouldnot_be_displayed()"
});
formatter.result({
  "duration": 480425324,
  "status": "passed"
});
formatter.after({
  "duration": 2420751143,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 15,
  "name": "Login with Valid credentials",
  "description": "",
  "id": "login-to-mercury-demo-tours-site;login-with-valid-credentials",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 16,
  "name": "The user opens mercury tour demo site",
  "keyword": "Given "
});
formatter.step({
  "line": 17,
  "name": "The user enters \u0027\u003cuser_name\u003e\u0027 and \u0027\u003cpassword\u003e\u0027 and click on login button",
  "keyword": "When "
});
formatter.step({
  "line": 18,
  "name": "The home page should be displayed",
  "keyword": "Then "
});
formatter.examples({
  "line": 20,
  "name": "",
  "description": "",
  "id": "login-to-mercury-demo-tours-site;login-with-valid-credentials;",
  "rows": [
    {
      "cells": [
        "user_name",
        "password"
      ],
      "line": 21,
      "id": "login-to-mercury-demo-tours-site;login-with-valid-credentials;;1"
    },
    {
      "cells": [
        "mercury",
        "mercury"
      ],
      "line": 22,
      "id": "login-to-mercury-demo-tours-site;login-with-valid-credentials;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 2287983951,
  "status": "passed"
});
formatter.scenario({
  "line": 22,
  "name": "Login with Valid credentials",
  "description": "",
  "id": "login-to-mercury-demo-tours-site;login-with-valid-credentials;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@login"
    }
  ]
});
formatter.step({
  "line": 16,
  "name": "The user opens mercury tour demo site",
  "keyword": "Given "
});
formatter.step({
  "line": 17,
  "name": "The user enters \u0027mercury\u0027 and \u0027mercury\u0027 and click on login button",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "When "
});
formatter.step({
  "line": 18,
  "name": "The home page should be displayed",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginStepdefinition.the_browser_is_open_with_URL()"
});
formatter.result({
  "duration": 2347481995,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "mercury",
      "offset": 17
    },
    {
      "val": "mercury",
      "offset": 31
    }
  ],
  "location": "LoginStepdefinition.the_user_enters_valid_user_name_and_password_and_click_on_login_button(String,String)"
});
formatter.result({
  "duration": 6222389323,
  "status": "passed"
});
formatter.match({
  "location": "LoginStepdefinition.the_home_page_should_be_displayed()"
});
formatter.result({
  "duration": 6669593766,
  "status": "passed"
});
formatter.after({
  "duration": 2137174981,
  "status": "passed"
});
}); "duration": 2181139096,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 29,
  "name": "Search a One way flight",
  "description": "",
  "id": "login-to-mercury-demo-tours-site-and-search-for-a-flight;search-a-one-way-flight",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 30,
  "name": "The user opens mercury tour demo site",
  "keyword": "Given "
});
formatter.step({
  "line": 31,
  "name": "The user enters \u0027\u003cuser_name\u003e\u0027 and \u0027\u003cpassword\u003e\u0027 and clicks on login button",
  "keyword": "When "
});
formatter.step({
  "line": 32,
  "name": "User enters Flight details and clicks Continue",
  "rows": [
    {
      "cells": [
        "Fields",
        "Values"
      ],
      "line": 33
    },
    {
      "cells": [
        "TripType",
        "oneway"
      ],
      "line": 34
    },
    {
      "cells": [
        "Passanger",
        "1"
      ],
      "line": 35
    },
    {
      "cells": [
        "DepartingFrom",
        "London"
      ],
      "line": 36
    },
    {
      "cells": [
        "MonthOn",
        "March"
      ],
      "line": 37
    },
    {
      "cells": [
        "FromDay",
        "20"
      ],
      "line": 38
    },
    {
      "cells": [
        "ArrivingIn",
        "Paris"
      ],
      "line": 39
    },
    {
      "cells": [
        "ReturningMonth",
        "NA"
      ],
      "line": 40
    },
    {
      "cells": [
        "ReturningDay",
        "NA"
      ],
      "line": 41
    },
    {
      "cells": [
        "ServClass",
        "Business"
      ],
      "line": 42
    },
    {
      "cells": [
        "Airline",
        "No Preference"
      ],
      "line": 43
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 44,
  "name": "User is Navigated to Select Flight page",
  "keyword": "Then "
});
formatter.examples({
  "line": 46,
  "name": "",
  "description": "",
  "id": "login-to-mercury-demo-tours-site-and-search-for-a-flight;search-a-one-way-flight;",
  "rows": [
    {
      "cells": [
        "user_name",
        "password"
      ],
      "line": 47,
      "id": "login-to-mercury-demo-tours-site-and-search-for-a-flight;search-a-one-way-flight;;1"
    },
    {
      "cells": [
        "mercury",
        "mercury"
      ],
      "line": 48,
      "id": "login-to-mercury-demo-tours-site-and-search-for-a-flight;search-a-one-way-flight;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 2210083834,
  "status": "passed"
});
formatter.scenario({
  "line": 48,
  "name": "Search a One way flight",
  "description": "",
  "id": "login-to-mercury-demo-tours-site-and-search-for-a-flight;search-a-one-way-flight;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@Smoke1"
    }
  ]
});
formatter.step({
  "line": 30,
  "name": "The user opens mercury tour demo site",
  "keyword": "Given "
});
formatter.step({
  "line": 31,
  "name": "The user enters \u0027mercury\u0027 and \u0027mercury\u0027 and clicks on login button",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "When "
});
formatter.step({
  "line": 32,
  "name": "User enters Flight details and clicks Continue",
  "rows": [
    {
      "cells": [
        "Fields",
        "Values"
      ],
      "line": 33
    },
    {
      "cells": [
        "TripType",
        "oneway"
      ],
      "line": 34
    },
    {
      "cells": [
        "Passanger",
        "1"
      ],
      "line": 35
    },
    {
      "cells": [
        "DepartingFrom",
        "London"
      ],
      "line": 36
    },
    {
      "cells": [
        "MonthOn",
        "March"
      ],
      "line": 37
    },
    {
      "cells": [
        "FromDay",
        "20"
      ],
      "line": 38
    },
    {
      "cells": [
        "ArrivingIn",
        "Paris"
      ],
      "line": 39
    },
    {
      "cells": [
        "ReturningMonth",
        "NA"
      ],
      "line": 40
    },
    {
      "cells": [
        "ReturningDay",
        "NA"
      ],
      "line": 41
    },
    {
      "cells": [
        "ServClass",
        "Business"
      ],
      "line": 42
    },
    {
      "cells": [
        "Airline",
        "No Preference"
      ],
      "line": 43
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 44,
  "name": "User is Navigated to Select Flight page",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginStepdefinition.the_browser_is_open_with_URL()"
});
formatter.result({
  "duration": 2516063980,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "mercury",
      "offset": 17
    },
    {
      "val": "mercury",
      "offset": 31
    }
  ],
  "location": "FlightFinderStepDefinition.the_user_enters_valid_user_name_and_password_and_click_on_login_button(String,String)"
});
formatter.result({
  "duration": 6529317250,
  "status": "passed"
});
formatter.match({
  "location": "FlightFinderStepDefinition.user_enters_Flight_details_and_clicks_Continue(String,String\u003e)"
});
formatter.result({
  "duration": 2864710737,
  "status": "passed"
});
formatter.match({
  "location": "FlightFinderStepDefinition.user_is_Navigated_to_Select_Flight_page()"
});
formatter.result({
  "duration": 34956354,
  "status": "passed"
});
formatter.after({
  "duration": 149043958,
  "status": "passed"
});
});