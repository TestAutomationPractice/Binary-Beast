$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/java/features/addMovie.feature");
formatter.feature({
  "line": 2,
  "name": "Add Movie when logged in with Admin",
  "description": "1. User should be able to Add movie",
  "id": "add-movie-when-logged-in-with-admin",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@AddMovie"
    }
  ]
});
formatter.scenarioOutline({
  "line": 5,
  "name": "Add a Movie and Verify parallelly",
  "description": "",
  "id": "add-movie-when-logged-in-with-admin;add-a-movie-and-verify-parallelly",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 6,
  "name": "The user opens Movie Rental site",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "The user enters user details and click on login button",
  "rows": [
    {
      "cells": [
        "user",
        "user"
      ],
      "line": 8
    },
    {
      "cells": [
        "password",
        "password"
      ],
      "line": 9
    }
  ],
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "The admin open Movie Rental site Parallely",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "Admin user login",
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "Admin adds movie with \"\u003cTitle\u003e\", \"\u003cDirector\u003e\",\"\u003cDescription\u003e\",\"\u003cCategories\u003e\",\"\u003cImageURL\u003e\",\"\u003cRating\u003e\"",
  "keyword": "When "
});
formatter.step({
  "line": 13,
  "name": "verify Movie with \"\u003cTitle\u003e\" is added successfully",
  "keyword": "Then "
});
formatter.examples({
  "line": 15,
  "name": "",
  "description": "",
  "id": "add-movie-when-logged-in-with-admin;add-a-movie-and-verify-parallelly;",
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
      "line": 16,
      "id": "add-movie-when-logged-in-with-admin;add-a-movie-and-verify-parallelly;;1"
    },
    {
      "cells": [
        "Chhichhore2",
        "Nitesh Talwar",
        "Great Comedy Movie",
        "Comedy",
        "https://akm-img-a-in.tosshub.com/indiatoday/images/story/201909/chhichhore-770x433.jpeg?FwxPwJC2sqo.UXyQWZ8DZGI9iaj1GjUP",
        "4"
      ],
      "line": 17,
      "id": "add-movie-when-logged-in-with-admin;add-a-movie-and-verify-parallelly;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 2985707779,
  "status": "passed"
});
formatter.scenario({
  "line": 17,
  "name": "Add a Movie and Verify parallelly",
  "description": "",
  "id": "add-movie-when-logged-in-with-admin;add-a-movie-and-verify-parallelly;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@AddMovie"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "The user opens Movie Rental site",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "The user enters user details and click on login button",
  "rows": [
    {
      "cells": [
        "user",
        "user"
      ],
      "line": 8
    },
    {
      "cells": [
        "password",
        "password"
      ],
      "line": 9
    }
  ],
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "The admin open Movie Rental site Parallely",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "Admin user login",
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "Admin adds movie with \"Chhichhore2\", \"Nitesh Talwar\",\"Great Comedy Movie\",\"Comedy\",\"https://akm-img-a-in.tosshub.com/indiatoday/images/story/201909/chhichhore-770x433.jpeg?FwxPwJC2sqo.UXyQWZ8DZGI9iaj1GjUP\",\"4\"",
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
  "line": 13,
  "name": "verify Movie with \"Chhichhore2\" is added successfully",
  "matchedColumns": [
    0
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "homePageStepDefinition.the_user_opens_Movie_Rental_site()"
});
formatter.result({
  "duration": 3294568467,
  "status": "passed"
});
formatter.match({
  "location": "homePageStepDefinition.the_user_enters_user_details_and_click_on_login_button(String,String\u003e)"
});
formatter.result({
  "duration": 2396279106,
  "status": "passed"
});
formatter.match({
  "location": "addMovieStepDefinition.the_admin_opens_Movie_Rental_site()"
});
formatter.result({
  "duration": 5825071631,
  "status": "passed"
});
formatter.match({
  "location": "addMovieStepDefinition.admin_user_logins()"
});
formatter.result({
  "duration": 2392249482,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Chhichhore2",
      "offset": 23
    },
    {
      "val": "Nitesh Talwar",
      "offset": 38
    },
    {
      "val": "Great Comedy Movie",
      "offset": 54
    },
    {
      "val": "Comedy",
      "offset": 75
    },
    {
      "val": "https://akm-img-a-in.tosshub.com/indiatoday/images/story/201909/chhichhore-770x433.jpeg?FwxPwJC2sqo.UXyQWZ8DZGI9iaj1GjUP",
      "offset": 84
    },
    {
      "val": "4",
      "offset": 207
    }
  ],
  "location": "addMovieStepDefinition.user_adds_movie_with(String,String,String,String,String,String)"
});
formatter.result({
  "duration": 2747440641,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Chhichhore2",
      "offset": 19
    }
  ],
  "location": "homePageStepDefinition.verify_Movie_with_is_added_successfully(String)"
});
formatter.result({
  "duration": 1163676418,
  "status": "passed"
});
formatter.after({
  "duration": 282498556,
  "status": "passed"
});
});